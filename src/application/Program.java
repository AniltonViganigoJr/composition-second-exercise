package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import entities.Client;
import entities.Order;
import entities.OrderItem;
import entities.Product;
import entities.enums.OrderStatus;

public class Program {

	public static void main(String[] args) throws ParseException {

		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);

		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		System.out.println("*Enter Client Data*");
		System.out.print("Name:");
		String clientName = sc.nextLine();
		System.out.print("Email:");
		String clientEmail = sc.nextLine();
		System.out.print("Birth Date (DD/MM/YYYY):");
		Date clientBirthDate = sdf.parse(sc.next());
		
		Client client = new Client(clientName, clientEmail, clientBirthDate);
		
		System.out.println("*Status Codes*");
		System.out.println("1 - PENDING PAYMENT");
		System.out.println("2 - PROCESSING");
		System.out.println("3 - SHIPPED");
		System.out.println("4 - DELIVERED");
		System.out.print("Order Status: ");
		sc.nextLine();
		String statusCode = sc.nextLine();
		
		Order order = new Order(LocalDateTime.now(), OrderStatus.updateOrderStatus(statusCode), client);

		System.out.print("How many items to this order?");
		int quantityItems = sc.nextInt();
		sc.nextLine();
		
		for(int i = 0; i < quantityItems; i++) {
			System.out.printf("\nEnter #%d item data:\n", i+1);
			System.out.print("Product Name:");
			String productName = sc.nextLine();
			System.out.print("Product Price:");
			double productPrice = sc.nextDouble();
			System.out.print("Quantity:");
			int quantity = sc.nextInt();
			sc.nextLine();
			
			OrderItem orderItem = new OrderItem(quantity, new Product(productName, productPrice));
			order.addItem(orderItem);
		}
		
		System.out.println("\n*ORDER SUMMARY*");
		System.out.println(order.toString());
		
		sc.close();
	}
}