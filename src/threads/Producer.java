/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package threads;

/**
 *
 * @author lucian
 */
public class Producer extends  Thread
{
    SynchronizedQueue<Integer> queue;
    int max ;
    public Producer(SynchronizedQueue<Integer> queue, int max )
    {
        this.queue = queue;
        this.max = max;
    }

    @Override
    public void run()
    {
        for (int i=0;i<max;i++)
        {
            try
            {
                sleep(10);
            }
            catch (InterruptedException e)
            {
                System.out.println(e);
            } 

            queue.addTail(i + 1);           
            System.out.println("Producing "+ (i+1)+"...");
        }
    }


}
