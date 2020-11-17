package ic.doc;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RPNController {

  private RPNModel calculationResult = new RPNModel();
  private RPNView calculatorInterface = new RPNView();

  class numController implements ActionListener {

    int num;

    public numController(int num) {
      this.num = num;
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
      calculationResult.addToDeque(num);
    }
  }

  class plusController implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent actionEvent) {
      calculationResult.plus();
    }
  }

  class minusController implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent actionEvent) {
      calculationResult.minus();
    }
  }

  class resetController implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent actionEvent) {
      calculationResult.reset();
    }
  }

}
