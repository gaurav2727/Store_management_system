#Store Management System using Singly Linked List
This Java program implements a simple Store Management System using a singly linked list data structure. It allows users to perform various operations such as buying products, displaying product bills, adding new products, and canceling product orders. Here's a brief overview of the code:

Code Structure
The code is divided into several classes:

Node1 Class: This class represents a node in the singly linked list. Each node contains information about a customer's purchases, including product IDs, beverage names, quantities, prices, and the total price.

Store_Management Class: This class contains methods for creating, displaying, inserting, and deleting customer orders. It also has a menu method for calculating the price of beverages based on user choices.

Main Class: This is the main entry point of the program. It provides a menu for users to interact with the Store Management System.

How to Use
Run the program, and it will display a menu with the following options:

Enter 1 to buy a product.
Enter 2 to display product bills for each customer.
Enter 3 to add a new product for an existing customer.
Enter 4 to cancel a product order for an existing customer.
Enter 0 to exit the program.
Choose an option by entering the corresponding number.

Depending on your choice:

Option 1 allows you to create a new customer order by selecting beverages and specifying quantities.
Option 2 displays the product bill for a specific customer, including the total price.
Option 3 allows you to add more products to an existing customer's order.
Option 4 lets you cancel a product from an existing customer's order.
Continue using the menu until you choose to exit the program (Option 0).

Sample Output
The program's output includes prompts for user input, such as customer names, beverage choices, quantities, and product IDs. It also displays the product bill with the customer's name, address, itemized details, and the total price.

Note
The program uses a randomly generated product ID for each purchase to distinguish between different items.
You may need to adjust the number of products and customers to match your requirements or use external data storage for a more realistic system.
Feel free to use and modify this code for your own store management system.
