package Users;

import Ordering.Order;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class RegisteredCustomer extends Customer{

    private String username;
    private String password;
    private String email;
    private String phone;
    private static boolean isActive;
    private int loyaltyPoints;
    private Order[] orderHistory;

    public RegisteredCustomer() {

    }
    public RegisteredCustomer(String uName,  String passWord, String eMail, String uPhone ) {
        super();
        this.username = uName;
        this.password = passWord;
        this.email = eMail;
        this.phone = uPhone;
        this.isActive = true;
        this.loyaltyPoints = 0;
    }
    public void showInfo(){
        System.out.println("ID: " + getId());
        System.out.println("Username: " + username);
        System.out.println("Email: " + getEmail());
        System.out.println("Phone: " + phone);
        System.out.println("Loyalty Points: " + loyaltyPoints);
    }

    public String getUsername() {
        return username;
    }


    public String getPassword() {
        return password;
    }


    public String getEmail() {
        return email;
    }





    public  RegisteredCustomer logIn(String username, String password) {
    try (BufferedReader reader = new BufferedReader(new FileReader("CustomersData.txt"))) {
        String line;
        while ((line = reader.readLine()) != null) {
            String[] userData = line.split(" \\| ");

            if (userData.length >= 2) {
                String storedUsername = userData[0].trim();
                String storedPassword = userData[1].trim();
                if (username.equals(storedUsername) && password.equals(storedPassword)) {
                    System.out.println("Login successful.");
                    return this;
                }
            }
        }
        System.out.println("Invalid username or password.");
        return null;
    } catch (IOException e) {
        System.out.println("Error reading user data: " + e.getMessage());
        return null;
    }
}


}
