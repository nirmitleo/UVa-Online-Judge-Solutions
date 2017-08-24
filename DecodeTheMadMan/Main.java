package UVa.DecodeTheMadMan;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by DELL on 01-Feb-16.
 */
public class Main
{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String ar[]) throws IOException
    {
        Main demo = new Main();
        demo.solve();
    }

    public void solve() throws IOException
    {
        String line = "";
        while (true)
        {
            int intCharacter = br.read();
            if (intCharacter < 0)
            {
                break;
            }
            char ch = (char) intCharacter;
            System.out.print(ch == ' ' ? ' ' : ch == '\n' ? "\n" : convert(Character.toLowerCase(ch)));
        }
    }

    public char convert(char ch)
    {
        switch (ch)
        {
            case 'e':
                return 'q';
            case 'r':
                return 'w';
            case 't':
                return 'e';
            case 'y':
                return 'r';
            case 'u':
                return 't';
            case 'i':
                return 'y';
            case 'o':
                return 'u';
            case 'p':
                return 'i';
            case '[':
            case '{':
                return 'o';
            case ']':
            case '}':
                return 'p';
            case 'd':
                return 'a';
            case 'f':
                return 's';
            case 'g':
                return 'd';
            case 'h':
                return 'f';
            case 'j':
                return 'g';
            case 'k':
                return 'h';
            case 'l':
                return 'j';
            case ';':
            case ':':
                return 'k';
            case '\'':
            case '\"':
                return 'l';
            case 'c':
                return 'z';
            case 'v':
                return 'x';
            case 'b':
                return 'c';
            case 'n':
                return 'v';
            case 'm':
                return 'b';
            case ',':
            case '<':
                return 'n';
            case '.':
            case '>':
                return 'm';
        }
        return '\u0000';
    }
}
