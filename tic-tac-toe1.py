
class tic-tac-toe:

	def __init__(self):
		self.positions = [[(0,1), (0,2), (0,3)],
						[(1,1), (1,2), (1,3)],
						[(2,1), (2,2), (2,3)]]
		self.player1 = ""
		self.player2 = ""
		self.win_moves = [[(0,1), (1,1),(2,1)], [(0,2), (1,2), (2,2)], [(0,3), (1,3), (2,3)], 
						[(0,1), (0,2), (0,3)], [(1,1), (1,2), (1,3)], [(2,1), (2,2), (2,3)],
						[(0,1), (1,2), (2,3)], [(0,3), (1,2), (2,1)]]
		self.player_positions = []
		self.other_positions = [] #Hold current occupying positions

	#Choose Player
	def choose_player(self, player):
		if player == "X" or player == "O":
			if player == "X":
				self.player1 = "X"
				self.player2 = "O"
				print("Okay, I'll be {}\n".format(player2))
			else:
				self.player1 = "O"
				self.player2 = "X"
				print(print("Okay, I'll be {}\n".format(player1)))
			return True
		else: 
			return False

	def show_positions(self):
		return self.positions

	def check_move(self, x, y):
		if x.isdigit() and y.isdigit():
			player_move = (x,y)
			if player_move in self.other_positions or player_move in self.player_positions:
				return True
			else:
				print("That place is already taken... Try again!")
				return False
		else:
			print("Thats not a position!!")
			return False

	def add_player(self, x_position, y_position):
		player_move = (x_position,y_position)
		self.player_positions.append(player_move)

	def add_other(self, x_position, y_position):
		player_move = (x_position,y_position)
		self.other_positions.append(player_move)

	def check_if_player_won(self, x, y):
		player_move = (x,y)
		for sequence in self.win_moves():
			#Check if move in a winning sequence(It should be....)
			first_move, second_move, third_move = sequence[0], sequence[1], sequence[2]
			if player_move == first_move:
				if second_move in player_positions:
					if third_move in player_positions:
						return (True, self.player1)
					else:
						return False
				else:
					return False
			elif player_move == second_move:
				if first_move in player_positions:
					if third_move in player_positions:
						return (True, self.player1)
					else:
						return False
				else:
					return False
			elif player_move == third_move:
				if first_move in player_positions:
					if second_move in player_positions:
						return (True, self.player1)
					else:
						return False
				else:
					return False

	def refresh_board(self):
		#get list of positions
		for p in self.positions:
			#Check if p in Player positions
			if p in self.player_positions:
				p = self.player1
			elif p in self.other_positions:
				p = self.player2
		return self.positions


