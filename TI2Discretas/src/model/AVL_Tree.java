package model;

public class AVL_Tree {
	Node root;
	
	public void insert(Node node)
	{
		root=insertHelper(root, node);
	}
	private Node insertHelper(Node root, Node node)
	{
		
		if(root==null)
		{
			root=node;
			return root;
		}else if(root.data.compareTo(node.data)<0)
		{
			root.left=insertHelper(root.left, node);
		}else if(root.data.compareTo(node.data)>0)
		{
			root.right=insertHelper(root.right, node);
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
}
