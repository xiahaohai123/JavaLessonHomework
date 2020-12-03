package dao;

import java.sql.*;
import java.util.Properties;

/**
 * @PackageName: dao
 * @ClassName: JDBCUtil
 * @Description: description
 * @Version: V1.0
 * @Author: 夏浩海
 * @Date: 2020/11/20 13:59
 */
public class JDBCUtil {
    private static ClassLoader driverClassLoader;
    private Properties properties;

    public JDBCUtil(Properties properties) {
        this.properties = properties;
        String driver = properties.getProperty("driver-class-name");
        try {
            loadDriver(driver);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private static void loadDriver(String location) throws ClassNotFoundException {
        Class.forName(location);
        driverClassLoader = DriverManager.class.getClassLoader();
    }

    public Connection getConnection(Properties properties) throws SQLException, ClassNotFoundException {
//        if (driverClassLoader == null) {
//            String driver = properties.getProperty("driver-class-name");
//            loadDriver(driver);
//        }

        String url = properties.getProperty("url");
        String username = properties.getProperty("username");
        String password = properties.getProperty("password");
        return DriverManager.getConnection(url, username, password);
    }

    public Connection getConnection() throws SQLException, ClassNotFoundException {
        return getConnection(properties);
    }

    public PreparedStatement prepareStatement(String sql) {
        try {
            Connection connection = getConnection();
            return connection.prepareStatement(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }


    public void close(Connection connection, Statement statement) {
        try {
            connection.close();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
