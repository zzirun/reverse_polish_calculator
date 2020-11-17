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
    notifyObservers();
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

  public void reset() {
    nums.clear();
    result = 0;
    notifyObservers();
  }

  public int getResult() {
    return result;
  }



}
