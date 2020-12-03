package dao;

import entity.UserInfo;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @PackageName: dao
 * @ClassName: UserInfoDaoImpl
 * @Description: description
 * @Version: V1.0
 * @Author: 夏浩海
 * @Date: 2020/11/28 9:50
 */
public class UserInfoDaoImpl implements UserInfoDao {
    // jdbc封装
    private JDBCUtil jdbcUtil;

    public UserInfoDaoImpl() {
        jdbcUtil = JDBCUtil.getInstance();
    }

    @Override
    public Integer insert(UserInfo userInfo) {
        String sql = "INSERT INTO userinfo (USERNAME, PASSWORD, EMAIL) VALUES (?, ?, ?)";
        return jdbcUtil.executeUpdate(sql, userInfo.getUsername(), userInfo.getPassword(), userInfo.getEmail());
    }

    @Override
    public Integer selectCount(UserInfo userInfo) {
        String sql = "SELECT COUNT(1) FROM userinfo WHERE USERNAME = ? AND PASSWORD = ?";
        ResultSet resultSet = jdbcUtil.executeQuery(sql, userInfo.getUsername(), userInfo.getPassword());
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
