package application;

import java.util.Scanner;

import entities.*;
import entities.enums.OrderStatus;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Locale;

public class Main {
	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);

		System.out.println("**********CLIENT**********");
		System.out.print("-> Name: ");
		String name = sc.nextLine();
		System.out.print("-> Email: ");
		String email = sc.nextLine();
		System.out.print("-> Birth Date (yyyy-MM-dd): ");
		LocalDate birthDate = LocalDate.parse(sc.nextLine());
		Client client = new Client(name, email, birthDate);
		
		System.out.println();

		System.out.println("**********ORDER DATA**********");
		System.out.print("-> Status: ");
		String status = sc.nextLine();
		Order order = new Order(LocalDate.now(), LocalTime.now(), OrderStatus.valueOf(status), client);

		System.out.print("-> Item quantity: ");
		int N = sc.nextInt();
		for (int i = 0; i < N; i++) {
			System.out.println("Product " + (i + 1));
			System.out.print("-> Product name: ");
			sc.nextLine();
			String productName = sc.nextLine();
			System.out.print("-> Product Price: ");
			double price = sc.nextDouble();
			System.out.print("-> Quantity: ");
			int quantity = sc.nextInt();
			OrderItem orderItem = new OrderItem(quantity, new Product(productName, price));
			order.addOrderItem(orderItem);
		}
		
		System.out.println(order);
		
		sc.close();
	}

}
