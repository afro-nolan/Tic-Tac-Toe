from tic_tac_toe1 import tic_tac_toe
import random

def main():
	game = tic_tac_toe()
	#Choose Side
	check = False  #Check to see if player is suitable input
	while check is False:
		player = input("Do you want to be X's or O's?\n Type X for X or O for O\n")
		check = game.choose_player(player)

	#Win Flag
	win = False
	#While no one wins
	while win is False:
		#Show Positions
		print("Our Board: \n")
		grid = game.show_positions()
		for row in grid:
			print(row, end="\n")

		#Ask for move
		prompt = print("Where would you like to move?")
		check = False
		#Check if suitable move
		while check is False:
			x_position = input("Enter X position: \n")
			y_position = input("Enter Y position: \n")
			check = game.check_move(x_position, y_position)

		#Record Move
		game.add_player(x_position, y_position)
	
		#Check if it was a winning move
		win = game.check_if_player_won(x_position, y_position, player)
		if win is True:
			break
		#If not win then, then get player 2 move (Comp. for now)
		check = False
		while check is False:
			x_position = random.randint(1,3)
			y_position = random.randint(1,3)
			print("They chose ({}, {})".format(x_position, y_position))
			check = game.check_move(x_position, y_position)

		#Record Move
		game.add_other(x_position, y_position)

		#Check if player2 won
		win = game.check_if_other_won(x_position, y_position, "other")
		if win is True:
			break

		grid = game.refresh_board()
		for row in grid:
			print(row, end="\n")

	grid = game.refresh_board()
	for row in grid:
			print(row, end="\n")
	if win and player == game.get_winner():
		print("{} won! Congratulations".format(player))
	else:
		print("Sorry, You Lost...")

if __name__ == "__main__":
	main()








