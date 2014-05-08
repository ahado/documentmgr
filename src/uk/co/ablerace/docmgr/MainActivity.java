package uk.co.ablerace.docmgr;

import android.app.*;
import android.os.*;
import android.view.*;
import android.widget.*;
import android.content.*;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;

public class MainActivity extends ActionBarActivity
{
	public static final String CURRENT_TOPIC = "currentTopic";
	String currentTopic = null;
	
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState)
	{
		
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
		
		SharedPreferences preferences = getPreferences(0);
		currentTopic = preferences.getString(CURRENT_TOPIC, null);
		
		ActionBar actionBar = getSupportActionBar();
		actionBar.setSubtitle(currentTopic);
    }

	@Override
	public boolean onCreateOptionsMenu(Menu menu)
	{
		MenuInflater inflater = getMenuInflater();
		inflater.inflate(R.menu.main_activity_actions, menu);
		return super.onCreateOptionsMenu(menu);
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item)
	{
		switch (item.getItemId()) {
			case R.id.action_new_topic:
				currentTopic = "TEST";
				SharedPreferences preferences = getPreferences(0);
				SharedPreferences.Editor editor = preferences.edit();
				editor.putString(CURRENT_TOPIC,currentTopic);
				editor.commit();
				ActionBar actionBar = getSupportActionBar();
				actionBar.setSubtitle(currentTopic);
				return true;
			case R.id.action_exit:
				finish();
				return true;
			default:
				return super.onOptionsItemSelected(item);
		}
	}

}
