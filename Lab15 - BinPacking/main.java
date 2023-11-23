import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
import java.util.Scanner;

class Disk implements Comparable<Disk> {
    int id = 0;
    int size = 1_000_000;
    ArrayList<Integer> files = new ArrayList<Integer>();

    public Disk(int i) {
        id = i;
    }

    @Override
    public int compareTo(Disk d) {
        if (id == d.id) return 0;
        return size < d.size ? 1 : -1;
    }
}

class inputAndOutput {
    public void WorstFit(ArrayList<Integer> files) {
        int totalSize = 0;
        int disksUsed = 0;
        PriorityQueue<Disk> q = new PriorityQueue<>(Disk::compareTo);
        for (int i = 0; i < files.size(); i++) {
            totalSize += files.get(i);
            Disk foo;
            if (q.size() > 0 && q.peek().size >= files.get(i)) {
                foo = q.poll();
            } else {
                foo = new Disk(disksUsed++);
            }
            foo.size -= files.get(i);
            foo.files.add(files.get(i));
            q.add(foo);
        }
        System.out.println(q.size());
        if (q.size() < 100) {
            System.out.println("Total size = " + (double) totalSize / 1_000_000 + " GB");
            System.out.println("Disks req'd = " + q.size());
            while (q.size() > 0) {
                Disk foo = q.poll();
                System.out.print(foo.id + " " + foo.size + ": ");
                for (int i : foo.files) System.out.print(i + " ");
                System.out.println("");
            }
        }


    }
    public void WorstFitDec(ArrayList<Integer> files){
        Collections.sort(files);
        Collections.reverse(files);
        WorstFit(files);


    }

}


public class main 
{
    public static void main(String[] args) throws FileNotFoundException {

        Scanner scan = new Scanner(new File("input20.txt"));
        ArrayList<Integer> files = new ArrayList<>();
        while (scan.hasNext()) files.add(scan.nextInt());
        inputAndOutput foo = new inputAndOutput();
        foo.WorstFitDec(files);


    }


}
