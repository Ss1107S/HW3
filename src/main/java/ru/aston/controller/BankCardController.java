package main.java.ru.aston.controller;

import main.java.ru.aston.service.BankCardService;
import main.java.ru.aston.model.dto.BankCardDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping
public class BankCardController {

    private final BankCardService bankCardService;

    @Autowired
    public BankCardController(BankCardService bankCardService) {
        this.bankCardService = bankCardService;
    }

    @PostMapping("/cards/")
    public ResponseEntity<BankCardDto> addItem(@RequestBody final BankCardDto bankCardDto) {
        ru.aston.model.BankCardIsAlreadyAssignedException bankCard = bankCardService.addBankCard(ru.aston.model.BankCardIsAlreadyAssignedException.from(bankCardDto));
        return new ResponseEntity<>(BankCardDto.from(bankCard), HttpStatus.OK);
    }

    @GetMapping("/cards/")
    public ResponseEntity<List<BankCardDto>> getItems() {
        List<ru.aston.model.BankCardIsAlreadyAssignedException> bankCards = bankCardService.getBankCards();
        List<BankCardDto> itemsDto = bankCards.stream().map(BankCardDto::from).collect(Collectors.toList());
        return new ResponseEntity<>(itemsDto, HttpStatus.OK);
    }

    @GetMapping("/cards/{id}")
    public ResponseEntity<BankCardDto> getItem(@PathVariable final Long id) {
        ru.aston.model.BankCardIsAlreadyAssignedException bankCard = bankCardService.getBankCard(id);
        return new ResponseEntity<>(BankCardDto.from(bankCard), HttpStatus.OK);
    }

    @DeleteMapping("/cards/{id}")
    public ResponseEntity<BankCardDto> deleteItem(@PathVariable final Long id) {
        ru.aston.model.BankCardIsAlreadyAssignedException bankCard = bankCardService.deleteBankCard(id);
        return new ResponseEntity<>(BankCardDto.from(bankCard), HttpStatus.OK);
    }

    @PutMapping("/cards/{id}")
    public ResponseEntity<BankCardDto> editItem(@PathVariable final Long id,
                                                @RequestBody final BankCardDto bankCardDto) {
        ru.aston.model.BankCardIsAlreadyAssignedException editedBankCard = bankCardService.editBankCard(id, ru.aston.model.BankCardIsAlreadyAssignedException.from(bankCardDto));
        return new ResponseEntity<>(BankCardDto.from(editedBankCard), HttpStatus.OK);
    }
}