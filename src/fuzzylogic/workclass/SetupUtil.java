package fuzzylogic.workclass;

import java.io.FileWriter;
import java.io.IOException;

public class SetupUtil {
	 static String[] GENERAL_RULE = new String[] {
		 "0,0,0,0","0,0,0,1","0,0,0,2","0,0,1,0","0,0,1,1","0,0,1,2","0,0,2,0","0,0,2,1","0,0,2,2","0,1,0,0","0,1,0,1","0,1,0,2","0,1,1,0","0,1,1,1","0,1,1,2","0,1,2,0","0,1,2,1","0,1,2,2","0,2,0,0","0,2,0,1","0,2,0,2","0,2,1,0","0,2,1,1","0,2,1,2","0,2,2,0","0,2,2,1","0,2,2,2","1,0,0,0","1,0,0,1","1,0,0,2","1,0,1,0","1,0,1,1","1,0,1,2","1,0,2,0","1,0,2,1","1,0,2,2","1,1,0,0","1,1,0,1","1,1,0,2","1,1,1,0","1,1,1,1","1,1,1,2","1,1,2,0","1,1,2,1","1,1,2,2","1,2,0,0","1,2,0,1","1,2,0,2","1,2,1,0","1,2,1,1","1,2,1,2","1,2,2,0","1,2,2,1","1,2,2,2","2,0,0,0","2,0,0,1","2,0,0,2","2,0,1,0","2,0,1,1","2,0,1,2","2,0,2,0","2,0,2,1","2,0,2,2","2,1,0,0","2,1,0,1","2,1,0,2","2,1,1,0","2,1,1,1","2,1,1,2","2,1,2,0","2,1,2,1","2,1,2,2","2,2,0,0","2,2,0,1","2,2,0,2","2,2,1,0","2,2,1,1","2,2,1,2","2,2,2,0","2,2,2,1","2,2,2,2"
	 	};
	 
	 public static Float getValueFromAttr(int no, int _case, float value ) {
		 float result = 0;
		 if ( no == 0 )
			 result =  SepalLength(_case, value);
		 else if ( no == 1 )
			 result =  SepalWidth(_case, value);
		 else if ( no == 2 )
			 result =  PetalLength(_case, value);
		 else if ( no == 3 )
			 result = PetalWidth(_case, value);
		 
		return result;	 
	 }
	 
	 
	 public static Float SepalWidth(int _case, float value) {
		 float result = 0;
		 switch(_case) {
		 	case 0:
		 		if (value <= 2)
		 			result = 1;
		 		else if ( (value >= 2) && (value <= 3.1) )
		 			result = (float) ((3.1 - value)/1.1);
		 		break;
		 	case 1:
		 		if ( (value >= 2) && (value <= 3.1) )
		 			result = (float) (( value - 2 )/1.1);
		 		else if ( (value >= 3.1) && (value <= 4.5) )
		 			result = (float) ((4.5 - value)/1.4);		 		
		 		break;
		 	case 2:
		 		if (value >= 4.5)
		 			result = 1;	
		 		else if ( (value >= 3.1) && (value <= 4.5) )
		 			result = (float) ((value - 3.1)/1.4);		 		
		 		break;
		 }
		 return result;
	 }
	 
	 public static Float SepalLength(int _case, float value) {
		 float result = 0;
		 switch(_case) {
		 	case 0:
		 		if (value <= 4.5)
		 			result = 1;
		 		else if ( (value >= 4.5) && (value <= 6) )
		 			result = (float) ((6 - value)/1.5);
		 		break;
		 	case 1:
		 		if ( (value >= 4.5) && (value <= 6) )
		 			result = (float) (( value - 4.5 )/1.5);
		 		else if ( (value >= 6) && (value <= 7.5) )
		 			result = (float) ((7.5 - value)/1.5);		 		
		 		break;
		 	case 2:
		 		if (value >= 7.5)
		 			result = 1;
		 		else if ( (value >= 6) && (value <= 7.5) )
		 			result = (float) ((value - 6)/1.5);		 		
		 		break;
		 }
		 return result;
	 }

	 public static Float PetalLength(int _case, float value) {
		 float result = 0;
		 switch(_case) {
		 	case 0:
		 		if (value <= 2)
		 			result = 1;
		 		else if ( (value >= 2) && (value <= 2.5) )
		 			result = (float) ((2.5 - value)/0.5);
		 		break;
		 	case 1:
		 		if ( (value >= 2) && (value <= 4.5) )
		 			result = (float) (( value - 2 )/2.5);
		 		else if ( (value >= 4.5) && (value <= 5.2) )
		 			result = (float) ((5.2 - value)/0.7);		 		
		 		break;
		 	case 2:
		 		if (value >= 5.2)
		 			result = 1;		
		 		else if ( (value >= 5.1) && (value <= 5.2) )
		 			result = (float) ((value - 5.1)/0.1);	 		
		 		break;
		 }
		 return result;
	 }
	 
	 
	 
	 public static Float PetalWidth(int _case, float value) {
		 float result = 0;
		 switch(_case) {
		 	case 0:
		 		if (value <= 0.5)
		 			result = 1;
		 		else if ( (value >= 0.5) && (value <= 1.2) )
		 			result = (float) ((1.2 - value)/0.7);
		 		break;
		 	case 1:
		 		if ( (value >= 0.5) && (value <= 1.2) )
		 			result = (float) ( ( value - 0.5 ) / 0.7 );
		 		else if ( (value >= 1.2) && (value <= 1.9) )
		 			result = (float) ( (1.9 - value) / 0.7 );		 		
		 		break;
		 	case 2:
		 		if (value >= 1.9)
		 			result = 1;	
		 		else if ( (value >= 1.2) && (value <= 1.9) )
		 			result = (float) ( (value - 1.2) / 0.7 );		 		
		 		break;
		 }
		 return result;
	 }
	 
	 
	 
	 /*
	 static void generateGeneralRule() throws IOException {
		 //  short, narrow: 0
	     //  medium: 1
	     //  long, wide: 2
			
			String filename = "/home/rimberry/Desktop/iris/entire_rule.txt";
			FileWriter fw = new FileWriter(filename, false);
			
			// có 4 thuộc tính x1, x2, x3, x4 :  dùng 4 vòng lặp
			int x1, x2, x3, x4;
			x1 = x2 = x3 = x4 = 0;
			int i = 1;
			for (x1 = 0; x1 <= 2; x1++)
				for (x2 = 0; x2 <= 2; x2++)
					for (x3 = 0; x3 <= 2; x3++)
						for (x4 = 0; x4 <= 2; x4++) {
							fw.write("\"" + x1 + "," + x2 + "," + x3 + "," + x4 + "\"," + "\n");
						}
			
			fw.close();
	 }*/
	 
}
