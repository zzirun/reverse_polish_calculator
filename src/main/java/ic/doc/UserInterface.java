package ic.doc;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UserInterface {

  private Calculator calculator = new Calculator();
  private Display calculatorInterface = new Display(this);

  public UserInterface() {
    calculator.addObserver(calculatorInterface);
  }

  public ActionListener getNumController(int i) {
    return new NumController(i);
  }

  public ActionListener getPlusController() {
    return new PlusController();
  }

  public ActionListener getMinusController() {
    return new MinusController();
  }

  public ActionListener getResetController() {
    return new ResetController();
  }

  // We have decided to keep controller classes as inner classes for access to Calculator class
  // without violating encapsulation

  class NumController implements ActionListener {

    int num;

    public NumController(int num) {
      this.num = num;
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
      calculator.addToDeque(num);
    }
  }

  class PlusController implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent actionEvent) {
      calculator.plus();
    }
  }

  class MinusController implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent actionEvent) {
      calculator.minus();
    }
  }

  class ResetController implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent actionEvent) {
      calculator.reset();
    }
  }

  public static void main(String[] args) {
    new UserInterface();
  }

}
