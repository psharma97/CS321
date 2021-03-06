import javax.swing.*;
import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class MoneyKeeper {
 
 public ArrayList<JPanel> panelList = new ArrayList<>();
 public Incomes inc;
 public Expenses exp;
 
 public static void main(String[] args) {
  new MoneyKeeper();
 }

 public MoneyKeeper() {
  JFrame guiFrame = new JFrame();
  guiFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  guiFrame.setTitle("MoneyKeeper");
  guiFrame.setSize(850, 800);
  //This will center the JFrame in the middle of the screen
  guiFrame.setLocationRelativeTo(null);
 
  //Expense Options
  String[] expenses = { "Rent", "Gas", "Insurance", "Food", "Utilities", "Entertainment"};
  
  //The first JPanel instantiates an Incomes Class. Incomes object is stored in MoneyKeeper.
  JPanel incomePanel = new JPanel();
  this.inc = new Incomes(incomePanel);
  this.panelList.add(incomePanel);
  
  
  //The second JPanel instantiates an Expenses Class
  //make suse the JPanel is not visible at start. Expenses object is stored in MoneyKeeper.
  JPanel expensePanel = new JPanel();
  this.exp = new Expenses(expensePanel);
  this.panelList.add(expensePanel);
  expensePanel.setVisible(false);
  

  
  
  JButton changeScreen = new JButton("Incomes or Expenses");
  changeScreen.addActionListener(new ActionListener() {
   @Override
   public void actionPerformed(ActionEvent event) {
    expensePanel.setVisible(!expensePanel.isVisible());
    incomePanel.setVisible(!incomePanel.isVisible());
   }
  });
  
  
  
  
  //The JFrame uses the BorderLayout layout manager.
  //Put the two JPanels and JButton in different areas.
  guiFrame.add(incomePanel, BorderLayout.NORTH);
  guiFrame.add(expensePanel, BorderLayout.CENTER);
  guiFrame.add(changeScreen, BorderLayout.SOUTH);
  //make sure the JFrame is visible
  guiFrame.setVisible(true);
 }


 // Calculate the difference between income and expenses. Used in multiple
 // functions throughout the application. Allows program to plan for various extra investments,
 // suggest student debt pay off plan etc. 
 public int calculateDelta() {
   int delta = this.inc.sumIncomes() - this.exp.sumExpenses();
   return delta;
 }
 
}
