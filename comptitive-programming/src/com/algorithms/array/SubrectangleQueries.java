package algorithms.array;

public class SubrectangleQueries {
    class SubrectangleQueriesImpl {
        int a[][];
        public SubrectangleQueriesImpl(int[][] rectangle) {
            a=rectangle;
        }

        public void updateSubrectangle(int row1, int col1, int row2, int col2, int newValue) {
            for(int i=row1;i<=row2;i++){
                for (int j=col1;j<=col2;j++){
                    a[i][j]=newValue;
                }
            }
        }

        public int getValue(int row, int col) {
            return a[row][col];
        }
    }




    public static void main(String args[]){


    }
}
