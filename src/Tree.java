package canadian_states_color_mapping_system;

import java.util.Random;

public class Tree {

	Node root;
	
	public Tree(int total_colors){
		
		//initializing states as nodes
		Node bc = new Node(3,total_colors);
		bc.Name = "BC";
		bc.id = 1;
		
		Node nb = new Node(3,total_colors);
		nb.Name = "NB";
		nb.id = 2;

		Node mb = new Node(3,total_colors);
		mb.Name = "MB";
		mb.id = 3;

		Node nl = new Node(1,total_colors);
		nl.Name = "NL";
		nl.id = 4;
		
		Node ab = new Node(3,total_colors);
		ab.Name = "AB";
		ab.id = 5;
		
		Node on = new Node(2,total_colors);
		on.Name = "ON";
		on.id = 6;
		
		Node nu = new Node(2,total_colors);
		nu.Name = "NU";
		nu.id = 7;
		
		Node nt = new Node(5,total_colors);
		nt.Name = "NT";
		nt.id = 8;
		
		Node ns = new Node(2,total_colors);
		ns.Name = "NS";
		ns.id = 9;
		
		Node pe = new Node(2,total_colors);
		pe.Name = "PE";
		pe.id = 10;
		
		Node qc = new Node(3,total_colors);
		qc.Name = "QC";
		qc.id = 11;
		
		Node sk = new Node(3,total_colors);
		sk.Name = "SK";
		sk.id = 12;
		
		Node yt = new Node(2,total_colors);
		yt.Name = "YT";
		yt.id = 13;
		
		////setting references. 
		//Taking PE island as node which is sharing water with NS and NB states
		//so color should not match
		bc.nextChild[0] = ab;
		bc.nextChild[1] = nt;
		bc.nextChild[2] = yt;
		
		nb.nextChild[0] = qc;
		nb.nextChild[1] = pe;
		nb.nextChild[2] = ns;
		
		mb.nextChild[0] = sk;
		mb.nextChild[1] = nu;
		mb.nextChild[2] = on;
		
		nl.nextChild[0] = qc;

		ab.nextChild[0] = bc;
		ab.nextChild[1] = sk;
		ab.nextChild[2] = nt;
		
		on.nextChild[0] = mb;
		on.nextChild[1] = qc;

		nu.nextChild[0] = mb;
		nu.nextChild[1] = nt;
		
		nt.nextChild[0] = nu;
		nt.nextChild[1] = ab;
		nt.nextChild[2] = bc;
		nt.nextChild[3] = yt;
		nt.nextChild[4] = sk;
		
		ns.nextChild[0] = nb;
		ns.nextChild[1] = pe;
		
		pe.nextChild[0] = ns;
		pe.nextChild[1] = nb;
		
		qc.nextChild[0] = on;
		qc.nextChild[1] = nl;
		qc.nextChild[2] = nb;
		
		sk.nextChild[0] = nt;
		sk.nextChild[1] = ab;
		sk.nextChild[2] = mb;
		
		yt.nextChild[0] = nt;
		yt.nextChild[1] = bc;
		
		
		//Random class instance to change root on each execution
        Random random = new Random();

        //Random number in the range of 1 to 14 (exclusive of 0)
        int randomNumber = random.nextInt(13) + 1;


        //setting root based on the random number
        switch (randomNumber) {
            case 1:
                root = bc;
                break;
            case 2:
                root = nb;
                break;
            case 3:
                root = mb;
                break;
            case 4:
                root = nl;
                break;
            case 5:
                root = ab;
                break;
            case 6:
                root = on;
                break;
            case 7:
                root = nu;
                break;
            case 8:
                root = nt;
                break;
            case 9:
                root = ns;
                break;
            case 10:
                root = pe;
                break;
            case 11:
                root = qc;
                break;
            case 12:
                root = sk;
                break;
            case 13:
                root = yt;
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + randomNumber);
        }
	}
}
