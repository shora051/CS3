import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
public class Melody
{
    private Queue<Note> notes;
    
    public Melody(Queue<Note> song)
    {
        notes = new LinkedList<>();
        int size = song.size();
        for (int i = 0; i < size; i++)
        {
            notes.offer(song.poll());
        }
    }
    public double getTotalDuration()
    {
        int size = notes.size();
        double t = 0;
         Queue<Note> copy = new LinkedList<>();
        boolean inRepeat = false;
        for (int i = 0; i < size; i++)
        {
            Note current = notes.poll();
            if (inRepeat)
            {
                t += current.getDuration();
            }
            t += current.getDuration();
            if (current.isRepeat() && !inRepeat)
            {
                t += current.getDuration();
                inRepeat = true;
            }
            else if (current.isRepeat() && inRepeat)
            {
                inRepeat = false;
            }
            
            copy.offer(current);   
        }
        size = copy.size();
        for (int i = 0; i < size; i++)
        {
            notes.offer(copy.poll());
        }
        

        return t; 
    }
    public String toString()
    {
        String msg = "";
        Queue<Note> repeat = new LinkedList<>();
        int x = notes.size();
        for (int i = 0; i < x; i++)
        {
            msg += notes.peek().toString() + "/n";
            repeat.offer(notes.poll());
        }
        for (int i = 0; i < x; i++)
        {
            notes.offer(repeat.poll());
        }
        return msg;
    }
    public void changeTempo(double tempo)
    {
        System.out.println("called");
        int x = notes.size();
        Queue<Note> flip = new LinkedList<>();
        for (int i = 0; i < x; i++)
        {
            double dur = notes.peek().getDuration();
            System.out.println(dur);
            notes.peek().setDuration(dur*tempo);
            flip.offer(notes.poll());
            
        }
        for (int i = 0; i < x; i++)
        {
            notes.offer(flip.poll());
        }
    }
     public void reverse()
     {
        Stack<Note> reverse = new Stack<>();
        int x = notes.size();
        for (int i = 0; i < x; i++){
            reverse.push(notes.poll());
        }
        for (int i = 0; i < x; i++){
            notes.offer(reverse.pop());
        }
    }
    public void append(Melody other){
        Queue<Note> fin = new LinkedList<>();
        
        int y = notes.size();
        for (int i = 0; i < y; i++){
            fin.offer(notes.poll());
        }
       
        int x = other.getNotes().size();
        for (int i = 0; i < x; i++){
            fin.offer(other.getNotes().poll());
        }
        
        for (int i = 0; i < y+x; i++){
            Note yes = fin.poll();
            if (i > x){
                other.getNotes().offer(yes);
            }
            notes.offer(yes);
        }
    }
    public void play(){
        Queue<Note> temp = new LinkedList<>();
        int x = notes.size();
        Queue<Note> repeat = new LinkedList<>();
        boolean inRepeat = false;
        for (int i = 0; i < x; i++){
            Note cur = notes.poll();
            cur.play();
            if (cur.isRepeat() && !inRepeat){
                inRepeat = !inRepeat;
            }

            else if (cur.isRepeat() && inRepeat){
                inRepeat = false;
                repeat.offer(cur);
                
                int z = repeat.size();
                for (int y = 0; y < z; y++){
                    Note rep = repeat.poll();
                    rep.play();

                    if (y != z-1){
                        temp.offer(rep);
                    }
                    
                }
            }
            if (inRepeat){
                repeat.offer(cur);
            }
            

            else {
                
                temp.offer(cur);
                
            }
        }
        x = temp.size();
        for (int i = 0; i < x; i++){
            notes.offer(temp.poll());
        }
    }
    public Queue<Note> getNotes(){
        return notes;
    }
}