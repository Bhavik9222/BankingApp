package com.bankingApp.Mapper;

import com.bankingApp.Dto.AccountDto;
import com.bankingApp.Entity.Account;

public class AccountMapper {

    public static AccountDto mapToAccountDto(Account account) {
        return new AccountDto(account.getId(), account.getAccountHolderName(), account.getBalance());
    }

    public static Account mapToAccount(AccountDto accountDto) {
        return new Account(accountDto.getId(), accountDto.getAccountHolderName(), accountDto.getBalance());
    }
}

