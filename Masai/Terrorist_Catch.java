package Masai;

import java.util.*;

public class Terrorist_Catch {
    static int T, N, M;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static char[][] grid;
    static boolean[][] visited;
    static int ans;
    static Queue<int[]> q;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        T = sc.nextInt();
        while (T-- > 0) {
            N = sc.nextInt();
            M = sc.nextInt();
            grid = new char[N][M];
            visited = new boolean[N][M];
            ans = 0;
            for (int i = 0; i < N; i++) {
                grid[i] = sc.next().toCharArray();
            }
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (!visited[i][j]) {
                        bfs(i, j);
                        ans++;
                    }
                }
            }
            System.out.println(ans);
        }
    }
    public static void bfs(int x, int y) {
        q = new LinkedList<>();
        q.add(new int[]{x, y});
        visited[x][y] = true;
        while (!q.isEmpty()) {
            int[] curr = q.poll();
            int currX = curr[0], currY = curr[1];
            for (int i = 0; i < 4; i++) {
                int newX = currX + dx[i];
                int newY = currY + dy[i];
                if (newX >= 0 && newX < N && newY >= 0 && newY < M && grid[newX][newY] == grid[currX][currY] && !visited[newX][newY]) {
                    visited[newX][newY] = true;
                    q.add(new int[]{newX, newY});
                }
            }
        }
    }
}

