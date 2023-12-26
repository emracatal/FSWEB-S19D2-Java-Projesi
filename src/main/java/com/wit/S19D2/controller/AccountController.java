package com.wit.S19D2.controller;

import com.wit.S19D2.entity.Account;
import com.wit.S19D2.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/account")
public class AccountController {
    private AccountService accountService;

    @Autowired

    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @GetMapping("/")
    public List<Account> findAll() {
        return accountService.findAll();
    }

    @PostMapping("/")
    public Account save(@RequestBody Account account) {
        return accountService.save(account);
    }
    //    İlk olarak Member kaydebilmek için [POST]/workintech/auth/register şeklinde bir endpoint tanımlayın ve buradan bir adet user rolünde bir adet admin rolünde kullanıcı tanımlayın.
//    Amacımız CRUD işlemlerini tanımlayan endpointler yazmak.
//            [GET]/workintech/accounts/ => tüm account listini dönmeli.
//            [GET]/workintech/accounts/{id} => İlgili id deki account objesini dönmeli.
//            [POST]/workintech/accounts => Bir adet account objesini veritabanına kaydeder.
//            [PUT]/workintech/accounts/{id} => İlgili id deki account objesinin değerlerini yeni gelen data ile değiştirir.
//[DELETE]/workintech/accounts/{id} => İlgili id değerindeki account objesini veritabanından siler.
}
