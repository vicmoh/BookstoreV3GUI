package lab3soln;

public class Textbook extends Book{
    
    private String subject;
    private String workbookISBN;
    
    // ~_~_~_~_~_~_~_~_~_~_~_~_~_~_~_~_~_~_~_~_~_~_~_~_~_~_~_~_~_~_~_~_~_~_~_~_~
    
    public Textbook(){
        super();
        this.subject = "";
        this.workbookISBN = "";
    }
    
    public Textbook(String title, String author, int year, String ISBN, 
            double price, String subject, String workbookISBN){
        super(title, author, year, ISBN, price);
        this.subject = subject;
        this.workbookISBN = workbookISBN;
    }
    
    // ~_~_~_~_~_~_~_~_~_~_~_~_~_~_~_~_~_~_~_~_~_~_~_~_~_~_~_~_~_~_~_~_~_~_~_~_~

    @Override
    public boolean equals(Object o){
        if (this == o) return true;
        if (o == null) return false;
        if (!this.getClass().equals(o.getClass())) return false;
        
        Textbook t = (Textbook) o;
        return ((this.getWorkbookISBN().equals(t.getWorkbookISBN()))&&
                (this.getSubject().equals(t.getSubject()))&&(super.equals(o)));
    }
    
    @Override
    public String toString() {
        return "Textbook{" + "subject=" + subject + ", workbookISBN=" + 
                workbookISBN +", "+ super.toString()+ "}";
    }
    

    // ~_~_~_~_~_~_~_~_~_~_~_~_~_~_~_~_~_~_~_~_~_~_~_~_~_~_~_~_~_~_~_~_~_~_~_~_~
    
    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getWorkbookISBN() {
        return workbookISBN;
    }

    public void setWorkbookISBN(String workbookISBN) {
        this.workbookISBN = workbookISBN;
    }
    
}
