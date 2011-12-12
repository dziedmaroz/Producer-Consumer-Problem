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
        SynchronizedQueue<Integer> queue = new SynchronizedQueue<Integer>(20);
        Producer producer = new Producer(queue, 500);
        Consumer consumer = new Consumer(queue);

       producer.run();
       consumer.run();
       

    }

}
