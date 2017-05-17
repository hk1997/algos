package algos;
import java.util.*;
public class RunningMedian 
{
	MaxHeap l;
	MinHeap r;
	public RunningMedian(int n) 
	{
		// TODO Auto-generated constructor stub
		l=new MaxHeap(n);
		r=new MinHeap(n);
	}
	class MinHeap 
	{
		int[] harr; //array to store elements of heap
		int capacity; //maximum capacity of array
		int heap_size; //number of elements currently in heap
		//constructor 
		public MinHeap(int cap) 
		{
			// TODO Auto-generated constructor stub
			this.capacity=cap;
			harr=new int[cap+1];
			heap_size=0;
		}
		
		 	int parent(int i) { return (i-1)/2; }
		 
		    // to get index of left child of node at index i
		    int left(int i) { return (2*i + 1); }
		 
		    // to get index of right child of node at index i
		    int right(int i) { return (2*i + 2); }
		    
		    //to extract minimum element,i.e, root from heap
		    int extractMin()
		    {
		    	if(heap_size<=0)
		    		return Integer.MAX_VALUE;
		    	else if(heap_size==1)
		    	{
		    		heap_size--;
		    		return harr[0];
		    	}
		    	else
		    	{
		    		int root=harr[0];
		    		harr[0]=harr[heap_size-1];
		    		heap_size--;
		    		MinHeapify(0);
		    		return root;
		    	}
		    }
		    // Decreases key value of key at index i to new_val
		    void decreaseKey(int i, int new_val)
		    {
		    	harr[i] = new_val;
		        while (i != 0 && harr[parent(i)] > harr[i])
		        {
		           swap(i, parent(i));
		           i = parent(i);
		        }

		    }
		    // Returns the minimum key (key at root) from min heap
		    int getMin() { return harr[0]; }
		 
		    // Deletes a key stored at index i
		    void deleteKey(int i)
		    {
		    	 decreaseKey(i, Integer.MIN_VALUE);
		    	    extractMin();
		    }
		    //to insert a new key
		    void insertKey(int k)
		    {
		        if (heap_size == capacity)
		        {
		            return;
		        }
		     
		        // First insert the new key at the end
		        heap_size++;
		        int i = heap_size - 1;
		        harr[i] = k;
		     
		        // Fix the min heap property if it is violated
		        while (i != 0 && harr[parent(i)] > harr[i])
		        {
		           swap(i, parent(i));
		           i = parent(i);
		        }
		    }
		    //to heapify a subtree with given root
		    void MinHeapify(int i)
		    {
		    	 int l = left(i);
		    	    int r = right(i);
		    	    int smallest = i;
		    	    if (l < heap_size && harr[l] < harr[i])
		    	        smallest = l;
		    	    if (r < heap_size && harr[r] < harr[smallest])
		    	        smallest = r;
		    	    if (smallest != i)
		    	    {
		    	        swap(i, smallest);
		    	        MinHeapify(smallest);
		    	    }
		    }
		    
		    //function to swap elements in array
		    void swap(int i,int j)
		    {
		    	int temp=harr[i];
		    	harr[i]=harr[j];
		    	harr[j]=temp;
		    }
		    
		  //get key
		    int  getKey(int element)
		    {
		    	int key=-1;
		    	for(int i=0;i<heap_size;i++)
		    	{
		    		if(harr[i]==element)
		    		{
		    			key=i;
		    			break;
		    		}
		    	}
		    	return key;
		    }
	}
	
	class MaxHeap 
	{
		int[] harr; //array to store elements of heap
		int capacity; //maximum capacity of array
		int heap_size; //number of elements currently in heap
		//constructor 
		public MaxHeap(int cap) 
		{
			// TODO Auto-generated constructor stub
			this.capacity=cap;
			harr=new int[cap+1];
			heap_size=0;
		}
		
		 	int parent(int i) { return (i-1)/2; }
		 
		    // to get index of left child of node at index i
		    int left(int i) { return (2*i + 1); }
		 
		    // to get index of right child of node at index i
		    int right(int i) { return (2*i + 2); }
		    
