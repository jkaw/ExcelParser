import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Scanner;

public class FindIdiot {
	
	/**
	 * This class takes two TxtParsers and spits out the names that are in the first parameter, but not the second. 
	 * @param args 1st arg is the path for the first txt file of names. 2nd arg is the path for the txt file of all names to check.
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {
		TxtParser excelNames = new TxtParser(args[0]);
		TxtParser allNames = new TxtParser(args[1]);
		excelNames.startParse();
		allNames.startParse();
	    Collection<String> enames = excelNames.names;
	    Collection<String> cnames = allNames.names;
	    System.out.println(excelNames.names);
	    System.out.println(allNames.names);
	    List<String> n = new ArrayList<String>(cnames);
	    n.removeAll(enames);
	    System.out.println(n);
	  }
}
