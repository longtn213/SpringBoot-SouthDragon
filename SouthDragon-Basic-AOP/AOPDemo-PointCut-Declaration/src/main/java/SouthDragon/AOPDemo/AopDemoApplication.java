package SouthDragon.AOPDemo;

import SouthDragon.AOPDemo.dao.AccountDAO;
import SouthDragon.AOPDemo.dao.MemberShipDAO;
import SouthDragon.AOPDemo.service.TrafficForTuneService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class AopDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(AopDemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner (AccountDAO accountDAO,
												MemberShipDAO memberShipDAO,
												TrafficForTuneService trafficForTuneService){
		return runner ->{
//			demoTheBeforeAccount(accountDAO,memberShipDAO);
//			demoTheAfterReturningAdvice(accountDAO);
//			demoTheAfterThrowingAdvice(accountDAO);

//			demoTheAfterAdvice(accountDAO);
//			demoTheAroundAdvice(trafficForTuneService);
//			demoTheAroundAdviceHandleException(trafficForTuneService);
			demoTheAroundAdviceReThrowException(trafficForTuneService);
		};
	}

	private void demoTheAroundAdviceReThrowException(TrafficForTuneService trafficForTuneService) {

		System.out.println("\n Main Program: demoTheAroundAdviceReThrowException");

		System.out.println("Calling getFortune");

		boolean tripWire = true;
		String data = trafficForTuneService.getFortune(tripWire);

		System.out.println("\nMy fortune: " + data);

		System.out.println("Finished");

	}

	private void demoTheAroundAdviceHandleException(TrafficForTuneService trafficForTuneService) {

		System.out.println("\n Main Program: demoTheAroundAdviceHandleException");

		System.out.println("Calling getFortune");

		boolean tripWire = true;
		String data = trafficForTuneService.getFortune(tripWire);

		System.out.println("\nMy fortune: " + data);

		System.out.println("Finished");
	}

	private void demoTheAroundAdvice(TrafficForTuneService trafficForTuneService) {
		System.out.println("\n Main Program: demoTheAroundAdvice");

		System.out.println("Calling getFortune");

		String data = trafficForTuneService.getFortune();

		System.out.println("\nMy fortune: " + data);

		System.out.println("Finished");
	}

	private void demoTheAfterAdvice(AccountDAO accountDAO) {

//		//call method to find accounts
		List<Account> theAccounts = null;
		try{
			// add a boolean flag to simulate exceptions
			boolean tripWire = true;
			accountDAO.findAccounts(tripWire);

		} catch (Exception e){
			System.out.println("\n\n Main Program: ... caught exception: " + e);
		}
		//display the accounts
		System.out.println("\n\n Main program: demoTheAfterReturningAdvice");
		System.out.println("----");
		System.out.println(theAccounts);
		System.out.println("\n");

	}

	private void demoTheAfterThrowingAdvice(AccountDAO accountDAO) {
		List<Account> theAccounts = null;
		try{
			// add a boolean flag to simulate exceptions
			boolean tripWire = true;
			accountDAO.findAccounts(tripWire);

		} catch (Exception e){
			System.out.println("\n\n Main Program: ... caught exception: " + e);
		}
		//display the accounts
		System.out.println("\n\n Main program: demoTheAfterReturningAdvice");
		System.out.println("----");
		System.out.println(theAccounts);
		System.out.println("\n");
	}

	private void demoTheAfterReturningAdvice(AccountDAO accountDAO) {

		List<Account> theAccounts = accountDAO.findAccounts();

		//display the accounts
		System.out.println("\n\n Main program: demoTheAfterReturningAdvice");
		System.out.println("----");
		System.out.println(theAccounts);
		System.out.println("\n");
	}

	private void demoTheBeforeAccount(AccountDAO accountDAO, MemberShipDAO memberShipDAO) {

		Account myAccount = new Account("Long" , " hai");
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
