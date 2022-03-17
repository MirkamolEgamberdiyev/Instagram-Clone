package com.mirkamol.roomdatabase.database;

import android.app.Application;

import com.mirkamol.roomdatabase.manager.RoomManager;
import com.mirkamol.roomdatabase.model.User;

import java.util.List;

public class UserRepository {
    private UserDao userDao;
    public UserRepository(Application application){
        RoomManager db = RoomManager.getDatabase(application);
        userDao = db.usersDao();
    }

    public List<User> getUsers(){
        return userDao.getUsers();
    }
    public void saveUser(User user){
        userDao.saveUser(user);
    }
}
