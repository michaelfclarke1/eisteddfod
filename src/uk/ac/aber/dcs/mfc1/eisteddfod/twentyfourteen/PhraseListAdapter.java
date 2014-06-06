package uk.ac.aber.dcs.mfc1.eisteddfod.twentyfourteen;

import java.util.ArrayList;

import uk.ac.aber.dcs.mfc1.eisteddfod.twentyfourteen.db.Phrase;
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
public class PhraseListAdapter extends BaseAdapter {
	
	private ArrayList<Phrase> phrases;
	private LayoutInflater inflater;
	
	public PhraseListAdapter(Context context, ArrayList<Phrase> phrases) {
		
		super();
		this.phrases = phrases;
		inflater = (LayoutInflater)context.getSystemService(
									Context.LAYOUT_INFLATER_SERVICE);
		
	}
	

	
	public int getCount() {
		
		return phrases.size();
		
	}
	
	public Object getItem(int position) {
		
		return phrases.get(position);
		
	}
	
	public long getItemId(int position) {
		
		return position;
		
	}
	
	public View getView(int position, View view, ViewGroup viewGroup) {
		
		TextView welshText;
		TextView englishText;
		
		view = inflater.inflate(R.layout.phrase_list_item, null);
		
		welshText     = (TextView) view.findViewById(R.id.welshText);
		englishText   = (TextView) view.findViewById(R.id.englishText);
		
		Phrase phrase = phrases.get(position);
		
		welshText.setText(phrase.getNorth());
		englishText.setText(phrase.getEnglish());
		
		return view;

	}

	public void clear() {
		phrases.clear();
		
	}



	public void setPhraseList(ArrayList<Phrase> phrases) {
this.phrases = phrases;
		
	}
	

}
