package SouthDragon.AOPDemo.dao;

import org.springframework.stereotype.Repository;

@Repository
public class MemberShipDAOImpl implements MemberShipDAO{
    @Override
    public boolean addSillyAccount() {
        System.out.println(getClass() +" Doing MY DB work: ADDING AN Silly MEMBERSHIP ACCOUNT");
        return true;
    }

    @Override
    public void gotoSleep() {
        System.out.println(getClass() +" GO to sleep");
    }
}
