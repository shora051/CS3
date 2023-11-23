import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Point {
    int x, y, dist;

    Point(int x, int y, int dist) {
        this.x = x;
        this.y = y;
        this.dist = dist;
    }
}

public class MazeSolver {

    private static final int[] rowNum = {-1, 0, 0, 1};
    private static final int[] colNum = {0, -1, 1, 0};

    public static void main(String[] args) {
        try {
            Scanner scanner = new Scanner(new File("maze.txt"));
            int R = scanner.nextInt();
            int C = scanner.nextInt();
            int T = scanner.nextInt();
            int[][] maze = new int[R][C];

            for (int i = 0; i < R; i++) {
                for (int j = 0; j < C; j++) {
                    maze[i][j] = scanner.nextInt();
                }
            }

            for (int t = 0; t < T; t++) {
                int startX = scanner.nextInt();
                int startY = scanner.nextInt();
                int endX = scanner.nextInt();
                int endY = scanner.nextInt();

                System.out.println(shortestPath(maze, startX, startY, endX, endY, R, C));
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    private static boolean isValid(int x, int y, int R, int C) {
        return (x >= 0) && (x < R) && (y >= 0) && (y < C);
    }

    private static int shortestPath(int[][] maze, int startX, int startY, int endX, int endY, int R, int C) {
        if (maze[startX][startY] == 0 || maze[endX][endY] == 0) {
            return -1;
        }

        boolean[][] visited = new boolean[R][C];
        visited[startX][startY] = true;

        Queue<Point> queue = new LinkedList<>();
        queue.add(new Point(startX, startY, 0));

        while (!queue.isEmpty()) {
            Point point = queue.poll();

            int x = point.x;
            int y = point.y;
            int dist = point.dist;

            if (x == endX && y == endY) {
                return dist;
            }

            for (int i = 0; i < 4; i++) {
                int newRow = x + rowNum[i];
                int newCol = y + colNum[i];

                if (isValid(newRow, newCol, R, C) && maze[newRow][newCol] == 1 && !visited[newRow][newCol]) {
                    queue.add(new Point(newRow, newCol, dist + 1));
                    visited[newRow][newCol] = true;
                }
            }
        }

        return -1;
    }
}

