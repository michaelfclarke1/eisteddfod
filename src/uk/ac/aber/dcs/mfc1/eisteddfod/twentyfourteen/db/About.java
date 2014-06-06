package uk.ac.aber.dcs.mfc1.eisteddfod.twentyfourteen.db;

public class About {

	private String headingText;
	private String descriptionText;
	
	public About(final String headingText, final String descriptionText) {
		this.setHeadingText(headingText);
		this.setDescriptionText(descriptionText);
	}
	
	private void setHeadingText(final String headingText) {
		this.headingText = headingText;
	}
	
	private void setDescriptionText(final String descriptionText) {
		this.descriptionText = descriptionText;
	}
	
	public final String getHeadingText() {
		return this.headingText;
	}
	
	public final String getDescriptionText() {
		return this.descriptionText;
	}
	
}
