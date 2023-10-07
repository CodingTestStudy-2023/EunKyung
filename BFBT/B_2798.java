// package BFBT;

// import java.io.BufferedReader;
// import java.io.IOException;
// import java.io.InputStreamReader;
// import java.util.*;

// // 시간복잡도 : O(n3)
// // 메모리 : 105020kb
// // 시간 : 336ms

// public class B_2798{

//     static int n;
//     static int m;
//     static int[] arr;
//     static boolean[] visit;
//     static int[] dfsArr = new int[3];
//     static int max = 0;
//     public static void main(String[] args) throws IOException {
//         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//         StringTokenizer st = new StringTokenizer(br.readLine());
//         n = Integer.parseInt(st.nextToken());
//         m = Integer.parseInt(st.nextToken());
//         arr = new int[n];
//         visit = new boolean[n];
//         StringTokenizer st2 = new StringTokenizer(br.readLine());

//         for(int i = 0 ; i < n; i ++){
//             arr[i] = Integer.parseInt(st2.nextToken());
//         }
//         dfs(0);
//         System.out.println(max);
//     }

//     public static void dfs(int cnt){

//         if(cnt == 3){
//             int plus = Arrays.stream(dfsArr).sum();
//             if(plus <= m){
//                 if(plus > max){
//                     max = plus;
//                 }
//             }
//             return;
//         }

//         for(int i = 0; i < arr.length; i ++){
//             if(!visit[i]){
//                 visit[i] = true;
//                 dfsArr[cnt] = arr[i];
//                 dfs(cnt + 1);
//                 visit[i] = false;
//             }
//         }

//     }
// }

package BFBT;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 시간복잡도 : O(n3)
// 메모리 : 14372kb
// 시간 : 132ms

public class B_2798 {

    static int n;
    static int m;
    static int[] arr;
    static int max = 0;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[n];

        StringTokenizer st2 = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st2.nextToken());
        }

        Arrays.sort(arr); // 배열 정렬

        findMaxSum(0, 0, 0);
        System.out.println(max);
    }

    public static void findMaxSum(int index, int count, int sum) {
        
        if (count == 3) {
            if (sum <= m) {
                max = Math.max(max, sum);
            }
            return;
        }

        for (int i = index; i < n; i++) {
            findMaxSum(i + 1, count + 1, sum + arr[i]);
        }
    }
}
