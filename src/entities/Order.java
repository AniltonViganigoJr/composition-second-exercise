package entities;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import entities.enums.OrderStatus;

public class Order {

	private LocalDateTime moment;
	private OrderStatus status;
	
	private Client client;
	private List<OrderItem> orders = new ArrayList<OrderItem>();
	
	public Order() {
	}

	public Order(LocalDateTime moment, OrderStatus status, Client client) {
		this.moment = moment;
		this.status = status;
		this.client = client;
	}

	public LocalDateTime getMoment() {
		return moment;
	}

	public void setMoment(LocalDateTime moment) {
		this.moment = moment;
	}

	public OrderStatus getStatus() {
		return status;
	}

	public void setStatus(OrderStatus status) {
		this.status = status;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public List<OrderItem> getOrders() {
		return orders;
	}
	
	public void addItem(OrderItem item) {
		orders.add(item);
	}
	
	public void removeItem(OrderItem item) {
		orders.remove(item);
	}
	
	public double total() {
		double sum = 0.0;
		for(OrderItem item : orders) {
			sum += item.subTotal();
		}
		return sum;
	}
	
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("\tOrder moment:" + moment.format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss")) + "\n");
		sb.append("\tOrder Status:" + status + "\n");
		sb.append("\t" + client.toString() +"\n");
		sb.append("\t*Order Items*\n");
		for(OrderItem item : orders) {
			sb.append("\t" + item.toString());
		}
		sb.append("TOTAL PRICE: $" + String.format("%.2f", total()));
		return sb.toString();
	}
}