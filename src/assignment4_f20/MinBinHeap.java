package assignment4_f20;

public class MinBinHeap implements Heap {
  private CacheFrame[] array; // load this array
  private int size;      // how many items currently in the heap
  private int arraySize; // Everything in the array will initially
                         // be null. This is ok! Just build out
                         // from array[1]

  public MinBinHeap(int nelts) {
    this.array = new CacheFrame[nelts+1];  // remember we dont use slot 0
    this.arraySize = nelts+1;
    this.size = 0;
    this.array[0] = new CacheFrame(null, 0); // 0 not used, so this is arbitrary
  }

  // Please do not remove or modify this method! Used to test your entire Heap.
  @Override
  public CacheFrame[] getHeap() { return this.array; }

  //===============================================================
  //
  // here down you implement the ops in the interface
  //
  //===============================================================

  public void insert(CacheFrame elt) {
	  if (this.size()+1 < this.arraySize) {
		  int slot = this.size() + 1;
		  this.array[slot] = elt;
		  elt.setSlot(slot);
		  this.size++;
		  
		  bubble_up(this.array[slot]);
		  bubble_down(this.array[slot]);
	  }
  }
  public void delMin() {
	  if (this.size() > 0) {
		  swap_pos(this.array[1].getSlot(), this.array[this.size()].getSlot());
		  this.array[this.size()] = null;

	  	  this.size -= 1;
	  	  	  	  
	  	  if (this.size() > 0) {
	  		  this.bubble_down(this.array[1]);  
	  	  }
	  }
  }
  
  public CacheFrame getMin() {
	  return this.array[1];
  }
  public int size() {
	  return this.size;
  }
  
  public int get_pos_of_elt(CacheFrame elt) {
	  for (int i = 0; i < this.array.length; i++) {
		  if (this.array[i].getValue()== elt.getValue()) {
			  return i;
		  }
	  }
	  return -1;
  }
  
  private int get_parent_pos(int pos) {
	  // is root
	  if (pos == 1) {
		  return pos; //[!]
	  }
	  // left child
	  if (pos % 2 == 0) {
		  return pos / 2;
	  }
	  // right child
	  else {
		  return (pos - 1) / 2;
	  }
  }
  
  private int get_left_child_pos(int pos) {
	  // has no left child
	  if (pos*2 > this.size) {
		  return -1;
	  }
	  // has left child
	  else {
		  return pos*2;
	  }
  }
  
  private int get_min_priority_child_pos(int pos) {
	  int left_child_pos = pos*2;
	  int right_child_pos = pos*2+1;
	  
	  boolean left_exists = (left_child_pos <= this.size());
	  boolean right_exists = (right_child_pos <= this.size());
	  
	  if (!left_exists && !right_exists) {
		  return -1;
	  }
	  if (left_exists && !right_exists) {
		  return left_child_pos;
	  }
	  if (!left_exists && right_exists) {
		  return right_child_pos;
	  }
	  else {
		  if (this.array[left_child_pos].getPriority() > this.array[right_child_pos].getPriority()) {
			  return right_child_pos;
		  }
		  else {
			  return left_child_pos;
		  }	  
	  }
  }
  
  private CacheFrame get_parent(CacheFrame elt) {
	  int pos = elt.getSlot();
	  int parent_pos;
	  
	  // is root
	  if (pos == 1) {
		  parent_pos = pos; //[!]
	  }
	  // left child
	  if (pos % 2 == 0) {
		  parent_pos = pos / 2;
	  }
	  // right child
	  else {
		  parent_pos = (pos - 1) / 2;
	  }
	  
	  return this.array[parent_pos];
  }
  
  public void incElt( CacheFrame elt ) {
	  int pos = get_pos_of_elt(elt);
	  
	  if (pos != -1) {
		  int new_priority = this.array[pos].getPriority() + 1;
		  this.array[pos].setPriority(new_priority);
		  elt.setPriority(new_priority);
	  }
	  
	  bubble_down(this.array[pos]);
  }
  
  private void bubble_up(CacheFrame elt) {
	  int elt_pos = elt.getSlot();
	  int parent_pos = get_parent_pos(elt_pos);
	  
	  while (this.array[elt_pos].getPriority() < this.array[parent_pos].getPriority()) {
		  swap_pos(elt_pos, parent_pos);
		  elt_pos = parent_pos;
		  parent_pos = get_parent_pos(elt_pos);
	  }
  }
  
  private void bubble_down(CacheFrame elt) {
	  int elt_pos = elt.getSlot();
	  int min_priority_child_pos = get_min_priority_child_pos(elt_pos);
	  
	  while (min_priority_child_pos != -1 && this.array[elt_pos].getPriority() > this.array[min_priority_child_pos].getPriority()) {
		  swap_pos(elt_pos, min_priority_child_pos);
		  elt_pos = min_priority_child_pos;
		  min_priority_child_pos = get_min_priority_child_pos(elt_pos);
	  }
  }
  
  private void swap_pos(int pos1, int pos2) {
	  CacheFrame temp = this.array[pos1];
	  int pos1_slot = this.array[pos1].getSlot();
	  int pos2_slot = this.array[pos2].getSlot();
	  
	  this.array[pos1] = new CacheFrame(this.array[pos2].getValue(), this.array[pos2].getPriority());
	  this.array[pos1].setSlot(pos1_slot);
	  
	  this.array[pos2] = new CacheFrame(temp.getValue(), temp.getPriority());
	  this.array[pos2].setSlot(pos2_slot);
  }
  
  public void decElt( CacheFrame elt ) {
	  int pos = get_pos_of_elt(elt);
	  
	  if (pos != -1) {
		  int new_priority = this.array[pos].getPriority() - 1;
		  if (new_priority < 1) { new_priority = 1; }
		  this.array[pos].setPriority(new_priority);
		  elt.setPriority(new_priority);
	  }

	  bubble_up(this.array[pos]);
  }

}
