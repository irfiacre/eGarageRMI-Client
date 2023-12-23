/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package helpers;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import java.util.regex.*;
import model.Cars;
import model.Mechanic;
import model.Staff;
import service.CarsService;
import service.MechanicService;
import service.StaffService;
import view.AdminView;
import view.CashierView;
import view.LoginView;
import view.MechanicView;

/**
 *
 * @author busyDev
 */
public class Helpers {

    private static Integer SERVER_PORT = 8000;

    public static final Pattern VALID_EMAIL_ADDRESS_REGEX = Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);

    public void navigateToAdminView(Staff staff) {
        AdminView adminFrame = new AdminView(staff);
        LoginView loginFrame = new LoginView();
        MechanicView mechFrame = new MechanicView();
        CashierView cashFrame = new CashierView();

        loginFrame.setVisible(false);
        mechFrame.setVisible(false);
        cashFrame.setVisible(false);
        adminFrame.setVisible(true);
    }

    public void navigateToCashierView(Staff staff) {
        AdminView adminFrame = new AdminView();
        LoginView loginFrame = new LoginView();
        MechanicView mechFrame = new MechanicView();
        CashierView cashFrame = new CashierView(staff);

        loginFrame.setVisible(false);
        mechFrame.setVisible(false);
        cashFrame.setVisible(true);
        adminFrame.setVisible(false);
    }

    public void navigateToMechanicView(Mechanic mechanic) {
        AdminView adminFrame = new AdminView();
        LoginView loginFrame = new LoginView();
        MechanicView mechFrame = new MechanicView(mechanic);
        CashierView cashFrame = new CashierView();

        loginFrame.setVisible(false);
        mechFrame.setVisible(true);
        cashFrame.setVisible(false);
        adminFrame.setVisible(false);
    }

    public void logout() {
        AdminView adminFrame = new AdminView();
        LoginView loginFrame = new LoginView();
        MechanicView mechFrame = new MechanicView();
        CashierView cashFrame = new CashierView();

        loginFrame.setVisible(true);
        mechFrame.setVisible(false);
        cashFrame.setVisible(false);
        adminFrame.setVisible(false);
    }

    public boolean validateEmail(String emailStr) {
        if (emailStr.isEmpty()) {
            return false;
        }
        Matcher matcher = VALID_EMAIL_ADDRESS_REGEX.matcher(emailStr);
        return matcher.matches();
    }

    public Staff findStaff(String username) {
        try {
            Registry theRegistry = LocateRegistry.getRegistry("127.0.0.1", SERVER_PORT);
            StaffService staffService = (StaffService) theRegistry.lookup("staff");

            Staff theStaff = new Staff();
            theStaff.setUsername(username);
            Staff staffObj = staffService.searchStaffById(theStaff);

            if (staffObj != null) {
                return staffObj;
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }

    public Mechanic findMechanic(String username) {
        try {
            Registry theRegistry = LocateRegistry.getRegistry("127.0.0.1", SERVER_PORT);
            MechanicService mechanicService = (MechanicService) theRegistry.lookup("mechanic");

            Mechanic theMechanic = new Mechanic();
            theMechanic.setUsername(username);
            Mechanic mechanicObj = mechanicService.searchMechanicById(theMechanic);
            if (mechanicObj != null) {
                return mechanicObj;
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }

    public Cars findCar(Integer carId) {
        Registry theRegistry;
        Cars carObj = null;

        try {
            theRegistry = LocateRegistry.getRegistry("127.0.0.1", 8000);
            CarsService carsService = (CarsService) theRegistry.lookup("cars");
            Cars theCar = new Cars();
            theCar.setId(carId);

            carObj = carsService.searchCarById(theCar);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return carObj;
    }
}
