
# Sports Bet Tracking Application

<br>

- **What will the application do?**
<br> My proposal for my personal project is an application for the user to track down their sports bets 
(specifically NBA and NHL).
The user will be able to manually enter in details of every bet. This includes the date, event, amount
staked, odds, and outcome (did you win or lose the bet). After entering this information for each bet, the application
will keep track of all the data and output statistics including overall money won/loss, win percentage, and total 
number of wins and losses. This application allows the user to view every single bet they've ever placed and their 
personalized statistics.

  <br>
- **Who will use it?** <br>
The targeted audience for this application are people who would like to responsibly bet or become a responsible better. 

  <br>
- **Why is this project of interest to you?** <br>
This is a topic of interest to me since I personally sport bet but also believe sports betting can be very harmful to
people. Especially since it's a fast-growing industry with an increasing amount of advertisements and influencers 
promoting it, I think it's becoming a problem in many people's lives. My hope is that if people
start tracking their bets on an application like this, some may realize how much money they're really losing and 
decide to seek help in order to quit.


### User Story

- As a user, I want to be able to add a bet 
(including date, the actual bet, amount staked, odds, and whether I won or lost that bet) to a list of my bets.
- As a user, I want to be able to view the total amount of money I won/lost.
- As a user, I want to be able to view my total number of wins and losses.
- As a user, I want to be able to view my largest win and largest loss.
- As a user, I want to be able to view the list of all my bets.
- As a user, I want to be able to save my list of bets to file (if I so choose)
- As a user, I want to be able to be able to load my list of bets from file (if I so choose)

# Instructions for Grader

- You can generate the first required action related to the user story adding bets to betting history by 
running the JSwing class and entering in all information then clicking add bet.
- You can view list of bets, view total profit, view biggest win all from running the program. The GUI automatically
the three visuals relating to bets.
- You can locate my visual component by adding a bet. Whenever a bet is added successfully the same image appears.
- You can save the state of my application by clicking the load button in the GUI.
- You can reload the state of my application by clicking the save button in the GUI.

### Phase 4: Task 2
- Wed Apr 03 15:20:43 PDT 2024
Bets loaded
- Wed Apr 03 15:20:43 PDT 2024
Bets added to betting history
- Wed Apr 03 15:20:43 PDT 2024
Bets added to betting history
- Wed Apr 03 15:20:43 PDT 2024
Bets added to betting history
- Wed Apr 03 15:20:43 PDT 2024
Bets added to betting history
- Wed Apr 03 15:20:43 PDT 2024
Total profit displayed and updated
- Wed Apr 03 15:20:43 PDT 2024
Biggest win displayed and updated
- Wed Apr 03 15:20:48 PDT 2024
Bets added to betting history
- Wed Apr 03 15:20:48 PDT 2024
Total profit displayed and updated
- Wed Apr 03 15:20:48 PDT 2024
Biggest win displayed and updated
- Wed Apr 03 15:20:50 PDT 2024
Bets saved to file

### Phase 4: Task 3

- If I had more time to work on my project, something I would refactor to improve my project is make a UI interface
where the console UI and GUI would implement it. The reason for this is that the console UI and GUI have
similar methods but with small differences. For example, both the of the UI's have a saveBettingHistory and
loadBettingHistory method but have differing code inside the methods. What this would do is make sure that if I made
any other UI's, I would know that those methods inside the interface should be included in the new UI. In the case that
the UI and GUI had the exact same loadBettingHistory and saveBettingHistory method, instead of an interface I would
make an abstract class where the UI's would share the methods.