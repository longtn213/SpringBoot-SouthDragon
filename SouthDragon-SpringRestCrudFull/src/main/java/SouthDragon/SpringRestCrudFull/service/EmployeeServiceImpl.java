//package SouthDragon.SpringRestCrudFull.service;
//
//import SouthDragon.SpringRestCrudFull.dao.EmployeeRepository;
//import SouthDragon.SpringRestCrudFull.entity.Employee;
//import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;
//
//import java.util.List;
//import java.util.Optional;
//
//@Service
//public class EmployeeServiceImpl implements EmployeeService{
//
//    private EmployeeRepository employeeRepository;
//
//    public EmployeeServiceImpl(EmployeeRepository theEmployeeDAO){
//        employeeRepository= theEmployeeDAO;
//    }
//    @Override
//    public List<Employee> findAll() {
//
//        return employeeRepository.findAll();
//    }
//
//    @Override
//    public Employee findById(int theId) {
//        Optional<Employee> result = employeeRepository.findById(theId);
//
//        Employee theEmployee = null;
//
//        if (result.isPresent()){
//            theEmployee = result.get();
//        }else{
////            we didn't find the employee
//            throw new RuntimeException("Did not find employee id - " + theId);
//        }
//
//        return theEmployee;
//    }
//    @Override
//    public Employee save(Employee employee) {
//        return employeeRepository.save(employee);
//    }
//
//    @Override
//    public void deleteById(int theId) {
//        employeeRepository.deleteById(theId);
//    }
//}
