/**
 @Project :- Library Management System
 @File :- CRUD.java
 @Developed :- 26 March 2023
 @Edited :- 26 March 2023
 @author VANSH KHANEJA
 */



import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

import java.util.LinkedList;
import java.util.List;

public class CRUD {
    String file = "issueData.txt";

    public void create(String data) {

        /**
         * @params data (Should be in the proper format)
         *
         * @Algo This method :-
         *      creates a new file
         *      stores the data in the file
         *      closes the file
         *
         * @return null
         */
        try {
            FileWriter writer = new FileWriter(file, false);
            writer.write(data);
            writer.close();

        } catch (Exception e) {
            e.printStackTrace();

            System.out.println("There's some error in create method");

        }

    }


    public int update(String studID, String bookID, String bookIssueDate) {

        /**
         * @params Student ID , Book ID , Book Name , Book Issue Date , Book Return Date
         *
         * @Algo This method :-
         *      reads the original file
         *      makes a temporary copy of the file
         *      updates temporary copy with the parameters given
         *      writes the copy back to the original file
         *      closes the file
         *
         * @return capacity(how much more books can be issued)
         */


        int capacity = 2;
        List<String[]> lines = new LinkedList<>();
        CRUD crud = new CRUD();
        String line;
        try {
            FileReader filereader = new FileReader(file);
            BufferedReader reader = new BufferedReader(filereader);

            while ((line = reader.readLine()) != null) {
                String[] words = line.split(",");
                lines.add(words);
            }
            reader.close();

        } catch (Exception e) {
            e.printStackTrace();

            System.out.println("There's some error in create method");
        }

        for (int i = 0; i < lines.size(); i++) {    // Matches the student ID and adds all data in that record (line)
            String[] words = lines.get(i);
            if (studID.equals(words[0])) {
                if (words[1].equals("-")) {
                    words[1] = bookID;
                    words[2] = bookIssueDate;

                    capacity = 2;
                } else if (words[3].equals("-")) {
                    words[3] = bookID;
                    words[4] = bookIssueDate;
                    capacity = 1;
                } else {
                    capacity = 0;

                }
            }
        }


        String data = ""; // Creates a string with the new updated data
        for (int i = 0; i < lines.size(); i++) {
            String[] words = lines.get(i);

            data+= words[0]+","+words[1]+","+words[2]+","+words[3]+","+words[4]+"\n";




        }



        crud.create(data);
        return capacity;
    }

    public String[] read(String studID) {

        /**
         *
         * @params Student ID
         *
         * @Algo This method :-
         *      reads the original file
         *      makes a temporary copy of the file
         *      matches the student ID in temporary file
         *      returns the data of that student ID
         *      closes the file
         *
         * @return array of the record at the provided student ID
         */
        List<String[]> lines = new LinkedList<>();
        try {
            File file = new File("issueData.txt");
            FileReader filereader = new FileReader(file);
            BufferedReader reader = new BufferedReader(filereader);
            String line;
            while ((line = reader.readLine()) != null) {
                String[] words = line.split(",");
                lines.add(words);
            }
            reader.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        for (int i = 0; i < lines.size(); i++) {
            String[] words = lines.get(i);
            if (studID.equals(words[0])) {
                return new String[]{words[1], words[2], words[3], words[4]};
            }
        }

        return new String[]{"-", "-", "-", "-"};

    }

    public int delete(String studID, String bookId) {

        /**
         * @params Student ID , Book ID
         *
         * @Algo This method :-
         *      reads the original file
         *      makes a temporary copy of the file
         *      deletes the record in temporary copy with the matching student ID & Book ID
         *      writes the copy back to the original file
         *      closes the file
         *
         * @return null
         */

        int present = 0;

        CRUD crud = new CRUD();

        List<String[]> lines = new LinkedList<>();
        try {
            File file = new File("issueData.txt");
            FileReader filereader = new FileReader(file);
            BufferedReader reader = new BufferedReader(filereader);
            String[] line;
            String ln = null;
            while ((ln = reader.readLine()) != null) {
                 line = ln.split(",");
                lines.add(line);
            }
            reader.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        int index = 0;
        for (int i = 0; i < lines.size(); i++) {
            String[] words = lines.get(i);
            if (studID.equals(words[0])) {
                if (words[1].equals(bookId)) {
                    words[1] = "-";
                    words[2] = "-";
                    present =1;
                } else if (words[3].equals(bookId)) {
                    words[3] = "-";
                    words[4] = "-";
                    present=1;

                }
                else {
                    present=0;
                 }
            }

        }


        String data = ""; // Creates a string with the new updated data
        for (int i = 0; i < lines.size(); i++) {
            String[] words = lines.get(i);

             data+= words[0]+","+words[1]+","+words[2]+","+words[3]+","+words[4]+"\n";





        }




        crud.create(data);
        return present;
    }


    public String[] readStudent(String studID) {
        List<String[]> lines = new LinkedList<>();
        try {
            File file = new File("studentData.txt");
            FileReader filereader = new FileReader(file);
            BufferedReader reader = new BufferedReader(filereader);
            String line;
            while ((line = reader.readLine()) != null) {
                String[] words = line.split(",");
                lines.add(words);
            }
            reader.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        for (int i = 0; i < lines.size(); i++) {
            String[] words = lines.get(i);
            if (studID.equals(words[0])) {
                return new String[]{words[1], words[2], words[3], words[4]};
            }
        }
        return new String[]{"-", "-", "-", "-"};

    }


    public String readBook(String bookID) {
        List<String[]> lines = new LinkedList<>();
        try {
            File file = new File("books.txt");
            FileReader filereader = new FileReader(file);
            BufferedReader reader = new BufferedReader(filereader);
            String line;
            while ((line = reader.readLine()) != null) {
                String[] words = line.split(",");
                lines.add(words);
            }
            reader.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        for (int i = 0; i < lines.size(); i++) {
            String[] words = lines.get(i);
            if (bookID.equals(words[0])) {
                return words[1];
            }
        }
        return "-";

    }

}

