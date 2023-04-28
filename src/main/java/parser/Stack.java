package parser;

import calculator.Expression;

import java.util.ArrayList;

/**
 * This class implement a stack data structure
 */
public class Stack {

    private ArrayList<ArrayList<Expression>> stack = new ArrayList<>();


    /**
     * Add a new array on the stack
     */
    public void addNewArray(){
        stack.add(new ArrayList<>());
    }

    /**
     * Insert an Expression object in the array that is on top of the stack
     * @param e The expression to add
     */
    public void insertInLastArray(Expression e){
        stack.get(stack.size()-1).add(e);
    }


    /**
     * Pop the array that is on top of the stack
     * @return The array on top
     */
    public ArrayList<Expression> popArray(){
        return stack.remove(stack.size()-1);
    }
}
