import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());

        for (int t = 0; t < T; t++) {
            st = new StringTokenizer(br.readLine().trim());
            int m = Integer.parseInt(st.nextToken());
            int n = Integer.parseInt(st.nextToken());

            char[][] grid = new char[n][m];
            int[][] fireTime = new int[n][m];
            for (int i = 0; i < n; i++) {
                Arrays.fill(fireTime[i], -1);
            }

            for (int i = 0; i < n; i++) {
                String line = br.readLine().trim();
                for (int j = 0; j < m; j++) {
                    grid[i][j] = line.charAt(j);
                }
            }

            Queue<CurrentState> fireQ = new ArrayDeque<>();
            CurrentState start = null;

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (grid[i][j] == '@') {
                        start = new CurrentState(i, j);
                    }
                    if (grid[i][j] == '*') {
                        fireQ.add(new CurrentState(i, j));
                        fireTime[i][j] = 0;
                    }
                }
            }

            if (start == null) {
                System.out.println("error");
                continue;
            }

            bfs(grid, fireTime, n, m, fireQ, start);
        }
    }

    private static void bfs(char[][] grid, int[][] fireTime, int n, int m, Queue<CurrentState> fireQ, CurrentState start) {
        int[] dx = {0, 0, 1, -1};
        int[] dy = {1, -1, 0, 0};

        while (!fireQ.isEmpty()) {
            CurrentState fire = fireQ.poll();
            int x = fire.x;
            int y = fire.y;

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx < 0 || nx >= n || ny < 0 || ny >= m) continue;
                if (grid[nx][ny] == '#' || fireTime[nx][ny] != -1) continue;

                fireTime[nx][ny] = fireTime[x][y] + 1;
                fireQ.add(new CurrentState(nx, ny));
            }
        }

        int[][] visited = new int[n][m];
        for (int i = 0; i < n; i++) Arrays.fill(visited[i], -1);
        visited[start.x][start.y] = 0;

        Queue<CurrentState> q = new ArrayDeque<>();
        q.add(start);

        while (!q.isEmpty()) {
            CurrentState cur = q.poll();
            int x = cur.x;
            int y = cur.y;
            
            if (x == 0 || y == 0 || x == n - 1 || y == m - 1) {
                if (fireTime[x][y] == -1 || visited[x][y] < fireTime[x][y]) {
                    System.out.println(visited[x][y] + 1);
                    return;
                }
            }

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx < 0 || nx >= n || ny < 0 || ny >= m) continue;
                if (grid[nx][ny] == '#' || visited[nx][ny] != -1) continue;

                int nextTime = visited[x][y] + 1;

                if (fireTime[nx][ny] != -1 && fireTime[nx][ny] <= nextTime) continue;

                visited[nx][ny] = nextTime;
                q.add(new CurrentState(nx, ny));
            }
        }

        System.out.println("IMPOSSIBLE");
    }
}

class CurrentState {
    int x, y;
    CurrentState(int x, int y) {
        this.x = x;
        this.y = y;
    }
}