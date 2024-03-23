package com.patika.kredinbizdenservice.repository;

import com.patika.kredinbizdenservice.enums.SectorType;
import com.patika.kredinbizdenservice.model.*;
import org.springframework.stereotype.Repository;
import java.util.Collections;
import java.util.Comparator;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class BankRepository {

    List<Bank> bankList = new ArrayList<>();


    public BankRepository() {
        List<Loan> loanList= new ArrayList<Loan>();
        loanList.add(new ConsumerLoan(BigDecimal.valueOf(10000),12, 5.5));
        loanList.add(new HouseLoan(BigDecimal.valueOf(8888),5, 2.5));

        List<CreditCard> creditCards= new ArrayList<CreditCard>();

        List<Campaign> campaignList= new ArrayList<Campaign>();
        campaignList.add(new Campaign ("8 Taksit","6 Taksit", LocalDate.of(2021,12,01),LocalDate.of(2023,05,11),LocalDate.of(2023,05,11), SectorType.MARKET));
        campaignList.add(new Campaign ("75 Puan","xxxxx", LocalDate.of(2022,06,10),LocalDate.of(2022,05,11),LocalDate.of(2022,05,11), SectorType.MARKET));
        creditCards.add(new CreditCard(BigDecimal.valueOf(5000),campaignList));

        List<Campaign> campaignList2= new ArrayList<Campaign>();
        campaignList2.add(new Campaign ("10 Taksit","6 Taksit", LocalDate.of(2021,03,16),LocalDate.of(2023,05,11),LocalDate.of(2023,05,11), SectorType.MARKET));
        campaignList2.add(new Campaign ("1000 Puan","xxxxx", LocalDate.of(2023,8,11),LocalDate.of(2022,05,11),LocalDate.of(2022,05,11), SectorType.MARKET));
        creditCards.add(new CreditCard(BigDecimal.valueOf(10000),campaignList2));


        bankList.add(new Bank("Bank1",loanList,creditCards));


        List<Loan> loanList2= new ArrayList<Loan>();
        loanList2.add(new ConsumerLoan(BigDecimal.valueOf(1245),8, 2.5));
        loanList2.add(new HouseLoan(BigDecimal.valueOf(9875),10, 8.5));
        loanList2.add(new ConsumerLoan(BigDecimal.valueOf(75000),6, 10.5));
        List<CreditCard> creditCards2= new ArrayList<CreditCard>();

        List<Campaign> campaignList3= new ArrayList<Campaign>();
        campaignList3.add(new Campaign ("2 Taksit","6 Taksit", LocalDate.of(2021,7,27),LocalDate.of(2023,05,11),LocalDate.of(2023,05,11), SectorType.MARKET));
        campaignList3.add(new Campaign ("100 Puan","xxxxx", LocalDate.of(2024,11,11),LocalDate.of(2023,05,11),LocalDate.of(2023,05,11), SectorType.MARKET));
        creditCards2.add(new CreditCard(BigDecimal.valueOf(15000),campaignList3));

        List<Campaign> campaignList4= new ArrayList<Campaign>();
        campaignList4.add(new Campaign ("15 Taksit","6 Taksit", LocalDate.of(2019,02,28),LocalDate.of(2023,05,11),LocalDate.of(2023,05,11), SectorType.MARKET));
        campaignList4.add(new Campaign ("250 Puan","xxxxx", LocalDate.of(2024,03,25),LocalDate.of(2023,05,11),LocalDate.of(2023,05,11), SectorType.MARKET));
        creditCards2.add(new CreditCard(BigDecimal.valueOf(6000),campaignList4));

        List<Campaign> campaignList5= new ArrayList<Campaign>();
        campaignList5.add(new Campaign ("15 Taksit","6 Taksit", LocalDate.of(2022,06,17),LocalDate.of(2023,05,11),LocalDate.of(2023,05,11), SectorType.MARKET));
        campaignList5.add(new Campaign ("250 Puan","xxxxx", LocalDate.of(2024,01,20),LocalDate.of(2023,05,11),LocalDate.of(2023,05,11), SectorType.MARKET));
        creditCards2.add(new CreditCard(BigDecimal.valueOf(8000),campaignList5));

        bankList.add(new Bank("Bank2",loanList2,creditCards2));


    }

    public Optional<Bank> findByName(String name){
        return bankList.stream()
                .filter(bank -> bank.getName().equals((name)))
                .findFirst();
    }

    public List<Bank> getAll() {
        return  bankList;
    }

    public List<Campaign> getAllCampaignsNewest() {
        List<Campaign> campaignList= new ArrayList<Campaign>();
        for(Bank bank: bankList){
            for(CreditCard card : bank.getCreditCards() ){
                List<Campaign> campaigns= card.getCampaignList();
                campaignList.addAll(campaigns);
            }
        }
        campaignList.sort(Comparator.comparing(Campaign::getDueDate).reversed());
        return campaignList;
    }
}
