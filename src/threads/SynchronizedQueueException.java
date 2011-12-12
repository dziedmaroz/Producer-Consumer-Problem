/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package threads;
enum Cases {NULL,FULL, EMPTY};
/**
 *
 * @author lucian
 */
public class SynchronizedQueueException extends Exception
{
    protected  Cases _case = Cases.NULL;

    public SynchronizedQueueException(Throwable cause)
    {
        super(cause);
    }

    public SynchronizedQueueException(String message, Throwable cause)
    {
        super(message, cause);
    }

    public SynchronizedQueueException(String message)
    {
        super(message);
    }

    public SynchronizedQueueException()
    {
    }

    public SynchronizedQueueException(Cases _case)
    {
        this._case = _case;
    }

    public  Cases getCase()
    {
        return _case;
    }

    @Override
    public String toString()
    {
        return "SynchronizedQueueException{" + "_case=" + _case + '}';
    }


}
