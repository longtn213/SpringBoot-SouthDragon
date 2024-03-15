package SouthDragon.SpringHibernate.JpaCRUD.dao;

import SouthDragon.SpringHibernate.JpaCRUD.entity.Student;

public interface StudentDAO {

    void save(Student theStudent);

    Student finStudentByID(Integer id);
}
