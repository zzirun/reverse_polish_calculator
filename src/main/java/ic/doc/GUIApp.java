package ic.doc;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUIApp {

  private Calculator calculator = new Calculator();
  private Display calculatorInterface = new Display(this);

  public GUIApp() {
    calculator.addObserver(calculatorInterface);
  }

  public ActionListener getNumController(int i) {
    return new numController(i);
  }

  public ActionListener getPlusController() {
    return new plusController();
  }

  public ActionListener getMinusController() {
    return new minusController();
  }

  public ActionListener getResetController() {
    return new resetController();
  }

  class numController implements ActionListener {

    int num;

    public numController(int num) {
      this.num = num;
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
      calculator.addToDeque(num);
    }
  }

  class plusController implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent actionEvent) {
      calculator.plus();
    }
  }

  class minusController implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent actionEvent) {
      calculator.minus();
    }
  }

  class resetController implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent actionEvent) {
      calculator.reset();
    }
  }

  public static void main(String args[]) {
    new GUIApp();
  }

}
