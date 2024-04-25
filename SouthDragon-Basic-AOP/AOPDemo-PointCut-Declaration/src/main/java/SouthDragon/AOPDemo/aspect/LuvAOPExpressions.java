package SouthDragon.AOPDemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect // only need when have @before 
@Component
public class LuvAOPExpressions {

    //    create pointcut to use
    @Pointcut("execution(* SouthDragon.AOPDemo.dao.*.*(..))")
    public void forDaoPackage() {
    }

    //    create a pointcut for getter
    @Pointcut("execution(* SouthDragon.AOPDemo.dao.*.get*(..))")
    public void getter() {
    }

    ;

    //    create a pointcut for setter
    @Pointcut("execution(* SouthDragon.AOPDemo.dao.*.set*(..))")
    public void setter() {
    }

    ;

    //    create a pointcut include package exclude getter/setter
    @Pointcut("forDaoPackage() && !(getter() || setter())")
    public void forDaoPackageNoGetterSetter() {}
}
