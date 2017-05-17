package DataStructures;

import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;


public class Dijkshtra {
	 LinkedList<Edge>[] l;
	 int nodes;
	 

	Dijkshtra(int n)
	{
		nodes=n;
		l=new LinkedList[n];
		for(int i=0;i<n;i++)
			l[i]=new LinkedList<Edge>();
	}
	void addEdge(int a,int b,int w)
	{
		l[a].add(new Edge(b,w));
	}
	
	int minNode(boolean[] state,int[] dist)
	{
		int flag=0;
		int min=0;
		int index=0;
		for(int i=0;i<nodes;i++)
		{
			if(!state[i])
			{
				if(flag==0)
					{
						min=dist[i];
						flag=1;
						index=i;
					}
				else if(min>dist[i])
				{
					min=dist[i];
					index=i;
				}
			}
		}
		if(flag==1)
			return index;
		else
			return -1; //all vertices are true
	}
	
	
	int[] dijkshtra(int s) //starting vertex
	{
		int[] dist=new int[nodes];
		boolean[] state=new boolean[nodes]; //@true=permanent node @false=temporary node
		Arrays.fill(state,false); //setting all vertices to temporary
		Arrays.fill(dist,(int) Math.pow(10, 9)); //setting all vertices to permanent
		dist[s]=0; //making source vertex distance zero
		int v=minNode(state,dist);
		while(v!=-1)
		{
			state[v]=true;
			Iterator<Edge> i=l[v].iterator();
			while(i.hasNext())
			{
				Edge e=i.next();
				if(!state[e.dest] && (dist[v]+e.weight)<dist[e.dest])
				{
					dist[e.dest]=dist[v]+e.weight;
				}
			}
			v=minNode(state,dist);
		}
		return dist;
	}
	
	class Edge
	 {
		 int dest; ///dest node
		 int weight;//weight  
		 Edge(int d,int w)
		 {
			 dest=d;
			 weight=w;
		 }
	 }
}	
