
public class ManagementCompany {

	private final int MAX_PROPERTY = 5;
	private final int MGMT_WIDTH = 10;
	private final int MGMT_DEPTH = 10;
	
	private double mgmFeePer;
	private String name;
	private String taxID;
	private Property[] properties;
	
	private Plot plot;
	
	public ManagementCompany() {
		this.name = "";
		this.taxID = "";
		mgmFeePer = 0.0;
		this.properties = new Property[MAX_PROPERTY];
		this.plot = new Plot(0, 0, MGMT_WIDTH, MGMT_DEPTH);
	}
	
	public ManagementCompany(String name, String taxID, double mgmFee) {
		this.name = name;
		this.taxID = taxID;
		this.mgmFeePer = mgmFee;
		this.properties = new Property[MAX_PROPERTY];
		this.plot = new Plot(0, 0, MGMT_WIDTH, MGMT_DEPTH);
	}
	
	public ManagementCompany(String name, String taxID, double mgmFee, int x, int y, int width, int depth) {
		this.name = name;
		this.taxID = taxID;
		this.mgmFeePer = mgmFee;
		this.properties = new Property[MAX_PROPERTY];
		this.plot = new Plot(0, 0, MGMT_WIDTH, MGMT_DEPTH);
	}
	
	public ManagementCompany(ManagementCompany otherCompany) {
		this.name = otherCompany.getName();
		this.taxID = otherCompany.getTaxID();
		this.mgmFeePer = otherCompany.getMgmFeePer();
		this.properties = otherCompany.getProperties();
	}
	
	public double getMgmFeePer() {
		return mgmFeePer;
	}
	
	public String getName() {
		return name;
	}
	
	public String getTaxID() {
		return taxID;
	}
	
	public int getMAX_PROPERTY() {
		return MAX_PROPERTY;
	}
	
	public Property[] getProperties() {
		return properties;
	}
	
	public Plot getPlot() {
		return plot;
	}
	
	public void setPlot() {
		this.plot = new Plot();
	}
	
	public void setPlot(Plot p) {
		this.plot = new Plot(p);
	}
	
	public void setPlot(int x, int y, int width, int depth) {
		this.plot = new Plot(x, y, width, depth);
	}
	
	public int addProperty(Property property) {
		//adds a property to the array and/or returns an int with what happened
		boolean isFull = true;
		boolean overlaps = false;
		int firstNull = -1;
		
		
		for(int i = 0; i < MAX_PROPERTY; i++) {
			if(properties[i] == null) {
				isFull = false;
				firstNull = i;
				i = MAX_PROPERTY;
			}
			else if(properties[i].getPlot().overlaps(property.getPlot())) {
				overlaps = true;
				i = MAX_PROPERTY;
			}
		}
		
		if(isFull)
			return -1;
		else if(property.getCity() == null)
			return -2;
		else if(!plot.encompasses(property.getPlot()))
			return -3;
		else if(overlaps)
			return -4;
		else {
			properties[firstNull] = property;
			return firstNull;
		}
	}
	
	public int addProperty(String name, String city, double rent, String owner) {
		//adds a property to the array and/or returns an int with what happened
		Property property = new Property(name, city, rent, owner);
		
		boolean isFull = true;
		boolean overlaps = false;
		int firstNull = -1;
		
		
		for(int i = 0; i < MAX_PROPERTY; i++) {
			if(properties[i] == null) {
				isFull = false;
				firstNull = i;
				i = MAX_PROPERTY;
			}
			else if(properties[i].getPlot().overlaps(property.getPlot())) {
				overlaps = true;
				i = MAX_PROPERTY;
			}
		}
		
		if(isFull)
			return -1;
		else if(property.getCity() == null)
			return -2;
		else if(!plot.encompasses(property.getPlot()))
			return -3;
		else if(overlaps)
			return -4;
		else {
			properties[firstNull] = property;
			return firstNull;
		}
	}
	
	public int addProperty(String name, String city, double rent, String owner, int x, int y, int width, int depth) {
		//adds a property to the array and/or returns an int with what happened
		Property property = new Property(name, city, rent, owner, x, y, width, depth);
		
		boolean isFull = true;
		boolean overlaps = false;
		int firstNull = -1;
		
		
		for(int i = 0; i < MAX_PROPERTY; i++) {
			if(properties[i] == null) {
				isFull = false;
				firstNull = i;
				i = MAX_PROPERTY;
			}
			else if(properties[i].getPlot().overlaps(property.getPlot())) {
				overlaps = true;
			}
		}
		
		if(isFull)
			return -1;
		else if(property.getCity() == null)
			return -2;
		else if(!plot.encompasses(property.getPlot()))
			return -3;
		else if(overlaps)
			return -4;
		else {
			properties[firstNull] = property;
			return firstNull;
		}
	}
	
	public String displayPropertyAtIndex(int i) {
		return properties[i].toString();
	}
	
	public double maxRentProp() {
		int maxIndex = maxRentPropertyIndex();
		return properties[maxIndex].getRentAmount();
	}
	
	private int maxRentPropertyIndex() {
		int index = -1;
		double temp = 0.0;
		for(int i = 0; i < properties.length; i++) {
			if(properties[i] == null)
				continue;
			else if(properties[i].getRentAmount() > temp) {
				temp = properties[i].getRentAmount();
				index = i;
			}
		}
		return index;
	}
	
	public double totalRent() {
		//returns the total property rent of all properties in array
		double total = 0.0;
		for(int i = 0; i < properties.length; i++) {
			if(properties[i] == null)
				continue;
			total += properties[i].getRentAmount();
		}
		return total;
	}
	
	public String toString() {
		String output = "List of the properties for " + name + ", taxID: " + taxID +"\n";
		for(int i = 0; i < 55; i++) {
			output += "_";
		}
		output += "\n";
		for(int i = 0; i < properties.length; i++) {
			output += properties[i].toString();
			output += "\n";
		}
		for(int i = 0; i < 55; i++) {
			output += "_";
		}
		output += "\nTotal Management Fee: " + (this.totalRent() * mgmFeePer);
		return output;
	}
	
}
