package uk.ac.aber.dcs.mfc1.eisteddfod.twentyfourteen;

import java.util.ArrayList;

import uk.ac.aber.dcs.mfc1.eisteddfod.twentyfourteen.db.About;

import android.os.Bundle;
import android.app.Activity;

import android.widget.ListView;

public class AboutActivity extends Activity {

	AboutListAdapter aboutAdapter;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.about_window);		
		
		ArrayList<About> aboutList = new ArrayList<About>();
		
		aboutList.add(new About("Welcome", "Introduction to the Eisteddfod"));
		aboutList.add(new About("Visitor Center", "Arriving at the Eisteddfod"));
		aboutList.add(new About("The Maes", "What to see at the Eisteddfod"));
		
		aboutAdapter = new AboutListAdapter(getBaseContext(), aboutList);	
		ListView listView = (ListView)findViewById(R.id.about_list);
		listView.setAdapter(aboutAdapter);
				
	}

}
