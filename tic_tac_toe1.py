
class tic_tac_toe:

	def __init__(self):
		self.positions = [[(1,1), (1,2), (1,3)],
						[(2,1), (2,2), (2,3)],
						[(3,1), (3,2), (3,3)]]
		self.player1 = ""
		self.player2 = ""
		self.win_moves = [[(1,1), (2,1),(3,1)], [(1,2), (2,2), (3,2)], [(1,3), (2,3), (3,3)], 
						[(1,1), (1,2), (1,3)], [(2,1), (2,2), (2,3)], [(3,1), (3,2), (3,3)],
						[(1,1), (2,2), (3,3)], [(1,3), (2,2), (3,1)]]
		self.player_positions = {}
		self.other_positions = {} #Hold current occupying positions
		self.won = ""
		self.possibilities = {1:True, 2:True, 3:True}

	#Choose Player
	def choose_player(self, player):
		if player == "X" or player == "O":
			if player == "X":
				self.player1 = "X"
				self.player2 = "O"
				print("Okay, I'll be {}\n".format(self.player2))
			else:
				self.player1 = "O"
				self.player2 = "X"
				print(print("Okay, I'll be {}\n".format(self.player1)))
			return True
		else: 
			return False

	def show_positions(self):
		return self.positions

	def check_move(self, x, y):
		try:
			if int(x) and int(y):
				x = int(x)
				y = int(y)
				try:
					chk1 = self.possibilities[x]
					chk2 = self.possibilities[y]
					player_move = (x,y)
					if player_move in self.player_positions or player_move in self.other_positions:
						return False
				except KeyError:
					print("Not in range!!")
					return False
		except ValueError:
			print("Thats not a position!!")
			return False

	def add_player(self, x_position, y_position):
		player_move = (int(x_position),int(y_position))
		self.player_positions[player_move] = True

	def add_other(self, x_position, y_position):
		player_move = (int(x_position),int(y_position))
		self.other_positions[player_move] = True

	def check_if_player_won(self, x, y, player):
		output = []
		output2 = []
		player_move = (int(x),int(y))
		for sequence in self.win_moves:
			#Check if move in a winning sequence(It should be....)
			first_move, second_move, third_move = sequence[0], sequence[1], sequence[2]
			if player_move == first_move:
				output.append("Equal to first move")
				if second_move in self.player_positions:
					if third_move in self.player_positions:
						self.won = self.player1
						#return output
						return True
					else:
						#return output
						return False
				else:
					return False
					#return output
			elif player_move == second_move:
				output.append("Equal to second move move")
				if first_move in self.player_positions:
					if third_move in self.player_positions:
						self.won = self.player1
						return True
						#return output
					else:
						return False
						#return output
				else:
					return False
					#return output
			elif player_move == third_move:
				output.append("Equal to third move")
				if first_move in self.player_positions:
					if second_move in self.player_positions:
						self.won = self.player1
						return True
						#return output
					else:
						return False
						#return output
				else:
					return False
					#return output

	def refresh_board(self):
		#get list of positions
		i = 0
		while i < len(self.positions):
			j = 0
			while j < len(self.positions):
				#Check if p in Player positions
				if self.positions[i][j] in self.player_positions:
					self.positions[i][j] = (self.player1)
				elif self.positions[i][j] in self.other_positions:
					self.positions[i][j] = (self.player2)
				j += 1
			i += 1
		return self.positions

	def get_winner(self):
		if self.won == "":
			return None
		else:
			return self.won

	def check_if_other_won(self, x, y, player):
		player_move = (int(x),int(y))
		for sequence in self.win_moves:
			#Check if move in a winning sequence(It should be....)
			first_move, second_move, third_move = sequence[0], sequence[1], sequence[2]
			if player_move == first_move:
				if second_move in self.other_positions:
					if third_move in self.other_positions:
						self.won = self.player2
						return True
					else:
						return False
				else:
					return False
			elif player_move == second_move:
				if first_move in self.other_positions:
					if third_move in self.other_positions:
						self.won = self.player2
						return True
					else:
						return False
				else:
					return False
			elif player_move == third_move:
				if first_move in self.other_positions:
					if second_move in self.other_positions:
						self.won = self.player2
						return True
					else:
						return False
				else:
					return False


