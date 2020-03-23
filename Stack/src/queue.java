
public class queue {
	
	int front;
	int rear;
	int maxLen;
	char[] Queue;

	
	
	public void init(int maxLen) {
		Queue = new char[maxLen];
		front = 0;
		rear = -1;
		this.maxLen = maxLen;
	}

	public void pushq(char x) {
		rear = rear+1;
		Queue[rear] = x;
	}

	int popq() {
		char x;
		x = Queue[front];
		front = front+1;
		return x;
	}

	

	public boolean isEmpty() {
		boolean empty;
		empty =false;
		if(front>=rear) {
			empty = true;
		}
		return empty;
		}
	
	
	
	}
