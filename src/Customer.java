import java.util.Iterator;

public class Customer extends User{

    private MSArrayList<Furniture> oldOrder;
    private MSArrayList<Furniture> order;
    /**
     * Constructor
     *
     * @param name     customer's name
     * @param surname  customer's surname
     * @param email    customer's email
     * @param password customer's password
     */
    public Customer(String name, String surname, String email, String password) {
        super(name, surname, email, password);
        oldOrder = new MSArrayList<>();
        order = new MSArrayList<>();
    }

    /**
     * Constructor for create temporary customer object
     * @param userID customer's userID
     */
    protected Customer(int userID){
        super("temp","temp", "temp", "temp");
        this.setUserID(userID);
    }

    /**
     * Returns the customer's previous orders
     * @return customer's previous orders
     */
    public MSArrayList<Furniture> getOldOrder(){
        return oldOrder;
    }

    /**
     * Finds any furniture in the company
     * @param company company
     * @param fr - target furniture
     */
    public void findProduct(Company company, Furniture fr){

        int stock;
        int bCode;
        if (fr instanceof OfficeDesk){
            int len = company.getFurniture().get(0).size();
            for (int i=0; i < len; i++){
                if (company.getFurniture().get(0).get(i).equals(fr))
                {
                    company.getFurniture().get(0).get(i).print();
                    stock = company.getFurniture().get(0).get(i).getStock();
                    bCode = company.getFurniture().get(0).get(i).getBranchCode();
                    System.out.println("Branch: " + bCode + " Stock: " + stock);
                }

            }
        }

        else if(fr instanceof OfficeChair){
            int len = company.getFurniture().get(1).size();
            for (int i=0; i < len; i++){
                if (company.getFurniture().get(1).get(i).equals(fr))
                {
                    company.getFurniture().get(1).get(i).print();
                    stock = company.getFurniture().get(1).get(i).getStock();
                    bCode = company.getFurniture().get(1).get(i).getBranchCode();
                    System.out.println("Branch: " + bCode + " Stock: " + stock);
                }

            }
        }

        else if(fr instanceof MeetingTable){
            int len = company.getFurniture().get(2).size();
            for (int i=0; i < len; i++){
                if (company.getFurniture().get(2).get(i).equals(fr))
                {
                    company.getFurniture().get(2).get(i).print();
                    stock = company.getFurniture().get(2).get(i).getStock();
                    bCode = company.getFurniture().get(2).get(i).getBranchCode();
                    System.out.println("Branch: " + bCode + " Stock: " + stock);
                }
            }
        }
    }

    /**
     * Returns existing orders
     * @return existing orders
     */
    public MSArrayList<Furniture> getOrder(){ return order;}

    /**
     * Add new order to cart
     * @param fr - furniture to be added
     */
    public void addOrder(Furniture fr){
        order.add(fr);
    }

    /**
     * Clears the order list
     */
    public void clearCart(){
        order = new MSArrayList<>();
    }

    /**
     * List the products in the branch
     * @param company company
     * @param branchCode branchcode
     */
    public void listProducts(Company company, int branchCode){

        HybridList<Furniture> hL = company.getFurniture();
        Iterator<MSArrayList<Furniture>> iter = hL.iterator();
        while (iter.hasNext()){
            MSArrayList<Furniture> fur = iter.next();
            for (int i=0; i<fur.size(); i++){
                if (fur.get(i).getBranchCode() == branchCode){
                    fur.get(i).print();
                    System.out.println(" Branch: " + fur.get(i).getBranchCode());
                }

            }
        }
    }

    /**
     * Prints in which branches the furniture is located
     * @param company company
     * @param fr - target furniture
     */
    public void printProductsBranch(Company company, Furniture fr){
        boolean flag = true;
        int len = company.getFurniture().size();
        if (fr instanceof OfficeDesk){
            int len2 = company.getFurniture().get(0).size();
            for (int i=0; i<len2;i++){
                if (company.getFurniture().get(0).get(i).equals(fr)){
                    int branch = company.getFurniture().get(0).get(i).getBranchCode();
                    System.out.println("Branch: "+ branch);
                    flag = false;
                }
            }
        }

        else if(fr instanceof OfficeChair){
            int len2 = company.getFurniture().get(1).size();
            for (int i=0; i<len2;i++){
                if (company.getFurniture().get(1).get(i).equals(fr)){
                    int branch = company.getFurniture().get(1).get(i).getBranchCode();
                    System.out.println("Branch: "+ branch);
                    flag = false;
                }
            }
        }

        else if(fr instanceof MeetingTable){
            int len2 = company.getFurniture().get(2).size();
            for (int i=0; i<len2;i++){
                if (company.getFurniture().get(2).get(i).equals(fr)){
                    int branch = company.getFurniture().get(2).get(i).getBranchCode();
                    System.out.println("Branch: "+ branch);
                    flag = false;
                }
            }
        }

        if (flag)
            System.out.println("The product is not available!");
    }


    /**
     * Prints the previous orders
     */
    public void printPreviousOrders(){
        if (oldOrder.isEmpty())
            System.out.println("Cart is empty!");
        else {
            int len = oldOrder.size();
            System.out.println("Order History: ");
            for (int i=0;i<len;i++)
                oldOrder.get(i).print();
        }

    }

    @Override
    public boolean equals(Object o) {
        if (o == null)
            return false;
        if (!(o instanceof Customer))
            return false;

        Customer other = (Customer) o;

        return getUserID() == other.getUserID();
    }


}
