
public class Main 
{
	 public static void main(String []args)
     {
			//create simple hash table with 11 indexes
			 SimpleHash simpleHash = new SimpleHash(11); 
             System.out.println("\nSIMPLE HASH\n");
             
             //values to add to table
             int[] values = {96, 81, 22, 35, 4, 15, 57, 46};
             
             //run through array and add to table and print results
             for(int i = 0; i < values.length; i++)
             {
            	 simpleHash.insert(values[i]);
            	 simpleHash.display();
            	 System.out.println();
             }
			 
             //delete 81 from simple hash table
             simpleHash.delete(81);
             simpleHash.display();
             
             //search for 35 in simple table and print result
             System.out.println("\n35 is kept at hash index: " + simpleHash.search(35));
             
             //try to insert 4 into table but it fails because it is a simple hash table
             simpleHash.insert(4);
             simpleHash.display();
             
             //create a linear probing hash table
             LinearProbing linearTable = new LinearProbing(11);
             System.out.println("\nLINEAR HASH\n");
            
             //add values into table and print the table
             for(int i = 0; i < values.length; i++)
             {
            	 linearTable.insert(values[i], 0);
            	 linearTable.display();
            	 System.out.println();
             }
             
             //delete 81 and display new table
             linearTable.delete(81,0);
             linearTable.display();
             
             //search for value and print results
             linearTable.search(35, 0);
             //if the result is -1, the value is not found
             if(linearTable.printSearchResults() == -1)
             {
            	 System.out.println("\nSearch failed, value not found");
            	 //clear stack for next search
            	 linearTable.clearSearchStack();
             }
             //else print the index the value is found at
             else
             {
            	 System.out.println("\n35 is found at: " + linearTable.printSearchResults() + "\n");
            	 //clear stack for next search
            	 linearTable.clearSearchStack();
             }
             
             //insert 4, it works this time because it uses linear probing and looks for open indexes to insert
             linearTable.insert(4, 0);
             linearTable.display();                    
     }
}
