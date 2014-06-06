package uk.ac.aber.dcs.mfc1.eisteddfod.twentyfourteen.db;

import java.util.ArrayList;

import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.media.MediaPlayer;
import android.util.Log;

public class Phrase {

	private static final String TAG = "PhraseClass";
	private static final String DATABASE_NAME = "WelshDB";
	
	private int id;
	private int lessonNumber;
	private String english;
	private String welsh;
	private String north;
	private String audio;
	
	public static Phrase getPhrase(final Context context, final int id) {

		Phrase p = new Phrase();
		p.setId(id);

		DatabaseController controller = 
					DatabaseController.getInstance(context, DATABASE_NAME);


		try {
			
			p.setLessonNumber(
					controller.getIntegerWithQuery("Phrases", "LessonNum", 
											"Id=?", new String[] { "" + id }));
			
			p.setEnglish(
					controller.getStringWithQuery("Phrases", "English",
											"Id=?", new String[] { "" + id }));
			
			p.setWelsh(
					controller.getStringWithQuery("Phrases", "Welsh", 
											"Id=?",	new String[] { "" + id }));
			
			p.setAudio(
					controller.getStringWithQuery("Phrases", "Audio", 
											"Id=?", new String[] { "" + id }));
			
		} catch (DataNotFoundException dnfe) {

			Log.e(TAG, "Lesson not found.");
			p = null;

		}
		
		try {
			
			p.setNorth(
					controller.getStringWithQuery("Phrases", "North", 
											"id=?", new String[] {"" + id }));
			
		} catch (DataNotFoundException dnfe) {
			
			p.setNorth(p.getWelsh());
			
		}
		
		if (p.getNorth().equalsIgnoreCase(""))
			p.setNorth(p.getWelsh());

		return p;

	}
	
	public static ArrayList<Phrase> getPhraseByLessonNumber(
							final Context context, final int lessonNumber) {
		
		ArrayList<Integer> ids = null;
		ArrayList<Phrase> phrases = new ArrayList<Phrase>();
		
		DatabaseController controller = 
				DatabaseController.getInstance(context, DATABASE_NAME);
		
		
		try {
			
			ids = controller.getIntegerArrayWithQuery("Phrases", "Id", 
					"LessonNum=?", new String[] { "" + lessonNumber } );
			
			
		} catch (DataNotFoundException dnfe) {
			Log.e(TAG, "No phrases for the lesson number provided.");
		}
		
		if (ids != null) { 
			for (int i = 0; i < ids.size(); i++) {
				
				Phrase p = Phrase.getPhrase(context, ids.get(i));
				if (p != null) phrases.add(p);
				
			}
		}
				
		return phrases;
		
	}
	
	private void setId(final int id) {
		this.id = id;
	}
	
	public final int getId() {
		return this.id;
	}
	
	private void setLessonNumber(final int lessonNumber) {
		this.lessonNumber = lessonNumber;
	}
	
	public final int getLessonNumber() {
		return this.lessonNumber;
	}
	
	private void setEnglish(final String english) {
		this.english = english;
	}
	
	public final String getEnglish() {
		return this.english;
	}
	
	private void setWelsh(final String welsh) {
		this.welsh = welsh;
	}
	
	public final String getWelsh() {
		return this.welsh;
	}
	
	private void setNorth(final String north) {
		this.north = north;
	}
	
	public final String getNorth() {
		return this.north;
	}
	
	private void setAudio(final String audio) {
		this.audio = audio;
	}
	
	public MediaPlayer getAudio(Context context) {
		
		MediaPlayer mp = new MediaPlayer();
		AssetFileDescriptor afd = null;
		
		if (audio == null)
			return null;
		
		try {
		
			afd = context.getAssets().openFd(audio);
			Log.i("Eisteddfod App", "Loading audio file: " + audio);
			if (afd != null) {
			
				mp.setDataSource(afd.getFileDescriptor(),
									afd.getStartOffset(),afd.getLength());
				
				mp.prepare();
			}
		
		} catch (Exception e) {
			Log.e("Eisteddfod App", "Error loading audio file: " + audio);
		}
		
		return mp;
		
	}
	
}
