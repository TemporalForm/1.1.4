package jm.task.core.jdbc;

import jm.task.core.jdbc.service.UserService;
import jm.task.core.jdbc.service.UserServiceImpl;

public class Main {
    public static void main(String[] args) {
        UserService userService = new UserServiceImpl();
        userService.createUsersTable();
        userService.saveUser("John", "Doe", (byte) 18);
        userService.saveUser("Jane", "Doe", (byte) 18);
        userService.saveUser("Ollanius", "Pius", (byte) 127);
        userService.saveUser("Firraeveus", "Carron", (byte) 99);
        userService.removeUserById(2);
        userService.getAllUsers();
        userService.dropUsersTable();
    }
}
