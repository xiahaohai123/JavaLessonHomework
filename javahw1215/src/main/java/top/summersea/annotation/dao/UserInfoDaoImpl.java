package top.summersea.annotation.dao;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import top.summersea.entity.UserInfo;

import javax.annotation.Resource;
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
@Repository
public class UserInfoDaoImpl implements UserInfoDao {
    @Resource
    private JdbcTemplate jdbcTemplate;

    /**
     * 获取用户列表
     *
     * @return
     */
    @Override
    public List<Map<String, Object>> selectAllUserInfoWithUserType(String... username) {
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
            return jdbcTemplate.queryForList(sql);
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
            return jdbcTemplate.queryForList(sql, username[0]);
        }
    }


    @Override
    public UserInfo selectUserInfoById(String userId) {
        String sql = "SELECT * FROM userinfo WHERE user_id = ?";
        return jdbcTemplate.queryForObject(sql, new Object[]{userId}, (rs, rowNum) ->
                new UserInfo(
                        rs.getString(1), rs.getString(2),
                        rs.getString(3), rs.getBoolean(4),
                        rs.getDate(5), rs.getString(6),
                        rs.getString(7), rs.getString(8)
                ));
    }

    @Override
    public UserInfo selectUserInfoByUsername(String username) {
        String sql = "SELECT * FROM userinfo WHERE username = ?";
        return jdbcTemplate.queryForObject(sql, UserInfo.class, username);
    }

    @Override
    public int insertUserInfo(UserInfo userInfo) {
        String sql = "INSERT INTO userinfo VALUES" +
                "(?,?,?,?,?,?,?,?" +
                ")";
        Object[] objects = {userInfo.getUserId(), userInfo.getUsername(), userInfo.getPassword(),
                userInfo.getSex(), userInfo.getBornDate(), userInfo.getUserTel(), userInfo.getUserAddress(),
                userInfo.getTypeId()};
        return jdbcTemplate.update(sql, objects);
    }

    @Override
    public int updateUserInfo(UserInfo userInfo) {
        String sql = "UPDATE `userinfo` SET `username` = ?, `password` = ?, `sex` = ?, " +
                "`born_date` = ?, `user_tel` = ?, `user_address` = ?, " +
                "`type_id` = ? WHERE `user_id` = ?;";
        Object[] objects = {userInfo.getUsername(), userInfo.getPassword(), userInfo.getSex(),
                userInfo.getBornDate(),
                userInfo.getUserTel(), userInfo.getUserAddress(), userInfo.getTypeId(),
                userInfo.getUserId()};
        return jdbcTemplate.update(sql, objects);
    }

    @Override
    public int deleteUserInfo(String userId) {
        String sql = "DELETE FROM userinfo WHERE user_id = ?";
        return jdbcTemplate.update(sql, userId);
    }
}
