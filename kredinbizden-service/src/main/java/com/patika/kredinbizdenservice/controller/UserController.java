package com.patika.kredinbizdenservice.controller;

import com.patika.kredinbizdenservice.model.Application;
import com.patika.kredinbizdenservice.model.User;
import com.patika.kredinbizdenservice.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/users")
public class UserController {

    @Autowired
    private IUserService userService;

    @Autowired
    public UserController(IUserService userService) {
        this.userService = userService;
    }

    // create user
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public User create(@RequestBody User user) {
        System.out.println("userService: " + userService.hashCode());
        return userService.save(user);
    }

    /*
    get all users
     */
    @GetMapping
    public List<User> getAll() {
        return userService.getAll();
    }

    @GetMapping("/{email}")
    public User getByEmail(@PathVariable String email) {
        return userService.getByEmail(email);
    }

    @PutMapping("/{email}")
    public ResponseEntity<User> update(@PathVariable String email, @RequestBody User user) {

        User user1 = userService.update(email, user);

        if (user1 != null){
            return ResponseEntity.ok().body(user1);
        }

        return ResponseEntity.notFound().build();
    }


    //email adresi ile kullanıcının bütün başvurularını listeleyen end-point’i yazın.
    @GetMapping("applications/{email}")
    public List<Application> getApplicationsByEmail(@PathVariable String email) {
        return userService.getByEmail(email).getApplicationList();
    }








   /* @Autowired
    public void setUserService(IUserService userService) {
        this.userService = userService;
    }*/
}
