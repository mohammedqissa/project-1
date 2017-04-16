/*list class is a class that will have the index of first node and call it header*/
/* method add(Object) is a method that will get a node from cursor and put the element in it and connect the node to list */
/*method getCounter() will return the number of nodes connected on the list*/
/*method getFirstElement() will return the element of the first node and delete that node*/


public class Lists {


	int header;
	int counter = 0;
	int last,previus;





	public void add(Object s) throws Exception{

		int tmp = Cursor.cursorAlloc(); // cursorAlloc() will give me the index of a free node from cursor

		if(counter == 0)
			header = tmp; // if the list is empty ,just put the header on its index ,else do the same but connect it to the previous node

		if(counter != 0)
			Cursor.cursor[last].next=tmp;

		Cursor.cursor[tmp].element = s;

		counter++;

		last=tmp;



	}

	public int getCounter(){
		return this .counter;
	}



	public  void delete(){

		//free the first node and make the next as header of the list
		int temp = Cursor.cursor[header].next;

		Cursor.cursorFree(header);
		header = temp;
		counter--;


	}

	public Object getFirstElement(){

		//return the element from first node and delete the first node
		Object o = Cursor.cursor[header].element;
		delete();
		return o;




	}



}
