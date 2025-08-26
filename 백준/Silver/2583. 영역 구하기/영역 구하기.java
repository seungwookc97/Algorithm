import java.util.*;
import java.util.stream.*;
import java.io.*;

class Pair{
	int x;
	int y;

	Pair(int x, int y){
		this.x =x;
		this.y =y;
	}
}

public class Main {
	
	static int[] dx= {1,-1,0,0};
	static int[] dy= {0,0,-1,1};
	static boolean[][] visited;
	static int[][] map;
	static int n,m;
	static List<Integer> lst= new ArrayList<>();

	static void bfs(int a, int b){
		Queue<Pair> q = new ArrayDeque<>();
		visited[a][b]=true;
		q.add(new Pair(a,b));
		int cnt=0;

		while(!q.isEmpty()){
			Pair p = q.poll();
			int x= p.x;
			int y= p.y;
			cnt++;

			IntStream.range(0,4)
				.mapToObj(i -> new Pair(x+dx[i], y+dy[i]))
				.filter(next -> isValid(next.x, next.y))
				.filter(next -> !visited[next.x][next.y] && map[next.x][next.y]==0)
				.forEach(next -> {
					visited[next.x][next.y]=true;
					q.add(next);
				});
		}

		lst.add(cnt);
	}

	static boolean isValid(int x, int y) {
		return x >= 0 && x < n && y >= 0 && y < m;
    }


	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int[] inp = Arrays.stream(bf.readLine().split(" "))
						.mapToInt(Integer::parseInt)
						.toArray();

		n = inp[0];
		m = inp[1];
		int k = inp[2];


		map = new int [n][m];
		visited = new boolean[n][m];

		IntStream.range(0, k)
            .mapToObj(i -> {
                try {
                    return Arrays.stream(bf.readLine().split(" "))
                                .mapToInt(Integer::parseInt)
                                .toArray();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            })
            .forEach(coords -> {
                int sy = coords[0], sx = coords[1];
                int ey = coords[2], ex = coords[3];
                
                IntStream.range(sx, ex)
                    .forEach(x -> IntStream.range(sy, ey)
                        .forEach(y -> map[x][y] = 1));
            });

		int answer=0;

		for(int i=0; i<n; i++){
			for(int j=0; j<m; j++){
				if(map[i][j]==0 && !visited[i][j]){
					bfs(i,j);
					answer++;
				}
			}
		}



		System.out.println(answer);
		lst.stream().
			sorted().
			forEach( x-> System.out.printf(x+" "));

		String[] words = {"ab","cd"};
		String target = "ac";

		Arrays.stream(words)
			.filter(word -> word.contains(target))
			.mapToInt(c -> c.length())
			.min()
			.orElse(-1);
	}

}
