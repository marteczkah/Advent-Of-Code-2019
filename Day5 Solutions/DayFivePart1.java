import java.util.*;

public class DayFivePart1 {

    public static void computer(int[] values){
        int size = values.length;
        Scanner scan = new Scanner(System.in);
        int i = 0;
        int d; //used to insert values to the array instruct
        int instruction;
        int[] instruct = new int[]{0, 0, 0, 0};
        while (i < size){
        if (values[i]>4 || values[i] != 99){
            instruction = values[i];
            d=0;
            while (instruction!=0){
                if (d==0){
                    instruct[d] = instruction%100;
                    instruction = instruction/100;
                    d++;
                }
                else {
                    instruct[d] = instruction%10;
                    instruction = instruction/10;
                    d++;
                }
            }
            if (instruct[0]==1){
                int sum = 0;
                if (instruct[1] == 0 && instruct[2]==0 && instruct[3]==0){ //000
                    sum = values[values[i+1]] + values[values[i+2]];
                    values[values[i+3]] = sum;
                }
                else if (instruct[1] == 1 && instruct[2]==1 && instruct[3]==1){ //111
                    sum = values[i+1] + values[i+2];
                    values[i+3] = sum;
                }
                else if (instruct[1] == 0 && instruct[2]==1 && instruct[3]==1){ //011
                    sum = values[values[i+1]] + values[i+2];
                    values[i+3] = sum;
                }
                else if (instruct[1] == 0 && instruct[2]==0 && instruct[3]==1){ //001
                    sum = values[values[i+1]] + values[values[i+2]];
                    values[i+3] = sum;
                }
                else if (instruct[1] == 1 && instruct[2]==1 && instruct[3]==0){ //110
                    sum = values[i+1] + values[i+2];
                    values[values[i+3]] = sum;
                }
                else if (instruct[1] == 1 && instruct[2]==0 && instruct[3]==1){ //101              
                    sum = values[i+1] + values[values[i+2]];
                    values[i+3] = sum;
                }
                else if (instruct[1] == 1 && instruct[2]==0 && instruct[3]==0){ //100
                    sum = values[i+1] + values[values[i+2]];
                    values[values[i+3]] = sum;
                }
                else if (instruct[1] == 0 && instruct[2]==1 && instruct[3]==0){ //010
                    sum = values[values[i+1]] + values[i+2];
                    values[values[i+3]] = sum;
                }
                i=i+4;
            }
            else if (instruct[0]==2){
                int mult = 0;
                if (instruct[1] == 0 && instruct[2]==0 && instruct[3]==0){ //000
                    mult = values[values[i+1]]*values[values[i+2]];
                    values[values[i+3]] = mult;
                }
                else if (instruct[1] == 1 && instruct[2]==1 && instruct[3]==1){//111
                    mult = values[i+1]*values[i+2];
                    values[i+3] = mult;
                }
                else if (instruct[1] == 0 && instruct[2]==1 && instruct[3]==1){//011
                    mult = values[values[i+1]]*values[i+2];
                    values[i+3] = mult;
                }
                else if (instruct[1] == 0 && instruct[2]==0 && instruct[3]==1){//001
                    mult = values[values[i+1]] * values[values[i+2]];
                    values[i+3] = mult;
                }
                else if (instruct[1] == 1 && instruct[2]==1 && instruct[3]==0){//110
                    mult = values[i+1] * values[i+2];
                    values[values[i+3]] = mult;
                }
                else if (instruct[1] == 1 && instruct[2]==0 && instruct[3]==1){
                    mult = values[i+1] * values[values[i+2]];
                    values[i+3] = mult;
                }
                else if (instruct[1] == 1 && instruct[2]==0 && instruct[3]==0){
                    mult = values[i+1] * values[values[i+2]];
                    values[values[i+3]] = mult;
                }
                else if (instruct[1] == 0 && instruct[2]==1 && instruct[3]==0){
                    mult = values[values[i+1]] * values[i+2];
                    values[values[i+3]] = mult;
                }
                i=i+4;
            }
            else if (instruct[0] == 3){
                int input = scan.nextInt();
                if (instruct[1] == 0){
                    values[values[i+1]] = input;
                }
                else if (instruct[1] == 1){
                    values[i+1] = input;
                }
                i=i+2;
            }
            else if (instruct[0]==4){
                if (instruct[1]==0){
                    System.out.println(values[values[i+1]]);
                }
                else if (instruct[1]==1){
                    System.out.println(values[i+1]);
                }
                i=i+2;
            }
            else if (instruct[0] == 99){
                i = size;
            }
        }
        else {
            if (values[i]==1){
                int sum = 0;
                sum = values[values[i+1]] + values[values[i+2]];
                values[values[i+3]] = sum;
                i=i+4;
            }
            else if (values[i]==2){
                int mult = 0;
                mult = values[values[i+1]]*values[values[i+2]];
                values[values[i+3]] = mult;
                i=i+4;
            }
            else if (values[i] == 3){
                int input = scan.nextInt();
                values[values[i+1]] = input;
                i=i+2;
            }
            else if (values[i]==4){
                System.out.println(values[values[i+1]]);
                i=i+2;
            }
            else if (values[i] == 99){
                i = size;
            }
        }
        }
        scan.close();
    }

