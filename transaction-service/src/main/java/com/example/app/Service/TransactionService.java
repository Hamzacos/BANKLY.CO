package com.example.app.Service;


import com.example.app.Client.WalletClient;
import com.example.app.Entity.Transaction;
import com.example.app.Entity.Type;
import com.example.app.Error.InsufficientBalanceException;
import com.example.app.Repositery.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TransactionService {

    @Autowired
    private TransactionRepository transactionRepository;
    private final WalletClient walletClient;

    public TransactionService(WalletClient walletClient) {
        this.walletClient = walletClient;
    }


    public void debit(String walletId, Double amount) {
        Double balance = walletClient.checkBalance(walletId);
        if (balance >= amount) {
            walletClient.debitAmount(walletId, amount);
            Transaction transaction = new Transaction();
            transaction.setAmount(amount);
            transaction.setDescription(Type.debiter);
            transaction.setStatus("Done");
            transaction.setWalletId(walletId);
            transactionRepository.save(transaction);
        } else {
            throw new InsufficientBalanceException("Votre solde est insuffisant");
        }
    }

    public void credit(String walletId, Double amount) {
        walletClient.creditAmount(walletId, amount);
        Transaction transaction = new Transaction();
        transaction.setAmount(amount);
        transaction.setDescription(Type.crediter);
        transaction.setStatus("Done");
        transaction.setWalletId(walletId);
        transactionRepository.save(transaction);
    }
}
