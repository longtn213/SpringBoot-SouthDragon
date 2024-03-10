package SpringCore.SouthDragonSpringCore.Class;

import SpringCore.SouthDragonSpringCore.Interface.Coach;
import org.springframework.stereotype.Component;

@Component
public class TennisCoach implements Coach {
    @Override
    public String getDailyWorkout() {
        return "Tennis ";
    }
}
