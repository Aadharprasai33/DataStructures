import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

public class Main {
	String fname;

	public Main(){
		getFileName();
		readFileName();
	}
	
	
	public static void main(String[] args) {
		Main m = new Main();
		
		
		
	}
	public void readFileName() {
		HashClassApp h = new HashClassApp();
		boolean looping;
		DataInputStream in;
		String line;
		char a0,a1,a2;
		int hashIndex;
		try {
			in = new DataInputStream(new FileInputStream(fname));

			while ((line = in.readLine()) != null) {
				a0=line.charAt(0);
				a1=line.charAt(1);
				a2=line.charAt(2);
				hashIndex = (a0*26^2 + a1*26^1+ a2*26^0)/10 ;
				h.makeTable(hashIndex, line, hashIndex);
			}

			
			
		
		}

		catch (IOException e) {
			System.out.println("Error " + e);
		} 
	}

	
	public void getFileName() {
		Scanner in = new Scanner(System.in);

		System.out.println("Enter file name please.");
		fname = in.nextLine();
		System.out.println("You entered " + fname);
	}

	

}
