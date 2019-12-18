
package co.grandcircus.GCFinalProject.dndpojos;

public class Cost {

	private int quantity;
	private String unit;
	
	public Cost() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Cost(int quantity, String unit) {
		super();
		this.quantity = quantity;
		this.unit = unit;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}
	
}
