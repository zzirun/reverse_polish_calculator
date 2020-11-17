package ic.doc;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class RPNView {

//  public RPNView () {
//    JFrame frame = new JFrame("Reverse Polish Calculator");
//    frame.setSize(300, 200);
//
//    JPanel panel = new JPanel();
//    JTextField textField = new JTextField("0", 10);
//
//    //adding buttons for numbers up to the limit
//    int limit = 10;
//    for (int i = 0; i < limit; i++) {
//      JButton button = new JButton(String.valueOf(i+1));
//      int finalI = i;
//      button.addActionListener(new ActionListener() {
//        @Override
//        public void actionPerformed(ActionEvent actionEvent) {
//          textField.setText(String.valueOf(finalI +1));
//          nums.add((finalI +1));
//        }
//      });
//      panel.add(button);
//    }
//
//    //plus button
//    JButton plus = new JButton("+");
//    plus.addActionListener(new ActionListener() {
//      @Override
//      public void actionPerformed(ActionEvent actionEvent) {
//        int sum = 0;
//        int size = nums.size();
//        if (size > 0) {
//          for (int i = 0; i < size; i++) {
//            //accounts for case where user enters more than 2 numbers to be processed
//            sum += nums.pollFirst();
//          }
//        }
//        nums.add(sum);
//        textField.setText(String.valueOf(sum));
//      }
//    });
//    panel.add(plus);
//
//    //minus button
//    JButton minus = new JButton("-");
//    minus.addActionListener(new ActionListener() {
//      @Override
//      public void actionPerformed(ActionEvent actionEvent) {
//        int difference = nums.pollFirst();
//        int size = nums.size();
//        if (size > 0) {
//          for (int i = 0; i < size; i++) {
//            //accounts for case where user enters more than 2 numbers to be processed
//            difference -= nums.pollFirst();
//          }
//        }
//        nums.add(difference);
//        textField.setText(String.valueOf(difference));
//      }
//    });
//    panel.add(minus);
//
//    //reset button
//    JButton reset = new JButton("Reset");
//    reset.addActionListener(new ActionListener() {
//      @Override
//      public void actionPerformed(ActionEvent actionEvent) {
//        nums.clear();
//        textField.setText("0");
//      }
//    });
//    panel.add(reset);
//
//    panel.add(textField);
//
//    frame.getContentPane().add(panel);
//    frame.setVisible(true);
//    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//  }

}
