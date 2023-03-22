package calculator;

import cli.InputUser;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Memory {
    private ArrayList<Result> memory;
    private int size;

    private static final String path = "memlog/";
    private static final String logFile = "log.txt";
    private static final String MemoryFile = "memory.txt";


    public Memory(int size){
        memory = new ArrayList<>();
        this.size = size;
        try {
            load(path);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public Memory() {
        memory = new ArrayList<>();
        this.size = -1;
        try {
            load(path);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
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
            display();
        }
        for(int a = memory.size()-n; a!= memory.size(); a++) {
            Result r = this.getMemory().get(a);
            System.out.println("Timestamp : "+r.getTimeStamp()+", ID : "+r.getVariable() + ", Result : " + r.getResult() + ", Expression :  " + r.getExpression());
        }
    }

    public void display() {
        for (Result r : memory) {
            System.out.println("Timestamp : "+r.getTimeStamp()+", ID : "+r.getVariable() + ", Result : " + r.getResult() + ", Expression :  " + r.getExpression());
        }
    }

    public void save(String path) {
        File log = new File(path + logFile);
        File memory = new File(path + MemoryFile);
        saveFile(log);
        saveFile(memory);
    }

    private void saveFile(File file) {
        try {
            Formatter formatter = new Formatter(file);
            for (Result r : memory) {
                formatter.format("%s /// %s /// %d /// %s", r.getTimeStamp(), r.getVariable(), r.getResult(), r.getExpression());
            }
        } catch (Exception e) {
            System.out.println("Error writing to log or memory file");
        }
    }

    public void loadFile(File file)  {
        if(!file.exists()) {
            try {
                file.createNewFile();
            } catch (Exception e) {
                System.out.println("Error creating log file");
            }
        } else {
            try {
                Scanner sc = new Scanner(file);
                while (sc.hasNextLine()) {
                    String line = sc.nextLine();
                    String[] data = line.split(" /// ");
                    String timeStamp = data[0];
                    String variable = data[1];
                    int result =  Integer.parseInt(data[2]);
                    String expression = data[3];
                    // TODO : add expression to result
                    //InputUser inputUser = new InputUser();
                    memory.add(new Result(variable, result, /*new Expression(expression)*/null));
                }
            } catch (Exception e) {
                System.out.println("Error reading log or memory file");
            }
        }
    }

    public void load(String path) throws FileNotFoundException {
        File log = new File(path + logFile);
        File memory = new File(path + MemoryFile);
        loadFile(log);
        loadFile(memory);
    }
}
