package uk.ac.aber.dcs.mfc1.eisteddfod.twentyfourteen.db;

import java.util.ArrayList;

import android.content.Context;
import android.util.Log;

public class Lesson {

	private static final String TAG = "LessonClass";
	private static final String DATABASE_NAME = "WelshDB";
	
	private int lessonNumber;
	private String lessonTitle;
	
	
	public static Lesson getLesson(final Context context, 
											final int lessonNumber) {
		
		Lesson l = new Lesson();
		l.setLessonNumber(lessonNumber);
		
		DatabaseController controller = 
				DatabaseController.getInstance(context, DATABASE_NAME);
		
		
		try {
			
			l.setLessonTitle(controller.getStringWithQuery("Lessons", 
			  "LessonTitle", "LessonNum=?", new String[] { ""+lessonNumber }));
			
		} catch (DataNotFoundException dnfe) {
			
			Log.e(TAG, "Lesson not found.");
			l = null;
			
		}
		
		return l;
		
	}
	
	public static ArrayList<Lesson> getAllLessons(final Context context) {
		
		ArrayList<Integer> ids = null;
		ArrayList<Lesson> lessons = new ArrayList<Lesson>();
		
		try {
			
			DatabaseController controller = 
					DatabaseController.getInstance(context, DATABASE_NAME);
			
			ids = controller.getOrderedIntegerArrayWithQuery("Lessons", 
									"LessonNum", null, null, "LessonNum");
			
			
		} catch (DataNotFoundException dnfe) {
			Log.e(TAG, "Unable to get list of lessons.");
		}
		
		if (ids != null) {
			
			for (int i = 0; i < ids.size(); i++) {
				
				Lesson temp = Lesson.getLesson(context, ids.get(i));
				if (temp != null) lessons.add(temp);
				
			}
			
		}
		
		return lessons;
		
	}
	
	private void setLessonNumber(final int lessonNumber) {
		this.lessonNumber = lessonNumber;
	}
	
	private void setLessonTitle(final String lessonTitle) {
		this.lessonTitle = lessonTitle;
	}
	
	public final int getLessonNumber() {
		return this.lessonNumber;
	}
	
	public final String getLessonTitle() {
		return this.lessonTitle;
	}
	
	private Lesson() { }
	
}
