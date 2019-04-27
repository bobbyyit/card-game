# card-game

To Start the app, run:
CardGame.main();

Navigate to localhost:8888/
You should see "You're up and running"

Enpoints:
"game/create" creates a new game
 
"game/delete", delete the game
 
"game/player/add", add a player to the game

"game/player/remove?player-id={id-returned}", remove the player given the id

"game/players", lists players and their cards in the game

"deck/create", creates a deck and returns the id

"deck/assign?deck-id={deck-id}", assigns the deck to game

"deck/un-dealt", shows un-dealth cards, (need to create a new deck after showing cards)
 
"deck/shuffle", shuffles the deck of cards

"deal?player-id={playerid}&quantity={a-quantity}", deal number of cards to the specified player  