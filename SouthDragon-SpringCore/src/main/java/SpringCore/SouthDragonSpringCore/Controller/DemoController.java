package SpringCore.SouthDragonSpringCore.Controller;

import SpringCore.SouthDragonSpringCore.Interface.Coach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

//    define a private field for the dependency
    private Coach myCoach;
    private Coach anotherCoach;

//    define a constructor for dependency injection
//    use Qualifier to inject specific bean you want
//    use Primary to mark one of the bean -> Only use one Primary
//    if you mix Qualifier and Primary -> Qualifier has higher priority -> recommended use Qualifier
    @Autowired
    public DemoController(@Qualifier("cricketCoach") Coach theCoach,
                          @Qualifier("cricketCoach") Coach theAnotherCoach){
        System.out.println("In constructor : " + getClass().getSimpleName());
        myCoach = theCoach;
        anotherCoach = theAnotherCoach;
    }

//    define a setter injection
//    @Autowired
//    public void setCoach(Coach theCoach){
//        myCoach = theCoach;
//    }
    @GetMapping("/dailyworkout")
    public String getDailyWorkout(){
        return myCoach.getDailyWorkout();
    }

    @GetMapping("/check")
    public String check(){
        return "Comparing beans : myCoach == anotherCoach ," + (myCoach == anotherCoach);
    }
}
