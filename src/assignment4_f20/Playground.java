package assignment4_f20;

public class Playground {
  public static void main(String[] args) {
    // Add more tests as methods and call them here!!
    //RunMyTests();
	  //HeapTest();
	  //ReferTest();
	  //PriorityTest();
	  //DelTest();
	  
	  //Test0();
	  //CacheTest();
	  //swapTest();
	  //swapTest2();
	  
	  //IncElt0();
	  //IncDec3();
	  
	  //ReferTest2();
	  
//	  CacheMapTest1();
	  //CacheMapTest2(); 
	  //delMinTest2();
	  
//	  minTest();
	  
	  //delMinTest4();
	  
	  CacheMapTest1();
	  
	  // etc.
  }
  
  public static void CacheHeapTest2() {
	  Cache_LFU lfc = new Cache_LFU(3);
	  lfc.refer("AA8C");
	  lfc.refer("AA8C");
	  lfc.refer("1234");
	  lfc.refer("234A");
	  lfc.refer("AA8C");
	  lfc.refer("1234");
	  lfc.refer("ABCD");
	  
//	  System.out.println(lfc.getHashMap().get("ABCD").toString());
	  
	  printHeap(lfc.getHeap().getHeap(), lfc.getHeap().size());

  }
  
  public static void delMinTest4() {
	  MinBinHeap mbh = new MinBinHeap(7);
	  mbh.insert(new CacheFrame("a", 3));
	  mbh.insert(new CacheFrame("b", 5));
	  mbh.insert(new CacheFrame("c", 9));
	  mbh.insert(new CacheFrame("d", 7));
	  mbh.insert(new CacheFrame("e", 4));
	  mbh.insert(new CacheFrame("f", 6));
	  mbh.insert(new CacheFrame("g", 2));
	  
	  mbh.delMin();
	  mbh.delMin();
	  
	  printHeap(mbh.getHeap(), mbh.size());
  }
  
  public static void minTest() {
	  MinBinHeap mbh = new MinBinHeap(5);
	  mbh.insert(new CacheFrame ("a", 3));
	  mbh.delMin();
	  System.out.println(mbh.getMin());
	  
//	  mbh.delMin();
	  
	  //printHeap(mbh.getHeap(), mbh.size());
  }

  public static void delMinTest2() {
	  MinBinHeap mbh = new MinBinHeap(7);
	  mbh.insert(new CacheFrame("a", 1));
	  mbh.insert(new CacheFrame("b", 2));
	  mbh.insert(new CacheFrame("c", 3));
	  
	  mbh.delMin();
	  
	  printHeap(mbh.getHeap(), mbh.size());
  }
  
//  public static void delMinTest() {
//	  MinBinHeap mbh = new MinBinHeap(7);
//	  mbh.insert(new CacheFrame("a", 1));
//	  mbh.insert(new CacheFrame("b", 2));
//	  mbh.insert(new CacheFrame("c", 3));
//	  mbh.insert(new CacheFrame("d", 4));
//	  mbh.insert(new CacheFrame("e", 5));
//	  mbh.insert(new CacheFrame("f", 6));
//	  mbh.insert(new CacheFrame("g", 7));
//	  
//	  mbh.delMin();
//	  
//	  printHeap(mbh.getHeap(), mbh.size());
//	  }
  
  public static void CacheMapTest2() {
	  Cache_LFU lfc = new Cache_LFU(30);
	  lfc.refer("AA8C");
	  lfc.refer("AA8C");
	  lfc.refer("1234");
	  lfc.refer("234A");
	  lfc.refer("ABCD");
	  
	  System.out.println(lfc.getHashMap().get("ABCD").toString());
	  
	  printHeap(lfc.getHeap().getHeap(), lfc.getHeap().size());
  }
  
  public static void CacheMapTest1() {
	  Cache_LFU lfc = new Cache_LFU(3);
	  lfc.refer("AA8C");
	  lfc.refer("AA8C");
//	  lfc.refer("AA8C");
//	  lfc.refer("1234");
//	  lfc.refer("AA8C");
	  lfc.refer("1234");

	  
	  System.out.println(lfc.getHashMap().get("AA8C").toString());
	  
	  printHeap(lfc.getHeap().getHeap(), lfc.getHeap().size());
  }
  
  
  public static void ReferTest2() {
	  Cache_LFU lfc = new Cache_LFU(3);
	  lfc.refer("AA8C");
	  lfc.refer("AA8C");
	  lfc.refer("1234");
	  lfc.refer("234A");
	  lfc.refer("ABCD");
	  
	  System.out.println(lfc.isFull());
	  
	  printHeap(lfc.getHeap().getHeap(), lfc.getHeap().size());
  }
  
  
  public static void IncDec3() {
	  MinBinHeap mbh = new MinBinHeap(7);
	  mbh.insert(new CacheFrame("a", 3));
	  mbh.insert(new CacheFrame("b", 5));
	  mbh.insert(new CacheFrame("c", 9));
	  mbh.insert(new CacheFrame("d", 7));
	  mbh.insert(new CacheFrame("e", 4));
	  mbh.insert(new CacheFrame("f", 6));
	  mbh.insert(new CacheFrame("g", 2));
	  
	  mbh.incElt(new CacheFrame("g", 2));
	  mbh.incElt(new CacheFrame("g", 2));
	  
	  mbh.decElt(new CacheFrame("d", 7));
	  mbh.decElt(new CacheFrame("d", 7));
	  
	  mbh.incElt(new CacheFrame("b", 5));
	  
	  mbh.incElt(new CacheFrame("e", 4));
	  mbh.incElt(new CacheFrame("e", 4));
	  
	  printHeap(mbh.getHeap(), mbh.size());
	  }
  
