package be.he2b.atlr5.skyjo.db;

import be.he2b.atlr5.skyjo.exception.DBException;

/**
 *
 * @author mad8
 */
public class SequenceDB {
    static final String USERS = "USERS";

    static synchronized int getNextNum(String sequence) throws DBException {
        try {
            java.sql.Connection connexion = DBManager.getConnection();
            String query = "Update SEQUENCES set sValue = sValue+1 where id='" + sequence + "'";
            java.sql.PreparedStatement update = connexion.prepareStatement(query);
            update.execute();
            java.sql.Statement stmt = connexion.createStatement();
            query = "Select sValue FROM Sequences where id='" + sequence + "'";
            java.sql.ResultSet rs = stmt.executeQuery(query);
            int nvId;
            if (rs.next()) {
                nvId = rs.getInt("sValue");
                return nvId;
            } else {
                throw new DBException("Nouveau n° de séquence inaccessible!");
            }
        } catch (java.sql.SQLException eSQL) {
            throw new DBException("Nouveau n° de séquence inaccessible!\n" + eSQL.getMessage());
        }
    }
}
