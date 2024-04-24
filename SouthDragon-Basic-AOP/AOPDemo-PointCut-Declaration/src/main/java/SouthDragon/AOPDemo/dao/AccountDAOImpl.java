package SouthDragon.AOPDemo.dao;

import SouthDragon.AOPDemo.Account;
import org.springframework.stereotype.Repository;

@Repository
public class AccountDAOImpl implements AccountDAO{
    @Override
    public void addAccount(Account theAccount,boolean vipFlag) {
        System.out.println(getClass() +" Doing MY DB work: ADDING AN ACCOUNT");
    }

    @Override
    public boolean doWork() {
        System.out.println(getClass() +" doWork()");
        return false;
    }
}
