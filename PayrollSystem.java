package motorphpayrollsystem;

import java.util.HashMap;
import java.util.Scanner;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class MotorPHPayrollSystem {
    static List<Employee> employees = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Payroll System is running...");
        System.out.println("1. Employee Login");
        System.out.println("2. Admin Dashboard");
        System.out.print("Choose an option: ");
        int choice = scanner.nextInt();
        scanner.nextLine(); // Consume the newline

        if (choice == 1) {
            // Employee login
            System.out.print("Enter Employee Number: ");
            String empNumber = scanner.nextLine();

            System.out.print("Enter Password: ");
            String password = scanner.nextLine();

            if (User.authenticate(empNumber, password)) {
                System.out.println("Login successful!");
                Employee employee = Employee.createDefaultEmployee(empNumber);
                if (employee != null) {
                    employee.trackLoginTime();  // Automatically track login time
                    employee.displaySalary();
                    employee.fileLeaveRequest();  // Option to file PTO or leave
                    employee.generatePayslip();  // Generate payslip
                    saveEmployeeData(employee);  // Save data to file
                }
            } else {
                System.out.println("Invalid credentials.");
            }
        } else if (choice == 2) {
            // Admin dashboard
            AdminDashboard.showDashboard();
            System.out.println("Admin functionality to manage employees.");
        }
        scanner.close();
    }

    // Method to save employee data to a file
    public static void saveEmployeeData(Employee employee) {
        try (FileWriter writer = new FileWriter("employees.txt", true)) {
            writer.write("Employee Number: " + employee.employeeNumber + "\n");
            writer.write("Name: " + employee.name + "\n");
            writer.write("Role: " + employee.role + "\n");
            writer.write("Basic Salary: " + employee.basicSalary + "\n");
            writer.write("Immediate Supervisor: " + employee.immediateSupervisor + "\n");
            writer.write("Login Time: " + employee.loginTime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")) + "\n");
            writer.write("Logout Time: " + employee.logoutTime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")) + "\n");
            writer.write("PTO Days Taken: " + employee.ptoDaysTaken + "\n");
            writer.write("Salary History: " + employee.salaryHistory + "\n");
            writer.write("---------------------------\n");
        } catch (IOException e) {
            System.out.println("An error occurred while saving employee data.");
        }
    }

    private static class AdminDashboard {

        private static void showDashboard() {
            throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        }

        public AdminDashboard() {
        }
    }
}

class User {
    private static final HashMap<String, String> users = new HashMap<>();

    static {
        users.put("admin", "chickennuggets"); // Admin login
        users.put("10001", "PrivateEquity47");
        users.put("10002", "developer123");
        users.put("10003", "kissme");
        users.put("10004", "chickenjoy");
        users.put("10005", "igafayt");
        users.put("10006", "shakeee");
        users.put("10007", "employee");
        users.put("10008", "snacktime");
        users.put("10009", "roadme");
        users.put("10010", "employee10");
        users.put("10011", "employee11");
        users.put("10012", "employee12");
        users.put("10013", "employee13");
        users.put("10014", "employee14");
        users.put("10015", "employee15");
        users.put("10016", "employee16");
        users.put("10017", "employee17");
        users.put("10018", "employee18");
        users.put("10019", "employee19");
        users.put("10020", "employee20");
        users.put("10021", "employee21");
        users.put("10022", "employee22");
        users.put("10023", "employee23");
        users.put("10024", "employee24");
        users.put("10025", "employee25");
        users.put("10026", "employee26");
        users.put("10027", "employee27");
        users.put("10028", "employee28");
        users.put("10029", "employee29");
        users.put("10030", "employee30");
        users.put("10031", "employee31");
        users.put("10032", "employee32");
        users.put("10033", "employee33");
        users.put("10034", "employee34");

        
    }

    public static boolean authenticate(String username, String password) {
        return users.containsKey(username) && users.get(username).equals(password);
    }
}

class Employee {
    String employeeNumber;
    String name;
    String birthday;
    String phoneNumber;
    String address;
    String sssNumber;
    String philHealthNumber;
    String tinNumber;
    String pagIbigNumber;
    String role;
    double basicSalary;
    double riceSubsidy;
    double phoneAllowance;
    double clothingAllowance;
    double grossSemiMonthly;
    double hourlyRate;
    String immediateSupervisor;
    int hoursWorked = 9; // Fixed hours from 8 AM to 5 PM
    LocalDateTime loginTime;
    LocalDateTime logoutTime;
    int ptoDaysTaken = 0;
    SalaryHistory salaryHistory = new SalaryHistory();

    public Employee(String employeeNumber, String name, String birthday, String phoneNumber, String address, String sssNumber, String philHealthNumber, String tinNumber, String pagIbigNumber) {
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
        this.immediateSupervisor = immediateSupervisor;
    }

    public static Employee createDefaultEmployee(String empNumber) {
        switch (empNumber) {
            case "10001" -> {
                return new Employee("10001", "Manuel III Garcia", "10/11/1983", "966-860-270", "Valero Carpark Building Valero Street 1227, Makati City",
                        "44-4506057-3", "820126853951", "442-605-657-000", "691295330870");
            }
            case "10002" -> {
                return new Employee("10002", "Antonio Lim", "06/19/1988", "171-867-411", "San Antonio De Padua 2, Block 1 Lot 8 and 2, Dasmarinas, Cavite",
                        "171-867-411", "331735646338", "683-102-776-000", "663904995411");
            }
            case "10003" -> {
                return new Employee("10003", "Bianca Sofia Aquino", "08/04/1989", "966-889-370", "Rm. 402 4/F Jiao Building Timog Avenue Cor. Quezon Avenue 1100, Quezon City",
                        "30-8870406-2", "177451189665", "971-711-280-000", "171519773969");
            }
            case "10004" -> {
                return new Employee("10004", "Isabela Reyes", "06/16/1994", "786-868-477", "460 Solanda Street Intramuros 1000, Manila",
                        "40-2511815-0", "341911411254", "876-809-437-000", "416946776041");
            }
            case "10005" -> {
                return new Employee("10005", "Eduard Hernandez", "09/23/1989", "088-861-012", "National Highway, Gingoog, Misamis Occidental",
                        "50-5577638-1", "957436191812", "031-702-374-000", "952347222457");
            }
            case "10006" -> {
                return new Employee("10006", "Andrea Mae Villanueva ", "02/14/1988", "918-621-603", "17/85 Stracke Via Suite 042, Poblacion, Las Piñas 4783 Dinagat Islands ",
                        "49-1632020-8", "382189453145", "317-674-022-000", "441093369646");
            }
            case "10007" -> {
                return new Employee("10007", "Brad San Jose ", "03/15/1996", "797-009-261", "99 Strosin Hills, Poblacion, Bislig 5340 Tawi-Tawi ",
                        "40-2400714-1", "239192926939", "672-474-690-000", "210850209964");
            }
            case "10008" -> {
                return new Employee("10008", "Alice Romualdez", "05/14/1992", "983-606-799", "12A/33 Upton Isle Apt. 420, Roxas City 1814 Surigao del Norte ",
                        "55-4476527-2", "545652640232", "888-572-294-000", "210850209964");
            }
            case "10009" -> {
                return new Employee("10009", "Rosie Atienza", "09/24/1948", "266-036-427", "90A Dibbert Terrace Apt. 190, San Lorenzo 6056 Davao del Norte",
                        "41-0644692-3", "708988234853", "604-997-793-000", "260107732354");
            }
            case "10010" -> {
                return new Employee("10010", "Roderick Alvaro", "05/14/1992", "053-381-386", "#284 T. Morato corner, Scout Rallos Street, Quezon City ",
                        "64-7605054-4", "578114853194", "525-420-419-000", "799254095212");
            }
            case "10011" -> {
                return new Employee("10011", "Anthony Salcedo", "09/14/1993", "070-766-300", "93/54 Shanahan Alley Apt. 183, Santo Tomas 1572 Masbate ",
                        "26-9647608-3", "126445315651", "210-805-911-000", "218002473454");
            }
            case "10012" -> {
                return new Employee("10012", "Josie Lopez", "01/14/1987", "478-355-427", "49 Springs Apt. 266, Poblacion, Taguig 3200 Occidental Mindoro ",
                        "44-8563448-3", "431709011012", "218-489-737-000", "113071293354");
            }
            case "10013" -> {
                return new Employee("10013", "Martha Farala", "01/11/1942", "329-034-366", "42/25 Sawayn Stream, Ubay 1208 Zamboanga del Norte ",
                        "45-5656375-0", "233693897247", "210-835-851-000", "631130283546");
            }
            case "10014" -> {
                return new Employee("10014", "Leila Martinez", "07/11/1970", "877-110-749", "37/46 Kulas Roads, Maragondon 0962 Quirino  ",
                        "27-2090996-4", "515741057496", "275-792-513-000", "101205445886");
            }
            case "10015" -> {
                return new Employee("10015", "Fredrick Romualdez ", "03/10/1985", "877-110-749", "22A/52 Lubowitz Meadows, Pililla 4895 Zambales ",
                        "26-8768374-1", "308366860059", "598-065-761-000", "223057707853");
            }
            case "10016" -> {
                return new Employee("10016", "Christian Mata", "10/21/1987", "783-776-744", "90 O'Keefe Spur Apt. 379, Catigbian 2772 Sulu  ",
                        "49-2959312-6", "824187961962", "103-100-522-000", "631052853464");
            }
            case "10017" -> {
                return new Employee("10017", "Selena De Leon ", "02/20/1975", "975-432-139", "89A Armstrong Trace, Compostela 7874 Maguindanao",
                        "27-2090208-8", "587272469938", "482-259-498-000", "719007608464");
            }
            case "10018" -> {
                return new Employee("10018", "Allison San Jose ", "06/24/1986", "179-075-129", "08 Grant Drive Suite 406, Poblacion, Iloilo City 9186 La Union",
                        "45-3251383-0", "745148459521", "121-203-336-000", "114901859343");
            }
            case "10019" -> {
                return new Employee("10019", "Cydney Rosario ", "10/06/1996", "868-819-912", "93A/21 Berge Points, Tapaz 2180 Quezon",
                        "49-1629900-2", "579253435499", "122-244-511-000", "265104358643");
            }
            case "10020" -> {
                return new Employee("10020", "Mark Bautista  ", "02/12/1991", "683-725-348", "65 Murphy Center Suite 094, Poblacion, Palayan 5636 Quirino",
                        "49-1647342-5", "399665157135", "273-970-941-000", "260054585575");
            }
            case "10021" -> {
                return new Employee("10021", "Darlene Lazaro  ", "11/25/1985", "740-721-558", "47A/94 Larkin Plaza Apt. 179, Poblacion, Caloocan 2751 Quirino",
                        "45-5617168-2", "606386917510", "354-650-951-000", "104907708845");
            }
            case "10022" -> {
                return new Employee("10022", "Kolby Delos Santos  ", "02/26/1980", "739-443-033", "06A Gulgowski Extensions, Bongabon 6085 Zamboanga del Sur",
                        "52-0109570-6", "357451271274", "187-500-345-000", "113017988667");
            }
            case "10023" -> {
                return new Employee("10023", "Vella Santos  ", "12/31/1983", "955-879-269", "99A Padberg Spring, Poblacion, Mabalacat 3959 Lanao del Sur",
                        "52-9883524-3", "548670482885", "101-558-994-000", "360028104576");
            }
            case "10024" -> {
                return new Employee("10024", "Tomas Del Rosario", "12/18/1978", "882-550-989", "80A/48 Ledner Ridges, Poblacion, Kabankalan 8870 Marinduque",
                        "45-5866331-6", "953901539995", "560-735-732-000", "913108649964");
            }
            case "10025" -> {
                return new Employee("10025", "Jacklyn Tolentino ", "05/19/1984", "675-757-366", "96/48 Watsica Flats Suite 734, Poblacion, Malolos 1844 Ifugao",
                        "47-1692793-0", "753800654114", "841-177-857-000", "210546661243");
            }
            case "10026" -> {
                return new Employee("10026", "Percival Gutierrez ", "12/18/1970", "512-899-876", "58A Wilderman Walks, Poblacion, Digos 5822 Davao del Sur",
                        "40-9504657-8", "797639382265", "502-995-671-000", "210897095686");
            }
            case "10027" -> {
                return new Employee("10027", "Garfield Manalaysay ", "08/28/1986", "948-628-136", "60 Goyette Valley Suite 219, Poblacion, Tabuk 3159 Lanao del Sur",
                        "45-3298166-4", "810909286264", "336-676-445-000", "211274476563");
            }
            case "10028" -> {
                return new Employee("10028", "Lizeth Villegas  ", "12/12/1981", "332-372-215", "66/77 Mann Views, Luisiana 1263 Dinagat Islands",
                        "40-2400719-4", "934389652994", "210-395-397-000", "122238077997");
            }
            case "10029" -> {
                return new Employee("10029", "Carol Ramos  ", "08/20/1978", "250-700-389", "72/70 Stamm Spurs, Bustos 4550 Iloilo",
                        "60-1152206-4", "351830469744", "395-032-717-000", "212141893454");
            }
            case "10030" -> {
                return new Employee("10030", "Emelia Maceda  ", "04/14/1973", "973-358-041", "50A/83 Bahringer Oval Suite 145, Kiamba 7688 Nueva Ecija",
                        "54-1331005-0", "465087894112", "215-973-013-000", "515012579765");
            }
            case "10031" -> {
                return new Employee("10031", "Delia Aguilar  ", "01/27/1989", "529-705-439", "95 Cremin Junction, Surallah 2809 Cotabato",
                        "52-1859253-1", "136451303068", "599-312-588-000", "110018813465");
            }
            case "10032" -> {
                return new Employee("10032", "John Rafael Castro  ", "02/09/1992", "332-424-955 ", "9Hi-way, Yati, Liloan Cebu",
                        "26-7145133-4", "601644902402", "404-768-309-000", "697764069311");
            }
            case "10033" -> {
                return new Employee("10033", "Carlos Ian Martinez ", "11/16/1990", "078-854-208", "Bulala, Camalaniugan",
                        "11-5062972-7", "380685387212", "256-436-296-000", "993372963726");
            }
            case "10034" -> { 
                return new Employee("10034", " Beatrice Santos ", "08/07/1990", "526-639-511", "Agapita Building, Metro Manila",
                        "20-2987501-5", "918460050077", "911-529-713-000", "874042259378");
            }
            default -> {
            }
        }
        return null;
    }

    public void trackLoginTime() {
        loginTime = LocalDateTime.now();
        logoutTime = loginTime.withHour(17).withMinute(0).withSecond(0); // Set logout time at 5 PM
        System.out.println("Employee " + name + " logged in at: " + loginTime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
    }

    public double calculateBonus() {
        return basicSalary * 0.1; // Example: 10% bonus
    }

    public double calculateTax() {
        return basicSalary * 0.15; // Example: 15% tax rate
    }

    public double calculateLeaveDeductions(int leaveDays) {
        double leaveDeduction = leaveDays * (hourlyRate * 8); // Assuming 8 hours of work per day
        return leaveDeduction;
    }

    public double calculateNetWage() {
        double totalDeductions = calculateTax() + calculateLeaveDeductions(ptoDaysTaken);
        return basicSalary - totalDeductions + calculateBonus();
    }

    public void fileLeaveRequest() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter number of PTO days to request: ");
        int requestedLeave = scanner.nextInt();

        if (requestedLeave <= 10) { // Assuming max 10 leave days per year
            ptoDaysTaken += requestedLeave;
            System.out.println("Leave request approved for " + requestedLeave + " days.");
        } else {
            System.out.println("Leave request exceeds maximum days allowed.");
        }
    }

    public void generatePayslip() {
        System.out.println("----- PAYSLIP -----");
        System.out.println("Employee Name: " + name);
        System.out.println("Employee Number: " + employeeNumber);
        System.out.println("Role: " + role);
        System.out.println("Basic Salary: PHP " + basicSalary);
        System.out.println("Bonus: PHP " + calculateBonus());
        System.out.println("Tax Deduction: PHP " + calculateTax());
        System.out.println("Leave Deduction: PHP " + calculateLeaveDeductions(ptoDaysTaken));
        System.out.println("Net Salary: PHP " + calculateNetWage());
        System.out.println("----- END PAYSLIP -----");
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
        System.out.println("Immediate Supervisor: " + immediateSupervisor);
        System.out.println("Basic Salary: PHP " + basicSalary);
        System.out.println("Gross Wage: PHP " + calculateBonus());
        System.out.println("Net Wage: PHP " + calculateNetWage());
    }
}

