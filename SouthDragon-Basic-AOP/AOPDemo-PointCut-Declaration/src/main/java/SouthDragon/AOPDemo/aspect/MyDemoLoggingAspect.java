package SouthDragon.AOPDemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyDemoLoggingAspect {

    // this is where we add all of our related advices for logging

    // let's start with an @Before advice

    //    create pointcut to use
    @Pointcut("execution(* SouthDragon.AOPDemo.dao.*.*(..))")
    public void forDaoPackage(){}
    //    call match any method with a package
    @Before("forDaoPackage()")
    public void beforeAddAccount(){
        System.out.println("\n =====> Executing @Before advice on method()");
    }

    //    call match any method with a package
    @Before("forDaoPackage()")
    public void performApiAnalytics(){
        System.out.println("\n =====> Performing Api Analytics");
    }
}
