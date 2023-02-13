package com.example.testeureka.Service.impl;



import com.example.testeureka.Entity.Wallet;
import com.example.testeureka.Error.InsufficientBalanceException;
import com.example.testeureka.Error.WalletNotFoundException;
import com.example.testeureka.Reposetry.WalletReposetry;
import com.example.testeureka.Service.ServiceWallet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WalletServiceImpl implements ServiceWallet {


    @Autowired
    private WalletReposetry walletRepository;

    @Override
    public List<Wallet> findAll() {
        return walletRepository.findAll();
    }

    @Override
    public Wallet findById(String id) {
        return walletRepository.findById(id).orElse(null);
    }

    @Override
    public Wallet save(Wallet wallet) {
        return walletRepository.save(wallet);
    }

    @Override
    public void deleteById(String id) {
        walletRepository.deleteById(id);
    }

    @Override
    public double checkBalance(String walletId) {
        Wallet wallet = walletRepository.findById(walletId)
                .orElseThrow(() -> new IllegalArgumentException("Invalid wallet ID"));
        return wallet.getBalance();
    }

    @Override
    public double creditAmount(String walletId, double amount) {
        Wallet wallet = walletRepository.findById(walletId).orElseThrow(() -> new WalletNotFoundException(walletId));
        double newBalance = wallet.getBalance() + amount;
        wallet.setBalance(newBalance);
        walletRepository.save(wallet);
        return newBalance;
    }

    @Override
    public double debitAmount(String walletId, double amount) {
        Wallet wallet = walletRepository.findById(walletId).orElseThrow(() -> new WalletNotFoundException(walletId));
        double currentBalance = wallet.getBalance();
        if (currentBalance >= amount) {
            double newBalance = currentBalance - amount;
            wallet.setBalance(newBalance);
            walletRepository.save(wallet);
            return newBalance;
        } else {
            throw new InsufficientBalanceException("Insufficient balance in wallet with id : " + walletId);
        }
    }
}

