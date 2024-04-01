package main.java.ru.aston.model.dto;

import lombok.Data;

import java.util.Objects;

@Data
public class BankCardDto {
    private Long id;
    private String serialNumber;
    private PlainUserDto plainUserDto;

    public static BankCardDto from(ru.aston.model.BankCardIsAlreadyAssignedException bankCard) {
        BankCardDto bankCardDto = new BankCardDto();
        bankCardDto.setId(bankCard.getId());
        bankCardDto.setSerialNumber(bankCard.getSerialNumber());
        if (Objects.nonNull(bankCard.getUser())) {
            bankCardDto.setPlainUserDto(PlainUserDto.from(bankCard.getUser()));
        }
        return bankCardDto;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public PlainUserDto getPlainUserDto() {
        return plainUserDto;
    }

    public void setPlainUserDto(PlainUserDto plainUserDto) {
        this.plainUserDto = plainUserDto;
    }
}