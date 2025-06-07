package com.ysy.aspectjsupport.declaringadvice.dao;

import com.ysy.aspectjsupport.declaringadvice.model.Account;

public interface AccountDao {
    Account findAccountById(String id);
    void updateAccount(Account account);
}
