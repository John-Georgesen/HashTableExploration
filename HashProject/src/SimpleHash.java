import java.util.LinkedList;

public class SimpleHash
{    
    private boolean[] occupied;
    private int[] table;
    private int size;
    
    //default constructor
    public SimpleHash(int size)
    {
        occupied = new boolean[size];
        table = new int[size];
        this.size = size;
    }
    
    //simple hashing function
    public int hash(int n, int size)
    {
        return n % size;
    }
    
    //search function
    public boolean search(int key)
    {
    	//find position
    	int position = hash(key,size);
    
    	//if that index is occupied, return false
    	if (occupied[position]==false)
    	{
    		return false;
    	}
    
    	//the value is found, return true
    	else if(key==table[position])
    	{
    		return true;
    	}
    
    	return false;
    }

    //insertion function
    public boolean insert(int key)
    {
    	//find index
        int position = hash(key,size);
        
        //if the index is open, insert value
        if(occupied[position]==false)
        {
        	//add value
        	table[position] = key;
        	
        	//mark as occupied
            occupied[position] = true;
            
            return true;
        }
        
        return false;
    }

    //deletion function
    boolean delete(int key)
    {
    	//find the index
        int position = hash(key,size);
        
        //if index is occupied with the key that the function is trying to delete
        if(occupied[position] == true && table[position] == key)
        {
        	//delete the value
            occupied[position] = false;
            return true;
        }
        
        return false;
    }
    
    //display table
    void display()
    {
    	//run through all the indexes and print the value
        for (int i = 0; i < size; i++)
        {
        	if(occupied[i] == true)
        	{
        		System.out.println(i + ": " + table[i]);
        	}
        }
    }
}

