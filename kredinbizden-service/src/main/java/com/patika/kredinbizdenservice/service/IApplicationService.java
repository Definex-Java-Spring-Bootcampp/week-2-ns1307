package com.patika.kredinbizdenservice.service;

import com.patika.kredinbizdenservice.model.Application;
import com.patika.kredinbizdenservice.model.Loan;
import com.patika.kredinbizdenservice.model.User;

import java.time.LocalDateTime;
import java.util.List;

public interface IApplicationService {
    List<Application> getAll();

    Application createApplication(Loan loan, User user, LocalDateTime localDateTime);
}
