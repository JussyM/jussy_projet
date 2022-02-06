package be.he2b.atlr5.skyjo.skyjoPlayer;

import java.io.Serializable;
/**
 * a user online and connected
 * @author 
 */
public class User implements Serializable {

    public static final int DEFAULT_ID = 0;
    private final String name;
    private int ID;
    private UserType type;

    /**
     * Constructor of the user having his name and ID
     * @param name of the player 
     * @param ID of the player
     */
    public User(String name, int ID) {
        this.name = name;
        this.ID = ID;
        type = UserType.GUEST;
    }

    /**
     * Overload constructor
     * @param name of the player
     * @param ID of the player
     * @param type ADMIN or OTHER or GUEST
     */
    public User(String name, int ID, UserType type) {
        this.name = name;
        this.ID = ID;
        this.type = type;
    }

    /**
     * Overload constructor using the name only
     * @param name of the player 
     */
    public User(String name) {
        this.name = name;
        this.ID = DEFAULT_ID;
        this.type = UserType.GUEST;
    }

    /**
     * setter of ID
     * @param ID of the player
     */
    public void setID(int ID) {
        this.ID = ID;
    }

    /**
     * setter of the userType
     * @param type userType
     */
    public void setType(UserType type) {
        this.type = type;
    }

    /**
     * getter of the player name
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * getter of the id 
     * @return ID
     */
    public int getID() {
        return ID;
    }

    /**
     * getter of the user Type
     * @return userType
     */
    public UserType getType() {
        return type;
    }
}
