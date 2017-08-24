package UVa.Councilling;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.TreeSet;

/**
 * Created by DELL on 15-Oct-16.
 */
public class Main
{
    private int nodes;
    private int source;
    private int target;
    private int clubFirst;
    private int clubLast;
    private int personFirst;
    private int personLast;
    private int partyFirst;
    private int partyLast;


    private int INF = 1000 * 1000;
    private int flow;
    private int maxFlow;
    private int dist[];
    private int parent[];
    private int g[][];

    private ArrayList<Person> persons;
    private TreeSet<String> uniqueParties;
    private TreeSet<String> uniqueClubs;
    private ArrayList<String> partyList;
    private ArrayList<String> clubList;

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
        int test = Integer.parseInt(br.readLine().trim());
        br.readLine();
        boolean isFirst = true;
        for (int t = 0; t < test; t++)
        {
            boolean isDataRead = false;
            persons = new ArrayList<Person>();
            uniqueParties = new TreeSet<String>();
            uniqueClubs = new TreeSet<String>();
            partyList = new ArrayList<String>();
            clubList = new ArrayList<String>();
            while (true)
            {
                line = br.readLine();
                if (line == null || line.trim().length() == 0)
                {
                    break;
                }
                isDataRead = true;
                tokens = line.trim().split("[ ]+");
                String name = tokens[0].trim();
                String party = tokens[1].trim();
                TreeSet<String> clubs = new TreeSet<String>();
                for (int i = 2; i < tokens.length; i++)
                {
                    clubs.add(tokens[i]);
                }
                Person person = new Person(name, party, clubs);
                persons.add(person);
                uniqueParties.add(party);
                uniqueClubs.addAll(clubs);
            }
            if (isDataRead)
            {
                clubList.addAll(uniqueClubs);
                partyList.addAll(uniqueParties);

                int totalClubs = uniqueClubs.size();
                int totalPersons = persons.size();
                int totalParties = uniqueParties.size();
                nodes = totalClubs + totalPersons + totalParties + 2;
                source = 0;
                target = nodes - 1;
                clubFirst = source + 1;
                clubLast = clubFirst + totalClubs - 1;
                personFirst = clubLast + 1;
                personLast = personFirst + totalPersons - 1;
                partyFirst = personLast + 1;
                partyLast = partyFirst + totalParties - 1;
                g = new int[nodes][nodes];

                for (int i = 0; i < persons.size(); i++)
                {
                    Person p = persons.get(i);
                    int personIndex = personFirst + i;
                    while (!p.clubs.isEmpty())
                    {
                        int clubIndex = getClubIndex(p.clubs.pollFirst());
                        g[clubIndex][personIndex] = INF;
                        g[source][clubIndex] = 1;
                    }
                    int partyIndex = getPartyIndex(p.party);
                    g[personIndex][partyIndex] = INF;
                    g[partyIndex][target] = 1;
                }
                maxFlow = 0;
                while (true)
                {
                    flow = 0;
                    dist = new int[nodes];
                    parent = new int[nodes];
                    LinkedList<Integer> queue = new LinkedList<Integer>();

                    Arrays.fill(dist, INF);
                    Arrays.fill(parent, -1);
                    dist[source] = 0;
                    queue.add(source);
                    while (!queue.isEmpty())
                    {
                        int u = queue.pollFirst();
                        if (u == target)
                        {
                            break;
                        }
                        for (int i = 0; i < nodes; i++)
                        {
                            if (g[u][i] > 0 && dist[i] == INF)
                            {
                                dist[i] = dist[u] + 1;
                                parent[i] = u;
                                queue.add(i);
                            }
                        }
                    }
                    augment(target, INF);
                    if (flow == 0)
                    {
                        break;
                    }
                    maxFlow += flow;
                }
                if (maxFlow <= partyList.size())
                {
                    for (int i = partyFirst; i <= partyLast; i++)
                    {
                        for (int j = personFirst; j <= personLast; j++)
                        {
                            //System.out.println("g[" + i + "][" + j + "] = " + g[i][j]);
                            if (g[i][j] > 0)
                            {
                                for (int k = clubFirst; k <= clubLast; k++)
                                {
                                    if (g[j][k] > 0)
                                    {
                                        if (isFirst)
                                        {
                                            System.out.print(persons.get(j - personFirst).name + " " + clubList.get(k - clubFirst));
                                            isFirst = false;
                                        } else
                                        {
                                            System.out.print("\n" + persons.get(j - personFirst).name + " " + clubList.get(k - clubFirst));
                                        }
                                    }
                                }
                            }
                        }
                    }
                } else
                {
                    if (isFirst)
                    {
                        isFirst = false;
                        System.out.print("Impossible.");
                    } else
                    {
                        System.out.print("\nImpossible.");
                    }
                }
                if (t != test)
                {
                    System.out.println();
                }
            }
        }
    }

    public void augment(int node, int minEdge)
    {
        if (node == source)
        {
            flow = minEdge;
        } else if (parent[node] != -1)
        {
            augment(parent[node], Math.min(minEdge, g[parent[node]][node]));
            g[parent[node]][node] -= flow;
            g[node][parent[node]] += flow;
        }
    }

    public int getPartyIndex(String partyName)
    {
        for (int i = 0; i < partyList.size(); i++)
        {
            if (partyName.equalsIgnoreCase(partyList.get(i)))
            {
                return i + partyFirst;
            }
        }
        return -1;
    }

    public int getClubIndex(String clubName)
    {
        for (int i = 0; i < clubList.size(); i++)
        {
            if (clubList.get(i).equalsIgnoreCase(clubName))
            {
                return i + clubFirst;
            }
        }
        return -1;
    }
}

class Person implements Comparable<Person>
{
    String name;
    String party;
    TreeSet<String> clubs;

    public Person(String name, String party, TreeSet<String> clubs)
    {
        this.name = name;
        this.party = party;
        this.clubs = clubs;
    }

    public int compareTo(Person that)
    {
        return this.name.compareToIgnoreCase(that.name);
    }

}