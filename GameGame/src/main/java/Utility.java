import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Utility {
    public static boolean[] StringToBoolean(String string)
    {
        ArrayList<Boolean> booleans = new ArrayList<>();
        char[] rawBoolean = string.toCharArray();
        for(char i : rawBoolean)
        {
            if(i == '1'){
                booleans.add(true);
            }
            else if(i == '0')
            {
                booleans.add(false);
            }
        }
        boolean[] b = new boolean[booleans.size()];
        for(int i = 0; i < booleans.size(); i++)
        {
            b[i] = booleans.get(i);
        }
        return b;
    }
    public static boolean[][] StringToBoolean2D(String filename)
    {
        boolean[][] arr = new boolean[0][];
        try {
            Scanner scanner = new Scanner(new File(filename));
            ArrayList<boolean[]> booleans = new ArrayList<>();
            while (scanner.hasNextLine()) {
                booleans.add(StringToBoolean(scanner.nextLine()));
            }
            scanner.close();
            arr = new boolean[booleans.size()][];
            for(int i = 0; i < booleans.size(); i++)
            {
                arr[i] = booleans.get(i);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return arr;
    }
}
