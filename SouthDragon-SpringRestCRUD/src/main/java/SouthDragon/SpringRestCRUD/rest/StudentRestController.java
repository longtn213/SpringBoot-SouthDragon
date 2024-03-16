package SouthDragon.SpringRestCRUD.rest;

import SouthDragon.SpringRestCRUD.entity.Student;
import jakarta.annotation.PostConstruct;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentRestController {

    private List<Student> theStudents;

    @PostConstruct
    void loadData(){
        theStudents = new ArrayList<>();

        theStudents.add(new Student("long","tran"));
        theStudents.add(new Student("phuong","hai"));
        theStudents.add(new Student("hue","thi"));
    }

//    endpoint "/students " - return a list of students
    @GetMapping("/students")
    public List<Student> getStudents(){


        return theStudents;
    }

//    endpoint "/students/{studentId} - return student at index
    @GetMapping("/student/{studentId}")
    public Student getStudentAtIndex(@PathVariable int studentId){

//      Check the studentId again in the list
        if((studentId >theStudents.size() || studentId < 0)){
            throw new StudentNotFoundException("Student id not found - "+ studentId);
        }

        return theStudents.get(studentId);
    }

}
