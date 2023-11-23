 



public class EmployeeDatabase {
  Employee data[] = new Employee[500000];
  public int hash(int key) {
    return (key % 100000 - 10000);
  }
  public void put(int Key, Employee Val) {
    int hash = this.hash(Key);
    if(this.data[hash] == null || this.data[hash].id == Val.id)
      this.data[hash] = Val;
    else {
    while(this.data[hash] == null)
      ++hash;
    this.data[hash] = Val;
    }
  }
  public Employee get(int Key) {
    int hash = this.hash(Key);
    
    if(this.data[hash].id != Key) {
      return linear(hash, Key);
    }
    else return this.data[hash];
  }
  public Employee linear(int hash, int ID) {
    while(data[hash].id != ID) {
      ++hash;
      if(data[hash] == null) return null;
    }
    return this.data[hash];
  }
  public Employee quad(int hash, int ID) {
    int num = 0;
    while(data[hash + num * num].id != ID) {
       ++num;
       if(data[hash + num * num] == null) return null;
    }
    return data[hash + num * num];
  }
  
  
}

