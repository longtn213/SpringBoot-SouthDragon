package SouthDragon.SpringHibernate.JpaCRUD.dao;

import SouthDragon.SpringHibernate.JpaCRUD.entity.Student;

import java.util.List;

public interface StudentDAO {

    void save(Student theStudent);

    Student finStudentByID(Integer id);

    List<Student> findAll();

    List<Student> findbyLastName(String theLastName);

    void update(Student theStudent);

    void deleteStudent(Integer id);

    int deleteAllStudent();
}
