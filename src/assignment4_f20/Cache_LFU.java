package assignment4_f20;

import java.util.HashMap;

public class Cache_LFU implements Cache {
  
  HashMap<String, CacheFrame> map; 
    // allocate from java collections lib
    // do it this way so we all start with default size and 
    // default lambda and default hash function for string keys
  MinBinHeap heap; // your own heap code above
  int limit;       // max num elts the cache can hold
  int size;        // current number elts in the cache
  
  public Cache_LFU (int maxElts) {
    this.map = new HashMap<String, CacheFrame>();
    this.heap = new MinBinHeap(maxElts);
    this.limit = maxElts;
    this.size = 0;
  }
  
  // dont change this we need it for grading
  public MinBinHeap getHeap() { return this.heap; }
  public HashMap getHashMap() { return this.map; }
  
  // =========================================================
  //
  // you fill in code for the other ops in the interface
  //
  //==========================================================
  public int size() {
	  return this.limit;
  }
  public int numElts() {
	  return this.size;
  }
  public boolean isFull() {
	  return this.numElts() == this.size();
  }
  
  public boolean refer( String address ) { 
	  boolean flag = this.map.containsKey(address);
	  
	  if (flag) {
		  CacheFrame cf = this.map.get(address);
		  int debug = cf.getPriority();
		  this.heap.incElt(cf);		  
	  }
	  else {
		  if (isFull()) {
			  CacheFrame del_this = this.heap.getMin();
			  this.heap.delMin();
			  this.map.remove(del_this.getValue());
			  this.size--;
		  }
		  CacheFrame new_cache_frame = new CacheFrame(address, 1);
		  
		  this.map.put(address, new_cache_frame);
		  this.heap.insert(this.map.get(address));
		  this.size++;
	  }
	  
	  update_slots();
	  return flag;
  }
  
  private void update_slots() {
	  int i = 1;
	  for(HashMap.Entry<String, CacheFrame> entry : this.map.entrySet()) {
		  int pos = this.getHeap().get_pos_of_elt(entry.getValue());
		  int slot = this.getHeap().getHeap()[pos].getSlot();
		  entry.getValue().setSlot(slot);
		  i++;
		}
  }
}
