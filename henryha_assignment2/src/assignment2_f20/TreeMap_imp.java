package assignment2_f20;
public class TreeMap_imp implements TreeMap { 
  TMCell root;
  private TMCell one = getRoot();
  private TMCell two  = getRoot();
  private TMCell three = getRoot();
  private TMCell four = getRoot();
  private TMCell five = getRoot();
  private TMCell six = getRoot();
  private TMCell seven = getRoot();
  private TMCell eight = getRoot();
  private TMCell nine = getRoot();
  private boolean right = false;
  private boolean left = false;
  private int count = 0;
  private int arrayCount = 0;
  private String array[];

  TreeMap_imp () { 
    root = null; 
  }
  @Override
  public TMCell getRoot() { return this.root; }
  
  //-------------------------------------------------------------
  // "height" is a complete implementation 
  // of the public interface method height
  // it is here to illustrate fr you how the textbook sets up 
  // the method implementation as recursion
  // you may include this in your project directly

  public int height() { // public interface method signature
  // this method is the public interface method
  // it is not recursive, but it calls a recursive
  // private method and passes it access to the tree cells
    return height_r(this.getRoot());
  }
  private int height_r(TMCell c) { 
  // inner method with different signature
  // this helper method uses recursion to traverse
  // and process the recursive structure of the tree of cells
    if (c==null) return -1;
    int lht = height_r(c.getLeft());
    int rht = height_r(c.getRight());
    return Math.max(lht,rht) + 1;
  }

@Override
public Value put(String k, Value v) {
	if(getRoot() == null) {
		root = new TMCell_imp(k,v);
		count++;
		return null;
	}
	
	if(five == null) {
		five = getRoot();
	}
	
	if(get(k) == null) {
		if(k.compareTo(five.getKey()) < 0) {
			if(five.getLeft() == null) {
				five.setLeft(new TMCell_imp(k,v));
				five = null;
				count++;
				return null;
			} else if(five.getLeft() != null) {
				five = five.getLeft();
				return put(k,v);
			}
		} else if(k.compareTo(five.getKey()) > 0) {
			if(five.getRight() == null) {
				five.setRight(new TMCell_imp(k,v));
				five = null;
				count++;
				return null;
			}else if(five.getRight() != null) {
				five = five.getRight();
				return put(k,v);
			}
		}
	}else if(get(k) != null) {
		if(five.getKey() == k) {
			Value temp = get(k);
			five.setValue(v);
			return temp;
		}else if(five.getKey().compareTo(k) > 0 && five.getRight() != null) {
			five= five.getLeft();
			return put(k,v);
		}
	}
	
	return null;
}

@Override
public Value get(String k) {
	if(getRoot() == null) {
		return null;
	} 
	
	if(one == null) {
		one = getRoot();
	}
	
	if(one.getValue() != null) {
		if(k.equals(one.getKey())) {
			return one.getValue();

		} else if(k.compareTo(one.getKey()) > 0) {
			if(one.getRight() == null) {
				return null;
			} else {
				one = one.getRight();
				return get(k);
			}	
		} else if(k.compareTo(one.getKey()) < 0) {
			if(one.getLeft() == null) {
				return null;
			} else {
				one = one.getLeft();
				return get(k);
			}
		}
	}
	
	return one.getValue();
}

@Override
public void remove(String k) {
	if (getRoot() == null) {
		return;
	}
	
	if(two == null) {
		two = getRoot();
	}
	
	if (getRoot().getKey().contentEquals(k) && getRoot().getRight() == null && getRoot().getLeft() == null) {
		count--;
		root = null;
		return;
	}
	
	if (k.compareTo(two.getKey()) < 0){
		if(two.getLeft() == null) {
			return;
		}
		if(two.getLeft().getKey().equals(k)){
			nine = two;
		}
		two = two.getLeft();
		remove(k);
	} else if(k.compareTo(two.getKey()) > 0) {
		if(two.getRight() == null) {
			return;
		}
		if(two.getRight().getKey().equals(k)){
			nine = two;
		}
		two = two.getRight();
		remove(k);
	} else if(k.compareTo(two.getKey()) == 0) {
		if(two.getRight() == null && two.getLeft() == null && two == getRoot()) {
			two.setKey(null);
			two.setValue(null);
			root = null;
			count--;
		} if(two.getRight() == null && two.getLeft() == null) {
			if(nine.getLeft() == two && nine != null && nine.getLeft()!= null) {
				nine.setLeft(null);
			} else if(nine.getRight() == two && nine != null && nine.getRight()!= null) {
				nine.setRight(null);
			}
			two.setKey(null);
			two.setValue(null);
			count--;
			return;
		} else if(two.getRight() == null && two.getLeft() != null && two == getRoot()) {
			root = two.getLeft();
			two.setLeft(null);
			two.setKey(null);
			two.setValue(null);
			count--;
			return;
		} else if(two.getRight() == null && two.getLeft() != null) {
			four = two.getLeft();
			two.setValue(four.getValue());
			two.setKey(four.getKey());
			count--;
			if(four.getLeft() != null) {
				two.setLeft(four.getLeft());
				four.setLeft(null);
				four.setKey(null);
				four.setValue(null);
			} if(four.getRight() != null) {
				two.setRight(four.getRight());
				four.setRight(null);
				four.setKey(null);
				four.setValue(null);
			} if(four.getLeft() == null) {
				two.setLeft(null);
				four.setValue(null);
				four.setKey(null);
			} if(four.getRight() == null) {
				two.setRight(null);
				four.setValue(null);
				four.setKey(null);
			}
			return;
		} else if(two.getRight() != null && two.getLeft() == null && two == getRoot()) {
			root = two.getRight();
			two.setRight(null);
			two.setKey(null);
			two.setValue(null);
			count--; 
			return;
		} else if(two.getRight() != null && two.getLeft() == null) {
			four = two.getRight();
			two.setValue(four.getValue());
			two.setKey(four.getKey());
			count--;
			if(four.getLeft() != null) {
				two.setLeft(four.getLeft());
				four.setLeft(null);
				four.setKey(null);
				four.setValue(null);
			} if(four.getRight() != null) {
				two.setRight(four.getRight());
				four.setRight(null);
				four.setKey(null);
				four.setValue(null);
			} if(four.getLeft() == null) {
				two.setLeft(null);
				four.setValue(null);
				four.setKey(null);
			} if(four.getRight() == null) {
				two.setRight(null);
				four.setValue(null);
				four.setKey(null);
			}
			return;
			
			} else if(two.getRight() != null && two.getLeft() != null) {
				if(k.compareTo(getRoot().getKey()) < 0) {
					if(getMax(two) != null) {
						two.setKey(getMax(two).getKey());
						two.setValue(getMax(two).getValue());
						eight = two;
						maxDel();
						count--;
						return;
					}
				} else if(k.compareTo(getRoot().getKey()) > 0) {
					if(getMin(two) != null) {
						two.setKey(getMin(two).getKey());
						two.setValue(getMin(two).getValue());
						eight = two;
						minDel();
						count--;
						return;
					}
				} else if(k.compareTo(getRoot().getKey()) == 0) {
					two = getRoot().getRight();
					two.setLeft(getRoot().getLeft());
					getRoot().setLeft(null);
					getRoot().setRight(null);
					root = two;
					count--;
					return;
				}
		
			}
	} 
}

private void minDel() {
	if (right == false) {
		eight = two;
		two = two.getRight();
		right = true;
		minDel();
	} else if(two.getLeft() != null){
		eight = two;
		two = two.getLeft();
		minDel();
	} else {
		eight.setRight(null);
		right = false;
		return;
	}
}

private void maxDel() {
	if (left == false) {
		eight = two;
		two = two.getLeft();
		left = true;
		maxDel();
	} else if(two.getRight() != null){
		eight = two;
		two = two.getRight();
		maxDel();
	} else {
		eight.setLeft(null);
		left = false;
		return;
	}
}

private TMCell getMin(TMCell t) {
	if (right == false) {
		t = t.getRight();
		right = true;
		return getMin(t);
	} else if(t.getLeft() != null){
		t = t.getLeft();
		return getMin(t);
	} else {
		right = false;
		return t;
	}
}

private TMCell getMax(TMCell t) {
	if (left == false) {
		t = t.getLeft();
		left = true;
		return getMax(t);
	} else if(t.getRight() != null){
		t = t.getRight();
		return getMax(t);
	} else {
		left = false;
		return t;
	}
}

@Override
public boolean hasKey(String k) {
	if(getRoot() == null) {
		return false;
	} if(seven == null) {
		seven = getRoot();
	}
	if(seven.getKey().equals(k)){
		return true;
	} else if (k.compareTo(seven.getKey()) > 0) {
		if(seven.getRight() == null) {
			return false;
		} else {
			seven = seven.getRight();
			hasKey(k);
		}
	} else if (k.compareTo(seven.getKey()) < 0) {
		if(seven.getLeft() == null) {
			return false;
		} else {
			seven = seven.getLeft();
			hasKey(k);
		}
	}
	return false;
}

@Override
public int size() {
	if(getRoot() == null) {
		return 0;
	}
	return count;
}

@Override
public String maxKey() {
	if(three == null) {
		three = getRoot();
	}
	if(getRoot() == null) {
		return null;
	} else if(getRoot().getRight() == null) {
		return getRoot().getKey();
	} else {
		if(three.getRight() != null) {
			three = three.getRight();
			return maxKey();
		} else {
			return three.getKey();
		}
	}
}

@Override
public String minKey() {
	if(six == null) {
		six = getRoot();
	}
	if(getRoot() == null) {
		return null;
	} else if (getRoot().getLeft() == null) {
		return getRoot().getKey();
	} else {
		if(six.getLeft() != null) {
			six = six.getLeft();
			return minKey();
		} else {
			return six.getKey();
		}
	}
}

@Override
public String[] getKeys() {
	inOrder(getRoot());
	return array;

}

private void inOrder(TMCell t) {
	if(array == null) {
		array = new String[size()];
	}
	if(arrayCount == size()) {
		return;
	}
	if(getRoot() == null) {
		return;
	}
	if(t.getLeft() != null) {
		inOrder(t.getLeft());
	}
	if(t != null) {
		array[arrayCount] = t.getKey();
	}
	arrayCount++;
	if(t.getRight() != null) {	
		inOrder(t.getRight());
	}
}
}