package com.bankingApp.Service;

import com.bankingApp.Dto.AccountDto;

import java.util.List;

public interface AccountService {
    List<AccountDto> createAccounts(List<AccountDto> accountDtos);
    AccountDto createAccount(AccountDto accountDto);
    AccountDto getAccountById(Long id);
    List<AccountDto> getAllAccounts();
    void deleteAccount(Long id);
    AccountDto deposit(Long id, double amount);
    AccountDto updateAccountBalance(Long id, double balance);
    AccountDto withdraw(long id, double amount);
}
