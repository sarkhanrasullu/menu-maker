package com.company.menumaker.controller.rest;

import com.company.menumaker.dto.CreateRequestUser;
import com.company.menumaker.dto.UpdateRequestUser;
import com.company.menumaker.dto.UserDto;
import com.company.menumaker.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/menumaker/user")
public class UserRestController {

    private final UserService userService;

    public UserRestController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public ResponseEntity<UserDto> createUser(@RequestBody CreateRequestUser createRequestUser){
        return ResponseEntity.ok(userService.createUser(createRequestUser));
    }

    @GetMapping
    public ResponseEntity<List<UserDto>> getAllUsers(){
        return ResponseEntity.ok(userService.getAllUsers());
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserDto> getUserById(@PathVariable Integer id){
        return ResponseEntity.ok(userService.getByUserDtoId(id));
    }

    @GetMapping("/v1/{email}")
    public ResponseEntity<UserDto> getUserByEmail(@PathVariable String email){
        return ResponseEntity.ok(userService.getByUserDtoEmail(email));
    }



    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Integer id){
        userService.deleteById(id);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserDto> updateCustomer(@PathVariable Integer id,
                                                  @RequestBody UpdateRequestUser updateRequestUser) {
        return ResponseEntity.ok(userService.updateUser(id, updateRequestUser));
    }

}
