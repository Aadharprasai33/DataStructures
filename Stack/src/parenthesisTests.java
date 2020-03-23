import java.util.Scanner;
	
public class parenthesisTests {
	
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.println("Enter the expression");
		String expression = input.nextLine();
		if(isBalanced(expression)) {
			System.out.println("the parenthesis is balanced");
			}
		else
			System.out.println("not balanced");

	}
	
	
	
	public static boolean isBalanced(String e) {
		
		int i;
		char ch;
		Stack s = new Stack();
		s.init(e.length());
		
		for(i = 0; i<e.length(); i++) {

			ch = e.charAt(i);
			
			if(ch == '(') {
				s.push(ch);
			}
			if(ch == ')') {
					if(s.empty()) {
						return false;
					}
					else {
						s.pop();
					}
			}
			
		}
		if(s.empty())
		return true;
		else
			return false;
	}
}
		
		
			
			
			
			
		
		
		
		
	
	
	
	


