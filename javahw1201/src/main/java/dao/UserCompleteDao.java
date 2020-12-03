package dao;

import entity.UserComplete;

public interface UserCompleteDao {
    Integer selectEmailCount(String email);

    Integer selectCount(UserComplete userComplete);
}
