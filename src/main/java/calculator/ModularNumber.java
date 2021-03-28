package calculator;

import visitor.Visitor;
import java.math.BigInteger;

public class ModularNumber implements Expression {
    private final BigInteger value;
    private final String representation;
    private final String moduloRepresentation;
    private final BigInteger modulo;

    public /*constructor*/ ModularNumber(String v) {
        value = new BigInteger(v);
        representation = v;
        modulo=new BigInteger(v).add(BigInteger.ONE);
        moduloRepresentation=v;
    }

    public /*constructor*/ ModularNumber(String v, String modulo) {
        value = new BigInteger(v);
        representation = v;
        this.modulo=new BigInteger(modulo);
        moduloRepresentation=modulo;
    }

    public BigInteger getNumber(){
        return value;
    }

    public BigInteger getValue() {
        return value.mod(modulo);
    }

    public String getRepresentation() {
        return representation;
    }

    public BigInteger getModulo() {
        return modulo;
    }

    public String getModuloRepresentation() {
        return moduloRepresentation;
    }

    public BigInteger getModularInverse(String modulo){
        return value.modInverse(new BigInteger(modulo));
    }

    public BigInteger getModularInverse(){
        return value.modInverse(modulo);
    }

    public void accept(Visitor v) {
        v.visit(this);
    }

    //Two MyNumber expressions are equal if the values they contain are equal
    @Override
    public boolean equals(Object o) {
        // No object should be equal to null (not including this check can result in an exception if a MyNumber is tested against null)
        if (o == null) return false;

        // If the object is compared to itself then return true
        if (o == this) {
            return true;
        }

        // If the object is of another type then return false
        if (!(o instanceof ModularNumber)) {
            return false;
        }
        return this.value.equals(((ModularNumber) o).value);
        // I used == above since the contained value is a primitive value
        // If it had been a Java object, .equals() would be needed
    }

    // The method hashCode() needs to be overridden if the equals method is overridden; otherwise there may be problems when you use your object in hashed collections such as HashMap, HashSet, LinkedHashSet
    @Override
    public int hashCode() {
        return value.intValue();
    }

}

