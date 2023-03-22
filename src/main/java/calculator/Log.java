package calculator;


public class Log extends Memory {

    public Log() {
        super();
    }


    @Override
    public void displayLastData(int n) {
        if (n > this.getMemory().size()) {
            this.display();
        }
        for(int a = this.getMemory().size()-n; a!= this.getMemory().size(); a++) {
            Result r = this.getMemory().get(a);
            System.out.println("Timestamp : "+r.getTimeStamp()+", ID : "+r.getVariable() + ", Result : " + r.getResult() + ", Expression :  " + r.getExpression());
        }
    }

    @Override
    public void display() {
        for (Result r : this.getMemory()) {
            System.out.println("Timestamp : "+r.getTimeStamp()+", ID : "+r.getVariable() + ", Result : " + r.getResult() + ", Expression :  " + r.getExpression());
        }
    }
}