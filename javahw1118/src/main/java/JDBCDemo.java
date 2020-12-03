import java.io.FileInputStream;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;

/**
 * @PackageName: PACKAGE_NAME
 * @ClassName: JDBCDemo
 * @Description: description
 * @Version: V1.0
 * @Author: 夏浩海
 * @Date: 2020/11/18 18:50
 */
public class JDBCDemo {
    public static void main(String[] args) throws IOException, ClassNotFoundException, SQLException, InterruptedException {
        // 获取配置文件
        Properties properties = new Properties();
        properties.load(new FileInputStream("javahw1118/src/main/resources/application.properties"));
        String driver = properties.getProperty("driver-class-name");
        String url = properties.getProperty("url");
        String username = properties.getProperty("username");
        String password = properties.getProperty("password");

        // 加载驱动
        Class.forName(driver);

        // 获取连接
        Connection connection = DriverManager.getConnection(url, username, password);

        // SQL
        String selectSql = "SELECT Id, StudentNo, SubJectId, StudentResult, ExamDate FROM result;";
        // 预编译
        PreparedStatement preparedStatement = connection.prepareStatement(selectSql);
        ResultSet resultSet = preparedStatement.executeQuery();
        System.out.println("Id\t\tStudentNo\t\tSubJectId\t\tStudentResult\t\tExamDate");
        while (resultSet.next()) {
            System.out.println(resultSet.getInt("Id") + "\t\t" +
                    resultSet.getInt("StudentNo") + "\t\t\t" +
                    resultSet.getInt("SubJectId") + "\t\t\t\t" +
                    resultSet.getInt("StudentResult") + "\t\t\t\t\t" +
                    resultSet.getDate("ExamDate")
            );
        }
        resultSet.close();
        preparedStatement.close();

        String updateSql = "UPDATE result SET StudentResult = 650 WHERE StudentNo = ?;";
        String deleteSql = "DELETE FROM result WHERE StudentNo = ?;";
        String insertSql = "INSERT INTO result (StudentNo, SubJectId, StudentResult, ExamDate) VALUES (?, 3, 78, '2014-05-01 00:00:00');";

        // 更新
        preparedStatement = connection.prepareStatement(updateSql);
        preparedStatement.setInt(1, 100012);
        System.out.println(preparedStatement.executeUpdate() > 0 ? "更新成功" : "更新失败");
        preparedStatement.close();
        Thread.sleep(5000);

        // 删除
        preparedStatement = connection.prepareStatement(deleteSql);
        preparedStatement.setInt(1,100012);
        System.out.println(preparedStatement.executeUpdate() > 0 ? "删除成功" : "删除失败");
        preparedStatement.close();
        Thread.sleep(5000);

        // 删除
        preparedStatement = connection.prepareStatement(insertSql);
        preparedStatement.setInt(1,100012);
        System.out.println(preparedStatement.executeUpdate() > 0 ? "插入成功" : "插入失败");
        preparedStatement.close();

        connection.close();
    }
}
