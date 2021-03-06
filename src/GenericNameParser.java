import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class GenericNameParser {
	public String path;
	public File txt;
	public ArrayList<String> names = new ArrayList<String>();
	public static ArrayList<String> parsePhrases = new ArrayList<String>();
	/*
	 * Constructor for setting the path file for the txt file. 
	 */
	GenericNameParser(String path, String[] parseList) {
		txt = new File(path);
		parsePhrases = new ArrayList<String>(Arrays.asList(parseList));
	}
	
	/**
	 * This will open a scanner to get a line by line string of the txt file.
	 * It then parses each line into a String Array and adds each name to an ArrayList
	 * not including blank strings that may have occured from parsing.
	 * @throws FileNotFoundException
	 */
	public void startParse() throws FileNotFoundException {
		Scanner reader = new Scanner(txt);
		while (reader.hasNextLine()){
		   String tmp = reader.nextLine().trim();
		   for(String s: removeNonNames(tmp)) {
			   if(!s.trim().equals("")) {
				   names.add(s.trim());
			   }
		   }
		}
		reader.close();
	}
	
	/**
	 * This will parse out all given parse phrases and give back a String Array with all names.
	 * @param nameLine The raw line of names from the excel file. 
	 * @return A String Array with each name separated. 
	 */
	public static String[] removeNonNames(String nameLine) {
		for(String s: parsePhrases) {
			nameLine = nameLine.replaceAll(s, "");
		}
		nameLine = nameLine.replaceAll("\\d", "");
		nameLine = nameLine.replaceAll("#", "");
		nameLine = nameLine.replaceAll("\t", " ");
		nameLine = nameLine.replaceAll("  ", "\n").toLowerCase();
		return nameLine.split("\n");
	}
	
	public static void main(String[] args) throws FileNotFoundException {
		TxtParser names = new TxtParser(args[0]);
		names.startParse();
		System.out.println(names.names);
		System.out.println(names.names.size());
	}
}
