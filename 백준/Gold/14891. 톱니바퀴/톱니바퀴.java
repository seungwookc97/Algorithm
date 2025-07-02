import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[][] arr = new int[4][8];

        for (int i = 0; i < 4; i++) {
            String input = br.readLine().trim();
            for (int j = 0; j < 8; j++) {
                arr[i][j] = input.charAt(j) - '0';
            }
        }

        int k = Integer.parseInt(br.readLine().trim());

        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken()) - 1; // 0-based index
            int dir = Integer.parseInt(st.nextToken());

            //num 번째 톱니바퀴 회전
            // 1. 현재 톱니의 2번째 바퀴와, 맞물린 톱니의 6번째 톱니바퀴를 확인하고 값이 같다면 회전, 아니라면 회전하지 않는다.
            // 2. dir: 1이면 시계방향, -1이면 반시계방향
            // 3. 만약 num 번째 톱니바퀴가 회전하면, 그에 영향을 받는 톱니바퀴들도 회전해야 한다.
            // 4, 영향을 받아 회전하는 톱니바퀴들은 반대로 회전

            // 연쇄적 회전 필요. 왼쪽 오른쪽 각각 2,6 톱니를 기준으로 값이 다른지 확인하고 만약 다르다면 방향을 설정하고 한번에 돌림
            // rotate, rotateOnce
            rotate(arr, num, dir);

        }

        int result = 0;

        for (int i = 0; i < 4; i++) {
            if (arr[i][0] == 1) {
                result += Math.pow(2, i);
            }
        }
        System.out.println(result);
    }

    public static void rotate(int[][] arr, int num, int dir) {
        int[] dirs = new int[4];
        dirs[num] = dir;

        for (int i = num - 1; i >= 0; i--) {
            if (arr[i][2] != arr[i + 1][6]) {
                dirs[i] = -dirs[i + 1];
            } else {
                break;
            }
        }

        for (int i = num + 1; i < 4; i++) {
            if (arr[i - 1][2] != arr[i][6]) {
                dirs[i] = -dirs[i - 1];
            } else {
                break;
            }
        }
        
        for (int i = 0; i < 4; i++) {
            if (dirs[i] != 0) {
                rotateOnce(arr[i], dirs[i]);
            }
        }
    }

    public static void rotateOnce(int[] arr, int dir) {
        if (dir == 1) {
            int temp = arr[7];
            for (int i = 7; i > 0; i--) {
                arr[i] = arr[i - 1];
            }
            arr[0] = temp;
        } else {
            int temp = arr[0];
            for (int i = 0; i < 7; i++) {
                arr[i] = arr[i + 1];
            }
            arr[7] = temp;
        }
    }

}

