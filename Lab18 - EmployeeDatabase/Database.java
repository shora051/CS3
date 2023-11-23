public class Database {
  Employee data[] = new Employee[500000];
  public int hash(int key) {
    return (key % 100000 - 10000);
  }
  public void put(int Key, Employee Val) {
    int hash = this.hash(Key);
    if(this.data[hash] == null || this.data[hash].id == Val.id)
      this.data[hash] = Val;
    else {
      linear(hash, Val);
    }
  }
  public Employee get(int Key) {
    int hash = this.hash(Key);
    if(this.data[hash] == null) return null;
    if(this.data[hash].id != Key) {
      return linearGet(hash, Key);
    }
    else return this.data[hash];
  }
  public Employee linearGet(int hash, int ID) {
    while(data[hash].id != ID) {
      ++hash;
      if(data[hash] == null) return null;
    }
    return this.data[hash];
  }
  public Employee quadGet(int hash, int ID) {
    int num = 0;
    while(data[hash + num * num].id != ID) {
       ++num;
       if(data[hash + num * num] == null) return null;
    }
    return data[hash + num * num];
  }
  public void linear(int hash, Employee val) {
    while(this.data[hash] == null)
      ++hash;
    this.data[hash] = val;
  }
  public void quad(int hash, Employee val) {
    int ind = 1;
    while(this.data[hash + ind * ind] == null)
      ++ind;
    this.data[hash + ind * ind] = val;
  }
}
