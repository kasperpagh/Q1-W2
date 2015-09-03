/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package threadexercisefridayweek2;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author pagh
 */
public class Producer extends Thread
{

    private ArrayBlockingQueue s1;
    private ArrayBlockingQueue s2;

    public Producer(ArrayBlockingQueue s1, ArrayBlockingQueue s2)
    {
        this.s1 = s1;
        this.s2 = s2;
    }

    @Override
    public void run()
    {
        calc(s1, s2);
        
        interrupt();
    }

    private long fib(long n)
    {
        if ((n == 0) || (n == 1))
        {
            return n;
        } else
        {
            return fib(n - 1) + fib(n - 2);
        }
    }

    private ArrayBlockingQueue calc(ArrayBlockingQueue s1, ArrayBlockingQueue s2)
    {

        while (!s1.isEmpty())
        {
            try
            {
                long i;

                i = fib((long) s1.poll());

//                System.out.println("I er lig med: " + i);
//                System.out.println("her fra t " + s2.isEmpty());
                s2.put(i);
//                System.out.println("Her er tallet fra ");
            } catch (InterruptedException e)
            {
                System.out.println("Der er knas med run() i tSecondary!!");
            }
        }
         
        System.out.println("S1 er empty! PRODUCER thread lukker ned!!");
        System.out.println("________________________________________________________________________________________________________________");
        
        return s2;

    }
}
