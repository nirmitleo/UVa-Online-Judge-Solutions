package UVa.Borrowers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by DELL on 14-Oct-15.
 */
public class Main
{
    public static void main(String[] args)
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);

        TaskA a = new TaskA();
        try
        {
            a.solve(br, out);
        } catch (IOException e)
        {
            e.printStackTrace();
        } catch (CloneNotSupportedException e)
        {
            e.printStackTrace();
        }

        out.close();
    }
}

class TaskA
{
    public void solve(BufferedReader in, PrintWriter out) throws IOException, CloneNotSupportedException
    {
        ArrayList<Book> books = new ArrayList<Book>();
        ArrayList<Book> result = new ArrayList<Book>();
        String input = in.readLine();
        while (!input.equalsIgnoreCase("END"))
        {
            String title = input.substring(1, input.lastIndexOf("\""));
            String author = input.substring(input.indexOf("by") + 3);
            books.add(new Book(title, author, true));
            input = in.readLine();
        }
        input = in.readLine();
        while (!input.equalsIgnoreCase("END"))
        {
            if (input.indexOf("BORROW") != -1)
            {
                String title = input.substring(input.indexOf("\"") + 1, input.lastIndexOf("\""));
                for (int i = 0; i < books.size(); i++)
                {
                    Book temp = books.get(i);
                    if (temp.title.equalsIgnoreCase(title))
                    {
                        temp.isAvailable = false;
                        break;
                    }
                }
            }
            else if (input.indexOf("RETURN") != -1)
            {
                String title = input.substring(input.indexOf("\"") + 1, input.lastIndexOf("\""));
                for (int i = 0; i < books.size(); i++)
                {
                    if (books.get(i).title.equalsIgnoreCase(title))
                    {
                        result.add(books.get(i).clone());
                    }
                }
            }
            else if (input.indexOf("SHELVE") != -1)
            {
                Collections.sort(books);
                Collections.sort(result);
                for (int i = 0; i < result.size(); i++)
                {
                    Book recentAvailable = null;
                    for (int j = 0; j < books.size(); j++)
                    {
                        if (books.get(j).isAvailable)
                        {
                            recentAvailable = books.get(j);
                        }
                        if (result.get(i).author.equalsIgnoreCase(books.get(j).author) && result.get(i).title.equalsIgnoreCase(books.get(j).title))
                        {
                            if (recentAvailable == null)
                            {
                                out.println("Put \"" + books.get(j).title + "\" first");

                            }
                            else
                            {
                                out.println("Put \"" + books.get(j).title + "\" after \"" + recentAvailable.title + "\"");
                            }
                            books.get(j).isAvailable = true;
                            break;
                        }

                    }
                }
                out.println("END");
                result = new ArrayList<Book>();
            }
            input = in.readLine();
        }

    }
}

class Book extends Object implements Comparable<Book>, Cloneable
{
    public String title;
    public String author;
    public boolean isAvailable;

    public Book(String title)
    {
        this.title = title;
    }

    public Book(String title, String author, boolean isAvailable)
    {
        this.title = title;
        this.author = author;
        this.isAvailable = isAvailable;
    }

    public int compareTo(Book that)
    {
        if (this.author.compareTo(that.author) < 0)
        {
            return -1;
        }
        if (this.author.compareTo(that.author) > 0)
        {
            return +1;
        }
        if (this.author.compareTo(that.author) == 0)
        {
            if (this.title.compareTo(that.title) < 0)
            {
                return -1;
            }
            if (this.title.compareTo(that.title) > 0)
            {
                return +1;
            }
        }
        return 0;
    }

    public Book clone() throws CloneNotSupportedException
    {
        return (Book) super.clone();
    }

}


