package SpringCore.SouthDragonSpringCore.Class;

import SpringCore.SouthDragonSpringCore.Interface.Coach;

public class SwimCoach implements Coach {

    public SwimCoach(){
        System.out.println("In Constructor: " + getClass().getSimpleName());
    }

    @Override
    public String getDailyWorkout() {
        return "Swim 100m as a warm up";
    }
}
