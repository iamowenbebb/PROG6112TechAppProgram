import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		
		System.out.println("OWENS TECH APP");
		System.out.println("--------------");
		System.out.println("Enter (1) to launch menu or any other key to exit");
		
		Scanner sc = new Scanner(System.in);
		
		if(sc.next().equals("1")) {		
			ArrayList<Product> prods = new ArrayList<>();
			
			while(true) {
				System.out.println("Please select one of the following menu items:");
				System.out.println("(1) Capture a new product.");
				System.out.println("(2) Search for a product.");
				System.out.println("(3) Update a product.");
				System.out.println("(4) Delete a product.");
				System.out.println("(5) Print report");
				System.out.println("(6) Exit Application.");
				System.out.print("Enter your option : ");
				int option = sc.nextInt();
				System.out.println();
				if(option == 1) {
					System.out.println("Enter id, name, cost : ");
					int id = sc.nextInt();
					String name = sc.next();
					double cost = sc.nextDouble();
					Product newProd = new Product(id, name, cost);
					prods.add(newProd);
				} else if(option == 2) {
					System.out.println("Enter id : ");
					int id = sc.nextInt();
					Product foundProd = null;
					for(int i=0 ; i<prods.size() ; i++) {
						if(prods.get(i).id == id) {
							foundProd = prods.get(i);
						}
					}
					if(foundProd == null) {
						System.out.println("Product not found");
					} else {
						System.out.println("Found Product");
						System.out.println(foundProd);
					}
				} else if(option == 3) {
					System.out.println("Enter id : ");
					int id = sc.nextInt();
					boolean found = false;
					for(int i=0 ; i<prods.size() ; i++) {
						if(prods.get(i).id == id) {
							found = true;
							System.out.println("Enter name, cost : ");
							String name = sc.next();
							double cost = sc.nextDouble();
							prods.get(i).name = name;
							prods.get(i).cost = cost;
						}
					}
					if(!found)
						System.out.println("Product id not found");
				} else if(option == 4) {
					System.out.println("Enter id : ");
					int id = sc.nextInt();
					boolean found = false;
					for(int i=0 ; i<prods.size() ; i++) {
						if(prods.get(i).id == id) {
							found = true;
							prods.remove(i);
						}
					}
					if(!found)
						System.out.println("Product id not found");
				} else if(option == 5) {
					if(prods.size() == 0) {
						System.out.println("Empty Products");
					} else {
						for(int i=0 ; i<prods.size() ; i++) {
							System.out.println(prods.get(i));
						}
					}
				} else if(option == 6) {
					System.out.println("\nClosing Application");
					break;
				}
				System.out.println();
			}
			sc.close();
		} else {
			System.out.println("\nClosing Application");
		}
		
	}
	
}
class Product {
	int id;
	String name;
	double cost;
	public Product(int id, String name, double cost) {
		this.id = id;
		this.name = name;
		this.cost = cost;
	}
	@Override
	public String toString() {
		return "Product : " + "\n\tid = " + id + "\n\tname = " + name + "\n\tcost = R" + cost;
	}
}
