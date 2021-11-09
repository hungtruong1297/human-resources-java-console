import java.util.*;

public class HumanResources {
    public static ArrayList<Staff> staffs = new ArrayList<>();
    public static Scanner scanner = new Scanner(System.in);


    public static void main(String[] args) {
        inputEmployeeAndManager();
        start();
    }



    public static void start() {
        boolean quit = false;
        while (!quit) {
            printMenu();
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();


            switch (choice) {
                case 0:
                    quit = true;
                    System.out.println("Quitting.");
                    printBreak();
                    break;
                case 1:
                    System.out.println("List of staffs:");
                    System.out.println("ID\tName\tDepartment\tJob Titles");
                    displayInformation();
                    printBreak();
                    break;
                case 2:
                    System.out.println("Display department:");
                    displayDepartment();
                    printBreak();
                    break;
                case 3:
                    System.out.println("Display staffs by department: ");
                    displayStaffByDepartment();
                    printBreak();
                    break;
                case 4:
                    System.out.println("Add new staff - Employee: ");
                    addEmployee();
                    printBreak();
                    break;
                case 5:
                    System.out.println("Add new staff - Manager: ");
                    addManager();
                    printBreak();
                    break;
                case 6:
                    System.out.println("Display staff salary: ");
                    displaySalary();
                    printBreak();
                    break;
                case 7:
                    System.out.println("Display staff salary (by Ascending): ");
                    displaySalaryAscending();
                    printBreak();
                    break;
                case 8:
                    System.out.println("Display staff salary (by Descending): ");
                    displaySalaryDescending();
                    printBreak();
                    break;
                case 9:
                    System.out.println("Find staff by ID: ");
                    findStaffByID();
                    printBreak();
                    break;
                case 10:
                    System.out.println("Find staff by Name: ");
                    findStaffByName();
                    printBreak();
                    break;
            }
        }
    }

    public static void printMenu() {
        System.out.println("Options: ");
        System.out.println("""
                0. Quit
                1. List of staff
                2. Display department
                3. Display staffs by department
                4. Add new staff - Employee
                5. Add new staff - Manager
                6. Show staff salary
                7. Show staff salary by ascending
                8. Show staff salary by descending
                9. Find staff by ID
                10. Find staff by Name
                """
        );
    }

    public static void displayInformation() {
        for (int i = 0; i < staffs.size(); i ++) {
            staffs.get(i).displayInformation();
        }
    }

    public static void displayDepartment() {
        ArrayList<String> departmentList = new ArrayList<String>();
        for (int i = 0; i < staffs.size(); i ++) {
            departmentList.add(i, staffs.get(i).getDepartment());
        }
        Set<String> uniqueDepartmentList = new HashSet<String>(departmentList);
        System.out.println(uniqueDepartmentList);
    }

    public static void displayStaffByDepartment() {
        for (int i = 0; i < staffs.size(); i ++) {
            if (staffs.get(i).getDepartment().equals("Business")) {
                staffs.get(i).displayInformation();
            }
        }
        for (int i = 0; i < staffs.size(); i ++) {
            if (staffs.get(i).getDepartment().equals("Project")) {
                staffs.get(i).displayInformation();
            }
        }
        for (int i = 0; i < staffs.size(); i ++) {
            if (staffs.get(i).getDepartment().equals("Technical")) {
                staffs.get(i).displayInformation();
            }
        }
    }

    public static void addEmployee() {
        Scanner sc = new Scanner(System.in);

        System.out.print("Nhap ID: ");
        int id = scanner.nextInt();

        System.out.print("Ten Nhan vien: ");
        String name = sc.nextLine();

        System.out.print("Ten Phong ban: ");
        String department = sc.next();

        staffs.add(Employee.create(id,name,department));
    }

    public static void addManager() {
        Scanner sc = new Scanner(System.in);

        System.out.println("Nhap ID: ");
        int id = scanner.nextInt();

        System.out.println("Nhap Ten quan ly: ");
        String name = sc.nextLine();

        System.out.println("Nhap Ten phong ban: ");
        String department = sc.next();

        System.out.println("Nhap Chuc vu: ");
        String jobTitle = sc.next() + " " + sc.next();

        staffs.add(Manager.create(id,name,department,jobTitle));
    }

    public static void displaySalary() {
        System.out.println("Display Salary: ");
        for (int i = 0; i < staffs.size(); i ++) {
            staffs.get(i).displaySalary();          //Take displaySalary() from class Staff
        }
    }
    public static void displaySalaryAscending() {
        staffs.sort(new SalarySorter());
        displaySalary();
    }

    public static void displaySalaryDescending() {
        staffs.sort(new SalarySorter().reversed());
        displaySalary();
    }

    public static void findStaffByID() {
        boolean isFound = false;
        System.out.print("Nhap vao ID can tim: ");
        int id = scanner.nextInt();
        for (int i = 0; i < staffs.size() ; i ++) {
            if (staffs.get(i).getId() == id) {
                staffs.get(i).displayInformation();
                isFound = true;
            }
        }
        if (isFound == false) {
            System.out.println("Khong tim thay ID nhan vien.");
        }
    }

    public static void findStaffByName() {
        Scanner sc = new Scanner(System.in);
        boolean isFound = false;

        System.out.print("Nhap vao Ten can tim: ");
        String name = sc.nextLine();

        for (int i = 0; i < staffs.size(); i++) {
            if (staffs.get(i).getName().toLowerCase().contains(name.toLowerCase())) {
                staffs.get(i).displayInformation();
                isFound = true;
            }

        }
        if (isFound == false) {
            System.out.println("Khong tim thay nhan vien " + name);
        }
    }


    public static void printBreak() {
        System.out.println("=====================");
    }

    public static void inputEmployeeAndManager() {
        staffs.add(Employee.create(101,"Tran Ngoc","Business"));
        staffs.add(Employee.create(102,"Truong Dinh","Project"));
        staffs.add(Employee.create(103,"Ngo Quyen","Technical"));
        staffs.add(Employee.create(104, "Quang Trung", Date.create(1998,4,15),2,Date.create(2018,5,30),"Project",2,20));
        staffs.add(Employee.create(105, "Van Quyen", Date.create(1990,4,12),3,Date.create(2021,5,30),"Technical",4,20));
        staffs.add(Employee.create(106, "Van Manh", Date.create(1988,9,12),4,Date.create(2021,5,30),"Project",4,0));

        staffs.add(Manager.create(107, "Duong Qua","Business","Business Leader"));
        staffs.add(Manager.create(108, "Co Co","Project","Project Leader"));
        staffs.add(Manager.create(109, "Pham Van Mach","Technical","Technical Leader"));

    }






}
