package algorithms.sorting;

import java.util.Arrays;

public class WidestVerticalAreaBetweenTwoPointsContainingNoPoints {
    /*
    *
    * N3 approach*/
    public int maxWidthOfVerticalArea(int[][] points) {
        for (int i=0;i<points.length;i++){
            for (int j=0;j<points.length-1;j++){
                if(points[j][0]>points[j+1][0]){
                    int tempX=0, tempY=0;
                    tempX=points[j][0];
                    points[j][0]=points[j+1][0];
                    points[j+1][0]=tempX;
                    tempY=points[j][1];
                    points[j][1]=points[j+1][1];
                    points[j+1][1]=tempY;
                }
            }
        }

        int count=points[0][0];
        int maximum=0;
        for(int i=1;i<points.length;i++){
             maximum=Math.max(maximum,Math.abs(count-points[i][0]));
             count=points[i][0];
        }
        return maximum;

    }


    public int maxWidthOfVerticalArea2(int[][] points) {
        int[] arr=new int[points.length];

        for (int i=0;i<points.length;i++){
            arr[i]=points[i][0];
        }
        Arrays.sort(arr);
        int count=arr[0];
        int maximum=0;
        for(int i=1;i<points.length;i++){
            maximum=Math.max(maximum,Math.abs(count-arr[i]));
            count=arr[i];
        }
        return maximum;

    }

    public static void main(String args[]){
    int[][] arr={{8,7},{9,9},{7,4},{9,7}};
    WidestVerticalAreaBetweenTwoPointsContainingNoPoints widestVerticalAreaBetweenTwoPointsContainingNoPoints=new WidestVerticalAreaBetweenTwoPointsContainingNoPoints();
    widestVerticalAreaBetweenTwoPointsContainingNoPoints.maxWidthOfVerticalArea(arr);
    }

    public int maxWidthOfVerticalArea1(int[][] points) {
        int maximum=0;
        int [] arr=new int[points.length];
        for(int i=0;i<points.length;i++)
        {
            arr[i]=points[i][0];
        }

        Arrays.sort(arr);

        int a=arr[0];
        for(int i=1;i<arr.length;i++)
        {
            maximum=Math.max(maximum,Math.abs(a-arr[i]));
            a=arr[i];
        }

        return maximum;
    }
}
