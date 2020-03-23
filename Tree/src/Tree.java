import java.util.ArrayList;

class treeNode {
	int data;

	treeNode left, right;
}

class node {
	int data;
	
	node next;
}

class LinkedList{
	
	node front, current, temp, prev;
	public void init() {
		front = null;
	}

	public node makeNode(int num) {
		node n = new node();
		n.data = num;
		
		n.next = null;
		return n;
	}

	public void insert(int num) {
		
		boolean searching;
		if (front == null) {
			front = makeNode(num);

		} else if (num < front.data) {
			temp = makeNode(num);
			temp.next = front;
			front = temp;

		} else {
			current = front;
			prev = current;
			searching = true;
			while (searching) {
			
			if (current.data <= num) {
					if (current.next == null) {
						current.next = makeNode(num);
						searching = false;

					} else {
						prev = current;
						current = current.next;
					}
				} else if (current.data > num) {
					temp = makeNode(num);
					temp.next = current;
					prev.next = temp;
					searching = false;
				}
			}

		}
	}

}

public class Tree {
	int numCount = 0;
	treeNode root = new treeNode();
	int comparison2 = 0;
	LinkedList linklist = new LinkedList();

	void init() {
		root = null;
	}

	treeNode makeTreeNode(int number) {
		treeNode x = new treeNode();
		x.data = number;
		x.left = null;
		x.right = null;
		return x;
	}

	public node makeNode(int num) {
		node n = new node();
		n.data = num;

		n.next = null;
		return n;
	}
	
		void setLeft(treeNode t, int num) {
		if (t.left != null) {
			System.out.print("error");
		} else
			t.left = makeTreeNode(num);
	}

	void setRight(treeNode t, int num) {
		if (t.right != null) {
			System.out.print("error");
		} else
			t.right = makeTreeNode(num);
	}

	void buildTree(ArrayList<Integer> list) {
		linklist.init();
		int j;
		int num;
		treeNode t = new treeNode();
		int comparison = 0;
		root = makeTreeNode(list.get(0));

		for (j = 1; j < list.size(); j++) {

			num = list.get(j);
			t = root;
			boolean searching = true;
			while (searching) {

				if (t.data == num) {
					
					linklist.insert(num);
					comparison++;
					searching = false;
				} else if (num < t.data) {
					
					if (t.left == null) {
						t.left = makeTreeNode(num);
						comparison++;
						searching = false;

					} else {
						comparison++;
						t = t.left;
					}
				}

				else if (num > t.data) {
					
					if (t.right == null) {

						t.right = makeTreeNode(num);
						comparison++;
						searching = false;
					} else {
						comparison++;
						t = t.right;

					}
				}
			}
		}
		System.out.println(comparison);
		counting(linklist.front);
	}
	
	void counting(node front) {
		int numCount =2;
		node current =front;
		
		boolean searching = true;
		boolean searching2 = true;
		while(searching2) {
			
			while(searching) {
				
				if(current.next!=null) {
				if(current.data == current.next.data) {
				numCount++;
				current= current.next;	
			}
			else 
				searching = false;
			}
				else {
				searching=false;
				searching2=false;
				}
			}
			
			
			System.out.println(current.data + " is repeated " + numCount+ " times");
			searching = true;
			numCount =2;
			current= current.next;
			}
		
		
	
		}
		
	
		
			
	

	void inorder(treeNode x) {

		if (x.left != null) {
			inorder(x.left);
		}
		System.out.println(x.data);

		if (x.right != null) {
			inorder(x.right);
		}
	}

	int findHigh(treeNode y) {
		if (y.right != null) {
			y.data = findHigh(y.right);
		}

		return (y.data);

	}

	void highToLow(treeNode z) {
		if (z.right != null) {
			highToLow(z.right);
		}

		System.out.println(z.data);

		if (z.left != null) {
			highToLow(z.left);
		}
	}

	void findNum(treeNode a, int num) {
		boolean searching = true;
		while ((searching) && (a != null)) {
			if (a.data < num) {

				a = a.right;

			}

			else if (a.data > num) {

				a = a.left;

			}

			else if (a.data == num) {
				System.out.println("the number is found " + a.data);
				searching = false;
			} 
		}
	}

	void findNumRec(treeNode b, int num) {

		if (b.data < num) {
			findNumRec(b.right, num);
		} else if (b.data > num) {
			findNumRec(b.left, num);
		} else if (b.data == num) {
			System.out.println("the number found by recursion is " + b.data);
		}

	}
	
	void find(int num, ArrayList<Integer> list, int i) {
		comparison2++;
		if(i<=list.size()) {
		if(list.get(i) == num) {
			System.out.println("found the num" + comparison2 + " " + list.get(i));
			
		}
		else {
			
			find(num, list, i=i+1);
		}
		}
	}
}

