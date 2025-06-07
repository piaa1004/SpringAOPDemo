package com.ysy.aspectj.declaringadvice.dao;

import com.ysy.aspectj.declaringadvice.model.Account;

public interface AccountDao {
    Account findAccountById(String id);
    void updateAccount(Account account);
}
