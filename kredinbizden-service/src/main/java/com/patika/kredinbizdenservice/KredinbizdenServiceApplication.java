package com.patika.kredinbizdenservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class KredinbizdenServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(KredinbizdenServiceApplication.class, args);

        //IUserService userService = new UserService();

        //IUserService userService2 = new UserService2();

        //UserController userController = new UserController(userService);
       // userController.create(new User());
    }

    /*
    @Bean
    @Scope("prototype")
    public IUserService userService() {
        return new UserService();
    }*/

}
