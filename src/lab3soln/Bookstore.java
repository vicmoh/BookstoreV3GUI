package lab3soln;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Bookstore {

    // Book type constants
    public static final int BT_BOOK = 1;
    public static final int BT_TEXTBOOK = 2;
    public static final int BT_WORKBOOK = 3;
    public static final int BT_FLOOR = 1;
    public static final int BT_CEILING = 3;
    
    // String formatting properties
    public static final int SF_NONEMPTY = 0;
    public static final int SF_ISBN = 1;
    
    // Integer format properties
    public static final int IF_BT = 0;
    public static final int IF_YEAR = 1;
    public static final int IF_NUMPROBS = 2;
    
    // Prompt constants
    public static final String P_BTMSG = "What kind of book would you like to add?\n1.Book\n2.Textbook\n3.Workbook";
    public static final String P_BTERR = "Input must be an integer between 1 and 3, inclusive.";
    public static final String P_TITLEMSG = "Enter the book's title.";
    public static final String P_TITLEERR = "Title must be a nonempty string.";
    public static final String P_AUTHMSG = "Enter the book's author.";
    public static final String P_AUTHERR = "Author must be a nonempty string.";
    public static final String P_YEARMSG = "Enter the book's year of publication.";
    public static final String P_YEARERR = "Year must be in the range -2600..2017, inclusive.";
    public static final String P_ISBNMSG = "Enter the book's ISBN.";
    public static final String P_ISBNERR = "An ISBN is a length 10 or 13 numerical sequence.";
    public static final String P_PRCMSG = "Enter the book's price.";
    public static final String P_PRCERR = "Price must be a positive real number, which gets rounded to 2 decimal places after being entered.";
    public static final String P_SUBJMSG = "Enter the book's subject.";
    public static final String P_SUBJERR = "Subject must be a nonempty string.";
    public static final String P_WBISBNMSG = "Enter the textbook's workbookISBN.";
    public static final String P_WBISBNERR = "An ISBN is a length 10 or 13 numerical sequence.";
    public static final String P_NPROBSMSG = "Enter the workbook's number of problems.";
    public static final String P_NPROBSERR = "The number of problems must be a positive integer.";

    // Other constants
    public static final int ISBN_LEN1 = 10;
    public static final int ISBN_LEN2 = 13;
    public static final int YEAR_FLOOR = -2600;
    public static final int YEAR_CIELING = 2017;
    public static final String FILE = "output.txt";
    
    // ~_~_~_~_~_~_~_~_~_~_~_~_~_~_~_~_~_~_~_~_~_~_~_~_~_~_~_~_~_~_~_~_~_~_~_~_~    
    
    private ArrayList<Book> books;
    
    // ~_~_~_~_~_~_~_~_~_~_~_~_~_~_~_~_~_~_~_~_~_~_~_~_~_~_~_~_~_~_~_~_~_~_~_~_~

    public Bookstore(){
        this.books = new ArrayList();
    }
    
    // ~_~_~_~_~_~_~_~_~_~_~_~_~_~_~_~_~_~_~_~_~_~_~_~_~_~_~_~_~_~_~_~_~_~_~_~_~
  
    /**
     * A possible skeleton for the new addBook() method, now that the command
     * loop is gone and the program is event-driven.
     * 
     * @param bookType
     * @param title
     * @param author
     * @param year
     * @param ISBN
     * @param price
     * @param subject
     * @param workbookISBN
     * @param numProblems
     * @return 
     */
    public String addBook(int bookType, String title, String author, int year, 
            String ISBN, double price, String subject, String workbookISBN, 
            int numProblems){
        
        Book book = null;
        
        switch (bookType) {
            case BT_TEXTBOOK:
                break;
            case BT_WORKBOOK:
                break;
            case BT_BOOK:
                break;
        }
        
        if (book == null){
            return "Failed to add book."; 
        } else {
            this.books.add(book);
            return "Book added successfully!";
        }
    }
    
    // ~_~_~_~_~_~_~_~_~_~_~_~_~_~_~_~_~_~_~_~_~_~_~_~_~_~_~_~_~_~_~_~_~_~_~_~_~
    
    /**
     * For a given String format (class constants with the prefix SF_ above),
     * verifies whether the String has the correct properties to be used for
     * a particular field.
     * 
     * @param input - A String passed by the user as a potential value for a 
     *                  Book field
     * @param format - SF_NONEMPTY or SF_ISBN depending on the string being 
     *                  passed
     * 
     * @return True if the String has the correct format, false otherwise
     */
    public boolean validateFormat(String input, int format){
        switch(format){
            case SF_NONEMPTY:
                return !input.isEmpty();
            case SF_ISBN:
                for(int i=0; i<input.length(); i++){
                    if (!Character.isDigit(input.charAt(i))) return false;
                }
                return ((input.length()==ISBN_LEN1)||(input.length()==ISBN_LEN2));
            default:
                System.out.println("Bookstore.validateFormat(input="+input+", "
                        + "format="+format+") - unexpected format, returning "
                                + "false.");
                return false;
        }
    }
    
    /**
     * For a given integer format (class constants with the prefix IF_ above),
     * verifies whether the String has the correct properties to be used for a
     * particular field.
     * 
     * @param input - An integer passed by the user as a potential value for a
     *                  Book field
     * @param format - IF_BT, IF_YEAR, or IF_NUMPROBS depending on the integer
     *                  being passed
     * 
     * @return True if the int has the correct format, false otherwise
     */
    public boolean validateFormat(int input, int format){
        switch(format){
            case IF_BT:
                return ((input >= BT_FLOOR)&&(input <= BT_CEILING));
            case IF_YEAR:
                return ((input >= YEAR_FLOOR)&&(input <= YEAR_CIELING));
            case IF_NUMPROBS:
                return (input > 0);
            default:
                 System.out.println("Bookstore.validateFormat(input="+input+", "
                        + "format="+format+") - unexpected format, returning "
                                + "false.");
                return false;  
        }
    }
    
    /**
     * Verifies that the value passed in for price is in the correct range.
     * 
     * @param input A double passed by the user as a potential value for price.
     * 
     * @return True if price is greater than 0, false otherwise
     */
    public boolean validateFormat(double input){
        return (input > 0);
    }

    // ~_~_~_~_~_~_~_~_~_~_~_~_~_~_~_~_~_~_~_~_~_~_~_~_~_~_~_~_~_~_~_~_~_~_~_~_~
    // ~_~_~_~_~_~_~_~_~_~_~_~_~_~_~_~_~_~_~_~_~_~_~_~_~_~_~_~_~_~_~_~_~_~_~_~_~
    
    /**
     * Produces the Bookstore menu.
     * 
     * @return A String representation of the Bookstore.
     */
     public String printMenu(){
        return "Please choose an option.\n1. Add a book\n2. List books\n"
                + "3. Print all unique authors\n4. Print the average book "
                + "price, along with the number of books\n5. Print all "
                + "Textbook.workbookISBN <=> Workbook.ISBN pairs\n6. Save the"
                + " program state (overwrites existing states)\n7. Load the "
                + "program state\n8. Quit";
    }
    
    /**
     * Lists all Books in the Bookstore if any are present.
     * 
     * @return A String containing a list of Books if any are present, otherwise
     *          a message that reports that no Books exist in the Bookstore.
     */
    public String listBooks(){
        String output;
        if (this.books.isEmpty()) output = "No books in the Bookstore!";
        else {
           output = "Books in the Bookstore: \n";
           for(int i=0; i<this.books.size(); i++){
               output += this.books.get(i).toString()+"\n";
           }
        }
        return output;
    }
    
    /**
     * Lists all authors whose names appear only once in Books in the Bookstore.
     * 
     * @return A list of authors if any Books are present, or a message that 
     *          no Books exist in the Store.
     */
    public String listUniqueAuthors(){
        String output;
        if (this.books.isEmpty()) output = "No books in the Bookstore!";
        else {
            ArrayList<String> unique = new ArrayList();
            for(int i=0; i<this.books.size(); i++){
                String author = this.books.get(i).getAuthor();
                if (!unique.contains(author)) unique.add(author);
            }
            output = "Unique authors: ";
            for(int i=0; i<unique.size(); i++){
                output += unique.get(i)+"\n";
            }
        }
        
        return output;
    }
    
    /**
     * Computes the average price of Books in the Bookstore.
     * 
     * @return The average price of Books in the Bookstore if any exist,
     *          otherwise a message that no books are present.
     */
    public String printAveragePrice(){
        if (this.books.isEmpty()) return "No books in the Bookstore!";
        String output;
        double sum = 0;
        double average;
        
        for(int i=0; i<this.books.size(); i++){
            sum += this.books.get(i).getPrice();
        }
        
        average = sum / this.books.size();
      
        return "There are "+this.books.size()+" books in the Bookstore, with an"
                + " average price of "+average+".";
    }
    
    /**
     * Finds all pairs (textbook, workbook) sth 
     * textbook.workbokISBN.equals(workbook.ISBN).
     * 
     * @return A list of the textbook-workbook pairs present in the Bookstore
     *          if any exist, or a message that none exist.
     */
    public String listTextbookWorkbookPairs(){
        if (this.books.isEmpty()) return "No books in the Bookstore!";
        else if (this.books.size() < 2) return "Not enough books to support any Textbook-Workbook pairs!";
        
        String output = "Textbook <=> Workbook pairs:\n";       
        for (int i=0; i<this.books.size(); i++){
            Book book1 = this.books.get(i);
            if (book1.getClass().getCanonicalName().equals("labs.Textbook")){
                for(int j=0; j<this.books.size(); j++){
                    if (j != i){
                        Book book2 = this.books.get(j);
                        if (book2.getClass().getCanonicalName().equals("labs.Workbook")){
                            Textbook t = (Textbook) book1;
                            Workbook w = (Workbook) book2;
                            if (t.getWorkbookISBN().equals(w.getISBN())){
                                output += t.getTitle()+" <=> "+w.getTitle()+"\n";
                            }
                        }
                    }
                }
            }
        }
        
        if (output.length() == "Textbook-Workbook pairs:".length()){
            output = "No Textbook-Workbook pairs in the Bookstore!";
        }
        
        return output;
    }
    
    /**
     * Saves the books currently in the Bookstore to the file output.txt.
     * 
     * @return A string reporting whether the operation was successful.
     */
    public String saveBookstoreState(){
        BufferedWriter writer;
        try{
            writer = new BufferedWriter(new FileWriter(FILE));
            for(int i=0; i<this.books.size(); i++){
                writer.write(books.get(i).toString()+"\n");
            }
            writer.close();
        } catch(IOException e){
            return "Failed to write to "+FILE+".";
        }
        
        return "Successfully wrote to file, saved "+this.books.size()+" books.";
        
    }
    
    /**
     * Loads zero or more Books from the file output.txt and adds them to the 
     * Bookstore. Treats loading as adding - that is, checks for duplicates
     * before adding.
     * 
     * @return A message indicating whether the file was loaded successfully
     *          and, if it was, how many books were loaded (and were not 
     *          duplicates).
     */
    public String loadBookstoreState(){
        BufferedReader reader;
        int numLines = 0;
        int wrongFormat = 0;
        int duplicates = 0;
        int booksAdded = 0;
        try{
            reader = new BufferedReader(new FileReader(FILE));
            String line = "";
            while (line != null){
                line = reader.readLine();
                if (line != null){
                    Book book = getBookFromString(line);
                    numLines++;
                    if (book != null) {
                        if (this.books.contains(book)){
                            duplicates++;
                        } else {
                            this.books.add(book);
                            booksAdded++;
                        }
                    } else{
                        wrongFormat++;
                    }
                }
            }
            
            reader.close();
        } catch(IOException e){
            return "Failed to read "+FILE+". No books loaded.";
        }
        
        return "Successfully read "+FILE+" with "+numLines+" entries.\nLoaded "
                +booksAdded+" books: "+duplicates+" entries were duplicates and"
                + " were not added; "+wrongFormat+" were incorrectly formatted "
                + "and could not be added.";
    }
    
    /*
     *  Retrieves a Book or one of its subtypes from their toString() 
     *  representation.
    */
    private Book getBookFromString(String line){
        String[] splitLine = line.split("[{},=]");
                        
        if ((splitLine.length!=11)&&
                (splitLine.length!=14)&&
                (splitLine.length!=16)){
            return null;
        }
        
        switch(splitLine[0]){
            case "Book":
                // Load field values
                String title = splitLine[2];
                String author = splitLine[4];
                int year;
                try{
                    year = Integer.parseInt(splitLine[6]);
                } catch (NumberFormatException n) {
                    System.out.println("Bookstore.getBookFromString(line): "
                            + "Failed to parse field 'year'. Unable to "
                            + "make a Book from line. Returning null.");  
                    return null;
                }
                String ISBN = splitLine[8];
                double price;
                try{
                    price = Double.parseDouble(splitLine[10]);
                } catch (NumberFormatException n){
                    System.out.println("Bookstore.getBookFromString(line): "
                            + "Failed to parse field 'price'. Unable to "
                            + "make a Book from line. Returning null.");                   
                    return null;
                }
                
                // Validate field values
                if (validateFormat(title, SF_NONEMPTY) && 
                        validateFormat(author, SF_NONEMPTY) && 
                        validateFormat(year, IF_YEAR) && 
                        validateFormat(ISBN, SF_ISBN) && 
                        validateFormat(price)){
                    return new Book(title, author, year, ISBN, price);
                } else{
                    System.out.println("Bookstore.getBookFromString(line): "
                            + "One or more invalid fields in entry. Unable to "
                            + "make a Book from line. Returning null.");
                    return null;
                }
                
            case "Textbook":
                // Load field values
                String subject = splitLine[2];
                String workbookISBN = splitLine[4];
                title = splitLine[7];
                author = splitLine[9];
                try{
                    year = Integer.parseInt(splitLine[11]);
                } catch(NumberFormatException n){
                    System.out.println("Bookstore.getBookFromString(line): "
                            + "Failed to parse field 'year'. Unable to "
                            + "make a Textbook from line. Returning null.");
                    return null;
                }
                ISBN = splitLine[13];
                try{
                    price = Double.parseDouble(splitLine[15]);
                } catch(NumberFormatException n){
                    System.out.println("Bookstore.getBookFromString(line): "
                            + "Failed to parse field 'price'. Unable to "
                            + "make a Textbook from line. Returning null.");
                    return null;
                }
                
                // Validate field values
                if (validateFormat(title, SF_NONEMPTY) && 
                        validateFormat(author, SF_NONEMPTY) && 
                        validateFormat(year, IF_YEAR) && 
                        validateFormat(ISBN, SF_ISBN) && 
                        validateFormat(price) && 
                        validateFormat(subject, SF_NONEMPTY) &&
                        validateFormat(workbookISBN, SF_ISBN)){
                    return new Textbook(title, author, year, ISBN, price, subject, workbookISBN);
                } else{
                    System.out.println("Bookstore.getBookFromString(line): "
                            + "One or more invalid fields in entry. Unable to "
                            + "make a Textbook from line. Returning null.");
                    return null;
                }
               
            case "Workbook":
                // Load field values
                int numProblems;
                try{
                    numProblems = Integer.parseInt(splitLine[2]);
                } catch(NumberFormatException n){
                    System.out.println("Bookstore.getBookFromString(line): "
                            + "Failed to parse field 'numProblems'. Unable to "
                            + "make a Workbook from line. Returning null.");
                    return null;
                }
                
                title = splitLine[5];
                author = splitLine[7];
                try{
                    year = Integer.parseInt(splitLine[9]);
                } catch (NumberFormatException n) {
                    System.out.println("Bookstore.getBookFromString(line): "
                            + "Failed to parse field 'year'. Unable to make a "
                            + "Workbook from lne. Returning null.");
                    return null;
                }
                ISBN = splitLine[11];
                try{
                    price = Double.parseDouble(splitLine[13]);
                } catch (NumberFormatException n){
                    System.out.println("Bookstore.getBookFromString(line): "
                            + "Failed to parse field 'price'. Unable to make a "
                            + "Workbook from lne. Returning null.");
                    return null;
                }
                
                // Validate field values
                if (validateFormat(title, SF_NONEMPTY) && 
                        validateFormat(author, SF_NONEMPTY) && 
                        validateFormat(year, IF_YEAR) && 
                        validateFormat(ISBN, SF_ISBN) && 
                        validateFormat(price) &&
                        validateFormat(numProblems, IF_NUMPROBS)){
                    return new Workbook(title, author, year, ISBN, price, numProblems);
                } else{
                    System.out.println("Bookstore.getBookFromString(line): "
                            + "One or more invalid fields in entry. Unable to "
                            + "make a Workbook from line. Returning null.");
                    return null;
                }
                
            default:
                System.out.println("Bookstore.getBookFromString(line): "
                        + "Unexpected Book type '"+splitLine[0]+"'. Unable to "
                                + "make a Book. Returning null.");
                return null;
        }
    }
}
