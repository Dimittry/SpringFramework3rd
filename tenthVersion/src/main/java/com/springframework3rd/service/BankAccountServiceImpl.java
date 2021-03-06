package com.springframework3rd.service;

import com.springframework3rd.dao.BankAccountDao;
import com.springframework3rd.domain.BankAccountDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service(value = "bankAccountService")
public class BankAccountServiceImpl implements BankAccountService {

    @Autowired
    private BankAccountDao bankAccountDao;

    @Override
    public int createBankAccount(BankAccountDetails bankAccountDetails) {
        return bankAccountDao.createBankAccount(bankAccountDetails);
    }

}
