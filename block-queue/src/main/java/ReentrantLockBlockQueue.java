import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockBlockQueue<T> implements BlockQueue<T> {

    private ReentrantLock lock;

    private Condition full;

    private Condition empty;

    private int maxSize;

    private Object[] queue;

    private int length;


    public ReentrantLockBlockQueue(int size) {
        lock = new ReentrantLock();
        full = lock.newCondition();
        empty = lock.newCondition();
        maxSize = size;
        queue = new Object[size];
        length = 0;
    }

    @Override
    public void push(T element) throws InterruptedException {
        lock.lock();
        try {
            while (length == maxSize) {
                System.out.println("队列满。。。");
                full.await();
            }
            queue[length++] = element;
            empty.signal();
        } finally {
            lock.unlock();
        }

    }

    @Override
    @SuppressWarnings("unchecked")
    public T pop() throws InterruptedException {
        lock.lock();
        T res;
        try {
            while (length == 0) {
                System.out.println("队列空。。。");
                empty.await();
            }
            res = (T) queue[length];
            queue[length--] = null;
            full.signal();
        } finally {
            lock.unlock();
        }
        return res;
    }
}
