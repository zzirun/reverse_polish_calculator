package ic.doc;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class RPNView implements Updatable {

  private RPNModel calculationResult;

  JTextField textField = new JTextField("0", 10);

  public RPNView (RPNController mainController, RPNModel calculationResult) {

    this.calculationResult = calculationResult;

    JFrame frame = new JFrame("Reverse Polish Calculator");
    frame.setSize(300, 200);

    JPanel panel = new JPanel();

    //adding buttons for numbers up to the limit
    int limit = 10;
    for (int i = 0; i < limit; i++) {
      JButton button = new JButton(String.valueOf(i + 1));
      button.addActionListener(mainController.getNumController(i + 1));
      panel.add(button);
    }

    //plus button
    JButton plus = new JButton("+");
    plus.addActionListener(mainController.getPlusController());
    panel.add(plus);

    //minus button
    JButton minus = new JButton("-");
    minus.addActionListener(mainController.getMinusController());
    panel.add(minus);

    //reset button
    JButton reset = new JButton("Reset");
    reset.addActionListener(mainController.getResetController());
    panel.add(reset);

    panel.add(textField);

    frame.getContentPane().add(panel);
    frame.setVisible(true);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  }

  @Override
  public void update(RPNModel model) {
    textField.setText(String.valueOf(model.getResult()));
  }
}
