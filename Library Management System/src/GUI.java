/**
 @Project :- Library Management System
 @File :- GUI.java
 @Developed :- 26 March 2023
 @Edited :- 26 March 2023
 @author VANSH KHANEJA
 */


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import java.util.Calendar;

public class GUI {

    JFrame frame;
    Container container;


    JTextArea table11, table12, table21, table22, table13, table23, table14, table24, table15, table25;

    JTextField studentIdEdit,bookIDIssueEdit,bookIDReturnEdit;

    JButton issueBookButton, returnBookButton,issueReturnButton,issueButton,returnButton,checkReturnButton,checkIssueButton;
    JLabel studentName, studentYear, studentCourse, studentBranch,returnIssueHeading,issueDateIssue,returnDateIssue,issueDateReturn,returnDateReturn;

    public void setFrame() {
        frame = new JFrame();

        frame = new JFrame("Library Manager");              // Sets up window for the Graphics
        frame.setBounds(100, 100, 1000, 700);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);


        container = frame.getContentPane();                     // Creates a container in frame to store widgets
        container.setLayout(null);
        container.setBackground(new Color(231, 231, 182));


        JLabel heading = new JLabel("Grand Central Library");     // Creates a heading inside the container
        heading.setBounds(220, 30, 400, 100);
        Font headingFont = new Font("serif", Font.BOLD, 35);
        heading.setFont(headingFont);


        Drawlogo logo = new Drawlogo();
        logo.setBounds(150, 30, 70, 70);


        JLabel studentIdText = new JLabel("Student ID");           // Creates a text label named Student ID
        studentIdText.setBounds(70, 160, 150, 30);
        Font studentIdFont = new Font("serif", Font.BOLD, 17);
        studentIdText.setFont(studentIdFont);

        studentIdEdit = new JTextField();                      //Creates EditText Box to input Student ID
        studentIdEdit.setBounds(70, 190, 200, 30);
        Font studentIdEditFont = new Font("monospace", Font.BOLD, 20);
        studentIdEdit.setFont(studentIdEditFont);


        JLabel dataNotFoundText = new JLabel("*Student ID Not Found");
        Font dataNotFoundFont = new Font("dialog", Font.BOLD, 12);
        dataNotFoundText.setFont(dataNotFoundFont);
        dataNotFoundText.setForeground(Color.RED);
        dataNotFoundText.setVisible(false);
        dataNotFoundText.setBounds(70, 220, 150, 30);


        CRUD crud = new CRUD();


        JButton searchButton = new JButton("Search");               //Creates a button to search student Data
        searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String[] studData = crud.readStudent(studentIdEdit.getText());
                String[] bookData = crud.read(studentIdEdit.getText());

                studentName.setText(studData[0]);                           // changes Student Name according to the students ID
                studentYear.setText(studData[1]);
                studentCourse.setText(studData[2]);
                studentBranch.setText(studData[3]);


                table12.setText(bookData[0]);
                table22.setText(bookData[2]);
                table13.setText(crud.readBook(bookData[0]));
                table23.setText(crud.readBook(bookData[2]));
                table14.setText("   "+bookData[1]);
                table24.setText("   "+bookData[3]);
                //table15.setText(bookData[3]);
                //table25.setText(bookData[7]);


                issueBookButton.setEnabled(true);
                returnBookButton.setEnabled(true);

                dataNotFoundText.setVisible(false);


