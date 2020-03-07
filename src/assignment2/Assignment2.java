//Daniel Elamrani
//CISC 3130 
//Assignment 2
package assignment2;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.util.LinkedList;


public class Assignment2 {

    
    public static void main(String[] args) throws IOException {
       
        //Files, may implement command line args should the data need to be dynamic. For now, we will use static file locations
        String file1 = "C:\\Users\\Admin\\Desktop\\Random pdf's\\Assignment 2 csv files\\regional-us-weekly-2-07-2-14.csv";
        String file2 = "C:\\Users\\Admin\\Desktop\\Random pdf's\\Assignment 2 csv files\\regional-us-weekly-2-14-2-21.csv";
        String file3 = "C:\\Users\\Admin\\Desktop\\Random pdf's\\Assignment 2 csv files\\regional-us-weekly-2-21-2-28.csv";
        String file4 = "C:\\Users\\Admin\\Desktop\\Random pdf's\\Assignment 2 csv files\\regional-us-weekly-2-28-3-06.csv";
        
        //ArrayList that holds my string of file names
        ArrayList<String> myFiles = new ArrayList<String>();
        
        //Adding all the files to that arraylist
        myFiles.add(file1);
        myFiles.add(file2);
        myFiles.add(file3);
        myFiles.add(file4);
        
        
        //ArrayList that qill hold MyQueue Objects
        ArrayList<MyQueue> allTheWeeks = new ArrayList<MyQueue>();
        
        //For loop instantiates a MyQueue Object with one of the file names from our myFiles arrayList and adds the resulting MyQueue to an allTheWeeks ArrayList
        for(int i = 0; i<myFiles.size(); i++ ){
            MyQueue dataExtract = new MyQueue(myFiles.get(i));
            allTheWeeks.add(dataExtract);
            
        }
        
        //allTheWeeks, an arrayList, now consists of 4 MyQueue objects. These MyQueue objects have extracted the Song data from the csv files and 
        //put them into a linked list of strings. So we essentially have an arraylist consisting of 4 linked lists. 
        
        
        //I will merge the first and second queue together and sort the merged MyQueue by calling my mergeFunction method I implemented in the MyQueue class,
        //I and we will use this new merged MyQueue to create a playlist as well as our song history list. 
        MyQueue merged = MyQueue.mergeFunction(allTheWeeks.get(0),allTheWeeks.get(1));
        
        
        /*Prints the merged MyQueue
        for(int i = 0; i<merged.queue.size();i++){
            System.out.println(merged.queue.get(i));
        }
        */
        
        //Create my queue that I implemented in the Playlist class
        Playlist myPlaylist = new Playlist();
        
        
        //I take my merged MyQueue that is essentially a large linked list of strings and add each to my Playlist queue.
        for (int i = 0; i<merged.queue.size(); i++){
            
            myPlaylist.addSong(merged.queue.get(i));
            
        }
        
        //I print my Playlist
        System.out.println();
        System.out.println();
        System.out.println("PRINTING OUT MY PLAYLIST");
        System.out.println();
        System.out.println();
        myPlaylist.displayQueue();
        System.out.println();
        System.out.println();
        
        //Create songHistoryList object which is a stack that will have my recently listened to songs. 
        SongHistoryList songHistoryList = new SongHistoryList();
        
        
        //Will use this variable in my for loops.
        int size = myPlaylist.getSize();
        
        //Now I want to listen to my playList so I will call my listenToSong method in the Playlist class which returns a song which is then passed as a parameter 
        //to my songHistoryList addSong method.
        for(int i=0; i<size; i++){
            
            songHistoryList.addSong(myPlaylist.listenToSong());
            
        }
        
        //Now I will print out my songHistoryList stack -- this will print the reverse order of the myPlaylist queue
        System.out.println();
        System.out.println();
        System.out.println("PRINTING OUT THE SONG HISTORY LIST");
        System.out.println();
        System.out.println();
        songHistoryList.displayStack();
        System.out.println();
        System.out.println();
        
        //Now I would like to listen to my last listened to songs and print them out, I do so by calling the lastListened method in my songHistoryList class
        //This will look the same as the displayStack but the key difference is that by calling the lastListened method I am removing that song from the stack.
        //This is called popping the stack.
        System.out.println("LISTENING TO MY LAST LISTENED SONGS AND PRINTING THEM OUT");
        System.out.println();
        System.out.println();
       
        //calls and also prints the lastListened songs.
        for(int i = 0; i<size;i++){
            
            System.out.println(songHistoryList.lastListened());
            
        }
        System.out.println();
        System.out.println();

        
    }
    
}
