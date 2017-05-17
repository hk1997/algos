package DataStructures;

import java.util.Arrays;
import java.util.Scanner;


public class KruskalAlgo 
{
	static Scanner hk=new Scanner(System.in);
	class Edge implements Comparable<Edge> 
	{
		int source,dest,weight;
		
		Edge(int a,int b,int w)
		{
			source=a;
			dest=b;
			weight=w;
		}
		
		public int compareTo(Edge e)
		{
			return this.weight-e.weight;
		}
	}
	int v,e; //no of vertices and edges
	Edge[] E;//array of edges
	KruskalAlgo(int v,int e)
	{
		//this ctor initializes the edges and sorts them
		this.v=v;
		this.e=e;
		E=new Edge[e];
		for(int i=0;i<e;i++)
		{
			int a=hk.nextInt();
			int b=hk.nextInt();
			int w=hk.nextInt();
			E[i]=new Edge(a-1,b-1,w);  //initializing edges
		}
		Arrays.sort(E); //sorting edges
	
	}
	//functions of UNION Find Algo
	int find(SubSet[] p,int i)
	{
		if(p[i].parent==i)
			return i;
		else
			return find(p,p[i].parent);
	}
	
	void Union(SubSet[] p,int v1,int v2)
	{
		int x=find(p,v1);
		int y=find(p,v2);
		if(p[x].rank<p[y].rank)
			p[x].parent=y;
		else if(p[y].rank<p[x].rank)
			p[y].parent=x;
		else
		{
			p[x].parent=y;
			p[y].rank++;
		}
		
	}
	
	
	
	
	class SubSet
	{
		int parent,rank;
	}
	
	int Kruskal()    //return weight of MST
	{
		Edge[] result=new Edge[v-1]; //contains edges of MST
		SubSet[] s=new SubSet[v];
	
	
		for(int i=0;i<v;i++)
		{
			s[i]=new SubSet();
			s[i].parent=i;
			s[i].rank=0;
		}
		int count=0;
		for(int i=0;i<e;i++)
		{
			int x=find(s,E[i].source);
			int y=find(s,E[i].dest);
			if(x!=y) //disjoint sets
			{
				result[count]=E[i];
				count++;
				Union(s,x,y);
			}
		}
		int weight=0;
		for(int i=0;i<v-1;i++)
		weight+=result[i].weight;
		
		return weight;
	}

	public static void main


}
