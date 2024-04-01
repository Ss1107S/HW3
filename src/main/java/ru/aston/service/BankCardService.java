package ru.aston.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.aston.model.BankCard;
import ru.aston.model.exception.BankCardNotFoundException;
import ru.aston.repository.BankCardRepository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class BankCardService {

    private final BankCardRepository bankCardRepository;

    @Autowired
    public BankCardService(BankCardRepository bankCardRepository) {
        this.bankCardRepository = bankCardRepository;
    }

    public BankCard addBankCard(BankCard bankCard){
        return bankCardRepository.save(bankCard);
    }

    public List<BankCard> getBankCards(){
        return StreamSupport
                .stream(bankCardRepository.findAll().spliterator(), false)
                .collect(Collectors.toList());
    }

    public BankCard getBankCard(Long id){
        return bankCardRepository.findById(id).orElseThrow(() ->
                new BankCardNotFoundException(id));
    }

    public BankCard deleteBankCard(Long id){
        BankCard bankCard = getBankCard(id);
        bankCardRepository.delete(bankCard);
        return bankCard;
    }

    @Transactional
    public BankCard editBankCard(Long id, BankCard bankCard){
        BankCard bankCardToEdit = getBankCard(id);
        bankCardToEdit.setSerialNumber(bankCard.getSerialNumber());
        return bankCardToEdit;
    }
}