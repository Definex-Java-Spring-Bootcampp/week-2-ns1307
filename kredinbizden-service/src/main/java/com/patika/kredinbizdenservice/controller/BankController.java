package com.patika.kredinbizdenservice.controller;

import com.patika.kredinbizdenservice.model.Bank;
import com.patika.kredinbizdenservice.model.Campaign;
import com.patika.kredinbizdenservice.model.CreditCard;
import com.patika.kredinbizdenservice.model.User;
import com.patika.kredinbizdenservice.service.BankService;
import com.patika.kredinbizdenservice.service.IBankService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/banks")
public class BankController {

    @Autowired
    private IBankService bankService; // BankService should be implemented to handle the business logic.

    //bütün bankaları döndürür.
    @GetMapping
    public List<Bank> getAll() {
        return bankService.getAll();
    }


    //Bankaların kredi kartlarını ve bu kartların kampanyalarını listeleyen end-point’i yazın.
    @GetMapping("/credit-cards/{bankName}")
    public List<CreditCard> getCreditCardsByBankName(@PathVariable String bankName) {
        // Bu metod, banka adına göre kredi kartlarını tüm özellikleriyle döndürür.
        return bankService.getCreditCardsWithCampaignsByBankName(bankName);
    }


    //Sistemdeki bütün kampanyaları en güncelden eski tarihe doğru listeleyen end-point’i yazın.
    @GetMapping("/campaigns")
    public List<Campaign> getAllCampaigns() {
        // Bu metod, bütün kampanyaları yeniden eskiye doğru döndürür.(dueDate tarihlerine göre)
        return bankService.getAllCampaignsNewest();
    }


}
