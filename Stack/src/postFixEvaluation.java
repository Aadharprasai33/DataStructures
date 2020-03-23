import java.util.Scanner;

public class postFixEvaluation {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		String expression = input.nextLine();
		System.out.print(calc(expression));

	}

	public static int calc(String ex) {
		Stack s = new Stack();
		s.init(ex.length());
		int top;
		int x,y;

		char[] ch = ex.toCharArray();
		int z = 0;
		for (int i = 0; i < ch.length; i=i+2) {
		
			if (!(ch[i] == '+' || ch[i] == '-' || ch[i] == '*' || ch[i] == '/' )) {
				
				s.push(ch[i]);
			} 
			
			else {
			y = (char)(s.pop()-'0');
			x = (char)(s.pop()-'0');
			if (ch[i] == '+') {
				z = (x + y);
			} else if (ch[i] == '-') {
				z = (x - y);
			} else if (ch[i] == '*') {
				z = (x * y);
			} else {
				z = (x / y);
			}
			
			s.push((char)(z+'0'));
		}
		}
		

	
		return (z);

	}
	}


