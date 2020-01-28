package operator;

public class Addition implements Operator {

    public void calculateInt(int firstNumber, int secondNumber) {
        System.out.println(firstNumber * secondNumber);
    }

    public void calculateDouble(double firstNumber, double secondNumber) {
        System.out.println(firstNumber * secondNumber);
    }

    public String getCharacterOperation() {
        return "*";
    }

    public String getDescription() {
        return "Addition";
    }
}
