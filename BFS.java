package DataStructures;
import java.util.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

public class BFS 
{
	boolean state[];
	int[] d; //to calculate distance
	int[] predecessor; //to find predecessor
	Graph g;
	
	BFS(int n)
	{
		 g=new Graph(n);
	}
	
	class Edge
	{
		int source;
		int dest;
		int weight;
		Edge(int s,int d,int w)
		{
			source=s;
			dest=d;
			weight=w;
		}
	}
	
	class Graph
	{
		private int V;   // No. of vertices
	 // Array  of lists for Adjacency List Representation
	    private LinkedList<Integer> adj[];
	 
	    // Constructor
	    Graph(int v)
	    {
	        V = v;
	        adj = new LinkedList[v];
	        for (int i=0; i<v; ++i)
	            adj[i] = new LinkedList();
	        state=new boolean[v];
	        d=new int[v];
	        predecessor=new int[v];
	       
	    }
	 
	    //Function to add an edge into the graph
	    void addEdge(int v, int w)
	    {
	        adj[v].add(w);  // Add w to v's list.
	    }

	}; //end of class graph
	
	class Queue
	{
		private	ArrayList<Integer> q;
		
		
		Queue() //default ctor
		{
			q=new ArrayList<Integer>();
		}
		
		Queue(int n) //parameterised ctor
		{
			q=new ArrayList<Integer>(n);
		}
		
		void queue(int o)
		{
			q.add(o);
		}
		
		int dequeue()
		{
			if(q.size()==0)
				return -1;
			else
			{
				 int o=q.get(0);
				 q.remove(0);
				 return o;
			}
		}	
		
		boolean isEmpty()
		{
			if(q.size()==0)
				return true;
			else
				return false;
			
		}
		
	}
	
	int[] bfs(Graph g,int v)
	{
		Arrays.fill(state, false); //initializing state array
		Arrays.fill(d, 1000000000);
		Arrays.fill(predecessor,-1);
		Queue q=new Queue();
		q.queue(v);
		d[v]=0;
	
		while(!q.isEmpty())
		{
			int n=q.dequeue();
			state[n]=true;
			Iterator<Integer> i=g.adj[n].iterator();
			while(i.hasNext())
			{
				int n0=i.next();
				if(!state[n0])
				{
					q.queue(n0);
					state[n0]=true;
					d[n0]=d[n]+1;
					predecessor[n0]=n;
				}
			}
		}
		
		return d;
				
		
	}
	
	
	
	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		Scanner hk=new Scanner(System.in);
		int t=hk.nextInt();
		for(int p=1;p<=t;p++)
		{
			int n=hk.nextInt();
			BFS o=new BFS(n);
			int m=hk.nextInt();
			for(int i=0;i<m;i++)
			{
				int a=hk.nextInt();
				int b=hk.nextInt();
				o.g.addEdge(a-1, b-1);
		//		o.g.addEdge(b-1, a-1);
			}
			int start=hk.nextInt();
			int[] ans=o.bfs(o.g, start-1);
			for(int i=0;i<n;i++)
				if(i!=start-1)
				if(ans[i]==1000000000)
					System.out.print(-1+" ");
				else
					System.out.print(6*ans[i]+" ");
			
			System.out.println();
		}
	}

}
