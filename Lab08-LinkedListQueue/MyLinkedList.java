import java.util.ArrayList;

public class MyLinkedList<T> 
{

    private ListNode head;

    private class ListNode{

        T val;
        ListNode next;

        public ListNode(T val){
            this.val = val;
        }
        public String toString(){
            return "" + this.val;
        }


    }


    public MyLinkedList(){
        head = null;
    }
    public MyLinkedList(T val){
        head = new ListNode(val);
        head.next = null;
    }
    public MyLinkedList(T ... vals){
        head = new ListNode(vals[0]);
        ListNode temp = head;

        int first = 0;
        for (T x : vals){
            first++;
            if (first != 1) {
                temp.next = new ListNode(x);
                temp = temp.next;
            }


        }



    }



    public void add(T newVal){
        if (head!= null){
            ListNode temp = head;
            while (temp.next != null){
                temp = temp.next;
            }
            temp.next = new ListNode(newVal);
        }
        else {
            head = new ListNode(newVal);
        }


    }

    public boolean contains(T target){
        ListNode temp = head;

        while (!temp.val.equals(target)){

            if (temp.next == null){
                return false;
            }
            temp = temp.next;


        }
        return true;
    }

    public T get(int index){

        ListNode temp = head;

        for (int i = 0; i < index; i++){
            if (temp.next == null){
                throw new IndexOutOfBoundsException();
            }
            temp = temp.next;
        }
        return temp.val;
    }
    public int indexOf(T target){
        ListNode temp = head;
        int ind = 0;
        while (!temp.val.equals(target)){

            if (temp.next == null){
                return -1;
            }
            temp = temp.next;
            ind++;

        }
        return ind;



    }
    public void set(T newVal, int index){

        ListNode temp = head;

        for (int i = 0; i < index; i++){
            if (temp.next == null){
                throw new IndexOutOfBoundsException();
            }
            temp = temp.next;

        }
        temp.val = newVal;







    }
    public int size(){
        ListNode temp = head;
        int size = 0;
        while (temp != null){
            temp = temp.next;
            size++;
        }
        return size;

    }
    public int sizeRecursive(ListNode cur){

        if (cur.next == null){
            return 0;
        }
        return 1 + sizeRecursive(cur.next);

    }

    public boolean isEmpty(){
        return head == null;
    }

    public T remove(int index){
        ListNode temp = head;

        if (temp != null && index == 0){
            T val = temp.val;
            head = temp.next;
            return val;
        }

        for (int i = 0; i < index-1; i++){
            if (temp.next == null){
                throw new IndexOutOfBoundsException();
            }
            temp = temp.next;

        }
        T val = temp.next.val;

        temp.next = temp.next.next;

        return val;
    }

    public void add(T newVal, int index){
        ListNode temp = head;
        for (int i = 0; i < index-1; i++){
            if (temp == null){
                throw new IndexOutOfBoundsException();
            }
            temp = temp.next;

        }
        ListNode connect = temp.next;
        temp.next = new ListNode(newVal);
        temp.next.next = connect;




    }
    @Override
    public String toString(){
        ArrayList<T> stuff = new ArrayList<>();
        String msg = "";
        if (isEmpty()){
            msg = "[]";
        }
        else {
            msg = "";
            ListNode temp = head;

            while (temp != null){
                stuff.add(temp.val);
                temp = temp.next;

            }
            msg = stuff.toString();


        }
        return msg;

    }


    public static void main(String[] args) {
        MyLinkedList<String> test = new MyLinkedList<>("wow", "dope", "sick");
        System.out.println(test);
    }

}
