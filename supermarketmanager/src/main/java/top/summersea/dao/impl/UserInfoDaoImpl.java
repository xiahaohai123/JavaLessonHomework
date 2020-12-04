package top.summersea.dao.impl;

import top.summersea.dao.UserInfoDao;
import top.summersea.entity.UserInfo;
import top.summersea.util.JDBCUtil;

import java.util.List;
import java.util.Map;

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
                    "born_date, " +
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
                    "born_date, " +
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

    @Override
    public Integer selectCountByUserId(String userId) {
        String sql = "SELECT COUNT(1) FROM userinfo WHERE user_id = ?";
        return jdbcUtil.executeQueryForCount(sql, userId);
    }

    @Override
    public Integer insertUserInfo(UserInfo userInfo, String typeName) {
        String sql = "INSERT INTO userinfo VALUES" +
                "(?,?,?,?,?,?,?," +
                "(SELECT ut.type_id FROM usertype ut WHERE ut.type_name=?))";
        Object[] objects = {userInfo.getUserId(), userInfo.getUsername(), userInfo.getPassword(),
                userInfo.getSex(), userInfo.getBornDate(), userInfo.getUserTel(), userInfo.getUserAddress(),
                typeName};
        return jdbcUtil.executeUpdate(sql, objects);
    }

    @Override
    public Map<String, Object> selectUserInfoByUserId(String userId) {
        String sql = "SELECT user_id, " +
                "username, " +
                "sex, " +
                "born_date, " +
                "user_tel, " +
                "user_address, " +
                "type_name " +
                "FROM userinfo ui LEFT JOIN usertype ut ON ui.type_id = ut.type_id " +
                "WHERE user_id = ?";
        return jdbcUtil.executeAssociationQueryForMap(sql, userId);
    }

    @Override
    public Integer updateUserInfo(UserInfo userInfo, String typeName) {
        String sql = "UPDATE userinfo SET username = ?, " +
                "sex = ?, " +
                "born_date = ?," +
                "user_tel = ?, " +
                "user_address = ?," +
                "type_id = " +
                "(SELECT ut.type_id FROM usertype ut WHERE type_name = ?) " +
                "WHERE user_id = ?;";
        Object[] objects = {userInfo.getUsername(), userInfo.getSex(), userInfo.getBornDate(),
                userInfo.getUserTel(), userInfo.getUserAddress(), typeName, userInfo.getUserId()};
        return jdbcUtil.executeUpdate(sql, objects);
    }

    @Override
    public Integer deleteUserInfoByUserId(String userId) {
        String sql = "DELETE FROM userinfo WHERE user_id = ?";

        return jdbcUtil.executeUpdate(sql, userId);
    }
}
