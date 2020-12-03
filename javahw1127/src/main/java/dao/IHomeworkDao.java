package dao;

import entity.User;

import java.util.List;

public interface IHomeworkDao {
    /**
     * 插入
     *
     * @param user
     * @return
     */
    public Integer insert(User user);

    /**
     * 计数
     *
     * @param user
     * @return
     */
    Integer selectCount(User user);

    /**
     * 获取用户列表
     *
     * @return
     */
    List<User> selectUserList();

    /**
     * 更新用户数据
     *
     * @param user
     * @return
     */
    Integer updateUser(User user);

    /**
     * 删除用户数据
     *
     * @param id
     * @return
     */
    Integer deleteUser(int id);
}
