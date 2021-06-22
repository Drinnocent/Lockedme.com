package Lockedme.com;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Lockedme implements LockedmeInterface {


    public void listingFilesInOrder() {
        String[] arr = new String[getFilesList().size()];
        getFilesList().toArray(arr);
        Arrays.sort(arr, String.CASE_INSENSITIVE_ORDER);
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);

        }
    }

    public void addFile(String filename) {
        if(filename.endsWith(".txt"))
        {
            File file = new File("C:\\Users\\Student\\FileProcessing\\" + filename);
            try {
                if (file.createNewFile())
                    System.out.println("File Created Successfully");
                else
                    System.out.println("File already exist");
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
        else
            {
                System.out.println("Please make sure the file you entered ends with .txt");
            }


    }

    @Override
    public void deleteFile(String filename) throws IOException {

        List<String> list = getFilesList();
        if(!filename.endsWith(".txt"))
            System.out.println("All must end with .txt please verify then try again'");
       else if (list.contains(filename)) {

            Files.delete(Paths.get("C:\\Users\\Student\\FileProcessing\\" + filename));
            System.out.println("File deleted successful");


        } else {
            System.out.println("File does not exist");
        }


    }

    public List<String> getFilesList() {
        List<String> textFiles = new ArrayList<String>();
        File dir = new File("C:\\Users\\Student\\FileProcessing");
        for (File file : dir.listFiles()) {
            if (file.getName().endsWith((".txt"))) {
                textFiles.add(file.getName());
            }
        }

        return textFiles;
    }

    @Override
    public void searchFile(String filename) {
        String[] arr = new String[getFilesList().size()];
        getFilesList().toArray(arr);
        if (arr.length == 0)
            System.out.println("Try adding some files in your directory");
        else if(!filename.endsWith(".txt"))
            System.out.println("Make sure your file ends with .txt to be a valid file");
        else {
            int r = -1;
            int index = 0;
            for (int i = 0; i < arr.length; i++) {
                if (arr[i].equals(filename)) {
                    index = i;
                    r = 1;
                    break;
                }
            }
            if (r == 1) {
                System.out.println("file found at position " + index);

            } else {
                System.out.println("file not found");

            }
        }

    }


    public void businessOperation() throws IOException {
        System.out.println("BUSINESS LOGIC MENU");
        System.out.printf("%-30s%-30s\n", "1.Add File", "2.Delete File");
        System.out.printf("%-30s%-30s\n", "3.Search File", "4.Exit to Main Menu");

        Scanner input = new Scanner(System.in);
        int option = 0;
        String filename = "";
        boolean check = true;
        try {
            option = Integer.parseInt(input.next());
        } catch (NumberFormatException e) {
            System.out.println("That input is invalid it should be numbers");
        }


        while (option == 4 || check == true) {


            if (option > 0 && option <= 4) {
                if (option == 1) {
                    System.out.println("Enter file name with .txt");
                    filename = input.next();
                    addFile(filename);
                } else if (option == 2) {
                    System.out.println("Enter file name with .txt");
                    filename = input.next();
                    deleteFile(filename);

                } else if (option == 3) {
                    System.out.println("Enter file name with .txt");
                    filename = input.next();
                    searchFile(filename);
                } else {
                    mainMenu();
                    break;
                }


            } else {
                System.out.println("Please Enter number within the ranger");

            }
            System.out.println("BUSINESS LOGIC MENU");
            System.out.printf("%-30s%-30s\n", "1.Add File", "2.Delete File");
            System.out.printf("%-30s%-30s\n", "3.Search File", "4.Exit to Main Menu");

            try {
                option = Integer.parseInt(input.next());
            } catch (NumberFormatException e) {
                System.out.println("That input is invalid it should be numbers");
            }


        }

    }


    public void mainMenu() throws IOException {
        System.out.println("WHAT WOULD YOU LIKE TO DO TODAY");
        System.out.printf("%-30s%-30s\n", "1.RETRIEVE FILES IN ORDER", "2.BUSINESS OPERATION MENU");
        System.out.printf("%-30s\n", "3.EXIT THE APPLICATION");


        System.out.println("Please Choose The Option You Would Like To Perform");
        Scanner input = new Scanner(System.in);
        int option = 0;
        try {
            option = Integer.parseInt(input.next());
        } catch (NumberFormatException e) {
            System.out.println("That input is invalid it should be numbers");
        }


        while (option != 3) {


            if (option > 0 && option <= 3) {
                if (option == 1) {
                    listingFilesInOrder();
                }
                if (option == 2) {
                    businessOperation();
                    break;
                }


            } else {
                System.out.println("Please Enter number within the ranger");

            }
            System.out.println("WHAT ELSE  WOULD YOU LIKE TO DO TODAY");
            System.out.printf("%-30s%-30s\n", "1.RETRIEVE FILES IN ORDER", "2.BUSINESS OPERATION MENU");
            System.out.printf("%-30s\n", "3.EXIT THE APPLICATION");

            try {
                option = Integer.parseInt(input.next());
            } catch (NumberFormatException e) {
                System.out.println("That input is invalid it should be numbers");
            }


        }


    }


}
