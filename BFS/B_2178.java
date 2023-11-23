package BFS;

import java.io.*;
import java.util.*;

// BFS 버전

public class B_2178 {

    static int N;
    static int M;
    static int[][] arr;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N][M];

        // 미로 정보 입력
        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(str.substring(j, j+1)); // 문자를 숫자로 변환
            }
        }

        BFS(0, 0);
        System.out.println(arr[N - 1][M - 1]); // 도착 지점까지의 최단 거리 출력
    }

    // BFS로 미로를 탐색하면서 최단 거리를 계산하는 함수
    public static void BFS(int x, int y) {

        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{x, y});

        // 상하좌우 키

        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            x = current[0];
            y = current[1];

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                // 다음 위치가 미로 범위를 벗어난 경우 무시
                if (nx < 0 || nx >= N || ny < 0 || ny >= M) continue;

                // 다음 위치가 벽인 경우 무시
                if (arr[nx][ny] == 0) continue;

                // 처음 방문하는 경우에만 최단 거리 기록 및 큐에 추가
                if (arr[nx][ny] == 1) {
                    arr[nx][ny] = arr[x][y] + 1;
                    queue.offer(new int[]{nx, ny});
                }
            }
        }
    }
}
