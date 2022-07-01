package com.company.menumaker.service;

import com.company.menumaker.dto.CreateRequestUser;
import com.company.menumaker.dto.UpdateRequestUser;
import com.company.menumaker.dto.UserDto;
import com.company.menumaker.entity.User;
import com.company.menumaker.exception.UserNotFoundException;
import com.company.menumaker.mapper.UserMapper;
import com.company.menumaker.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    private final UserRepository userRepository;

    private final UserMapper userMapper;

    public UserService(UserRepository userRepository, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }

    public UserDto createUser(CreateRequestUser createRequestUser) {
        User user = new User();
        user.setEmail(createRequestUser.getEmail());
        user.setPhone(createRequestUser.getPhone());
        user.setPassword(createRequestUser.getPassword());
        user.setState(createRequestUser.getState());
        User savedUser = userRepository.save(user);
        return userMapper.userEntityToDto(savedUser);

    }

    public List<UserDto> getAllUsers() {
        List<User> userList = userRepository.findAll();
        return userMapper.toDtoList(userList);
    }

    public UserDto getByUserDtoId(Integer id) {
        Optional<User> userOptional = userRepository.findById(id);
        return userOptional.map(userMapper::userEntityToDto).orElse(new UserDto());

    }

    public UserDto getByUserDtoEmail(String email) {
        User user = findByEmail(email);
        return userMapper.userEntityToDto(user);
    }

    public UserDto getByUserDtoPhone(String phone) {
        User user = findByPhone(phone);
        return userMapper.userEntityToDto(user);
    }

    public UserDto getByUserDtoPassword(String password) {
        User user = findByPassword(password);
        return userMapper.userEntityToDto(user);
    }


    public UserDto updateUser(Integer id, UpdateRequestUser updateRequestUser) {
        Optional<User> userOptional = userRepository.findById(id);
        userOptional.ifPresent(user -> {
            user.setEmail(updateRequestUser.getEmail());
            user.setPhone(updateRequestUser.getPhone());
            user.setPassword(updateRequestUser.getPassword());
            userRepository.save(user);
        });
        return userOptional.map(userMapper::userEntityToDto).orElse(new UserDto());


    }

    public void deleteById(Integer id) {
        userRepository.deleteById(id);
    }


    protected User getUserId(Integer id) {
        return userRepository.findById(id).orElse(new User());
    }

    private User findByEmail(String email) {
        return userRepository.findByEmail(email)
                .orElseThrow(() -> new UserNotFoundException("User not found"));
    }

    private User findByPhone(String phone) {
        return userRepository.findByEmail(phone)
                .orElseThrow(() -> new UserNotFoundException("User not found"));
    }

    private User findByPassword(String password) {
        return userRepository.findByPassword(password)
                .orElseThrow(() -> new UserNotFoundException("User not found"));
    }


}
