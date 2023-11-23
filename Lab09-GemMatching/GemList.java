import java.util.ArrayList;

public class GemList
{

	private ListNode head;

	private class ListNode{

		Gem val;
		ListNode next;

		public ListNode(Gem val){
			this.val = val;
		}
		public String toString(){
			return "" + this.val;
		}


	}

	public GemList(){

		head = null;

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

	public void insertBefore(Gem gem, int index){
		if (this.size() == 0){
			head = new ListNode(gem);
		}
		else if (index > this.size()){
			ListNode temp = head;
			while (temp.next != null){
				temp = temp.next;
				
			}
			temp.next = new ListNode(gem);
		}
		else {
			ListNode temp = head;

        	for (int i = 0; i < index-1; i++){
            	
            temp = temp.next;
        	}
			ListNode e = temp.next;
			temp.next = new ListNode(gem);
			temp.next.next = e;


		}

	}

	public void draw(double y){
		ListNode temp = head;
		int ind = 0;
		while (temp != null){
			temp.val.draw(GemGame.indexToX(ind), y);
			temp = temp.next;
			
			
			ind++;
		}



	}
	public String toString(){
		ArrayList<Gem> stuff = new ArrayList<>();
        String msg = "";
        if (this.size()==0){
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
	
	public int score(){
		int complete = 0;
		int total = 0;
		int streak = 0;
		ArrayList<Gem> colors = new ArrayList<>();
		ListNode temp = head;

        while (temp != null){
            colors.add(temp.val);
            temp = temp.next;
       }

		for (int i = 0; i  < this.size(); i++){
			GemType color = colors.get(i).getType();
			total = 0;
			streak = 0;
			int x = i;
			while (x < this.size() && colors.get(x).getType() == color){
				total += colors.get(x).getPoints();
				streak++;
				x++;
			}
			i = x-1;
			complete += (streak*total);



		}
		return complete;

		
	}























	public static void main(String [] args)
	{
		GemList list = new GemList();
		System.out.println(list);
		System.out.println("size = " + list.size() + ", score = " + list.score());
		list.draw(0.9);

		list.insertBefore(new Gem(GemType.BLUE, 10), 0);
		System.out.println("\n" + list);
		System.out.println("size = " + list.size() + ", score = " + list.score());
		list.draw(0.8);

		list.insertBefore(new Gem(GemType.BLUE, 20), 99);  //not a mistake, should still work
		System.out.println("\n" + list);
		System.out.println("size = " + list.size() + ", score = " + list.score());
		list.draw(0.7);

		list.insertBefore(new Gem(GemType.ORANGE, 30), 1);
		System.out.println("\n" + list);
		System.out.println("size = " + list.size() + ", score = " + list.score());
		list.draw(0.6);

		list.insertBefore(new Gem(GemType.ORANGE, 10), 2);
		System.out.println("\n" + list);
		System.out.println("size = " + list.size() + ", score = " + list.score() );
		list.draw(0.5);

		list.insertBefore(new Gem(GemType.ORANGE, 50), 3);
		System.out.println("\n" + list);
		System.out.println("size = " + list.size() + ", score = " + list.score());
		list.draw(0.4);

		list.insertBefore(new Gem(GemType.GREEN, 50), 2);
		System.out.println("\n" + list);
		System.out.println("size = " + list.size() + ", score = " + list.score());
		list.draw(0.3);
	}
}