package service;

import entity.UserComplete;

public interface UserCompleteService {
    boolean isEmailExist(String email);

    boolean login(UserComplete userComplete);
}
