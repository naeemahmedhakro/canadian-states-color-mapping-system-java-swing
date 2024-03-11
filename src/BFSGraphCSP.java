package canadian_states_color_mapping_system;

import java.awt.Color;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BFSGraphCSP {

	HashMap<String, Color> visitedQueue;
	
    public BFSGraphCSP(List<String> mapColors, int total_colors) {
    	
        Node root;
        Node current;
        Tree graphTree = new Tree(total_colors);

        root = graphTree.root;

        Queue<Node> cspColoringQueue = new LinkedList<Node>();
        visitedQueue = new HashMap<String, Color>();

        cspColoringQueue.add(root);

        while (!cspColoringQueue.isEmpty()) {
            current = cspColoringQueue.poll();

            if (current != null && !visitedQueue.containsKey(current.Name)) {
            	if (current.colorbooleans[0]) { //if color 1
                    current.colorbooleans[1] = false; // color 2 false
                    current.colorbooleans[2] = false; // color 3 false
                    if(current.colorbooleans.length > 3){
                    	current.colorbooleans[3] = false; // color 4 false
                    }
                    
                    for (int n = 0; n < current.nextChild.length; n++) {
                        if (current.nextChild[n] != null) {
                            current.nextChild[n].colorbooleans[0] = false; //color 1 is false for connected nodes
                            cspColoringQueue.add(current.nextChild[n]);
                        }
                    }

                    if(mapColors.get(0).equalsIgnoreCase("Red")){
                    	visitedQueue.put(current.Name, Color.RED); 
                    }
                    if(mapColors.get(0).equalsIgnoreCase("Yellow")){
                    	visitedQueue.put(current.Name, Color.YELLOW); 
                    }
                    if(mapColors.get(0).equalsIgnoreCase("Green")){
                    	visitedQueue.put(current.Name, Color.GREEN);
                    }
                    if(mapColors.get(0).equalsIgnoreCase("Blue")){
                    	visitedQueue.put(current.Name, Color.BLUE); 
                    }
                    
                } else if (current.colorbooleans[1]) { //if color 2
                    current.colorbooleans[2] = false; // color 3 false
                    if(current.colorbooleans.length > 3){
                    	current.colorbooleans[3] = false; // color 4 false
                    }

                    for (int n = 0; n < current.nextChild.length; n++) {
                        if (current.nextChild[n] != null) {
                            current.nextChild[n].colorbooleans[1] = false; //color 2 is false for connected nodes
                            cspColoringQueue.add(current.nextChild[n]);
                        }
                    }

                    if(mapColors.get(1).equalsIgnoreCase("Red")){
                    	visitedQueue.put(current.Name, Color.RED); 
                    }
                    if(mapColors.get(1).equalsIgnoreCase("Yellow")){
                    	visitedQueue.put(current.Name, Color.YELLOW);
                    }
                    if(mapColors.get(1).equalsIgnoreCase("Green")){
                    	visitedQueue.put(current.Name, Color.GREEN); 
                    }
                    if(mapColors.get(1).equalsIgnoreCase("Blue")){
                    	visitedQueue.put(current.Name, Color.BLUE);
                    }
                } else if (current.colorbooleans[2]) { //if color 3
                	if(current.colorbooleans.length > 3){
                    	current.colorbooleans[3] = false; // color 4 false
                    }
                    for (int n = 0; n < current.nextChild.length; n++) {
                        if (current.nextChild[n] != null) {
                            current.nextChild[n].colorbooleans[2] = false; //color 3 is false for connected nodes
                            cspColoringQueue.add(current.nextChild[n]);
                        }
                    }

                    if(mapColors.get(2).equalsIgnoreCase("Red")){
                    	visitedQueue.put(current.Name, Color.RED); 
                    }
                    if(mapColors.get(2).equalsIgnoreCase("Yellow")){
                    	visitedQueue.put(current.Name, Color.YELLOW); 
                    }
                    if(mapColors.get(2).equalsIgnoreCase("Green")){
                    	visitedQueue.put(current.Name, Color.GREEN); 
                    }
                    if(mapColors.get(2).equalsIgnoreCase("Blue")){
                    	visitedQueue.put(current.Name, Color.BLUE);
                    }
                }
                else if (current.colorbooleans.length > 3 && current.colorbooleans[3]) { //if color 4
                    for (int n = 0; n < current.nextChild.length; n++) {
                        if (current.nextChild[n] != null) {
                            current.nextChild[n].colorbooleans[3] = false; //color 4 is false for connected nodes
                            cspColoringQueue.add(current.nextChild[n]);
                        }
                    }

                    if(mapColors.get(2).equalsIgnoreCase("Red")){
                    	visitedQueue.put(current.Name, Color.RED); 
                    }
                    if(mapColors.get(2).equalsIgnoreCase("Yellow")){
                    	visitedQueue.put(current.Name, Color.YELLOW); 
                    }
                    if(mapColors.get(2).equalsIgnoreCase("Green")){
                    	visitedQueue.put(current.Name, Color.GREEN); 
                    }
                    if(mapColors.get(2).equalsIgnoreCase("Blue")){
                    	visitedQueue.put(current.Name, Color.BLUE);
                    }
                }
            }
        }
    }
}

