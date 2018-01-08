package UVa.PreInAndPost.Code1;

import ScrapCoding.CrapFastPrinter.FastPrinter;
import ScrapCoding.CrapFastScanner.FastScanner;

public class PreInAndPost
{
    private String inorder;
    private String preorder;


    public void solve(int testNumber, FastScanner in, FastPrinter out)
    {
        int test = in.nextInt();
        for (int t = 1; t <= test; t++)
        {
            String line = in.next();
            if (line == null)
            {
                return;
            }
            int n = Integer.parseInt(line);
            preorder = in.next();
            inorder = in.next();
            String postOrder = go(0, 0, n - 1);
            out.println(postOrder);
        }
    }

    private String go(int root, int low, int high)
    {
        if (low > high)
        {
            return "";
        }
        char now = preorder.charAt(root);
        if (low == high)
        {
            return now + "";
        }
        int pos = inorder.indexOf(now);
        int leftRoot = root + 1;
        int rightRoot = root + (pos - low) + 1;
        String left = go(leftRoot, low, pos - 1);
        String right = go(rightRoot, pos + 1, high);
        return left + right + now;
    }
}
