package DFS;

// import java.io.BufferedReader;
// import java.io.IOException;
// import java.io.InputStreamReader;
// import java.util.Arrays;
// import java.util.StringTokenizer;

// public class B_1574 {

//     public static void main(String[] args) throws IOException {

//         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//         int t = Integer.parseInt(br.readLine());
//         int[][] arr = new int[t][2];
//         int where = 1;

//         for (int i = 0; i < t; i++) {
//             String str = br.readLine();
//             StringTokenizer st = new StringTokenizer(str, " ");
//             arr[i][0] = Integer.parseInt(st.nextToken());
//             arr[i][1] = Integer.parseInt(st.nextToken());
//         }

//         System.out.println(Arrays.deepToString(arr));

//         for (int i = 0; i < arr.length; i++) {

//             if (arr[i][0] == 1) {
//                 where = arr[i][1];
//                 arr[i][0] = where;
//                 arr[i][1] = 1;
//             } else if (arr[i][1] == 1) {
//                 where = arr[i][0];
//                 arr[i][1] = where;
//                 arr[i][0] = 1;
//             }
//             System.out.println("Where : " + where);
          
//         }  
        
//         for(int i = 0 ; i < arr.length; i ++){
//             if(arr[i][0] == 1){
//                 System.out.println(arr[i][1]);
//                 break;
//             }else if(arr[i][1] == 1){
//                 System.out.println(arr[i][0]);
//                 break;
//             }else{
//                 System.out.println(-1);
//                 break;
//             }
//         }
//     }
// }


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B_1574 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        int[][] arr = new int[t][2];
        int where = 1;

        for (int i = 0; i < t; i++) {
            String str = br.readLine();
            StringTokenizer st = new StringTokenizer(str, " ");
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());

            if (arr[i][0] == where || arr[i][1] == where) {
                where = (arr[i][0] == where) ? arr[i][1] : arr[i][0];
            }
        }

        System.out.println(where);
    }
}
