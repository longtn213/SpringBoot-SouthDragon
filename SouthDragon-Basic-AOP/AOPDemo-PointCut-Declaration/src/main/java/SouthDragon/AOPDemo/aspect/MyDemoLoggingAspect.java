package SouthDragon.AOPDemo.aspect;

import SouthDragon.AOPDemo.Account;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(2)
public class MyDemoLoggingAspect {

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
