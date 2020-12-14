package top.summersea.hw3.dao;


import java.util.List;

public interface UserInfoDao {

    List<Object> selectAllUserInfoWithUserType(String... username);


}
