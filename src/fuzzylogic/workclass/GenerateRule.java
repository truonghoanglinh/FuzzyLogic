package fuzzylogic.workclass;

import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class GenerateRule {
	private static Map<Integer, String> myMap;
	private static String urlInput = "/home/rimberry/Desktop/iris/Iris/data_training.txt";
	private static String urlOutput = "/home/rimberry/Desktop/iris/result.txt";
	private static Integer []arrSort;
	public static void main(String [] args) throws IOException {
		
		//initial Map<int, String>
		//int = idRule
		//String = "value,label"
		myMap = new HashMap<Integer, String>();
		for (int i = 0; i <= 80; i++) {
			myMap.put(i, null);
		}
		
		GenerateRule.readFromFile(urlInput);
		arrSort = new Integer[81];
		

		FileWriter fw = new FileWriter(GenerateRule.urlOutput, false);
		int count = 0;
		for (int i = 0; i < 81; i++) {
			String s = myMap.get(i);
			if (s == null) continue;
			arrSort[count] = i;
		
			count ++;
		}
		
		//Sort
		arrSort = GenerateRule.sortResult(count, arrSort);
		int number = 0;
		for (int i = (count-1) ; i > 0 ; i--) {
			if (number > 24) break;
			else number++;
			int j = arrSort[i];
			
			String[] rule = SetupUtil.GENERAL_RULE[j].split(",");
			fw.write( String.valueOf((Integer.valueOf(rule[0]) + 1)) );
			fw.write( String.valueOf((Integer.valueOf(rule[1]) + 1)) );
			fw.write( String.valueOf((Integer.valueOf(rule[2]) + 1)) );
			fw.write( String.valueOf((Integer.valueOf(rule[3]) + 1)) );

			
			fw.write(" " + myMap.get(j).split(",")[1] + " " + myMap.get(j).split(",")[0] + "\n");

		}
		
		fw.close();
	}
	
	private static void readFromFile(String url) {
		try {
			//create a thread to connect your file
			FileInputStream is=new FileInputStream(url);
			//Use Scanner method
			Scanner input=new Scanner(is,"UTF-8");
			
			while(input.hasNextLine()) {
					//read next line
					String line=input.nextLine();
					GenerateRule.analyzeInput(line);
			}
			//close thread
			is.close();
			input.close();
			} catch (IOException e) {
			e.printStackTrace();
			}
	}
	
	private static void analyzeInput(String input) {
		String []arrInput = input.split(" ");
		Float x0, x1, x2, x3;
		String label = null;
		x0 = Float.parseFloat(arrInput[0]);
		x1 = Float.parseFloat(arrInput[1]);
		x2 = Float.parseFloat(arrInput[2]);
		x3 = Float.parseFloat(arrInput[3]);
		label = arrInput[4];
		GenerateRule.calProbability(x0, x1, x2, x3, label);
	}
	
	private static void calProbability(float x0, float x1, float x2, float x3, String label) {
		 for (int i = 0; i < 81; i++) {
			 String []arrRule = SetupUtil.GENERAL_RULE[i].split(",");
			 Float temp_a = SetupUtil.getValueFromAttr(0, Integer.parseInt(arrRule[0]), x0);
			 Float temp_b = SetupUtil.getValueFromAttr(1, Integer.parseInt(arrRule[1]), x1);
			 Float temp_c = SetupUtil.getValueFromAttr(2, Integer.parseInt(arrRule[2]), x2);
			 Float temp_d = SetupUtil.getValueFromAttr(3, Integer.parseInt(arrRule[3]), x3);
			 
			 if ( temp_a == 0 || temp_b == 0 || temp_c == 0 || temp_d == 0 )
				 continue;
			  Float multi = temp_a * temp_b * temp_c * temp_d;
			  		  
			  pushIntoMap(i, multi, label);
		 }
	 }
	 
	private static void pushIntoMap(int i, Float multi, String label) {
		String temp = multi + "," + label;
		
		String s = GenerateRule.myMap.get(i);

		if ( s == null ) {
			GenerateRule.myMap.put(i, temp);
		} else {
			if ( Float.parseFloat(s.split(",")[0]) < multi ) 
				GenerateRule.myMap.put(i, temp);
		}
	}
	
	
	private static Integer[] sortResult(int count, Integer[] arrSort) {
		for (int i = count; i >= 1; i--) {
			for (int j = 0; j < (i - 1); j++) {
				String s1 = GenerateRule.myMap.get(arrSort[j]);
				float f1 = Float.parseFloat( s1.split(",")[0] );
				String s2 = GenerateRule.myMap.get(arrSort[j+1]);
				float f2 = Float.parseFloat( s2.split(",")[0] );
				if ( f1 > f2 ) {
					int temp = arrSort[j];
					arrSort[j] = arrSort[j+1];
					arrSort[j+1] = temp;
				}
			}
		}
		return arrSort;
	}
	
}
