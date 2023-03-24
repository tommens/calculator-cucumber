package calculator;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

import static cli.InputUser.*;

public class Memory {
    private ArrayList<Variable> memory;
    private int size;
    private static final String path = "memlog/";
    private static final String logFile = "log.txt";
    private static final String MemoryFile = "memory.txt";


    public Memory(int size){
        memory = new ArrayList<>();
        this.size = size;
    }

    public Memory() {
        memory = new ArrayList<>();
        this.size = -1;
    }

    public ArrayList<Variable> getMemory() {
        return memory;
    }

    public void setMemory(ArrayList<Variable> memory) {
        this.memory = memory;
    }

    public void add(String variable, int result, Expression expression){
        if (memory.size() == size) {
            throw new RuntimeException("Memory is full");
        }
        for(Variable r: memory) {
            if (r.getVariable().equals(variable)) {
                throw new RuntimeException("Variable already exists");
            }
        }
        memory.add(new Variable(variable, result, expression));
    }

    public void add(int result, Expression expression){
        if (memory.size() == size) {
            throw new RuntimeException("Memory is full");
        }
        String uniqueID = UUID.randomUUID().toString();
        this.getMemory().add(new Variable(uniqueID, result, expression));
    }


    public void remove(String variable){
        for(Variable r: memory) {
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
            Variable r = this.getMemory().get(a);
            System.out.println("Timestamp : "+r.getTimeStamp()+", ID : "+r.getVariable() + ", Result : " + r.getValue() + ", Expression :  " + r.getExpression());
        }
    }

    public void display() {
        for (Variable r : memory) {
            System.out.println("Timestamp : "+r.getTimeStamp()+", ID : "+r.getVariable() + ", Result : " + r.getValue() + ", Expression :  " + r.getExpression());
        }
    }

    public void saveLog() {
        save(logFile);
    }

    public void saveMemory() {
        save(MemoryFile);
    }

    private void save(String memoryFile) {
        try {
            FileWriter fileWriter = new FileWriter(path + memoryFile);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            for (Variable r : memory) {
                bufferedWriter.write(r.getTimeStamp() + " %%% " + r.getVariable() + " %%% " + r.getValue() + " %%% " + r.getExpression());
                bufferedWriter.newLine();
            }
            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void loadFile(File file)  {
        try {
            Scanner sc = new Scanner(file);
            while (sc.hasNextLine()) {
                String line = sc.nextLine();
                String[] data = line.split(" %%% ");
                String timeStamp = data[0];
                String name = data[1];
                int value =  Integer.parseInt(data[2]);
                String expressionString = data[3];
                List<Expression> expressions = new ArrayList<>();;
                // TODO : upgrade this part to handle recursive expressions
                String operator = null;
                Notation notation = checkNotation(expressionString);
                for (int i = 0; i < expressionString.length(); i++) {
                    if (isNumber(String.valueOf(expressionString.charAt(i)))) {
                        expressions.add(new MyNumber(Integer.parseInt(String.valueOf(expressionString.charAt(i)))));
                    }
                    if (isOperator(String.valueOf(expressionString.charAt(i)))) {
                        operator = String.valueOf(expressionString.charAt(i));
                    }
                }
                if (operator == null) {
                    Expression expression = new MyNumber(Integer.parseInt(expressionString));
                    System.out.println(expression);
                    Variable variable = new Variable(name, value, expression, timeStamp);
                    memory.add(variable);
                } else {
                    Expression expression = getOperator(operator, expressions, notation);
                    System.out.println(expression);
                    Variable variable = new Variable(name, value, expression, timeStamp);
                    memory.add(variable);
                }
            }
        } catch (Exception e) {
            System.out.println("Error reading log or memory file");
        }
    }

    private Notation checkNotation(String expression) {
        if (isOperator(String.valueOf(expression.charAt(0)))) {
            return Notation.PREFIX;
        } else if (isOperator(String.valueOf(expression.charAt(expression.length() - 1)))) {
            return Notation.POSTFIX;
        } else {
            return Notation.INFIX;
        }
    }

    public void loadMemory() {
        File memory = new File(path + MemoryFile);
        loadFile(memory);
    }

    public void loadLog() {
        File log = new File(path + logFile);
        loadFile(log);
    }


}
