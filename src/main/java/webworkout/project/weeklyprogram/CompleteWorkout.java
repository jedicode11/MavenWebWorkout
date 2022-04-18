package webworkout.project.weeklyprogram;

public class CompleteWorkout {
    public static boolean trainingDays(DayOfWeek days) {
        switch(days) {
            case TUE:
            case MON:
            case WED:
            case THU:
            case FRI: return true;
            default: return false;
        }
    }

    public static void main(String[] args) {
        for(DayOfWeek days : DayOfWeek.values()){
            System.out.printf("%s -> Training for Daily Workout = %b%n", days.toString(), trainingDays(days));
        }
        DayOfWeek weekend = DayOfWeek.valueOf("SAT");
        DayOfWeek weekend2 = DayOfWeek.valueOf("SUN");
        System.out.printf("%s [%d] -> Rest Day or Cardio = %b%n", weekend, weekend.ordinal(), trainingDays(weekend));
        System.out.printf("%s [%d] -> Rest Day or Cardio = %b%n", weekend2, weekend2.ordinal(), trainingDays(weekend2));
    }
}
