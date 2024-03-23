package com.patika.kredinbizdenservice.service;

import com.patika.kredinbizdenservice.model.Bank;
import com.patika.kredinbizdenservice.model.Campaign;
import com.patika.kredinbizdenservice.model.CreditCard;
import com.patika.kredinbizdenservice.model.User;

import java.util.List;

public interface IBankService {
    List<CreditCard> getCreditCardsWithCampaignsByBankName(String bankName);

    List<Bank> getAll();

    List<Campaign> getAllCampaignsNewest();
}
