package SouthDragon.AOPDemo.dao;

import SouthDragon.AOPDemo.Account;

public interface AccountDAO {

    void addAccount(Account theAccount, boolean vipFlag);

    boolean doWork();
}
