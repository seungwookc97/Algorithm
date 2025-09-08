
import java.io.*;
import java.util.*;

class Pos{
    int x,y;
    int cnt;

    Pos(int x,int y,int cnt){
        this.x=x;
        this.y=y;
        this.cnt=cnt;
    }
}

class Cell{
    int color;
    int time;

    Cell(int color,int time){
        this.color=color;
        this.time=time;
    }
}

public class Main {

    static int n,m,g,r;
    static int[][] map;
    static int totalCount;
    static int answer=0;
    static List<Set<Integer>> greenPos = new ArrayList<>();
    static List<Pos> canPlant;

    static void getGreenPos(int cnt, Set<Integer> set){

        if(set.size()>=g){
            greenPos.add(new HashSet<>(set));
            return;
        }

        if(cnt>= canPlant.size()) return;

        int remaining = canPlant.size()- cnt;
        int needed = g- set.size();
        if(remaining< needed) return;

        for(int i=cnt; i<canPlant.size(); i++){
            if (!set.contains(i)) {
                set.add(i);
                getGreenPos(i+1,set);
                set.remove(i);
            }
        }
    }

    static void getRedPos(Set<Integer> green, int cnt, Set<Integer> set, List<Set<Integer>> redPosList){

        if(set.size()>=r){
            redPosList.add(new HashSet<>(set));
            return;
        }

        if(cnt>= canPlant.size()) return;

        int remaining = canPlant.size()- cnt;
        int needed = r- set.size();
        if(remaining< needed) return;

        for(int i=cnt; i<canPlant.size(); i++){
            if (!green.contains(i) && !set.contains(i)) {
                set.add(i);
                getRedPos(green, i+1, set, redPosList);
                set.remove(i);
            }
        }
    }



    static int[] dx ={1,-1,0,0};
    static int[] dy= {0,0,-1,1};

    static int bfs(Queue<Pos> gq, Queue<Pos> rq) {
        Cell[][] visited = new Cell[n][m];
        for (int i=0;i<n;i++)
            for (int j=0;j<m;j++)
                visited[i][j] = new Cell(0,-1);

        for(Pos p : gq) {
            visited[p.x][p.y] = new Cell(1, 0);
        }
        for(Pos p : rq) {
            visited[p.x][p.y] = new Cell(2, 0);
        }

        int flowers = 0;
        Queue<Pos> q = new ArrayDeque<>();
        q.addAll(gq);
        q.addAll(rq);

        while(!q.isEmpty()) {
            Pos p = q.poll();
            if (visited[p.x][p.y].color == 3) continue;

            for(int i=0; i<4; i++) {
                int nx = p.x+dx[i];
                int ny = p.y+dy[i];
                if(nx<0||ny<0||nx>=n||ny>=m) continue;
                if(map[nx][ny]==0) continue;

                if(visited[nx][ny].color==0) {
                    // 아직 방문 안한 칸
                    visited[nx][ny] = new Cell(visited[p.x][p.y].color, p.cnt+1);
                    q.add(new Pos(nx,ny,p.cnt+1));
                } else if(visited[nx][ny].color==1 || visited[nx][ny].color==2) {
                    // 다른 색이 같은 시간에 도착하면 꽃
                    if(visited[nx][ny].color != visited[p.x][p.y].color &&
                            visited[nx][ny].time == p.cnt+1) {
                        visited[nx][ny].color = 3;
                        flowers++;
                    }
                }
            }
        }
        return flowers;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inp = br.readLine().split(" ");
        n =  Integer.parseInt(inp[0]);
        m =  Integer.parseInt(inp[1]);
        g = Integer.parseInt(inp[2]);
        r = Integer.parseInt(inp[3]);
        totalCount = g+r;

        map = new int[n][m];
        canPlant= new LinkedList<>();
        int totalPlant = g+r;

        for(int i=0; i<n; i++){
            int[] tmp = Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();

            for(int j=0; j<m; j++){
                if(tmp[j]==2) canPlant.add(new Pos(i,j,0));
                map[i][j]=tmp[j];
            }

        }

        getGreenPos(0, new HashSet<>());

        for (Set<Integer> green : greenPos) {

            List<Set<Integer>> redPosList = new ArrayList<>();
            getRedPos(green, 0, new HashSet<>(), redPosList);

            for (Set<Integer> red : redPosList) {
                Queue<Pos> gq = new ArrayDeque<>();
                Queue<Pos> rq = new ArrayDeque<>();

                for (int j : green) {
                    int x = canPlant.get(j).x;
                    int y = canPlant.get(j).y;
                    gq.add(new Pos(x, y, 0));
                }

                for (int j : red) {
                    int x = canPlant.get(j).x;
                    int y = canPlant.get(j).y;
                    rq.add(new Pos(x, y, 0));
                }

                int flowers = bfs(gq, rq);
                answer = Math.max(answer, flowers);
                }
        }
        System.out.println(answer);
    }
}