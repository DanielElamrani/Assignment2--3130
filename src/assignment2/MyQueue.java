
package assignment2;

import java.util.LinkedList;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class MyQueue {
    protected LinkedList<String> queue = new LinkedList<String>();

    
    public MyQueue(String fileName) throws IOException{
        
        
        //Create file and its pathway
        File inputData = new File(fileName);
        
        //create scanner
        Scanner sc = new Scanner(inputData);
        
        
        //String that will hold the value from each line of our data.
        String line="";
        
        
        //This is the 2D array we will be putting all of our input data into.
        String[][] allDataArr = new String[200][5]; 
        
        //this will be used in our for loop to place the data into the correct array indices
        int allDataArrRowIndex = 0;
        
        //While loop to read in our data and place into our 2D array
        while (sc.hasNextLine()){
            
            //This String holds a line of our data
            line = sc.nextLine();
            
            
            //This String array will take our line and split it up by the delimiter "," and place everything into between the commas into an array index
            String[] results = line.split(",");
            
            //This for loop takes our String array which has 5 elements, as there are 5 pieces of data in each line separated by commas,
            //and places them into our 2D array in a grid like fashion.
            for (int i = 0; i<5; i++){
                
                allDataArr[allDataArrRowIndex][i] = results[i];
                
            }
            
            //We use this variable to increment the row as we know we have 5 columns of data and only the row will be changing continusouly for each iteration.
            allDataArrRowIndex++;
    
        }//Exit while loop
        
        
        
        //This for loop will take our song column in the 2D array and add the song name into our instance variable queue linked list
        for (int i = 0; i<200;i++){
            
         
          queue.add(allDataArr[i][1]);
        
        }
    
    
    }
    
    //method to merge two MyQueues together and sort them
    public static MyQueue mergeFunction(MyQueue q1, MyQueue q2){
        
        //enhanced for loop iterates through q2 and adds its items to q1
        for (String item: q2.queue){
            
            q1.queue.add(item);
            
        }
        
        //Call collection.sort to sort q1
        Collections.sort(q1.queue, String.CASE_INSENSITIVE_ORDER);
        
        //return q1
        return q1;
        
    }
    
    
    
}
