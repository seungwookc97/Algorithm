import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for(int t=0; t<T; t++) {
            int k  = Integer.parseInt(br.readLine());

            int[] dp = new int[k+1];
            dp[0] = 1;

            for(int coin=1; coin<=3; coin++){
                for(int i=coin; i<=k; i++){
                    dp[i]+=dp[i-coin];
                }
            }

            System.out.println(dp[k]);
        }
    }
}

