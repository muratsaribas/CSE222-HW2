public class User implements UserInterface{

    private String name;
    private String surname;
    private String email;
    private String password;
    private int userID;
    private static int idNum = 100;


    /**
     * Constructor
     * @param name user's name
     * @param surname user's surname
     * @param email user's email
     * @param password user's password
     */
    public User(String name, String surname, String email, String password){
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.password = password;
        userID = idNum++;
    }


    /**
     * Getter for user's name
     * @return user's name
     */
    @Override
    public String getName() {
        return name;
    }

    /**
     * Getter for user's surname
     * @return user's surname
     */
    @Override
    public String getSurname() {
        return surname;
    }


    /**
     * Getter for user's email
     * @return user's email
     */
    @Override
    public String getEmail() {
        return email;
    }

    /**
     * Getter for user's password
     * @return user's password
     */
    @Override
    public String getPassword() {
        return password;
    }

    /**
     * Getter for user's ID
     * @return user's ID
     */
    @Override
    public int getUserID() {
        return userID;
    }

    /**
     * Set user's name
     * @param name user's name
     */
    public void setName(String name){
        this.name = name;
    }

    /**
     * Set user's surname
     * @param surname user's surname
     */
    public void setSurname(String surname){
        this.surname = surname;
    }

    /**
     * Set user's email
     * @param email user's email
     */
    public void setEmail(String email){
        this.email = email;
    }

    /**
     * Set user's password
     * @param password user's password
     */
    public void setPassword(String password){
        this.password = password;
    }

    /**
     * Setter for userID
     * @param userID new userID
     */
    protected void setUserID(int userID){
        this.userID = userID;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return userID == user.userID;
    }


    @Override
    public String toString() {
        return String.format("Name: "+getName()+" " + getSurname() +
                " email: "+getEmail()+ " ID: " +getUserID());
    }
}
