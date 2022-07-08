package com.company.menumaker.controller;

import com.company.menumaker.dto.CreateRequestUser;
import com.company.menumaker.dto.UpdateRequestUser;
import com.company.menumaker.dto.UserDto;
import com.company.menumaker.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/menumaker/user")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PreAuthorize("hasAuthority('USER')")
    @PostMapping("/signup")
    public ResponseEntity<?> createUser(@RequestBody CreateRequestUser createRequestUser){
        if (userService.checkEmail(createRequestUser.getEmail())) {
            return new ResponseEntity<>("Email is already taken!", HttpStatus.BAD_REQUEST);
        }
        return ResponseEntity.ok(userService.createUser(createRequestUser));
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @GetMapping
    public ResponseEntity<List<UserDto>> getAllUsers(){
        return ResponseEntity.ok(userService.getAllUsers());
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @GetMapping("/{id}")
    public ResponseEntity<UserDto> getUserById(@PathVariable Integer id){
        return ResponseEntity.ok(userService.getByUserDtoId(id));
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @GetMapping("/v1/{email}")
    public ResponseEntity<UserDto> getUserByEmail(@PathVariable String email){
        return ResponseEntity.ok(userService.getByUserDtoEmail(email));
    }



    @PreAuthorize("hasAuthority('ADMIN')")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Integer id){
        userService.deleteById(id);
        return ResponseEntity.ok().build();
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @PutMapping("/{id}")
    public ResponseEntity<UserDto> updateCustomer(@PathVariable Integer id,
                                                  @RequestBody UpdateRequestUser updateRequestUser) {
        return ResponseEntity.ok(userService.updateUser(id, updateRequestUser));
    }

}
