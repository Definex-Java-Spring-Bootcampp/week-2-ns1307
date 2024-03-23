package com.patika.kredinbizdenservice.service;

import com.patika.kredinbizdenservice.model.Application;
import com.patika.kredinbizdenservice.model.Loan;
import com.patika.kredinbizdenservice.model.User;
import com.patika.kredinbizdenservice.repository.ApplicationRepository;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class ApplicationService implements IApplicationService{

    private ApplicationRepository applicationRepository = new ApplicationRepository();
    @Override
    public List<Application> getAll() {
        System.out.println("applicationRepository: " + applicationRepository.hashCode());
        return applicationRepository.getAll();
    }

    @Override
    public Application createApplication(Loan loan, User user, LocalDateTime localDateTime) {
        return applicationRepository.createApplication(loan, user, localDateTime);
    }
}
