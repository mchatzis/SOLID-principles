# A chat processor

## Motivation
This project was part of my plan of self-learning software design that implements the S.O.L.I.D. design principles.

My plan was to carry out the following processes in parallel:
  - Theory: Read through Robert C. Martin's (Uncle Bob's) books on Clean Architecture and Software Craftsmanship
  - Practice: Implement concepts learnt from theory in my OOP-chat application

This github repository is the archive of the end result.

## Next Project and why this project is still being updated
My next project is going to be focusing on Test Driven Development. 
However, an intermediate milestone before beginning that is to improve my *Unit testing* skills, including the *Mockito* library.

Therefore, although testing was outside the scope of my initial plan for this project, I have been writing unit tests for this project.
Due to this fact, one may notice that this project is still being updated (with tests). 

## Documentation
### What the program is and does

This program is a very simple text file processor. 
It reads from an input text file, it processes the information and it outputs the product of processing into an output file in JSON format.

### Reading from a text file ###

The program reads from a '.txt' file. The text to be read has to have a specific format, which represents a conversation of people in a chat application.
The format follows:

`(10 digit number) (non-empty sequence of characters) (non-empty sequence of characters)`

representing...

`(timestamp of message) (sender) (message sent)`

NB: Successive conversation messages should be split by newlines '\n' in the input text file

### Processing

The processing is split in two parts:
  - Filtering the conversation
  - Creating a report based on conversation analytics
  
Filtering can be based on 'user' and on 'keyword'. For example, if we filter by the user 'bob', in the output file the conversation will have only messages from 'bob'. If we filter by the keyword 'pie', then the output file will have only messages containing the word 'pie'. If we apply **both**, then in the output file we are going to see only messages from 'bob' that contain the keyword 'pie'.

Reporting scans through the conversation and creates data analytic metrics. The program has currently only one metric, which is called 'UserActivity', and counts the number of messages per user.  

### Exporting the end product

What comes out of the 'Processing' stage is what I call here the end product. The end product is the *Filtered Conversation* and the generated *Report*. The 'Product' is converted **first to JSON format** and is then written to the output file. 

## Technical Specification

### Dependencies & Maven

This project has been built with Maven. Both the main program and the tests are ready to run in *Intellij Idea*. For running through the command line, one should first install Maven then build and run the program.

**External Dependencies**
  - GSON (com.google.code.gson)
  - Junit5 (org.junit)
  - Mockito (org.mockito)

### Implementation

This project is pretty self-explanatory. The code has very carefully chosen names and follows the Single Responsibility Principle, which means that understanding the function of a module is pretty straight forward.

There are 4 levels of abstraction. Modules belonging to different levels of abstraction are decoupled using interfaces. The "Program" class is just the driver of the structure and hence the lowest level module.


In this ![diagram](https://github.com/mchatzis/OOP-chat-application/blob/main/IMG_20210112_124829.jpg), the hierarchical structure can be clearly seen without the driver class "Program" included. Please notice that this is not a UML diagram which should include the interfaces and follow the arrow conventions.

In the second ![diagram](https://github.com/mchatzis/OOP-chat-application/blob/main/IMG_20210112_125056.jpg), the "Program" is included.

Flow of control is linear. First importing, then processing then exporting. Importing first reads, then parses. Processing first filters then generates report. Exporting first converts to JSON, then writes to file.

The Filterer applies all given filters sequentially.  


## Implementation of S.O.L.I.D. principles

The S.O.L.I.D. principle architecture has been carefully implemented. More specifically:

  - All modules have a single responsibility
  - No higher level module depends on a lower level module. This has been achieved by decoupling the modules with...
  - Segregated interfaces, created with the smallest necessary degree of abstraction
  
From the above, it follows that all modules are 'Open for extension but closed for modification'. 

**Example**

For instance, let us suppose we need another filter to be applied to the conversation. If the S.O.L.I.D. principles were ignored during the construction of the program, this would mean that we would have to change higher level modules that depend on the Filters, such as the 'Filterer' module which is responsible for applying all filters.

However, this is not the case in this program. Any number of filters can be added as long as they abide to the contract defined by the 'IFilterer' interface (which is to implement the function 'filterBy'). The 'Filterer' higher-level module does not depend on the individual filters, but only on the interface. Hence, it does not have to change.

### Testing

Testing is **neither extensive**, **nor sufficient**. Testing was not the primary goal of this project. This project is not aiming at being ready-to-ship production code, but rather serves as a *dojo* for my self-learning of S.O.L.I.D. principles, Unit Testing and Mockito. 

That being said, some tests have been performed but are limited to testing very basic functionality.

### Future work

  - **Comprehensive unit testing** and addition of **integration tests** and **end-to-end tests**
  - In-line documentation in code functions and modules
  - More detailed *README* technical documentation for all functions and modules
  






