package ic.doc;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class CalculatorTest {

  Calculator model = new Calculator();

  private void populateNormal() {
    model.addToDeque(1);
    model.addToDeque(10);
  }

  private void populateMultiple() {
    model.addToDeque(4);
    model.addToDeque(5);
    model.addToDeque(10);
  }

  @Test
  public void addingToDequeChangesResult() {
    populateNormal();
    assertThat(model.getResult(), is(10));
  }

  @Test
  public void addNormal() {
    populateNormal();
    model.plus();
    assertThat(model.getResult(), is(11));
  }

  @Test
  public void addSumsTwoMostRecentOperands() {
    populateMultiple();
    model.plus();
    assertThat(model.getResult(), is(15));
  }

  @Test
  public void multipleNormalAdds() {
    populateNormal();
    model.plus();
    assertThat(model.getResult(), is(11));
    model.addToDeque(8);
    model.plus();
    assertThat(model.getResult(), is(19));
  }

  @Test
  public void addReturns0WithoutOperands() {
    model.plus();
    assertThat(model.getResult(), is(0));
  }

  @Test
  public void addDoesNothingWithOneOperand() {
    model.addToDeque(4);
    model.plus();
    assertThat(model.getResult(), is(4));
  }

  @Test
  public void subtractNormal() {
    populateNormal();
    model.minus();
    assertThat(model.getResult(), is(-9));
  }

  @Test
  public void minusSubtractsMostRecentOperandFromSecondMostRecentOperand() {
    populateMultiple();
    model.minus();
    assertThat(model.getResult(), is(-5));
  }

  @Test
  public void subtractReturns0WithoutOperands() {
    model.minus();
    assertThat(model.getResult(), is(0));
  }

  @Test
  public void subtractNegatesOperandWithOneOperand() {
    model.addToDeque(4);
    model.minus();
    assertThat(model.getResult(), is(-4));
  }

  @Test
  public void multipleNormalAddsAndSubtractions() {
    populateNormal();
    model.plus();
    model.addToDeque(8);
    model.minus();
    model.addToDeque(7);
    model.minus();
    model.addToDeque(6);
    model.plus();
    assertThat(model.getResult(), is(2));
  }

  @Test
  public void resetSetsResultToZero() {
    populateNormal();
    model.plus();
    model.addToDeque(8);
    model.minus();
    model.addToDeque(7);
    model.minus();
    model.reset();
    assertThat(model.getResult(), is(0));
  }



}
