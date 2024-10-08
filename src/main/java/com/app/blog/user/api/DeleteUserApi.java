package com.app.blog.user.api;

import com.app.blog.user.interfaces.service.DeleteUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
@CrossOrigin(origins = "http://localhost:8080")
public class DeleteUserApi {
    private DeleteUserService userService;

    @Autowired
    public DeleteUserApi(DeleteUserService userService) {
        super();
        this.userService = userService;
    }

    @DeleteMapping("/{userName}")
    public ResponseEntity<String>  deleteByUserName(@PathVariable String userName) {
        boolean isDeleted = userService.deleteByUserName(userName);
        if (isDeleted) {
            return ResponseEntity.ok("User deleted successfully");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not found");
        }
    }


}
