import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;



public class Main {

    static boolean[][] visited;
    static int[][] arr;
    static int n,m;
    static int[] dx = {0, 0, -1, 1}; // Directions for x (left, right, up, down)
    static int[] dy = {-1, 1, 0, 0}; // Directions for y (left, right, up, down)
    static int pic_count = 0;
    static int max=0;
    static void bfs(int x, int y) {
        Queue<Pair> queue = new ArrayDeque<>();
        queue.add(new Pair(x, y));
        visited[x][y] = true;

        int cnt=1;

        while (!queue.isEmpty()) {
            Pair current = queue.poll();
            int cx = current.x;
            int cy = current.y;

            // Check all 4 directions
            for (int i = 0; i < 4; i++) {
                int nx = cx + dx[i];
                int ny = cy + dy[i];

                if (nx >= 0 && nx < n && ny >= 0 && ny < m && !visited[nx][ny] && arr[nx][ny] == arr[cx][cy]) {
                    visited[nx][ny] = true;
                    queue.add(new Pair(nx, ny));
                    cnt++;
                }
            }
        }
        pic_count++;
        max = Math.max(max, cnt);
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new int[n][m];
        visited= new  boolean[n][m];

        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<m; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(!visited[i][j] && arr[i][j] != 0) {
                    bfs(i,j);

                }
            }
        }
        System.out.println(pic_count);
        System.out.println(max);

    }
}

class Pair {
    int x, y;

    public Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }
}