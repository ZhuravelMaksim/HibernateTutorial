package com.it.app;

import com.it.dao.AddressDAO;
import com.it.dao.UserDAO;
import com.it.dao.impl.AddressDAOImpl;
import com.it.dao.impl.UserDAOImpl;
import com.it.model.Address;
import com.it.model.User;

public class Main {
    private static final UserDAO userDAO = UserDAOImpl.getInstance();
    private static final AddressDAO addressDAO = AddressDAOImpl.getInstance();

    public static void main(String[] arguments) {
        Address address = getAddress();

        performUserOperations(address);
    }

    private static Address getAddress() {
        Address address = addressDAO.getOne(1L);
        if (address == null) {
            createAddress("NY", "33 penny st.", 221L);
        }
        return addressDAO.getOne(1L);
    }

    private static void createAddress(String city, String street, Long number) {
        Address transientAddress = new Address();
        transientAddress.setCity(city);
        transientAddress.setStreet(street);
        transientAddress.setNumber(number);
        addressDAO.save(transientAddress);
    }

    private static void performUserOperations(Address adress) {
        User user = userDAO.getOne(1L);
        if (user == null) {
            createUser("John Doe", 33, adress);
        }
        User persistentUser = userDAO.getOne(1L);
        updateUserName(persistentUser, "James Doe");
        userDAO.delete(1L);
    }

    private static void updateUserName(User persistentUser, String name) {
        persistentUser.setName(name);
        userDAO.update(persistentUser);
    }

    private static void createUser(String name, Integer age, Address address) {
        User transientUser = new User();
        transientUser.setName(name);
        transientUser.setAge(age);
        transientUser.setAddress(address);
        userDAO.save(transientUser);
    }
}
