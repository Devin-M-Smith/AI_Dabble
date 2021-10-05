import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;

public class NewFile {
	
	public static void prnt(String x) {
		System.out.println(x);
	}
	
	public static void main(String[] args) {
		String[] Filename = {
			"Greetings", "Goodbyes", "Attack", "Shutdown"
		};
		String[] Keywords = {
				"hello", "goodbye", "attack", "shutdown"
		};
		try{
		for(int i = 0; i < Filename.length; i++){
			String a = ("databanks/" + Filename[i].toLowerCase());
			String content = Keywords[i];
			boolean dir = new File("databanks").mkdir();
			File file = new File(a + ".txt");
		
		
			if(!file.exists()){
				prnt("Creating new file: " + Filename[i] + ".txt");
				file.createNewFile();
			}
			
			FileWriter fw = new FileWriter(file.getAbsolutePath());
			BufferedWriter bw = new BufferedWriter(fw);
			
			bw.write(content);
			
			bw.close();
		}
		}catch(Exception e){
			System.out.println(e);
		}
	}

}
