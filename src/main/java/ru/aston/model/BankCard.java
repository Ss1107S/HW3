package main.java.ru.aston.model;

import lombok.Data;
import main.java.ru.aston.model.dto.BankCardDto;

import javax.persistence.*;

@Data
@Entity
@Table(name = "BankCard")
public class BankCard {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String serialNumber;
    @ManyToOne
    private User user;

    public static BankCard from(BankCardDto bankCardDto){
        BankCard bankCard = new BankCard();
        bankCard.setSerialNumber(bankCardDto.getSerialNumber());
        return bankCard;
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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}