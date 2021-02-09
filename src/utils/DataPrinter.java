package utils;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class DataPrinter {
	
	public void addLineToFile(String path, String output) {
		try {
			FileWriter fw = new FileWriter(new File(path), true);
			BufferedWriter bfw = new BufferedWriter(fw);
			bfw.write(output);
			bfw.close();
			fw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
