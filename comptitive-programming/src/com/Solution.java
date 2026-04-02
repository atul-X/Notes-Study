import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Solution {
    public String mergeCharacters(String s, int k) {
        StringBuilder sb = new StringBuilder();
        Map<Character, Integer> mp = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (mp.containsKey(ch)) {
                int indexOfChar = mp.get(ch);
                if (i - indexOfChar <= k) {
                    continue;
                }
            }
            sb.append(ch);
            mp.put(ch, i);
        }

        return sb.toString();
    }
    public static void main(String[] args) {
        Solution stringContainsBinaryCode = new Solution();
        System.out.println(stringContainsBinaryCode.mergeCharacters("yybyzybz", 2)); // Expected output: "yybyzybz"
    }
    static int M=1000000007;
    int[][][] t;
    int numberOfStableArrays(int zero,int one,int limit){
        t=new int[10001][10001][2];
        for (int[][] ns:t){
            for (int[] n:ns) {
                Arrays.fill(n, -1);
            }
        }
        int startWithOne=solve(one,zero,false,limit);
        int startWithZero=solve(zero,one,true,limit);
        return startWithOne+startWithZero;
    }
    int solve(int one,int zero,boolean flag,int limit){
        if(one==0 && zero==0){
            return 1;
        }
        if(t[one][zero][flag?1:0]!=-1){
            return t[one][zero][flag?1:0];
        }
        int result=0;
        if(flag){
            for(int i=0;i<=Math.min(zero,limit);i++){
                result=(result+solve(one,zero-i,false,limit))%M;
            }
        }else{
            for(int i=0;i<=Math.min(one,limit);i++){
                result=(result+solve(one-i,zero,true,limit))%M;
            }
        }
        t[one][zero][flag?1:0]=result;
        return result;
    }
    public long minNumberOfSeconds(int mountainHeight, int[] workerTimes) {
        int timeSpent=0;
        int height=mountainHeight;
        int min= Arrays.stream(workerTimes).min().getAsInt();
        int level=0;
        while (height>0){
            level++;
            timeSpent=timeSpent+min*level;
            height=height-1;
        }
        int low=0;
        int high=timeSpent;
        int ans=0;
        while (low<=high){
            int mid=((high+low)-low)/2;
            if (canFinish(mid,mountainHeight,workerTimes)){
                ans=mid;
                high=mid+1;
            }else {
                low=low+1;
            }
        }
        return ans;
    }
    boolean canFinish(int mid,int mountainHeight,int[] workerTimes){
        int totalHeightReduced=0;
        for(int i=0;i<workerTimes.length;i++){
            int height=0;
            int timeSpent=0;
            int level=1;
            while(true){
                int nextcost=workerTimes[i]*level;
                if(timeSpent+nextcost>mid){
                  break;
                }
                timeSpent=timeSpent+nextcost;
                height=height+1;
                level=level+1;
            }
            totalHeightReduced=totalHeightReduced+height;
            if(totalHeightReduced>=mountainHeight){
                return true;
            }

        }
        return false;
    }
}
