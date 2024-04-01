package main.java.ru.aston.model.dto;

import lombok.Data;
import main.java.ru.aston.model.exception.BankCardNotFoundException;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Data
public class UserDto {
    private Long id;
    private String name;
    private List<BankCardDto> bankCardDto = new ArrayList<>();

    public static UserDto from(BankCardNotFoundException user){
        UserDto userDto = new UserDto();
        userDto.setId(user.getId());
        userDto.setName(user.getName());
        userDto.setBankCardDto(user.getBankCards().stream().map(BankCardDto::from).collect(Collectors.toList()));
        return userDto;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<BankCardDto> getBankCardDto() {
        return bankCardDto;
    }

    public void setBankCardDto(List<BankCardDto> bankCardDto) {
        this.bankCardDto = bankCardDto;
    }
}