package lab3soln;

public class Book {
    
    private String title;
    private String author;
    private int year;
    private String ISBN;
    private double price;

    // ~_~_~_~_~_~_~_~_~_~_~_~_~_~_~_~_~_~_~_~_~_~_~_~_~_~_~_~_~_~_~_~_~_~_~_~_~

    public Book(){
        this.title = "";
        this.author = "";
        this.year = 0;
        this.ISBN = "";
        this.price = 0.00;
    }
    
    public Book(String title, String author, int year, String ISBN, 
            double price){
        this.title = title;
        this.author = author;
        this.year = year;
        this.ISBN = ISBN;
        this.price = price;
    } 
    
    // ~_~_~_~_~_~_~_~_~_~_~_~_~_~_~_~_~_~_~_~_~_~_~_~_~_~_~_~_~_~_~_~_~_~_~_~_~
    
    @Override
    public boolean equals(Object o){
        if (this == o) return true;
        if (o == null) return false;
        if (!this.getClass().equals(o.getClass())) return false;
        
        Book b = (Book) o;
        if (!this.getTitle().equals(b.getTitle())) return false;
        if (!this.getAuthor().equals(b.getAuthor())) return false;
        if (!(this.getYear()==b.getYear())) return false;
        if (!this.getISBN().equals(b.getISBN())) return false;
        if (!(this.getPrice()==b.getPrice())) return false;
        return true;
    }

    @Override
    public String toString() {
        return "Book{" + "title=" + title + ", author=" + author + ", year=" 
                + year + ", ISBN=" + ISBN + ", price=" + price + "}";
    }
    
    // ~_~_~_~_~_~_~_~_~_~_~_~_~_~_~_~_~_~_~_~_~_~_~_~_~_~_~_~_~_~_~_~_~_~_~_~_~
    
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
   
}
