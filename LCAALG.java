import java.util.ArrayList;
import java.util.List;

public class LCAALG {
	
	private static List<Integer> l1 = new ArrayList<Integer>();
	private static List<Integer> l2 = new ArrayList<Integer>();
	
	boolean findPath(Node root, int n, List<Integer> path ) {
		path.add(root.val);
		if(root.val== n) {
			return true;
		}
		System.out.println(root.val);
		
		
		if(root.left!=null && findPath(root.left,n,l1)) {
			System.out.println("done with reading left child");
			return true;
		}
		if(root.right!=null && findPath(root.right,n,l2)) {
			System.out.println("done with reading right child");
			return true;
		}
		System.out.println("Content of path: "+path);
		path.remove(path.size()-1);
		
		return false;
	}
	public static void main(String[] args) {
		
		LCAALG lca = new LCAALG();
		
		Node n = new Node(1);

		n.left = new Node(2);
		
		n.right = new Node(3);
		
		n.left.left = new Node(4);
		
		n.left.right = new Node(5);
		
		n.right.left = new Node(6);
		
		n.right.right = new Node(7);

		l1.clear();
		l2.clear();

		System.out.println(l1);
		System.out.println(l2);
		int i;
		boolean res;
		//keep adding to path 2
		do {
			res=lca.findPath(n,5,l2);
		}while(!res);

		System.out.println(l1);
		System.out.println(l2);

//		}
//		System.out.println("LCA is: "+l1.get(i-1));
		
	}

}
