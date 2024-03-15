package SouthDragon.SpringHibernate.JpaCRUD.dao;

import SouthDragon.SpringHibernate.JpaCRUD.entity.Student;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class StudentDAOImpl implements StudentDAO{

//    define for entity manger
    private EntityManager entityManager;


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
}
