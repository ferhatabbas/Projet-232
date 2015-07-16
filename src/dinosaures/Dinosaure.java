package dinosaures;
import java.util.HashMap;

public class Dinosaure {
	
	protected HashMap<String, Object> AttributesList;
	public int dinosaureID;
	
	public Dinosaure()
	{
		AttributesList = new HashMap<String, Object>();
	}
	
	public Dinosaure(int dinosaureID)
	{
		setDinosaureID(dinosaureID);
		AttributesList = new HashMap<String, Object>();
	}

	public int getDinosaureID() {
		return dinosaureID;
	}

	public void setDinosaureID(int dinosaureID) {
		this.dinosaureID = dinosaureID;
	}

	public HashMap<String, Object> getListeAttribute() {
		return AttributesList;
	}
	
	public void setAttributesList(HashMap<String, Object> listeAttribute) {
		this.AttributesList = listeAttribute;
	}
	
	public Object getAttribute(String attributeName)
	{
		return AttributesList.get(attributeName);
	}
	
	public void setAttributlist(String attributeName, Object value)
	{
		AttributesList.put(attributeName, value);
	}
	
	
	public boolean equals(Object otherDinosaure)
	{
		if (otherDinosaure instanceof Dinosaure)
		{
			Dinosaure dinosaure = (Dinosaure) otherDinosaure;
			return dinosaureID == dinosaure.getDinosaureID() && 
					AttributesList.equals(dinosaure.getListeAttribute());
		}
		else
		{
			return false;
		}
	}
}
