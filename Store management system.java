// STORE MANAGEMENT SYSTEM USING SINGLY LINKED LIST DATA STRUCTURE 

// CODE : 
import java.util.*;
import java.lang.*;
class Node1{
    Node1 link;
    int pro_id;
    String beverage[]=new String[20];
    String name,add;
    int num_quan[]=new int[20];
    float price[]=new float[20];
        float  tot_price;
    Node1(){
        link = null;
    }
}
class Store_Management {
    Scanner sc = new Scanner(System.in);
    Random r= new Random();
    Node1 head=null;
    Node1 tail=null;
    int n , quantity;
    public void create(){
        int ch=0;
        Node1 temp= new Node1();
        System.out.println("Enter the number of products to be bought : ");
        n = sc.nextInt();
        System.out.print("Enter the your name: ");
        temp.name = sc.next();
        System.out.print("Enter the your address: ");
        temp.add = sc.next();

        for(int i = 0;i < n ; i++){
            int num_quan=1;
            System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
            System.out.println("******************************************Beverages********************************************************");
            System.out.println("1) Coke\t2) Coca - cola\n3) Pepsi\t4) Fanta\n5) Sprite\t6) Thumbs - up\n7) Limonta\t8) Squirt\n9) Frizz\t 10) Shunya");
            System.out.print("Enter your choice: ");
            ch = sc.nextInt();
            System.out.println("enter beverage name: ");
            temp.beverage[i]=sc.next();
            System.out.println("Enter 1 to add more quantity: ");
            int choice = sc.nextInt();
            if(choice == 1){
                System.out.print("Enter the quantity of beverages: ");
                 temp.num_quan[i] = sc.nextInt();
            }
            temp.price[i] = menu(temp.num_quan[i],ch);
            System.out.println("your product id is : ");
            int pro_id = r.nextInt(50);
            System.out.println(pro_id);
            System.out.println("Remember your id for next time !!!!!");

            System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        }
        if(head==null){
            head=temp;
            tail=temp;
        }
        else {
            Node1 ptr=head;
            while(ptr.link!=null){
                ptr=ptr.link;
            }
            ptr.link=temp;
            tail=temp;
        }
    }
    void insert(){
        int ch=0;
        int num_quan=1;
//        Node1 new_node = new Node1();
        Node1 ptr1 = head;
        boolean flag=false;
        while(ptr1 != null){
            System.out.print("Enter the name of customer to add product: ");
            String name1 = sc.next();

            if(name1.equals(ptr1.name)){
                flag=true;
                System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
                System.out.println("******************************************Beverages********************************************************");
                System.out.println("1) Coke\t2) Coca - cola\n3) Pepsi\t4) Fanta\n5) Sprite\t6) Thumbs - up\n7) Limonta\t8) Squirt\n9) Frizz\t 10) Shunya");
                System.out.print("Enter your choice: ");
                ch = sc.nextInt();
                System.out.println("enter beverage name: ");
                ptr1.beverage[n]=sc.next();

                System.out.println("Enter 1 to add more quantity: ");
                int choice = sc.nextInt();
                if(choice == 1){
                    System.out.print("Enter the quantity of beverages: ");
                    ptr1.num_quan[n] = sc.nextInt();
                }
                ptr1.price[n] = menu(ptr1.num_quan[n],ch);
                System.out.println("Price = "+ptr1.price[n]);
                System.out.println("your product id is : ");
                int pro_id = r.nextInt(50);
                System.out.println(pro_id);
                System.out.println("Remember your id for next time !!!!!");

                System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
                break;
            }
            ptr1 = ptr1.link;
        }
        n=n+1;
        if(!flag){
            System.out.println("enter valid details.");
        }

        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
}
    public void delete(){
        System.out.println("enter your name: ");
        String name =sc.next();
        Node1 ptr=head;
        boolean flag=false;
        Node1 prev = null;
        while(ptr != null){
            if (ptr.name.equals(name)){

                System.out.println("Enter the product to be deleted: ");
                String beve = sc.next();
                for(int i=0;i<n;i++){
                    if(beve.equals(ptr.beverage[i])){
                        flag=true;
                        ptr.beverage[i] = ptr.beverage[i+1];
                        ptr.price[i] = ptr.price[i+1];
                        ptr.num_quan[i] = ptr.num_quan[i+1];
                        break;
                    }
                }

            }
            ptr = ptr.link;
        }
        if(!flag){
            System.out.println("enter valid details.");
        }
        n--;
        //display();
    }
    public  float menu(int num_quan,int ch){
        float price = 0;
        switch(ch){
            case 1: price = 35;//coke
                break;
            case 2: price = 37;//coca-cola
                break;
            case 3: price = 38;//pepsi
                break;
            case 4: price = 34;//fanta
                break;
            case 5: price = 80;//sprite
                break;
            case 6: price = 32;//thumbs-up
                break;
            case 7: price = 40;//limonta
                break;
            case 8: price = 50;//squirt
                break;
            case 9: price = 32;//frizz
                break;
            case 10: price = 50;//Shunya
                break;
            default: System.out.println("Invalid Choice");
        }

        price *= num_quan ;
        return price;
    }
    void display(){

        System.out.println("enter customer name: ");
        String name=sc.next();
        boolean flag=false;
        Node1 ptr =head;
        while(ptr!=null){
            ptr.tot_price=0f;
            if(ptr.name.equals(name)){
                System.out.println("---------------------------------");
                System.out.println("DISPLAY OF BILL: ");
                System.out.println("NAME OF CUSTOMER : "+ptr.name);
                System.out.println("ADDRESS OF CUSTOMER: "+ptr.add);
                System.out.println();
                System.out.println("Items      quantity        Total price");
                for(int i=0;i<n;i++) {
                    System.out.println(ptr.beverage[i] + "         " + ptr.num_quan[i] + "              " + ptr.price[i]);
                    ptr.tot_price += ptr.price[i];
                }
                System.out.println("\t\t\t\tTotal Price = "+ptr.tot_price);
                System.out.println("---------------------------------");
                return;
            }
            else{
                flag=true;
            }

            ptr=ptr.link;
        }
        if(flag){
            System.out.println("enter valid details !!!!!!");
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("WELCOME!!!!!!");
        Store_Management sm=new Store_Management();
        int ch;
        do {
            System.out.println("------------------------------------------");

            System.out.println("!!!!MENU!!!!");
            System.out.println("Enter 1 to buy a product.");
            System.out.println("Enter 2 to display product bill of each product.");
            System.out.println("Enter 3 to add new product.");
            System.out.println("Enter 4 to cancel product order.");
            System.out.println("ENTER 0 TO EXIT.");
            System.out.println("Enter your choice: ");
            ch = sc.nextInt();
            System.out.println("------------------------------------------");
            switch(ch)
            {
                case 1: // create
                    sm.create();
                    break;
                case 2: // display
                    sm.display();
                    break;
                case 3: // insert
                    sm.insert();
                    break;
                case 4: // delete
                    sm.delete();
                    break;
                case 0:{
                    System.out.println("EXIT!!!! ");
                    break;
                }
                default:{
                    System.out.println("PLEASE ENTER VALID OPTION !!!");
                    break;
                }
            }
        }while(ch != 0);
    }
}

//output: 
/*

WELCOME!!!!!!
------------------------------------------
!!!!MENU!!!!
Enter 1 to buy a product.
Enter 2 to display product bill of each product.
Enter 3 to add new product.
Enter 4 to cancel product order.
ENTER 0 TO EXIT.
Enter your choice: 
1
------------------------------------------
Enter the number of products to be bought : 
4
Enter the your name: shruti
Enter the your address: pune
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
******************************************Beverages********************************************************
1) Coke	2) Coca - cola
3) Pepsi	4) Fanta
5) Sprite	6) Thumbs - up
7) Limonta	8) Squirt
9) Frizz	 10) Shunya
Enter your choice: 1
enter beverage name: 
coke
Enter 1 to add more quantity: 
1
Enter the quantity of beverages: 4
your product id is : 
0
Remember your id for next time !!!!!
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
******************************************Beverages********************************************************
1) Coke	2) Coca - cola
3) Pepsi	4) Fanta
5) Sprite	6) Thumbs - up
7) Limonta	8) Squirt
9) Frizz	 10) Shunya
Enter your choice: 3
enter beverage name: 
pepsi
Enter 1 to add more quantity: 
1
Enter the quantity of beverages: 4
your product id is : 
14
Remember your id for next time !!!!!
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
******************************************Beverages********************************************************
1) Coke	2) Coca - cola
3) Pepsi	4) Fanta
5) Sprite	6) Thumbs - up
7) Limonta	8) Squirt
9) Frizz	 10) Shunya
Enter your choice: 4
enter beverage name: 
fanta
Enter 1 to add more quantity: 
1
Enter the quantity of beverages: 7
your product id is : 
13
Remember your id for next time !!!!!
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
******************************************Beverages********************************************************
1) Coke	2) Coca - cola
3) Pepsi	4) Fanta
5) Sprite	6) Thumbs - up
7) Limonta	8) Squirt
9) Frizz	 10) Shunya
Enter your choice: 9
enter beverage name: 
frizz
Enter 1 to add more quantity: 
1
Enter the quantity of beverages: 2
your product id is : 
12
Remember your id for next time !!!!!
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
------------------------------------------
!!!!MENU!!!!
Enter 1 to buy a product.
Enter 2 to display product bill of each product.
Enter 3 to add new product.
Enter 4 to cancel product order.
ENTER 0 TO EXIT.
Enter your choice: 
2
------------------------------------------
enter customer name: 
shruti
---------------------------------
DISPLAY OF BILL: 
NAME OF CUSTOMER : shruti
ADDRESS OF CUSTOMER: pune

Items      quantity        Total price
coke         4              140.0
pepsi         4              152.0
fanta         7              238.0
frizz         2              64.0
				Total Price = 594.0
---------------------------------
------------------------------------------
!!!!MENU!!!!
Enter 1 to buy a product.
Enter 2 to display product bill of each product.
Enter 3 to add new product.
Enter 4 to cancel product order.
ENTER 0 TO EXIT.
Enter your choice: 
3
------------------------------------------
Enter the name of customer to add product: khushi
enter valid details.
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
------------------------------------------
!!!!MENU!!!!
Enter 1 to buy a product.
Enter 2 to display product bill of each product.
Enter 3 to add new product.
Enter 4 to cancel product order.
ENTER 0 TO EXIT.
Enter your choice: 
3
------------------------------------------
Enter the name of customer to add product: shruti
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
******************************************Beverages********************************************************
1) Coke	2) Coca - cola
3) Pepsi	4) Fanta
5) Sprite	6) Thumbs - up
7) Limonta	8) Squirt
9) Frizz	 10) Shunya
Enter your choice: 10
enter beverage name: 
shunya
Enter 1 to add more quantity: 
1
Enter the quantity of beverages: 3
Price = 150.0
your product id is : 
7
Remember your id for next time !!!!!
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
------------------------------------------
!!!!MENU!!!!
Enter 1 to buy a product.
Enter 2 to display product bill of each product.
Enter 3 to add new product.
Enter 4 to cancel product order.
ENTER 0 TO EXIT.
Enter your choice: 
4
------------------------------------------
enter your name: 
alia
enter valid details.
------------------------------------------
!!!!MENU!!!!
Enter 1 to buy a product.
Enter 2 to display product bill of each product.
Enter 3 to add new product.
Enter 4 to cancel product order.
ENTER 0 TO EXIT.
Enter your choice: 
4
------------------------------------------
enter your name: 
shruti
Enter the product to be deleted: 
shunya
------------------------------------------
!!!!MENU!!!!
Enter 1 to buy a product.
Enter 2 to display product bill of each product.
Enter 3 to add new product.
Enter 4 to cancel product order.
ENTER 0 TO EXIT.
Enter your choice: 
2
------------------------------------------
enter customer name: 
shruti
---------------------------------
DISPLAY OF BILL: 
NAME OF CUSTOMER : shruti
ADDRESS OF CUSTOMER: pune

Items      quantity        Total price
coke         4              140.0
pepsi         4              152.0
fanta         7              238.0
frizz         2              64.0
				Total Price = 594.0
---------------------------------
------------------------------------------
!!!!MENU!!!!
Enter 1 to buy a product.
Enter 2 to display product bill of each product.
Enter 3 to add new product.
Enter 4 to cancel product order.
ENTER 0 TO EXIT.
Enter your choice: 
0
------------------------------------------
EXIT!!!! 

Process finished with exit code 0

*/
