import javax.swing.tree.TreeNode;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine().trim();

        StringTokenizer st = new StringTokenizer(str);

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] coins = new int[n];
        for (int i = 0; i < n; i++) {
            coins[i] = Integer.parseInt(br.readLine().trim());
        }
        
        int[] dp = new int[k + 1];
        dp[0] = 1;


        for (int coin : coins) {
            for(int i = coin; i <= k; i++)
                dp[i] += dp[i - coin];

        }

        System.out.println(dp[k]);
    }


}

