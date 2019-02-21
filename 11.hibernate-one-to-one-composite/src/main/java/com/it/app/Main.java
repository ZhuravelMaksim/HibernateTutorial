package com.it.app;

import com.it.dao.AddressDAO;
import com.it.dao.UserDAO;
import com.it.dao.impl.AddressDAOImpl;
import com.it.dao.impl.UserDAOImpl;
import com.it.model.Address;
import com.it.model.User;
import com.it.model.UserId;

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
        UserId userId = new UserId("John", "Doe");
        createUser(userId, 33, adress);
        User persistentUser = userDAO.getOne(userId);
        updateUserName(persistentUser, 22);
        userDAO.delete(userId);
    }

    private static void updateUserName(User persistentUser, Integer age) {
        persistentUser.setAge(age);
        userDAO.update(persistentUser);
    }

    private static void createUser(UserId userId, Integer age, Address address) {
        User transientUser = new User();
        transientUser.setId(userId);
        transientUser.setAge(age);
        transientUser.setAddress(address);
        userDAO.save(transientUser);
    }
}
