import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.*;

public class FizzBuzz {

	public static void main(String[] args) throws IOException, URISyntaxException {
		/** Starting number of the list */
		int kezd = 1;
		/** Final number of the list */
		int veg = 100;
		/** Chooses the printing format (stdout, HTML, JSON) */
		int printto = 2;
		ArrayList<String> szamsor = new ArrayList<String>();
		szamsor = fizzing(kezd, veg);
		switch(printto){
		case 1:
			for(int i = 0; i < szamsor.size(); i++){
				System.out.println(szamsor.get(i));
			}
		case 2:
			tofile(printhtml(szamsor).toString());
		/*case 3:
			tofile(printjson(szamsor));*/
		}
	}

	/** Writes the output into a file */
	private static void tofile(String fo) throws IOException, URISyntaxException {
		FileWriter fstream = new FileWriter("FizzBuzz.html");
	    BufferedWriter out = new BufferedWriter(fstream);
	    out.write(fo);
	    out.close();
		
	}

	/** Creates the HTML code */
	private static StringBuilder printhtml(ArrayList<String> szamsor) {
		StringBuilder fo = new StringBuilder();
	    fo.append("<html>");
	    fo.append("<head>");
	    fo.append("<title>FizzBuzz");
	    fo.append("</title>");
	    fo.append("</head>");
	    fo.append("<body>");
	    for(int i = 0; i < szamsor.size(); i++){
	    	fo.append(szamsor.get(i));
	    	fo.append("<br />");
	    }
	    fo.append("</body>");
	    fo.append("</html>");
	    return fo;
		
	}

	/** Makes a list, fizzes numbers divisible by 3, buzzes numbers divisible by 5 */
	private static ArrayList<String> fizzing(int kezd, int veg) {
		int j = 0;
		ArrayList<String> szamsor = new ArrayList<String>();
		for(int i = kezd; i <= veg; i++, j++){
			if(i % 3 == 0 && i % 5 == 0){
				szamsor.add(j, "FizzBuzz");
			}else if(i % 3 == 0){
				szamsor.add(j, "Fizz");
			}else if(i % 5 == 0){
				szamsor.add(j, "Buzz");
			}else{
				szamsor.add(j, String.valueOf(i));
			}
		}
		return szamsor;
	}
}
