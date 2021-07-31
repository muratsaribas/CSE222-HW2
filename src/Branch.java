public class Branch {
    private int branchCode;
    private Company company;

    /**
     * Constructor
     * @param company branch's company
     * @param branchCode branch's code
     */
    public Branch(Company company, int branchCode){
        this.company = company;
        setBranchCode(branchCode);
    }

    /**
     * Getter for branch's code
     * @return branch's code
     */
    public int getBranchCode(){
        return branchCode;
    }

    /**
     * Setter for branch's code
     * @param branchCode branch's code
     */
    public void setBranchCode(int branchCode){
        this.branchCode = branchCode;
    }

    /**
     * Getter for branch's company
     * @return branch's company
     */
    public Company getCompany(){
        return company;
    }


    /**
     *
     * @param o other branch
     * @return true if the branch codes are the same
     */
    @Override
    public boolean equals(Object o) {
        if (o == null)
            return false;
        if (!(o instanceof Branch))
            return false;

        Branch other = (Branch) o;
        return getBranchCode() == other.getBranchCode();
    }

    @Override
    public String toString() {
        return String.format(" Branch Code: " + getBranchCode());
    }


}

