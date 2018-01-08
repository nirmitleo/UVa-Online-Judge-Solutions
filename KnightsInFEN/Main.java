package UVa.KnightsInFEN;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.TreeMap;
import java.util.TreeSet;

/**
 * Created by DELL on 18-Feb-16.
 */
public class Main
{
    TreeMap<String, Integer> visited;
    TreeSet<State> queue;
    String end = "111110111100 110000100000";
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String arp[]) throws IOException
    {
        Main demo = new Main();
        demo.solve();
    }

    public void solve() throws IOException
    {
        int test = Integer.parseInt(br.readLine());
        while (test-- > 0)
        {
            String start = "";
            for (int i = 0; i < 5; i++)
            {
                String line = br.readLine();
                for (int j = 0; j < 5; j++)
                {
                    start += line.charAt(j);
                }
            }
            visited = new TreeMap<String, Integer>();
            queue = new TreeSet<State>();
            int steps = bfs(new State(start, 0));
            if ( steps < 0 )
            {
                System.out.println("Unsolvable in less than 11 move(s).");
            } else
            {
                System.out.println("Solvable in " + steps + " move(s).");
            }
        }
    }

    public int bfs(State start)
    {
        queue.add(start);
        visited.put(start.id, start.layer);
        while (!queue.isEmpty())
        {
            start = queue.pollFirst();
            //System.out.println("Current state = " + start.id + " layer = " + start.layer);
            if ( start.id.equals(end) )
            {
                return start.layer;
            }
            if ( start.layer < 10 )
            {
                ArrayList<State> nodes = generateStates(start);
                for (int i = 0; i < nodes.size(); i++)
                {
                    State temp = nodes.get(i);
                    if ( temp.id.equals(end) )
                    {
                        return temp.layer;
                    }
                    queue.add(temp);
                }
            }
        }
        return -1;
    }

    public ArrayList<State> generateStates(State state)
    {
        ArrayList<State> list = new ArrayList<State>();
        int index = state.id.indexOf(" ");
        State temp = null;
        if ( index - 7 >= 0 )
        {
            temp = generateState(state, index, index - 7);
            if ( temp != null )
            {
                list.add(temp);
            }
        }
        if ( index - 11 >= 0 )
        {
            temp = generateState(state, index, index - 11);
            if ( temp != null )
            {
                list.add(temp);
            }
        }
        if ( index - 9 >= 0 )
        {
            temp = generateState(state, index, index - 9);
            if ( temp != null )
            {
                list.add(temp);
            }
        }
        if ( index - 3 >= 0 )
        {
            temp = generateState(state, index, index - 3);
            if ( temp != null )
            {
                list.add(temp);
            }
        }
        if ( index + 7 < 25 )
        {
            temp = generateState(state, index, index + 7);
            if ( temp != null )
            {
                list.add(temp);
            }

        }
        if ( index + 11 < 25 )
        {
            temp = generateState(state, index, index + 11);
            if ( temp != null )
            {
                list.add(temp);
            }
        }
        if ( index + 9 < 25 )
        {
            temp = generateState(state, index, index + 9);
            if ( temp != null )
            {
                list.add(temp);
            }
        }
        if ( index + 3 < 25 )
        {
            temp = generateState(state, index, index + 3);
            if ( temp != null )
            {
                list.add(temp);
            }

        }
        return list;
    }

    public State generateState(State state, int from, int to)
    {
        char positions[] = state.id.toCharArray();
        char temp = positions[to];
        positions[to] = positions[from];
        positions[from] = temp;
        String id = new String(positions);
        int layer = state.layer + 1;
        if ( visited.get(id) == null )
        {
            visited.put(id, layer);
            return new State(id, layer);
        } else
        {
            return null;
        }
    }

    public void test()
    {
        System.out.println("1011101011101 10100100000".compareTo("1011101011101 10100100000"));
    }

}

class State implements Comparable<State>
{
    String id;
    int layer;

    public State(String id, int layer)
    {
        this.id = id;
        this.layer = layer;
    }

    public int compareTo(State that)
    {
        int diff = this.id.compareTo(that.id);
        int idDiff = this.layer - that.layer;
        return diff == 0 ? 0 : idDiff < 0 ? -1 : 1;
    }
}