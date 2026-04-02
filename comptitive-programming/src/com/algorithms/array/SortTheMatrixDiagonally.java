package algorithms.array;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SortTheMatrixDiagonally {
    public int[][] diagonalSort(int[][] mat) {
        List<Integer> list=new ArrayList<>();
        for (int x =0;x<mat[0].length;x++) {
            for (int i = 0; i < mat.length; i++) {
                for (int j = x; j < mat.length; j++) {
                    list.add(mat[i][j]);
                    i++;
                }
            }
            Collections.sort(list);
            for (int i = x; i < mat.length; i++) {
                for (int j = 0; j < mat.length; j++) {
                    mat[i][j]=list.get(i);
                    i++;
                }
            }
            list.clear();
        }
        return null;
    }

    public static void main(String args[]){

    int[][] mat={{3,3,1,1},
                 {2,2,1,2},
                 {1,1,1,2}};
    SortTheMatrixDiagonally sortTheMatrixDiagonally=new SortTheMatrixDiagonally();
    sortTheMatrixDiagonally.diagonalSort(mat);
    }
}
