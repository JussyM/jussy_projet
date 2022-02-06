package be.he2b.atlr5.skyjo.dbdto;

import be.he2b.atlr5.skyjo.exception.DtoException;
/**
 *
 * @author mad8
 */
public class UserDto extends EntityDto<Integer>{
     private String name;
    private String login;

    /**
     * constructeur d'un user persistant
     *
     * @param id
     * @param login
     * @param name
     * @throws be.he2b.esi.exception.DtoException
     */
    public UserDto(Integer id, String login, String name) throws DtoException {
        this(login, name);
        this.id = id;
    }

    /**
     * constructeur d'un user non persistant
     *
     * @param login
     * @param name
     * @throws exception.DtoException
     */
    public UserDto(String login, String name) throws DtoException {
        if (login == null || name == null) {
            throw new DtoException("les attributs login et  name sont obligatoires");
        }
        this.login = login;
        this.name = name;

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

    @Override
    public String toString() {
        return "[UserDto] (" + getId() + ") " + getLogin() + " " + getName();
    }
}
