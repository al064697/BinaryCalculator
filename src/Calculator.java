import javax.swing.*;

public class Calculator {
    String result;
    int n1, n2;

    String binSum(String operation) {
        n1 = Integer.parseInt(operation.substring(0, operation.indexOf('+')).trim(), 2);
        n2 = Integer.parseInt(operation.substring(operation.indexOf('+') + 1).trim(), 2);
        result = Integer.toBinaryString(n1 + n2);
        return result;
    }

    String binMult(String operation) {
        n1 = Integer.parseInt(operation.substring(0, operation.indexOf('x')).trim(), 2);
        n2 = Integer.parseInt(operation.substring(operation.indexOf('x') + 1).trim(), 2);
        result = Integer.toBinaryString(n1 * n2);
        return result;
    }

    String binRest(String operation) {
        n1 = Integer.parseInt(operation.substring(0, operation.indexOf('-')).trim(), 2);
        n2 = Integer.parseInt(operation.substring(operation.indexOf('-') + 1).trim(), 2);
        result = Integer.toBinaryString(n1 - n2);
        return result;
    }

}