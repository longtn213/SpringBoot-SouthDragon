package SouthDragon.SpringBootJpaAdvancedMapping.dao;

import SouthDragon.SpringBootJpaAdvancedMapping.entity.Course;
import SouthDragon.SpringBootJpaAdvancedMapping.entity.Instructor;
import SouthDragon.SpringBootJpaAdvancedMapping.entity.InstructorDetail;
import SouthDragon.SpringBootJpaAdvancedMapping.entity.Student;

import java.util.List;

public interface AppDAO {

    void save(Instructor theInstructor);

    Instructor findInstructorById(int theId);

    void deleteInstructorById(int theId);

    InstructorDetail findInstructorDetailById(int theId);

    void deleteInstructorDetailById(int theId);

    List<Course> findCoursesByInstructorId(int theId);

    Instructor findInstructorByJoinFetch(int theId);

    void update (Instructor tempInstructor);

    void updateCourse(Course tempCourse);

    Course findCourseById(int theId);

    void deleteCourseById(int theId);

    void save(Course course);

    Course findCourseAndReviewsByCourseId(int theId);

    Course findCourseAndStudentByCourseId(int theId);

    Student findStudentAndCourseByStudentId(int theId);

    void update(Student theStudent);

    void deleteStudentById(int theId);

}