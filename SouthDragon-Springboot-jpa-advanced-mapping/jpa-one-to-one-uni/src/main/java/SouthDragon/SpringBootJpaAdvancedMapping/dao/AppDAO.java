package SouthDragon.SpringBootJpaAdvancedMapping.dao;

import SouthDragon.SpringBootJpaAdvancedMapping.entity.Instructor;

public interface AppDAO {

    void save(Instructor theInstructor);

    Instructor findInstructorById(int theId);

    void deleteInstructorById(int theId);
}
