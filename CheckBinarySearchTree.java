package DataStructures;

public class CheckBinarySearchTree 
{
	static boolean isBST(Node root,int min,int max)
	{
		if(root.data<=min || root.data>=max)
		{
			return false;
		}
		else
		{
			return isBST(root.left,min,root.data) || isBST(root.right,root.data,max);
		}
	int a=Integer.ma
	}
	
	class Node
	{
		Node left;
		int data;
		Node right;
	}
}
