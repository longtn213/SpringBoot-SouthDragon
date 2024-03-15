package SouthDragon.SpringHibernate.JpaCRUD;

import SouthDragon.SpringHibernate.JpaCRUD.dao.StudentDAO;
import SouthDragon.SpringHibernate.JpaCRUD.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO){
		return runner -> {
//			createStudent(studentDAO);
//			createMultipleStudent(studentDAO);
			readStudent(studentDAO);
		};
	}

	private void readStudent(StudentDAO studentDAO) {
//		create a student object
		System.out.println("Creating the new student object...");
		Student tempStudent = new Student("Longdepzai", " tran", "longdepzai123@gmail.com");

//		save the student
		System.out.println("Saving the student...");
		studentDAO.save(tempStudent);

//		display id of the saved student
		int theId =tempStudent.getId();
		System.out.println("saved student: Generated id: "+ tempStudent.getId());

//		retrieve student based on the id :primary key
		System.out.println("Retrieve student with id : "+ theId);
		Student myStudent = studentDAO.finStudentByID(theId);

//		display student
		System.out.println("Found the student: " + myStudent);
	}

	private void createMultipleStudent(StudentDAO studentDAO) {
//		create multiple students
		System.out.println("Creating the 3 student object...");
		Student tempStudent1 = new Student("Long1", " tran", "long123@gmail.com");
		Student tempStudent2 = new Student("Long2", " tran", "long123@gmail.com");
		Student tempStudent3 = new Student("Long3", " tran", "long123@gmail.com");
//		save the student objects
		System.out.println("Saving the students...");
		studentDAO.save(tempStudent1);
		studentDAO.save(tempStudent2);
		studentDAO.save(tempStudent3);
	}

	private void createStudent(StudentDAO studentDAO) {
//		create the student object
		System.out.println("Creating the new student object...");
		Student tempStudent = new Student("Long", " tran", "long123@gmail.com");

//		save the student object
		System.out.println("Saving the student...");
		studentDAO.save(tempStudent);

//		display id of the saved student
		System.out.println("saved student: Generated id: "+ tempStudent.getId());
	}


}
