package lab3soln;

public class Workbook extends Book{
    
    private int numProblems;
    
    // ~_~_~_~_~_~_~_~_~_~_~_~_~_~_~_~_~_~_~_~_~_~_~_~_~_~_~_~_~_~_~_~_~_~_~_~_~
    
    public Workbook(){
        super();
        this.numProblems = 0;
    }
    
    public Workbook(String title, String author, int year, String ISBN, 
            double price, int numProblems){
        super(title, author, year, ISBN, price);
        this.numProblems = numProblems;
    }

    // ~_~_~_~_~_~_~_~_~_~_~_~_~_~_~_~_~_~_~_~_~_~_~_~_~_~_~_~_~_~_~_~_~_~_~_~_~
    
    @Override
    public boolean equals(Object o){
        if (this == o) return true;
        if (o == null) return false;
        if (!this.getClass().equals(o.getClass())) return false;
        
        Workbook w = (Workbook) o;
        return ((this.getNumProblems()==w.getNumProblems())&&super.equals(o));
    }
    
    @Override
    public String toString(){
        return "Workbook{" + "numProblems=" + numProblems +", "+ super.toString()+ "}";
    }
    
    // ~_~_~_~_~_~_~_~_~_~_~_~_~_~_~_~_~_~_~_~_~_~_~_~_~_~_~_~_~_~_~_~_~_~_~_~_~

    public int getNumProblems() {
        return numProblems;
    }

    public void setNumProblems(int numProblems) {
        this.numProblems = numProblems;
    }
    
}
