package uk.ac.aber.dcs.mfc1.eisteddfod.twentyfourteen;

import java.util.ArrayList;

import uk.ac.aber.dcs.mfc1.eisteddfod.twentyfourteen.db.Lesson;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

/**
 * Phrase List Adapter is used to hold a collection of phrases.
 * 
 * @author Michael Clarke <mfc1@aber.ac.uk>
 * @version 0.1
 */
public class LessonListAdapter extends BaseAdapter {
	
	private ArrayList<Lesson> lessons;
	private LayoutInflater inflater;
	
	public LessonListAdapter(Context context, ArrayList<Lesson> lessons) {
		
		super();
		this.lessons = lessons;
		inflater = (LayoutInflater)context.getSystemService(
									Context.LAYOUT_INFLATER_SERVICE);
		
	}
	

	
	public int getCount() {
		
		return lessons.size();
		
	}
	
	public Object getItem(int position) {
		
		return lessons.get(position);
		
	}
	
	public long getItemId(int position) {
		
		return position;
		
	}
	
	public View getView(int position, View view, ViewGroup viewGroup) {
		
		TextView lessonName;
		
		view = inflater.inflate(R.layout.lesson_list_item, null);
		lessonName = (TextView) view.findViewById(R.id.lessonName);
		Lesson lesson = lessons.get(position);
		lessonName.setText(lesson.getLessonTitle());
		return view;

	}

	public void clear() {
		lessons.clear();
		
	}
	

}
