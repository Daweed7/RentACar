package com.lab.commands;

import com.lab.console.CarConsoleOutput;
import com.lab.console.RenterConsoleOutput;
import com.lab.domain.Car;
import com.lab.domain.Renter;
import com.lab.service.CarService;
import com.lab.service.RenterService;

import java.sql.Date;
import java.util.Scanner;

public class RenterCar {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        CarConsoleOutput carConsoleOutput = new CarConsoleOutput();
        RenterConsoleOutput renterConsoleOutput = new RenterConsoleOutput();
        CarService carService = new CarService();
        RenterService renterService = new RenterService();
while (true) {
    System.out.println("Hello\n Choose the number: ");
    System.out.println("If you want to view information about cars choose №1\n" + "If you want to view information about renters chosse №2");
    System.out.println("To complete the request enter \"0\"");
    int i = scanner.nextInt();
    if(i==0) break;
    if (i == 1) {
        System.out.println("Choose the information that you want to know ");
        System.out.println("If you want to view information about all cars choose №1\n"
                + "If you want to view information about certain car that we have choose №2\n"
                + "If you want to add information about new car choose №3\n"
                + "If you want to delete information about car choose №4\n"
                + "If you want to update information about carName choose №5\n"
                + "If you want to update information about carColor choose №6\n"
                + "If you want to update information about carPrice choose №7\n"
                + "If you want to view information about free cars that we have choose №8");

        while (true) {
            System.out.println();
            System.out.println("To complete the request enter \"0\"");
            int s = scanner.nextInt();
            if (s == 0)
                break;
            switch (s) {
                case 1:
                    carConsoleOutput.outputAllCars();
                    break;
                case 2:
                    System.out.print("Choose id: ");
                    int id = scanner.nextInt();
                    carConsoleOutput.outputCar(id);
                    break;
                case 3:
                    System.out.print("Enter the name: ");
                    String name = scanner.next();
                    System.out.print("Enter the color: ");
                    String color = scanner.next();
                    System.out.print("Enter the price: ");
                    int price = scanner.nextInt();
                    Car car = new Car(name, color, price);
                    carService.createCar(car);
                    System.out.println("Car was added");
                    break;
                case 4:
                    System.out.print("Choose id: ");
                    id = scanner.nextInt();
                    carService.deleteCar(id);
                    System.out.println("Car was removed");
                    break;
                case 5:
                    System.out.print("Choose id: ");
                    id = scanner.nextInt();
                    System.out.print("Enter the name: ");
                    name = scanner.next();
                    carService.changCarName(name, id);
                    System.out.println("Car name was changed");
                    break;
                case 6:
                    System.out.print("Enter the color: ");
                    color = scanner.next();
                    System.out.print("Choose id: ");
                    id = scanner.nextInt();
                    carService.changCarColor(color, id);
                    System.out.println("Car color was changed");
                    break;
                case 7:
                    System.out.print("Choose id: ");
                    id = scanner.nextInt();
                    System.out.print("Enter the price: ");
                    price = scanner.nextInt();
                    carService.changCarPrice(price, id);
                    System.out.println("Car price was changed");
                    break;
                case 8:
                    carConsoleOutput.outputFreeCars();
                    break;
                default:
                    System.out.println("This number does not exist. Try again");
                    break;
            }
        }
    }

    if (i == 2) {
        System.out.println("Choose the information that you want to know ");
        System.out.println("If you want to view information about all renters choose №1\n"
                + "If you want to view information about certain renter that we have choose №2\n"
                + "If you want to add information about new renter choose №3\n"
                + "If you want to delete information about renter choose №4\n"
                + "If you want to update information about renter name choose №5\n"
                + "If you want to update information about renter city choose №6\n"
                + "If you want to update information about renter car_id choose №7\n"
                + "If you want to update information about renter birthday choose №8\n");
        while (true) {
            System.out.println();
            System.out.println("To complete the request enter \"0\"");
            int s = scanner.nextInt();
            if (s == 0)
                break;
            switch (s) {
                case 1:
                    renterConsoleOutput.outputAllRenters();
                    break;
                case 2:
                    System.out.print("Choose id: ");
                    int id = scanner.nextInt();
                    renterConsoleOutput.outputRenter(id);
                    break;
                case 3:
                    System.out.print("Enter the name: ");
                    String renterName = scanner.next();
                    System.out.print("Enter the city: ");
                    String city = scanner.next();
                    System.out.print("Enter the car_id: ");
                    int renterCarId = scanner.nextInt();
                    System.out.print("Enter the Date of Birth: ");
                    String renterBirthday = scanner.next();
                    Date date = Date.valueOf(renterBirthday);
                    Renter renter = new Renter(renterName, city, renterCarId, date);
                    renterService.createRenter(renter);
                    System.out.println("Renter was added");
                    break;
                case 4:
                    System.out.print("Choose id: ");
                    id = scanner.nextInt();
                    renterService.deleteRenter(id);
                    System.out.println("Renter was removed");
                    break;
                case 5:
                    System.out.print("Choose id: ");
                    id = scanner.nextInt();
                    System.out.print("Enter the name: ");
                    String name = scanner.next();
                    renterService.changeRenterName(name, id);
                    System.out.println("Renter's name was changed");
                    break;
                case 6:
                    System.out.print("Enter the city: ");
                    city = scanner.next();
                    System.out.print("Choose id: ");
                    id = scanner.nextInt();
                    renterService.changeRenterCity(city, id);
                    System.out.println("Renter's city was changed");
                    break;
                case 7:
                    System.out.print("Choose id: ");
                    id = scanner.nextInt();
                    System.out.print("Enter the car Id: ");
                    int carId = scanner.nextInt();
                    renterService.changeRenterCar_id(carId, id);
                    System.out.println("Renter's carId was changed");
                    break;
                case 8:
                    System.out.print("Choose id: ");
                    id = scanner.nextInt();
                    System.out.print("Enter the Date of Birth: ");
                    renterBirthday = scanner.next();
                    date = Date.valueOf(renterBirthday);
                    renterService.changeRenterBirthday(date, id);
                    System.out.println("Renter's Date of Birth was changed");
                    break;
                default:
                    System.out.println("This number does not exist. Try again");
                    break;
            }
        }

    }
}
    }
}
