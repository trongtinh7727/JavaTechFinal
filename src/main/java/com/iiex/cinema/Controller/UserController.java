package com.iiex.cinema.Controller;

import com.iiex.cinema.Api.CustomResponse;
import com.iiex.cinema.DTO.UserDto;
import com.iiex.cinema.Model.User;
import com.iiex.cinema.Repository.RoleRepository;
import com.iiex.cinema.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("api/users")
public class UserController {
    @Autowired
    private UserService userService;

    @Autowired
    private RoleRepository roleRepository;

    @GetMapping("")
    ResponseEntity<CustomResponse> all() {
        List<User> users = userService.findAllUsers(roleRepository.findByName("USER"));
        CustomResponse<User> response = new CustomResponse(true, users);
        return ResponseEntity.ok(response);
    }
    @GetMapping("/{id}")
    User one(@PathVariable Long id) {
        return userService.findById(id);
    }
    @PostMapping("")
    ResponseEntity<CustomResponse> getNewUser(@RequestBody UserDto newUser) {
        userService.saveUser(newUser);
        CustomResponse<User> response = new CustomResponse(true,"Thêm thành công");
        return ResponseEntity.ok(response);
    }
    @DeleteMapping("/{id}")
    ResponseEntity<CustomResponse> delete(@PathVariable Long id){
        userService.delete(id);
        CustomResponse<User> response = new CustomResponse(true,"Xóa thành công");
        return ResponseEntity.ok(response);
    }
    @PutMapping("/{id}")
    ResponseEntity<CustomResponse> update(@RequestBody User newUser) {
        List<User> list = new ArrayList<>();
        list.add(userService.update(newUser));
        CustomResponse<User> response = new CustomResponse(true,list,"Sửa thành công");
        return ResponseEntity.ok(response);
    }
    
}
