import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

public class FileWriter {
	
	public static void writeToFile(String fileName, String[] text) {
		try {
			PrintWriter writer = new PrintWriter(fileName, "UTF-8");
			for(String s : text) {
				writer.println(s);
			}
			writer.close();
		} catch (FileNotFoundException | UnsupportedEncodingException e) {
			e.printStackTrace();
		}
	}
}
