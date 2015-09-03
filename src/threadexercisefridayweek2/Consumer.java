/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package threadexercisefridayweek2;

import java.util.ArrayList;
import java.util.Collection;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author KasperRoland
 */
public class Consumer extends Thread
{

    private ArrayBlockingQueue s2;

    public Consumer(ArrayBlockingQueue s2)
    {
        this.s2 = s2;
    }

    public void run()
    {
        long result = 0;
        for (int i = 0; i < 10; i++)
        {
            result = getFib(s2);            
        }
        
        System.out.println("Her er SUMMEN af alle tal i s2: " + result);
        System.out.println("________________________________________________________________________________________________________________");
        interrupt();
    }

    public long getFib(ArrayBlockingQueue s2)
    {
        int a = s2.size();
        long result = 0;
//        System.out.println("Her fra consumer kommer et kig på s2: " + s2.toString());
        while (true)
        {
            while (a != s2.size())
            {
                a = s2.size();
                System.out.println("Her fra CONSUMER kommer et kig på s2: " + s2.toString());
System.out.println("________________________________________________________________________________________________________________");
            }
            if (s2.size() > 9)
            {
                for (Object out1 : s2)
                {
                    result += (long) out1;

                }

                break;
            }
        }
        return result;
//        System.out.println("Her er SUMMEN af alle tal i s2: " + result);
    }

}
