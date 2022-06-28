package com.company.menumaker.service;

import com.company.menumaker.dto.CreateRequestUser;
import com.company.menumaker.dto.UpdateRequestUser;
import com.company.menumaker.dto.UserDto;
import com.company.menumaker.dto.UserDtoConverter;
import com.company.menumaker.entities.User;
import com.company.menumaker.exception.UserNotFoundException;
import com.company.menumaker.repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
@Service
public class UserService {
    private final UserRepository userRepository;
    private final UserDtoConverter userDtoConverter;

    public UserService(UserRepository userRepository, UserDtoConverter userDtoConverter) {
        this.userRepository = userRepository;
        this.userDtoConverter = userDtoConverter;
    }

     public UserDto createUser(CreateRequestUser createRequestUser){
        User user=new User();
        user.setEmail(createRequestUser.getEmail());
        user.setPhone(createRequestUser.getPhone());
        user.setPassword(createRequestUser.getPassword());
        user.setState(createRequestUser.getState());
        userRepository.save(user);
        return userDtoConverter.converter(user);

     }
     public List<UserDto> getAllUsers(){
        List<User> userList=userRepository.findAll();
        List<UserDto> userDtoList = new ArrayList<>();
        for(User user:userList){
            userDtoList.add(userDtoConverter.converter(user));
        }
        return userDtoList;
     }

     public UserDto getByUserDtoId(Integer  id){
         Optional<User> userOptional=userRepository.findById(id);
         return userOptional.map(userDtoConverter::converter).orElse(new UserDto());

     }

    public UserDto getByUserDtoEmail(String  email) {
        User user=findByEmail(email);
        return userDtoConverter.converter(user);
    }

    public UserDto getByUserDtoPhone(String  phone) {
        User user=findByPhone(phone);
        return userDtoConverter.converter(user);
    }

    public UserDto getByUserDtoPassword(String password) {
        User user=findByPassword(password);
        return userDtoConverter.converter(user);
    }




    public UserDto updateUser(Integer id, UpdateRequestUser updateRequestUser){
        Optional<User> userOptional = userRepository.findById(id);
        userOptional.ifPresent(user -> {
            user.setEmail(updateRequestUser.getEmail());
            user.setPhone(updateRequestUser.getPhone());
            user.setPassword(updateRequestUser.getPassword());
            userRepository.save(user);
        });
        return userOptional.map(userDtoConverter::converter).orElse(new UserDto());


    }
     public void deleteById(Integer id){
      userRepository.deleteById(id);
     }


     protected User getUserId(Integer id){
        return userRepository.findById(id).orElse(new User());
     }
     private User findByEmail(String email){
        return userRepository.findByEmail(email)
                .orElseThrow(()-> new UserNotFoundException("User not found"));
     }

    private User findByPhone(String phone){
        return userRepository.findByEmail(phone)
                .orElseThrow(()-> new UserNotFoundException("User not found"));
    }

    private User findByPassword(String password){
        return userRepository.findByPassword(password)
                .orElseThrow(()-> new UserNotFoundException("User not found"));
    }






}
