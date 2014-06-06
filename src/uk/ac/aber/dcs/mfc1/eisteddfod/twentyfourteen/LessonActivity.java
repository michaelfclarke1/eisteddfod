package uk.ac.aber.dcs.mfc1.eisteddfod.twentyfourteen;

import uk.ac.aber.dcs.mfc1.eisteddfod.twentyfourteen.db.Phrase;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;

public class LessonActivity extends Activity {

	PhraseListAdapter phraseAdapter;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.list_window);
		
		phraseAdapter = new PhraseListAdapter(getBaseContext(), 
				Phrase.getPhraseByLessonNumber(getBaseContext(), 
										Tracker.getCurrentLessonId()));
		
		final ListView listView = (ListView)findViewById(R.id.generic_list);
		listView.setAdapter(phraseAdapter);
		this.getActionBar().setDisplayHomeAsUpEnabled(true);
		
		this.setTitle("Lesson " + Tracker.getCurrentLessonId());
		
		listView.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> arg0, 
											View arg1, int arg2, long arg3) {
		
				/* Play sound */
				
			}
			
		});
		
	}
	
	public boolean onOptionsItemSelected(MenuItem item) {
		
		if (item.getItemId() == android.R.id.home) {
	        Intent i = new Intent(getApplicationContext(), LessonPickerActivity.class);
	        startActivity(i);
	        this.overridePendingTransition(0, 0);
	        return true;
		}
		
		return super.onOptionsItemSelected(item);
		
	}
	
	public void onResume() {
		
        super.onResume();
		
		this.overridePendingTransition(0, 0);
		
		phraseAdapter.setPhraseList(
			Phrase.getPhraseByLessonNumber(getBaseContext(), 
									Tracker.getCurrentLessonId()));
		phraseAdapter.notifyDataSetChanged();
		this.setTitle("Lesson " + Tracker.getCurrentLessonId());
		
	}
	
}
