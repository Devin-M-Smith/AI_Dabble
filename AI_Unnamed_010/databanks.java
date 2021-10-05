import java.io.BufferedWriter;

import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;


public class databanks {
	
	public static void NewWords(String[] inPut, ArrayList<String> match){
		AI.prnt("To which databank should the words be added?");
		String in = AI.input();
		in = in.toLowerCase();
		ArrayList<String> InPut = new ArrayList<String>(Arrays.asList(inPut));
		//prnt(InPut.toString());
		main(in, InPut);
	}

	public static void main(String in, ArrayList<String> InPut) throws IndexOutOfBoundsException{
		try{
			//String content = "This is the content to write into create file";
			in = "databanks/" + in + ".txt";
			File file = new File(in);
			
			
				if(!file.exists()){
					file.createNewFile();
					AI.prnt("Creating new databank " + file);
				}
				AI.prnt(InPut.toString());
				ArrayList<String> temp = new ArrayList<String>();
				for(int i = 0; i<InPut.size(); i++){
					Scanner sc = new Scanner(new File(in));
					while(sc.hasNext()){
						String line = sc.nextLine();
						if(InPut.get(i).toString().equals(line)){
							temp.add(InPut.get(i));
							//AI.prnt(InPut.get(i).toString());
						}
					}sc.close();
				}InPut.removeAll(temp);
				
				BufferedWriter output;
				output = new BufferedWriter(new FileWriter(in, true));
				for(int i=0; i<InPut.size(); i++){	
					
					output.newLine();
					output.write(InPut.get(i));
					
				}
				output.close();
				
		}catch(Exception e){
			System.out.println(e);
		}

	}

}
