/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package threads;

/**
 *
 * @author lucian
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)
    {

        SynchronizedQueue<Integer> q  = new SynchronizedQueue<Integer>(5);
        for (int i=0;i<6;i++)
        {
            try
            {
                q.addTail(i);
            }
            catch (SynchronizedQueueException e)
            {
                System.out.println(e);
            }

        }
    }

}
