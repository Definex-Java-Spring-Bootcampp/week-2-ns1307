package com.patika.kredinbizdenservice.service;

import com.patika.kredinbizdenservice.model.Bank;
import com.patika.kredinbizdenservice.model.Campaign;
import com.patika.kredinbizdenservice.model.CreditCard;
import com.patika.kredinbizdenservice.model.User;
import com.patika.kredinbizdenservice.repository.BankRepository; // Varsayılan bir repository sınıfı.
import com.patika.kredinbizdenservice.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class BankService implements IBankService {

    private BankRepository bankRepository = new BankRepository();

    @Override
    public List<CreditCard> getCreditCardsWithCampaignsByBankName(String bankName) {
        // Bu metod, verilen banka adına göre, bu bankanın kredi kartlarını ve bu kartların kampanyalarını döndürür.
        Optional<Bank> bank = bankRepository.findByName(bankName);

        if (bank.isPresent()) {
            return bank.get().getCreditCards();
        } else {
            // Banka bulunamazsa, boş bir liste döndür.
            return List.of();
        }
    }


    @Override
    public List<Bank> getAll() {
        System.out.println("bankRepository: " + bankRepository.hashCode());
        return bankRepository.getAll();
    }

    @Override
    public List<Campaign> getAllCampaignsNewest() {
        return bankRepository.getAllCampaignsNewest();
    }
}
