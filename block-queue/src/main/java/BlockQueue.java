public interface BlockQueue<T> {
    /**
     * push element
     *
     * @param element ele
     * @throws InterruptedException
     */
    void push(T element) throws InterruptedException;

    /**
     * pop element
     * @return element
     * @throws InterruptedException
     */
    T pop() throws InterruptedException;
}
