
import java.util.ArrayList;
import java.util.Scanner;
import java.util.ArrayList;

import java.io.*;

public class File {
	String fname;

	public File() {
		System.out.println("Constructor");
		getFileName();
		readFileContents();
	}

	public void readFileContents() {
		boolean looping;
		DataInputStream in;
		Tree t = new Tree();
		int i= 0;
		int high = 0;
		String line;

		ArrayList<Integer> lineArray = new ArrayList<Integer>();
		int j, len;
		char ch;

		/* Read input from file and process. */
		try {
			in = new DataInputStream(new FileInputStream(fname));

			while ((line = in.readLine()) != null) {
				lineArray.add(Integer.parseInt(line));
			}

			t.buildTree(lineArray);

			t.inorder(t.root);
			System.out.println("\n");
			high = t.findHigh(t.root);
			System.out.println("Highest number is " + high);
			System.out.println("\n");
			
			
		
		}

		catch (IOException e) {
			System.out.println("Error " + e);
		} /* End catch. */
	}

	public void getFileName() {
		Scanner in = new Scanner(System.in);

		System.out.println("Enter file name please.");
		fname = in.nextLine();
		System.out.println("You entered " + fname);
	}

	public static void main(String[] args) {

		System.out.println("Hello TV land!");

		File f = new File();

		System.out.println("Bye-bye!");
	}
}
