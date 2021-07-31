
public class Company {

    private String companyName;
    private Admin admin;
    private MSLinkedList<Branch> branch;
    private MSArrayList<BranchEmployee> employee;
    private MSArrayList<Customer> customer;
    private HybridList<Furniture> furniture;


    /**
     * Constructor
     * @param companyName Company name
     */
    public Company(String companyName) {
        this.companyName = companyName;
        Admin admin1 = new Admin("admin", "admin", "admin@gmail.com", "1234",this);
        admin = admin1;
        branch = new MSLinkedList<>();
        employee = new MSArrayList<>();
        customer = new MSArrayList<>();
        furniture = new HybridList<>();
        MSArrayList<Furniture> officeDesk = new MSArrayList<>();
        MSArrayList<Furniture> officeChair = new MSArrayList<>();
        MSArrayList<Furniture> meetingTable = new MSArrayList<>();
        furniture.add(officeDesk);
        furniture.add(officeChair);
        furniture.add(meetingTable);
    }

    /**
     * Getter for company's name
     * @return company's name
     */
    public String getCompanyName(){
        return companyName;
    }

    /**
     * Setter for company's name
     * @param companyName company's name
     */
    public void setCompanyName(String companyName){
        this.companyName = companyName;
    }

    /**
     * Getter for admin
     * @return admin
     */
    public Admin getAdmin() {
        return admin;
    }

    /**
     * Getter for branches owned by the company
     * @return branches registered in the company
     */
    public MSLinkedList<Branch> getBranches(){
        return branch;
    }

    /**
     * Getter for branch employees owned by the company
     * @return branch employees registered in the company
     */
    public MSArrayList<BranchEmployee> getEmployees(){
        return employee;
    }

    /**
     * Getter for customers
     * @return customers registered in the company
     */
    public MSArrayList<Customer> getCustomers(){
        return customer;
    }

    /**
     * Getter for furniture
     * @return furniture registered in the company
     */
    public HybridList<Furniture> getFurniture(){
        return furniture;
    }


    @Override
    public String toString() {
        return String.format("Company Name: "+getCompanyName()+
                " Admin: "+ getAdmin().getName()+ " " + getAdmin().getSurname()+
                "\nAdmin's ID: " +getAdmin().getUserID() +
                " Password: "+ getAdmin().getPassword());
    }
}
