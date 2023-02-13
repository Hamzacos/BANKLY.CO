package com.example.app.Controller;


import com.example.app.Entity.Transaction;
import com.example.app.Error.InsufficientBalanceException;
import com.example.app.Service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TransactionController {

    @Autowired
    private TransactionService transactionService;

    @PostMapping(path = "/debiter")
    public void debit(@RequestBody Transaction request) {
        String walletId = request.getWalletId();
        Double amount = request.getAmount();
        transactionService.debit(walletId, amount);
    }

    @PostMapping(path = "/crediter")
    public void credier(@RequestBody Transaction request) {
        String walletId = request.getWalletId();
        Double amount = request.getAmount();
        transactionService.credit(walletId, amount);
    }
}
