package SouthDragon.SpringBootJpaAdvancedMapping;

import SouthDragon.SpringBootJpaAdvancedMapping.dao.AppDAO;
import SouthDragon.SpringBootJpaAdvancedMapping.entity.Course;
import SouthDragon.SpringBootJpaAdvancedMapping.entity.Instructor;
import SouthDragon.SpringBootJpaAdvancedMapping.entity.InstructorDetail;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class SpringBootJpaAdvancedMappingApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootJpaAdvancedMappingApplication.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(AppDAO appDAO) {
        return runner -> {
//			findInstructor(appDAO);
//			deleteInstructor(appDAO);
//			findInstructorDetail(appDAO);
//			deleteInstructorDetail(appDAO);

//			createInstructorWithCourses(appDAO);
//			findInstructorWithCourses(appDAO);
//			findCoursesForInstructor(appDAO);
//			findInstructorWithCoursesJoinFetch(appDAO);
//			updateInstructor(appDAO);
//			updateCourses(appDAO);
            deleteCourse(appDAO);
        };
    }

    private void deleteCourse(AppDAO appDAO) {
        int theId = 1;
        System.out.println("delete");
        appDAO.deleteCourseById(theId);
        System.out.println("Done");
    }

    private void updateCourses(AppDAO appDAO) {
        int theId = 1;

//		find course
        Course tempCourse = appDAO.findCourseById(theId);

//		update Course
        System.out.println("Update");
        tempCourse.setTitle("Hello world 123");

        appDAO.updateCourse(tempCourse);
        System.out.println("Done");
    }

    private void updateInstructor(AppDAO appDAO) {
        int theId = 1;

//		find the instructor
        Instructor tempInstructor = appDAO.findInstructorById(theId);

//		Update the instructor
        System.out.println("Update");
        tempInstructor.setLastName("TESTer");

        appDAO.update(tempInstructor);

        System.out.println("Done");
    }

    private void findInstructorWithCoursesJoinFetch(AppDAO appDAO) {

        int theId = 1;

        System.out.println("Finding the Instructor: " + theId);
        Instructor tempInstructor = appDAO.findInstructorByJoinFetch(theId);

        System.out.println("tempInstructor: " + tempInstructor);

        System.out.println("the associated courses: " + tempInstructor.getCourses());
        System.out.println("DONE!");
    }

    private void findCoursesForInstructor(AppDAO appDAO) {
        int theId = 1;
        System.out.println("Finding instructor id: " + theId);

        Instructor tempInstructor = appDAO.findInstructorById(theId);

        System.out.println("tempInstructor: " + tempInstructor);

//		find courses for instructors
        System.out.println("Finding courses for instructor id: " + theId);
        List<Course> courses = appDAO.findCoursesByInstructorId(theId);

        tempInstructor.setCourses(courses);

        System.out.println("the associate courses: " + tempInstructor.getCourses());
        System.out.println("Done!");

    }

    private void findInstructorWithCourses(AppDAO appDAO) {

        int theId = 1;
        System.out.println("Finding instructor id: " + theId);

        Instructor tempInstructor = appDAO.findInstructorById(theId);
        System.out.println("tempInstructor: " + tempInstructor);
        System.out.println("the associate courses: " + tempInstructor.getCourses());

        System.out.println("Done!");
    }

    private void createInstructorWithCourses(AppDAO appDAO) {
        // create the instructor
        Instructor tempInstructor = new Instructor("long", "tran", "longtra123n@gmail.com");
        // create the intructor-detail
        InstructorDetail temInstructorDetail = new InstructorDetail("anh123", "helloworld123");
//		accociate the objects
        tempInstructor.setInstructorDetail(temInstructorDetail);

//		create some course
        Course tempCourse1 = new Course("Air Guitar");
        Course tempCourse2 = new Course("Air Video Game");

//		add courses to instructor
        tempInstructor.add(tempCourse1);
        tempInstructor.add(tempCourse2);

        System.out.println("Saving instructor: " + tempInstructor);
        System.out.println("The courses:" + tempInstructor.getCourses());

        appDAO.save(tempInstructor);

    }

    private void deleteInstructorDetail(AppDAO appDAO) {
        int theId = 3;
        System.out.println("Deleting instructor detail: " + theId);


        appDAO.deleteInstructorDetailById(theId);
        System.out.println("Done!");
    }

    private void findInstructorDetail(AppDAO appDAO) {
        int theId = 2;
        System.out.println("Finding the id :" + theId);

        InstructorDetail tempInstructorDetail = appDAO.findInstructorDetailById(theId);

        System.out.println("tempInstructorDetail: " + tempInstructorDetail);
        System.out.println("the associate Instructor only:" + tempInstructorDetail.getInstructor());

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

        System.out.println("tempInstructor: " + tempInstructor);
        System.out.println("the associate instructorDetail only:" + tempInstructor.getInstructorDetail());
    }


}
