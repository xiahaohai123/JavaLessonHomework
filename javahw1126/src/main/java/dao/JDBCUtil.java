package dao;

import java.io.IOException;
import java.sql.*;
import java.util.Properties;

/**
 * @PackageName: PACKAGE_NAME
 * @ClassName: dao.JDBCUtil
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

        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
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
    public int executeUpdate(String sql, String... args) {
        Connection connection = getConnection();
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement(sql);
            for (int i = 1; i <= args.length; i++) {
                preparedStatement.setString(i, args[i - 1]);
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
    public ResultSet executeQuery(String sql, String... args) {
        Connection connection = getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            for (int i = 1; i <= args.length; i++) {
                preparedStatement.setString(i, args[i-1]);
            }
            return preparedStatement.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 双检锁
     *
     * @return
     */
    private Connection getConnection() {
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
        System.out.println(connection);
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
