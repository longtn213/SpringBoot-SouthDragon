package SouthDragon.SpringHibernate.JpaCRUD.dao;

import SouthDragon.SpringHibernate.JpaCRUD.entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class StudentDAOImpl implements StudentDAO{

//    define for entity manger
    private final EntityManager entityManager;


//    inject entity manager using constructor injection
    @Autowired
    public StudentDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    //    implement save method
    @Override
    @Transactional
    public void save(Student theStudent) {
        entityManager.persist(theStudent);
    }

    @Override
    public Student finStudentByID(Integer id) {
        return entityManager.find(Student.class,id);
    }

    @Override
    public List<Student> findAll() {
//        create query
        TypedQuery<Student> theTypedQuery = entityManager.createQuery("FROM Student order by lastName desc", Student.class);

//        return query results

        return theTypedQuery.getResultList();
    }

    @Override
    public List<Student> findbyLastName(String theLastName) {
//        create query
        TypedQuery<Student> theTypedQuery = entityManager.createQuery("FROM Student WHERE lastName=:theData", Student.class);

//        set query parameters

        theTypedQuery.setParameter("theData", theLastName);
//        return query resutls

        return theTypedQuery.getResultList();
    }

    @Override
    @Transactional
    public void update(Student theStudent) {
        entityManager.merge(theStudent);
    }

    @Override
    @Transactional
    public void deleteStudent(Integer id) {
//        retrieve the student
        Student myStudent = entityManager.find(Student.class, id);
//        delete student
        entityManager.remove(myStudent);
    }

    @Override
    @Transactional
    public int deleteAllStudent() {
        return entityManager.createQuery("DELETE from Student ").executeUpdate();
    }
}
