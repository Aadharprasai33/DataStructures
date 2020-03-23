import java.util.ArrayList;

public class HashClass {
int tableIndex;
int hashIndex;
String names;

public HashClass( int tableIndex, String names, int hashIndex){
	this.tableIndex = tableIndex;
	this.hashIndex = hashIndex;
	this.names = names;
}
public String toString() {
	return "HashTable " + tableIndex + " " + names + " " + hashIndex;
	
}
}

class HashClassApp{
	void makeTable(int tableIndex, String name, int index){
		ArrayList<HashClass> h = new ArrayList<HashClass>();
		h.add(new HashClass(tableIndex, name, index));
		System.out.println(h.toString());
	}
	
	
}

