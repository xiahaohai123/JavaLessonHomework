package top.summersea.hw3.dao;


import org.springframework.stereotype.Repository;
import top.summersea.hw3.util.JDBCUtil;

import java.util.List;

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
    private JDBCUtil jdbcUtil;

    public UserInfoDaoImpl() {
        jdbcUtil = JDBCUtil.getInstance();
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

}
