package com.patika.kredinbizdenservice.service;

import com.patika.kredinbizdenservice.model.User;

import java.util.List;

public interface IUserService {
    User save(User user);

    List<User> getAll();

    User getByEmail(String email);

    User update(String email, User user);
}
