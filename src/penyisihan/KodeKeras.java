package penyisihan;

import java.io.*;

public class KodeKeras {
    public static void main(String[] args) throws IOException {
        InputStream in = System.in;
        OutputStream out = System.out;
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(out));

        int testCaseCount = Integer.parseInt(bufferedReader.readLine());
        String[] results = new String[testCaseCount];
        for(int i = 0; i < testCaseCount; i++){
            int itemCount = Integer.parseInt(bufferedReader.readLine());
            int[][] matrix = new int[itemCount][2];
            for(int j = 0; j < itemCount; j++){
                String[] line = bufferedReader.readLine().split(" ");

                String[] time = line[0].split(":");
                matrix[j][0] = Integer.parseInt(time[0]) * 3600 +
                                Integer.parseInt(time[1]) * 60 +
                                Integer.parseInt(time[2]);

                time = line[1].split(":");
                matrix[j][1] = Integer.parseInt(time[0]) * 3600 +
                        Integer.parseInt(time[1]) * 60 +
                        Integer.parseInt(time[2]);
            }

            results[i] = minimalStatusCount(matrix);
        }

        for(String str:results)
            bufferedWriter.write(str);

        bufferedReader.close();
        bufferedWriter.close();
    }

    static String minimalStatusCount(int[][] arr){
        String result = "";

        for(int i = 0; i < arr.length; i++){
            int sum = 2, a = 0, b = 0;
            for (int j = 0; j < arr.length; j++) {
                if(j == i) continue;

                if(arr[i][0] >= arr[j][0] && arr[i][1] <= arr[j][1]){
                    //auto -1
                    sum = -1;
                    a = -1;
                    b = -1;
                    break;
                }

                if(arr[i][0] <= arr[j][0] && a != -1)
                    a = 1;
                else
                    a = -1;

                if(arr[i][1] >= arr[j][1] && b != -1)
                    b = 1;
                else
                    b = -1;
            }

            if(a == 1 || b == 1)
                result += "1\n";
            else
                result += sum +"\n";
        }
        return result;
    }
}
//TestCase:
//        2
//        4
//        08:00:00 09:00:00
//        08:20:00 08:45:00
//        08:05:00 09:40:00
//        08:15:00 10:00:00
//        3
//        00:00:00 00:00:01
//        00:00:01 00:00:10
//        00:00:02 00:00:10
