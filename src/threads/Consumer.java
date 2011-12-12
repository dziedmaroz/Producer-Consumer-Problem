/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package threads;


  

/**
 *
 * @author lucian
 */
public class Consumer extends Thread
{
    SynchronizedQueue<Integer> queue;

    @Override
    public void run()
    {
        
        while(true)
        {
            try
            {
                 sleep(100);
            }
            catch (InterruptedException e)
            {
                System.out.print(e);
            } 
            System.out.println("Consuming "+queue.removeHead());            
            
        }
    }

    public Consumer(SynchronizedQueue<Integer> queue)
    {
        this.queue = queue;
    }
    
}
