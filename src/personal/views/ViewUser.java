package personal.views;

import personal.controllers.UserController;
import personal.model.User;
import personal.views.validator.NameSurnameValidator;

import java.util.List;

import java.util.Scanner;


public class ViewUser {

    private UserController userController;

    public ViewUser(UserController userController) {
        this.userController = userController;
    }

    public void run() {
        Commands com = Commands.NONE;

        while (true) {
            String command = prompt("Введите команду: ");
            try {
                com = Commands.valueOf(command.toUpperCase());
                if (com == Commands.EXIT) return;
                switch (com) {
                    case CREATE:
                        createUser();
                        break;
                    case READ:
                        readUser();
                        break;
                    case LIST:
                        readList();
                        break;
                    case UPDATE:
                        updateUser();
                        break;
                    case HELP:
                        showHelp();
                        break;
                    case DELETE:
                        deleteUser();
                        break;
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private void deleteUser() throws Exception {
        readList();
        User user = getUser();
        User deletedUser = userController.deleteUser(user);
        System.out.println("Удалили: ");
        System.out.println(deletedUser);
    }

    private void showHelp() {
        System.out.println("Список команд:");
        for(Commands c : Commands.values()) {
            System.out.println(c);
        }
    }

    private void updateUser() throws Exception {
        readList();
        User user = getUser();
        User newUser = getNewUser();
        newUser.setId(user.getId());
        User savedUser = userController.updatedUser(newUser);
        System.out.println("Обновили: ");
        System.out.println(savedUser);
    }


    private void readList() {
        List<User> listUsers = userController.readAllUsers();
        for (User user : listUsers) {
            System.out.println(user);
        }

    }

    private void readUser() throws Exception {
        User user = getUser();
        System.out.println(user);
    }

    private User getUser() throws Exception {
        String id = prompt("Идентификатор пользователя: ");
        User user = userController.readUser(id);
        return user;
    }

    private void createUser() throws Exception {
        User user = getNewUser();
        userController.saveUser(user);
    }

    private User getNewUser() throws Exception {
        String firstName = prompt("Имя: ");
        new NameSurnameValidator(firstName).validate();
        String lastName = prompt("Фамилия: ");
        new NameSurnameValidator(lastName).validate();
        String phone = prompt("Номер телефона: ");
        User user = new User(firstName, lastName, phone);
        return user;
    }

    private String prompt(String message) {
        Scanner in = new Scanner(System.in);
        System.out.print(message);
        return in.nextLine();
    }
}
