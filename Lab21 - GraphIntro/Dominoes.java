import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Dominoes {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner scanner = new Scanner(new File("play.txt"));
        int t = scanner.nextInt(); // number of test cases

        while (t-- > 0) {
            int n = scanner.nextInt(); // number of domino tiles
            int m = scanner.nextInt(); // number of domino pairs that affect each other
            int l = scanner.nextInt(); // number of dominoes knocked by hand
            Map<Integer, List<Integer>> graph = new HashMap<>();

            // build the graph of domino pairs
            for (int i = 0; i < m; i++) {
                int x = scanner.nextInt();
                int y = scanner.nextInt();
                graph.computeIfAbsent(x, key -> new ArrayList<>()).add(y);
            }

            // simulate the domino effect
            Set<Integer> knockedDown = new HashSet<>();
            for (int i = 0; i < l; i++) {
                int z = scanner.nextInt();
                knockDown(z, graph, knockedDown);
            }

            // print the number of fallen dominos
            System.out.println(knockedDown.size());
        }
    }

    private static void knockDown(int z, Map<Integer, List<Integer>> graph, Set<Integer> knockedDown) {
        if (knockedDown.contains(z)) {
            return; // already knocked down
        }
        knockedDown.add(z);
        if (graph.containsKey(z)) {
            for (int neighbor : graph.get(z)) {
                knockDown(neighbor, graph, knockedDown);
            }
        }
    }
}
