package Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B_1946 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for(int i = 0 ; i < T; i ++){
            int N = Integer.parseInt(br.readLine());
            int[][] arr = new int[N][2];
            boolean[] tf = new boolean[N];
            int sum = 0;
            for(int j = 0 ; j < N; j ++){
                String str = br.readLine();
                StringTokenizer st = new StringTokenizer(str, " ");
                arr[j][0] = Integer.parseInt(st.nextToken());
                arr[j][1] = Integer.parseInt(st.nextToken());
            }

            for(int j = 0 ; j < N - 1; j ++){
                if(arr[j][0] > arr[j+1][0]){
                    tf[j] = true;
                }else{
                    tf[j] = false;
                }
            }

            for(int j = 0 ; j < N - 1; j ++){
                if(arr[j][1] > arr[j+1][1]){
                    tf[j] = true;
                }else{
                    tf[j] = false;
                }
            }

            for(int j = 0 ; j < N; j ++){
                if(!tf[j]){
                    sum ++;
                }
            }
            System.out.println(sum);
        }
        
    }
    
}
