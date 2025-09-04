import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] tmp = br.readLine().trim().split(" ");
        int n = Integer.parseInt(tmp[0]);
        int k = Integer.parseInt(tmp[1]);

        int[] weights = new int[n+1];
        int[] values = new int[n+1];

        for(int i = 1; i <= n; i++){
            tmp = br.readLine().trim().split(" ");
            weights[i] = Integer.parseInt(tmp[0]);
            values[i] = Integer.parseInt(tmp[1]);
        }

        int[][] dp = new int[n+1][k+1];

        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= k; j++){
                if (j >= weights[i]){
                    dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-weights[i]]+values[i]);
                }else{
                    dp[i][j] = dp[i-1][j];
                }
            }
        }

        System.out.println(dp[n][k]);
    }
}