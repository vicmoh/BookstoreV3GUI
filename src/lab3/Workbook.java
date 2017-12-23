package lab3;

import java.text.*;

public class Workbook extends Book {
    
    private int numProblems;
    
    public Workbook(String title, String author, int year, double price, String isbn, int numProblems){
        super(title, author, year, price, isbn);
        this.numProblems = numProblems;
    }//end public
    
    public int getNumProblems(){
        return numProblems;
    }//end method
    
    @Override
    public boolean equals(Object other){
        //check if the object is the same
        if (other instanceof Textbook) {
            Textbook textbook = (Textbook) other;
            if (this.getISBN().equals(textbook.getWorkbookISBN()) == true){
                return true;
            }//end if
        }//end if
        return false;
    }//end 
    
    public String data(){
        return("w" + "@" + super.getTitle() + "@" + super.getAuthor() + "@" + super.getYear() + "@" + super.getPrice() + "@" + super.getISBN() + "@" + this.numProblems);
    }//end string
    
    public String toString(){
        //set object of 2 decimal format
       DecimalFormat twoDecimal = new DecimalFormat();
       twoDecimal.setMaximumFractionDigits(2);
       //display book 
       System.out.println("Book: " + super.getTitle());
       System.out.println("Author: " + super.getAuthor());
       System.out.println("Year of Publication: " + super.getYear());
       System.out.println("Price: $" + twoDecimal.format(super.getPrice()));
       System.out.println("ISBN: " + super.getISBN());
       System.out.println("Number of Problems: " + this.numProblems);
       System.out.println("Amount of Book: " + super.amountOfBook());
       return("************************************************" +
              "\nWORKBOOK" +
              "\nBook: " + super.getTitle() +
              "\nAuthor: " + super.getAuthor() +
              "\nYear of Publication: " + super.getYear() +
              "\nPrice: $" + twoDecimal.format(super.getPrice()) +
              "\nISBN: " + super.getISBN() + 
              "\nNumber of Problems: " + this.numProblems +
              "\n***********************************************");
    }//end func
}//end func
