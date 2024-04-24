package SouthDragon.AOPDemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyDemoLoggingAspect {

    // this is where we add all of our related advices for logging

    // let's start with an @Before advice

//    call only method AccountDAO.addAccount()
//    @Before("execution(public void SouthDragon.AOPDemo.dao.AccountDAOImpl.addAccount())")


//    call any addAccount
//    @Before("execution(public void addAccount())")

//    call method starting with add in any class
//    @Before("execution(public void add*())")

//    call match method with based on Return type
//    @Before("execution(* add*())")

//    call match method with one Parameter
//    @Before("execution(* add*(SouthDragon.AOPDemo.Account))")

//    call match method with one Parameter or more Parameter
//    @Before("execution(* add*(SouthDragon.AOPDemo.Account, ..))")

//    call match method with any Parameter
//    @Before("execution(* add*(..))")  not run error
//TODO:    need to have package in method name

    //    call match any method with a package
    @Before("execution(* SouthDragon.AOPDemo.dao.*.*(..))")
    public void beforeAddAccount(){
        System.out.println("\n =====> Executing @Before advice on method()");
    }
}
