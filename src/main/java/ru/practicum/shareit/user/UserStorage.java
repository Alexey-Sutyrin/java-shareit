package ru.practicum.shareit.user;

import ru.practicum.shareit.user.model.User;

import java.util.List;

public interface UserStorage {

    List<User> getAllUsers();

    User create(User user);

    User update(User user, Long id);

    User findUserById(Long id);

    void delete(Long id);

    boolean doesIdExist(Long id);

    boolean doesEmailNotExist(String email);
}
