class Tester {
  public static void main(String[] args) {
    EmployeeDatabase db = new EmployeeDatabase();
    Employee p = new Employee("BOB", 50000);
    Employee z = new Employee("TOM", 34803);
    Employee q = new Employee("HARRY", 12313);
    Employee a = new Employee("JAKE", 41323);
    //Not initialized Employees

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