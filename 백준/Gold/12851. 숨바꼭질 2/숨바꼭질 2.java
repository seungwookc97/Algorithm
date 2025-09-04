import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int k = Integer.parseInt(input[1]);

        int MAX = 100000;
        int[] dist = new int[MAX+1];
        int[] count = new int[MAX+1];
        Arrays.fill(dist, -1);

        Queue<Integer> q = new ArrayDeque<>();
        q.offer(n);
        dist[n] = 0;
        count[n] = 1;

        while (!q.isEmpty()) {
            int cur = q.poll();

            for (int next : new int[]{cur - 1, cur + 1, cur * 2}) {
                if (next < 0 || next > MAX) continue;

                if (dist[next] == -1) {  // 처음 방문
                    dist[next] = dist[cur] + 1;
                    count[next] = count[cur];
                    q.offer(next);
                } else if (dist[next] == dist[cur] + 1) { // 같은 최단 시간
                    count[next] += count[cur];
                }
            }
        }

        System.out.println(dist[k]);
        System.out.println(count[k]);
    }
}