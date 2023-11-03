package DFS;
import java.io.*;
import java.util.*;

public class B_10451 {

    // 그래프를 나타내는 배열 선언
    static int[] arr;
    // 방문한 노드를 추적하는 불리언 배열 선언
    static boolean[] visited;
    // 그래프 내의 순환 수를 저장하는 변수
    static int cycle;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        // 테스트 케이스의 수를 읽음
        int t = Integer.parseInt(br.readLine());

        // 각 테스트 케이스에 대해 반복
        for (int i = 0; i < t; i++) {
            // 순열의 요소 수를 읽음
            int n = Integer.parseInt(br.readLine());
            // 순열을 나타내는 배열 초기화
            arr = new int[n + 1];
            // 순환 수 초기화
            cycle = 0;

            // 순열 값을 읽고 배열을 채움
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j < n + 1; j++) {
                arr[j] = Integer.parseInt(st.nextToken());
            }

            // 방문한 노드를 추적하는 배열 초기화
            visited = new boolean[n + 1];

            // 그래프의 각 노드를 탐색
            for (int j = 1; j < n + 1; j++) {
                // 노드가 방문되지 않았다면 해당 노드에서 DFS 수행
                if (!visited[j]) {
                    DFS(j);
                    // DFS 탐색 후 순환 수 증가
                    cycle++;
                }
            }
            // 순열 내의 순환 수를 출력
            System.out.println(cycle);
        }
    }

    // 깊이 우선 탐색(DFS) 메서드
    static void DFS(int start) {
        // 현재 노드를 방문한 것으로 표시
        visited[start] = true;
        // 순열 내의 다음 노드를 얻음
        int next = arr[start];
        // 다음 노드가 방문되지 않았다면 재귀적으로 DFS 수행
        if (!visited[next]) {
            DFS(arr[start]);
        }
    }
}
