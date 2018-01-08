//package UVa.HelpTheLeaders.Code1;
//
//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.util.*;
//
///**
// * Created by Nirmit on 17/06/2017.
// */
//public class PTriplets
//{
//    private int N;
//    private int E;
//    private int S;
//    private String[] names;
//    private int[] a;
//    private TreeSet<String> set;
//    private ArrayList<String> result;
//    private TreeMap<String, ArrayList<String>> exceptions = new TreeMap<String, ArrayList<String>>();
//    private String line;
//    private StringTokenizer st;
//    private BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
//
//    public static void Main(String ar[]) throws IOException
//    {
//        PTriplets demo = new PTriplets();
//        demo.test();
//    }
//
//    public void test() throws IOException
//    {
//        st = new StringTokenizer(in.readLine());
//        int test = Integer.parseInt(st.nextToken());
//        for (int t = 1; t <= test; t++)
//        {
//            st = new StringTokenizer(in.readLine());
//            N = Integer.parseInt(st.nextToken());
//            E = Integer.parseInt(st.nextToken());
//            S = Integer.parseInt(st.nextToken());
//            names = new String[N];
//            a = new int[S];
//            for (int i = 0; i < N; i++)
//            {
//                st = new StringTokenizer(in.readLine());
//                names[i] = st.nextToken().toUpperCase();
//            }
//            Arrays.sort(names, new Comparator<String>()
//            {
//
//                public int compare(String a, String b)
//                {
//                    int lenDiff = Integer.compare(b.length(), a.length());
//                    if (lenDiff == 0)
//                    {
//                        return a.compareTo(b);
//                    }
//                    return lenDiff;
//                }
//            });
//            for (int i = 0; i < E; i++)
//            {
//                st = new StringTokenizer(in.readLine());
//                String n1 = st.nextToken();
//                String n2 = st.nextToken();
//                addException(n1, n2);
//            }
//            result = new ArrayList<String>();
//            set = new TreeSet<String>(new Comparator<String>()
//            {
//                @Override
//                public int compare(String o1, String o2)
//                {
//                    int lenDiff = Integer.compare(o2.length(), o1.length());
//                    if (lenDiff == 0)
//                    {
//                        return o1.compareTo(o2);
//                    }
//                    return lenDiff;
//                }
//            });
//            bfs(0, S);
//            Collections.sort(result, new Comparator<String>()
//            {
//                @Override
//                public int compare(String o1, String o2)
//                {
//                    int lenDiff = Integer.compare(o2.length(), o1.length());
//                    if (lenDiff == 0)
//                    {
//                        return o1.compareTo(o2);
//                    }
//                    return lenDiff < 0 ? -1 : +1;
//                }
//            });
//            TreeSet<String> was = new TreeSet<String>();
////            ArrayList<String> temp = new ArrayList<String>();
////            for (int i = 0; i < result.size(); i++)
////            {
////                String[] tokens = result.get(i).split(" ");
////                String x = tokens[0];
////                if (!was.contains(x))
////                {
////                    was.add(x);
////                    for (int j = 0; j < result.size(); j++)
////                    {
////                        if (result.get(j).startsWith(x))
////                        {
////                            temp.add(result.get(j));
////                        }
////                    }
////                }
////            }
//            //result = temp;
//            StringBuilder sb = new StringBuilder("Set " + t + ":\n");
//            for (int i = 0; i < result.size(); i++)
//            {
//                sb.append(result.get(i) + "\n");
//            }
//            if (t == 1)
//            {
//                System.out.print(sb);
//            } else
//            {
//                System.out.print("\n" + sb);
//            }
//
//        }
//    }
//
//    public void bfs(int i, int j, int left)
//    {
//        if (i == N)
//        {
//            if (left == 0)
//            {
//                String pair = "";
//                for (int j = 0; j < set.size(); j++)
//                {
//                    String name = set.pollFirst();
//                    pair += name + " ";
//                }
//                result.add(pair.trim());
//            }
//        } else
//        {
//            bfs(i + 1, left);
//            boolean ok = true;
//            ArrayList<String> exc = exceptions.get(names[i]);
//            if (exc != null)
//            {
//                for (int j = 0; j < exc.size(); j++)
//                {
//                    String name = exc.get(j);
//                    if (set.contains(name))
//                    {
//                        ok = false;
//                        break;
//                    }
//                }
//            }
//            if (ok)
//            {
//                a[i] = ;
//                bfs(i + 1, left - 1);
//                set.remove(names[i]);
//            }
//        }
//    }
//
//    public void addException(String n1, String n2)
//    {
//        if (exceptions.containsKey(n1))
//        {
//            exceptions.get(n1).add(n2);
//        } else
//        {
//            ArrayList<String> temp = new ArrayList<String>();
//            temp.add(n2);
//            exceptions.put(n1, temp);
//        }
//
//        if (exceptions.containsKey(n2))
//        {
//            exceptions.get(n2).add(n1);
//        } else
//        {
//            ArrayList<String> temp = new ArrayList<String>();
//            temp.add(n1);
//            exceptions.put(n2, temp);
//        }
//    }
//}
