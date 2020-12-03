package dao;

import entity.UserComplete;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @PackageName: dao
 * @ClassName: UserCompleteDaoImpl
 * @Description: description
 * @Version: V1.0
 * @Author: 夏浩海
 * @Date: 2020/12/1 15:38
 */
public class UserCompleteDaoImpl implements UserCompleteDao {
    private JDBCUtil jdbcUtil;

    public UserCompleteDaoImpl() {
        jdbcUtil = JDBCUtil.getInstance();
    }

    @Override
    public Integer selectEmailCount(String email) {

        String sql = "SELECT COUNT(1) FROM usercomplete WHERE email = ?";
        ResultSet resultSet = jdbcUtil.executeQuery(sql, email);
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
    public Integer selectCount(UserComplete userComplete) {
        String sql = "SELECT COUNT(1) FROM usercomplete WHERE username = ? AND password = ?";
        ResultSet resultSet = jdbcUtil.executeQuery(sql, userComplete.getUsername(), userComplete.getPassword());
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
