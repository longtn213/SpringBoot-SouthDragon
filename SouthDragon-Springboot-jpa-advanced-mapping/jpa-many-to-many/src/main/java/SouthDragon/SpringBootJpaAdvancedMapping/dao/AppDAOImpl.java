package SouthDragon.SpringBootJpaAdvancedMapping.dao;

import SouthDragon.SpringBootJpaAdvancedMapping.entity.Course;
import SouthDragon.SpringBootJpaAdvancedMapping.entity.Instructor;
import SouthDragon.SpringBootJpaAdvancedMapping.entity.InstructorDetail;
import SouthDragon.SpringBootJpaAdvancedMapping.entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class AppDAOImpl implements AppDAO {

    //    define field for entity manager
    private EntityManager entityManager;

    //    inject entity manager using constructor injection
    @Autowired
    public AppDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    @Transactional
    public void save(Instructor theInstructor) {
        entityManager.persist(theInstructor);
    }

    @Override
    public Instructor findInstructorById(int theId) {
        return entityManager.find(Instructor.class, theId);
    }

    @Override
    @Transactional
    public void deleteInstructorById(int theId) {

//        retrieve the instructor
        Instructor tempInstructor = entityManager.find(Instructor.class, theId);

//      get the courses
        List<Course> courses = tempInstructor.getCourses();

//        break association of all courses for the instructor
        for (Course tempCourse : courses) {
            tempCourse.setInstructor(null);
        }

//        delete the instructor
        entityManager.remove(tempInstructor);
    }

    @Override
    public InstructorDetail findInstructorDetailById(int theId) {
        return entityManager.find(InstructorDetail.class, theId);
    }

    @Override
    @Transactional
    public void deleteInstructorDetailById(int theId) {

        InstructorDetail tempInstructorDetail = entityManager.find(InstructorDetail.class, theId);

        tempInstructorDetail.getInstructor().setInstructorDetail(null);

        entityManager.remove(tempInstructorDetail);
    }

    @Override
    public List<Course> findCoursesByInstructorId(int theId) {
//        create query
        TypedQuery<Course> query = entityManager.createQuery(
                "from Course where instructor.id=:data", Course.class);
        query.setParameter("data", theId);

//        execute query
        List<Course> courses = query.getResultList();

        return courses;

    }

    @Override
    public Instructor findInstructorByJoinFetch(int theId) {
//        create query
        TypedQuery<Instructor> query = entityManager.createQuery(
                "select i from Instructor i "
                        + "join fetch i.courses "
                        + "join fetch i.instructorDetail "
                        + "where i.id = :data ", Instructor.class);
        query.setParameter("data", theId);

//        execute query
        Instructor instructor = query.getSingleResult();

        return instructor;
    }

    @Override
    @Transactional
    public void update(Instructor tempInstructor) {
        entityManager.merge(tempInstructor);
    }

    @Override
    @Transactional
    public void updateCourse(Course tempCourse) {
        entityManager.merge(tempCourse);
    }

    @Override
    public Course findCourseById(int theId) {
        return entityManager.find(Course.class, theId);
    }

    @Override
    @Transactional
    public void deleteCourseById(int theId) {
        Course course = entityManager.find(Course.class, theId);

//        delete course
        entityManager.remove(course);
    }

    @Override
    @Transactional
    public void save(Course course) {
        entityManager.persist(course);
    }

    @Override
    public Course findCourseAndReviewsByCourseId(int theId) {
//        create query
        TypedQuery<Course> query = entityManager.createQuery(
                "select c from Course c " +
                        "Join fetch c.reviews " +
                        "where c.id=:data", Course.class);
        query.setParameter("data", theId);

//        execute query
        Course course = query.getSingleResult();

        return course;

    }

    @Override
    public Course findCourseAndStudentByCourseId(int theId) {
//        create query
        TypedQuery<Course> query = entityManager.createQuery(
                "select c from Course c " +
                        "JOIN fetch c.students " +
                        "where c.id=:data",Course.class);
        query.setParameter("data", theId);

//        execute query
        Course course = query.getSingleResult();

        return course;
    }

    @Override
    public Student findStudentAndCourseByStudentId(int theId) {
        //        create query
        TypedQuery<Student> query = entityManager.createQuery(
                "select s from Student s " +
                        "JOIN fetch s.courses " +
                        "where s.id=:data",Student.class);
        query.setParameter("data", theId);

//        execute query
        Student student = query.getSingleResult();

        return student;
    }

    @Override
    @Transactional
    public void update(Student theStudent) {
        entityManager.merge(theStudent);
    }

    @Override
    @Transactional
    public void deleteStudentById(int theId) {
        Student tempStudent = entityManager.find(Student.class,theId);

        entityManager.remove(tempStudent);
    }

}
