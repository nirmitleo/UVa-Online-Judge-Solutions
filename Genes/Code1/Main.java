package UVa.Genes.Code1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.TreeMap;

/**
 * Created by DELL on 21-Apr-16.
 */
public class Main
{

    private String line;
    private String tokens[];
    private BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private TreeMap<String, Person> map = new TreeMap<String, Person>();

    public static void main(String ar[]) throws IOException
    {
        Main demo = new Main();
        demo.solve();
    }

    public void solve() throws IOException
    {

        int n = Integer.parseInt(br.readLine().trim());
        while (n-- > 0)
        {
            tokens = br.readLine().trim().split("[ ]+");
            if (tokens[1].equals("non-existent") || tokens[1].equals("recessive") || tokens[1].equals("dominant"))
            {
                String name = tokens[0];
                String gene = tokens[1];
                Person person = new Person(name, gene);
                map.put(name, person);
            } else
            {
                String name = tokens[1];
                String parent = tokens[0];
                Person person = map.get(name);
                if (person != null)
                {
                    person.parent2 = parent;
                } else
                {
                    person = new Person(name, null);
                    person.parent1 = parent;
                }
                map.put(name, person);
            }
        }
        boolean isFirst = true;
        for (Map.Entry<String, Person> entry : map.entrySet())
        {
            Person person = entry.getValue();
            person.gene = getGene(person.name);
            if (isFirst)
            {
                System.out.print(person.name + " " + person.gene);
                isFirst = false;
            } else
            {
                System.out.print("\n" + person.name + " " + person.gene);
            }
        }
    }

    public String getGene(String name)
    {
        Person person = map.get(name);
        if (person.parent1 != null && person.parent2 != null)
        {
            Person parent1 = map.get(person.parent1);
            Person parent2 = map.get(person.parent2);
            if (parent1.gene == null)
            {
                parent1.gene = getGene(parent1.name);
            }
            if (parent2.gene == null)
            {
                parent2.gene = getGene(parent2.name);
            }
            if ((parent1.gene.equals("non-existent") && parent2.gene.equals("non-existent")) && (!parent1.gene.equals("dominant") && !parent2.gene.equals("dominant")))
            {
                person.gene = "non-existent";
            } else if ((parent1.gene.equals("dominant") && parent2.gene.equals("dominant")) || (parent1.gene.equals("dominant") && parent2.gene.equals("recessive")) || (parent1.gene.equals("recessive") || parent2.gene.equals("dominant")))
            {
                person.gene = "dominant";
            } else
            {
                person.gene = "recessive";
            }
        }
        return person.gene;
    }
}


class Person implements Comparable<Person>
{
    String name;
    String parent1;
    String parent2;
    String gene;

    public Person(String name, String gene)
    {
        this.name = name;
        this.gene = gene;
    }


    public int compareTo(Person that)
    {
        return this.name.toLowerCase().compareTo(that.name.toLowerCase());
    }
}

