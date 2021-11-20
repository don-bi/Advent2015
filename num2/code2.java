import java.io.*;
import java.util.Arrays;

public class code2 {
    public static void main(String[] args) throws Exception{
        run();
    }

    public static void run() throws Exception{
        BufferedReader br = new BufferedReader(new FileReader("data.txt"));
        String line;
        int ribbon = 0;
        while ((line = br.readLine()) != null){
            String[] dimenString = line.split("x");
            int[] dimensions = new int[dimenString.length];
            for (int i = 0; i < dimenString.length; i ++){
                dimensions[i] = Integer.parseInt(dimenString[i]);
            }
            int perim = ribbon(dimensions);
            //System.out.println(perim);
            ribbon += perim + dimensions[0] * dimensions[1] * dimensions[2];
            //System.out.println(perim + dimensions[0] * dimensions[1] * dimensions[2]);
        }
        System.out.println(ribbon);
        br.close();
    }

    public static int max(int[] data){
        int max = data[0];
        for (int i = 0; i < data.length; i ++){
            if (data[i] > max){
                max = data[i];
            }
        }
        return max;
    }

    public static int ribbon(int[] data){
        int max = max(data);
        int halfperim = 0;
        for (int i = 0; i < data.length; i ++){
            if (data[i] != max){
                halfperim += data[i];
            }
        }
        return halfperim * 2;
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
