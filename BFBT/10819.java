package BFBT;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 시간복잡도 : O(n!)
// 메모리 : 14788kb
// 시간 : 152ms

public class B_10819 {

    static int n;
    static int[] arr;
    static int[] dfsArr;
    static int max = 0;

    public static void main(String[] args) throws IOException {

        //BufferReader 사용으로 입출력 시간 단축

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        arr = new int[n];
        dfsArr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        dfs(0);
        System.out.println(max);
    }

    //DFS로 배열 순회 및 방문체크 하며 모든 경우의 수 만들기 (브루트포스)

    public static void dfs(int cnt) {
        if (cnt == n) {
            calculateMax();
            return;
        }

        for (int i = 0; i < n; i++) {
            if (dfsArr[i] == 0) {
                dfsArr[i] = arr[cnt];
                dfs(cnt + 1);
                dfsArr[i] = 0;
            }
        }
    }

    // 문제의 조건에 맞게 최댓값 탐색

    public static void calculateMax() {
        int plus = 0;

        for (int i = 0; i < n - 1; i++) {
            plus += Math.abs(dfsArr[i] - dfsArr[i + 1]);
        }

        max = Math.max(max, plus);
    }
}
