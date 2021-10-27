
public class Property {

	private String city;
	private String owner;
	private String propertyName;
	private double rentAmount;
	private Plot plot;
	
	public Property() {
		this.owner = "";
		this.city = "";
		this.propertyName = "";
		this.rentAmount = 0.0;
		this.plot = new Plot();
	}
	
	public Property(Property p){
		
		this.owner = p.getOwner();
		this.city = p.getCity();
		this.propertyName = p.getPropertyName();
		this.rentAmount = p.getRentAmount();
		this.setPlot(p.getPlot().getX(), p.getPlot().getY(), p.getPlot().getWidth(), p.getPlot().getDepth());
	}
	
	public Property(String propertyName, String city, double rentAmount, String owner) {
		this.propertyName = propertyName;
		this.city = city;
		this.rentAmount = rentAmount;
		this.owner = owner;
		this.setPlot(0, 0, 1, 1);
	}
	
	public Property(String propertyName, String city, double rentAmount, String owner, int x, int y, int width, int depth) {
		this.propertyName = propertyName;
		this.city = city;
		this.rentAmount = rentAmount;
		this.owner = owner;
		this.setPlot(x, y, width, depth);
	}
	
	public Plot getPlot() {
		return plot;
	}
	
	public String getCity() {
		return city;
	}
	
	public String getOwner() {
		return owner;
	}
	
	public String getPropertyName() {
		return propertyName;
	}
	
	public double getRentAmount() {
		return rentAmount;
	}
	
	public void setPlot(int x, int y, int width, int depth) {
		plot = new Plot(x, y, width, depth);
	}
	
	public void setCity(String city) {
		this.city = city;
	}
	
	public void setPropertyName(String propertyName) {
		this.propertyName = propertyName;
	}
	
	public void setRentAmount(double rentAmount) {
		this.rentAmount = rentAmount;
	}
	
	public String toString() {
		return "Property Name: " + propertyName +  "\nLocated in " + city + "\nBleonging to: " + owner + "\nRent Amount: " + rentAmount;
	}
	
}
