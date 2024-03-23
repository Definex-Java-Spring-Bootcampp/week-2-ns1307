package com.patika.kredinbizdenservice.configuration;

import com.patika.kredinbizdenservice.service.IUserService;
import com.patika.kredinbizdenservice.service.UserService;
import com.patika.kredinbizdenservice.service.UserService2;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfiguration {

    @Bean
    public IUserService userService4() {
        return new UserService2();
    }
}
