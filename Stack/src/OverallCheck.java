
import java.util.Scanner;

import java.io.*;

public class OverallCheck {
	String fname;

	public OverallCheck() {
		System.out.println("Constructor");
		getFileName();
		readFileContents();
	}

	public void readFileContents() {
		boolean looping;
		DataInputStream in;
		String line;
		int j, len;
		char ch;
		int count = 0;

		/* Read input from file and process. */
		try {
			in = new DataInputStream(new FileInputStream(fname));

			line = in.readLine();
			parenthesisTests pt = new parenthesisTests();
			infixToPostFix itpf = new infixToPostFix();
			postFixEvaluation pfe = new postFixEvaluation();
			if (line.equals("parentheses tests")) {
				System.out.println(line);
				while (!((line = in.readLine()).equals("postfix equation solving"))) {
					System.out.println(line);

					if (pt.isBalanced(line)) {
						System.out.println("  is balanced");
					} else {
						System.out.println("  not balanced");

					}
				}
			}
			if (line.equals("postfix equation solving")) {
				System.out.println(line);

				while (!((line = in.readLine()).equals("infix to postfix conversion"))) {
					System.out.println(line);

					System.out.println(pfe.calc(line));

				}
			}

			if (line.equals("infix to postfix conversion")) {
				System.out.println(line);
				while (!((line = in.readLine())
						.equals("Parentheses check, infix to postfix conversion, postfix evaluation"))) {
					System.out.println(line);
					System.out.print(itpf.Evaluation(line));
					System.out.print("\n");

				}
			}

			if (line.equals("Parentheses check, infix to postfix conversion, postfix evaluation")) {
				System.out.println(line);
				while (!((line = in.readLine()).equals(""))) {
					if (pt.isBalanced(line)) {
						String x = itpf.Evaluation(line);
						System.out.println(x);
						System.out.println(pfe.calc(x));
					} else {
						System.out.println("It is not balanced");
						System.out.println();
					}
				}

			}
		} catch (IOException e) {
			System.out.println("Error " + e);
		}
	}

	public void getFileName() {
		Scanner in = new Scanner(System.in);

		System.out.println("Enter file name please.");
		fname = in.nextLine();
		System.out.println("You entered " + fname);
	}

	public static void main(String[] args) {

		System.out.println("Hello TV land!");

		new OverallCheck();

		System.out.println("Bye-bye!");
	}
}
