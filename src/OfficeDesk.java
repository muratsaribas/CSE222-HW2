public class OfficeDesk extends Furniture{

    private static final String[] models = {"MODEL_1", "MODEL_2", "MODEL_3", "MODEL_4", "MODEL_5"};
    private static final String[] colors = {"BLACK", "BLUE", "GREEN", "WHITE"};
    private String model;

    /**
     * Constructor
     * @param company furniture's company
     * @param color furniture's color
     * @param branchCode furniture's branch code
     * @param model desk's model
     * @throws Exception This color is not available
     */
    public OfficeDesk(Company company, String color, int branchCode, String model) throws Exception {
        super(company, color, branchCode);
        if (!isAvailableColor(color))
            throw new Exception("This color is not available");
        if (!isAvailableModel(model))
            throw new Exception("This model is not available");
        this.model = model;
    }

    /**
     * Getter for desk's model
     * @return desk's model
     */
    public String getModel(){
        return model;
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
     * @param officeDesk - table model
     * @return true if the model exists in the system, otherwise returns false
     */
    public static boolean isAvailableModel(String officeDesk){
        for (int i=0; i< models.length; i++){
            if (models[i].equals(officeDesk))
                return true;
        }
        return false;
    }


    @Override
    public void print() {
        System.out.println("Office Desk: " + getModel() + " Color: " + getColor());
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
        if (!(o instanceof OfficeDesk))
            return false;

        OfficeDesk other = (OfficeDesk) o;
        return getModel().equals(other.getModel()) && getColor().equals(other.getColor());
    }

}

