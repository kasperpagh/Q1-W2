/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package threadexercisefridayweek2;

import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author pagh
 */

/*
 Svar på spørgsmål i OPG 1:
 ________________________________________________
 when and why will we use threads in our program:

 For at kunne køre processer i parallel, det kan (potentielt, der er signifikant overhead i thread creation) give et hurtigere program
 hvis eksemplvis store regne operationer ligger i en seperat thread og eventwatcher i GUI er i en anden thread (så du altid kan klikke 
 på knapper.
 ________________________________________________
 Explain about the Race Condition Problem:

 RC problemet opstår når en threads (eller proces) er afhængig af en anden thread. Eksempelvis hvis Thread1 og Thread2
 skal x++ på samme variabel, og T1 når at indlæse den som x og T2 ligeledes indlæser x førend T1 har nået at incrementerer den.
 DVS at resultatet i stedet for x+2 ender som x++.
 ________________________________________________
 Explain about the Producer/Consumer-problem and how to solve it in modern Java Programs

 Dette problem hedder også " the bounded-buffer problem". Det går ud på at en producer (P)
 genererer data til en buffer og en consumer (C) fjerner denne data. Problemet er da at sikre at 
 P ikke fylder data ind når bufferen er fuld, og at C ikke prøver at fjerne data hvis bufferen er tom!

 En god løsning er at lade P vente (wait) eller sove (sleep), når bufferen er fuld, og da derfter kun producerer data
 når den bliver "notifiet" af C (når den har taget et stykke med data).

 PS. det er også virkelig vigtigt at bruge en thread-safe datetype (blockingque eller whatever) som buffer, da der ellers kan opstå race-condition probs oven i hatten!!
 ------------------------------------------------------------------------
 Notes: 
 -Det er cosumer (thread c1) der printer summen af alle fibo tal i s2!!!

- Alt det udkommenterede kode er fra "præ-opgave nr. 5" så at sige!!

 */
public class ThreadExerciseFRIDAYWeek2
{

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)
    {
        
        oneMethodToRuleThemAllForAssignmentNumber5(4);
//        ArrayBlockingQueue<Long> s1 = new ArrayBlockingQueue(15);
//        ArrayBlockingQueue<Long> s2 = new ArrayBlockingQueue(15);
//
//        long a = 4;
//        long b = 5;
//        long c = 8;
//        long d = 12;
//        long e = 21;
//        long f = 22;
//        long g = 34;
//        long h = 35;
//        long i = 37;
//        long j = 42;
//
//        s1.add(a);
//        s1.add(b);
//        s1.add(c);
//        s1.add(d);
//        s1.add(e);
//        s1.add(f);
//        s1.add(g);
//        s1.add(h);
//        s1.add(i);
//        s1.add(j);
//
//        Producer t1 = new Producer(s1, s2);
//        Producer t2 = new Producer(s1, s2);
//        Producer t3 = new Producer(s1, s2);
//        Producer t4 = new Producer(s1, s2);
//
//        t1.start();
//        t2.start();
//        t3.start();
//        t4.start();
//        Consumer c1 = new Consumer(s2);
//        c1.start();
//        try
//        {
//            t1.join();
//            t2.join();
//            t3.join();
//            t4.join();
//            c1.join();
//        } catch (InterruptedException ex)
//        {
//            System.out.println("Der er interrupt!");
//        }
//        try
//        {
//            //dirty solution coz lazy, burde joine main med alle fire threads, vi venter i 3 secs på at alle threads er done
//            Thread.sleep(3000);
//        } catch (InterruptedException ex)
//        {
//            Logger.getLogger(ThreadExerciseFRIDAYWeek2.class.getName()).log(Level.SEVERE, null, ex);
//        }
////        System.out.println("virker inte??" + t1.isInterrupted());
////        System.out.println("virker alive??? " + t1.isAlive());

    }

    public static void oneMethodToRuleThemAllForAssignmentNumber5(int numberOfProducerThreads)
    {
        ArrayBlockingQueue<Long> s1 = new ArrayBlockingQueue(15);
        ArrayBlockingQueue<Long> s2 = new ArrayBlockingQueue(15);

        long a = 4;
        long b = 5;
        long c = 8;
        long d = 12;
        long e = 21;
        long f = 22;
        long g = 34;
        long h = 35;
        long i = 37;
        long j = 42;

        s1.add(a);
        s1.add(b);
        s1.add(c);
        s1.add(d);
        s1.add(e);
        s1.add(f);
        s1.add(g);
        s1.add(h);
        s1.add(i);
        s1.add(j);
        try
        {
            Consumer c1 = new Consumer(s2);
            c1.start();
           
            for (int q = 0; q < numberOfProducerThreads; q++)
            {
                Producer producerThread = new Producer(s1, s2);
                producerThread.start();
                producerThread.join();

            }
            c1.join();
        } catch (InterruptedException exc)
        {
            System.out.println("der er knas i interrupts i super funktionen!!");
        }

        System.out.println("Her er s2 toString (indholder fibo resultater): " + s2.toString());

    }

}
