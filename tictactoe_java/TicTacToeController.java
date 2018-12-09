import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.layout.ColumnConstraints;
import javafx.event.ActionEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.control.ToggleGroup;
import java.util.ArrayList;
import java.util.List;
import java.security.SecureRandom;



public class TicTacToeController {

    @FXML
    private RadioButton button_x;

    @FXML
    private RadioButton button_o;

    @FXML
    private ToggleGroup players;

    @FXML
    private Label instructions;

    @FXML
    private GridPane gridPane;

    @FXML
    private Button button00;

    @FXML
    private Button button01;

    @FXML
    private Button button02;

    @FXML
    private Button button10;

    @FXML
    private Button button11;

    @FXML
    private Button button12;

    @FXML
    private Button button20;

    @FXML
    private Button button21;

    @FXML
    private Button button22;

    @FXML
    void button00pressed(ActionEvent event) {
        if (button00.getText() == "") {
            button00.setText(player1);
            instructions.setText("Player2's Turn");
            player1_positions.add(00);
            check_win();
            System.out.println("We've gotten this far..");
            if (won == false) {
                computer_move();
                System.out.println("Computer should have just moved.");
            }
        }
        else {
            instructions.setText("That's already taken! Try again.");
        }

    }

    //method to check if player1 one
    private void check_win() {
        for (int[] sequence : win_moves) {
            int check = 0;
            for (int num : sequence) {
                boolean result = player1_positions.contains(num);
                if (result == true) {
                    check += 1;
                }
            }
            if (check == 3) {
                won = true;
                instructions.setText("You win!");
                refresh_game();
            }
        //check_tie(); Program freezing
            
        }
    }

    @FXML
    void button01pressed(ActionEvent event) {
        if (button01.getText() == "") {
            button01.setText(player1);
            instructions.setText("Player2's Turn");
            player1_positions.add(01);
            check_win();
            if (won == false) {
                computer_move();
            }
        }
        else {
            instructions.setText("That's already taken! Try again.");
        }


    }

    @FXML
    void button02pressed(ActionEvent event) {
        if (button02.getText() == "") {
            button02.setText(player1);
            instructions.setText("Player2's Turn");
            player1_positions.add(02);
            check_win();
            if (won == false) {
                computer_move();
            }
        }
        else {
            instructions.setText("That's already taken! Try again.");
        }


    }

    @FXML
    void button10pressed(ActionEvent event) {
        if (button10.getText() == "") {
            button10.setText(player1);
            instructions.setText("Player2's Turn");
            player1_positions.add(10);
            check_win();
            if (won == false) {
                computer_move();
            }
        }
        else {
            instructions.setText("That's already taken! Try again.");
        }


    }

    @FXML
    void button11pressed(ActionEvent event) {
        if (button11.getText() == "") {
            button11.setText(player1);
            instructions.setText("Player2's Turn");
            player1_positions.add(11);
            check_win();
            if (won == false) {
                computer_move();
            }
        }
        else {
            instructions.setText("That's already taken! Try again.");
        }


    }

    @FXML
    void button12pressed(ActionEvent event) {
        if (button12.getText() == "") {
            button12.setText(player1);
            instructions.setText("Player2's Turn");
            player1_positions.add(12);
            check_win();
            if (won == false) {
                computer_move();
            }
        }
        else {
            instructions.setText("That's already taken! Try again.");
        }


    }

    @FXML
    void button20pressed(ActionEvent event) {
        if (button20.getText() == "") {
            button20.setText(player1);
            instructions.setText("Player2's Turn");
            player1_positions.add(20);
            check_win();
            if (won == false) {
                computer_move();
            }
        }
        else {
            instructions.setText("That's already taken! Try again.");
        }


    }

    @FXML
    void button21pressed(ActionEvent event) {
        if (button21.getText() == "") {
            button21.setText(player1);
            instructions.setText("Player2's Turn");
            player1_positions.add(21);
            check_win();
            if (won == false) {
                computer_move();
            }
        }
        else {
            instructions.setText("That's already taken! Try again.");
        }


    }

    @FXML
    void button22pressed(ActionEvent event) {
        if (button22.getText() == "") {
            button22.setText(player1);
            instructions.setText("Player2's Turn");
            player1_positions.add(22);
            check_win();
            if (won == false) {
                computer_move();
            }
        }
        else {
            instructions.setText("That's already taken! Try again.");
        }


    }

    @FXML 
    void button_o_pressed(ActionEvent event) {
        player1 = "O";
        player2 = "X";
        instructions.setText("Pick A Square!");

    }

    @FXML
    void button_x_pressed(ActionEvent event) {
        player1 = "X";
        player2 = "O";
        instructions.setText("Pick A Square!");

    }

