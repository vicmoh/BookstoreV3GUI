//import  package
package lab3;
import java.util.*;
import java.io.*;
import java.text.DecimalFormat;
//swing gui lib
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Bookstore {
    //declare object
    private static Scanner scan = new Scanner(System.in);
    private static Book newBook = new Book();
    private static HashMap<Integer, Book> bookList = new HashMap();
    //decalre var
    private static int menu = 0;
    private static String title = "", author = "", isbn = "", input = "", subject = "", workbookISBN = "";
    private static int year = 0, numProblems;
    private static double price;
    private static String errorString;
    private static boolean wrongFormat;
    private static boolean correctIsbnFormat;
    private static boolean existingISBN;
    private static int hashCount = 0;
    //constant var
    private static final int BOOK = 1;
    private static final int TEXTBOOK = 2;
    private static final int WORKBOOK = 3;
    //gui variables
    private static JFrame mainFrame;
    private static JPanel controlPanel;
        
    public static void main(String[] args) {
        //set the default font
        setUIFont (new javax.swing.plaf.FontUIResource("Serif",Font.BOLD,35));
        //run the gui
        prepareGUI();
    }//end main
    
    public static void setUIFont (javax.swing.plaf.FontUIResource f){
        //set the default frame of the whole font
        java.util.Enumeration keys = UIManager.getDefaults().keys();
        while (keys.hasMoreElements()) {
            Object key = keys.nextElement();
            Object value = UIManager.get (key);
            if (value instanceof javax.swing.plaf.FontUIResource){
              UIManager.put (key, f);
            }//end if
        }//end while
    }//end func
    
    public static void prepareGUI(){
        //set the main frame
        mainFrame = new JFrame("Menu");
        mainFrame.setSize(1000,1000);
        mainFrame.setLayout(new GridLayout(8, 1));
        //frame
        mainFrame.addWindowListener(new WindowAdapter() {
           public void windowClosing(WindowEvent windowEvent){
              System.exit(0);
           }//ennd window closing        
        });    
        //the header
        JLabel headerLabel = new JLabel("Enter the option:", JLabel.CENTER);  

        //created var for button
        JButton option1 = new JButton("1. Add a unique book to the inventory");        
        JButton option2 = new JButton("2. Print out information on each book");
        JButton option3 = new JButton("3. Print out all unique authors");
        JButton option4 = new JButton("4. Print out the average book price & total books");
        JButton option5 = new JButton("5. Print out all Textbook-Workbook pairs in the inventory");
        JButton option6 = new JButton("6. Save the state of the inventory to a file");
        JButton option7 = new JButton("7. Load the state of the inventory from a file");
        //add objects to the frame
        mainFrame.add(headerLabel);
        mainFrame.add(option1);
        mainFrame.add(option2);
        mainFrame.add(option3);
        mainFrame.add(option4);
        mainFrame.add(option5);
        mainFrame.add(option6);
        mainFrame.add(option7);
        //set font for all
        
        //show frame
        mainFrame.setVisible(true);
        
        option1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                mainFrame.setVisible(false);
                bookOptions();
            }//end action         
        });
        option2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                print(option2());
            }//end action    
        });
        option3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                print(option3());
            }//end action    
        });
        option4.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                print(option4());
            }//end action    
        });
        option5.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                print(option5());
            }//end action    
        });
        option6.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                option6();
                print("File has been saved.");
            }//end action    
        });
        option7.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                option7();
                print("File has been loaded.");
            }//end action    
        });
    }//end func
    
    public static void print(String text){
        //create window
        JFrame frame = new JFrame();
        frame.setSize(1000, 1000);
        frame.setLayout(new GridLayout(1, 1));
        //create objects
        JTextArea info = new JTextArea(text);
        JButton button = new JButton("Okay");
        JScrollPane scrollPane = new JScrollPane(info);
        //add to the frame
        frame.add(scrollPane);
        frame.setVisible(true);
        //when butto is clicked
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frame.setVisible(false);
            }//end action    
        });
    }//end func
    
    public static void bookOptions(){
        //set the frame
        JFrame bookFrame = new JFrame();
        bookFrame.setSize(1000,1000);
        bookFrame.setLayout(new GridLayout(4, 1));
        //frame
        bookFrame.addWindowListener(new WindowAdapter() {
           public void windowClosing(WindowEvent windowEvent){
              System.exit(0);
           }//ennd window closing        
        });
        
        //create ui
        JLabel headerLabel = new JLabel("Enter the option:", JLabel.CENTER);
        JButton book = new JButton("Book");
        JButton workbook = new JButton("Workbook");
        JButton textbook = new JButton("Textbook");
        //add ui
        bookFrame.add(headerLabel);
        bookFrame.add(book);
        bookFrame.add(textbook);
        bookFrame.add(workbook);
       
        //action when button is called
        book.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                bookFrame.setVisible(false);
                addBookInfoOption(BOOK);
            }//end action    
        });
        textbook.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                bookFrame.setVisible(false);
                addBookInfoOption(TEXTBOOK);
            }//end action    
        });
        workbook.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                bookFrame.setVisible(false);
                addBookInfoOption(WORKBOOK);
            }//end action    
        });
        
        //show the gui
        bookFrame.setVisible(true);
    }//end func
    
    public static void addBookInfoOption(int type){
        //set the frame
        JFrame frame = new JFrame();
        frame.setSize(1000,1000);
        frame.setLayout(new GridLayout(11, 1));
        //frame
        frame.addWindowListener(new WindowAdapter() {
           public void windowClosing(WindowEvent windowEvent){
              System.exit(0);
           }//ennd window closing        
        });
        
        //set the button and the text
        JButton addButton = new JButton();
        if(type == BOOK){
            addButton.setText("ADD BOOK");
        }else if(type == TEXTBOOK){
            addButton.setText("ADD TEXTBOOK");
        }else if(type == WORKBOOK){
            addButton.setText("ADD WORKBOOK");
        }//endif
        
        //variable for
        wrongFormat = false;
        existingISBN = false;
        correctIsbnFormat = false;
        errorString = "";
        JLabel titleLabel = new JLabel("Enter title:");
        JLabel authorLabel = new JLabel("Enter author:");
        JLabel yearLabel = new JLabel("Enter year:");
        JLabel priceLabel = new JLabel("Enter price:");
        JLabel isbnLabel = new JLabel("Enter ISBN:");
        JLabel workIsbnLabel = new JLabel("Enter workbook ISBN:");
        JLabel subjectLabel = new JLabel("Enter subject field:");
        JLabel numOfProbLabel = new JLabel("Enter number of problems:");
        JTextField titleField = new JTextField("");
        JTextField authorField = new JTextField("");
        JTextField yearField = new JTextField("");
        JTextField priceField = new JTextField("");
        JTextField isbnField = new JTextField("");
        JTextField workIsbnField = new JTextField("");
        JTextField subjectField = new JTextField("");
        JTextField numOfProbField = new JTextField("");
        
        //add field panel
        frame.add(titleLabel);
        frame.add(titleField);
        frame.add(authorLabel);
        frame.add(authorField);
        frame.add(yearLabel);
        frame.add(yearField);
        frame.add(priceLabel);
        frame.add(priceField);
        frame.add(isbnLabel);
        frame.add(isbnField);
        //display the frame
        
        if(type == TEXTBOOK){
            //user chose textbook
            frame.setLayout(new GridLayout(15, 1));
            frame.add(workIsbnLabel);
            frame.add(workIsbnField);
            frame.add(subjectLabel);
            frame.add(subjectField);
        }else if(type == WORKBOOK){
            //if user choose workbook
            frame.setLayout(new GridLayout(13, 1));
            frame.add(numOfProbLabel);
            frame.add(numOfProbField);
        }//end if
        
        //set the frame visible
        frame.add(addButton);
        frame.setVisible(true);
        
        addButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                //apply to the instance variable            
                try{
                    title = titleField.getText();
                    author = authorField.getText();
                    year = Integer.parseInt(yearField.getText());
                    price = Double.parseDouble(priceField.getText());
                    isbn = isbnField.getText();
                    if(type == TEXTBOOK){
                        workbookISBN = workIsbnField.getText();
                        subject = subjectField.getText();
                    }else if(type == WORKBOOK){
                        numProblems = Integer.parseInt(numOfProbField.getText());
                    }//end if
                }catch(NumberFormatException E){
                    //code here
                }//end catch
                
                infoErrorCheck(type);
                if(wrongFormat == true){
                    popup("\n\n\n\t One of the field \n\t Has the wrong format \n\t PLEASE RE-ENTER");
                    mainFrame.setVisible(false);
                }else if(wrongFormat == false){
                    mainFrame.setVisible(true);
                    if(type == BOOK){
                        bookList.put(bookList.size(), new Book(title, author, year, price, isbn));
                    }else if(type == TEXTBOOK){
                        bookList.put(bookList.size(), new Textbook(title, author, year, price, isbn, workbookISBN, subject));
                    }else if(type == WORKBOOK){
                        bookList.put(bookList.size(), new Workbook(title, author, year, price, isbn, numProblems));
                    }//end if
                    frame.setVisible(false);
                }//end if
            }//end action
        });
    }//end
    
    public static void infoErrorCheck(int type){
        //set info error checking
        wrongFormat = false;
        correctIsbnFormat = false;
        errorString = "";
        //check if the format is good
        if(title.equals("")){
            errorString = errorString + "Wrong format TITLE\n";
            wrongFormat = true;
        }//end if
        if(author.equals("")){
            errorString = errorString + "Wrong format for AUTHOR\n";
            wrongFormat = true;
        }//end if
        if(year < -2600 || year > 2017){
            errorString = errorString + "Wrong format for YEAR\n";
            wrongFormat = true;
        }//end if
        if(price < 0){
            errorString = errorString + "Wrong format for PRICE\n";
            wrongFormat = true;
        }//end if
        System.out.println("FORMAT: " + correctIsbnFormat);
        System.out.println("LENGTH: " + isbn.length());
        if(isbn.length() == 10 || isbn.length() == 13){
            correctIsbnFormat = true;
        }//end if
        if(correctIsbnFormat != true){
            errorString = errorString + "Wrong format for ISBN\n";
            wrongFormat = true;
        }//end if
        for(Integer x:bookList.keySet()){
            if(bookList.get(x).getISBN().equals(isbn)){
                errorString = errorString + "Found Existing ISBN\n";
                existingISBN = true;
            }//end if
        }//end 
        
        //for other books
        if(type == TEXTBOOK){
            //check if the format is fine
            if(workbookISBN.length() == 10 || workbookISBN.length() == 13){
                correctIsbnFormat = true;
            }//end if
            if(correctIsbnFormat != true){
                errorString = errorString + "Wrong format for WORKBOOK ISBN\n";
                wrongFormat = true;
            }//end if
            for(Integer x:bookList.keySet()){
                if(bookList.get(x).getISBN().equals(workbookISBN)){
                    errorString = errorString + "Found Existing ISBN\n";
                    existingISBN = true;
                }//end if
            }//end for
            if(subject.equals("")){
                errorString = errorString + "Wrong format for SUBJECT\n";
                wrongFormat = true;
            }//end if
        }else if(type == WORKBOOK){
            //check the format
            if(numProblems < 1){
                errorString = errorString + "Wrong format for NUMBER OF PROBLEMS\n";
                wrongFormat = true;
            }//end if
        }//end if
    }//end func
    
    public static void popup(String text){
        //create window
        JFrame frame = new JFrame();
        frame.setSize(1000, 1000);
        frame.setLayout(new GridLayout(2, 1));  
        //create objects 
        JTextArea info = new JTextArea(text);
        JButton button = new JButton("Okay");
        //add to the frame
        frame.add(info);
        frame.add(button);
        frame.setVisible(true);
        //when butto is clicked
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frame.setVisible(false);
            }//end action    
        });
    }//end func
    
    public static int tryCatchInt(String toBeConverted){
        int number = 0;
        try{
            number = Integer.parseInt(toBeConverted);
        }catch(NumberFormatException E){
            System.out.println("WRONG FORMAT");
            return number = -1;
        }//end catch
        return number;
    }//end  func
    
    public static double tryCatchDouble(String toBeConverted){
        double number = 0;
        try{
            number = Double.parseDouble(toBeConverted);
        }catch(NumberFormatException E){
            System.out.println("WRONG FORMAT");
            return number = -1;
        }//end catch
        return number;
    }//end  func
    
    public static String option2(){
        String string = "";
        //print the books in the list
        int bookNumber = 0;
        System.out.println("***************************************");
        for(Integer x:bookList.keySet()){
            bookNumber++;
            string = string + "\nBook Number: " + bookNumber;
            newBook = bookList.get(x);
            string = string + "\n" + newBook.toString();
            System.out.println("***************************************");
        }//end for loop
        return string;
    }//end func
    
    public static String option3(){
        String string = "";
        boolean sameAuthor;
        String string1;
        String string2;
        System.out.println("***************************************");
        string = string +  "List of author available...";
        //check if any author is the same if not print
        int countX = 0;
        int countY = 0;
        for(int x=0; x < bookList.size();x++){
            sameAuthor = false;
            
            for(int y=x+1; y < bookList.size();y++){
                System.out.println(bookList.get(x).getAuthor() + " and " + bookList.get(y).getAuthor());
                string1 = bookList.get(x).getAuthor();
                string2 = bookList.get(y).getAuthor();
                if(string1.equals(string2)){
                    sameAuthor = true;
                    //System.out.println(sameAuthor);
                }//end if
            }//end if

            if(sameAuthor == false){
                string = string + "\n" + bookList.get(x).getAuthor();
                System.out.println(bookList.get(x).getAuthor());
            }//end if
            
        }//end for loop
        System.out.println("***************************************");
        return string;
    }//end func
    
    public static String option4(){
        String string = "";
        //set object of 2 decimal format
        DecimalFormat twoDecimal = new DecimalFormat();
        twoDecimal.setMaximumFractionDigits(2);
        //declare var
        double averagePrice = 0;
        for(Integer x:bookList.keySet()){
            newBook = bookList.get(x);
            averagePrice = averagePrice + newBook.getPrice();
        }//end for loop
        averagePrice = averagePrice/bookList.size();
        System.out.println("***************************************");
        string = string + "\nCalculating...";
        string = string + "\nThe average price of all book is $" + twoDecimal.format(averagePrice);
        string = string + "\nAnd the total number of book is " + bookList.size();
        System.out.println("***************************************");
        return string;
    }//end func
    
    public static String option5(){
        String string = "";
        Workbook workbook;
        Textbook textbook;
        System.out.println("***************************************");
        System.out.println("List of pair books...");
        //check if any author is the same if not print
        for(Integer x:bookList.keySet()){
            for(Integer y:bookList.keySet()){
                if (bookList.get(y) instanceof Textbook) {
                    textbook = (Textbook)bookList.get(y);
                    //System.out.println("Comparing..." + textbook.getTitle() + " and " + bookList.get(x).getTitle());
                    if(textbook.equals(bookList.get(x)) == true){
                        string = string + "\n" + bookList.get(y).getTitle() + " = " + bookList.get(x).getTitle();
                    }//end if
               }//end if
            }//end loop
        }//end for loop
        System.out.println("***************************************");
        return string;
    }//end func
    
    public static void option6(){
        //declare var
        String fileName = "data.txt";
        Textbook textbook;
        Workbook workbook;
        Book book;
        // Write to a file
        BufferedWriter writer;
        try{
            writer = new BufferedWriter(new FileWriter(fileName));
            for(Integer x:bookList.keySet()){
                bookList.get(x);
                if(bookList.get(x) instanceof Textbook){
                    textbook = (Textbook)bookList.get(x);
                    writer.write(textbook.data());
                }else if(bookList.get(x) instanceof Workbook){
                    workbook = (Workbook)bookList.get(x);
                    writer.write(workbook.data());
                }else if(bookList.get(x) instanceof Book){
                    book = (Book)bookList.get(x);
                    writer.write(book.data());
                }//end if
                writer.newLine();
            }//end for
            System.out.println("Saving...");
            writer.close();
        } catch(IOException e){
            System.out.println("Failed to write to "+fileName+".");
        }//end try
    }//end func
    
    public static void option7(){
        //declare var
        String fileName = "data.txt";
        // Read the file
        BufferedReader reader;
        try{
            reader = new BufferedReader(new FileReader(fileName));
            String line = reader.readLine();
            bookList.clear();
            int yearData = 0;
            double priceData = 0;
            int numProbData = 0;
            int count = 0;
            System.out.println("***************************************");
            System.out.println("Loading...");
            while (line != null){
                String[] data = line.split("@");
                
                //for debug
                System.out.println(line);
                /*for(int x=0; x < data.length; x++){
                    System.out.println("Split: " + data[x]);
                }*/
     
                if(data[0].equals("t")){
                   yearData = Integer.parseInt(data[3]);
                   priceData = Double.parseDouble(data[4]);
                   bookList.put(bookList.size(),new Textbook(data[1], data[2], yearData, priceData, data[5], data[6], data[7])); 
                }//en if 
                if(data[0].equals("w")){
                   yearData = Integer.parseInt(data[3]);
                   priceData = Double.parseDouble(data[4]);
                   numProbData = Integer.parseInt(data[6]);
                   bookList.put(bookList.size(), new Workbook(data[1], data[2], yearData, priceData, data[5], numProbData));
                }if(data[0].equals("b")){
                   yearData = Integer.parseInt(data[3]);
                   priceData = Double.parseDouble(data[4]);
                   bookList.put(bookList.size(), new Book(data[1], data[2], yearData, priceData, data[5]));
                }//end if
                line = reader.readLine();
            }//end while
            System.out.println("***************************************");
            reader.close();
        } catch(IOException e){
            System.out.println("Failed to read "+fileName+".");
        }//end try
    }//end func
}//end class
