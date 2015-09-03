/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package threadexercisefridayweek2;

import java.util.Random;
import java.util.concurrent.BlockingQueue;

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

 */
public class ThreadExerciseFRIDAYWeek2
{

    static volatile BlockingQueue shared;
    static volatile BlockingQueue resultSet;
    volatile int i;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)
    {
        shared = popShared(shared);
        Producer t1 = new Producer(shared);
        Producer t2 = new Producer(shared);
        Producer t3 = new Producer(shared);
        Producer t4 = new Producer(shared);
        
        
    }

    public static BlockingQueue popShared(BlockingQueue shared)
    {      
        shared.add(4);
        shared.add(5);
        shared.add(8);
        shared.add(12);
        shared.add(21);
        shared.add(22);
        shared.add(34);
        shared.add(35);
        shared.add(36);
        shared.add(37);
        shared.add(42);
        
        return shared;
    }

}
