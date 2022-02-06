package be.he2b.atlr5.skyjo.business;

import be.he2b.atlr5.skyjo.db.UserDB;
import be.he2b.atlr5.skyjo.dbdto.UserDto;
import be.he2b.atlr5.skyjo.exception.DBException;
import be.he2b.atlr5.skyjo.dbspecification.UserSpecification;
import java.util.Collection;
import java.util.List;
/**
 *
 * @author mad8
 */
public class UserBusinessLogic {
    
    /**
     * Insert an user in the database. Returns the user's id.
     *
     * @param login user's login.
     * @param name user's name.
     * @return the user's id.
     * @throws SQLException if the query failed.
     */
    static int add(UserDto user) throws DBException {
        return UserDB.insertDb(user);
    }

    /**
     * Removes the given user.
     *
     * @param user user to delete.
     * @throws SQLException if the query failed.
     */
    static void delete(int id) throws DBException {
        UserDB.deleteDb(id);
    }

    /**
     * Updates the given user.
     *
     * @param user user to update.
     * @throws SQLException if the query failed.
     */
    static void update(UserDto user) throws DBException {
        UserDB.updateDb(user);
    }

    /**
     * Returns the unique user with the given login.
     *
     * @param id user's login.
     * @return the unique user with the given login.
     * @throws SQLException if the query failed.
     */
    static UserDto findByLogin(String login) throws DBException {
        UserSpecification sel = new UserSpecification(login, null);
        Collection<UserDto> col = UserDB.getCollection(sel);
        if (col.size() == 1) {
            return col.iterator().next();
        } else {
            return null;
        }
    }

    /**
     * Returns the unique user with the given name.
     *
     * @param name user's name.
     * @return the unique user with the given name.
     * @throws SQLException if the query failed.
     */
    static UserDto findByName(String name) throws DBException {
        UserSpecification sel = new UserSpecification(null, name);
        Collection<UserDto> col = UserDB.getCollection(sel);
        if (col.size() == 1) {
            return col.iterator().next();
        } else {
            return null;
        }
    }

    /**
     * Returns the unique user with the given id.
     *
     * @param id user's id.
     * @return the unique user with the given id.
     * @throws SQLException if the query failed.
     */
    static UserDto findById(int id) throws DBException {
        UserSpecification sel = new UserSpecification(id);
        Collection<UserDto> col = UserDB.getCollection(sel);
        if (col.size() == 1) {
            return col.iterator().next();
        } else {
            return null;
        }
    }

    /**
     * Returns a list of users with the given specifications.
     *
     * @param sel specifications (where clause)
     * @return a list of users with the given specifications.
     * @throws BusinessException if the query failed.
     */
    static List<UserDto> findBySel(UserSpecification sel) throws DBException {
        List<UserDto> col = UserDB.getCollection(sel);
        return col;
    }

    /**
     * Returns a list of all users.
     *
     * @return a list of all users.
     * @throws BusinessException if the query failed.
     */
    static List<UserDto> findAll() throws DBException {
        UserSpecification sel = new UserSpecification(0);
        List<UserDto> col = UserDB.getCollection(sel);
        return col;
    }

    //ajouter les methodes avec une logique métier
}
