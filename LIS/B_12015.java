package LIS;

import java.util.*;
import java.io.*;

public class B_12015 {

    static int[] arr;
    static int[] lis;
    static int length = 1;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        arr = new int[N];
        lis = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        // 입력 배열 초기화
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        lis[0] = arr[0]; // LIS 배열 초기화

        // LIS 계산 및 출력
        LIS(1);
        System.out.println(length);

    }

    public static int LIS(int A) {

        if (A == arr.length) {
            return length;
        }

        int key = arr[A];

        // 현재 값이 LIS의 마지막 값보다 큰 경우, LIS의 길이를 증가시키고 현재 값을 추가
        if (lis[length - 1] < key) {
            length++;
            lis[length - 1] = key;
        } else {
            // 이분 탐색을 활용하여 현재 값이 들어갈 위치를 찾아 LIS를 갱신
            int low = 0;
            int high = length;
            while (low < high) {
                int mid = (low + high) / 2;

                if (lis[mid] < key) {
                    low = mid + 1;
                } else {
                    high = mid;
                }
            }

            lis[low] = key;
        }

        // 다음 인덱스로 이동하여 재귀적으로 LIS 계산
        LIS(A + 1);
        return length;
    }
}
