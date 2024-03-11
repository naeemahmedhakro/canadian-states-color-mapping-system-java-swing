package canadian_states_color_mapping_system;

public class Node {

	int id;
	String Name;
	Node[] nextChild;
	boolean[] colorbooleans;
	
	Node(){
		
	}
	
	public Node(int no_of_childs,int size_of_boolean_array){
		nextChild = new Node[no_of_childs];
		this.colorbooleans = new boolean[size_of_boolean_array];
		
		for(int n=0;n<size_of_boolean_array; n++){
			colorbooleans[n] = true;
		}
		
		for(int i=0; i<no_of_childs; i++){
			nextChild[i] = new Node();
		}
	}
}
