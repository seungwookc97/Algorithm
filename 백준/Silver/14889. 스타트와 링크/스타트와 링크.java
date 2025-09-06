import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int[][] arr;
    static int n;
    static List<Set<Integer>> lst = new ArrayList<>();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        arr = new int[n][n];

        for(int i = 0; i < n; i++) {
            String[] tmp = br.readLine().split(" ");

            for(int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(tmp[j]);
            }
        }

        Set<Integer> tmpSet = new HashSet<>();

        getList(tmpSet, 0);
        int min = Integer.MAX_VALUE;


        for(int i = 0; i< lst.size(); i++) {
            List<Integer> start = new ArrayList<>();
            List<Integer> link =  new ArrayList<>();


            for(int j = 0; j < n; j++) {
                if(lst.get(i).contains(j)) start.add(j);
                else link.add(j);
            }

            int totalStartVal=0;
            int totalLinkVal=0;

            for(int j =0; j<n/2; j++){
                for(int k=0; k<n/2; k++){
                    if(j==k) continue;
                    totalStartVal += arr[start.get(j)][start.get(k)];
                    totalLinkVal+=arr[link.get(j)][link.get(k)];
                }
            }

            if(Math.abs(totalLinkVal - totalStartVal) < min){
                min = Math.abs(totalLinkVal - totalStartVal);
            }
        }
        System.out.println(min);
    }

    static void getList(Set<Integer> tmpSet, int start){

        if(tmpSet.size() == n/2){
            lst.add(new HashSet<>(tmpSet));
            return;
        }

        for(int i = start; i < n; i++) {
            if(!tmpSet.contains(i)){
                tmpSet.add(i);
                getList(tmpSet, i+1);
                tmpSet.remove(i);
            }
        }

    }
}