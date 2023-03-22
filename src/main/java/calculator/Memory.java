package calculator;

import java.util.*;

public class Memory {
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

    public void add(String variable, int result, Expression expression){
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

    public void add(int result, Expression expression){
        String uniqueID = UUID.randomUUID().toString();
        this.getMemory().add(new Result(uniqueID, result, expression));
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
            System.out.println("Variable : "+r.getVariable() + ", Result : " + r.getResult() + ", Expression :  " + r.getExpression());
        }
    }

    public void save(String path) {
        // TODO
    }

    public void load(String path) {
        // TODO
    }
}
