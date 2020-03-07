
package assignment2;


public class Playlist {
    protected SongNode front;
    protected SongNode rear;
    protected int size=0;
    
    public void addSong(String track){
        
        //we create a node and call its constructor, we will insert this into our queue once we find the end of our queue
         SongNode node = new SongNode(track);
        
        //if head is null then we know our list is empty and we set the newly created node as our first node
        if(front==null){
            front = node;
            rear = node;
        }
        
        //if the list is not empty and our first node has a value then we enter the else statement
        else{
            
            //we create a temporary node and set it equal to the firt node
            SongNode traverseNode = front;
            
            //we now traverse the list by entering a while loop that keeps iterating if the next node is not null
            while(traverseNode.next!=null){
                
                //we set our temp node to equal the next node only stopping when temp node gets a value of null. Once we get null, we know that we are at the last node
                //in the linked list and can exit the while loop.
                traverseNode = traverseNode.next;
            }
            
            //We have exited the while loop because tempNode.next returned null. We want our information to be stored in that location so we say the node that we first created
            //and its information is now going to be stored at the location. Traverse node hit the end of the list and said hey I know where the null is, im going to now point to the
            //the new node instead and the new node can then point to null because it wont have a next value
            traverseNode.next=node;
            rear=node;
            
        }
        
        size++;
    }
    //Basically our dequeue method in that we remove the first song that was added
    public SongNode listenToSong(){
        
        //if the front of the queue isn't null go inside if statement
        if(front!=null){
        
            
        //create temp node and set it equal to front
        SongNode oldFrontNode = front;
        
        
        
        //set the node that was after front as the new front node
        front = front.next;
        
        
        //decrease size by 1 since we lost a node
        size--;
        
        //return the old front node
        return oldFrontNode;
        }
        
        //if front node is null we know the queue is emptu so we return null
        else {
            return null;
                    }
        
    }
    
    //returns the size of our queue
    public int getSize(){
        return size;
    }
    
    //displays our queue
    public void displayQueue(){
        
        //We create a node to traverse our linked list, starting with the first node
        SongNode node = front;
        
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
    
    
    
    
    
    
    public Playlist(){
      front = null;
      rear=null;
    }
    
    
    public boolean isEmpty(){
     return (front == null);
    }
    
    
    
    
    
    
}
