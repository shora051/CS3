class Tester 
{
  public static void main(String[] args) {
    Database db = new Database();
     Employee p = new Employee("BOB", 50000);
    Employee z = new Employee("TOM", 34803);
    Employee q = new Employee("HARRY", 12313);
    Employee a = new Employee("JAKE", 41323);


  int[] ids = new int[]{50000,34803,12313,41323};
    for (int i = 0; i < ids.length; i++)
  {
    int getID = ids[i];
    db.put(p.id,p);
    db.put(z.id,z);
    db.put(q.id,q);
    db.put(a.id,a);
    
    
      if(db.get(getID) == null) {
      System.out.println("No Entry For ID: " + getID);
    } else {
      System.out.println("Entry Found for ID: " + db.get(getID).id + " -> " + db.get(getID).name);
    }
  }
}
}
