import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CustomDialog extends JDialog {
    private final JTextField textField;

    public CustomDialog(JFrame parent, String message) {
        super(parent, "Mi ventana", true);
        setLayout(new FlowLayout());

        JLabel label = new JLabel(message);
        add(label);

        textField = new JTextField(10);
        add(textField);

        JButton okButton = new JButton("Aceptar");
        okButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
            }
        });
        add(okButton);

        setSize(300, 200);
        setLocationRelativeTo(parent);
    }

    public String getInput() {
        return textField.getText();
    }

}