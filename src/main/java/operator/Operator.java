package operator;

public interface Operator {

    void calculateInt(int firstNumber, int secondNumber);

    void calculateDouble(double firstNumber, double secondNumber);

    String getCharacterOperation();

    String getDescription();
}
