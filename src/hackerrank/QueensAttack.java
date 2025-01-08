package hackerrank;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class QueensAttack {

    public static void main(String[] args) {
        List<List<Integer>> obstacles = new ArrayList<>();
        obstacles.add(Arrays.asList(5, 5));
        obstacles.add(Arrays.asList(4, 2));
        obstacles.add(Arrays.asList(2, 3));
        int result = solution1(5, 3, 4, 3, obstacles);
        System.out.println(result);
    }

    /**
     * @param n         : board size (indexing is done like quadrant in geometry)
     * @param k         : number of obstacles
     * @param rq        : queen row position (1 based index)
     * @param cq        : queen col position (1 based index)
     * @param obstacles : obstacle positions
     * @return
     */
    public static int solution2(int n, int k, int rq, int cq, List<List<Integer>> obstacles) {
        return 0;
    }

    /**
     * @param n         : board size (indexing is done like quadrant in geometry)
     * @param k         : number of obstacles
     * @param rq        : queen row position (1 based index)
     * @param cq        : queen col position (1 based index)
     * @param obstacles : obstacle positions
     * @return
     */
    public static int solution1(int n, int k, int rq, int cq, List<List<Integer>> obstacles) {
        int count = 0;
        int i;
        int j;
        //right
        i = rq;
        j = cq + 1;
        while (j <= n) {
            if (isAnObstacle(i, j, obstacles)) {
                break;
            } else {
                j++;
                count++;
            }
        }
        // left
        j = cq - 1;
        while (j > 0) {
            if (isAnObstacle(i, j, obstacles)) {
                break;
            } else {
                j--;
                count++;
            }
        }
        //up
        i = rq + 1;
        j = cq;
        while (i <= n) {
            if (isAnObstacle(i, j, obstacles)) {
                break;
            } else {
                i++;
                count++;
            }
        }
        //down
        i = rq - 1;
        while (i > 0) {
            if (isAnObstacle(i, j, obstacles)) {
                break;
            } else {
                i--;
                count++;
            }
        }
        //right-up
        i = rq + 1;
        j = cq + 1;
        while (i <= n && j <= n) {
            if (isAnObstacle(i, j, obstacles)) {
                break;
            } else {
                i++;
                j++;
                count++;
            }
        }
        //left-up
        i = rq + 1;
        j = cq - 1;
        while (i <= n && j > 0) {
            if (isAnObstacle(i, j, obstacles)) {
                break;
            } else {
                i++;
                j--;
                count++;
            }
        }
        //left-down
        i = rq - 1;
        j = cq - 1;
        while (i > 0 && j > 0) {
            if (isAnObstacle(i, j, obstacles)) {
                break;
            } else {
                i--;
                j--;
                count++;
            }
        }
        //right-down
        i = rq - 1;
        j = cq + 1;
        while (i > 0 && j <= n) {
            if (isAnObstacle(i, j, obstacles)) {
                break;
            } else {
                i--;
                j++;
                count++;
            }
        }
        return count;
    }

    public static boolean isAnObstacle(int i, int j, List<List<Integer>> obstacles) {
        return obstacles.parallelStream().anyMatch(point -> point.get(0) == i && point.get(1) == j);
    }
}
