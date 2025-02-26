/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package payrollsystem;

import java.util.HashMap;
import java.util.Scanner;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

class User {
    private static final HashMap<String, String> users = new HashMap<>();
    
    static {
        users.put("admin", "admin123"); // Admin login
        users.put("10001", "PrivateEquity47");
        users.put("10002", "developer123");
        users.put("10003", "staff456");
        users.put("10004", "employee789");
        users.put("10005", "employee101");
    }

    public static boolean authenticate(String username, String password) {
        return users.containsKey(username) && users.get(username).equals(password);
    }
}

class Employee {
    private String employeeNumber;
    private String name;
    private String birthday;
    private String phoneNumber;
    private String address;
    private String sssNumber;
    private String philHealthNumber;
    private String tinNumber;
    private String pagIbigNumber;
    private String role;
    private double basicSalary;
    private double riceSubsidy;
    private double phoneAllowance;
    private double clothingAllowance;
    private double grossSemiMonthly;
    private double hourlyRate;
    private int hoursWorked = 9; // Fixed hours from 8 AM to 5 PM
    private LocalDateTime loginTime;
    private LocalDateTime logoutTime;

    public Employee(String employeeNumber, String name, String birthday, String phoneNumber, String address,
                    String sssNumber, String philHealthNumber, String tinNumber, String pagIbigNumber,
                    String role, double basicSalary, double riceSubsidy, double phoneAllowance,
                    double clothingAllowance, double grossSemiMonthly, double hourlyRate) {
        this.employeeNumber = employeeNumber;
        this.name = name;
        this.birthday = birthday;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.sssNumber = sssNumber;
        this.philHealthNumber = philHealthNumber;
        this.tinNumber = tinNumber;
        this.pagIbigNumber = pagIbigNumber;
        this.role = role;
        this.basicSalary = basicSalary;
        this.riceSubsidy = riceSubsidy;
        this.phoneAllowance = phoneAllowance;
        this.clothingAllowance = clothingAllowance;
        this.grossSemiMonthly = grossSemiMonthly;
        this.hourlyRate = hourlyRate;
    }

    public static Employee createDefaultEmployee(String empNumber) {
        if (empNumber.equals("10001")) {
            return new Employee("10001", "Manuel III Garcia", "10/11/1983", "966-860-270", "Valero Carpark Building Valero Street 1227, Makati City",
                "44-4506057-3", "820126853951", "442-605-657-000", "691295330870", "Chief Executive Officer",
                90000.0, 1500.0, 2000.0, 1000.0, 45000.0, 535.71);
        } else if (empNumber.equals("10002")) {
            return new Employee("10002", "Antonio Lim", "06/19/1988", "171-867-411", "San Antonio De Padua 2, Block 1 Lot 8 and 2, Dasmarinas, Cavite",
                "171-867-411", "331735646338", "683-102-776-000", "663904995411", "Chief Operating Officer",
                60000.0, 1500.0, 2000.0, 1000.0, 30000.0, 357.14);
        } else if (empNumber.equals("10003")) {
            return new Employee("10003", "Bianca Sofia Aquino", "08/04/1989", "966-889-370", "Rm. 402 4/F Jiao Building Timog Avenue Cor. Quezon Avenue 1100, Quezon City",
                "30-8870406-2", "177451189665", "971-711-280-000", "171519773969", "Chief Finance Officer",
                60000.0, 1500.0, 2000.0, 1000.0, 30000.0, 357.14);
        }
        return null;
    }

    public void logInAutomatically() {
        loginTime = LocalDateTime.now().withHour(8).withMinute(0).withSecond(0);
        logoutTime = loginTime.withHour(17).withMinute(0).withSecond(0);
        System.out.println("Employee " + name + " logged in at: " + loginTime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
        System.out.println("Employee " + name + " logged out at: " + logoutTime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
    }

    public double calculateGrossWage() {
        return hoursWorked * hourlyRate;
    }

    public double calculateNetWage() {
        double totalBenefitsDeduction = 1000.0 + 500.0 + 500.0; // SSS, Pag-ibig, PhilHealth deductions
        return Math.max(calculateGrossWage() - totalBenefitsDeduction, 0);
    }

    public void displaySalary() {
        System.out.println("Employee Number: " + employeeNumber);
        System.out.println("Employee Name: " + name);
        System.out.println("Birthday: " + birthday);
        System.out.println("Phone Number: " + phoneNumber);
        System.out.println("Address: " + address);
        System.out.println("SSS Number: " + sssNumber);
        System.out.println("PhilHealth Number: " + philHealthNumber);
        System.out.println("TIN Number: " + tinNumber);
        System.out.println("Pag-ibig Number: " + pagIbigNumber);
        System.out.println("Role: " + role);
        System.out.println("Basic Salary: PHP " + basicSalary);
        System.out.println("Rice Subsidy: PHP " + riceSubsidy);
        System.out.println("Phone Allowance: PHP " + phoneAllowance);
        System.out.println("Clothing Allowance: PHP " + clothingAllowance);
        System.out.println("Gross Semi-Monthly Salary: PHP " + grossSemiMonthly);
        System.out.println("Hourly Rate: PHP " + hourlyRate);
        System.out.println("Total Hours Worked: " + hoursWorked);
        System.out.println("Gross Wage: PHP " + calculateGrossWage());
        System.out.println("Deductions:");
        System.out.println("  SSS: PHP 1000.00");
        System.out.println("  Pag-ibig: PHP 500.00");
        System.out.println("  PhilHealth: PHP 500.00");
        System.out.println("Total Benefits Deduction: PHP 2000.00");
        System.out.println("Net Wage: PHP " + calculateNetWage());
    }
}

public class PayrollSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter username: ");
        String username = scanner.nextLine();
        System.out.print("Enter password: ");
        String password = scanner.nextLine();
        
        if (User.authenticate(username, password)) {
            System.out.println("Login successful!");
            Employee employee = Employee.createDefaultEmployee(username);
            if (employee != null) {
                employee.logInAutomatically();
                employee.displaySalary();
            } else {
                System.out.println("Employee not found.");
            }
        } else {
            System.out.println("Login failed. Incorrect username or password.");
        }
        scanner.close();
    }
}
