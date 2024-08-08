package com.app.blog.user.api;

import com.app.blog.user.interfaces.datamodel.UserBo;
import com.app.blog.user.interfaces.service.CreateUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
public class CreateUserApi implements CreateUserService {
    private CreateUserService userService;

    @Autowired
    public CreateUserApi(CreateUserService userService) {
        super();
        this.userService = userService;
    }


    @Override
    @PostMapping("/user")
    public ResponseEntity<UserBo> saveUser(@RequestBody UserBo user) {
        return userService.saveUser(user);
    }
}
