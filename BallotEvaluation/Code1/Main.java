package UVa.BallotEvaluation.Code1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.TreeMap;

/**
 * Created by DELL on 23-Apr-16.
 */
public class Main
{

    private String line;
    private String tokens[];
    private BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String ar[]) throws IOException
    {
        Main demo = new Main();
        demo.solve();
    }

    public void solve() throws IOException
    {
        tokens = br.readLine().trim().split("[ ]+");
        int parties = Integer.parseInt(tokens[0]);
        int guess = Integer.parseInt(tokens[1]);

        TreeMap<String, Integer> poll = new TreeMap<String, Integer>();
        while (parties-- > 0)
        {
            tokens = br.readLine().split("[ ]+");
            String key = tokens[0];
            int value = (int) (Double.parseDouble(tokens[1]) * 10);
            poll.put(key, value);
        }

        for (int g = 1; g <= guess; g++)
        {
            int sum = 0;
            int value = 0;
            String expression = br.readLine().trim();

            tokens = expression.split("[ ]+");
            for (int i = 0; i < tokens.length; i++)
            {
                Integer temp = poll.get(tokens[i]);
                if (temp != null)
                {
                    sum += temp;
                }
            }

            if (expression.contains("<="))
            {
                value = Integer.parseInt(expression.substring(expression.indexOf("<=") + 2).trim());
                value *= 10;
                if (sum <= value)
                {
                    System.out.println("Guess #" + g + " was correct.");
                } else
                {
                    System.out.println("Guess #" + g + " was incorrect.");
                }
            } else if (expression.contains("<"))
            {
                value = Integer.parseInt(expression.substring(expression.indexOf("<") + 1).trim());
                value *= 10;
                System.out.println("Sum = " + sum);
                System.out.println("Value = " + value);

                if (sum < value)
                {
                    System.out.println("Guess #" + g + " was correct.");
                } else
                {
                    System.out.println("Guess #" + g + " was incorrect.");
                }
            } else if (expression.contains(">="))
            {
                value = Integer.parseInt(expression.substring(expression.indexOf(">=") + 2).trim());
                value *= 10;
                if (sum >= value)
                {
                    System.out.println("Guess #" + g + " was correct.");
                } else
                {
                    System.out.println("Guess #" + g + " was incorrect.");
                }
            } else if (expression.contains(">"))
            {
                value = Integer.parseInt(expression.substring(expression.indexOf(">") + 1).trim());
                value *= 10;
                if (sum > value)
                {
                    System.out.println("Guess #" + g + " was correct.");
                } else
                {
                    System.out.println("Guess #" + g + " was incorrect.");
                }
            } else
            {
                value = Integer.parseInt(expression.substring(expression.indexOf("=") + 1).trim());
                value *= 10;
                if (sum == value)
                {
                    System.out.println("Guess #" + g + " was correct.");
                } else
                {
                    System.out.println("Guess #" + g + " was incorrect.");
                }
            }
        }
    }
}

