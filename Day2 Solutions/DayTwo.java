import java.util.*;

public class DayTwo {
    public static int computer(int noun, int verb){
        int[] values = new int[]{1,noun,verb, 3,1,1,2,3,1,3,4,3,1,5,0,3,2,10,1,19,2,9,19,23,2,13,23,27,1,6,27,31,2,6,31,35,2,13,35,39,1,39,10,43,2,43,13,47,1,9,47,51,1,51,13,55,1,55,13,59,2,59,13,63,1,63,6,67,2,6,67,71,1,5,71,75,2,6,75,79,1,5,79,83,2,83,6,87,1,5,87,91,1,6,91,95,2,95,6,99,1,5,99,103,1,6,103,107,1,107,2,111,1,111,5,0,99,2,14,0,0};
        int size = values.length;
        int i = 0;
        while (i < size){
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
            else if (values[i] == 99){
                i = size;
            }
        }
        return values[0];
    }
    public static void main(String[] args){
        int[] values = new int[]{1,0,12, 3,1,1,2,3,1,3,4,3,1,5,0,3,2,10,1,19,2,9,19,23,2,13,23,27,1,6,27,31,2,6,31,35,2,13,35,39,1,39,10,43,2,43,13,47,1,9,47,51,1,51,13,55,1,55,13,59,2,59,13,63,1,63,6,67,2,6,67,71,1,5,71,75,2,6,75,79,1,5,79,83,2,83,6,87,1,5,87,91,1,6,91,95,2,95,6,99,1,5,99,103,1,6,103,107,1,107,2,111,1,111,5,0,99,2,14,0,0};
        int size = values.length;

        //first problem
        int result = computer(12, 2);
        System.out.println(result);

        //second problem
        int noun, verb;
        for (noun = 0; noun < size; noun++ ){
            for (verb = 0; verb < size; verb++){
                if (computer(noun, verb) == 19690720){
                    System.out.println("Noun " + noun + " verb " + verb + " equals 19690720");
                    int answer = 100 * noun + verb;
                    System.out.println("Answer: " + answer);
                }
            }
        }
    }   
}