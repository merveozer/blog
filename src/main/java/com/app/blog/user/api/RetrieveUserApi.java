package com.app.blog.user.api;

import com.app.blog.user.interfaces.datamodel.UserBo;
import com.app.blog.user.interfaces.service.CreateUserService;
import com.app.blog.user.interfaces.service.RetrieveUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class RetrieveUserApi implements RetrieveUserService {
    private RetrieveUserService userService;

    @Autowired
    public RetrieveUserApi(RetrieveUserService userService) {
        super();
        this.userService = userService;
    }

    @Override
    @GetMapping("/users/{userName}")
    public ResponseEntity<UserBo> getByUserName(@PathVariable String userName) {
        return userService.getByUserName(userName);
    }

    @Override
    @GetMapping("/users")
    public ResponseEntity<List<UserBo>> getAllUsers() {
        return userService.getAllUsers();
    }
}
