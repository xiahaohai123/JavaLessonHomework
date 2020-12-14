package top.summersea.util;

import java.io.IOException;
import java.lang.reflect.Field;
import java.sql.*;
import java.util.*;

/**
 * @PackageName: PACKAGE_NAME
 * @ClassName: JDBCUtil
 * @Description: description
 * @Version: V1.0
 * @Author: 夏浩海
 * @Date: 2020/11/26 15:38
 */
public class JDBCUtil {
    private static JDBCUtil INSTANCE = null;


    private Properties properties;
    private Connection connection;

    private JDBCUtil() {
        properties = new Properties();
        try {
            properties.load(Thread.currentThread().getContextClassLoader().getResourceAsStream("db.properties"));
            String driver = properties.getProperty("driver-class-name");
            // 是否会有重复加载的问题？
            // 双亲委派机制的作用：防止类被重复加载
            Class.forName(driver);

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static JDBCUtil getInstance() {
        if (INSTANCE == null) {
            synchronized (JDBCUtil.class) {
                if (INSTANCE == null) {
                    INSTANCE = new JDBCUtil();
                }
            }
        }

        return INSTANCE;
    }

    /**
     * 执行非查询语句
     * DCL
     *
     * @param sql
     * @return
     */
    public int executeUpdate(String sql, Object... args) {
        Connection connection = getConnection();
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement(sql);
            for (int i = 1; i <= args.length; i++) {
                preparedStatement.setObject(i, args[i - 1]);
            }
            return preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            return 0;
        }
    }

    /**
     * 执行查询语句
     * DQL
     *
     * @param sql
     * @return
     */
    public ResultSet executeQuery(String sql, Object... args) {
        Connection connection = getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            for (int i = 1; i <= args.length; i++) {
                preparedStatement.setObject(i, args[i - 1]);
            }
            return preparedStatement.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 执行DQL
     * 封装对象
     *
     * @param sql
     * @param tClass
     * @param args
     * @param <T>
     * @return
     */
    public <T> T executeQuery(String sql, Class<T> tClass, Object... args) {
        ResultSet resultSet = executeQuery(sql, args);
        // 默认构造器
        try {
            T t = null;
            // 获取查询结果元数据（字段名列表）
            ResultSetMetaData metaData = resultSet.getMetaData();
            int metaDataLen = metaData.getColumnCount();
            while (resultSet.next()) {
                t = loadField(tClass, resultSet, metaData, metaDataLen);
            }
            return t;
        } catch (InstantiationException | IllegalAccessException | SQLException | NoSuchFieldException e) {
            e.printStackTrace();
        } finally {
            try {
                resultSet.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    public <T> List<T> executeQueryForList(String sql, Class<T> cls, Object... args) {
        ResultSet resultSet = executeQuery(sql, args);
        List<T> resList = new ArrayList<>();
        try {
            // 获取查询结果元数据（字段名列表）
            ResultSetMetaData metaData = resultSet.getMetaData();
            int metaDataLen = metaData.getColumnCount();
            while (resultSet.next()) {
                T t = loadField(cls, resultSet, metaData, metaDataLen);
                resList.add(t);
            }
        } catch (SQLException | IllegalAccessException | InstantiationException | NoSuchFieldException e) {
            e.printStackTrace();
        } finally {
            try {
                resultSet.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return resList;
    }

    private <T> T loadField(Class<T> cls, ResultSet resultSet, ResultSetMetaData metaData, int metaDataLen) throws IllegalAccessException, InstantiationException, SQLException, NoSuchFieldException {
        T t = cls.newInstance();
        for (int i = 1; i <= metaDataLen; i++) {
            // 数据库从1开始
            String columnName = metaData.getColumnName(i);
            Object columnValue = resultSet.getObject(columnName);
            // 反射加载数据
            Field field = cls.getDeclaredField(NameMapperUtil.underlineToSmallCamel(columnName));
            field.setAccessible(true); // 设置字段访问权限
            field.set(t, columnValue);
        }
        return t;
    }

    public Integer executeQueryForCount(String sql, Object... args) {
        ResultSet resultSet = executeQuery(sql, args);
        try {
            if (resultSet.next()) {
                return resultSet.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    /**
     * 组合查询
     * <p>
     * 尝试
     * 直接把数据封装在map返回
     * <p>
     * 问题拆分：
     * 1、执行sql语句获取结果集
     * 2、获取结果集元数据
     * 3、根据元数据获取对应驼峰命名集合
     * 3、遍历结果集
     * <p>3.1、根据元数据将数据加入map key是驼峰命名
     * <p>3.2、将map加入结果list
     *
     * @param sql
     * @param args
     * @return
     */
    public List<Object> executeAssociationQueryForList(String sql, Object... args) {
        ResultSet resultSet = executeQuery(sql, args);
        List<Object> resList = new ArrayList<>();
        try {
            ResultSetMetaData metaData = resultSet.getMetaData();
            int len = metaData.getColumnCount();
            // 获取驼峰映射表
            Map<String, String> metaColumnNameToSmallCamelMap = getSmallCamelListByMetaData(metaData);

            while (resultSet.next()) {
                Map<String, Object> valueMap = new HashMap<>();
                for (int i = 1; i <= len; i++) {
                    String columnName = metaData.getColumnName(i);
                    valueMap.put(metaColumnNameToSmallCamelMap.get(columnName), resultSet.getObject(columnName));
                }
                resList.add(valueMap);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                resultSet.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return resList;
    }

    public Map<String, Object> executeAssociationQueryForMap(String sql, Object... args) {
        ResultSet resultSet = executeQuery(sql, args);
        Map<String, Object> valueMap = new HashMap<>();
        try {
            ResultSetMetaData metaData = resultSet.getMetaData();
            int len = metaData.getColumnCount();
            // 获取驼峰映射表
            Map<String, String> metaColumnNameToSmallCamelMap = getSmallCamelListByMetaData(metaData);

            if (resultSet.next()) {
                for (int i = 1; i <= len; i++) {
                    String columnName = metaData.getColumnName(i);
                    valueMap.put(metaColumnNameToSmallCamelMap.get(columnName), resultSet.getObject(columnName));
                }
                return valueMap;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                resultSet.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return valueMap;
    }

    private Map<String, String> getSmallCamelListByMetaData(ResultSetMetaData metaData) throws SQLException {
        Map<String, String> camelMap = new HashMap<>();

        int columnCount = metaData.getColumnCount();
        for (int i = 1; i <= columnCount; i++) {
            String columnName = metaData.getColumnName(i);
            camelMap.put(columnName, NameMapperUtil.underlineToSmallCamel(columnName));
        }
        return camelMap;
    }

    /**
     * 双检锁
     *
     * @return
     */
    public Connection getConnection() {
        if (connection == null) {
            synchronized (this) {
                if (connection == null) {
                    String url = properties.getProperty("url");
                    String username = properties.getProperty("username");
                    String password = properties.getProperty("password");
                    try {
                        connection = DriverManager.getConnection(url, username, password);
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        return connection;
    }

    // 在被销毁前关闭连接
    @Override
    protected void finalize() throws Throwable {
        if (connection != null) {
            connection.close();
        }
        super.finalize();
    }
}
