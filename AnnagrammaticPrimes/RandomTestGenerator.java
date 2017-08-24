package UVa.AnnagrammaticPrimes;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

/**
 * Created by Nirmit on 13-Mar-16.
 */
public class RandomTestGenerator
{
    public static void main(String[] args) throws IOException
    {
        BufferedWriter out = new BufferedWriter(new FileWriter(new File("./src/UVa/AnnagrammaticPrimes/out.txt")));
        Random r = new Random();
        for (int i = 1; i <= 100; i++)
        {
            out.write(r.nextInt(100) + "\n");
        }
        out.flush();
        out.close();
    }
}
