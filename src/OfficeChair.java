
public class OfficeChair extends Furniture{

    private static final String[] models = {"MODEL_A", "MODEL_B", "MODEL_C", "MODEL_D", "MODEL_E","MODEL_F","MODEL_G"};
    private static final String[] colors = {"BLACK", "BLUE", "GREEN", "WHITE", "RED"};
    private String chairModel;

    /**
     * Constructor
     * @param company furniture's company
     * @param color furniture's color
     * @param branchCode furniture's branch code
     * @param chairModel chair's model
     * @throws Exception This color is not available
     */
    public OfficeChair(Company company, String color, int branchCode, String chairModel) throws Exception {
        super(company, color, branchCode);
        if (!isAvailableColor(color))
            throw new Exception("This color is not available");
        if (!isAvailableModel(chairModel))
            throw new Exception("This model is not available");
        this.chairModel = chairModel;
    }

    /**
     * Getter for chair's model
     * @return chair's model
     */
    public String getModel(){
        return chairModel;
    }


    /**
     * Check if there is color in the available colors
     * @param color furniture's color
     * @return true if the color is available
     */
    public static boolean isAvailableColor(String color){
        for (int i=0; i < colors.length; i++ ){
            if (colors[i].equals(color))
                return true;
        }
        return false;
    }

    /**
     * Check if there is model in the available models
     * @param chairModel - chair model
     * @return true if the model exists in the system, otherwise returns false
     */
    public static boolean isAvailableModel(String chairModel){
        for (int i=0; i< models.length; i++){
            if (models[i].equals(chairModel))
                return true;
        }
        return false;
    }


    @Override
    public void print() {
        System.out.println("Office Chair: " + getModel() + " Color: "+getColor());
    }

    @Override
    public void showAvailableColors() {
        System.out.println("Available Colors: ");
        for (int i=0; i< colors.length;i++)
            System.out.println(colors[i]);

    }

    @Override
    public boolean equals(Object o) {
        if (o == null)
            return false;
        if (!(o instanceof OfficeChair))
            return false;

        OfficeChair other = (OfficeChair) o;
        return getModel().equals(other.getModel()) && getColor().equals(other.getColor());
    }

}
