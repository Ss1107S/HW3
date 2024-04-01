package main.java.ru.aston.model.dto;

import lombok.Data;
import main.java.ru.aston.model.exception.BankCardNotFoundException;

@Data
public class PlainUserDto {
    private Long id;
    private String name;

    public static PlainUserDto from(BankCardNotFoundException user){
        PlainUserDto plainUserDto = new PlainUserDto();
        plainUserDto.setId(user.getId());
        plainUserDto.setName(user.getName());
        return plainUserDto;
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
}