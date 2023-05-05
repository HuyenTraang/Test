import java.io.*;

public class Test {
    public static void main(String[] args) {
        try {
            int Width = Obstacle.SCREEN_WIDTH+1;
            int Height = Obstacle.SCREEN_HEIGHT+1;
            BufferedWriter writer = new BufferedWriter(new FileWriter("Wall_Rectangle"));
            for(int i = 0; i < Width;i++)
            {
                for(int j = 0; j < Height; j++)
                {
                    if( i == 0 || i == Width-1)
                    {
                        writer.write(1+" ");
                    }
                    else
                    {
                        if(j == 0 || j == Height-1)
                        {
                            writer.write(1+" ");
                        }
                        else
                        {
                            writer.write(0+" ");
                        }
                    }
                }
                writer.newLine();
            }
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            BufferedReader reader = new BufferedReader(new FileReader("Wall_Rectangle"));
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
