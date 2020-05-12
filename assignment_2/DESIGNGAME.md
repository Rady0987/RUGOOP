Design game:

VISUAL DESIGN:
First two rounds:
4 players (maybe option for later: making the amount of players variable),
	these players can be on the four sides of the table (left, right, up and down) with their already drawn cards shown

	--------------------------------------------
	|                 cards player             |
	|c                                        c|
	|a                                        a|
	|r                                        r|
	|d                                        d|
	|s                                        s|
	|    deck: stack of cards or pyramid       |
	|p                                        p|
	|l                                        l|
	|a                                        a|
	|y                                        y|
	|e                                        e|
	|r                                        r|
	|                  cards player            |
	--------------------------------------------

Third round:
Played by player who lost the second round:
 	-----------------------------------------------
 	|           deck: stack of cards              |
 	|                                             |
 	|   card1    card2    card3   card4    card5  |
 	|                                             |
 	|         options shown for the player        |
 	-----------------------------------------------

In the corner of all rounds: An option to restart game, if something went wrong (with failsafe, are you sure?)
Big restart button and start button at the end and beginning of game.

CLASSES:
Needed for all rounds: class game, class card, class deck (which cards are left and on which order), class roundx(parts of the game divided)
Needed for 1st and 2d round: class hand (belongs to a player, exists of arraylist of cards)
Neede for 3d round: class bus (which cards are in the array, and is the back or front shown of the position (so each position in the array has the value of a card and front shown as boolean), which position the player is at with guessing)


GAMEPLAY:
Round 1:

The game asks the player whether the first card of the deck at the moment will be red or black,
 the player can click an answer and the card will be dealt. There will be a statement shown, whether he was right or not.
 The card will stay visible at the side of the table of the player who was playing.
 This will be done for all players.
 Then the game asks the first player whether the second card they will get is higher of lower than the first card. The player can click an answer and the card will be dealt again and there will be shown again, whether he was right or not. Card stays. Other players also answer.
 Then the game asks the player whether the third card is between the first two. (all the same things again as the previous cards).
 Then the game asks whether the next card is of a kind (diamonds, heart, etc) that the player already has or not. If the player has three different kind of cards, the option disco will appear, this means that the player wants the last 
 card to be the the fourth kind of card. If it is the card, all the other players 'lose' (like when they have their own card wrong).

 Round 2: A pyramid will be shown with the back of cards and the 'hands' of all the players are still visible from the last round. 
 		Each time you can click on the pyramid and the front of a card will be shown instead of the back of a card, this will be the first card of the deck (same deck as previous round, because the cards of the players cannot be the exact same as one in the pyramid). 
 		Each player has the opportunity to lay his card on the turned around card íf the value is the same. And the hand will have this card deleted.
 		When all card are shown, the game will announce who has lost the round (player with the most cards left).

 Round 3:  
 A bus will be like this:
 Bus: {ten of hearts (frontShown: true), five of spades (frontShown: true), three of diamonds (frontShown: false), ..}, position: 0
 Shown as:
 	-----------------------------------------------
 	|   card1    card2    card3   card4    card5  |
 	-----------------------------------------------

 	Beginning: Cards must be reshuffled in the deck. The first five are added to the array bus. This will be shown as a row of five cards with the back shown (so frontShown is false).
 	The game asks the player whether the first card of the deck will be higher or lower than the first card of the left. When the player chooses one of the options, the first card will be turned (if the front of the card is not shown yet, at the beginning of the round all cards are closed) and the first card of the deck will be drawn. The card of the deck that is drawn will lay upon the first card with the front shown (it will take its place in the array). If the player is wrong, he has to start again with the first card. When the front of a card is shown on a place in the array, it will stay showed.
 	If the player is right, he can guess the second card. This will be done the same way as the first card.
 	The player has completed the round when he guesses the last card right.