
import java.io.*;
import java.util.*;


public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        List<int []> seg = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            seg.add(new int[]{x, y});
        }

        seg.sort(Comparator.comparingInt(a -> a[0]));
        List<int []> merged = new ArrayList<>();

        for (int[] current : seg) {
            if (merged.isEmpty() || merged.get(merged.size() - 1)[1] < current[0]) {
                merged.add(new int[] {current[0], current[1]});
            } else {
                int[] last = merged.get(merged.size() - 1);
                last[1] = Math.max(last[1], current[1]);
            }
        }

        // 병합된 구간들의 총 길이 계산
        int totalLength = 0;
        for (int[] val : merged) {
            totalLength += val[1] - val[0];
        }

        System.out.println(totalLength);
    }


}