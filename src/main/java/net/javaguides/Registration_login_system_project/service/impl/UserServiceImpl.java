package net.javaguides.Registration_login_system_project.service.impl;

import net.javaguides.Registration_login_system_project.dto.UserDto;
import net.javaguides.Registration_login_system_project.entity.User;
import net.javaguides.Registration_login_system_project.repository.UserRepository;
import net.javaguides.Registration_login_system_project.service.UserService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void saveUser(UserDto userDto) {
        User user = new User();
        user.setName(userDto.getFirstName() + " " + userDto.getLastName());
        user.setEmail(userDto.getEmail());
        user.setPhoneNumber(userDto.getPhoneNumber());
        user.setCourseOfStudy(userDto.getCourseOfStudy());
        userRepository.save(user);
    }

    @Override
    public User findUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    @Override
    public List<UserDto> findAllUsers() {
        List<User> users = userRepository.findAll();
        return users.stream()
                .map(this::mapToUserDto)
                .collect(Collectors.toList());
    }

    private UserDto mapToUserDto(User user) {
        UserDto userDto = new UserDto();
        String[] names = user.getName().split(" ", 2);
        userDto.setFirstName(names.length > 0 ? names[0] : "");
        userDto.setLastName(names.length > 1 ? names[1] : "");
        userDto.setEmail(user.getEmail());
        userDto.setPhoneNumber(user.getPhoneNumber());
        userDto.setCourseOfStudy(user.getCourseOfStudy());
        return userDto;
    }
}
