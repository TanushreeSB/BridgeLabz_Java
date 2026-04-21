public class EmpWageBuilder {

    public static final int IS_PRESENT = 1;
    public static final int WAGE_PER_HOUR = 20;
    public static final int FULL_DAY_HOURS = 8;

    public void computeDailyWage() {

        int attendance = (int) (Math.random() * 2);

        if (attendance == IS_PRESENT) {
            int dailyWage = WAGE_PER_HOUR * FULL_DAY_HOURS;
            System.out.println("Employee Present");
            System.out.println("Daily Wage: " + dailyWage);
        } else {
            System.out.println("Employee Absent");
        }
    }
}