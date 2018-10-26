package com.company;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;


        public class Main {
            public static void main(String[] args) {
                Scanner scan = new Scanner(System.in);
                ArrayList<Contact> book = new ArrayList<>();

                String line;
                while (!(line = scan.nextLine()).equals("")) {
                    Contact contact = new Contact(line.split(" ")[0], line.split(" ")[1]);

                    if (book.contains(contact)) {
                        throw new RuntimeException();
                    } else {
                        book.add(contact);
                    }
                }

                scan.close();

                ArrayList<Contact> writedBook = readFromFile();

                for (Contact contact : book) {
                    if (writedBook.contains(contact)) {
                        throw new RuntimeException();
                    }
                }

                writeToFile(book);
            }

            public static ArrayList<Contact> readFromFile() {
                ArrayList<Contact> tempBook = new ArrayList<>();
                Scanner scan;
                try {
                    scan = new Scanner(new File("phoneBook.txt"));

                    while (scan.hasNextLine()) {
                        String line = scan.nextLine();
                        Contact contact = new Contact(line.split(" ")[0], line.split(" ")[1]);
                        tempBook.add(contact);
                    }

                    scan.close();
                } catch (FileNotFoundException e) {}

                return tempBook;
            }

            public static void writeToFile(ArrayList<Contact> book) {
                FileWriter writer;
                try {
                    writer = new FileWriter("phoneBook.txt", true);
                    for (Contact contact : book) {
                        writer.write(contact.toString() + "\n");
                    }

                    writer.flush();
                    writer.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }


