package algorithms.string;

import java.util.ArrayList;

public class JosephusProblem {
    public  int Josephus(int n, int k)
    {
        k--;
        int arr[] = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = 1;
        }
        int cnt = 0, cut = 0, num = 1;
        while (cnt < (n - 1))
        {
            while (num <= k)
            {
                cut++;
                cut = cut % n;
                if (arr[cut] == 1) {
                    num++;
                }
            }
            num = 1;
            arr[cut] = 0;
            cnt++;
            cut++;
            cut = cut % n;
            while (arr[cut] == 0)
            {
                cut++;
                cut = cut % n;
            }
        }
        return cut + 1;
    }

    public static void main(String[] args) {
        JosephusProblem josephusProblem=new JosephusProblem();
        josephusProblem.Josephus(6,5);
    }
}
