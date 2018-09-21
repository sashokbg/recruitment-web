# Java Recruitment Exercise

This Java exercises aims at your conceptional and problem solving skills in a real world
problem.

The goal of the exercise is to develop an application (java8 or greater) that manages some aspects
of a library as detailed in the Business Logic bellow.

### Business Logic

```text
    The city of Townsville requires a new Library Management system to replace it's
    current paper based workflow.
    
    The library is attended by two groups of people - Student members and Resident members.
    Only Members can borrow books at the library.
    
    Students that in their first year are allowed to 
    borrow books for free for a period of 15 days.
    After that period they are charged 10 cents (0.10 eu) for each day
    they keep a book.
    
    If a student, regardless of what year they are in, keeps a book
    for more than 30 days they are obliged to pay 
    15 (0.15) cents for each day after the initial 30 days.
    
    Residents are allowed to borrow books for a period of 60 days and are
    charged 10 cents (0.10 eu) for each day they keep the book
    If a resident keeps a book for more than 60 days they are obliged 
    to pay 20 cents (0.20 eu) for each day after the initial 60 days.
    
    If a member has late books they cannot borrow any new books before
    returning the late ones. 
```

### Requirements

* Time Requirements:

You can spend as much time as you like on the exercises but it should generally not take you more than
one afternoon. 

* Solution

Your solution should compile properly and all the unit tests included in the LibraryTest file should be green. 

* Sending the solution

Ideally you should fork the repository on github and create a branch with your name and send us the link to your repo

If you do not wish to use github, you can send your solution to our HR team via email
 

### Hints

You should :

* Implement the required business logic
* Implement the unit tests in src/test/LibraryTest.class
* Fix the code where it seems badly written or not respecting java conventions
* Use modern Java APIs where possible
* Avoid using heavy frameworks like Spring
* Be careful for pitfalls
* Do not bother implementing any logic for ISBN codes - they are completely fictional in our exercise
and serve only as identifiers for books
* Have fun :)


You may :

* Alter the existing code, but please follow the proposed code structure
* Add new code and features at your will
* Add more test cases where it seem logical to you
* Use design patterns to solve different problems

Happy Coding :) !