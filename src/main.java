import java.util.Iterator;

public class main {
    public static void main(String[] args){
        Company company = new Company("Saribas");

        AutomationSystem aSystem = new AutomationSystem("HW3", company);

        try{
            // Login to system as Admin
            System.out.println("\n### Login to system as Admin ###");
            User loginUser = aSystem.login(company.getAdmin().getUserID(), "1234");
            Admin admin = null;
            if (loginUser instanceof Admin)
                admin = (Admin) loginUser;
            System.out.println(admin.toString());

            // Add branch
            System.out.println("\n ### Add branch ###");
            admin.addBranch(300);
            Branch branch = new Branch(company,400);
            admin.addBranch(branch.getBranchCode());
            admin.printBranches();

            // Remove branch
            System.out.println("\n ### Remove branch ###");
            admin.removeBranch(300);
            admin.removeBranch(400);
            admin.printBranches();

            // Add branch employee
            System.out.println("\n ### Add branch employee ###");
            boolean flag = admin.addBranchEmployee(100,"be3","be3","be3@gmail.com","123");
            admin.addBranchEmployee(200,"be4","be4","be4@gmail.com","123");
            admin.printEmployees();

            // Remove branch employee
            System.out.println("\n ### Remove branch employee ###");
            int userID = company.getEmployees().get(2).getUserID();
            int branchCode =  company.getEmployees().get(2).getBranch().getBranchCode();
            admin.removeBranchEmployee(branchCode,userID);
            userID = company.getEmployees().get(2).getUserID();
            branchCode =  company.getEmployees().get(2).getBranch().getBranchCode();
            admin.removeBranchEmployee(branchCode,userID);
            admin.printEmployees();


            // Login to system as branch employee
            System.out.println("\n### Login to system as branch employee ###");
            userID = company.getEmployees().get(0).getUserID();
            loginUser = aSystem.login(userID,"123");

            BranchEmployee branchEmployee = null;
            if (loginUser instanceof BranchEmployee)
                branchEmployee = (BranchEmployee) loginUser;
            System.out.println(branchEmployee.toString());

            // Add customer
            System.out.println("\n ### Add customer ###");
            Customer customer = null;
            flag = branchEmployee.addUser("Murat", "Saribas", "ms@gmail.com","123");
            int index = company.getCustomers().size();
            customer = company.getCustomers().get(index -1);
            if (flag)
                System.out.println("\nSuccessful: "+ customer.getName()+" "+customer.getSurname()+" ID: " + customer.getUserID());

            flag = branchEmployee.addUser("Veli","Kemal","vk@gmail.com","123");
            index = company.getCustomers().size();
            customer = company.getCustomers().get(index-1);
            if (flag)
                System.out.println("Successful: "+ customer.getName()+" "+customer.getSurname()+" ID: " + customer.getUserID());

            flag = branchEmployee.addUser("Enes","Ozgur","enes@gmail.com","123");
            index = company.getCustomers().size();
            customer = company.getCustomers().get(index-1);
            if (flag)
                System.out.println("Successful: "+ customer.getName()+" "+customer.getSurname()+" ID: " + customer.getUserID());

            flag = branchEmployee.addUser("Bilal","Eksi","eksi@gmail.com","123");
            index = company.getCustomers().size();
            customer = company.getCustomers().get(index-1);
            if (flag)
                System.out.println("Successful: "+ customer.getName()+" "+customer.getSurname()+" ID: " + customer.getUserID());

            System.out.println("Total Customer: " +company.getCustomers().size());
            // Remove customer
            System.out.println("\n ### Remove customer ###");
            customer = company.getCustomers().get(2);
            branchEmployee.removeUser(customer.getUserID());
            for (int i=0; i<company.getCustomers().size();i++){
                customer = company.getCustomers().get(i);
                System.out.println("Name: " + customer.getName()+" "+customer.getSurname()+" ID: "+ customer.getUserID());
            }
            System.out.println("Total Customer: " +company.getCustomers().size());

            // Create and add office chair
            System.out.println("\n ### Create and add office chair ###");
            branchCode = branchEmployee.getBranch().getBranchCode();
            OfficeChair chair = new OfficeChair(company,"BLACK" , branchCode, "MODEL_A");
            branchEmployee.addProduct(chair);
            chair = new OfficeChair(company,"BLUE" , branchCode, "MODEL_A");
            branchEmployee.addProduct(chair);
            chair = new OfficeChair(company,"GREEN", branchCode, "MODEL_A");
            branchEmployee.addProduct(chair);
            chair = new OfficeChair(company, "WHITE", branchCode, "MODEL_A");
            branchEmployee.addProduct(chair);
            chair = new OfficeChair(company,"BLACK" , branchCode, "MODEL_B");
            branchEmployee.addProduct(chair);
            chair = new OfficeChair(company,"BLUE" , branchCode, "MODEL_B");
            branchEmployee.addProduct(chair);
            chair = new OfficeChair(company,"GREEN", branchCode, "MODEL_C");
            branchEmployee.addProduct(chair);
            chair = new OfficeChair(company, "WHITE", branchCode, "MODEL_C");
            branchEmployee.addProduct(chair);

            chair = new OfficeChair(company,"RED" , 200, "MODEL_B");
            branchEmployee.addProduct(chair);
            chair = new OfficeChair(company,"BLUE" , 200, "MODEL_B");
            branchEmployee.addProduct(chair);
            chair = new OfficeChair(company,"RED", 200, "MODEL_C");
            branchEmployee.addProduct(chair);
            chair = new OfficeChair(company, "WHITE", 200, "MODEL_C");
            branchEmployee.addProduct(chair);

            // Create and add office desk
            System.out.println("\n ### Create and add office desk ###");
            OfficeDesk desk1 = new OfficeDesk(company, "BLACK", branchCode, "MODEL_1");
            branchEmployee.addProduct(desk1);
            desk1 = new OfficeDesk(company, "BLUE", branchCode, "MODEL_1" );
            branchEmployee.addProduct(desk1);
            desk1 = new OfficeDesk(company, "GREEN", branchCode, "MODEL_1" );
            branchEmployee.addProduct(desk1);
            desk1 = new OfficeDesk(company, "WHITE", branchCode, "MODEL_1" );
            branchEmployee.addProduct(desk1);
            desk1 = new OfficeDesk(company, "BLACK", branchCode, "MODEL_2");
            branchEmployee.addProduct(desk1);
            desk1 = new OfficeDesk(company, "BLUE", branchCode, "MODEL_2" );
            branchEmployee.addProduct(desk1);
            desk1 = new OfficeDesk(company, "GREEN", branchCode, "MODEL_2" );
            branchEmployee.addProduct(desk1);
            desk1 = new OfficeDesk(company, "WHITE", branchCode, "MODEL_2" );
            branchEmployee.addProduct(desk1);

            desk1 = new OfficeDesk(company, "BLACK", 200, "MODEL_1");
            branchEmployee.addProduct(desk1);
            desk1 = new OfficeDesk(company, "BLUE", 200, "MODEL_1" );
            branchEmployee.addProduct(desk1);
            desk1 = new OfficeDesk(company, "BLACK", 200, "MODEL_2" );
            branchEmployee.addProduct(desk1);
            desk1 = new OfficeDesk(company, "BLUE", 200, "MODEL_2" );
            branchEmployee.addProduct(desk1);

            // Create and add meeting table
            System.out.println("\n ### Create and add meeting table ###");
            MeetingTable table1 = new MeetingTable(company, "BLACK", branchCode, "MODEL_MT1");
            branchEmployee.addProduct(table1);
            table1 = new MeetingTable(company, "BLUE", branchCode, "MODEL_MT1");
            branchEmployee.addProduct(table1);
            table1 = new MeetingTable(company, "GREEN", branchCode, "MODEL_MT1");
            branchEmployee.addProduct(table1);
            table1 = new MeetingTable(company, "BLACK", branchCode, "MODEL_MT2");
            branchEmployee.addProduct(table1);
            table1 = new MeetingTable(company, "BLUE", branchCode, "MODEL_MT2");
            branchEmployee.addProduct(table1);
            table1 = new MeetingTable(company, "GREEN", branchCode, "MODEL_MT2");
            branchEmployee.addProduct(table1);

            table1 = new MeetingTable(company, "BLACK", 200, "MODEL_MT3");
            branchEmployee.addProduct(table1);
            table1 = new MeetingTable(company, "BLUE", 200, "MODEL_MT3");
            branchEmployee.addProduct(table1);
            table1 = new MeetingTable(company, "GREEN", 200, "MODEL_MT3");
            branchEmployee.addProduct(table1);

            // Print stock of the furniture
            System.out.println("\n ### Print stock of the furniture ###");
            System.out.println("Stock: "+ branchEmployee.getStock(chair));
            chair.print();
            System.out.println("Stock: "+ branchEmployee.getStock(desk1));
            desk1.print();
            System.out.println("Stock: "+ branchEmployee.getStock(table1));
            table1.print();

            System.out.println("\n #### All products ####");
            HybridList<Furniture> hL = company.getFurniture();
            Iterator<MSArrayList<Furniture>> iter = hL.iterator();
            while (iter.hasNext()){
                MSArrayList<Furniture> fur = iter.next();
                for (int i=0; i<fur.size(); i++){
                    fur.get(i).print();
                    System.out.println(" Branch: " + fur.get(i).getBranchCode());
                }
            }

            table1 = new MeetingTable(company, "BLUE", 200, "MODEL_MT3");
            // Remove product
            System.out.println("\n ### Remove product ###");
            branchEmployee.removeProduct(chair);
            branchEmployee.removeProduct(desk1);
            branchEmployee.removeProduct(table1);
            table1 = new MeetingTable(company, "GREEN", 200, "MODEL_MT3");
            branchEmployee.removeProduct(table1);
            table1 = new MeetingTable(company, "BLACK", 200, "MODEL_MT3");
            branchEmployee.removeProduct(table1);

            System.out.println("\n #### All products ####");
            hL = company.getFurniture();
            iter = hL.iterator();
            while (iter.hasNext()){
                MSArrayList<Furniture> fur = iter.next();
                for (int i=0; i<fur.size(); i++){
                    fur.get(i).print();
                    System.out.println(" Branch: " + fur.get(i).getBranchCode());
                }
            }

            // Taking orders and selling
            chair = new OfficeChair(company, "BLACK", 100, "MODEL_A");
            desk1 = new OfficeDesk(company, "BLUE", 200, "MODEL_2");
            table1 = new MeetingTable(company,"GREEN", 100, "MODEL_MT1");
            System.out.println("\n ### Taking orders and selling ###");
            System.out.println("Stocks before sale: ");
            System.out.println("Stock: "+ branchEmployee.getStock(chair));
            chair.print();
            System.out.println("Stock: "+ branchEmployee.getStock(desk1));
            desk1.print();
            System.out.println("Stock: "+ branchEmployee.getStock(table1));
            table1.print();

            customer = company.getCustomers().get(0);
            userID = customer.getUserID();
            branchEmployee.newOrder(userID, "MODEL_A", "BLACK");
            branchEmployee.newOrder(userID, "MODEL_2", "BLUE");
            branchEmployee.newOrder(userID, "MODEL_MT1", "GREEN");
            branchEmployee.newOrder(userID, "MODEL_MT1", "GREEN");
            branchEmployee.sale(userID);


            System.out.println("\n");
            System.out.println("Stocks after sale: ");
            System.out.println("Stock: "+ branchEmployee.getStock(chair));
            chair.print();
            System.out.println("Stock: "+ branchEmployee.getStock(desk1));
            desk1.print();
            System.out.println("Stock: "+ branchEmployee.getStock(table1));
            table1.print();


            // Prints the customer's previous orders
            System.out.println("\n ### Prints the customer's previous orders ###");
            branchEmployee.printPreviousOrders(userID);

            // Login to system as customer
            System.out.println("\n### Login to system as customer ###");
            customer = company.getCustomers().get(0);
            userID = customer.getUserID();
            loginUser = aSystem.login(userID,"123");
            if (loginUser instanceof Customer)
                customer = (Customer) loginUser;
            System.out.println(customer.toString());


            // Find product
            System.out.println("\n ### Find product ###");
            customer.findProduct(company, chair);
            customer.findProduct(company, desk1);
            customer.findProduct(company, table1);

            // List products in the branch
            System.out.println("\n ### List products in the branch ###");
            customer.listProducts(company, 200);


            // Find the branch where the product is located
            System.out.println("\n ### Find the branch where the product is located ###");
            customer.printProductsBranch(company, chair);
            customer.printProductsBranch(company, desk1);
            customer.printProductsBranch(company, table1);

            // Prints previous orders
            System.out.println("\n ### Prints previous orders ###");
            customer.printPreviousOrders();


        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}
