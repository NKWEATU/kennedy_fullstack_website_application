package net.javaguides.Registration_login_system_project.service;

import net.javaguides.Registration_login_system_project.dto.UserDto;
import net.javaguides.Registration_login_system_project.entity.User;

import java.util.List;

public interface UserService {
    void saveUser(UserDto userDto);

    User findUserByEmail(String email);

    List<UserDto> findAllUsers();  //  Added to match implementation
}
