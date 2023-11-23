import java.util.*;
public class MyLinkedList
{
    private ListNode head;
    
     private class ListNode
     {
        int val;
        ListNode next;
        public ListNode(int val)
        { 
            this.val = val;
        }
        @Override
        public String toString()
        {
            return "" + this.val;
        }
    }
    
    public MyLinkedList()
    {
        head = null;
    }
    public MyLinkedList(int val)
    {
        head = new ListNode(val);
        head.next = null;
    }
    
    public void add(int newVal)
    {
        if(head == null)
        {
            head = new ListNode(newVal);
        }
        else
        {
            ListNode yuh = this.head;
            while(yuh.next != null)
            {
                yuh = yuh.next;
            }
            yuh.next = new ListNode(newVal);
        }
    }
    
    public boolean contains(int target)
    {
        ListNode mf = head;
        while (mf.val != target)
        {
            if (mf.next == null)
            {
                return false;
            }
            mf = mf.next;
        }
        return true;  
    }
    
    public int get(int index)
    {
        ListNode eff = head;
        for (int i = 0; i < index; i++)
        {
            if (eff.next == null)
            {
                throw new IndexOutOfBoundsException();
            }
            eff = eff.next;
        }
        return eff.val;
    }
    
    public int indexOf(int target)
    {
        ListNode temp = head;
        int ind = 0;
        while (temp.val != target)
        {
            if (temp.next == null)
            {
                return -1;
            }
            temp = temp.next;
            ind++;
        }
        return ind;
    }
    
    public void set(int newVal, int index)
    {
        ListNode temp = head;
        for(int i = 0; i < index; i++)
        {
            if(temp.next == null)
            {
                throw new IndexOutOfBoundsException();
            }
            temp = temp.next;
        }
        temp.val = newVal;
    }
    
    public int size()
    {
        ListNode yem = head;
        int size = 0;
        while (yem != null)
        {
            yem = yem.next;
            size++;
        }
        return size;
    }
    public int sizeRecursive(ListNode cur)
    {
        if (cur.next == null)
        {
            return 0;
        }
        return 1 + sizeRecursive(cur.next);

    }

    public boolean isEmpty()
    {
        return head == null;
    }

    public int remove(int index)
    {
        ListNode temp = head;
        if (temp != null && index == 0)
        {
            int val = temp.val;
            head = temp.next;
            return val;
        }
        for (int i = 0; i < index-1; i++)
        {
            if (temp.next == null){
                throw new IndexOutOfBoundsException();
            }
            temp = temp.next;
        }
        int val = temp.next.val;      
        temp.next = temp.next.next;
        return val;
    }

    public void add(int newVal, int index)
    {
        ListNode temp = head;
        for (int i = 0; i < index-1; i++)
        {
            if (temp == null)
            {
                throw new IndexOutOfBoundsException();
            }
            temp = temp.next;
            
        }
        ListNode connect = temp.next;
        temp.next = new ListNode(newVal);
        temp.next.next = connect;
    }
    
    @Override
    public String toString()
    {
        ArrayList<Integer> stuff = new ArrayList<>();
        String msg = "";
        if (isEmpty()){
            msg = "[]";
        }
        else 
        {
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
}
