/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment2;

/**
 *
 * @author Admin
 */
public class SongHistoryList {
    protected SongNode top;
    protected int size=0;
    
    
    //adds a song to our stack
    public void addSong(SongNode lastListened){
        
        //we create a node and call its constructor, we will insert this onto the top of our stack
         SongNode node = lastListened;
         
         //this clears the pointer of the SongNode that was passed in
         node.next = null;
        
        //if head is null then we know our list is empty and we set the newly created node as our first node
        if(top==null){
            top = node;
            
        }
        
        //if the list is not empty and our first node has a value then we enter the else statement
        else{
            
            //set the pointer for our new node to the current top node. Now this top node is being reference by something so we wont lose track of it
            node.next = top;
            
            //Since the old top node is being referenced by our new node, we are free to set the new node to top
            top = node;     
            
        }
        
        size++;
    }
    
    public SongNode lastListened(){
        
        //if the stack isn't empty
        if(top!=null){
            
            //make a temp node and set it equal to top
            SongNode oldTopNode = top;
            
            //set the node under the top node equal to top
            top =top.next;
            
            //decrease size by 1
            size--;
            
            //return the old top node
            return oldTopNode;
        }
        
        else {
            return null;
                    }
        
    }
    
    
    public int getSize(){
        return size;
    }
    
    public void displayStack(){
        
        //We create a node to traverse our stack
        SongNode node = top;
        
        
        
        //while the next node isnt null, we print out the node
        while(node.next!=null){
            
            System.out.println(node);
            
            //once we've printed out the current node, we set our node equal to the next node.
            node=node.next;
            
            
            
        }
        
        //We need this because it stops printing when node.next has a null value which the end node will always have a null value so we must print the last node
        //after the while loop ends
        System.out.println(node);
        
        
    }
}