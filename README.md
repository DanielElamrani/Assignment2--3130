# Assignment2--3130
Assignment 2 for CISC 3130 
Daniel Elamrani


My code is well commented and explains my thought process throought out. Essentially this project is testing our understanding
of implementing stacks and queues using linked lists. The data received was altered to remove commas in the data fields 
to make for easy parsing. A work around should this not be viable in a given scenario is to use an open source library I came across
called openCSV. This essentially makes dealing with CSV files extremely easy. For future projects that require vast amounts of data where
manual manipulation is no onger viable, this is a good option. 

The assignment asks for multiple csv files to be read in and parsed for song data. I went about this by creating an arrayList of strings
with file locations. This made it simple to iterate through a for loop. 
I created a MyQueue class with a linkedlist as its data field. The constructor for this class takes a file name, parses out the song name,
and ultimately what you are left with is a linked list of String song names. I created a merge function that accepts two of these MyQueue
objects that combines the linkedlists of each and sorts them. 

I read in 4 csv files and created these for MyQueue objects with linkedlists containing the song names for all 4 csv files, BUT after
demonstrating the merge function on just the first two MyQueue objects I continued with the assignment working with one merged MyQueue object,
ultimately containing two csv files. I could have merged them all into one giant list but that would be 800 song names and I felt I met the
objective of the assignment and did not feel it was necessary to add them as at that point it serves no purpose other than making reading
the output extremely tedious as there would be 800 songs. 

Next I created a queue called myPlaylist. It has the necessary methods for adding a song to the rear, displaying the contents 
and removing a song from the front.
I printed the playlist after I added in the data from the merged MyQueue object. There is an output text file that shows this. 
I then created a stack, to serve as my song history list. This has methods for adding a song to the top of the stack, removing a song from
the top of the stack and also a method to display the stack. 

I "listened" to all the songs in myPlaylist which were passed into my song history list.

I then printed the Song history list to show thoe order in which the songs were added.

Then I "listened" to my lastListened songs from my song history list (the stack) and printed them out.
lastListened is essentially popping the stack so after the end of this method call my stack was empty.

The same goes for the myPlaylist queue, as "listening" to a song removes it from the queue. 

Data used and output are included in this repository. 
