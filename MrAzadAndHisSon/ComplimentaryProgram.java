package UVa.MrAzadAndHisSon;

/**
 * Created by Nirmit on 13-Mar-16.
 */
public class ComplimentaryProgram
{
    public static void main(String[] args)
    {
        int num = 101136;
        for (int i = 0; i < num; i++)
        {
            int ans = ((1 << (i - 1)) * ((1 << i) - 1));
            System.out.println("I = " + i + " ans = " + ans + " num = " + num);
        }
    }
}
