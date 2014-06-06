package uk.ac.aber.dcs.mfc1.eisteddfod.twentyfourteen;

public class Tracker {

	static private int currentLessonId = 1;
	
	static public int getCurrentLessonId() {
		return currentLessonId;
	}
	
	static public void setCurrentLessonId(final int currentLessonId) {
		Tracker.currentLessonId = currentLessonId;
	}
	
	private Tracker() {}
	
}
