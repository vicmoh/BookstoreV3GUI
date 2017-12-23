//import library
package lab3;
import java.util.*;
import java.text.*;

public class Book {
    //decalre
    private static int numOfBook = -1;
    private String title, author;
    private int year;
    private double price;
    private String isbn;
    
    public Book(String title, String author, int year, double price, String isbn){
        //add books
        this.title = title;
        this.author = author;
        this.year = year;
        this.price = price;
        this.isbn = isbn;
        numOfBook++;
    }//end func
    
    public Book(){
        numOfBook++;
    }//end func
    
    public int amountOfBook(){
        return numOfBook;
    }//end if
    
    public String getTitle(){
        return title;
    }//end func
    
    public String getAuthor(){
        return author;
    }//ens func
    
    public int getYear(){
        return year;
    }//end mmethod
    
    public double getPrice(){
        return price;
    }//end func
    
    public String getISBN(){
        return isbn;
    }//end if
    
    public String data(){
        return("b" + "@" + getTitle() + "@" + getAuthor() + "@" + getYear() + "@" + getPrice() + "@" + getISBN());
    }//end string
    
    @Override public boolean equals(Object other){
        //check if the object is the same
        if (other instanceof Book) {
            Book book = (Book) other;
            if (this.author.equals(book.author)){
                return true;
            }//end if
        }//end if
        return false;
    }//end func
    
    public String toString(){
        //set object of 2 decimal format
       DecimalFormat twoDecimal = new DecimalFormat();
       twoDecimal.setMaximumFractionDigits(2);
       //display book 
       System.out.println("Book: " + title);
       System.out.println("Author: " + author);
       System.out.println("Year of Publication: " + year);
       System.out.println("Price: $" + twoDecimal.format(price));
       System.out.println("ISBN: " + isbn);
       System.out.println("Amount of Book: " + numOfBook);
       return("************************************************" +
              "\nBOOK" +
              "\nBook: " + title +
              "\nAuthor: " + author +
              "\nYear of Publication: " + year +
              "\nPrice: $" + twoDecimal.format(price) +
              "\nISBN: " + isbn + 
              "\n***********************************************");
    }//end func
}//end class
