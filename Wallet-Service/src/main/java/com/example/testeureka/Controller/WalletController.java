package com.example.testeureka.Controller;


import com.example.testeureka.Entity.Wallet;
import com.example.testeureka.Service.impl.WalletServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class WalletController {

    @Autowired
    private WalletServiceImpl walletService;

    @GetMapping(path = "/Wallets")
    public List<Wallet> findAll() {
        return walletService.findAll();
    }

    @GetMapping("wallet/{id}")
    public Wallet findById(@PathVariable("id") String id) {
        return walletService.findById(id);
    }

    @PostMapping("/Wallet")
    public Wallet save(@RequestBody Wallet wallet) {
        return walletService.save(wallet);
    }

    @DeleteMapping("Wallet/{id}")
    public void deleteById(@PathVariable("id") String id) {
        walletService.deleteById(id);
    }

}

