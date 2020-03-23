import java.io.DataInputStream;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

public class LinkedList {
	String fname;
	Scanner in = new Scanner(System.in);
	node n = new node();
	
	BabyLinkedList nm = new BabyLinkedList();

	public LinkedList() {
		System.out.println("Constructor");
		getFileName();
		readFileContentsNumber();
		if (fname.equals("file.txt")) {
			insertOrDelete();
		} else {
			insertOrDeleteName();
			

		}

	}

	public static void main(String[] args) {
		System.out.println("Hello TV land!");
		new LinkedList();
		System.out.println("Bye-bye!");

	}

	public void readFileContentsNumber() {
		Scanner fn = new Scanner(System.in);
		DataInputStream in;
		String line;
		int result = 0;

		nm.init();

		try {
			in = new DataInputStream(new FileInputStream(fname));
			if (fname.equals("file.txt")) {
				while ((line = in.readLine()) != null) {
					result = Integer.parseInt(line);

					nm.insert(result);
				}
				nm.showList();
			} else {
				while (((line = in.readLine()) != null)) {
					int value = nm.getCode(line);

					nm.insert(value, line);

				}

				nm.showListName();
				System.out.println("enter alphabet");
				String s = fn.next();
				char c = s.charAt(0);
				int inputAlphabet = c - 'a';
				
				nm.makeIndexList(inputAlphabet);
				nm.showListIndexed(inputAlphabet);

			}

		} catch (IOException e) {
			System.out.println("Error " + e);
		}

	}

	public void insertOrDelete() {
		System.out.println("insert or delete?");
		String s = in.nextLine();
		if (s.equals("insert")) {
			System.out.println("what do you wanna insert");
			int number = in.nextInt();
			n = nm.spotInList(number);
			nm.insert(number);
			nm.showList();
		}

		else if (s.equals("delete")) {
			System.out.println("what do you wanna delete");
			int number = in.nextInt();
			nm.delete(number);
			nm.showList();
		}
	}

	public void insertOrDeleteName() {
		System.out.println("insert or delete?");
		String s = in.nextLine();
		if (s.equals("insert")) {
			System.out.println("what do you wanna insert");
			String nameInsert = in.nextLine();
			int valueOfInsert = nm.getCode(nameInsert);

			n = nm.spotInListname(valueOfInsert);
			nm.insert(valueOfInsert, nameInsert);
			nm.showListName();
		}

		else if (s.equals("delete")) {
			System.out.println("what do you wanna delete");
			String nameDelete = in.nextLine();
			int valueOfDelete = nm.getCode(nameDelete);
			nm.delete(valueOfDelete);
			nm.showListName();
		}
	}

	public void getFileName() {
		System.out.println("Enter file name please.");
		fname = in.nextLine();

		System.out.println("You entered " + fname);
	}

}
