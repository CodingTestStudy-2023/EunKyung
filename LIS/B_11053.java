package LIS;

import java.io.*;
import java.util.*;

public class B_11053 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String A = br.readLine();
        StringTokenizer st = new StringTokenizer(A, " ");

        int[] arr = new int[N];
        int[] lis = new int[N];

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.fill(lis, 1); //1로 초기 세팅

        for (int i = 1; i < N; i++) {
            for (int j = 0; j < i; j++) {
                if (arr[i] > arr[j] && lis[i] < lis[j] + 1) {
                    lis[i] = lis[j] + 1;
                }
            }
        }
        int max = Arrays.stream(lis).max().orElse(0);
        System.out.println(max);
        
    }
}
