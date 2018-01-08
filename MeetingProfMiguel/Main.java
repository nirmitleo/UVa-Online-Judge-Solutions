package UVa.MeetingProfMiguel;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;

/**
 * Created by DELL on 20-Feb-16.
 */
public class Main
{
    int n;
    private int young[][];
    private int mature[][];
    private TreeMap<String, Integer> nodes;
    private ArrayList<String> edges;
    private final static int MAX = 1000;
    private String tokens[];
    private BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String arp[]) throws IOException
    {
        Main demo = new Main();
        demo.solve();
    }

    public void solve() throws IOException
    {
        String line = "";
        boolean isFirst = true;
        while ((line = br.readLine()).charAt(0) != '0')
        {
            int e = Integer.parseInt(line);
            int index = 0;
            nodes = new TreeMap<String, Integer>();
            edges = new ArrayList<String>();
            for (int i = 0; i < e; i++)
            {
                line = br.readLine();
                edges.add(line);
                tokens = line.split(" ");
                String from = tokens[2];
                if (nodes.get(from) == null)
                {
                    nodes.put(from, index++);
                }
                String to = tokens[3];
                if (nodes.get(to) == null)
                {
                    nodes.put(to, index++);
                }
            }
            n = nodes.size();
            young = new int[n][n];
            mature = new int[n][n];
            for (int i = 0; i < young.length; i++)
            {
                for (int j = 0; j < young.length; j++)
                {
                    mature[i][j] = young[i][j] = (i == j) ? 0 : MAX;
                }
            }
            for (int i = 0; i < edges.size(); i++)
            {
                tokens = edges.get(i).split(" ");
                int from = nodes.get(tokens[2]);
                int to = nodes.get(tokens[3]);
                int cost = Integer.parseInt(tokens[4]);
                young[from][to] = tokens[0].equals("Y") ? cost : young[from][to];
                mature[from][to] = tokens[0].equals("M") ? cost : mature[from][to];
                if (tokens[1].equals("B"))
                {
                    young[to][from] = tokens[0].equals("Y") ? cost : young[to][from];
                    mature[to][from] = tokens[0].equals("M") ? cost : mature[to][from];
                }
            }
            for (int k = 0; k < n; k++)
            {
                for (int i = 0; i < n; i++)
                {
                    for (int j = 0; j < n; j++)
                    {
                        young[i][j] = Math.min(young[i][j], young[i][k] + young[k][j]);
                        mature[i][j] = Math.min(mature[i][j], mature[i][k] + mature[k][j]);
                    }
                }
            }
            tokens = br.readLine().split(" ");
            Integer youngStart = nodes.get(tokens[0]);
            Integer matureStart = nodes.get(tokens[1]);
            if (tokens[0].equals(tokens[1]))
            {
                if (isFirst)
                {
                    System.out.print("0 " + tokens[0]);
                    isFirst = false;
                }
                else
                {
                    System.out.print("\n0 " + tokens[0]);
                }
                continue;
            }
            if (youngStart == null || matureStart == null)
            {
                if (isFirst)
                {
                    System.out.print("You will never meet.");
                    isFirst = false;
                }
                else
                {
                    System.out.print("\nYou will never meet.");
                }
                continue;
            }
            int min = Integer.MAX_VALUE;
            for (int i = 0; i < young.length; i++)
            {
                int y = young[youngStart][i];
                int m = mature[matureStart][i];
                if (y < MAX && m < MAX)
                {
                    min = Math.min(min, y + m);
                }
            }
            if (min == Integer.MAX_VALUE)
            {
                if (isFirst)
                {
                    System.out.print("You will never meet.");
                    isFirst = false;
                }
                else
                {
                    System.out.print("\nYou will never meet.");
                }
            }
            else
            {
                String result = "";
                for (int i = 0; i < young.length; i++)
                {
                    if (min == young[youngStart][i] + mature[matureStart][i])
                    {
                        result += getNode(i) + " ";
                    }
                }
                if (isFirst)
                {
                    System.out.print(min + " " + result.trim());
                    isFirst = false;
                }
                else
                {
                    System.out.print("\n" + min + " " + result.trim());
                }
            }
        }
    }

    public void printMature()
    {
        System.out.println("*****Mature*******");
        for (int i = 0; i < mature.length; i++)
        {
            for (int j = 0; j < mature.length; j++)
            {
                System.out.printf("%8d", mature[i][j]);
            }
            System.out.println();
        }
    }

    public void printYoung()
    {
        System.out.println("*****Young*******");
        for (int i = 0; i < young.length; i++)
        {
            for (int j = 0; j < young.length; j++)
            {
                System.out.printf("%8d", young[i][j]);
            }
            System.out.println();
        }
    }


    public String getNode(int index)
    {
        for (Map.Entry<String, Integer> entry : nodes.entrySet())
        {
            if (index == entry.getValue())
            {
                return entry.getKey();
            }
        }
        return null;
    }
}
