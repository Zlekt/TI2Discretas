package model;

public class Node {
	Person data;
	Node right;
	Node left;
	
	int height;
	
	public Node(Person data)
	{
		this.data=data;
	}
	
	public String toString()
	{
		String out="";
		out=data.toString();
		return out;
	}
}
