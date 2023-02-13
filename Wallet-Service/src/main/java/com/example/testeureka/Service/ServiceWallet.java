package com.example.testeureka.Service;


import com.example.testeureka.Entity.Wallet;

import java.util.List;

public interface ServiceWallet {

     List<Wallet> findAll();
    Wallet findById(String id);
    Wallet save(Wallet wallet);
    void deleteById(String id);
    double checkBalance(String walletId);
    double creditAmount(String walletId, double amount);
    double debitAmount(String walletId, double amount);
}
