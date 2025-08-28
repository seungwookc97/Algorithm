import java.util.*;


class Main{
    public static int dfs(int n,int r,int c, int v){

        if (n>0){
            int m=1;

            for(int i=0; i<n; i++){
                m*=2;
            }
            int val= m*m/4;
            m/=2;

            if(r<m && c<m) return dfs(n-1,r,c,v);
            else if(r<m && c>=m) return dfs(n-1,r,c-m,v+val);
            else if(r>=m && c<m) return dfs(n-1,r-m,c,v+2*val);
            else return dfs(n-1,r-m,c-m,v+3*val);

        }
        
        return v;
    }
  
    public static void main(String[] args){
 
        Scanner sc= new Scanner(System.in);
        int n,r,c;
        n=sc.nextInt();
        r=sc.nextInt();
        c=sc.nextInt();

        System.out.println(dfs(n,r,c,0));
    }
}


