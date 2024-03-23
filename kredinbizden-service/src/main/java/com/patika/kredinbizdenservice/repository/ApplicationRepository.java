package com.patika.kredinbizdenservice.repository;

import com.patika.kredinbizdenservice.model.Application;
import com.patika.kredinbizdenservice.model.ConsumerLoan;
import com.patika.kredinbizdenservice.model.Loan;
import com.patika.kredinbizdenservice.model.User;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class ApplicationRepository {
    List<Application> applicationList=new ArrayList<Application>();

    public ApplicationRepository(){
        applicationList.add(new Application(new ConsumerLoan(BigDecimal.valueOf(10000),10,5.5),new User("Cem", "Dırman", "cemdırman@gmail.com", "password123", "1234567890", true), LocalDateTime.now()));
        applicationList.add(new Application(new ConsumerLoan(BigDecimal.valueOf(12345),8,3.5),new User("John", "Doe", "john.doe@hotmail.com", "password123", "1234567890", true), LocalDateTime.now()));

    }

    public List<Application> getAll() {
        return applicationList;
    }

    public Application createApplication(Loan loan, User user, LocalDateTime localDateTime){
        Application newApplication= new Application(loan, user, localDateTime);
        applicationList.add(newApplication);
        return newApplication;
    }
}
