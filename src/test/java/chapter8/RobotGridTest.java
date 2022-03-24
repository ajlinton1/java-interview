package chapter8;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

public class RobotGridTest {

    @Test
    public void testComputePath() {
        boolean[][] maze = new boolean[3][3];

        maze[1][1] = true;
        maze[2][1] = true;

        Set<Point> result = new LinkedHashSet<>();
        var pathFound = computePath(2, 2, maze, result);

        Point[] finalResult = new Point[result.size()];

        int pos = finalResult.length - 1;
        for (Point point: result) {
            finalResult[pos--] = point;
        }

        for (int i = 0; i < finalResult.length; i++) {
            System.out.println(String.format("%d %d", finalResult[i].x, finalResult[i].y));
        }

        assertTrue(pathFound);
    }

    boolean computePath(int m, int n, boolean[][] maze, Set<Point> path) {
        if (m < 0 || n < 0) {
            return false;
        }
        if (maze[m][n]) {
            return false;
        }
        if (((m == 0) && (n == 0))
            || computePath(m, n -1, maze, path)
            || computePath(m - 1, n, maze, path)) {
                path.add(new Point(m, n));
                return true;
        }
        return false;
    }

    class Point {

        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
