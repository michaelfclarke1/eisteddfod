package uk.ac.aber.dcs.mfc1.eisteddfod.twentyfourteen;

import java.util.ArrayList;

import uk.ac.aber.dcs.mfc1.eisteddfod.twentyfourteen.db.About;
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
public class AboutListAdapter extends BaseAdapter {
	
	private ArrayList<About> aboutList;
	private LayoutInflater inflater;
	
	public AboutListAdapter(Context context, ArrayList<About> aboutList) {
		
		super();
		this.aboutList = aboutList;
		inflater = (LayoutInflater)context.getSystemService(
									Context.LAYOUT_INFLATER_SERVICE);
		
	}
	

	
	public int getCount() {
		
		return aboutList.size();
		
	}
	
	public Object getItem(int position) {
		
		return aboutList.get(position);
		
	}
	
	public long getItemId(int position) {
		
		return position;
		
	}
	
	public View getView(int position, View view, ViewGroup viewGroup) {
		
		TextView headingText;
		TextView descriptionText;
		
		view = inflater.inflate(R.layout.about_list_item, null);
		
		headingText     = (TextView) view.findViewById(R.id.headingText);
		descriptionText = (TextView) view.findViewById(R.id.descriptionText);
		
		About about = aboutList.get(position);
		
		headingText.setText(about.getHeadingText());
		descriptionText.setText(about.getDescriptionText());
		
		return view;

	}

	public void clear() {
		aboutList.clear();
		
	}

	

}
