package com.example.tictactoemarnan;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity implements View.OnClickListener {
    // ImageButtons for the tic-tac-toe grid
    ImageButton imgbtn0, imgbtn1, imgbtn2, imgbtn3, imgbtn4, imgbtn5, imgbtn6, imgbtn7, imgbtn8;

    // TextViews for displaying the current turn and progress
    TextView tvTurn, tvProgress;

    // Button for returning or resetting the game
    Button btnReturn;

    // Variable to keep track of the winner
    int whoWin;

    // ImageView for displaying X or O
    ImageView imgXO;

    boolean canTakeInput = true;

    boolean isGameActive;

    // 2D array representing the tic-tac-toe board
    int[][] board = {{' ', ' ', ' '},
            {' ', ' ', ' '},
            {' ', ' ', ' '}};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        // Initialize all views and variables
        initialized();

        // Make the return button initially invisible
        btnReturn.setVisibility(View.INVISIBLE);
    }



    private void initialized() {
        // Initializing all variables
        // ImageView for displaying X or O
        imgXO = findViewById(R.id.imgXO);

        // ImageButton references for each position on the tic-tac-toe grid
        imgbtn0 = findViewById(R.id.imgbtn0);
        imgbtn1 = findViewById(R.id.imgbtn1);
        imgbtn2 = findViewById(R.id.imgbtn2);
        imgbtn3 = findViewById(R.id.imgbtn3);
        imgbtn4 = findViewById(R.id.imgbtn4);
        imgbtn5 = findViewById(R.id.imgbtn5);
        imgbtn6 = findViewById(R.id.imgbtn6);
        imgbtn7 = findViewById(R.id.imgbtn7);
        imgbtn8 = findViewById(R.id.imgbtn8);

        // TextView for displaying whose turn it is
        tvTurn = findViewById(R.id.tvTurn);

        // Button for returning to the previous screen or resetting the game
        btnReturn = findViewById(R.id.btnReturn);

        // Setting OnClickListener for the return button
        btnReturn.setOnClickListener(this);

        // Setting OnClickListener for each tic-tac-toe grid button
        imgbtn0.setOnClickListener(this);
        imgbtn1.setOnClickListener(this);
        imgbtn2.setOnClickListener(this);
        imgbtn3.setOnClickListener(this);
        imgbtn4.setOnClickListener(this);
        imgbtn5.setOnClickListener(this);
        imgbtn6.setOnClickListener(this);
        imgbtn7.setOnClickListener(this);
        imgbtn8.setOnClickListener(this);

        // TextView for displaying the game progress
        tvProgress = findViewById(R.id.tvProgress);
    }


    @Override
    public void onClick(View view) {

        // Check if the return button was clicked
        if (btnReturn == view) {
            // Player 1 won
            if (whoWin == 1) {
                setResult(44);
                finish();

            }
            // Player 2 won
            else if (whoWin == 2) {
                setResult(45);
                finish();
            }
            // The game was draw
            else if (whoWin == 0) {
                setResult(46);
                finish();
            }
            else {
                //default case
                finish();
            }
        }

        // Now for each button in the game i do the same: checking if the button was clicked, and if it was setting the making it invisible.
        //Then, i check if it was clicked i enter it to the board array. after this i check if it the final turn of the player and if not checking for game over options and continue the game

        if (view == imgbtn0 && canTakeInput){
            imgbtn0.setClickable(false);
            imgbtn0.setImageResource(R.drawable.efdsf);
            board[0][0] = 1;
            if (isfinalTurn() == true){
                gameOver();
            }
            else {
                gameOver();
                aiTurn();
            }
            canTakeInput = false;

        }
        if (view == imgbtn1 && canTakeInput){
            imgbtn1.setClickable(false);
            board[0][1] = 1;
            canTakeInput = false;
            imgbtn1.setImageResource(R.drawable.efdsf);
            if (isfinalTurn() == true){
                gameOver();
            }
            else {
                gameOver();
                aiTurn();
            }
        }
        if (view == imgbtn2 && canTakeInput){
            imgbtn2.setClickable(false);
            canTakeInput = false;
            board[0][2] = 1;
            imgbtn2.setImageResource(R.drawable.efdsf);
            if (isfinalTurn() == true){
                gameOver();
            }
            else {
                gameOver();
                aiTurn();
            }

        }
        if (imgbtn3 == view && canTakeInput){
            imgbtn3.setClickable(false);
            canTakeInput = false;
            board[1][0] = 1;
            imgbtn3.setImageResource(R.drawable.efdsf);
            if (isfinalTurn() == true){
                gameOver();
            }
            else {
                gameOver();
                aiTurn();
            }
        }
        if (imgbtn4 == view && canTakeInput){
            imgbtn4.setClickable(false);
            canTakeInput = false;
            board[1][1] = 1;
            imgbtn4.setImageResource(R.drawable.efdsf);
            if (isfinalTurn() == true){
                gameOver();
            }
            else {
                gameOver();
                aiTurn();
            }
        }
        if (imgbtn5 == view && canTakeInput){
            imgbtn5.setClickable(false);
            canTakeInput = false;
            board[1][2] = 1;
            imgbtn5.setImageResource(R.drawable.efdsf);
            if (isfinalTurn() == true){
                gameOver();
            }
            else {
                gameOver();
                aiTurn();
            }


        }
        if (imgbtn6 == view && canTakeInput){
            imgbtn6.setClickable(false);
            canTakeInput = false;
            board[2][0] = 1;
            imgbtn6.setImageResource(R.drawable.efdsf);
            if (isfinalTurn() == true){
                gameOver();
            }
            else {
                gameOver();
                aiTurn();
            }

        }
        if (imgbtn7 == view && canTakeInput){
            canTakeInput = false;
            imgbtn7.setClickable(false);
            board[2][1] = 1;
            imgbtn7.setImageResource(R.drawable.efdsf);
            if (isfinalTurn() == true){
                gameOver();
            }
            else {
                gameOver();
                aiTurn();
            }


        }
        if (imgbtn8 == view && canTakeInput){
            canTakeInput = false;
            imgbtn8.setClickable(false);
            board[2][2] = 1;
            imgbtn8.setImageResource(R.drawable.efdsf);
            if (isfinalTurn() == true){
                gameOver();
            }
            else {
                gameOver();
                aiTurn();
            }


        }

    }

    //Building the opponent turn
    private void aiTurn() {
        // Set the initial AI move image
        imgXO.setImageResource(R.drawable.fsd);

        // Delay the AI move to simulate thinking time
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                // Generate random positions for the AI move
                int aiPic1 = (int) (Math.random() * 3);
                int aiPic2 = (int) (Math.random() * 3);

                // Ensure the chosen position is not already taken
                while (board[aiPic1][aiPic2] == 1 || board[aiPic1][aiPic2] == 2) {
                    aiPic1 = (int) (Math.random() * 3);
                    aiPic2 = (int) (Math.random() * 3);
                }

                // Set the AI move image after decision
                imgXO.setImageResource(R.drawable.efdsf);

                // Calculate the position on the board
                int placeOnBoard = aiPic1 * 3 + aiPic2;
                String btnName = "imgbtn" + placeOnBoard;

                // Perform the AI move on the corresponding button and update the board
                canTakeInput = true;

                if (btnName.equals("imgbtn0") && canTakeInput) {
                    imgbtn0.setClickable(false);
                    imgbtn0.setImageResource(R.drawable.fsd);
                    board[0][0] = 2;
                    canTakeInput = true;
                    //checking if the game is over
                    gameOver();
                }
                if (btnName.equals("imgbtn1")) {
                    imgbtn1.setClickable(false);
                    imgbtn1.setImageResource(R.drawable.fsd);
                    board[0][1] = 2;
                    canTakeInput = true;
                    gameOver();

                }
                if (btnName.equals("imgbtn2")) {
                    imgbtn2.setClickable(false);
                    imgbtn2.setImageResource(R.drawable.fsd);
                    board[0][2] = 2;
                    canTakeInput = true;
                    gameOver();
                }
                if (btnName.equals("imgbtn3")) {
                    imgbtn3.setClickable(false);
                    imgbtn3.setImageResource(R.drawable.fsd);
                    board[1][0] = 2;
                    canTakeInput = true;
                    gameOver();
                }
                if (btnName.equals("imgbtn4")) {
                    imgbtn4.setClickable(false);
                    imgbtn4.setImageResource(R.drawable.fsd);
                    board[1][1] = 2;
                    canTakeInput = true;
                    gameOver();
                }
                if (btnName.equals("imgbtn5")) {
                    imgbtn5.setClickable(false);
                    imgbtn5.setImageResource(R.drawable.fsd);
                    board[1][2] = 2;
                    canTakeInput = true;
                    gameOver();
                }
                if (btnName.equals("imgbtn6")) {
                    imgbtn6.setClickable(false);
                    imgbtn6.setImageResource(R.drawable.fsd);
                    board[2][0] = 2;
                    canTakeInput = true;
                    gameOver();
                }
                if (btnName.equals("imgbtn7")) {
                    imgbtn7.setClickable(false);
                    imgbtn7.setImageResource(R.drawable.fsd);
                    board[2][1] = 2;
                    canTakeInput = true;
                    gameOver();
                }
                if (btnName.equals("imgbtn8")) {
                    imgbtn8.setClickable(false);
                    imgbtn8.setImageResource(R.drawable.fsd);
                    board[2][2] = 2;
                    canTakeInput = true;
                    gameOver();
                }
            }
        }
        , 500); // Delay of 200 milliseconds

    }

    // checking for all winning options
    private void gameOver(){

        // checking if the player won

        if (board[0][0]== 1 && board[0][1]== 1 && board[0][2]== 1){
            playerWin();
        }
         else if (board[1][0]== 1 && board[1][1]== 1 && board[1][2]== 1){
            playerWin();
        }
         else if (board[2][0]== 1 && board[2][1]== 1 && board[2][2]== 1){
            playerWin();
        }
         else if (board[0][0]== 1 && board[1][0]== 1 && board[2][0]== 1){
            playerWin();
        }
         else if (board[0][1]== 1 && board[1][1]== 1 && board[2][1]== 1){
            playerWin();
        }
         else if (board[0][2]== 1 && board[1][2]== 1 && board[2][2]== 1){
            playerWin();
        }
         else if (board[0][0]== 1 && board[1][1]== 1 && board[2][2]== 1){
            playerWin();
        }
         else if (board[0][2]== 1 && board[1][1]== 1 && board[2][0]== 1){
            playerWin();
        }

        //checking if the opponents won

         else if (board[0][0]== 2 && board[0][1]== 2 && board[0][2]== 2){
            aiWin();
        }
         else if (board[1][0]== 2 && board[1][1]== 2 && board[1][2]== 2){
            aiWin();
        }
         else if (board[2][0]== 2 && board[2][1]== 2 && board[2][2]== 2){
            aiWin();
        }
         else if (board[0][0]== 2 && board[1][0]== 2 && board[2][0]== 2){
            aiWin();
        }
         else if (board[0][1]== 2 && board[1][1]== 2 && board[2][1]== 2){
            aiWin();
        }
         else if (board[0][2]== 2 && board[1][2]== 2 && board[2][2]== 2){
            aiWin();
        }
         else if (board[0][0]== 2 && board[1][1]== 2 && board[2][2]== 2){
            aiWin();
        }
         else if (board[0][2]== 2 && board[1][1]== 2 && board[2][0]== 2){
            aiWin();
        }

         // checking for draw option

         else if ((board[0][0] == 1 || board[0][0] == 2) && (board[0][1] == 1 || board[0][1] == 2) &&
                (board[0][2] == 1 || board[0][2] == 2) && (board[1][0] == 1 || board[1][0] == 2) &&
                (board[1][1] == 1 || board[1][1] == 2) && (board[1][2] == 1 || board[1][2] == 2) &&
                (board[2][0] == 1 || board[2][0] == 2) && (board[2][1] == 1 || board[2][1] == 2) &&
                (board[2][2] == 1 || board[2][2] == 2 )){

             draw();
        }

    }

    //checking if it is the last turn in the game
    private boolean isfinalTurn(){
        // checking if there is last place left on the board

        if(board[0][0] +board[0][1] + board[0][2] + board[1][0] + board[1][1] +
                board[1][2] + board[2][0] + board[2][1] + board[2][2] == 13){

            return true;

        }
        else return false;
    }

    //handling draw option
    private void draw(){

        //clearing th board
        dissapearAll();
        //setting the text to draw
        tvTurn.setText("draw");
        imgXO.setImageResource(R.drawable.dsf);
        //setting the winner to no one
        whoWin =0;

    }
    //handling opponent winning option
    private void aiWin() {
        //clearing th board
        dissapearAll();
        imgXO.setImageResource(R.drawable.fsd);
        //setting the winner to the ai
        whoWin =2;


    }
    //handling player winning option
    private void playerWin() {
        //clearing the board
        dissapearAll();
        imgXO.setImageResource(R.drawable.efdsf);
        //setting the winner to the player
        whoWin =1;

    }
    //disappearing everything
    private void dissapearAll() {
        imgbtn0.setVisibility(View.INVISIBLE);
        imgbtn1.setVisibility(View.INVISIBLE);
        imgbtn2.setVisibility(View.INVISIBLE);
        imgbtn3.setVisibility(View.INVISIBLE);
        imgbtn4.setVisibility(View.INVISIBLE);
        imgbtn5.setVisibility(View.INVISIBLE);
        imgbtn6.setVisibility(View.INVISIBLE);
        imgbtn7.setVisibility(View.INVISIBLE);
        imgbtn8.setVisibility(View.INVISIBLE);
        tvTurn.setText("Winner: ");
        tvProgress.setVisibility(View.INVISIBLE);
        btnReturn.setVisibility(View.VISIBLE);


    }
}