    public static void main(String[] args){
        int[] values = new int[]{3,225,1,225,6,6,1100,1,238,225,104,0,1101,37,61,225,101,34,121,224,1001,224,-49,224,4,224,102,8,223,223,1001,224,6,224,1,224,223,223,1101,67,29,225,1,14,65,224,101,-124,224,224,4,224,1002,223,8,223,101,5,224,224,1,224,223,223,1102,63,20,225,1102,27,15,225,1102,18,79,224,101,-1422,224,224,4,224,102,8,223,223,1001,224,1,224,1,223,224,223,1102,20,44,225,1001,69,5,224,101,-32,224,224,4,224,1002,223,8,223,101,1,224,224,1,223,224,223,1102,15,10,225,1101,6,70,225,102,86,40,224,101,-2494,224,224,4,224,1002,223,8,223,101,6,224,224,1,223,224,223,1102,25,15,225,1101,40,67,224,1001,224,-107,224,4,224,102,8,223,223,101,1,224,224,1,223,224,223,2,126,95,224,101,-1400,224,224,4,224,1002,223,8,223,1001,224,3,224,1,223,224,223,1002,151,84,224,101,-2100,224,224,4,224,102,8,223,223,101,6,224,224,1,224,223,223,4,223,99,0,0,0,677,0,0,0,0,0,0,0,0,0,0,0,1105,0,99999,1105,227,247,1105,1,99999,1005,227,99999,1005,0,256,1105,1,99999,1106,227,99999,1106,0,265,1105,1,99999,1006,0,99999,1006,227,274,1105,1,99999,1105,1,280,1105,1,99999,1,225,225,225,1101,294,0,0,105,1,0,1105,1,99999,1106,0,300,1105,1,99999,1,225,225,225,1101,314,0,0,106,0,0,1105,1,99999,108,677,677,224,1002,223,2,223,1006,224,329,101,1,223,223,1107,677,226,224,102,2,223,223,1006,224,344,101,1,223,223,8,677,677,224,1002,223,2,223,1006,224,359,101,1,223,223,1008,677,677,224,1002,223,2,223,1006,224,374,101,1,223,223,7,226,677,224,1002,223,2,223,1006,224,389,1001,223,1,223,1007,677,677,224,1002,223,2,223,1006,224,404,1001,223,1,223,7,677,677,224,1002,223,2,223,1006,224,419,1001,223,1,223,1008,677,226,224,1002,223,2,223,1005,224,434,1001,223,1,223,1107,226,677,224,102,2,223,223,1005,224,449,1001,223,1,223,1008,226,226,224,1002,223,2,223,1006,224,464,1001,223,1,223,1108,677,677,224,102,2,223,223,1006,224,479,101,1,223,223,1108,226,677,224,1002,223,2,223,1006,224,494,1001,223,1,223,107,226,226,224,1002,223,2,223,1006,224,509,1001,223,1,223,8,226,677,224,102,2,223,223,1006,224,524,1001,223,1,223,1007,226,226,224,1002,223,2,223,1006,224,539,1001,223,1,223,107,677,677,224,1002,223,2,223,1006,224,554,1001,223,1,223,1107,226,226,224,102,2,223,223,1005,224,569,101,1,223,223,1108,677,226,224,1002,223,2,223,1006,224,584,1001,223,1,223,1007,677,226,224,1002,223,2,223,1005,224,599,101,1,223,223,107,226,677,224,102,2,223,223,1005,224,614,1001,223,1,223,108,226,226,224,1002,223,2,223,1005,224,629,101,1,223,223,7,677,226,224,102,2,223,223,1005,224,644,101,1,223,223,8,677,226,224,102,2,223,223,1006,224,659,1001,223,1,223,108,677,226,224,102,2,223,223,1005,224,674,1001,223,1,223,4,223,99,226};
        computer(values);
    }   
}
