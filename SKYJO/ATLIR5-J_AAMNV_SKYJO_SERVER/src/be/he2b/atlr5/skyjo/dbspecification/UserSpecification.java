package be.he2b.atlr5.skyjo.dbspecification;

/**
 *
 * @author mad8
 */
public class UserSpecification {
    private int id;
    private String login;
    private String name;

    /**
     *
     * @param login
     * @param name
     */
    public UserSpecification(String login, String name) {
        this.id = 0;
        this.login = login;
        this.name = name;
    }

    /**
     *
     * @param id
     */
    public UserSpecification(int id) {
        this.id = id;
    }

    /**
     *
     * @return
     */
    public int getId() {
        return id;
    }

    /**
     *
     * @param id
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     *
     * @return
     */
    public String getLogin() {
        return login;
    }

    /**
     *
     * @param login
     */
    public void setLogin(String login) {
        this.login = login;
    }

    /**
     *
     * @return
     */
    public String getName() {
        return name;
    }

    /**
     *
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }
}
