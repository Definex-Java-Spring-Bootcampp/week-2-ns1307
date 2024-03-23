package com.patika.kredinbizdenservice.controller;

import com.patika.kredinbizdenservice.model.*;
import com.patika.kredinbizdenservice.service.ApplicationService;
import com.patika.kredinbizdenservice.service.IApplicationService;
import com.patika.kredinbizdenservice.service.IBankService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/applications")
public class ApplicationController {



    //get all applications
    @Autowired
    private IApplicationService applicationService;

    @GetMapping
    public List<Application> getAll() {
        return applicationService.getAll();
    }

    //Kredi başvurularını kaydeden end-point’i yazın.
    @PostMapping
    public ResponseEntity createApplication(@RequestParam("loanType") String loanType, @RequestParam("amount") int amount, @RequestParam("installment") int installment, @RequestParam("interestRate") double interestRate, @RequestBody User user, @RequestBody LocalDateTime localDateTime){
        if(loanType.equalsIgnoreCase("IHTIYAC_KREDISI")){
            return ResponseEntity.ok().body(applicationService.createApplication(new ConsumerLoan(BigDecimal.valueOf(amount), installment, interestRate), user, localDateTime));
        }
        else if (loanType.equalsIgnoreCase("KONUT_KREDISI")) {
            return ResponseEntity.ok().body(applicationService.createApplication(new HouseLoan(BigDecimal.valueOf(amount), installment, interestRate), user, localDateTime));
        }
        else{
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body("Böyle bir kredi türü yok.");
        }
    }

}
