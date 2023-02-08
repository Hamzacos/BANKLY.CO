package com.example.testeureka.Entity;




import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;


@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Wallet {

    @Id
    private String id;

    private String name;
    private Double balance;

    public Wallet(String name,Double balance){
        this.name = name;
        this.balance = balance;
    }

}
