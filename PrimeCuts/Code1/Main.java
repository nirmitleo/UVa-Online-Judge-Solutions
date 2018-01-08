package UVa.PrimeCuts.Code1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by Nirmit on 06/07/2017.
 */
public class Main
{
    private int[] primes = {1, 2,
            3,
            5,
            7,
            11,
            13,
            17,
            19,
            23,
            29,
            31,
            37,
            41,
            43,
            47,
            53,
            59,
            61,
            67,
            71,
            73,
            79,
            83,
            89,
            97,
            101,
            103,
            107,
            109,
            113,
            127,
            131,
            137,
            139,
            149,
            151,
            157,
            163,
            167,
            173,
            179,
            181,
            191,
            193,
            197,
            199,
            211,
            223,
            227,
            229,
            233,
            239,
            241,
            251,
            257,
            263,
            269,
            271,
            277,
            281,
            283,
            293,
            307,
            311,
            313,
            317,
            331,
            337,
            347,
            349,
            353,
            359,
            367,
            373,
            379,
            383,
            389,
            397,
            401,
            409,
            419,
            421,
            431,
            433,
            439,
            443,
            449,
            457,
            461,
            463,
            467,
            479,
            487,
            491,
            499,
            503,
            509,
            521,
            523,
            541,
            547,
            557,
            563,
            569,
            571,
            577,
            587,
            593,
            599,
            601,
            607,
            613,
            617,
            619,
            631,
            641,
            643,
            647,
            653,
            659,
            661,
            673,
            677,
            683,
            691,
            701,
            709,
            719,
            727,
            733,
            739,
            743,
            751,
            757,
            761,
            769,
            773,
            787,
            797,
            809,
            811,
            821,
            823,
            827,
            829,
            839,
            853,
            857,
            859,
            863,
            877,
            881,
            883,
            887,
            907,
            911,
            919,
            929,
            937,
            941,
            947,
            953,
            967,
            971,
            977,
            983,
            991,
            997};
    private String line;
    private StringTokenizer st;
    private BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String ar[]) throws IOException
    {
        Main demo = new Main();
//        demo.test();
        demo.solve2();
    }

    public void solve() throws IOException
    {
        int N = 169;
        //System.out.println(primes.length);
        for (; ; )
        {
            line = in.readLine();
            if (line == null || line.trim().length() == 0)
            {
                return;
            }
            st = new StringTokenizer(line);
            int n = Integer.parseInt(st.nextToken());
            int C = Integer.parseInt(st.nextToken());

            int last = N;
            for (int i = 0; i < N; i++)
            {
                if (primes[i] > n)
                {
                    last = i;
                    break;
                }
            }

            String result = "" + n + " " + C + ": ";
            if (last % 2 == 0)
            {
                int center = last / 2;
                if (center + C - 1 < Math.min(last, N) && center - C >= 0)
                {
                    for (int i = center - C; i < Math.min(last, center); i++)
                    {
                        result += primes[i] + " ";
                    }
                    for (int i = center; i <= Math.min(last, center + C - 1); i++)
                    {
                        result += primes[i] + " ";
                    }
                } else
                {
                    for (int i = Math.max(0, center - C + 1); i <= Math.min(last, center); i++)
                    {
                        result += primes[i] + " ";
                    }
                    for (int i = center + 1; i <= center + C && i < last && i < N; i++)
                    {
                        result += primes[i] + " ";
                    }
                }
            } else
            {
                int center = last / 2;
                C -= 1;
                for (int i = Math.max(0, center - C); i < Math.min(last, center); i++)
                {
                    result += primes[i] + " ";
                }
                result += primes[center] + " ";
                for (int i = center + 1; i <= center + C && i < last && i < N; i++)
                {
                    result += primes[i] + " ";
                }
            }
//            while (!set.isEmpty())
//            {
//                result += set.pollFirst() + " ";
//            }
            System.out.println(result.trim() + "\n");
        }
    }

    public void solve2() throws IOException
    {
        int N = 169;
        for (; ; )
        {

            line = in.readLine();
            if (line == null || line.trim().length() == 0)
            {
                return;
            }
            st = new StringTokenizer(line);
            int n = Integer.parseInt(st.nextToken());
            int C = Integer.parseInt(st.nextToken());

            int length = N;
            for (int i = 0; i < N; i++)
            {
                if (primes[i] > n)
                {
                    length = i;
                    break;
                }
            }

            String result = "" + n + " " + C + ": ";
            if (length % 2 == 0)
            {
                int center = length / 2;
                if (center + C - 1 < Math.min(length, N) && center - C >= 0)
                {
                    for (int i = center - C; i < center; i++)
                    {
                        result += primes[i] + " ";
                    }
                    for (int i = center; i < center + C; i++)
                    {
                        result += primes[i] + " ";
                    }
                } else
                {
                    for (int i = Math.max(0, center - C + 1); i <= center; i++)
                    {
                        result += primes[i] + " ";
                    }
                    for (int i = center + 1; i < Math.min(length, center + C); i++)
                    {
                        result += primes[i] + " ";
                    }
                }
            } else
            {
                int center = length / 2;
                C -= 1;
                for (int i = Math.max(0, center - C); i < Math.min(length, center); i++)
                {
                    result += primes[i] + " ";
                }
                result += primes[center] + " ";
                for (int i = center + 1; i < Math.min(length, center + C + 1); i++)
                {
                    result += primes[i] + " ";
                }
            }
            System.out.println(result.trim() + "\n");
        }
    }

}
