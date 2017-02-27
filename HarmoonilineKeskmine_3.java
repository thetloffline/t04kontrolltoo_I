import java.io.*;
import java.net.*;
public class HarmoonilineKeskmine_3{
	
	public static float[] kiirused;
	public static String fileLocation;
	public static float[] arrayFromFile;

	public static float jadaSumma(float[] input) {
		float summa = 0;
		for(float a : input){
			summa += 1 / a;
		}
		return summa;
	}

	public static float calculatingAverage(float[] input) {
		return input.length / jadaSumma(input);		
	}

	static BufferedReader askFile(String fileLocation) {
	  try {
		if (fileLocation.startsWith("http://")) {
			return new BufferedReader(new InputStreamReader(
			   new URL(fileLocation).openConnection().getInputStream()));
		}
		else {
			return new BufferedReader(new FileReader(fileLocation));
		}
	  } catch (Exception ex) {		  
		  return null;
	  }
	}



	public static float[] arrayFromFile(String filePath) throws IOException {
		BufferedReader array = askFile(filePath);
		String line = array.readLine();
		String[] helper = line.split(",");
		float[] outputArray = new float[helper.length];
		for (int i = 0; i < helper.length; i++) {
			outputArray[i] = Float.parseFloat(helper[i]);
		}
		return outputArray;
	}

	public static void checkValues(String filePath) throws IOException {
	//	Kontrolli, kas vastus on juba olemas. hetkel ei tööta..
		BufferedReader answerFile = askFile(filePath);
		String answerLine = answerFile.readLine();
		float answer = Float.parseFloat(answerLine);
		if (answer != calculatingAverage(arrayFromFile("data.txt"))) {
			saveToFile("vastus.txt", calculatingAverage(arrayFromFile("data.txt")));
		}
		
	}

	public static void saveToFile(String filepath, float answer) throws IOException {
		StringBuffer sb = new StringBuffer();
			sb.append(answer);
		try {
			PrintWriter pw = new PrintWriter(new FileWriter(filepath));
			pw.println(sb);
			pw.close();
		} catch (Exception e) {

		}
	}

	public static void main(String[] args) throws IOException {
		saveToFile("vastus.txt", calculatingAverage(arrayFromFile("data.txt")));
		
	}

}