    //method for computer's move
    private void computer_move() {
        //random number geneator object
        SecureRandom randomNumbers = new SecureRandom();
        //find free position
        //produce x and y random value between 0 and 2 inclusive
        int x = randomNumbers.nextInt(3);
        int y = randomNumbers.nextInt(3);
        String x1 = String.valueOf(x);
        String y1 = String.valueOf(y);
        String pos = x1 + y1;
        int position = Integer.parseInt(pos);
        //if position
        if (x == 0) {
            if (y == 0) {
                System.out.println(button00.getText());
                if (button00.getText() == "") {
                    player2_positions.add(position);
                    button00.setText(player2);
                    check_won_computer();
                    if (won == false) {
                        instructions.setText("Your Turn!");
                    }
                }
                else {
                    computer_move();
                }
            }
            if (y == 1) {
                if (button01.getText() == "") {
                    player2_positions.add(position);
                    button01.setText(player2);
                    check_won_computer();
                    if (won == false) {
                        instructions.setText("Your Turn!");
                    }
                }
                else {
                    computer_move();
                }

            }
            if (y == 2) {
                if (button02.getText() == "") {
                    player2_positions.add(position);
                    button02.setText(player2);
                    check_won_computer();
                    if (won == false) {
                        instructions.setText("Your Turn!");
                    }
                }
                else {
                    computer_move();
                }

            }
        }
        System.out.print("X is not 0");
        if (x == 1) {
            if (y == 0) {
                if (button10.getText() == "") {
                    player2_positions.add(position);
                    button10.setText(player2);
                    check_won_computer();
                    if (won == false) {
                        instructions.setText("Your Turn!");
                    }
                }
                else {
                    computer_move();
                }
            }
            if (y == 1) {
                if (button11.getText() == "") {
                    player2_positions.add(position);
                    button11.setText(player2);
                    check_won_computer();
                    if (won == false) {
                        instructions.setText("Your Turn!");
                    }
                }
                else {
                    computer_move();
                }

            }
            if (y == 2) {
                if (button12.getText() == "") {
                    player2_positions.add(position);
                    check_won_computer();
                    button12.setText(player2);
                    if (won == false) {
                        instructions.setText("Your Turn!");
                    }
                }
                else {
                    computer_move();
                }

            }
        }
        if (x == 2) {
            if (y == 0) {
                if (button20.getText() == "") {
                    player2_positions.add(position);
                    button20.setText(player2);
                    check_won_computer();
                    if (won == false) {
                        instructions.setText("Your Turn!");
                    }
                }
                else {
                    computer_move();
                }
            }
            if (y == 1) {
                if (button21.getText() == "") {
                    player2_positions.add(position);
                    button21.setText(player2);
                    check_won_computer();
                    if (won == false) {
                        instructions.setText("Your Turn!");
                    }
                }
                else {
                    computer_move();
                }

            }
            if (y == 2) {
                if (button22.getText() == "") {
                    player2_positions.add(position);
                    button22.setText(player2);
                    check_won_computer();
                    if (won == false) {
                        instructions.setText("Your Turn!");
                    }
                }
                else {
                    computer_move();
                }

            }
        }

    }

    //Method to check if computer won
    private void check_won_computer() {
        for (int[] sequence : win_moves) {
            int check = 0;
            for (int num : sequence) {
                boolean result = player2_positions.contains(num);
                if (result == true) {
                    check += 1;
                }
            }
            if (check == 3) {
                won = true;
                instructions.setText("The Computer wins!");
                refresh_game();
            } 
            
        }
        check_tie();
    }

    //Method to check for a tie
    private void check_tie() {
        if ((player1_positions.size() > 4) || (player2_positions.size() > 4)) {
            tie = true;
            refresh_game();

        }
        else {
            tie = false;
        }
        
    }

    //will refresh if someone has won or its a tie
    private void refresh_game() {
        button00.setText("");
        button01.setText("");
        button02.setText("");
        button10.setText("");
        button11.setText("");
        button12.setText("");
        button20.setText("");
        button21.setText("");
        button22.setText("");
        player1_positions.clear();
        player2_positions.clear();
        instructions.setText("Choose a Player!");

    }

    //Players
    String player1 = "X"; //default set to X
    String player2 = "O";

    // Check
    boolean won = false;
    boolean tie = false;

    //Positions
    int[] positions = {00,01,02,10,11,12,20,21,22};

    //win positions
    int[][] win_moves = {{01, 11, 21}, {02, 12, 22}, {03, 13, 23}, {01, 12, 23}, {01, 02, 03}, {11, 12, 13}, {21, 22, 23},
                            {01, 12, 23}, {03, 12, 21}};

    //player1 positions
    //int[] player1_positions = new int[9];
    List<Integer> player1_positions = new ArrayList<Integer>();

    //player2 positions
    //int[] player2_positions = new int[9];
    List<Integer> player2_positions = new ArrayList<Integer>();

    //List of buttons (squares)
    Button[] buttons = {button00, button01, button02, button10, button11, button12, button20, button21, button22};


    public void initialize() {
        button00.setText("");
        button01.setText("");
        button02.setText("");
        button10.setText("");
        button11.setText("");
        button12.setText("");
        button20.setText("");
        button21.setText("");
        button22.setText("");
        instructions.setText("Choose a Player!");
    }

}

