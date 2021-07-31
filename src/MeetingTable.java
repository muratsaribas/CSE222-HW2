
public class MeetingTable extends Furniture{

    private static final String[] models = {"MODEL_MT1", "MODEL_MT2", "MODEL_MT3"};
    private static final String[] colors = {"BLACK", "BLUE", "GREEN"};
    private String model;

    /**
     * Constructor
     * @param company furniture's company
     * @param color furniture's color
     * @param branchCode furniture's model
     * @param model table's model
     * @throws Exception this color is not available
     */
    public MeetingTable(Company company, String color, int branchCode, String model) throws Exception {
        super(company, color, branchCode);
        if (!isAvailableColor(color))
            throw new Exception("This color is not available");
        if (!isAvailableModel(model))
            throw new Exception("This model is not available");
        this.model = model;
    }

    /**
     * Getter for table's model
     * @return table's model
     */
    public String getModel(){
        return model;
    }

    /**
     * Check if there is color in the available colors
     * @param color furniture's color
     * @return true if the color is available, otherwise returns false
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
     * @param model - table model
     * @return true if the model exists in the system, otherwise returns false
     */
    public static boolean isAvailableModel(String model){
        for (int i=0; i< models.length; i++){
            if (models[i].equals(model))
                return true;
        }
        return false;
    }


    @Override
    public void print() {
        System.out.println("Meeting Table : " + getModel() + " Color: " +getColor());
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
        if (!(o instanceof MeetingTable))
            return false;

        MeetingTable other = (MeetingTable) o;
        return getModel().equals(other.getModel()) && getColor().equals(other.getColor());
    }

}

