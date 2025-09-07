import javax.swing.tree.TreeNode;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int n, count;
    static int[] col;

    static void nQueens(int x) {

        if(x==n){
            count++;
            return;
        }

        for(int i=0; i<n; i++){

            if(isVaild(x,i)){
                col[x] = i;
                nQueens(x+1);
                col[x] = 0;
            }
        }
    }

    static boolean isVaild(int row, int x){

        for(int i=0; i<row; i++){
            if(col[i] == x){
                return false;
            }
            if(Math.abs(row - i) == Math.abs(x - col[i])){
                return false;
            }
        }
        return true;
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        col = new int[n];
        
        nQueens(0);

        System.out.println(count);
    }
}

