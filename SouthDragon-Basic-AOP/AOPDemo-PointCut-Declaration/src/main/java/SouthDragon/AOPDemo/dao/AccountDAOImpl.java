package SouthDragon.AOPDemo.dao;

import SouthDragon.AOPDemo.Account;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class AccountDAOImpl implements AccountDAO{

    private String name;

    private String serviceCode;

    @Override
    public List<Account> findAccounts() {
        return findAccounts(false);
    }

    @Override
    public List<Account> findAccounts(boolean tripWire) {

        // for academic purposes ... simulate an exception

        if(tripWire){
            throw new RuntimeException("No soup for you!!");
        }

        List<Account> myAccounts = new ArrayList<Account>();

        //create sample accounts
        Account temp1 = new Account("Long","2");
        Account temp2 = new Account("QA","4");
        Account temp3 = new Account("Luca","5");

        myAccounts.add(temp1);
        myAccounts.add(temp2);
        myAccounts.add(temp3);
        //add them to our accounts list
        return myAccounts;
    }

    @Override
    public void addAccount(Account theAccount,boolean vipFlag) {
        System.out.println(getClass() +" Doing MY DB work: ADDING AN ACCOUNT");
    }

    @Override
    public boolean doWork() {
        System.out.println(getClass() +" doWork()");
        return false;
    }

    public String getName() {
        System.out.println(getClass() +" getName()");

        return name;
    }

    public void setName(String name) {
        System.out.println(getClass() +" setName()");
        this.name = name;
    }

    public String getServiceCode() {
        System.out.println(getClass() +" getServiceCode()");

        return serviceCode;
    }

    public void setServiceCode(String serviceCode) {
        System.out.println(getClass() +" setServiceCode()");

        this.serviceCode = serviceCode;
    }
}
