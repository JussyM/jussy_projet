package be.he2b.atlr5.skyjo.business;

import be.he2b.atlr5.skyjo.db.DBManager;
import be.he2b.atlr5.skyjo.dbdto.UserDto;
import be.he2b.atlr5.skyjo.exception.DBBusinessException;
import be.he2b.atlr5.skyjo.exception.DBException;
import be.he2b.atlr5.skyjo.exception.DtoException;
import be.he2b.atlr5.skyjo.dbspecification.UserSpecification;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
/**
 *
 * @author mad8
 */
public class AdminModel implements AdminFacade{
    // private static final String URL = "jdbc:derby://localhost:1527/threeLayer";
    // private static final String USER_DB = "app";
    // private static final String PASSWORD = "app";

    // static final String USERS = "USERS";

    // static int getNextNum(String sequence) throws SQLException {
        // Connection connexion = DriverManager.getConnection(URL, USER_DB, PASSWORD);
        // String query = "Update SEQUENCES set sValue = sValue+1 where id='" + sequence + "'";
        // java.sql.PreparedStatement update = connexion.prepareStatement(query);
        // update.execute();
        // java.sql.Statement stmt = connexion.createStatement();
        // query = "Select sValue FROM Sequences where id='" + sequence + "'";
        // java.sql.ResultSet rs = stmt.executeQuery(query);
        // int nvId;
        // if (rs.next()) {
            // nvId = rs.getInt("sValue");
            // return nvId;
        // } else {
            // throw new IllegalStateException("Nouveau n° de séquence inaccessible!");
        // }
    // }

    @Override
    public List<UserDto> getUsers() throws DBBusinessException {
        try {
            DBManager.startTransaction();
            List<UserDto> col = UserBusinessLogic.findAll();
            DBManager.validateTransaction();
            return col;
        } catch (DBException eDB) {
            String msg = eDB.getMessage();
            try {
                DBManager.cancelTransaction();
            } catch (DBException ex) {
                msg = ex.getMessage() + "\n" + msg;
            } finally {
                throw new DBBusinessException("Liste des Users inaccessible! \n" + msg);
            }
        }
    }

    @Override
    public UserDto getUser(int userId) throws DBBusinessException {
        try {
            DBManager.startTransaction();
            UserDto user = UserBusinessLogic.findById(userId);
            DBManager.validateTransaction();
            return user;
        } catch (DBException eDB) {
            String msg = eDB.getMessage();
            try {
                DBManager.cancelTransaction();
            } catch (DBException ex) {
                msg = ex.getMessage() + "\n" + msg;
            } finally {
                throw new DBBusinessException("Liste des Users inaccessible! \n" + msg);
            }
        }
    }

    @Override
    public UserDto getUser(String userName) throws DBBusinessException {
        try {
            DBManager.startTransaction();
            UserDto user = UserBusinessLogic.findByName(userName);
            DBManager.validateTransaction();
            return user;
        } catch (DBException eDB) {
            String msg = eDB.getMessage();
            try {
                DBManager.cancelTransaction();
            } catch (DBException ex) {
                msg = ex.getMessage() + "\n" + msg;
            } finally {
                throw new DBBusinessException("Liste des Users inaccessible! \n" + msg);
            }
        }
    }

    public static Collection<UserDto> getSelectedUsers(UserSpecification sel) throws DBBusinessException {
        try {
            DBManager.startTransaction();
            Collection<UserDto> col = UserBusinessLogic.findBySel(sel);
            DBManager.validateTransaction();
            return col;
        } catch (DBException eDB) {
            String msg = eDB.getMessage();
            try {
                DBManager.cancelTransaction();
            } catch (DBException ex) {
                msg = ex.getMessage() + "\n" + msg;
            } finally {
                throw new DBBusinessException("Liste des Users inaccessible! \n" + msg);
            }
        }
    }

    @Override
    public int addUser(String userLogin, String userName) throws DBBusinessException {
        try {
            DBManager.startTransaction();
            UserDto user = new UserDto(userLogin, userName);
            int id = UserBusinessLogic.add(user);
            DBManager.validateTransaction();
            return id;
        } catch (DBException | DtoException ex) {
            try {
                DBManager.cancelTransaction();
                throw new DBBusinessException(ex.getMessage());
            } catch (DBException ex1) {
                throw new DBBusinessException(ex1.getMessage());
            }
        }
    }

    @Override
    public void removeUser(UserDto user) throws DBBusinessException {
        try {
            if (user.isPersistant()) {
                DBManager.startTransaction();
                UserBusinessLogic.delete(user.getId());
                DBManager.validateTransaction();
            } else {
                throw new DBBusinessException("User: impossible de supprimer un user inexistant!");
            }
        } catch (DBException eDB) {
            String msg = eDB.getMessage();
            try {
                DBManager.cancelTransaction();
            } catch (DBException ex) {
                msg = ex.getMessage() + "\n" + msg;
            } finally {
                throw new DBBusinessException("Suppression de User impossible! \n" + msg);
            }
        }
    }

    @Override
    public void updateUser(UserDto user) throws DBBusinessException {
        try {
            DBManager.startTransaction();
            UserBusinessLogic.update(user);
            DBManager.validateTransaction();
        } catch (DBException eDB) {
            String msg = eDB.getMessage();
            try {
                DBManager.cancelTransaction();
            } catch (DBException ex) {
                msg = ex.getMessage() + "\n" + msg;
            } finally {
                throw new DBBusinessException("Mise à jour de User impossible! \n" + msg);
            }
        }
    }

    @Override
    public UserDto getRandomUser() throws DBBusinessException {
        List<UserDto> users = getUsers();
        if (users.isEmpty()) {
            throw new DBBusinessException("Aucun utilisateur présent");
        }
        Collections.shuffle(users);
        return users.get(0);
    }
}
