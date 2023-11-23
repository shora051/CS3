import java.lang.NullPointerException;
public class NumberList
{
    private Integer[] list;
    private int size;
    public NumberList()
    {
        list = new Integer[2];  
    }
    public int size()
    {
        size = 0;
        for(int i = 0; i < list.length; i++)
        {
            if(list[i] != null)
            {
                size++;
            }
        }
        return size;
    }
    public boolean isEmpty()
    {
        if(size() != 0)
        {
            return false;
        }
        else
        {
            return true;
        }
    }
    public String toString()
    {
        String s = "";
        for(int i = 0; i < size; i++)
        {
            if(i != 0)
                s += ", ";
            if(list[i] != null)
            {
                s += list[i].toString();
            }
        }
        return "[" + s + "]";
    }
    private void doubleCapacity()
    {
        Integer[] newList = new Integer[list.length * 2];
        for(int i = 0; i < list.length; i++)
        {
            newList[i] = list[i];
        }
        list = newList; 
        size();
    }
    public void add(int index, Integer val)
    {
        if(index < 0 || index > list.length)
        {
            throw new IndexOutOfBoundsException();
        }
        else if(size+1 >= list.length)
        {
            doubleCapacity(); 
        }
        else
        {
            for(int i = size; i > index; i--)
            {
                list[i] = list[i-1];
            }
        }
        list[index] = val;
        size++;
    }
    public boolean add(Integer element)
    {
        add(size, element);
        return true;
    }
    public Integer get(int index)
    {
        if(index <= size)
        {
            return list[index];
        }
        else
        {
            throw new IndexOutOfBoundsException();
        }
    }
    public Integer set(int index, Integer val)
    {
        if(index <= size)
        {
            int t = list[index];
            list[index] = val;
            return t;
        }
        else
        {
            throw new IndexOutOfBoundsException();
        }
    }
    public Integer remove(int index)
    {
        if(index < size)
        {
            int r = list[index];
            for(int i = index; i < size-1; i++)
            {
                list[i] = list[i+1];
            }
            list[size-1] = null;
            size--;
            return r;
        }
        else
        {
            throw new IndexOutOfBoundsException();
        }
    }
}
