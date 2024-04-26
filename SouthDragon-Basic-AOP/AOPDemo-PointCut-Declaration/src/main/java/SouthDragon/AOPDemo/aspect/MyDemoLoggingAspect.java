package SouthDragon.AOPDemo.aspect;

import SouthDragon.AOPDemo.Account;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.List;

@Aspect
@Component
@Order(2)
public class MyDemoLoggingAspect {


    @Around("execution(* SouthDragon.AOPDemo.service.*.getFortune(..))")
    public Object arroundGetFortune(ProceedingJoinPoint theProceedingJoinPoint)throws Throwable{

        //print out method we are advising on
        String method = theProceedingJoinPoint.getSignature().toShortString();
        System.out.println("\n===> Executing @Around " + method);
        //get begin timestamp
        long begin = System.currentTimeMillis();
        // now, let's execute the method
        Object result = null;
        try{
            result = theProceedingJoinPoint.proceed();
        }catch (Throwable e){
            //log the exception
            System.out.println(e.getMessage());

            //rethrow exception
            throw e;
        }


        // get end timestamps
        long end = System.currentTimeMillis();
        //compute duration and display it
        long duration = end - begin;
        System.out.println("\n===> Time taken: " + duration / 1000.0 + " seconds");

        return result;
    }

    // after advice
    @After("execution(* SouthDragon.AOPDemo.dao.AccountDAO.findAccounts(..))")
    public void afterFinallyFindAccountAdvice(JoinPoint joinPoint) {
        String method = joinPoint.getSignature().toShortString();
        System.out.println("\n===> Executing @After (finally) " + method);


    }

    // after throwing
    @AfterThrowing(
            pointcut = "execution(* SouthDragon.AOPDemo.dao.AccountDAO.findAccounts(..))",
            throwing = "theExc"
    )
    public void afterThrowingFindAccountsAdvice(JoinPoint joinPoint, Throwable theExc){
        // print out which method we are advising on
        String method = joinPoint.getSignature().toShortString();
        System.out.println("\n===> Executing @AfterThrowing " + method);

        // log the exception
        System.out.println("\n===> Exception is" + theExc);

    }



    // add a new advice for @AfterReturning on the findAccounts method
    @AfterReturning(
            pointcut = "execution(* SouthDragon.AOPDemo.dao.AccountDAO.findAccounts(..))"
            ,returning = "result"
    )
    public void afterReturningFindAccountsAdvice(JoinPoint joinPoint, List<Account> result) {
        // print out which method we are advising on
        String method = joinPoint.getSignature().toShortString();
        System.out.println("\n===> Executing @AfterReturning: " + method);

        // print out the results of the method call

        System.out.println("\n===> result is: " + result);
        // let's post-process the dât ... let's modify

        //convert the account names to uppercase
        convertAccountNamesToUpperCase(result);

        System.out.println("\n===> result is: " + result);

    }

    private void convertAccountNamesToUpperCase(List<Account> result) {
        // loop through accounts
        for (Account account : result) {

            //get uppercase version of name
            String theUpperName = account.getName().toUpperCase();

            // update the name on the account
            account.setName(theUpperName);
        }



    }


    //    call match any method with a package
    @Before("SouthDragon.AOPDemo.aspect.LuvAOPExpressions.forDaoPackageNoGetterSetter()")
    public void beforeAddAccount(JoinPoint theJoinPoint) {

        System.out.println("\n =====> Executing @Before advice on method()");

        // display the method signature
        MethodSignature methodSignature = (MethodSignature) theJoinPoint.getSignature();
        System.out.println("Method Signature: " + methodSignature);

        // display the method arguments

        // get args
        Object[] args = theJoinPoint.getArgs();

        // loop thru args
        for (Object arg : args) {
            System.out.println(arg);

            if (arg instanceof Account) {

                //downcast and print Account specific stuff
                Account theAccount = (Account) arg;
                System.out.println("Account name: "+ theAccount.getName());
                System.out.println("Account level: "+ theAccount.getLevel());

            }
        }
    }

}
