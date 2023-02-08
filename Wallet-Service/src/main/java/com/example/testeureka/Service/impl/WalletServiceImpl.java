package com.example.testeureka.Service.impl;



import com.example.testeureka.Entity.Wallet;
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
}

