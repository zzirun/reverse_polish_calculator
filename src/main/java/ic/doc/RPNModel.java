package ic.doc;

import java.util.ArrayDeque;
import java.util.Deque;

public class RPNModel {

  private final RPNView view;

  private Deque<Integer> nums = new ArrayDeque<Integer>();

  private int result = 0;

  public RPNModel(RPNView view) {
    this.view = view;
  }

  public void addToDeque(int num) {
    nums.add(num);
  }

  public void arithmetic(int startingValue, boolean plus) {
    result = startingValue;
    int size = nums.size();
    if (size > 0) {
      for (int i = 0; i < size; i++) {
        //accounts for case where user enters more than 2 numbers to be processed
        if (plus) {
          result += nums.pollFirst();
        } else {
          result -= nums.pollFirst();
        }
      }
    }
    nums.add(result);
//    view.update();
  }

  public void plus() {
    arithmetic(0, true);
  }

  public void minus() {
    int startingValue = 0;
    if (!nums.isEmpty()) {
      startingValue = nums.pollFirst();
    }
    arithmetic(startingValue, false);
  }

  public int getResult() {
    return result;
  }

}
