package Greedy;

import java.util.*;
import java.io.*;

public class B_13305 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        long[] arr = new long[N - 1]; // 거리 배열을 long으로 변경
        long[] oil = new long[N];

        String str = br.readLine();
        StringTokenizer st = new StringTokenizer(str, " ");

        for (int i = 0; i < N - 1; i++) {
            arr[i] = Long.parseLong(st.nextToken());
        }

        String str2 = br.readLine();
        StringTokenizer st2 = new StringTokenizer(str2, " ");

        for (int i = 0; i < N; i++) {
            oil[i] = Long.parseLong(st2.nextToken());
        }

        long result = 0;
        long max = oil[0]; // 현재까지의 최소 기름 가격

        for (int i = 0; i < N - 1; i++) {
            max = Math.min(max, oil[i]); // 현재까지의 최소 기름 가격 업데이트
            result += max * arr[i]; // 최소 기름 가격으로 이동한 거리를 더함
        }

        System.out.println(result);
    }
}
