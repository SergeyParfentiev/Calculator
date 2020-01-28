package operator;

public class Subtraction implements Operator {
    @Override
    public void calculateInt(int firstNumber, int secondNumber) {
        System.out.println(firstNumber / secondNumber);
    }

    @Override
    public void calculateDouble(double firstNumber, double secondNumber) {
        System.out.println(firstNumber / secondNumber);
    }

    @Override
    public String getCharacterOperation() {
        return "/";
    }

    @Override
    public String getDescription() {
        return "Subtraction";
    }
}
