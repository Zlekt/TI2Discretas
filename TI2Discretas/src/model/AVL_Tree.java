package model;

public class AVL_Tree {
	Node root;
	/*
	 * el método insertHelper realiza la inserción como si fuese un árbol ABB normal. 
	 * el método insert2 se ocupa de realizar la inserción ABB. Al terminar, recalcula la altura de la raíz y rebalancea.
	 * el método insert es el método público que llaman las otras clases que hagan uso del árbol.
	 */
	public void insert(Person per)
	{
		Node node=new Node(per);
		root=insert2(root, node.data);
	}
	
	private Node insert2(Node root, Person per)
	{
		root=insertHelper(root, per);
		
		calculateHeight(root);
		
		return balance(root);
	}
	
	private Node insertHelper(Node root, Person per)
	{
		Node node=new Node(per);
		
		if(root==null)
		{
			root=node;
			root.height=1;
			return root;
		}else if(root.data.compareTo(node.data)<0)
		{
			root.left=insertHelper(root.left, node.data);
		}else if(root.data.compareTo(node.data)>0)
		{
			root.right=insertHelper(root.right, node.data);
		}
		
		return root;
	}
	
	public void show()
	{
		showHelper(root);
	}
	
	private void showHelper(Node root)
	{
		if(root!=null)
		{
			showHelper(root.left);
			System.out.println(root.toString());
			showHelper(root.right);
		}
	}
	
	public boolean search(Person data)
	{
		return searchHelper(root, data);
	}
	
	private boolean searchHelper(Node root, Person input)
	{
		if(root==null)
		{
			return false;
		}
		else if(root.data.equals(input))
		{
			return true;
		}
		else if(input.compareTo(root.data)<0)
		{
			return searchHelper(root.left, input);
		}
		else
		{
			return searchHelper(root.right, input);
		}
	}
	
	public void remove(Person input)
	{
		if(search(input))
		{
			removeHelper(root, input);
			
			calculateHeight(root);
			
			balance(root);
		}else
		{
			System.out.println(input.toString()+ " no ha sido encontrado");
		}
	}
	
	private Node removeHelper(Node root, Person input)
	{
		if(root==null)
		{
			return root;
		}
		else if(input.compareTo(root.data)<0)
		{
			root.left=removeHelper(root.left, input);
		}
		else if(input.compareTo(root.data)>0)
		{
			root.right=removeHelper(root.right, input);
		}
		else //encuentra el elemento
		{
			if(root.left == null && root.right==null)
			{
				root=null;
			}
			else if(root.right!=null)
			{
				root.data=successor(root);
				root.right=removeHelper(root.right, root.data);
			}
			else   
			{
				root.data=predecessor(root);
				root.left=removeHelper(root.left, root.data);
			}
		}
		return root;
	}
	
	private Person successor(Node root)
	{
		root=root.right;
		while(root.left!=null)
		{
			root=root.left;
		}
		return root.data;
	}
	private Person predecessor(Node root)
	{
		root=root.left;
		while(root.right!=null)
		{
			root=root.right;
		}
		return root.data;
	}
	
	private int height(Node node)
	{
		if(node!=null)
		{
			return node.height;
		}
		else
		{
			return -1;
		}
	}
	
	private void calculateHeight(Node node)
	{
		if(node.left!=null && node.right!=null)
		{
			int left=node.left.height;
			int right=node.right.height;
			if(left>right)
			{
				node.height=left;
			}
			else
			{
				node.height=right;
			}
		}
	}
	
	private int balanceFactor(Node node) {
		int bf=height(node.right)-height(node.left);
		return bf;
	}
	
	private Node leftRotation(Node node) 
	{
		Node rightInter=node.right;
		node.right=rightInter.left;
		rightInter.left=node;
		calculateHeight(node);
		calculateHeight(rightInter);
		
		return rightInter;
	}
	
	private Node rightRotation(Node node)
	{
		Node leftInter=node.left;
		node.left=leftInter.right;
		leftInter.right=node;
		
		calculateHeight(node);
		calculateHeight(leftInter);
		return leftInter;
	}
	
	private Node balance(Node node)
	{
		int bf=balanceFactor(node);
		
		if(bf<-1)
		{
			if(balanceFactor(node.left)<=0)
			{
				node=rightRotation(node);
				System.out.println("right rotation" + node.toString());
			}
			else
			{
				node.left=leftRotation(node.left);
				node=rightRotation(node);
				System.out.println("left then right rotation" + node.toString());
			}
		}
		
		if(bf>1)
		{
			if(balanceFactor(node.right)>=0)
			{
				node=leftRotation(node);
				System.out.println("left rotation " + node.toString());
			}
			else
			{
				node.right=rightRotation(node.right);
				node=leftRotation(node);
				System.out.println("right, then left rotation" + node.toString());
			}
		}
		
		return node;
	}
}
