package DFS;

import java.io.*;
import java.util.*;

public class B_1012 {

    static int M, N;
    static int[][] field;
    static boolean[][] visited;

    static int[] dx = {-1, 1, 0, 0}; // 상하좌우
    static int[] dy = {0, 0, -1, 1};

//16312kb 176ms
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine()); // 테스트 케이스 수

        for (int t = 0; t < T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            M = Integer.parseInt(st.nextToken()); // 배추밭의 가로 길이
            N = Integer.parseInt(st.nextToken()); // 배추밭의 세로 길이
            int K = Integer.parseInt(st.nextToken()); // 배추의 수

            field = new int[M][N];
            visited = new boolean[M][N];

            // 배추의 위치 정보를 입력받아 배추밭에 표시
            for (int i = 0; i < K; i++) {
                st = new StringTokenizer(br.readLine(), " ");
                int X = Integer.parseInt(st.nextToken());
                int Y = Integer.parseInt(st.nextToken());
                field[X][Y] = 1;
            }

            int wormCount = 0; // 필요한 지렁이(배추흰지렁이) 수

            // 전체 배추밭을 탐색하여 아직 방문하지 않은 배추가 있다면 DFS 수행
            for (int i = 0; i < M; i++) {
                for (int j = 0; j < N; j++) {
                    if (field[i][j] == 1 && !visited[i][j]) {
                        dfs(i, j);
                        wormCount++;
                    }
                }
            }

            System.out.println(wormCount);
        }
    }

    static void dfs(int x, int y) {
        visited[x][y] = true;

        // 상하좌우 인접한 위치를 탐색
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            // 배추밭을 벗어나지 않고, 아직 방문하지 않은 배추가 있다면 DFS 호출
            if (nx >= 0 && ny >= 0 && nx < M && ny < N) {
                if (field[nx][ny] == 1 && !visited[nx][ny]) {
                    dfs(nx, ny);
                }
            }
        }
    }
}
