package src;

import src.entites.User;
import src.exceptions.UserNotFoundException;

public interface Manager {
    void add();
    void showList();
    void delete();
    void update();
    void search();
    User findUserByPhoneNumber(String phone) throws UserNotFoundException;
    void saveDataToFile();
}
