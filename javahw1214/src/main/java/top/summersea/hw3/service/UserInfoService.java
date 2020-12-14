package top.summersea.hw3.service;


import java.util.List;

public interface UserInfoService {

    /**
     * 根据username的有无可以进行模糊查询
     *
     * @param username
     * @return
     */
    List<Object> getUserInfoList(String... username);

}
