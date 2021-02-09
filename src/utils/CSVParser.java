package utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CSVParser {
	private String fileName;

	public CSVParser(String fileName) {
		this.fileName = fileName;
	}

	public List<String[]> getTokens() {
		List<String[]> result = new ArrayList<>();
		FileReader fileReader;
		BufferedReader bufferedReader = null;
		String row;
		try {
			fileReader = new FileReader(new File(fileName));
			bufferedReader = new BufferedReader(fileReader);
			while ((row = bufferedReader.readLine()) != null) {
				String[] tokens = row.split(",");
				result.add(tokens);
			}
		} catch (IOException e1) {
			e1.printStackTrace();
		} finally {
			if (bufferedReader != null) {
				try {
					bufferedReader.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return result;
	}
}
