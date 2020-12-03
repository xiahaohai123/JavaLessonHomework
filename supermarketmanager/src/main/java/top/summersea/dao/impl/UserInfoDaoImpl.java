package top.summersea.dao.impl;

import top.summersea.dao.UserInfoDao;
import top.summersea.entity.UserInfo;
import top.summersea.util.JDBCUtil;

import java.util.List;

/**
 * @PackageName: dao
 * @ClassName: UserInfoDaoImpl
 * @Description: description
 * @Version: V1.0
 * @Author: 夏浩海
 * @Date: 2020/12/2 16:46
 */
public class UserInfoDaoImpl implements UserInfoDao {
    private JDBCUtil jdbcUtil;

    public UserInfoDaoImpl() {
        jdbcUtil = JDBCUtil.getInstance();
    }

    @Override
    public UserInfo selectUserCodeByUsernameAndPassword(UserInfo userInfo) {
        String sql = "SELECT user_id FROM userinfo WHERE username = ? AND password = ?";
//        ResultSet resultSet = jdbcUtil.executeQuery(sql, userInfo.getUsername(), userInfo.getPassword());
//        try {
//            while (resultSet.next()) {
//                userInfo.setUserId(resultSet.getString("user_id"));
//                return userInfo;
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
        return jdbcUtil.executeQuery(sql, userInfo.getClass(), userInfo.getUsername(), userInfo.getPassword());
    }

    @Override
    public Integer updatePasswordByUserCode(UserInfo userInfo, String newPassword) {
        String sql = "UPDATE userinfo SET password = ? WHERE user_id=? AND username = ? AND password = ?";

        return jdbcUtil.executeUpdate(sql, newPassword, userInfo.getUserId(), userInfo.getUsername(), userInfo.getPassword());
    }

    /**
     * 获取用户列表
     *
     * @return
     */
    @Override
    public List<Object> selectAllUserInfoWithUserType(String... username) {
        String sql;
        if (username.length == 0) {
            sql = "SELECT user_id, " +
                    "username, " +
                    "sex, " +
                    "TIMESTAMPDIFF(YEAR,born_date,CURDATE()) AS age, " +
                    "user_tel, " +
                    "user_address, " +
                    "type_name " +
                    "FROM userinfo LEFT JOIN usertype ON userinfo.type_id = usertype.type_id;";
            return jdbcUtil.executeAssociationQueryForList(sql);
        } else {
            sql = "SELECT user_id, " +
                    "username, " +
                    "sex, " +
                    "TIMESTAMPDIFF(YEAR,born_date,CURDATE()) AS age, " +
                    "user_tel, " +
                    "user_address, " +
                    "type_name " +
                    "FROM userinfo LEFT JOIN usertype ON userinfo.type_id = usertype.type_id " +
                    "WHERE userinfo.username LIKE ?";
            // 只取第一个防止出错
            return jdbcUtil.executeAssociationQueryForList(sql, username[0]);
        }
    }
}
