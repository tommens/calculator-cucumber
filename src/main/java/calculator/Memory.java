package calculator;

import java.util.*;

public class Memory {

    private Date date = new Date();
    private ArrayList<Result> memory;
    private int size;

    public Memory(int size) {
        memory = new ArrayList<>();
        this.size = size;
    }

    public Memory() {
        memory = new ArrayList<>();
        this.size = -1;
    }

    public ArrayList<Result> getMemory() {
        return memory;
    }

    public void setMemory(ArrayList<Result> memory) {
        this.memory = memory;
    }

    public void add(String variable, Expression expression, int result){
        if (memory.size() == size) {
            throw new RuntimeException("Memory is full");
        }
        for(Result r: memory) {
            if (r.getVariable().equals(variable)) {
                throw new RuntimeException("Variable already exists");
            }
        }
        memory.add(new Result(variable, result, expression));
    }


    public void remove(String variable){
        for(Result r: memory) {
            if (r.getVariable().equals(variable)) {
                memory.remove(r);
                return;
            }
        }
        throw new RuntimeException("Variable does not exist");
    }
    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        if (size < 0) {
            this.size = size;
            return;
        }
        if (size < memory.size()) {
            throw new RuntimeException("Size is smaller than the number of variables");
        }
        this.size = size;
    }

    public void clearMemory(){
        memory.clear();
    }

    public void displayLastData(int n) {
        if (n > memory.size()) {
            System.out.println(memory);
        }
        for(int a = memory.size()-n; a!= memory.size(); a++) {
            System.out.println(memory.get(a).getVariable() + " " + memory.get(a).getExpression() + " " + memory.get(a).getResult());
        }
    }

    public void display() {
        for (Result r : memory) {
            System.out.println(r.getVariable() + " " + r.getExpression() + " " + r.getResult());
        }
    }

    public void saveLog() {
        // TODO
    }

    public void loadLog() {
        // TODO
    }
}
