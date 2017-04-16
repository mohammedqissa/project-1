
public class RadixSort {



	static Lists[] lists = new Lists[127]; //127 list or bucket

	static Cursor cursor;
	
	private static int max = 0;
	
	public static void sort(String[] str) throws Exception{


		for (int i = 0; i < lists.length; i++) { //make new lists in all indices of array
			lists[i] = new Lists();
		}

		cursor = new Cursor(str.length + 1); //make cursor with nodes equal to the number of strings
		

		for (int i = 0; i < str.length; i++) { // to know the # of characters in longest string
			if(str[i].length() > max)
				max = str[i].length();
		}

		int i = max-1;
		char c = ' ';

		while(i >= 0){ // number of chars on longest string


			for (int j = 0; j < str.length; j++) {

				if(str[j].length() > i )
					c = str[j].charAt(i); 
				else
					c = ' ';
			
				String s = str[j];
				
				
				String h = ""+c;
				h=h.toLowerCase();
				c = h.charAt(0);
				
//				if(c >= 'a' && c <= 'z' )
//					lists[c-'a'].add(s);
//				if(c >= 'A' && c <= 'Z' )
//					lists[c-'Z'].add(s);
//				else
//					lists[53].add(s);
				
				lists[c].add(s); //add the node to its bucket 

			}

			int index =0;
			for (int j = 0; j < lists.length; j++) {
				while(lists[j].getCounter()>0){
					str[index] = (String)lists[j].getFirstElement();  //after read all string will return strings from lists to string array
					index++;
				}
			}
			i--;
		}


	}




}
