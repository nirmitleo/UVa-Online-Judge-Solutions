package UVa.ICanGuessTheDataStructure.Code1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Stack;

/**
 * Created by DELL on 24-Apr-16.
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
        while (true)
        {
            line = br.readLine();
            if (line == null || line.trim().length() == 0)
            {
                return;
            }
            int size = Integer.parseInt(line.trim());
            PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
            Stack<Integer> stack = new Stack<Integer>();
            LinkedList<Integer> queue = new LinkedList<Integer>();
            boolean isStack = true;
            boolean isPQ = true;
            boolean isQ = true;
            while (size-- > 0)
            {
                tokens = br.readLine().trim().split("[ ]+");
                int code = Integer.parseInt(tokens[0]);
                int element = Integer.parseInt(tokens[1]);
                if (code == 1)
                {
                    if (isPQ)
                    {
                        pq.add(-element);
                    }
                    if (isStack)
                    {
                        stack.push(element);
                    }
                    if (isQ)
                    {
                        queue.add(element);
                    }
                } else
                {
                    int temp = -1;
                    if (isPQ)
                    {
                        if (pq.size() > 0)
                        {
                            temp = -pq.poll();
                            if (temp != element)
                            {
                                isPQ = false;
                            }
                        } else
                        {
                            isPQ = false;
                        }
                    }

                    if (isQ)
                    {
                        if (queue.size() > 0)
                        {
                            temp = queue.pollFirst();
                            if (temp != element)
                            {
                                isQ = false;
                            }
                        } else
                        {
                            isQ = false;
                        }
                    }

                    if (isStack)
                    {
                        if (stack.size() > 0)
                        {
                            temp = stack.pop();
                            if (temp != element)
                            {
                                isStack = false;
                            }
                        } else
                        {
                            isStack = false;
                        }
                    }
                }
            }
            if (isPQ || isQ || isStack)
            {
                if (isPQ && !isQ && !isStack)
                {
                    System.out.println("priority queue");
                } else if (isQ && !isPQ && !isStack)
                {
                    System.out.println("queue");
                } else if (isStack && !isPQ && !isQ)
                {
                    System.out.println("stack");
                } else
                {
                    System.out.println("not sure");
                }
            } else
            {
                System.out.println("impossible");
            }
        }
    }
}

