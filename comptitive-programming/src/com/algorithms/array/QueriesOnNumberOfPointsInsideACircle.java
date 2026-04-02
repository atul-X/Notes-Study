package algorithms.array;

import java.util.HashMap;

public class QueriesOnNumberOfPointsInsideACircle {
    public int[] countPoints(int[][] points, int[][] queries) {
        int count=0;
        int[] arr=new int[queries.length];
        for (int i=0;i< queries.length;i++){
            int x1=queries[i][0];
            int y1=queries[i][1];
            double radius=queries[i][2];
            for (int j=0;j<points.length;j++){
                int x2=points[j][0];
                int y2=points[j][1];
                double dist= Math.sqrt(((x2-x1)*(x2-x1))+((y2-y1)*(y2-y1)));
                if(dist<=radius){
                    count++;
                }
            }
            arr[i]=count;
            count=0;
        }
        return arr;
    }
    public static void main(String args[]){
        int[][] points={{1,3},{3,3},{5,3},{2,2}};
        int[][] queries={{2,3,1},{4,3,1},{1,1,2}};
        QueriesOnNumberOfPointsInsideACircle aCircle=new QueriesOnNumberOfPointsInsideACircle();
        aCircle.countPoints(points,queries);
    }
}