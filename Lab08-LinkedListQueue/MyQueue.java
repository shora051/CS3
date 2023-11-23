public class MyQueue<T> {

    private MyLinkedList<T> queue;


    public MyQueue(){
        queue = new MyLinkedList<>();
    }
    public MyQueue(T ... vals){
        queue = new MyLinkedList<T>(vals);
    }
    public boolean isEmpty(){
        return queue.isEmpty();
    }
    public void offer(T item){
        queue.add(item);
    }
    public T poll(){
        return queue.remove(0);
    }
    public int size(){
        return queue.size();
    }
    public void clear(){
        int size = queue.size();
        for (int i = 0; i < size; i++){
            queue.remove(i);
        }

    }





}
