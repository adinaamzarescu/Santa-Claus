# Santa Claus is coming to ACS students
## Copyright 2022 Adina-Maria Amzarescu

Link GitHub: https://github.com/adinaamzarescu/Santa-Claus

Objectives: 
* Learning design patterns
* Writing generic code that can be changed afterwards
* Following a certain coding style and commenting style

The idea:
This Christmas themed project determines what kind of gift every
child will recieve.

`` Design Patterns: ``

* Factory
* Singleton
* Strategy
* Builder
_____________________________________________________________________

#### Input/Output :

You can find them in **fileio**.
In order to load them I used ObjectMapper.

Input classes: 
* Initial Data
  * For the first round
* Annual Changes
  * For the other rounds
* Children
* Gifts
* Loader
_____________________________________________________________________

Output classes:

There is a numberOfYears + 1 list of children that recieved gifts for
each round. 
* Children
* Gifts
* Loader

_____________________________________________________________________

`` Implementation ``

The main design pattern used is Factory. I also used Strategy 
(applying elf changes) and Builder (ChildBase class).
The factory is implemented by the generic child class
**ChildBase**.

* You can find *ChildBase* in the _entities_ package

In the _factories_ package you can find *ChildrenFactory* and
*ElfFactory*.

   The 4 children types:
      * Baby: < 5y
      * Kid: 5 - 12y
      * Teen: 12 - 18y
      * Young Adult: > 18y
   The 4 elves types:
     * Black
        * Decreases the assigned budget by 30%
     * Pink
        * Increases the assigned budget by 30%
     * Yellow
        * Assigns a gift to a child that hasn't
        received one yet
     * White
        * Does not affect the program
        
This factories are both Singleton and creates the 4 children and
elves types.
_____________________________________________________________________

The _Santa_ package does 2 main things:

* calculateScore
   
   The calculateScore method recieves a list of children
   and the budget. Depending on the child type the average score is
   calculated in 3 different ways:
   
   * For babies the averageScore is always 10
   * For kids it's the average of every niceScore they had in the last i
     years. Those scores are found in the niceScoreHistory list.
   * For teens it's the weighted average, the most recent years being
     more important

* calculateNiceScoreCity
    
   The calculateNiceScoreCity method recieves a list of scores for
   each city and calculates the average nice score of that city
   based on the children that live there.
   
* applyElfChanges

    Each child will have an elf that will take care of the gift.
    There are 4 types of elves that can be changed every year:

    1. YELLOW - gives a child (that haven't received a gift yet) a gift:
      * chooses the cheapest gift from the preference list
      * if there are no gift in teh preference list or if the quantity of the cheapest
      gift = 0  then this child won't receive a gift

    2. BLACK - decreseas the assignedBudget with 30%
      * budget -= budget * 30 / 100

    3. PINK - adds 30% to the asignedBudget
      * budget += budget * 30 / 100

    4. WHITE -  this elf won't do anything
    
* giveGift

   Depending on the assigned budget for each child, they will receive
   them in the prefered order.
   Every annual change will have a strategy based on the order of:

    * ID
    * niceScore
	    - the highest scores will receive gift first
	      if 2 children have the same niceScore the order will depend on their id (ascending order)

    * niceScoreCity
	    - for every city there will be an average score.
	    - when this score is calculated, the children will be sorted based on their id

        The gift will be given based on this niceScoreCity from highest to lowest and
	      the children from each city will be checked based on their id order.
	      If 2 cities have the same score they will be sorted in lexicographically order.
_____________________________________________________________________   

## The Game

In **Simulation** (main package) the program is implemented. 

The first step is to get the input and create each child. Then the 
children will be added in a list (**childrenList**) using the factory.

`` First Round ``

The first step was to remove the young adults (>18 years old) from the 
list. Then to calculate the score of every child.
Using the _giveGifts_ method the program gives the children presents.
Then it sorts the children based on their id.

After this the children are sorted based on the strategies mentioned
earler.

`` Base Round ``

For an intermediate turn the first step is to get the changes of each 
year. Then the new children are added to the list.
After that any young adult is removed. 

Since Santa has a new budget each year, _santaBudget_ will be modified
as well as the new gifts he has at the North Pole.
 
The score is calculated for every child in the list and then there
will be added the niceScoreBonus (if it exists). The budget for each child
is calculated and based on their elf type they receive gifts.

`` All Rounds``

At first it will be simulated the **firstRound** and then the remaining 
number of years rounds. 
_____________________________________________________________________

`` Main ``

This class is used to run the code. The _main_ method is used to call
the checker which calculates the score using the checker.
_____________________________________________________________________
