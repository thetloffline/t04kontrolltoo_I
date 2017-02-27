import java.io.*;
import java.net.*;
public class HarmoonilineKeskmine_3 {

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
    } else {
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

public static void checkValues(String filePath) throws IOException, Exception {
    System.out.println("Checking values...");

    BufferedReader answerFile = askFile(filePath);
    if (answerFile == null) {
        return;
    }

   String answerLine = answerFile.readLine();
   float answer = Float.parseFloat(answerLine);
   if (Math.abs(answer - calculatingAverage(arrayFromFile("data.txt"))) < 0.000001) {
       throw new Exception("Answer is in file!");
   }
}

public static void saveToFile(String filepath, float answer) throws IOException, Exception {
    checkValues(filepath);

    System.out.printf("Save answer [%f] to file...\n", answer);
    StringBuffer sb = new StringBuffer();
    sb.append(answer);

    try {
        PrintWriter pw = new PrintWriter(new FileWriter(filepath));
        pw.println(sb);
        pw.close();
    } catch (Exception e) {}
}

public static void main(String[] args) {
    try {
        saveToFile("vastus.txt", calculatingAverage(arrayFromFile("data.txt")));
    } catch (Exception e) {
        System.out.println(e.getMessage());
    }
}
}