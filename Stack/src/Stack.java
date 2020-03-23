
class Stack {
	int top;
	char stack[];
	int maxLen;
	
	public void init(int maxLen)
	{
		stack = new char[maxLen];
		top = -1;
		this.maxLen = maxLen;
	}
	
	public void push(char item)
	{
		top = top+1;
		stack[top] = item;
	}
	
	public char pop()
	{
		char item;
		item = stack[top];
		top = top-1;
		return item;
		
	}
	
	public boolean empty()
	{
		boolean empty = false;
		if(top == -1) {
			empty = true;
			
		}
		return empty;
	}
	
	public void reset()
	{
		top = -1;
	}
	
	public void showStack()
	{
		int j;
		
		System.out.println(" ");
		System.out.println("Stack contents ...");
		for(j=top;j>-1;j--) {
			System.out.println(stack[j]);
		}
		System.out.println(" ");
	}
	
	public void showStack0toTop()
	{
		int j;
		
		System.out.println(" ");
		System.out.println("Stack contents ...");
		for(j=0;j<=top;j++) {
			System.out.print(stack[j]);
		}
		System.out.println(" ");
	}
	
	
}
