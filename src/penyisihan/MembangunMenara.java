package penyisihan;

import java.util.Scanner;

public class MembangunMenara {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int items = scanner.nextInt();
        String[] results = new String[items];
        for(int i = 0; i < items; i++){
            int elements = scanner.nextInt();
            scanner.nextLine();
            int[][] arr = new int[elements][3];
            for (int j = 0; j < elements; j++) {
                String[] line = scanner.nextLine().split(" ");
                for(int k = 0; k < line.length; k++){
                    arr[j][k] = Integer.parseInt(line[k]);
                }
            }
            results[i] = minAndMax(arr);
        }

        for(String result:results){
            System.out.println(result);
        }
    }

    static String minAndMax(int[][] arr){
        int resultMin = 0;
        int resultMax = 0;

        for(int[] i:arr){
            int min = i[0];
            int max = i[0];
            for(int j = 1; j < i.length; j++){
                min = Math.min(min, i[j]);
                max = Math.max(max, i[j]);
            }
            resultMin += min;
            resultMax += max;
        }

        return resultMin + " " + resultMax;
    }
}
