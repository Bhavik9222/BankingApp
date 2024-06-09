package com.bankingApp.Controller;

import com.bankingApp.Dto.AccountDto;
import com.bankingApp.Service.AccountService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/accounts")
public class AccountController {

    private final AccountService accountService;

    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }
// create multiple accounts
    @PostMapping("/createAccounts")
    public ResponseEntity<List<AccountDto>> createAccounts(@RequestBody List<AccountDto> accountDtos) {
        List<AccountDto> createdAccounts = accountService.createAccounts(accountDtos);
        return new ResponseEntity<>(createdAccounts, HttpStatus.CREATED);
    }
// create single account
    @PostMapping("/createAccount")
    public ResponseEntity<AccountDto> createAccount(@RequestBody AccountDto accountDto) {
        AccountDto createdAccount = accountService.createAccount(accountDto);
        return new ResponseEntity<>(createdAccount, HttpStatus.CREATED);
    }
// get account by id
    @GetMapping("/{id}")
    public ResponseEntity<AccountDto> getAccountById(@PathVariable Long id) {
        AccountDto accountDto = accountService.getAccountById(id);
        return ResponseEntity.ok(accountDto);
    }
// add deposit amount 
    @PostMapping("/{id}/deposit")
    public ResponseEntity<AccountDto> deposit(@PathVariable Long id, @RequestParam double amount) {
        AccountDto updatedAccount = accountService.deposit(id, amount);
        return ResponseEntity.ok(updatedAccount);
    }
// for update balance
    @PutMapping("/{id}/balance")
    public ResponseEntity<AccountDto> updateAccountBalance(@PathVariable Long id, @RequestParam double balance) {
        AccountDto updatedAccount = accountService.updateAccountBalance(id, balance);
        return ResponseEntity.ok(updatedAccount);
    }
// for withdraw balance
    @PutMapping("/{id}/withdraw")
    public ResponseEntity<AccountDto> withdraw(@PathVariable long id, @RequestBody Map<String, Double> request) {
        double amount = request.get("amount");
        AccountDto accountDto = accountService.withdraw(id, amount);
        return ResponseEntity.ok(accountDto);
    }

// get all account 
    @GetMapping
    public ResponseEntity<List<AccountDto>> getAllAccounts() {
        List<AccountDto> accounts = accountService.getAllAccounts();
        return ResponseEntity.ok(accounts);
    }
    
// for delete account through id
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAccount(@PathVariable Long id) {
        accountService.deleteAccount(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