		    //to extract minimum element,i.e, root from heap
		    int extractMax()
		    {
		    	if(heap_size<=0)
		    		return Integer.MIN_VALUE;
		    	else if(heap_size==1)
		    	{
		    		heap_size--;
		    		return harr[0];
		    	}
		    	else
		    	{
		    		int root=harr[0];
		    		harr[0]=harr[heap_size-1];
		    		heap_size--;
		    		MaxHeapify(0);
		    		return root;
		    	}
		    }
		    // Decreases key value of key at index i to new_val
		    void decreaseKey(int i, int new_val)
		    {
		    	harr[i] = new_val;
		        while (i != 0 && harr[parent(i)] < harr[i])
		        {
		           swap(i, parent(i));
		           i = parent(i);
		        }

		    }
		    // Returns the minimum key (key at root) from min heap
		    int getMax() { return harr[0]; }
		 
		    // Deletes a key stored at index i
		    void deleteKey(int i)
		    {
		    	 decreaseKey(i, Integer.MAX_VALUE);
		    	    extractMax();
		    }
		    //to insert a new key
		    void insertKey(int k)
		    {
		        if (heap_size == capacity)
		        {
		            return;
		        }
		     
		        // First insert the new key at the end
		        heap_size++;
		        int i = heap_size - 1;
		        harr[i] = k;
		     
		        // Fix the min heap property if it is violated
		        while (i != 0 && harr[parent(i)] < harr[i])
		        {
		           swap(i, parent(i));
		           i = parent(i);
		        }
		    }
		    //to heapify a subtree with given root
		    void MaxHeapify(int i)
		    {
		    	 int l = left(i);
		    	    int r = right(i);
		    	    int smallest = i;
		    	    if (l < heap_size && harr[l] > harr[i])
		    	        smallest = l;
		    	    if (r < heap_size && harr[r] > harr[smallest])
		    	        smallest = r;
		    	    if (smallest != i)
		    	    {
		    	        swap(i, smallest);
		    	        MaxHeapify(smallest);
		    	    }
		    }
		    
		    //function to swap elements in array
		    void swap(int i,int j)
		    {
		    	int temp=harr[i];
		    	harr[i]=harr[j];
		    	harr[j]=temp;
		    }
		    
		  //get key
		    int  getKey(int element)
		    {
		    	int key=-1;
		    	for(int i=0;i<heap_size;i++)
		    	{
		    		if(harr[i]==element)
		    		{
		    			key=i;
		    			break;
		    		}
		    	}
		    	return key;
		    }
	}	    
	
	int Signum(int l,int r)
	{
		if(l==r) //both heaps are equal
			return 0;
		else if(l>r) //if leftheap contains more elements
			return -1;
		else //if rightHeap contains more elements
			return 1;
	}
	
	double getMedian(int e,double m)
	{
		int sig=Signum(l.heap_size,r.heap_size);
		switch(sig)
		{
		//left contains more elements
			case -1:
			//	System.out.println(-1);
				if(e<m)
				{
					r.insertKey(l.extractMax());
					l.insertKey(e);
				
				}
				else
				{
					r.insertKey(e);
				}
				m=(l.getMax()+r.getMin())/2.0;
				break;
				//both contains same number of elements
			case 0: 
				//System.out.println(0);
				if(e<m)
				{
					l.insertKey(e);
					m=l.getMax();
				}
				else
				{
					r.insertKey(e);
					m=r.getMin();
				}
				break;
				//RIGHT CONTAINS MORE ELEMENTS 
			case 1:	
			{
			//	System.out.println(1);
				if(e<m)
				{
					l.insertKey(e);
				}
				else
				{
					l.insertKey(r.extractMin());
					r.insertKey(e);
				}
				m=(l.getMax()+r.getMin())/2.0;
				break;
			}
			
		}
		return m;
	}
	
	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		Scanner hk=new Scanner(System.in);
		int n=hk.nextInt();
		
		RunningMedian o=new RunningMedian(n);
		double m=0;
		while(n--!=0)
		{
			int e=hk.nextInt();
			m=o.getMedian(e, m);
			
			System.out.println(m);
		}
	}

}
