package BFS;

import java.io.*;
import java.util.*;

public class B_11725 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] arr = new int[N-1][2];
        boolean[] visit = new boolean[N+1];
        for(int i = 0 ; i < arr.length; i ++){
            String str = br.readLine();
            StringTokenizer st = new StringTokenizer(str, " ");
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }

        
        Arrays.sort(arr, (a, b) -> Integer.compare(a[1], b[1]));

        for(int i = 0 ; i < arr.length; i ++){
            for(int j = 2; j <= N; j ++){
                if(arr[i][1] == j && !visit[j]){
                    visit[j-1] = true;
                    System.out.println("now" + j);
                
                }else{
                    System.out.println("no" + j);
                }
            }
        }
        System.out.println(Arrays.deepToString(arr));
        System.out.println(Arrays.toString(visit));



    }
    
}
