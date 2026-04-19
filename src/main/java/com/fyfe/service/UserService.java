package com.fyfe.service;

import com.fyfe.beans.User;

public interface UserService {
    User getUserById(Integer id);
    int add(User user);
    int update(User user);
    int delete(Integer id);
}
