package dev.xue.services;

import dev.xue.models.User;
import dev.xue.repositories.UserRepo;
import dev.xue.repositories.jdbc.UserJDBC;

import java.util.List;

// Where we are going to put any business logic needed for the application to function the way we want.
// Specifically any services that need to be available to our users.
public class UserServices {

    UserRepo userRepo = new UserJDBC();

    public boolean login(String username, String password) {

        // in order to log in a user, we will need username and password
        // that information is stored in our database
        // the repository layer needs to take care of this

        User u = userRepo.getByUsername(username); // more of the Sole Responsibility Principle at work

        // check to make sure User object is not null
        if (u != null) {
            // now check to make sure it matches
            if (username.equals(u.getUsername()) && password.equals(u.getPassword())) {
                return true;
            }
        }
        return false;
    }
    public List<User> getAllUsers() {

        return userRepo.getAll();

    }
    public User getUser(String username) {

        return userRepo.getByUsername(username);

    }


}