                if (studData[0].equals("-")) {
                    dataNotFoundText.setVisible(true);

                    issueBookButton.setEnabled(false);
                    returnBookButton.setEnabled(false);
                }
            }
        });
        searchButton.setMargin(new Insets(0, 0, 0, 0));
        searchButton.setBounds(275, 190, 70, 30);


        Font studentDataFont = new Font("dialog", Font.BOLD, 17);

        JLabel studentNameText = new JLabel("Student Name :");              //Creates a text label named "Student Name :"
        studentNameText.setFont(studentDataFont);
        studentNameText.setBounds(370, 150, 150, 30);


        JLabel studentYearText = new JLabel("Year :");                      //Creates a text label named "Year :"
        studentYearText.setFont(studentDataFont);
        studentYearText.setBounds(370, 180, 150, 30);


        JLabel studentCourseText = new JLabel("Course :");                  //Creates a text label named "Course :"
        studentCourseText.setFont(studentDataFont);
        studentCourseText.setBounds(370, 210, 150, 30);


        JLabel studentBranchText = new JLabel("Branch :");                    //Creates a text label named "Branch :"
        studentBranchText.setFont(studentDataFont);
        studentBranchText.setBounds(370, 240, 150, 30);


        JTextArea studentDataContainer = new JTextArea();                           //Creates a container to store fetched student Data
        studentDataContainer.setBounds(520, 153, 180, 125);
        studentDataContainer.setEditable(false);
        studentDataContainer.setBackground(null);


        studentName = new JLabel("-");                                          //Creates a text label for student Name according to student ID
        studentName.setBounds(2, 5, 180, 20);

        studentYear = new JLabel("-");                                          //Creates a text label for student Year according to student ID
        studentYear.setBounds(2, 35, 180, 20);

        studentCourse = new JLabel("-");                                        //Creates a text label for student course according to student ID
        studentCourse.setBounds(2, 65, 180, 20);

        studentBranch = new JLabel("-");                                        //Creates a text label for student branch according to student ID
        studentBranch.setBounds(2, 95, 180, 20);


        JTextArea booksIssuedTableTitle = new JTextArea("S no.                Book ID           Book Name                  Issue Date ");      //Creates headings for the table columns
        booksIssuedTableTitle.setBounds(70, 350, 539, 30);
        booksIssuedTableTitle.setBackground(Color.LIGHT_GRAY);
        Font booksIssuedttFont = new Font("monospace", Font.PLAIN, 18);
        booksIssuedTableTitle.setFont(booksIssuedttFont);


        Font tableheadFont = new Font("serif", Font.BOLD, 17);
        Font tablebodyFont = new Font("serif", Font.PLAIN, 17);


        table11 = new JTextArea("Book 1");
        table11.setFont(tableheadFont);
        table11.setEditable(false);
        table11.setBounds(70, 382, 117, 28);
        container.add(table11);

        table21 = new JTextArea("Book 2");
        table21.setFont(tableheadFont);
        table21.setEditable(false);
        table21.setBounds(70, 412, 117, 28);
        container.add(table21);

        table12 = new JTextArea("     -");
        table12.setBounds(188, 382, 118, 28);
        table12.setEditable(false);
        table12.setFont(tablebodyFont);
        container.add(table12);

        table22 = new JTextArea("     -");
        table22.setEditable(false);
        table22.setBounds(188, 412, 118, 28);
        table22.setFont(tablebodyFont);
        container.add(table22);

        table13 = new JTextArea("     -");
        table13.setEditable(false);
        table13.setBounds(307, 382, 182, 28);
        table13.setFont(tablebodyFont);
        container.add(table13);

        table23 = new JTextArea("     -");
        table23.setEditable(false);
        table23.setBounds(307, 412, 182, 28);
        table23.setFont(tablebodyFont);
        container.add(table23);

        table14 = new JTextArea("     -");
        table14.setEditable(false);
        table14.setBounds(491, 382, 118, 28);
        table14.setFont(tablebodyFont);
        container.add(table14);

        table24 = new JTextArea("     -");
        table24.setEditable(false);
        table24.setBounds(491, 412, 118, 28);
        table24.setFont(tablebodyFont);
        container.add(table24);




        issueBookButton = new JButton("Issue Book");
        issueBookButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                issueButton.setEnabled(false);
                checkIssueButton.setEnabled(true);

                bookIDIssueEdit.setEnabled(true);
                returnButton.setEnabled(false);
                checkReturnButton.setEnabled(false);
            }
        });
        issueBookButton.setMargin(new Insets(0, 0, 0, 0));
        issueBookButton.setBounds(550, 480, 110, 35);
        issueBookButton.setEnabled(false);

        returnBookButton = new JButton("Return Book");
        returnBookButton.setMargin(new Insets(0, 0, 0, 0));
        returnBookButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                returnButton.setEnabled(false);
                checkReturnButton.setEnabled(true);

                bookIDReturnEdit.setEnabled(true);

                issueButton.setEnabled(false);
                checkIssueButton.setEnabled(false);

            }
        });
        returnBookButton.setBounds(550, 520, 110, 35);
        returnBookButton.setEnabled(false);


        studentDataContainer.add(studentName);
        studentDataContainer.add(studentYear);
        studentDataContainer.add(studentCourse);
        studentDataContainer.add(studentBranch);


        JTextArea issueBox = new JTextArea();
        issueBox.setBounds(700, 0, 300, 335);
        issueBox.setBackground(new Color(222, 217, 217));
        issueBox.setEditable(false);
        issueBox.setVisible(true);


        returnIssueHeading = new JLabel("Issue Book");
        Font returnIssueFont = new Font("monospace",Font.BOLD,20);
        returnIssueHeading.setFont(returnIssueFont);
        returnIssueHeading.setBounds(65,20,300,30);
        issueBox.add(returnIssueHeading);



        JLabel BookIdIssueText = new JLabel("Book ID :");
        BookIdIssueText.setBounds(40,70,300,30);
        issueBox.add(BookIdIssueText);


        bookIDIssueEdit = new JTextField();
        bookIDIssueEdit.setBounds(40,105,200,30);
        Font edit_bookIdIssueFont = new Font("serif",Font.BOLD,17);
        bookIDIssueEdit.setFont(edit_bookIdIssueFont);
        bookIDIssueEdit.setEnabled(false);
        issueBox.add(bookIDIssueEdit);

        JLabel alreadyIssued = new JLabel("*Already 2 books issued");
        alreadyIssued.setBounds(40,133,150,20);
        alreadyIssued.setForeground(Color.RED);
        alreadyIssued.setVisible(false);
        issueBox.add(alreadyIssued);


        JLabel bookNotAvailable = new JLabel("*Book not available");
        bookNotAvailable.setBounds(40,133,150,20);
        bookNotAvailable.setForeground(Color.RED);
        bookNotAvailable.setVisible(false);
        issueBox.add(bookNotAvailable);



        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        Calendar cal = Calendar.getInstance();
        String issueDate = sdf.format(cal.getTime());
        cal.add(Calendar.DATE, 15);
        String returnDate = sdf.format(cal.getTime());

        checkIssueButton = new JButton("Check");
        checkIssueButton.setEnabled(false);
        checkIssueButton.setBounds(170,150,70,30);
        checkIssueButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if((crud.readBook(bookIDIssueEdit.getText())).equals("-")){
                    bookNotAvailable.setVisible(true);
                }
                else{
                    issueButton.setEnabled(true);
                    issueDateIssue.setText(issueDate);
                    returnDateIssue.setText(returnDate);
                    bookNotAvailable.setVisible(false);

                }

            }
        });
        issueBox.add(checkIssueButton);



        JLabel issueDateIssueText = new JLabel("Issue Date       :");
        issueDateIssueText.setBounds(30,200,90,30);
        issueBox.add(issueDateIssueText);

        issueDateIssue = new JLabel("-");
        issueDateIssue.setBounds(140,200,80,30);
        issueBox.add(issueDateIssue);


        JLabel returnDateIssueText = new JLabel("Return Date    :");
        returnDateIssueText.setBounds(30,230,90,30);
        issueBox.add(returnDateIssueText);

        returnDateIssue = new JLabel("-");
        returnDateIssue.setBounds(140,230,80,30);
        issueBox.add(returnDateIssue);


        issueButton = new JButton("Issue");
        issueButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int capacity = crud.update(studentIdEdit.getText(),bookIDIssueEdit.getText(),issueDate);

                String[] bookData = crud.read(studentIdEdit.getText());

                table12.setText(bookData[0]);
                table22.setText(bookData[2]);
                table13.setText(crud.readBook(bookData[0]));
                table23.setText(crud.readBook(bookData[2]));
                table14.setText("   "+bookData[1]);
                table24.setText("   "+bookData[3]);


                bookIDIssueEdit.setText("");
                bookIDIssueEdit.setEnabled(false);
                issueButton.setEnabled(false);
                checkIssueButton.setEnabled(false);
                if(capacity==0){
                    alreadyIssued.setVisible(true);
                }





            }
        });
        issueButton.setBounds(95,280,80,30);
        issueButton.setEnabled(false);
        issueBox.add(issueButton);








        JTextArea returnBox = new JTextArea();
        returnBox.setBounds(700, 345, 300, 345);
        returnBox.setBackground(new Color(222, 217, 217));
        returnBox.setEditable(false);
        returnBox.setVisible(true);


        returnIssueHeading = new JLabel("Return Book");
        returnIssueHeading.setFont(returnIssueFont);
        returnIssueHeading.setBounds(65,20,300,30);
        returnBox.add(returnIssueHeading);



        JLabel BookIdReturnText = new JLabel("Book ID :");
        BookIdReturnText.setBounds(40,70,300,30);
        returnBox.add(BookIdReturnText);


        bookIDReturnEdit = new JTextField();
        bookIDReturnEdit.setEnabled(false);
        bookIDReturnEdit.setBounds(40,105,200,30);
        Font edit_bookIdReturnFont = new Font("serif",Font.BOLD,17);
        bookIDReturnEdit.setFont(edit_bookIdReturnFont);
        returnBox.add(bookIDReturnEdit);


        JLabel notPresent = new JLabel("*Book ID not found");
        notPresent.setBounds(40,133,150,20);
        notPresent.setForeground(Color.RED);
        notPresent.setVisible(false);
        returnBox.add(notPresent);

        checkReturnButton = new JButton("Check");
        checkReturnButton.setEnabled(false);
        checkReturnButton.setBounds(170,150,70,30);
        checkReturnButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String[] data = crud.read(studentIdEdit.getText());

                if(data[0].equals(bookIDReturnEdit.getText())){
                    String strDate = data[1];
                    issueDateReturn.setText(data[1]);


                    Calendar date = Calendar.getInstance();
                    int ddate = Integer.parseInt(strDate.substring(0,2));
                    int dmonth = Integer.parseInt(strDate.substring(3,5));
                    int dyear = Integer.parseInt(strDate.substring(6,10));


                    date.set(Calendar.DATE,ddate);
                    date.set(Calendar.MONTH,dmonth-1);
                    date.set(Calendar.YEAR,dyear);
                    date.add(Calendar.DATE,15);
                    DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
                    String returnDate = df.format(date.getTime());

                    returnDateReturn.setText(returnDate);

                }
                else if (data[2].equals(bookIDReturnEdit.getText())){
                    issueDateReturn.setText(data[3]);
                    String strDate = data[3];


                    Calendar date = Calendar.getInstance();
                    int ddate = Integer.parseInt(strDate.substring(0,2));
                    int dmonth = Integer.parseInt(strDate.substring(3,5));
                    int dyear = Integer.parseInt(strDate.substring(6,10));


                    date.set(Calendar.DATE,ddate);
                    date.set(Calendar.MONTH,dmonth-1);
                    date.set(Calendar.YEAR,dyear);
                    date.add(Calendar.DATE,15);
                    DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
                    String returnDate = df.format(date.getTime());

                    returnDateReturn.setText(returnDate);
                }
                returnButton.setEnabled(true);
            }
        });
        returnBox.add(checkReturnButton);



        JLabel issueDateReturnText = new JLabel("Issue Date       :");
        issueDateReturnText.setBounds(30,200,90,30);
        returnBox.add(issueDateReturnText);

        issueDateReturn = new JLabel("-");
        issueDateReturn.setBounds(140,200,80,30);
        returnBox.add(issueDateReturn);


        JLabel returnDateReturnText = new JLabel("Return Date    :");
        returnDateReturnText.setBounds(30,230,90,30);
        returnBox.add(returnDateReturnText);

        returnDateReturn = new JLabel("-");
        returnDateReturn.setBounds(140,230,80,30);
        returnBox.add(returnDateReturn);


        returnButton = new JButton("Return");
        returnButton.setEnabled(false);
        returnButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int present = crud.delete(studentIdEdit.getText(),bookIDReturnEdit.getText());


                String[] bookData = crud.read(studentIdEdit.getText());

                table12.setText(bookData[0]);
                table22.setText(bookData[2]);
                table13.setText(crud.readBook(bookData[0]));
                table23.setText(crud.readBook(bookData[2]));
                table14.setText("   "+bookData[1]);
                table24.setText("   "+bookData[3]);

                bookIDReturnEdit.setText("");
                bookIDReturnEdit.setEnabled(false);
                returnButton.setEnabled(false);
                checkReturnButton.setEnabled(false);



                if(present == 0){
                    notPresent.setVisible(true);
                }
            }
        });
        returnButton.setBounds(95,280,80,30);
        returnBox.add(returnButton);



        container.add(heading);
        container.add(logo);
        container.add(studentIdText);
        container.add(studentIdEdit);
        container.add(searchButton);
        container.add(dataNotFoundText);
        container.add(studentNameText);
        container.add(studentNameText);
        container.add(studentYearText);
        container.add(studentCourseText);
        container.add(studentBranchText);
        container.add(studentDataContainer);
        container.add(booksIssuedTableTitle);
        container.add(issueBookButton);
        container.add(returnBookButton);
        container.add(issueBox);
        container.add(returnBox);

        frame.setVisible(true);


    }

}
class Drawlogo extends JPanel {
    public void paintComponent(Graphics g) {
        Image image = new ImageIcon("bs.png").getImage();
        g.drawImage(image, 5, 5, this);


    }
}