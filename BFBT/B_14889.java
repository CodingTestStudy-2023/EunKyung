package BFBT;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B_14889 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[][] map = new int[N][N];
        boolean[] visit = new boolean[N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int min = Integer.MAX_VALUE;

        // idx는 인덱스, count는 조합 개수(=재귀 깊이)
        for (int i = 0; i < N; i++) {
            boolean[] tempVisit = new boolean[N];
            tempVisit[i] = true;
            min = Math.min(min, combi(N, map, tempVisit, i, 1));
        }

        System.out.println(min);
    }

    // idx는 인덱스, count는 조합 개수(=재귀 깊이)
    static int combi(int N, int[][] map, boolean[] tempVisit, int idx, int count) {
        // 팀 조합이 완성될 경우
        if (count == N / 2) {
            return diff(N, map, tempVisit);
        }

        int min = Integer.MAX_VALUE;

        for (int i = idx + 1; i < N; i++) {
            // 방문하지 않았다면?
            if (!tempVisit[i]) {
                tempVisit[i] = true;    // 방문으로 변경
                min = Math.min(min, combi(N, map, tempVisit, i, count + 1));    // 재귀 호출
                tempVisit[i] = false;    // 재귀가 끝나면 비방문으로 변경
            }
        }

        return min;
    }

    // 두 팀의 능력치 차이를 계산하는 함수
    static int diff(int N, int[][] map, boolean[] tempVisit) {
        int teamStart = 0;
        int teamLink = 0;

        for (int i = 0; i < N - 1; i++) {
            for (int j = i + 1; j < N; j++) {
                // i 번째 사람과 j 번째 사람이 true라면 스타트팀으로 점수 플러스
                if (tempVisit[i] && tempVisit[j]) {
                    teamStart += map[i][j];
                    teamStart += map[j][i];
                }
                // i 번째 사람과 j 번째 사람이 false라면 링크팀으로 점수 플러스
                else if (!tempVisit[i] && !tempVisit[j]) {
                    teamLink += map[i][j];
                    teamLink += map[j][i];
                }
            }
        }
        // 두 팀의 점수 차이 (절댓값)
        return Math.abs(teamStart - teamLink);
    }
}
