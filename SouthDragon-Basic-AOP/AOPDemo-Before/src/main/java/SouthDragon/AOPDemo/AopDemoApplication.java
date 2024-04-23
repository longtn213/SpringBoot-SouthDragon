package SouthDragon.AOPDemo;

import SouthDragon.AOPDemo.dao.AccountDAO;
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
	public CommandLineRunner commandLineRunner (AccountDAO accountDAO){
		return runner ->{
			demoTheBeforeAccount(accountDAO);
		};
	}

	private void demoTheBeforeAccount(AccountDAO accountDAO) {

		// call the business method
		accountDAO.addAccount();

		// do it again
		System.out.println("\n let's call it again \n");
		accountDAO.addAccount();
	}
}
