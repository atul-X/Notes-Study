package algorithms.sorting;

import java.util.Arrays;

public class MinimumNumberOfMovesToSeatEveryone {
    public int minMovesToSeat(int[] seats, int[] students) {
        Arrays.sort(seats);
        Arrays.sort(students);
        int count=0;
        for(int i=0;i<seats.length;i++){
           int num= Math.abs(seats[i]-students[i]);
           count+=num;
        }
        return count;
    }
}
