package dao;

import entity.User;

public interface IHomeworkDao {
    public Integer insert(User user);

    Integer selectCount(User user);
}
