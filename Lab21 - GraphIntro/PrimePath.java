import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

class PrimePath {
    public static void main(String[] args) {
        try {
            Scanner scanner = new Scanner(new File("primepath.txt"));
            int startPrime = scanner.nextInt();
            int endPrime = scanner.nextInt();

            int steps = findShortestPath(startPrime, endPrime);
            System.out.println(steps);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    private static boolean isPrime(int num) {
        if (num <= 1) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }

    private static List<Integer> generateNeighbors(int prime) {
    List<Integer> neighbors = new ArrayList<>();
    char[] digits = String.valueOf(prime).toCharArray();

    for (int i = 0; i < 4; i++) {
        for (int j = (i == 0 ? 1 : 0); j <= 9; j++) {
            char[] temp = digits.clone();
            temp[i] = (char) ('0' + j);
            int newNumber = Integer.parseInt(new String(temp));

            if (newNumber != prime && isPrime(newNumber)) {
                neighbors.add(newNumber);
            }
        }
    }
    return neighbors;
   } 


    private static int findShortestPath(int startPrime, int endPrime) {
        Set<Integer> visited = new HashSet<>();
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{startPrime, 0});
        visited.add(startPrime);

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int prime = current[0];
            int steps = current[1];

            if (prime == endPrime) {
                return steps;
            }

            for (int neighbor : generateNeighbors(prime)) {
                if (!visited.contains(neighbor)) {
                    queue.add(new int[]{neighbor, steps + 1});
                    visited.add(neighbor);
                }
            }
        }
        return -1;
    }
}

