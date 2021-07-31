public class BranchEmployee extends User{
    private Branch branch;


    /**
     * Constructor
     * @param name branch employee's name
     * @param surname branch employee's surname
     * @param email branch employee's email
     * @param password branch employee's password
     * @param branch where the branch employee's will work
     */
    public BranchEmployee(String name, String surname, String email, String password, Branch branch) {
        super(name, surname, email, password);
        this.branch = branch;
    }

    /**
     * Constructor for create temporary branch employee object
     * @param branch branch
     * @param userID userID
     */
    protected BranchEmployee(Branch branch, int userID) {
        super("temp", "temp", "temp", "temp");
        this.branch = branch;
        this.setUserID(userID);
    }

    /**
     * Getter for branch employee's branch
     * @return Branch - employee's branch
     */
    public Branch getBranch(){
        return branch;
    }

    /**
     * Add new customer
     * @param name customer's name
     * @param surname customer's surname
     * @param email customer's email
     * @param password customer's password
     * @return true if the customer is added
     */
    public boolean addUser(String name, String surname, String email, String password){
        Customer cs = new Customer(name, surname, email, password);
        return getBranch().getCompany().getCustomers().add(cs);
    }

    /**
     * Remove the existing customer in the company
     * @param userID customer's userID
     * @return true if the customer is removed
     */
    public boolean removeUser(int userID){
        Customer cs = new Customer(userID);
        return getBranch().getCompany().getCustomers().remove(cs);
    }

    /**
     * Prints the customer's previous orders
     * @param userID customer's userID
     */
    public void printPreviousOrders(int userID){
        Customer cs = new Customer(userID);
        int index = getBranch().getCompany().getCustomers().indexOf(cs);
        if (index == -1)
        {
            System.out.println("Invalid ID");
            return;
        }

        getBranch().getCompany().getCustomers().get(index).printPreviousOrders();

    }

    /**
     * Add new order
     * @param userID customer's userID
     * @param model furniture's model
     * @param color furniture's color
     * @throws Exception Stock is insufficient!
     */
    public void newOrder(int userID, String model, String color) throws Exception {

        Customer cs = new Customer(userID);
        int idx = getBranch().getCompany().getCustomers().indexOf(cs);
        if (idx == -1)
        {
            System.out.println("Invalid ID");
            return;
        }

        if (OfficeDesk.isAvailableModel(model)){
            if (OfficeDesk.isAvailableColor(color)){
                Furniture temp = new OfficeDesk(getBranch().getCompany(), color, getBranch().getBranchCode(), model);
                int index = getBranch().getCompany().getFurniture().get(0).indexOf(temp);
                if (index == -1){
                    System.out.println("The product is not availableO!");
                    return;
                }
                else if(0 == getBranch().getCompany().getFurniture().get(0).get(index).getStock()){
                    System.out.println("The product is out of stock!");
                    return;
                }
                getBranch().getCompany().getCustomers().get(idx).addOrder(temp);
            }
            else{
                System.out.println("Color is not available!");
                return;}

        }

        else if(OfficeChair.isAvailableModel(model)){
            if (OfficeChair.isAvailableColor(color)){
                Furniture temp = new OfficeChair(getBranch().getCompany(), color, getBranch().getBranchCode(), model);
                int index = getBranch().getCompany().getFurniture().get(1).indexOf(temp);
                if (index == -1){
                    System.out.println("The product is not availableD!");
                    return;
                }
                else if(0 == getBranch().getCompany().getFurniture().get(1).get(index).getStock()){
                    System.out.println("The product is out of stock!");
                    return;
                }
                getBranch().getCompany().getCustomers().get(idx).addOrder(temp);
            }
            else{
                System.out.println("Color is not available!");
                return;}
        }

        else if(MeetingTable.isAvailableModel(model)){
            if (MeetingTable.isAvailableColor(color)){
                Furniture temp = new MeetingTable(getBranch().getCompany(), color, getBranch().getBranchCode(), model);
                int index = getBranch().getCompany().getFurniture().get(2).indexOf(temp);
                if (index == -1){
                    System.out.println("The product is not availableM!");
                    return;
                }
                else if(0 == getBranch().getCompany().getFurniture().get(2).get(index).getStock()){
                    System.out.println("The product is out of stock!");
                    return;
                }
                getBranch().getCompany().getCustomers().get(idx).addOrder(temp);
            }
            else{
                System.out.println("Color is not available!");
                return;}
        }

        else {
            System.out.println("The product is not available!!!");
        }

    }


    /**
     * Add new furniture to the system
     * @param furniture to be added
     */
    public void addProduct(Furniture furniture){
        if (furniture instanceof OfficeDesk){
            int index = getBranch().getCompany().getFurniture().get(0).indexOf(furniture);
            if (index != -1){
                Furniture fr = getBranch().getCompany().getFurniture().get(0).get(index);
                if (fr.getBranchCode() == furniture.getBranchCode()){
                    System.out.println("The product already exists!");
                    return;
                }
            }
            getBranch().getCompany().getFurniture().get(0).add(furniture);
        }

        else if(furniture instanceof OfficeChair){
            int index = getBranch().getCompany().getFurniture().get(1).indexOf(furniture);
            if (index != -1){
                Furniture fr = getBranch().getCompany().getFurniture().get(1).get(index);
                if (fr.getBranchCode() == furniture.getBranchCode()){
                    System.out.println("The product already exists!");
                    return;
                }
            }
            getBranch().getCompany().getFurniture().get(1).add(furniture);
        }

        else if(furniture instanceof MeetingTable){
            int index = getBranch().getCompany().getFurniture().get(2).indexOf(furniture);
            if (index != -1){
                Furniture fr = getBranch().getCompany().getFurniture().get(2).get(index);
                if (fr.getBranchCode() == furniture.getBranchCode()){
                    System.out.println("The product already exists!");
                    return;
                }
            }
            getBranch().getCompany().getFurniture().get(2).add(furniture);
        }
    }

    /**
     * Remove the furniture in the system
     * @param furniture to be removed
     * @return true if the furniture is removed
     */
    public boolean removeProduct(Furniture furniture){

        if (furniture instanceof OfficeDesk)
            return getBranch().getCompany().getFurniture().get(0).remove(furniture);

        else if(furniture instanceof OfficeChair)
            return getBranch().getCompany().getFurniture().get(1).remove(furniture);

        else if(furniture instanceof MeetingTable)
            return getBranch().getCompany().getFurniture().get(2).remove(furniture);

        return false;
    }

    /**
     * Sells received orders
     * @param userID customer's userID
     */
    public void sale(int userID){
        Customer cs = new Customer(userID);
        int idx = getBranch().getCompany().getCustomers().indexOf(cs);
        if (idx == -1)
        {
            System.out.println("Invalid ID");
            return;
        }
        cs = getBranch().getCompany().getCustomers().get(idx);
        if(cs.getOrder().isEmpty())
            System.out.println("Cart is empty!");
        else{
            int len = cs.getOrder().size();
            for (int i=0; i<len; i++){
                Furniture temp = cs.getOrder().get(i);
                if (temp.getStock() == 0){
                    System.out.println(temp.toString() + "is out of stock!");
                    cs.clearCart();
                    return;
                }
            }
            for(int i=0;i<len;i++){
                Furniture temp = cs.getOrder().get(i);
                getBranch().getCompany().getCustomers().get(idx).getOldOrder().add(temp);
                decreaseStock(temp);
            }
            cs.clearCart();
        }
    }

    /**
     * Getter for the furniture's stock
     * @param furniture - target furniture
     * @return furniture's stock
     */
    public int getStock(Furniture furniture){
        if (furniture instanceof OfficeDesk){
            int index = getBranch().getCompany().getFurniture().get(0).indexOf(furniture);
            if (index == -1){
                return 0;
            }
            return getBranch().getCompany().getFurniture().get(0).get(index).getStock();
        }

        else if(furniture instanceof OfficeChair){
            int index = getBranch().getCompany().getFurniture().get(1).indexOf(furniture);
            if (index == -1){
                return 0;
            }
            return getBranch().getCompany().getFurniture().get(1).get(index).getStock();
        }

        else if(furniture instanceof MeetingTable){
            int index = getBranch().getCompany().getFurniture().get(2).indexOf(furniture);
            if (index == -1){
                return 0;
            }
            return getBranch().getCompany().getFurniture().get(2).get(index).getStock();
        }
        return 0;
    }

    /**
     * Increases furniture stock by 1
     * @param fr - target furniture
     */
    protected void increaseStock(Furniture fr){
        if (fr instanceof OfficeDesk){
            int index = getBranch().getCompany().getFurniture().get(0).indexOf(fr);
            getBranch().getCompany().getFurniture().get(0).get(index).increaseStock();
        }

        else if(fr instanceof OfficeChair){
            int index = getBranch().getCompany().getFurniture().get(1).indexOf(fr);
            getBranch().getCompany().getFurniture().get(1).get(index).increaseStock();
        }

        else if(fr instanceof MeetingTable){
            int index = getBranch().getCompany().getFurniture().get(2).indexOf(fr);
            getBranch().getCompany().getFurniture().get(2).get(index).increaseStock();
        }
        return;
    }

    /**
     * Decreases furniture stock by 1
     * @param fr furniture
     */
    protected void decreaseStock(Furniture fr){
        if (fr instanceof OfficeDesk){
            int index = getBranch().getCompany().getFurniture().get(0).indexOf(fr);
            getBranch().getCompany().getFurniture().get(0).get(index).decreaseStock();
        }

        else if(fr instanceof OfficeChair){
            int index = getBranch().getCompany().getFurniture().get(1).indexOf(fr);
            getBranch().getCompany().getFurniture().get(1).get(index).decreaseStock();
        }

        else if(fr instanceof MeetingTable){
            int index = getBranch().getCompany().getFurniture().get(2).indexOf(fr);
            getBranch().getCompany().getFurniture().get(2).get(index).decreaseStock();
        }
        return;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null)
            return false;
        if (!(o instanceof BranchEmployee))
            return false;

        BranchEmployee other = (BranchEmployee) o;
        return getUserID() == other.getUserID();
    }


    @Override
    public String toString() {
        return String.format(super.toString()+ " Branch: " + getBranch().getBranchCode());
    }
}
