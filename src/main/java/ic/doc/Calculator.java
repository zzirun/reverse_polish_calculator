package ic.doc;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class Calculator {

  private List<Updatable> views = new ArrayList<>();

  private Deque<Integer> nums = new ArrayDeque<>();

  private int result = 0;

  public Calculator() {
  }

  public void addObserver(Display observer) {
    // Provides mobility for alternate views
    views.add(observer);
  }

  public void notifyObservers() {
    for (Updatable view : views) {
      view.update(this);
    }
  }

  public void addToDeque(int num) {
    nums.add(num);
    result = num;
    notifyObservers();
  }

  public void arithmetic(boolean plus) {
    // We have chosen to operate on the two most recent operands
    // if more than 2 operands have been entered before the operation.
    // For example,
    // 9 8 7 + = (8 + 7) = 15, and 9 8 7 + + = (9 + (8 + 7)) = 24,
    // 9 8 7 - = (8 - 7) = 1, and 9 8 7 - - = (9 - (8 - 7)) = 8
    result = 0;
    if (nums.size() > 0) {
      if (plus) {
        result += nums.pollLast();
      } else {
        result -= nums.pollLast();
      }
      if (nums.size() > 0) {
        if (plus) {
          result += nums.pollLast();
        } else {
          result += nums.pollLast();
        }
      }
    }
    nums.add(result);
    notifyObservers();
  }

  public void plus() {
    arithmetic(true);
  }

  public void minus() {
    arithmetic(false);
  }

  public void reset() {
    nums.clear();
    result = 0;
    notifyObservers();
  }

  public int getResult() {
    return result;
  }



}
