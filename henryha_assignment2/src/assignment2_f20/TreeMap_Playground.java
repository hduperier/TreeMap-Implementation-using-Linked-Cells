package assignment2_f20;

public class TreeMap_Playground {
/*
 * you will test your own TreeMap implementation in here
 *
 * we will replace this with our own when grading, and will
 * do what you should do in here... create TreeMap objects,
 * put data into them, take data out, look for values stored
 * in it, checking size, and looking at the TMCells to see if they 
 * are all linked up correctly as a BST
 * 
*/
  
  public static void main(String[] args) {
 

    TreeMap tester = new TreeMap_imp();
    Value v1 = new Value_imp(12345, 87.3, 21);
    Value v2 = new Value_imp(23456, 75.54, 25);
    Value v3 = new Value_imp(34567, 99.013, 19);
    Value v4 = new Value_imp(45678, 55.70, 35);
    Value v5 = new Value_imp(1245, 53.09, 23);
    Value v6 = new Value_imp(3987, 76.54, 12);
    
    tester.put("kappa", v1); tester.put("beta",v2); 
    tester.put("sigma",v3); tester.put("alpha",v4);
    tester.put("Phi", v5); tester.put("delta", v6);
    System.out.println(tester.get("sigma")); // assumes a toString for a Value onject
    System.out.println(tester.hasKey("gamma"));
    System.out.println(tester.maxKey());
    System.out.println(tester.hasKey("delta"));
    System.out.println(tester.size());
    
    prTree(tester.getRoot(),0); 

    

  }

  public static void prTree (TMCell c, int off) {
    if (c==null) return;
        
    prTree(c.getRight(), off+2);
    
    for (int i=0; i<off; i++) System.out.print(" ");
    System.out.println(c.getKey());
    
    prTree(c.getLeft(), off+2);
  }

}