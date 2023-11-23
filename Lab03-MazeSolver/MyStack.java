import java.util.EmptyStackException;
public class MyStack {

    private Square[] stack;
    private int size;

    public MyStack(){
        stack = new Square[7];
        size = -1;

    }
    public MyStack(int initCap){
        stack = new Square[initCap];
        size = initCap;
    }
    public boolean isEmpty(){
        return size==-1;
    }
    public Square peek(){
        if (this.isEmpty()){
            throw new EmptyStackException();
        }
        else{
            return stack[size];
        }
    }
    public Square pop(){
        if (this.isEmpty()){
            throw new EmptyStackException();
        }
        Square value = stack[size];
        size--;
        return value;

    }
    public void push(Square item){
        if (size+1 >= stack.length){
            this.doubleCapacity();
            stack[size+1] = item;
            size++;
        }
        else{
            stack[size+1] = item;
            size++;
        }
    }
    private void doubleCapacity(){
        Square[] neww = new Square[stack.length*2];
        for (int i = 0; i < stack.length; i++){
            neww[i] = stack[i];
        }
        stack = neww;


    }
    public String toString(){
        String string = stack[size] + "     <----- TOP\n";
        for (int i = size-1; i >= 0; i--){
            string += stack[i];
            string += "\n";
        }
        return string;
    }

}
