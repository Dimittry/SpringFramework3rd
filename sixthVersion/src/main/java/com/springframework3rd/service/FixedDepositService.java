package com.springframework3rd.service;

import com.springframework3rd.common.DependencyResolver;
import com.springframework3rd.common.MyApplicationContext;
import com.springframework3rd.dao.FixedDepositDao;
import com.springframework3rd.dao.IFixedDepositDao;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service(value="fixedDepositService")
@Qualifier("service")
public class FixedDepositService
        implements IFixedDepositService, DependencyResolver {
    private static Logger logger = Logger.getLogger(FixedDepositService.class);
    @Autowired
    @Qualifier(value="myFixedDepositDao")
    private IFixedDepositDao fixedDepositDao;

    public FixedDepositService() {
        logger.info("FixedDepositService constructor invoked.");
    }

    public void setFixedDepositDao(IFixedDepositDao fixedDepositDao) {
        logger.info("setFixedDepositDao invoked.");
        this.fixedDepositDao = fixedDepositDao;
    }

    @Override
    public void resolveDependency(MyApplicationContext myApplicationContext) {
        fixedDepositDao = myApplicationContext.getBean(IFixedDepositDao.class);
    }

    public void run() {
        fixedDepositDao.getDeposit();
    }
}
