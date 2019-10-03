package penyisihan;

import java.util.Scanner;
import java.util.SortedSet;
import java.util.TreeSet;

public class MembangunMenaraSortedSet {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int items = scanner.nextInt();
        String[] results = new String[items];
        for(int i = 0; i < items; i++){
            int elements = scanner.nextInt();
            scanner.nextLine();
            SortedSet<Integer>[] sets = new TreeSet[elements];
            for (int j = 0; j < elements; j++) {
                sets[j] = new TreeSet();
                String[] line = scanner.nextLine().split(" ");
                for(int k = 0; k < line.length; k++){
                    sets[j].add(Integer.parseInt(line[k]));
                }
            }
            results[i] = minAndMax(sets);
        }

        for(String result:results){
            System.out.println(result);
        }
    }

    static String minAndMax(SortedSet[] sets){
        int resultMin = 0;
        int resultMax = 0;

        for(SortedSet set:sets){
            resultMin += (int)set.first();
            resultMax += (int)set.last();
        }

        return resultMin + " " + resultMax;
    }
}
