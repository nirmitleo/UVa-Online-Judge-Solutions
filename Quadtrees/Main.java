package UVa.Quadtrees;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Stack;

/**
 * Created by DELL on 21-Feb-16.
 */
public class Main
{
    char image1[];
    char image2[];
    private String tokens[];
    private BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String ar[]) throws IOException
    {
        Main demo = new Main();
        demo.solve();
    }

    public void solve() throws IOException
    {
        int test = Integer.parseInt(br.readLine());
        while (test-- > 0)
        {
            char image1[] = br.readLine().toCharArray();
            char image2[] = br.readLine().toCharArray();
            Node quad1 = createQuadTree(image1);
            Node quad2 = createQuadTree(image2);
            System.out.println(printQuadTree(quad1, ""));
            System.out.println(printQuadTree(quad2, ""));
        }
    }

    public int merge(char image1[], char image2[])
    {
        int level = 0;
        int count = 0;
        int i = 0;
        int j = 0;
        while (i < image1.length && j < image2.length)
        {
            if (image1[i] == 'f' || image2[j] == 'f')
            {
                count++;
            }
            // else if (image1[i] == 'p' && image2[])
        }
        return -1;
    }

    public String printQuadTree(Node quad, String path)
    {
        path += (quad.isParent ? "p" : quad.isBlack ? "f" : "e");
        for (int i = 0; quad.childs != null && i < quad.childs.length; i++)
        {
            path = printQuadTree(quad.childs[i], path);
        }
        return path;
    }


    public Node mergeQuadTree(Node q1, Node q2)
    {
        Node q3 = new Node(true, false);
        LinkedList<Node> queue1 = new LinkedList<Node>();
        LinkedList<Node> queue2 = new LinkedList<Node>();
        LinkedList<Node> queue3 = new LinkedList<Node>();
        queue1.add(q1);
        queue2.add(q2);
        while (!queue1.isEmpty() && !queue2.isEmpty())
        {
            Node node1 = queue1.poll();
            Node node2 = queue2.poll();
            Node node3 = null;

        }
        return null;
    }

    public Node createQuadTree(char image[])
    {
        Stack<Node> stack = new Stack<Node>();
        for (int i = image.length - 1; i >= 0; i--)
        {
            if (image[i] == 'p')
            {
                Node parent = new Node(true, false);
                parent.childs = new Node[4];
                int count = 0;
                while (!stack.isEmpty() && count != 4)
                {
                    parent.childs[count++] = stack.pop();
                }
                stack.push(parent);
            }
            else
            {
                stack.push(new Node(false, image[i] == 'f'));
            }
        }
        return stack.pop();
    }
}


class Node
{
    boolean isParent;
    boolean isBlack;
    Node childs[];

    public Node(boolean isParent, boolean isBlack)
    {
        this.isParent = isParent;
        this.isBlack = isBlack;
    }
}
