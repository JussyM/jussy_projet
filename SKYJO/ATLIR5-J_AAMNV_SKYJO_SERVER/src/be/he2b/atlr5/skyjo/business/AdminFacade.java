/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package be.he2b.atlr5.skyjo.business;

import be.he2b.atlr5.skyjo.dbdto.UserDto;
import be.he2b.atlr5.skyjo.exception.DBBusinessException;
import java.util.List;

/**
 *
 * @author mad8
 */
public interface AdminFacade {
    /**
     * Returns a list of all users.
     *
     * @return a list of all users.
     * @throws DBBusinessException if the query failed.
     */
    List<UserDto> getUsers() throws DBBusinessException;

    /**
     * Returns the unique user with the given id.
     *
     * @param id user's id.
     * @return the unique user with the given id.
     * @throws be.he2b.atlr5.skyjo.exception.DBBusinessException
     */
    UserDto getUser(int id) throws DBBusinessException;

    /**
     * Returns the last user with the given name.
     *
     * @param name user's name.
     * @return the last user with the given name.
     * @throws be.he2b.atlr5.skyjo.exception.DBBusinessException
     * @throws SQLException if the query failed.
     */
    UserDto getUser(String name) throws DBBusinessException;

    /**
     * Creates a user and insert it in the database.Returns the user's id.
     *
     * @param login user's login.
     * @param name user's name.
     * @return the user's id.
     * @throws be.he2b.atlr5.skyjo.exception.DBBusinessException
     * @throws SQLException if the query failed.
     */
    int addUser(String login, String name) throws DBBusinessException;

    /**
     * Removes the given user.
     *
     * @param user user to delete.
     * @throws be.he2b.atlr5.skyjo.exception.DBBusinessException
     * @throws SQLException if the query failed.
     */
    void removeUser(UserDto user) throws DBBusinessException;

    /**
     * Updates the given user.
     *
     * @param current
     * @param user user to update.
     * @throws be.he2b.atlr5.skyjo.exception.DBBusinessException
     * @throws SQLException if the query failed.
     */
    void updateUser(UserDto current) throws DBBusinessException;

    /**
     * Returns a random user from the database.
     *
     * @return a random user from the database.
     * @throws be.he2b.atlr5.skyjo.exception.DBBusinessException
     */
    UserDto getRandomUser() throws DBBusinessException;
}
