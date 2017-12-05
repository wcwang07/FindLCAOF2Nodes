import java.util.ArrayList;
import java.util.List;

public class LCAALG {
	
	private List<Integer> l1 = new ArrayList<Integer>();
	private List<Integer> l2 = new ArrayList<Integer>();
	
	boolean findPath(Node root, int n, List<Integer> path) {
		

		System.out.println("adding: "+root.val);
//		//add to the traversed list
		path.add(root.val);
		System.out.println("after adding: "+path);
		//exit from findPath if match
		if(root.val==n) {
			return true;
		}
		
		//recusively look into the left child
		if(root.left!=null && findPath(root.left,n,path)) {
			return true;
		}
		//recursively look into right child
		if(root.right!=null && findPath(root.right,n,path)) {
			return true;
		}
		System.out.println("current content: "+path);
		System.out.println("will remove "+path.get(path.size()-1));
		path.remove(path.size()-1);
		System.out.println("after removal: "+path);
		
		return false;
	}
	int findLCA(Node root, int n1, int n2) {
		l1.clear();
		l2.clear();
		
		
		//use findLCAInternal function to find path path for each node
		return findLCAForNodes(root, n1, n2);
		
	}
	int findLCAForNodes(Node root, int n1, int n2) {
		boolean res;
		//keep adding to path 1
		do {
			res=findPath(root,n1,l1);
		}while(!res);
		
		//keep adding to path 2
		do {
			res=findPath(root,n2,l2);
		}while(!res);

		int i;
		//break out if path differs
		for(i=0;i<l1.size()&&i<l2.size();i++) {
			System.out.print("at index "+i+"="+l1.get(i)+" "+l2.get(i));
			if(l1.get(i)!=l2.get(i)) {
				break;
			}
		}
		
		return l1.get(i-1);
		
	}
	public static void main(String[] args) {
		LCAALG lcaalg = new LCAALG();
		
		Node n = new Node(1);

		n.left = new Node(2);
		
		n.right = new Node(3);
		
		n.left.left = new Node(4);
		
		n.left.right = new Node(5);
		
		n.right.left = new Node(6);
		
		n.right.right = new Node(7);
		
		System.out.println("LCA(6,7):" + lcaalg.findLCA(n, 6,7));
		
	}
	
	
}
