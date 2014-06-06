package uk.ac.aber.dcs.mfc1.eisteddfod.twentyfourteen;

import uk.ac.aber.dcs.mfc1.eisteddfod.twentyfourteen.db.Lesson;

import android.os.Bundle;
import android.app.Activity;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;

public class LessonPickerActivity extends Activity {

	LessonListAdapter lessonAdapter;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.list_window);		
		
		lessonAdapter = new LessonListAdapter(getBaseContext(),
								Lesson.getAllLessons(getBaseContext()));
		
		ListView listView = (ListView)findViewById(R.id.generic_list);
		listView.setAdapter(lessonAdapter);
		
		listView.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> arg0, 
											View arg1, int arg2, long arg3) {
				
				Lesson l = (Lesson)lessonAdapter.getItem(arg2);
				Tracker.setCurrentLessonId(l.getLessonNumber());
				finish();
				
			}
			
		});
		
	}

}
