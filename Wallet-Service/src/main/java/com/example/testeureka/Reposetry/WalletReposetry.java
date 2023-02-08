package com.example.testeureka.Reposetry;


import com.example.testeureka.Entity.Wallet;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WalletReposetry extends MongoRepository<Wallet,String> {
}
