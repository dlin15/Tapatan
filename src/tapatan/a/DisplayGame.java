package tapatan.a;


import android.os.Bundle;
import android.support.v4.app.NavUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.app.Activity;


public class DisplayGame extends Activity{
	boolean p1 = true;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_board);
    }   

    // The dropping pieces round of game
    public void onClick(View v) {
    	// Player one's turn to drop piece
    	if (p1 && v.getTag() == null) {
    		v.setBackgroundResource(R.drawable.movable_player1);
    		v.setTag("player1"); // Gives button a tag to show this piece belong's to player 1
    		p1 = !p1;
    	} else if (!p1 && v.getTag() == null) { // Player two's turn to drop piece
    		v.setBackgroundResource(R.drawable.movable_player2);
    		v.setTag("player2"); // Gives button a tag to show this piece belong's to player 2
    		p1 = !p1;
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
