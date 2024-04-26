package SouthDragon.SpringMVCCrudFull.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

@Aspect
@Component
public class DemoLoggingAspect {

    //set up logger
    private final Logger myLogger = Logger.getLogger(getClass().getName());

    //setup pointcut declarations

    @Pointcut("execution(* SouthDragon.SpringMVCCrudFull.controller.*.*(..))")
    private void forControllerPackage(){
        //do the same for service and dao
    }

    @Pointcut("execution(* SouthDragon.SpringMVCCrudFull.service.*.*(..))")
    private void forServicePackage(){
        //do the same for service and dao
    }

    @Pointcut("execution(* SouthDragon.SpringMVCCrudFull.dao.*.*(..))")
    private void forDaoPackage(){
        //do the same for service and dao
    }

    @Pointcut("forControllerPackage() || forServicePackage() || forDaoPackage()")
    private void forAppFlow(){}

    @Before("forAppFlow()")
    public void before(JoinPoint joinPoint){
        // display method we are calling
        String theMethodName = joinPoint.getSignature().getName();
        myLogger.info("==> in @Before: calling method: " + theMethodName);

        // display the arguments to the method

        //get the arguments
        Object[] args = joinPoint.getArgs();

        //loop thru and display args
        for (Object arg : args) {
            myLogger.info("===> arguments: " + arg);
        }
    }

    //add @AfterReturning advice
    @AfterReturning(
            pointcut = "forAppFlow()",
            returning = "result"
    )
    public void afterReturning(JoinPoint joinPoint, Object result){
        // display method we are returning from
        String theMethodName = joinPoint.getSignature().getName();
        myLogger.info("==> in @AfterReturning: calling method: " + theMethodName);

        // display data returned
        myLogger.info("==> result: " + result);
    }

}
