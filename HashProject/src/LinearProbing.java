import java.util.Stack;

public class LinearProbing
{
    private int[] occupied;
    private int[] table;
    private int size;
    
    //stack to hold search list
    private Stack<Integer> searchList = new Stack<Integer>();
    
    //default constructor
    public LinearProbing(int size)
    {
    	occupied = new int[size]; //1 : occupied, 0 : unoccupied, 2: marked
        table = new int[size];
        this.size = size;
    }
    
    //hashing function
    public int hash(int n,int size, int i)
    {       
        return (n % size + i) % size;
    }
    
    //print the results of the search
    public int printSearchResults()
    {
    	//return the first value of stack
    	return searchList.get(0);
    }
    //clear search stack
    public void clearSearchStack()
    {
    	searchList.clear();
    }
    
    //find a value in the hash table recursively
    public void search(int key, int i)
    {
    	//get inital position from hash function
    	int pos = hash(key,size, i);
    	    	
    	//if the value is found 
    	if(table[pos] == key && occupied[pos] == 1)
    	{
    		//add true to first value of the stack
    		searchList.add(pos);
    	}
    	//if the method runs through all the values in the table
    	else if(occupied[pos] == 0)
    	{
    		//add false to first value of the stack
    		searchList.add(-1);
    	}
    	else
    	{
    		//recursively look through hash table
    		i = i + 1;
        	search(key, i);
    	}
    	
    	//if all else fails
    	searchList.add(-1);
    }

    //insert into table
    public void insert(int key, int i)
    {
        
      //get inital position from hash function
    	int pos = hash(key,size, i);
    	
    	//if the value is found 
    	if(occupied[pos]!=1)
    	{
    		//insert the value in table and mark as occupied
    		table[pos] = key;
    		occupied[pos] = 1;
    	}
    	else
    	{
    		//recursively look through hash table
    		i = i + 1;
        	insert(key, i);
    	}
    }

    //delete from table
    void delete(int key, int i)
    {      
    	
      //get inital position from hash function
    	int pos = hash(key,size, i);
    	
    	    	
    	//if the value is found 
    	if(table[pos] == key && occupied[pos] == 1)
    	{
    		//mark as 2 (lazy deletion)
    		occupied[pos] = 2;
    		return;
    	}
    	//if the method runs through all the values in the table
    	else if(occupied[pos] == 0)
    	{
    		//add false to first value of the stack
    		System.out.println("Deletion value not found");
    		return;
    	}
    	else
    	{
    		//recursively look through hash table
    		i = i + 1;
        	delete(key, i);
    	}
    }
    
    void display()
    {
    	//run through table and print value at each index
        for (int i = 0;i<size;i++)
        {
            if(occupied[i] == 1)
                System.out.println(i+": "+table[i]);
        }
    }
}