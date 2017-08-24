package UVa.GalacticImport;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;

/**
 * Created by DELL on 15-Feb-16.
 */
public class Main
{
    boolean a[][];
    int queue[];
    boolean visited[];
    double score[];
    boolean isWilling[];
    ArrayList<String> connections;
    TreeMap<Integer, Character> pair;
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String arp[]) throws IOException
    {
        Main demo = new Main();
        demo.solve();
    }

    public void solve() throws IOException
    {
        String line = "";
        while ((line = br.readLine()) != null)
        {
            /*if (line.length() == 0)
            {
                continue;
            }*/
            int n = Integer.parseInt(line);
            a = new boolean[n][n];
            score = new double[n];
            visited = new boolean[n];
            isWilling = new boolean[n];
            queue = new int[n];
            pair = new TreeMap<Integer, Character>();
            connections = new ArrayList<String>();
            for (int i = 0; i < visited.length; i++)
            {
                String tokens[] = br.readLine().split(" ");
                pair.put(i, tokens[0].charAt(0));
                score[i] = Double.parseDouble(tokens[1]);
                connections.add(tokens[2]);
            }

            for (int i = 0; i < connections.size(); i++)
            {
                String connection = connections.get(i);
                for (int j = 0; j < connection.length(); j++)
                {
                    char ch = connection.charAt(j);
                    if (ch == '*')
                    {
                        isWilling[i] = true;
                    }
                    else
                    {
                        int key = -1;
                        for (Map.Entry<Integer, Character> entry : pair.entrySet())
                        {
                            if (ch == entry.getValue())
                            {
                                key = entry.getKey();
                                break;
                            }
                        }
                        a[i][key] = a[key][i] = true;
                    }
                }
            }
            System.out.println("Import from " + pair.get(bfs(0)));
        }
    }

    public int bfs(int start)
    {
        int front = -1;
        int rear = -1;
        double max = score[start];
        int maxID = start;
        queue[++rear] = start;
        visited[start] = true;
        while (front != rear)
        {
            start = queue[++front];
            for (int i = 0; i < visited.length; i++)
            {
                if (i != start && a[start][i] && !visited[i])
                {
                    if (max < score[i])
                    {
                        max = score[i];
                        maxID = i;
                    }
                    else if (max == score[i] && pair.get(maxID) > pair.get(i))
                    {
                        if ((!isWilling[maxID] && isWilling[i]) || (isWilling[maxID] == isWilling[i]))
                        {
                            maxID = i;
                        }
                    }
                    visited[i] = true;
                    queue[++rear] = i;
                }
            }
        }
        return maxID;
    }
}
