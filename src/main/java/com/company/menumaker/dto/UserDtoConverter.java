package com.company.menumaker.dto;

import com.company.menumaker.entities.User;
import org.springframework.stereotype.Component;

@Component
public class UserDtoConverter {
    public UserDto converter(User user) {
       UserDto userDto=new UserDto();
       userDto.setEmail(user.getEmail());
       userDto.setPhone(user.getPhone());
       userDto.setState(user.getState());
       return userDto;
    }
}
