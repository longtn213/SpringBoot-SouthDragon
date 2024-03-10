package SpringCore.SouthDragonSpringCore.Class;

import SpringCore.SouthDragonSpringCore.Interface.Coach;
import org.springframework.stereotype.Component;

@Component
public class BaseballCoach implements Coach {
    @Override
    public String getDailyWorkout() {
        return "Baseball";
    }
}
