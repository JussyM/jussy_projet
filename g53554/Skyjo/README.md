[Skyjo PROJECT]

A game card written in java using javafx library and build with maven, the game has a 
fluid and interacting view for the best usage. 
The left pane is the only pane use for interacting with the current player the right pane 
is only made to show the opponent player.
This project is written using MVC and Observer Observable design pattern.

[SKYJO TREE]

![image](../master/Skyjo/image/skyjo_tree.png)

[GAME RULES]

Every player has 12 hidden cards (3x4). Two are turned face up. 
On your turn you can take the top card from the discard or draw pile. 
You can exchange one card (hidden or open) from your display. 
Round ends when one player has only open cards. (equal turns). 
All card will be revealed. Add the numbers of the card for scoring. 
Game ends after one player has 100 or more points. Whoever has the lowest number wins.
Special rule: Whenever one column of 3 cards all have the same value, they will be discarded and no longer scored.
Cards are ranked from -2 up to 12

Source : https://boardgamegeek.com/boardgame/204135/skyjo

[HOW TO LAUNCH THE APPLICATION]

To run the game you can use maven command if you're on terminal or launch it passing by your favorite IDE 

Terminal cmd : mvn clean javafx:run
