import java.util.Scanner;


public class infixToPostFix {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		String ex = input.nextLine();
		System.out.print(Evaluation(ex));
	}

	public static String Evaluation(String expression) {
		
		String x = "";
		queue q = new queue();
		Stack s = new Stack();
		q.init(expression.length());
		s.init(expression.length());
		char op;
		for (int i = 0; i < expression.length(); ++i) {
			char[] ch = expression.toCharArray();
			if (Character.isLetterOrDigit(ch[i])) {
				q.pushq(ch[i]);
			}
			else if (ch[i] == '-' || ch[i] == '*' || ch[i] == '+' || ch[i] == '/' ) {
				s.push(ch[i]);	
				}
			
			 else if (ch[i] == ')') {
				op = s.pop();
					q.pushq(op);
				}
			
		}
		while (!(s.empty())) {
			op = s.pop();
			q.pushq(op);
		}
		
for(int i = 0; i< q.Queue.length; i++) {
	
		x = x + q.Queue[i]+ " ";
		}	

return x;
	}
	
}
		
	

	
	
