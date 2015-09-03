/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package threadexercisefridayweek2;

import java.util.concurrent.BlockingQueue;

/**
 *
 * @author pagh
 */
public class Producer extends Thread
{
    private BlockingQueue abe;

    public Producer(BlockingQueue abe)
    {
        this.abe = abe;
    }
    
    @Override
    public void run()
    {
        fib((Long)abe.poll());
    }

    private long fib(long n)
    {
        if ((n == 0) || (n == 1))
        {
            return n;
        } 
        else
        {
            return fib(n - 1) + fib(n - 2);
        }
    }
}
