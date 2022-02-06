package be.he2b.atlr5.skyjo.db;

import be.he2b.atlr5.skyjo.dbdto.UserDto;
import be.he2b.atlr5.skyjo.exception.DBException;
import be.he2b.atlr5.skyjo.exception.DtoException;
import be.he2b.atlr5.skyjo.dbspecification.UserSpecification;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author mad8
 */
public class UserDB {
    private static final String recordName = "USER";
    
    /**
     *
     * @return
     * @throws DbException
     */
    public static List<UserDto> getAllUsers() throws DtoException, DBException {
        List<UserDto> users = getCollection(new UserSpecification(0));
        return users;
    }

    /**
     *
     * @param sel
     * @return
     * @throws DbException
     */
    public static List<UserDto> getCollection(UserSpecification sel) throws DBException {
        List<UserDto> al = new ArrayList<>();
        try {
            String query = "Select id, login, name  FROM USERS ";
            java.sql.Connection connexion = DBManager.getConnection();
            java.sql.PreparedStatement stmt;
            String where = "";
            if (sel.getId() != 0) {
                where = where + " id = ? ";
            }
            if (sel.getLogin() != null && !sel.getLogin().isEmpty()) {
                if (!where.isEmpty()) {
                    where = where + " AND ";
                }
                where = where + " login like ? ";
            }

            if (sel.getName() != null && !sel.getName().isEmpty()) {
                if (!where.isEmpty()) {
                    where = where + " AND ";
                }
                where = where + " name like ? ";
            }

            if (where.length() != 0) {
                where = " where " + where + " order by login,name";
                query = query + where;
                stmt = connexion.prepareStatement(query);
                int i = 1;
                if (sel.getId() != 0) {
                    stmt.setInt(i, sel.getId());
                    i++;

                }
                if (sel.getLogin() != null && !sel.getLogin().isEmpty()) {
                    stmt.setString(i, sel.getLogin() + "%");
                    i++;
                }
                if (sel.getName() != null && !sel.getName().isEmpty()) {
                    stmt.setString(i, sel.getName() + "%");
                    i++;
                }
            } else {
                query = query + " Order by login,name";
                stmt = connexion.prepareStatement(query);
            }
            java.sql.ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                al.add(new UserDto(rs.getInt("id"), rs.getString("login"), rs.getString("name")));
            }
        } catch (DtoException ex) {
            throw new DBException("Instanciation de "+recordName+" impossible:\nDTOException: " + ex.getMessage());
        } catch (java.sql.SQLException eSQL) {
            throw new DBException("Instanciation de "+recordName+" impossible:\nSQLException: " + eSQL.getMessage());
        }
        return al;
    }

    /**
     *
     * @param id
     * @throws DbException
     */
    public static void deleteDb(int id) throws DBException {
        try {
            java.sql.Statement stmt = DBManager.getConnection().createStatement();
            stmt.execute("delete from Users where id=" + id);
        } catch (Exception ex) {
            throw new DBException(recordName+": suppression impossible\n" + ex.getMessage());
        }
    }

    /**
     *
     * @param record
     * @throws DbException
     */
    public static void updateDb(UserDto record) throws DBException {
        try {
            java.sql.Connection connexion = DBManager.getConnection();

            java.sql.PreparedStatement update;
            String sql = "Update USERS set "
                    + "login=?, "                    
                    + "name=? "
                    + "where id=?";
            update = connexion.prepareStatement(sql);
            update.setString(1, record.getLogin());            
            update.setString(2, record.getName());
            update.setInt(3, record.getId());
            update.executeUpdate();
        } catch (Exception ex) {
            throw new DBException(recordName+", modification impossible:\n" + ex.getMessage());
        }
    }

    /**
     *
     * @param record
     * @return
     * @throws DbException
     */
    public static int insertDb(UserDto record) throws DBException {
        try {
            int num = SequenceDB.getNextNum(SequenceDB.USERS);
            java.sql.Connection connexion = DBManager.getConnection();
            java.sql.PreparedStatement insert;
            insert = connexion.prepareStatement(
                    "Insert into USERS(id, login, name) "
                    + "values(?, ?, ? )");
            insert.setInt(1, num);
            insert.setString(2, record.getLogin());
            insert.setString(3, record.getName());
            insert.executeUpdate();
            return num;
        } catch (Exception ex) {
            throw new DBException(recordName+": ajout impossible\n" + ex.getMessage());
        }
    }

    //faire une methode sur un attribut particulier un boolean active par exemple
}
