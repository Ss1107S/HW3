package main.java.ru.aston.model;

import main.java.ru.aston.model.dto.UserDto;
import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name = "User")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private List<BankCard> bankCards = new ArrayList<>();

    public void addBankCard(BankCard bankCard) {
        bankCards.add(bankCard);
    }

    public void removeBankCard(BankCard bankCard) {
        bankCards.remove(bankCard);
    }

    public static User from(UserDto userDto) {
        User user = new User();
        user.setName(userDto.getName());
        return user;
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

    public List<BankCard> getBankCards() {
        return bankCards;
    }

    public void setBankCards(List<BankCard> bankCards) {
        this.bankCards = bankCards;
    }
}