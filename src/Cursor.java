/*cursor class is an array of nodes*/
/* cursorAlloc() will give me a free node to use it*/
/*cursorFree(int p) will make the node of index p a free node that i can use it again*/
/*find(object x) will search for object x in the cursor*/



public class Cursor {


	public static Node cursor[]; // make an array of Nodes


	public Cursor(int size) {


		cursor = new  Node[size] ; //given size will be the length of the cursor


		for (int i = 0; i < cursor.length; i++) { //make new Nodes in all indices of the array
			cursor[i] =  new Node() ;
		}

		for (int i = 0; i < cursor.length; i++) { //make the next for each index is the next index
			cursor[i].next=i+1;
		}
		cursor[size-1].next=0;

	}


	public static int cursorAlloc() throws Exception { 

		int p = cursor[0].next;  //save the index of the first free node and replace the next free node with it
		cursor[0].next=cursor[p].next;
		cursor[p].next=0;

		if ( p == 0 )
			throw new Exception("memory is full ");//if the next index of free node is 0 then all the nodes are allocated

		return p;
	}

	public static void cursorFree(int p){

		cursor[p].element = null ;
		cursor[p].next = cursor[0].next;// put the node p next to the 0 node and make it empty
		cursor[0].next=p;

	}

	public static boolean isEmpty(int l){
		return(cursor[l].next==0); 
	}


	public static int find(Object x , int l){

		int p = cursor[l].next;
		while(p!=0 && !cursor[l].element.equals(x))
			p = cursor[p].next;
		return p;
	}




}
