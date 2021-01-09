# A chat processor

## Motivation
This project was part of my plan of self-learning software design that abides by the S.O.L.I.D. design principles.

My plan was to carry out the following processes in parallel:
  - Theory: Read through Robert C. Martin's (Uncle Bob's) books on Clean Architecture and Software Craftsmanship
  - Practice: Implement concepts learnt from theory in my OOP-chat application

My plan worked and this github repository is the archive of the end result.

## Next Project and why this project is still being updated
My next project is going to be focusing on Test Driven Development. 
However, an intermediate milestone before beginning that is to improve my unit testing skills.

Therefore, I have been writing unit tests for this project, although testing was outside the scope of my initial plan for this project. Due to this fact, one may notice that this project is still being updated (with tests). 

## Documentation
### What the program is and does

This program is a very simple text file processor. 
It reads from an input text file, it processes the information and it outputs the product of processing into an output file in JSON format.

### Reading from a text file ###

The program reads from a '.txt' file. The text to be read has to have a specific format, which represents a conversation of people in a chat application.
The format follows:

(10 digit number) (non-empty sequence of characters) (non-empty sequence of characters)

representing...

(timestamp of message) (sender) (message sent)

NB: Successive conversation messages should be split by newlines '\n' in the input text file

### Processing

The processing is split in two parts:
  - Filtering the conversation
  - Creating a report based on conversation analytics
  
Filtering can be based on 'user' and on 'keyword'. For example, if we filter by the user 'bob', in the output file the conversation will have only messages from 'bob'. If we filter by the keyword 'pie', then the output file will have only messages containing the word 'pie'. If we apply **both**, then in the output file we are going to see only messages from 'bob' that contain the keyword 'pie'.

Reporting scans through the conversation and creates data analytic metrics. The program has currently only one metric, which is called 'UserActivity', and counts the number of messages per user.  

### Exporting the end product

What comes out of the 'Processing' stage is what I call here the end product. The end product is the *Filtered Conversation* and the generated *Report*. The 'Product' is converted first to **JSON format** and is then written to the output file. 

## Technical Specification

### Dependencies & Maven

This project has been built with Maven. Both the main program and the tests are ready to run in *Intellij Idea*. For running through the command line, one should first install Maven then build and run the program.

**External Dependencies**
  - GSON (com.google.code.gson)
  - Junit5 (org.junit)
  - Mockito (org.mockito)
  






