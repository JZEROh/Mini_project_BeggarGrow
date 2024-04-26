package 거지키우기;


public class Save {
	
	private String currentID;

	public String getCurrentID() {
		return currentID;
	}

	public void setCurrentID(String currentID) {
		this.currentID = currentID;
	}
	
	public Save(String currentID) {
		super();
		this.currentID = currentID;
	}
//
	public String Save() {
		return currentID;
	}
	
}
