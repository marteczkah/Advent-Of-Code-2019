import java.util.*;

public class dayFour {
    //part one; checks if an integer has two equal adjacent digits
    public static boolean doubleCheck(int m){
        int z = m;
        int i = 0;
        int[] checker = new int[7];
        while (z!=0){
            int k = z%10;
            z = z/10;
            checker[i]=k;
            i++;
        }
        for (int d = 0; d < 6; d++){
            if (checker[d] == checker[d+1]){
                return true;
            }
        }
        return false;
    }

    //part one; checks if the digits in an integer are either increasing or equal 
    public static boolean increasing(int m){
        int z = m;
        int i = 0;
        int[] checker = new int[7];
        while (z!=0){
            int k = z%10;
            z = z/10;
            checker[i]=k;
            i++;
        }
        for (int d = 0; d < 6; d++){
            if (checker[d]<checker[d+1]){
                return false;
            }
        }
        return true;
    }

    //double check for part 2
    public static boolean doubleCheckTwo(int m){
        int z = m;
        int i = 0;
        int[] checker = new int[7];
        while (z!=0){
            int k = z%10;
            z = z/10;
            checker[i]=k;
            i++;
        }
        for (int d = 0; d < 6; d++){
            if (d==0){
                if ((checker[d] == checker[d+1] && checker[d+2] != checker[d])){
                    return true;
                }  
            }
            else if (d==5){
                if ((checker[d] == checker[d+1]) && checker[d-1] != checker[d]){
                    return true;
                }
            }
            else {
                if ((checker[d] == checker[d+1]) && checker[d-1] != checker[d] && checker[d+2] != checker[d]){
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] values = new int[545391];
        int m = 0;
        for (int i = 245182; i < 790573; i++){
            values[m] = i;
            m++;
        }
        //part one
        int count = 0;
        for (int z  = 0; z < 545391; z++){
            if (increasing(values[z]) && doubleCheck(values[z])){
                count++;
            }
        }
        System.out.println("Part One Solution " + count);
        //part tow
        int countTwo = 0;
        for (int z  = 0; z < 545391; z++){
            if (increasing(values[z]) && doubleCheckTwo(values[z])){
                countTwo++;
            }
        }
        System.out.println("Part Two Solution " + countTwo);
    }
}