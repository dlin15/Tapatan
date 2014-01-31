package tapatan.a;


import android.os.Bundle;
import android.support.v4.app.NavUtils;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.app.FragmentManager;
import android.content.DialogInterface;
import android.content.Intent;


public class DisplayGame extends Activity{
	//boolean p1 = true;
	private TextView player1Text;
    private TextView player2Text;
    private tapatanBoard board;	
    private int turn;
    private int firstClick;
    private static View lastClick;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_board);

        board = new tapatanBoard();
        player1Text = (TextView)findViewById(R.id.textView1);
        player2Text = (TextView)findViewById(R.id.textView2);
        
        // Initialize turn color
		player1Text.setBackgroundResource(R.color.lightBlue);
		player2Text.setBackgroundResource(R.color.white);
		
		turn = 0;
		firstClick = -1;
		lastClick = null;
    }   

public void onClick(View v){
	int position = Integer.parseInt(v.getTag().toString());
	if (turn <= 5 && board.place(position)) {	
		// Player one's turn to drop piece
		if (!board.getTurn()) { // End of player 1's turn
			v.setBackgroundResource(R.drawable.movable_player1);
			v.setVisibility(v.VISIBLE);
			
			// Highlight player 2's turn
			player1Text.setBackgroundResource(R.color.white);
			player2Text.setBackgroundResource(R.color.lightRed);
			
		} else { // End of player 2's turn
			v.setBackgroundResource(R.drawable.movable_player2);
			v.setVisibility(v.VISIBLE);
			
			// Highlight player 1's turn
			player1Text.setBackgroundResource(R.color.lightBlue);
			player2Text.setBackgroundResource(R.color.white);
		} 
		turn++;
	} 
	else{
		if(board.ownership(position)){
			firstClick = position;
			lastClick = v;
			return;
		}
		
			System.out.println(firstClick +" " + position);
		if(board.move(firstClick, position) && firstClick != -1){
			System.out.println("Your printing wrong!");
			lastClick.setVisibility(lastClick.INVISIBLE);
			if(!board.getTurn()){	
				v.setBackgroundResource(R.drawable.movable_player1);
				player1Text.setBackgroundResource(R.color.white);
				player2Text.setBackgroundResource(R.color.lightRed);
			}else{
				v.setBackgroundResource(R.drawable.movable_player2);
				player1Text.setBackgroundResource(R.color.lightBlue);
				player2Text.setBackgroundResource(R.color.white);
			}
			v.setVisibility(v.VISIBLE);
		}else{
			firstClick = -1;
			return;
		}
	}
	
	checkWin();
}


private void checkWin(){
	int check = board.checkWin();

	if(check == 0){
		return;
	} else{ 
		Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
	}		
}


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
        case android.R.id.home:
            NavUtils.navigateUpFromSameTask(this);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
