import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class ScoobyPassages {
    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("scooby.txt");
        Scanner scanner = new Scanner(file);

        int n = scanner.nextInt();
        scanner.nextLine();

        for (int i = 0; i < n; i++) {
            String[] passages = scanner.nextLine().split(" ");
            String route = scanner.nextLine();
            char startRoom = route.charAt(0);
            char endRoom = route.charAt(1);
            boolean result = isRoutePossible(passages, startRoom, endRoom);
            System.out.println(result ? "yes" : "no");
        }

        scanner.close();
    }

    private static boolean isRoutePossible(String[] passages, char startRoom, char endRoom) {
        Set<Character> visitedRooms = new HashSet<>();
        Stack<Character> roomStack = new Stack<>();
        roomStack.push(startRoom);

        while (!roomStack.isEmpty()) {
            char currentRoom = roomStack.pop();
            if (currentRoom == endRoom) {
                return true;
            }

            if (!visitedRooms.contains(currentRoom)) {
                visitedRooms.add(currentRoom);
                for (String passage : passages) {
                    if (passage.contains(String.valueOf(currentRoom))) {
                        char nextRoom = passage.charAt(0) == currentRoom ? passage.charAt(1) : passage.charAt(0);
                        if (!visitedRooms.contains(nextRoom)) {
                            roomStack.push(nextRoom);
                        }
                    }
                }
            }
        }

        return false;
    }
}
