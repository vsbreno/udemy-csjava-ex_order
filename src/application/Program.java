package application;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Scanner;

import entities.Client;
import entities.Order;
import entities.OrderItem;
import entities.Product;
import entities.enums.OrderStatus;

public class Program {

	public static void main(String[] args) {

		Locale.setDefault(Locale.US);
		Scanner scan = new Scanner(System.in);
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");

		System.out.println("Enter client data: ");
		System.out.print("Name: ");
		String clientName = scan.nextLine();
		System.out.print("Email: ");
		String clientEmail = scan.nextLine();
		System.out.print("Birth date (DD/MM/YYYY): ");
		LocalDate clientBirthDate = LocalDate.parse(scan.next(), dtf);
		Client client = new Client(clientName, clientEmail, clientBirthDate);

		System.out.println("Enter order data:");
		System.out.print("Status: ");
		String orderStatus = scan.next();
		Order order = new Order(LocalDateTime.now(), OrderStatus.valueOf(orderStatus),
				client);

		System.out.print("How many items to this order? ");
		int n = scan.nextInt();
		
		for (int i = 0; i < n; i++) {
			System.out.println("Enter #" + (i + 1) + " item data:");
			System.out.print("Product name: ");
			String productName = scan.next();
			System.out.print("Product price: ");
			double productPrice = scan.nextDouble();
			System.out.print("Quantity: ");
			int productQuantity = scan.nextInt();

			Product p = new Product(productName, productPrice);
			OrderItem oI = new OrderItem(p.getPrice(), productQuantity, p);
			order.addItems(oI);
		}

		System.out.println();
		System.out.println(order);

		scan.close();
	}

}
