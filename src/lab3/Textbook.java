package lab3;

import java.text.*;

public class Textbook extends Book{
    
    private String subject;
    private String workbookISBN;
    
    public Textbook(String title, String author, int year, double price, String isbn, String workbookISBN, String subject){
        super(title, author, year, price, isbn);
        this.subject = subject;
        this.workbookISBN = workbookISBN;
    }//end public
    
    public String getSubject(){
        return subject;
    }//end 
    
    public String getWorkbookISBN(){
        return workbookISBN;
    }//end 
    
    @Override
    public boolean equals(Object other){
        //check if the object is the same   
        if (other instanceof Workbook) {
            Workbook workbook = (Workbook) other;   
            if (this.workbookISBN.equals(workbook.getISBN()) == true){
                return true;
            }//end if
        }//end if
        return false;
    }//end 
    
    public String data(){
        return("t" + "@" + super.getTitle() + "@" + super.getAuthor() + "@" + super.getYear() + "@" + super.getPrice() + "@" + super.getISBN() + "@" + this.workbookISBN + "@" + this.subject);
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
       System.out.println("workbook ISBN: " + workbookISBN);
       System.out.println("Subject: " + subject);
       System.out.println("Amount of Book: " + super.amountOfBook());
       return("************************************************" +
              "\nTEXTBOOK" +
              "\nBook: " + super.getTitle() +
              "\nAuthor: " + super.getAuthor() +
              "\nYear of Publication: " + super.getYear() +
              "\nPrice: $" + twoDecimal.format(super.getPrice()) +
              "\nISBN: " + super.getISBN() + 
              "\nworkbook ISBN: " + workbookISBN +
              "\nSubject: " + subject +
              "\n***********************************************");
    }//end func
    
}//end class
