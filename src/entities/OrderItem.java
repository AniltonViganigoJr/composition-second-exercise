package entities;

public class OrderItem {

	private Integer quantity;

	private Product product;
	
	public OrderItem() {
	}

	public OrderItem(Integer quantity,Product product) {
		this.quantity = quantity;
		this.product = product;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}
	
	public double subTotal() {
		return product.getPrice() * quantity;
	}
	
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Oder Items:\n");
		sb.append(product.getName() + ",");
		sb.append(product.getPrice() + ",$");
		sb.append("Quantity: " + quantity);
		sb.append(",Subtotal: $" + subTotal() + "\n");

		return sb.toString();
	}
}