/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package threads;

import java.util.ArrayList;

 /*
  Написать класс SynchronizedQueue для управления доступом параллельных потоков
  к кольцевой очереди. Класс SynchronizedQueue имеет два метода: addTail и
  removeHead. Кольцевая очередь реализуется массивом, элементы которого имеют тип
  int. Размер кольцевой очереди задается в конструкторе. Если поток обращается к
  методу addTail класса, а кольцевая очередь оказывается в этот момент полной,
  то этот поток должен переходить в состояние ожидания до удаления из кольцевой
  очереди, хотя бы одного элемента. Если поток обращается к методу removeHead
  класса, а кольцевая очередь оказывается в этот момент пустой, то этот поток
  должен переходить в состояние ожидания до записи в кольцевую очередь, хотя бы
  одного нового элемента.
  */
/**
 *
 * @param <E>
 * @author lucian
 */
public class SynchronizedQueue<E>
{
    protected E [] queue;
    protected int head;
    protected int tail;


    @SuppressWarnings({"unchecked"})
    public SynchronizedQueue(int size)
    {
        ArrayList<E> tmp = new ArrayList<E>(size);
        for (int i=0;i<size;i++)
        {
            tmp.add(null);
        }
        queue = (E[])(tmp).toArray();
        head = 0;
        tail = 0;       
    }

    /**
     *
     * @return
     */
    public  boolean  isFull()
    {
        return getSize()==queue.length;
    }
    public  boolean  isEmpty ()
    {
        return getSize() == 0;
    }

    public  int  getCapacity ()
    {
        return queue.length;
    }

    public  int getSize ()
    {
        if ((queue.length+queue.length-(head-tail))%(queue.length)==0 && queue[head]!=null)
        {
            return queue.length;
        }
        return (queue.length+queue.length-(head-tail))%(queue.length);
    }

    public synchronized  E removeHead ()
    {
        while (this.isEmpty())
        {
            
             try { wait(); }
             catch (InterruptedException e) { }
             finally { }

        }
        int tmpHead = head;
        head = (queue.length+head+1)%queue.length;
        E tmpItem = queue [tmpHead];
        queue[tmpHead] = null;
        notify();
        return tmpItem;
    }

    public synchronized  void  addTail (E item)  
    {
        while (this.isFull())
        {
              try { wait(); }
              catch (InterruptedException e) { }
              finally { }
        }
        queue[tail] = item;
        tail= (queue.length+tail+1)%queue.length;
        notify();
    }
    
}
