package spring.crud.service;

import spring.crud.model.User;

import java.util.List;

public interface UserService {
    void save(User user);
    void deleteById(int id);
    User getById(int id);
    List<User> getAll();
}
