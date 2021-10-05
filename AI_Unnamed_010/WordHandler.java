import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.DirectoryIteratorException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

public class WordHandler {
		
		public static void main(String[] inPut, String[] bank) throws FileNotFoundException {
			int i;
			int z;
			ArrayList<String> match = new ArrayList<String>();
			for(z=0; z<bank.length; z++){
				int acc=0;
				AI.prnt(bank[z]);
				for(i=0; i<inPut.length; i++){
					
					Scanner sc = new Scanner(new File("databanks/" + bank[z] + ".txt"));
					while(sc.hasNext()){
						String line = sc.nextLine();
						if(inPut[i].equals(line)){
						AI.prnt(" " + line);
						match.add(inPut[i]);
						acc = acc+1;
				 }
				}
				sc.close();
			}if (acc>=inPut.length){
				AI.prnt("Command is " + bank[z]);
				z = bank.length + 1;
				//AI.prnt(match.toString());
				
			}
			}
			if(z==bank.length){
				AI.prnt("Command not recognized, would you like to add/create commands?");
				String l = AI.input();
				l=l.toLowerCase();
				if(l.equals("yes")){
					databanks.NewWords(inPut, match);
				}
			}
			match.clear();
			
			
		}
		
		
		
		
		
		
		
		public static String get_data(){
			ArrayList<String> databanks = new ArrayList<String>();
			Path dir = Paths.get("databanks");
			try (DirectoryStream<Path> stream = Files.newDirectoryStream(dir)) {
			    for (Path file: stream) {
			        //System.out.println(file.getFileName());
			        databanks.add(file.getFileName().toString());
			        //System.out.println(databanks);
			    }
			} catch (IOException | DirectoryIteratorException x) {
			    // IOException can never be thrown by the iteration.
			    // In this snippet, it can only be thrown by newDirectoryStream.
			    System.err.println(x);
			}
			String A = databanks.toString();
			A = A.replace(".txt", "");
			//A = A.replace(",", "");
			A = A.replace("[", "");
			A = A.replace("]", "");
			return A;
			}
}
	

