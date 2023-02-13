package com.example.testeureka.Controller;


import com.example.testeureka.Entity.Wallet;
import com.example.testeureka.Service.impl.WalletServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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

    @GetMapping("/balance/{walletId}")
    public ResponseEntity<Double> checkBalance(@PathVariable String walletId) {
        Double balance = walletService.checkBalance(walletId);
        return ResponseEntity.ok(balance);
    }

    @PutMapping("/credit/{walletId}/{amount}")
    public ResponseEntity<Double> creditAmount(@PathVariable String walletId, @PathVariable Double amount) {
        Double newBalance = walletService.creditAmount(walletId, amount);
        return ResponseEntity.ok(newBalance);
    }

    @PutMapping("/debit/{walletId}/{amount}")
    public ResponseEntity<Double> debitAmount(@PathVariable String walletId, @PathVariable Double amount) {
        Double newBalance = walletService.debitAmount(walletId, amount);
        return ResponseEntity.ok(newBalance);
    }

}

