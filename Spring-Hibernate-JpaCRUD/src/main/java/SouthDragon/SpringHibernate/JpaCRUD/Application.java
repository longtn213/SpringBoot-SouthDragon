package SouthDragon.SpringHibernate.JpaCRUD;

import SouthDragon.SpringHibernate.JpaCRUD.dao.StudentDAO;
import SouthDragon.SpringHibernate.JpaCRUD.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO){
		return runner -> {
//			createStudent(studentDAO);

			createMultipleStudent(studentDAO);

//			readStudent(studentDAO);

//          queryForStudents(studentDAO);

//            queryForStudentsByLastName(studentDAO);

//            updateStudent(studentDAO);

//            deleteStudent(studentDAO);

//            deleteAllStudent(studentDAO);
		};
	}

    private void deleteAllStudent(StudentDAO studentDAO) {

        System.out.println("Deleting all students");
        int numRowsDeleted = studentDAO.deleteAllStudent();
        System.out.println("deleted row count: " +numRowsDeleted);
    }

    private void deleteStudent(StudentDAO studentDAO) {
        int studentId = 3;
        System.out.println("Deleting student id: "+ studentId);
        studentDAO.deleteStudent(studentId);
    }

    private void updateStudent(StudentDAO studentDAO) {
//        retrieve student based on the id: primary key
        int studentId = 2;
        System.out.println("Getting student with id : "+ studentId);
        Student myStudent = studentDAO.finStudentByID(studentId);

//        change firstname to "Scooby"
        System.out.println("updateing student ...");
        myStudent.setFirstName("John");

//        update the student
        studentDAO.update(myStudent);

//        display the updated student
        System.out.println("Updated student: " + myStudent);
    }

    private void queryForStudentsByLastName(StudentDAO studentDAO) {
//        get a list of students
        List<Student> theStudents = studentDAO.findbyLastName("a");

//        display list of students
        for (Student temStudent : theStudents){
            System.out.println(temStudent);
        }
    }

    private void queryForStudents(StudentDAO studentDAO){

//        get a list of students
        List<Student> theStudents = studentDAO.findAll();

//        display list of students
        for (Student temStudent : theStudents){
            System.out.println(temStudent);
        }
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
