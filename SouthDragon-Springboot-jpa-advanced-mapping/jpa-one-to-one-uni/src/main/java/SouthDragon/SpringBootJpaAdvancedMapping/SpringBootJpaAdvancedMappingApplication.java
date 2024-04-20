package SouthDragon.SpringBootJpaAdvancedMapping;

import SouthDragon.SpringBootJpaAdvancedMapping.dao.AppDAO;
import SouthDragon.SpringBootJpaAdvancedMapping.entity.Instructor;
import SouthDragon.SpringBootJpaAdvancedMapping.entity.InstructorDetail;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringBootJpaAdvancedMappingApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootJpaAdvancedMappingApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(AppDAO appDAO){
		return runner ->{
//			createInstructor(appDAO);
//			findInstructor(appDAO);
			deleteInstructor(appDAO);
		};
	}

	private void deleteInstructor(AppDAO appDAO) {
		int theId = 1;
		System.out.println("Deleting the id :" + theId);

		appDAO.deleteInstructorById(theId);

		System.out.println("Done!");

	}

	private void findInstructor(AppDAO appDAO) {
		int theId = 1;
		System.out.println("Finding instructor id: " + theId);

		Instructor tempInstructor = appDAO.findInstructorById(theId);

		System.out.println("tempInstructor: "+ tempInstructor);
		System.out.println("the associate instructorDetail only:" + tempInstructor.getInstructorDetail());
	}

	private void createInstructor(AppDAO appDAO) {
/*
		// create the instructor
		Instructor tempInstructor = new Instructor("long","nam","longtran@gmail.com");
		// create the intructor-detail
		InstructorDetail temInstructorDetail = new InstructorDetail("longtn", "helloworld");
*/
		// create the instructor
		Instructor tempInstructor = new Instructor("quynh","anh","longtra123n@gmail.com");
		// create the intructor-detail
		InstructorDetail temInstructorDetail = new InstructorDetail("anh123", "helloworld123");
//		accociate the objects
		tempInstructor.setInstructorDetail(temInstructorDetail);

//		save the instructor
		System.out.println("Saving instructor :" + tempInstructor);
		appDAO.save(tempInstructor);

		System.out.println("Done!");
	}

}
