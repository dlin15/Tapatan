package tapatan.a;


import android.os.Bundle;
import android.support.v4.app.NavUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.app.Activity;


public class DisplayGame extends Activity{
	boolean p1 = true;
	TextView player1Text;
    TextView player2Text;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_board);
        player1Text = (TextView)findViewById(R.id.textView1);
        player2Text = (TextView)findViewById(R.id.textView2);
        
        // Initialize turn color
		player1Text.setBackgroundResource(R.color.lightBlue);
		player2Text.setBackgroundResource(R.color.white);
    }   

    // The dropping pieces round of game
    public void onClick(View v) {
    	// Player one's turn to drop piece
    	if (p1 && v.getTag() == null) {
    		v.setBackgroundResource(R.drawable.movable_player1);
    		v.setTag("player1"); // Gives button a tag to show this piece belong's to player 1
    		p1 = !p1;
    		
    		// Highlight player 2's turn
    		player1Text.setBackgroundResource(R.color.white);
    		player2Text.setBackgroundResource(R.color.lightRed);
    		
    	} else if (!p1 && v.getTag() == null) { // Player two's turn to drop piece
    		v.setBackgroundResource(R.drawable.movable_player2);
    		v.setTag("player2"); // Gives button a tag to show this piece belong's to player 2
    		p1 = !p1;
    		
    		// Highlight player 1's turn
    		player1Text.setBackgroundResource(R.color.lightBlue);
    		player2Text.setBackgroundResource(R.color.white);
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
