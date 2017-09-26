import java.util.Stack;

public class Traversals {

	public static void inorder(Node root) {	
		Stack<Node> stack = new Stack<Node>();
		Node node = root;

		while (node != null) {
			stack.push(node);
			node = node.left;
		}

		while (stack.size() > 0) {
			node = stack.pop();
			System.out.print(node.value + " ");

			if (node.right != null) {
				node = node.right;

				while (node != null) {
					stack.push(node);
					node = node.left;
				}
			}
		}
	}

	public static void preorder(Node root) {
		Stack<Node> stack = new Stack<Node>();
		stack.push(root);

		while (stack.size() > 0) {
			Node node = stack.peek();
			System.out.print(node.value + " ");
			stack.pop();

			if (node.right != null) {
				stack.push(node.right);
			}
			if (node.left != null) {
				stack.push(node.left);
			}
		}
	}

	public static void postorder(Node root) {
		Stack<Node> tempStack = new Stack<Node>();
		Stack<Node> stack = new Stack<Node>();
		tempStack.push(root);
		
		while (tempStack.size() > 0) {
			Node temp = tempStack.pop();
			stack.push(temp);
			if(temp.left != null){
				tempStack.push(temp.left);
			}
			if(temp.right != null){
				tempStack.push(temp.right);
			}
		}
		while(stack.size() > 0){
			System.out.print(stack.pop().value + " ");
		}			
	}
	
	public static void breadthFirstTraversal(Node root) {
		Queue<Node> queue = new LinkedList<Node>();
		queue.add(root);

		while (queue.size() > 0) {
			Node tempNode = queue.poll();
			System.out.print(tempNode.value + " ");

			if (tempNode.left != null) {
				queue.add(tempNode.left);
			}

			if (tempNode.right != null) {
				queue.add(tempNode.right);
			}
		}
	}

	public static void main(String[] args) {
		/*	Binary Tree:
		 				  60
		 				/    \
		 			  55      100
		 			 /  \     /  \
		 		   45    57  67   107
		 		  / \    /
		 		40  47  56
		 */
		
		Node root = new Node(60);
		root.left = new Node(55);
		root.right = new Node(100);
		root.left.left = new Node(45);
		root.left.right = new Node(57);
		root.right.left = new Node(67);
		root.right.right = new Node(107);
		root.left.right.left = new Node(56);
		root.left.left.right = new Node(47);
		root.left.left.left = new Node(40);

		System.out.print("Inorder: ");
		inorder(root);
		
		System.out.println();
		
		System.out.print("Preorder: ");
		preorder(root);
		
		System.out.println();
		
		System.out.print("Postorder: ");
		postorder(root);
		
		System.out.println();
		
		System.out.print("Breadth First: ");
		breadthFirstTraversal(root);		
	}
}

class Node {
	int value;
	Node left, right;

	public Node(int i) {
		value = i;
		left = right = null;
	}
}
