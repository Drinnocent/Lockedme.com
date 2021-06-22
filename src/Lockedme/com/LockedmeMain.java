package Lockedme.com;

import java.io.IOException;


public class LockedmeMain {


    public void welcomeScreen() {
        System.out.println("WELCOME TO LockedMe.Com");
        System.out.println("doc@lockedme.com for more info");
        System.out.printf("%-10s%-10s\n", "Name", "Doctor");
        System.out.printf("%-10s%-10s\n", "Surname", "Khanyile");
        System.out.printf("%-10s%-10s\n", "Link", "locked.com");
        System.out.println();

    }

    public static void main(String[] args) throws IOException {

        LockedmeMain test = new LockedmeMain();
        test.welcomeScreen();
        LockedmeInterface lock = new Lockedme();
        lock.mainMenu();


    }
}
