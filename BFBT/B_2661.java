package BFBT;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B_2661 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        backtracking(N, "");
    }

    private static void backtracking(int N, String result) {
        if (result.length() == N) {
            System.out.println(result);
            System.exit(0); // 현재 실행하고 있는 프로세스를 강제 종료

        } else {
            for (int i = 1; i <= 3; i++) {
                if (isGoodSequence(result + i)) {
                    backtracking(N, result + i);
                }
            }
        }
    }

    private static boolean isGoodSequence(String s) {
        int length = s.length() / 2;

        for (int i = 1; i <= length; i++) {
            if (s.substring(s.length() - i).equals(s.substring(s.length() - 2 * i, s.length() - i))) {
                return false;
            }
        }

        return true;
    }
}
