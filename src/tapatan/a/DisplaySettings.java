package tapatan.a;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.NavUtils;
import android.view.MenuItem;

public class DisplaySettings extends Activity{

	 @Override
	    protected void onCreate(Bundle savedInstanceState) {
	        super.onCreate(savedInstanceState);
	        setContentView(R.layout.activity_settings);
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
