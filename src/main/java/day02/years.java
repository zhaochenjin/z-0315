import java.util.Scanner;

class Years {
    public boolean isLeapYear(int year) {
        if (year % 4 == 0 || (year % 400 == 0 && year % 100 != 0)) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("input year：");
        int year = scanner.nextInt();
        Years year1 = new Years();
        System.out.println(year+" is leap year"+year1.isLeapYear(year));
    }
}

12