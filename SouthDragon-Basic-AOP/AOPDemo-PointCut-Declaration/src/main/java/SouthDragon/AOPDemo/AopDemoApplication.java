package SouthDragon.AOPDemo;

import SouthDragon.AOPDemo.dao.AccountDAO;
import SouthDragon.AOPDemo.dao.MemberShipDAO;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class AopDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(AopDemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner (AccountDAO accountDAO, MemberShipDAO memberShipDAO){
		return runner ->{
			demoTheBeforeAccount(accountDAO,memberShipDAO);
		};
	}

	private void demoTheBeforeAccount(AccountDAO accountDAO, MemberShipDAO memberShipDAO) {

		Account myAccount = new Account();
		myAccount.setName("Long");
		myAccount.setLevel("Professional");
		// call the business method
		accountDAO.addAccount(myAccount,true);
		accountDAO.doWork();

//		call the accountDAO getter/setter
		accountDAO.setName("foobar");
		accountDAO.setServiceCode("sivler");

		String name = accountDAO.getName();
		String code = accountDAO.getServiceCode();


		System.out.println("\n");
//		call the membership dao
		memberShipDAO.addSillyAccount();
		memberShipDAO.gotoSleep();

	}
}
