package dao;

import entity.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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

    @Override
    public Integer selectUsername(String username) {
        String sql = "SELECT COUNT(1) FROM user WHERE username = ?";
        ResultSet resultSet = jdbcUtil.executeQuery(sql, username);
        try {
            if (resultSet.next()) {
                return resultSet.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();

        }

        return 0;
    }

    @Override
    public List<User> selectUserList() {
        String sql = "SELECT id, username, password FROM user;";
        ResultSet resultSet = jdbcUtil.executeQuery(sql);
        List<User> resList = new ArrayList<>();
        try {
            while (resultSet.next()) {
                User user = new User();
                user.setId(resultSet.getInt("id"));
                user.setUsername(resultSet.getString("username"));
                user.setPassword(resultSet.getString("password"));
                resList.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return resList;
    }

    /**
     * 更新用户信息
     *
     * @param user
     * @return
     */
    @Override
    public Integer updateUser(User user) {
        String sql = "UPDATE user SET username = ?, password = ? WHERE id = ?";
        Connection connection = jdbcUtil.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, user.getUsername());
            preparedStatement.setString(2, user.getPassword());
            preparedStatement.setInt(3, user.getId());
            return preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    /**
     * 删除用户数据
     *
     * @param id
     * @return
     */
    @Override
    public Integer deleteUser(int id) {
        String sql = "DELETE FROM user WHERE id = ?";
        Connection connection = jdbcUtil.getConnection();

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            return preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }
}
