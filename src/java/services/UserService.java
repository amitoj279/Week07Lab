package services;

import dataaccess.RoleDB;
import models.User;
import java.util.List;
import dataaccess.UserDB;
import java.util.ArrayList;
import models.Role;

public class UserService {

    public User get(String email) throws Exception {
        UserDB db = new UserDB();
        User user = db.getUser(email);
        return user;
    }

    public List<User> getAll() throws Exception {
        UserDB db = new UserDB();
        ArrayList<User> userList = (ArrayList<User>) db.getActive();
        return userList;
    }
    /**
     * @Author David and Ayden With leadership from Ember
     */
    public int update(String email, String fname, String lname, String password, int roleID) throws Exception {
        UserDB db = new UserDB();
        RoleDB rdb = new RoleDB();
        Role role = rdb.getRole(roleID);
        User user = new User(email, fname, lname, password, role);
        return db.update(user);
    }

    /**
     * @Author David and Ayden With leadership from Ember
     */
    public int delete(String email) throws Exception {
        UserDB db = new UserDB();
        User user = get(email);
        user.setActive(false);
        int i = db.update(user);
        return i;
    }
    /**
     * @Author David and Ayden With leadership from Ember
     */
    public int insert(String email, String fname, String lname, String password, int roleID) throws Exception {
        UserDB db = new UserDB();
        RoleDB rdb = new RoleDB();
        Role role = rdb.getRole(roleID);
        User user = new User(email, fname, lname, password, role);
        int i = db.insert(user);
        return i;
    }

}
