import javax.swing.*;
import java.awt.*;

class Frameset extends JFrame {
    Calculator calculator = new Calculator();

    public Frameset(String title) {
        super(title);
        setDefaultCloseOperation(javax.swing.JFrame.EXIT_ON_CLOSE);

        try {
            status();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,
                    "Proceso terminado"
            );
        }
    }

    void turnOnCalculator(boolean status) {
        if (status) {
            JOptionPane.showMessageDialog(
                    null,
                    "Calculadora encendida"
            );
            operation();

        } else {
            JOptionPane.showMessageDialog(null,
                    "Calculadora apagada"
            );
            System.exit(0);
        }
    }

    void status() {
        Object[] options = {"Encender", "Apagar"};
        JPanel panel = new JPanel();
        panel.add(
                new JLabel("Calculadora binaria.\nBienvenido.\n" +
                "IMPORTANTE: La calculadora " + "solo cuenta con suma, " +
                "resta, multiplicación y división.\n¿Qué desea hacer?"),
                BorderLayout.NORTH
        );
        int option = JOptionPane.showOptionDialog(
                null, panel,
                "Calculadora binaria",
                JOptionPane.YES_NO_CANCEL_OPTION,
                JOptionPane.PLAIN_MESSAGE,
                new ImageIcon(
                        "BinaryCalculator.logo.png"
                ),
                options,
                null
        );
        if (option == JOptionPane.YES_OPTION)  {
            turnOnCalculator(true);

        } else if (option == JOptionPane.NO_OPTION) {
            turnOnCalculator(false);
        }
    }

    public void operation() {
        String operation = JOptionPane.showInputDialog(
                null, "Calculadora de binario " +
                        "\nIngresa una operación binaria." +
                        "\n(suma, resta o multiplicación)"
        );
        do {
            if((operation.contains("0") && operation.contains("1"))) {
                if (operation.contains("+")) {
                    JOptionPane.showMessageDialog(null, calculator.binSum(operation));

                } else if (operation.contains("x")) {
                    JOptionPane.showMessageDialog(null, calculator.binMult(operation));

                } else if (operation.contains("-")) {
                    JOptionPane.showMessageDialog(null, calculator.binRest(operation));
                }
            } else {
                while ((!(operation.equals("0")) && (!(operation.equals("1"))))) {
                    JOptionPane.showMessageDialog(null, "ERROR: valores no binarios \n intenta de nuevo");
                    operation();
                }
            }
        }while((Integer.parseInt(operation) == 1) && (Integer.parseInt(operation) == 0));
    }

    public static void main(String[] args) {
        new Frameset("Calculadora binaria");
    }
}