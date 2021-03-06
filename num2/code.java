import java.io.*;
import java.util.Arrays;

public class code {
    public static void main(String[] args) throws Exception{
        run();
    }

    public static void run() throws Exception{
        BufferedReader br = new BufferedReader(new FileReader("data.txt"));
        String line;
        int totalpaper = 0;
        while ((line = br.readLine()) != null){
            String[] dimenString = line.split("x");
            int[] dimensions = new int[dimenString.length];
            for (int i = 0; i < dimenString.length; i ++){
                dimensions[i] = Integer.parseInt(dimenString[i]);
            }
            int s1 = dimensions[0] * dimensions[1];
            int s2 = dimensions[1] * dimensions[2];
            int s3 = dimensions[2] * dimensions[0];
            int[] sides = {s1, s2, s3};
            int min = min(sides);
            totalpaper += 2 * s1 + 2 * s2 + 2 * s3 + min;
        }
        System.out.println(totalpaper);
        br.close();
    }

    public static int min(int[] data){
        int min = data[0];
        for (int i = 0; i < data.length; i ++){
            if (data[i] < min){
                min = data[i];
            }
        }
        return min;
    }

    public static String arr2String(int[] arr){
        String str = "[";
        for (int i = 0; i < arr.length; i ++){
            str += arr[i];
            if (i != arr.length - 1){
                str += ", ";
            }
        }
        return str + "]";
    }
}
