package entities;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import entities.enums.OrderStatus;

public class Order {

	private static DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
	
	private LocalDateTime moment;
	private OrderStatus status;
	private Client client;
	private List<OrderItem> items = new ArrayList<>();

	public Order(LocalDateTime moment, OrderStatus status, Client client) {
		this.moment = moment;
		this.status = status;
		this.client = client;
	}

	public Order() {

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
	
	public void addItems (OrderItem item) {
		items.add(item);
	}
	
	public void removeItems (OrderItem item) {
		items.remove(item);
	}
	
	public double totalPrice() {
		double sum = 0;
		
		for(OrderItem i : items) {
			sum += i.subTotal();
		}
		
		return sum;
	}
	
	public String toString() {
		
		StringBuilder sb = new StringBuilder();
		sb.append("ORDER SUMMARY:\n");
		sb.append("order moment: " + moment.format(dtf) + "\n");
		sb.append("order status: " + status + "\n");
		sb.append("Client: " + client);
		sb.append("Order items: \n");
		for(OrderItem i : items) {
			if(i != null) {
				sb.append(i + "\n");
			}
		}
		
		sb.append("Total price: $" + String.format("%.2f", totalPrice()));
		
		return sb.toString();
	}
}
