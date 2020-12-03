package dao;

import entity.User;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @PackageName: PACKAGE_NAME
 * @ClassName: dao.HomeworkDao
 * @Description: description
 * @Version: V1.0
 * @Author: 夏浩海
 * @Date: 2020/11/26 15:26
 */
public class HomeworkDao implements IHomeworkDao {
    private JDBCUtil jdbcUtil;

    public HomeworkDao() {
        jdbcUtil = JDBCUtil.getInstance();
    }

    public void setJdbcUtil(JDBCUtil jdbcUtil) {
        this.jdbcUtil = jdbcUtil;
    }

    @Override
    public Integer insert(User user) {
        String sql = "INSERT INTO user (username, password) VALUES (?, ?)";
        return jdbcUtil.executeUpdate(sql, user.getUsername(), user.getPassword());
    }

    /**
     * 登录
     *
     * @param user
     * @return
     */
    @Override
    public Integer selectCount(User user) {
        String sql = "SELECT COUNT(1) FROM user WHERE username = ? AND password = ?";
        ResultSet resultSet = jdbcUtil.executeQuery(sql, user.getUsername(), user.getPassword());
        try {
            if (resultSet.next()) {
                return resultSet.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();

        }

        return 0;
    }

}
