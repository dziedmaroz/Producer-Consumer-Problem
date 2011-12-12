/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package threads;

/**
 *
 * @author lucian
 */
public class Producer
{
    SynchronizedQueue<Integer> queue;

    public Producer(SynchronizedQueue<Integer> queue)
    {
        this.queue = queue;
    }

    
}
