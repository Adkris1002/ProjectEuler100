import java.util.Scanner;

public class Tree {
	static class Node {    
	    int value; 
	        Node left, right; 
	          
	        Node(int value){ 
	            this.value = value; 
	            left = null; 
	            right = null; 
	        } 
	} 
	       
	public void insertTest(Node node, int value) {
        if (value < node.value) { 
        	if (node.left != null) { 
        		insertTest(node.left, value); 
        	} else { 
        		System.out.println("Inserted " + value + " to left of " + node.value); 
        		node.left = new Node(value); 
        	} 
        } else if (value > node.value) {
          if (node.right != null) {
            insertTest(node.right, value);
          } else {
            System.out.println("Inserted " + value + " to right of " + node.value);
            node.right = new Node(value);
          }
        }
    } 
	
	public void insert(Node node, String values) {
		if (node != null && node.left != null && node.right != null) {
			//System.out.println("Next Node");
			insert(node.left, values);

			Scanner input = new Scanner(values);
			input.next();
			values = "";
			while (input.hasNext()) {
				values += input.next() + " ";
			}
			//System.out.println(values);
			insert(node.right, values);
			input.close();
		} else if (node.left == null && node.right == null) {
			//System.out.println("No Children");
			Scanner input = new Scanner(values);
			if (input.hasNext()) {
				node.left = new Node(Integer.parseInt(input.next()));
			}
			if (input.hasNext()) {
				node.right = new Node(Integer.parseInt(input.next()));
			}
			input.close();
		}
    }
	
	public int traverseAndSum(Node node) {
		if (node != null && node.left != null && node.right != null) {
			traverseAndSum(node.left);
			traverseAndSum(node.right);
			if (node.left.value >= node.right.value) {
				node.value += node.left.value;
			} else {
				node.value += node.right.value;
			}
			return (node.value);
		}
		return 0;
	}
	
	 public void traverseInOrder(Node node) {
	    if (node != null) {
	    	if (node.left != null && node.right != null) {
		        System.out.println(node.value + " Parent of " + node.left.value + " and " + node.right.value);
	    	} else {
	    		System.out.println(node.value + " is at bottom");
	    	}
	        traverseInOrder(node.left);
	        traverseInOrder(node.right);
	    }
	 }
}