  public static void IncElt0() {
	  MinBinHeap mbh = new MinBinHeap(7);
	  mbh.insert(new CacheFrame("a", 3));
	  mbh.insert(new CacheFrame("b", 5));
	  mbh.insert(new CacheFrame("c", 9));
	  mbh.insert(new CacheFrame("d", 7));
	  mbh.insert(new CacheFrame("e", 4));
	  mbh.insert(new CacheFrame("f", 6));
	  mbh.insert(new CacheFrame("g", 2));
	  
	  mbh.incElt(new CacheFrame("g", 2));
	  mbh.incElt(new CacheFrame("g", 2));

	  
	  printHeap(mbh.getHeap(), mbh.size());
	  
//	  System.out.println(mbh.getHeap()[1]);

	  }
  
  public static void swapTest() {
	  MinBinHeap mbh = new MinBinHeap(4);
	  mbh.insert(new CacheFrame("AAAA", 2));
	  mbh.insert(new CacheFrame("BBBB", 2));
	  mbh.insert(new CacheFrame("CCCC", 3));
	  mbh.insert(new CacheFrame("DDDD", 2));
	  
	  mbh.decElt(new CacheFrame("DDDD", 2));
	  
	  printHeap(mbh.getHeap(), mbh.size());
	  
	  System.out.println(mbh.getHeap()[1]);

	  }
  
  public static void swapTest2() {
	  MinBinHeap mbh = new MinBinHeap(4);
	  mbh.insert(new CacheFrame("AAAA", 2));
	  mbh.insert(new CacheFrame("BBBB", 2));
	  mbh.insert(new CacheFrame("CCCC", 3));
	  mbh.insert(new CacheFrame("DDDD", 2));
	  
	  mbh.incElt(new CacheFrame("AAAA", 2));
	  
	  printHeap(mbh.getHeap(), mbh.size());
	  
	  System.out.println(mbh.getHeap()[1]);

	  }
  
  public static void CacheTest() {
	   Cache_LFU lfc = new Cache_LFU(3);
	    lfc.refer("AA8C");
	    lfc.refer("AA8C");

	    System.out.println(lfc.numElts());
	    printHeap(lfc.getHeap().getHeap(), lfc.getHeap().size());
	 
	    // etc.

	  }
  public static void Test0() {
//	  MinBinHeap mbh = new MinBinHeap(3);
//	  mbh.insert(new CacheFrame("AAAA", 1));
//	  mbh.insert(new CacheFrame("BBBB", 2));
//	  
//	  
//	  mbh.getMin()
//	  
//	  printHeap(mbh.getHeap(), mbh.size());

  }
  
  public static void DelTest() {
	  MinBinHeap mbh = new MinBinHeap(3);
	  mbh.insert(new CacheFrame("AAAA", 1));
	  mbh.insert(new CacheFrame("BBBB", 2));
	  
	  mbh.delMin();
	  
	  printHeap(mbh.getHeap(), mbh.size());

  }
  
  public static void PriorityTest() {
	  MinBinHeap mbh = new MinBinHeap(3);
	  mbh.insert(new CacheFrame("AAAA", 1));
	  mbh.insert(new CacheFrame("BBBB", 2));
	  mbh.decElt(new CacheFrame("BBBB", 2));
	  mbh.decElt(new CacheFrame("BBBB", 2));
	  printHeap(mbh.getHeap(), mbh.size());

  }
  
  public static void ReferTest() {
	  Cache_LFU lfc = new Cache_LFU(3);
	  lfc.refer("AA8C");
	  lfc.refer("AA8C");
	  printHeap(lfc.getHeap().getHeap(), lfc.getHeap().size());
  }
  
  public static void HeapTest() {
	  MinBinHeap mbh = new MinBinHeap(3);
	  mbh.insert(new CacheFrame("316A", 1));
	  mbh.insert(new CacheFrame("AD43", 2));
	  mbh.insert(new CacheFrame("BB12", 3));
	  printHeap(mbh.getHeap(), mbh.size());
  }
  
  public static void RunMyTests2() {
	  Cache_LFU lfc = new Cache_LFU(3);
  }

  public static void RunMyTests() {
   Cache_LFU lfc = new Cache_LFU(20);
    lfc.refer("AA8C");
    lfc.refer("AA8C");
    lfc.refer("1234");
    lfc.refer("234A");
    lfc.refer("AA8C");
    lfc.refer("234A");
    lfc.refer("ABCD");
    lfc.refer("234A");
    lfc.refer("ABCD");
    lfc.refer("1101");
    lfc.refer("2202"); lfc.refer("2202");
    lfc.refer("2202"); lfc.refer("2202");

    System.out.println(lfc.size());
    System.out.println(lfc.numElts());
    printHeap(lfc.getHeap().getHeap(), lfc.getHeap().size());
 
    // etc.

  }

  public static void printHeap(CacheFrame[] e,int len) { 
    // this method skips over unused 0th index....
    System.out.println("Printing Heap");
    for(int i=1; i< len+1; i++) {
      System.out.print("(p."+e[i].value+",f"+e[i].priority+",s"+e[i].getSlot()+")\t");
    }
    System.out.print("\n");
  }

}
