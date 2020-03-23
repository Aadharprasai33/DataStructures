
class node {
	String name;
	int data;
	int data2;
	node next;
}

class indexNode {
	String name;
	int data;
	node next;
}

public class BabyLinkedList {

	indexNode[] nameCodeIndex = new indexNode[26];
	node front;
	node prev, current;
	node temp, temp2;

	public void init() {
		front = null;
	}

	public node makeNode(int num) {
		node n = new node();
		n.data = num;

		n.next = null;
		return n;
	}

	public node makeNode(int nameCode, String s) {
		temp = new node();
		temp.name = s;
		temp.data = nameCode;

		temp.next = null;
		return temp;
	}

	public int getCode(String s) {
		char a0, a1, a2;
		a0 = s.charAt(0);
		a1 = s.charAt(1);
		a2 = s.charAt(2);
		int code = (a0 - 'a') * 26 * 26 + (a1 - 'a') * 26 + (a2 - 'a');
		return code;
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
				if (current.data == num) {
					searching = false;
				} else if (current.data < num) {
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

	public void insert(int num, String name) {

		boolean searching;
		if (front == null) {
			front = makeNode(num, name);

		} else if (num < front.data) {
			temp = makeNode(num, name);
			temp.next = front;
			front = temp;

		} else {
			current = front;
			prev = current;
			searching = true;
			while (searching) {
				if (current.data == num) {
					searching = false;
				} else if (current.data < num) {
					if (current.next == null) {
						current.next = makeNode(num, name);
						searching = false;

					} else {
						prev = current;
						current = current.next;
					}
				} else if (current.data > num) {
					temp = makeNode(num, name);
					temp.next = current;
					prev.next = temp;
					searching = false;
				}
			}

		}
	}

	public void InsertAfter(node spot, int number) {
		node newNode;
		newNode = new node();
		newNode.next = spot.next;
		spot.next = newNode;
		newNode.data = number;
	}

	public void showListName() {
		current = front;
		while (current != null) {
			System.out.println(current.name);
			current = current.next;

		}
	}

	public void showList() {
		current = front;
		while (current != null) {
			System.out.println(current.data);
			current = current.next;

		}
	}

	public node spotInList(int number) {
		current = front;
		prev = current;
		while (current.data < number) {
			prev = current;
			current = current.next;

		}
		return prev;

	}

	public node spotInListname(int num) {
		current = front;
		prev = current;

		while (current.data < num) {
			prev = current;
			current = current.next;

		}
		return prev;

	}

	public void delete(int number) {
		current = front;
		prev = current;
		node nextNode;
		while (current.data != number) {
			prev = current;
			current = current.next;

		}
		nextNode = prev.next;
		prev.next = nextNode.next;

	}

	public node findIndex(int code) {
		current = front;
		prev = current;

		while ((current.next != null) && (current.data2 < code)) {

			prev = current;
			current = current.next;
		}
		return prev;
	}

	public void makeIndexList(int codeByUser) {
		node spot;
		spot = new node();

		for (int j = 0; j < 26; j++) {
			spot = findSpot(codeByUser);
			nameCodeIndex[j] = new indexNode();
			nameCodeIndex[j].data = j;
			nameCodeIndex[j].name = spot.name;
			nameCodeIndex[j].next = spot;
		}

	}

	public node findSpot(int codeUser) {
		current = front;
		temp = new node();
		int codeToCheck = (codeUser - 0) * 26 * 26 + ('z' - 'a') * 26 + ('z' - 'a');
		while (current.next != null) {
			int x = ((current.name).charAt(0))-'a';
			if (( x == codeUser) && (current.data <= (codeToCheck))) {
				temp = current;
				current = current.next;
				return temp;
			}
			else
				current = current.next;
			
		}
		return current;

	}
	
	public void counting(int count) {
		System.out.println("for the entered alphabet number of names is " + count);
	}

	public void showListIndexed(int codeUser) {
		int count = 0;
		node printNode;
		printNode = new node();
		printNode = nameCodeIndex[codeUser].next;
		int codeToCheck = (codeUser - 0) * 26 * 26 + ('z' - 'a') * 26 + ('z' - 'a');
		do{
			if ((printNode.data < (current.data))) {
				count++;
				System.out.println(printNode.name);
				
			}
			
			printNode = current;
			current = current.next;

		} while(printNode.next != null && (printNode.data <= codeToCheck));
		count++;
		System.out.println(printNode.name);
		
		counting(count);
	}
	
}
