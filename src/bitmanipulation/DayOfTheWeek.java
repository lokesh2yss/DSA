package bitmanipulation;

public class DayOfTheWeek {
    public static void main(String[] args) {

        System.out.println(dayofweek(29,2,2020));
    }
    public static int dayofweek(int d, int m, int y)
    {
        //01-01-1970 Thursday
        int yearDiff = y - 1970;
        int monthDiff = m;
        int dayDiff = d;
        int leapYears = 0;
        if(y > 1972) {
            leapYears = 1 + (y - 1972)/4;
        }
        if(y > 2000) {
            //leapYears--;
        }
        int totalDays = (y-1970)*365 + leapYears;
        int[] month = new int[12];
        month[0] = 31;
        month[1] = 28;
        month[2] = 31;
        month[3] = 30;
        month[4] = 31;
        month[5] = 30;
        month[6] = 31;
        month[7] = 31;
        month[8] = 30;
        month[9] = 31;
        month[10] = 30;
        month[11] = 31;
        for(int i=0;i<m-1;i++) {
            totalDays += month[i];
        }
        totalDays += dayDiff;
        totalDays--;
        int day  = totalDays%7;
        switch(day) {
            case 0:
                return 4;
            case 1:
                return 5;
            case 2:
                return 6;
            case 3:
                return 7;
            case 4:
                return 1;
            case 5:
                return 2;
            case 6:
                return 3;
        }

        return -1;
    }

}
