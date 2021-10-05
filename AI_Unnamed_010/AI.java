import java.io.FileNotFoundException;
import java.util.Scanner;

public class AI {
	
	
	public static void prnt(String x) {
		System.out.println(x);
	}
	
	@SuppressWarnings("resource")
	public static String input(){
		
		Scanner scanner = new Scanner(System.in);
		String x = scanner.nextLine();
		
		//clean it up
		x = x.replaceAll("\\p{Punct}","");
		x = x.toLowerCase();
		
		return x;
	}
	
	public static void main(String[] args) throws FileNotFoundException {
		
		String x;
		NewFile.main(args);
		while(true){
		String a = WordHandler.get_data();
		String[] bank = a.split(", ");
		
		
		x = input();
		
		String[] inPut = x.split(" ");
		WordHandler.main(inPut, bank);
		}
	}
}