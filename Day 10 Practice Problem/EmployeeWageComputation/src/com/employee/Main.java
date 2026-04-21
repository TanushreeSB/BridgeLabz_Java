public class Main {

    public static void main(String[] args) {

        System.out.println("Welcome to Employee Wage Computation Program");

        EmpWageBuilder emp = new EmpWageBuilder();
        emp.computeDailyWage();
    }

    int PART_TIME = 4;
    int FULL_TIME = 8;
    int wagePerHour = 20;

    int empType = (int)(Math.random() * 3);

    int hours = 0;

    switch(empType) {
        case 1:
            hours = FULL_TIME;
            break;
        case 2:
            hours = PART_TIME;
            break;
        default:
            hours = 0;
    }

    int wage = hours * wagePerHour;
    System.out.println("Employee Wage: " + wage);
}