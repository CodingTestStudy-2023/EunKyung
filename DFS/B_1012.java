package DFS;

import java.io.*;
import java.util.*;

public class B_1012 {

    static int M, N;                   // 배추밭의 가로와 세로 길이
    static int[][] field;               // 배추밭의 상태를 나타내는 2D 배열
    static boolean[][] visited;         // DFS에서 방문 여부를 기록하는 2D 배열

    static int[] dx = {-1, 1, 0, 0};    // 상하좌우 이동을 위한 배열
    static int[] dy = {0, 0, -1, 1};

    // 메모리 사용량과 실행 시간 출력 주석
    // 16312kb 176ms

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine()); // 테스트 케이스 수

        for (int t = 0; t < T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            M = Integer.parseInt(st.nextToken()); // 배추밭의 가로 길이
            N = Integer.parseInt(st.nextToken()); // 배추밭의 세로 길이
            int K = Integer.parseInt(st.nextToken()); // 배추의 수

            field = new int[M][N];          // 배추밭 초기화
            visited = new boolean[M][N];    // 방문 여부 초기화

            // 배추의 위치 정보를 입력받아 배추밭에 표시
            for (int i = 0; i < K; i++) {
                st = new StringTokenizer(br.readLine(), " ");
                int X = Integer.parseInt(st.nextToken());
                int Y = Integer.parseInt(st.nextToken());
                field[X][Y] = 1;  // 배추가 있는 위치를 1로 표시
            }

            int wormCount = 0; // 필요한 지렁이(배추흰지렁이) 수

            // 전체 배추밭을 탐색하여 아직 방문하지 않은 배추가 있다면 DFS 수행
            for (int i = 0; i < M; i++) {
                for (int j = 0; j < N; j++) {
                    if (field[i][j] == 1 && !visited[i][j]) {
                        dfs(i, j);   // DFS 수행
                        wormCount++; // 연결된 구성 요소를 모두 방문한 경우, 새로운 배추 지렁이 필요
                    }
                }
            }

            System.out.println(wormCount); // 각 테스트 케이스에서 필요한 배추 지렁이 수 출력
        }
    }

    // 깊이 우선 탐색 (DFS) 함수 정의
    static void dfs(int x, int y) {
        visited[x][y] = true;  // 현재 위치를 방문했음을 표시

        // 상하좌우 인접한 위치를 탐색
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            // 배추밭을 벗어나지 않고, 아직 방문하지 않은 배추가 있다면 DFS 호출
            if (nx >= 0 && ny >= 0 && nx < M && ny < N) {
                if (field[nx][ny] == 1 && !visited[nx][ny]) {
                    dfs(nx, ny);   // DFS 재귀 호출
                }
            }
        }
    }
}
