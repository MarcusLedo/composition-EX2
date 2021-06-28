package entities;
import entities.enums.OrderStatus;
import java.util.List;
import java.util.ArrayList;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class Order {
	private LocalDate date;
	private LocalTime time;
	private OrderStatus status;
	private Client client;
	private List<OrderItem> order = new ArrayList<>();
	
	public Order(LocalDate date, LocalTime time, OrderStatus status, Client client) {
		this.date = date;
		this.time = time;
		this.status = status;
		this.client = client;
	}
	
	public Order() {
		
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public LocalTime getTime() {
		return time;
	}

	public void setTime(LocalTime time) {
		this.time = time;
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

	public List<OrderItem> getOrder() {
		return order;
	}
	
	public void addOrderItem(OrderItem order) {
		this.order.add(order);
	}
	
	public void removeOrderItem(OrderItem order) {
		this.order.remove(order);
	}
	
	public Double total() {
		double total = 0.0;
		for(OrderItem x : order)
			total += x.subTotal();
		return total;
	}
	
	@Override
	public String toString() {
		//Usamos a classe StringBuilder e o método append para concatenar strings
		//Isso é necessário, pois usar o método append é um método mais efeciente 
		//Para concatenar grandes strings
		StringBuilder sb = new StringBuilder();
		sb.append("Order moment: ");
		sb.append(date.format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
		sb.append(" " + time.format(DateTimeFormatter.ofPattern("HH:mm:ss")));
		sb.append("\n" + "Order status: " + status);
		sb.append("\nClient: " + client.getName() + "(" + client.getBirthDate().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")) + ")");
		sb.append(" - " + client.getEmail());
		sb.append("\n" + "Order Items:" + "\n");
		for(OrderItem x : order)
			sb.append(x + "\n");
		
		sb.append("Total Price: $" + total());
		
		return sb.toString();
	}
	
}
