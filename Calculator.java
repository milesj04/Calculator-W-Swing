/*-----------------------------------------------------------------------------------
 * This is a fully functional calculator program built using Java and Swing for the GUI.
 * The program supports basic arithmetic operations such as addition, subtraction,
 * multiplication, division, as well as advanced operations like power, square roots,
 * logarithms, and factorials. Users can also store and recall values from memory, and
 * the calculator includes error handling for invalid operations such as division by zero.
 * The program's intuitive interface features buttons for each operation, and the input is
 * displayed dynamically. With features like reciprocal calculation and the ability to switch
 * signs for numbers, this calculator offers both functionality and ease of use.
 * -----------------------------------------------------------------------------------
 *------------------------------------------------------------------------------------
 * AUTHOR: MILES JENNINGS 12/15/24
 * -----------------------------------------------------------------------------------
 * ~ EECS 40; Professor Zhou Li; University of California Irvine ~
 * -----------------------------------------------------------------------------------
 */
package calculator;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Calculator {
    //Main panel for the swing GUI
    private JPanel calcPanel;
    //Text field to display the buttons/result calculated
    private JTextField textField;
    //buttons that make up the calculator
    private JButton zeroBtn;
    private JButton mClearBtn;
    private JButton reciprocalBtn;
    private JButton clearBtn;
    private JButton fourBtn;
    private JButton oneBtn;
    private JButton sevenBtn;
    private JButton mRecallBtn;
    private JButton sqrBtn;
    private JButton divideBtn;
    private JButton mulBtn;
    private JButton minusBtn;
    private JButton addBtn;
    private JButton mAddBtn;
    private JButton powerBtn;
    private JButton signBtn;
    private JButton eightBtn;
    private JButton fiveBtn;
    private JButton twoBtn;
    private JButton mSubBtn;
    private JButton digitBtn;
    private JButton logBtn;
    private JButton equalBtn;
    private JButton factorialBtn;
    private JButton nineBtn;
    private JButton sixBtn;
    private JButton threeBtn;

    /**
     * Class made to be the base class to be inherited from for the number buttons
     */
    class numberBtnClicked implements ActionListener {
        // The value associated with the number button
        private final int value;
        private final JTextField textField;

        /**
         * Constructor that sets the value of the number button and the text field.
         *
         * @param value The number value as an integer (e.g., 1, 2, 3).
         * @param textField The text field to update when the button is clicked.
         */
        public numberBtnClicked(int value, JTextField textField) {
            this.value = value;
            this.textField = textField;
        }

        /**
         * Appends the button's value to the calculator's display when clicked.
         *
         * @param e is the event triggered by the button click.
         */
        @Override
        public void actionPerformed(ActionEvent e) {
            if(textField.getText().equals("0")){
                textField.setText(String.valueOf(value));
            } else {
                textField.setText(textField.getText() + value);
            }

        }
    }

    /**
     * Handles the click event for the '0' button. (Each number button has a class)
     * Each class (zeroBtnClicked - nineBtnClicked) has a constructor for their event handler
     */
    class zeroBtnClicked extends numberBtnClicked {
        /**
         * Constructor for the zeroBtnClicked class
         * @param textField is the textField to update whenever pressed
         */
        public zeroBtnClicked(JTextField textField) {
            super(0, textField);
        }
    }

    /**
     * Handles the click event for the '1' button.
     */
    class oneBtnClicked extends numberBtnClicked {
        /**
         * Constructor for the oneBtnClicked class
         * @param textField is the textField to update whenever pressed
         */
        public oneBtnClicked(JTextField textField) {
            super(1, textField);
        }
    }

    /**
     * Handles the click event for the '2' button.
     */
    class twoBtnClicked extends numberBtnClicked {
        /**
         * Constructor for the twoBtnClicked class
         * @param textField is the textField to update whenever pressed
         */
        public twoBtnClicked(JTextField textField) {
            super(2, textField);
        }
    }

    /**
     * Handles the click event for the '3' button.
     */
    class threeBtnClicked extends numberBtnClicked {
        /**
         * Constructor for the threeBtnClicked class
         * @param textField is the textField to update whenever pressed
         */
        public threeBtnClicked(JTextField textField) {
            super(3, textField);
        }
    }

    /**
     * Handles the click event for the '4' button.
     */
    class fourBtnClicked extends numberBtnClicked {
        /**
         * Constructor for the fourBtnClicked class
         * @param textField is the textField to update whenever pressed
         */
        public fourBtnClicked(JTextField textField) {
            super(4, textField);
        }
    }

    /**
     * Handles the click event for the '5' button.
     */
    class fiveBtnClicked extends numberBtnClicked {
        /**
         * Constructor for the fiveBtnClicked class
         * @param textField is the textField to update whenever pressed
         */
        public fiveBtnClicked(JTextField textField) {
            super(5, textField);
        }
    }

    /**
     * Handles the click event for the '6' button.
     */
    class sixBtnClicked extends numberBtnClicked {
        /**
         * Constructor for the sixBtnClicked class
         * @param textField is the textField to update whenever pressed
         */
        public sixBtnClicked(JTextField textField) {
            super(6, textField);
        }
    }

    /**
     * Handles the click event for the '7' button.
     */
    class sevenBtnClicked extends numberBtnClicked {
        /**
         * Constructor for the sevenBtnClicked class
         * @param textField is the textField to update whenever pressed
         */
        public sevenBtnClicked(JTextField textField) {
            super(7, textField);
        }
    }

    /**
     * Handles the click event for the '8' button.
     */
    class eightBtnClicked extends numberBtnClicked {
        /**
         * Constructor for the eightBtnClicked class
         * @param textField is the textField to update whenever pressed
         */
        public eightBtnClicked(JTextField textField) {
            super(8, textField);
        }
    }

    /**
     * Handles the click event for the '9' button.
     */
    class nineBtnClicked extends numberBtnClicked {
        /**
         * Constructor for the nineBtnClicked class
         * @param textField is the textField to update whenever pressed
         */
        public nineBtnClicked(JTextField textField) {
            super(9, textField);
        }
    }
    //initializing variables to use in operations/methods
    double num1 = 0.0;      //first operand
    double num2 = 0.0;      //second operand
    double result = 0.0;    //value from the operation stored in result for some methods
    private double memory = 0.0;    //used to hold memory value for memory buttons
    String operator = "";       //initialize operator so that no cases are triggered in switch statement

    /**
     * Constructor made to set up all button actionlisteners and logic.
     */
    public Calculator() {

        // Initialize all the number buttons using numberBtnClicked
        zeroBtn.addActionListener(new numberBtnClicked(0, textField));
        oneBtn.addActionListener(new numberBtnClicked(1, textField));
        twoBtn.addActionListener(new numberBtnClicked(2, textField));
        threeBtn.addActionListener(new numberBtnClicked(3, textField));
        fourBtn.addActionListener(new numberBtnClicked(4, textField));
        fiveBtn.addActionListener(new numberBtnClicked(5, textField));
        sixBtn.addActionListener(new numberBtnClicked(6, textField));
        sevenBtn.addActionListener(new numberBtnClicked(7, textField));
        eightBtn.addActionListener(new numberBtnClicked(8, textField));
        nineBtn.addActionListener(new numberBtnClicked(9, textField));

        //actionlisteners for the rest of the buttons on calculator
        /**
         * Memory clear actionListener to clear the memory variable
         */
        mClearBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                memory = 0.0;

            }
        });
        /**
         * Reciprocal actionListener to get reciprocal of num1 when button is pressed
         * Outputs error to textField when trying to take reciprocal of 0
         */
        reciprocalBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(!textField.getText().isEmpty()){       //isEmpty suggested by intelliJ (had it as .equals(""))
                    num1 = Double.parseDouble(textField.getText());      //converts textField to double and stores in num1
                    if(num1 != 0) {     //makes sure the value from textField is not zero
                        result = (1 / num1);
                        if (result == (int) result) {
                            textField.setText(String.valueOf((int) result));
                        } else {
                            textField.setText(String.valueOf(result));  // display double result if not int
                        }
                    } else {
                        textField.setText("ERROR");
                    }
                }
            }
        });
        /**
         * Clear button actionListener to clear the textField and all of the variables used in operations
         */
        clearBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textField.setText("0");
                num1 = 0.0;
                num2 = 0.0;
                result = 0.0;
            }
        });
        /**
         * Memory Recall actionListener made to print the memory variable to textField
         */
        mRecallBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (memory == (int) memory) {
                    textField.setText(String.valueOf((int) memory));
                } else {
                    textField.setText(String.valueOf(memory));
                }
            }
        });
        /**
         * Power actionListener to trigger switch case and sets text to empty when button is pressed
         */
        powerBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(!textField.getText().isEmpty()){
                    num1 = Double.parseDouble(textField.getText());
                    operator = "^";
                    textField.setText("");
                }
            }
        });
        /**
         * Sign actionListener to change the sign of the value in the text field
         * PMsign(plus minus sign) is temp variable used to convert either decimal values or int values from +/-
         */
        signBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(textField.getText().contains(".")) {
                    double PMsign = Double.parseDouble(textField.getText());
                    PMsign *= -1;
                    textField.setText(String.valueOf(PMsign));
                } else {
                    long PMsign = Long.parseLong(textField.getText());
                    PMsign *= -1;
                    textField.setText(String.valueOf(PMsign));
                }
            }
        });
        /**
         * Memory add actionListener used to add variable in memory to value in textField
         */
        mAddBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!textField.getText().isEmpty()) {
                    memory += Double.parseDouble(textField.getText());
                }
            }
        });
        /**
         * Log actionListener used to perform natural log on num1 variable(value in textField)
         * Returns ERROR when doing ln of zero or negatie number
         */
        logBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(!textField.getText().isEmpty()){
                    num1 = Double.parseDouble(textField.getText());
                    if(num1 > 0) {
                        result = Math.log(num1);
                        if (result == (int) result) {
                            textField.setText(String.valueOf((int) result));
                        } else {
                            textField.setText(String.valueOf(result));  // display double result if not int
                        }
                    } else {
                        textField.setText("ERROR");
                    }
                }
            }
        });
        /**
         * Factorial actionListener used to obtain factorial of all values >= 0
         * If input is 0 or 1, factorial will be 1
         * Cannot handle factorials of negative numbers or fractions/decimal values
         * Can only do factorial on values between 0 and 11
         */
        factorialBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(!textField.getText().isEmpty()){
                    num1 = Double.parseDouble(textField.getText());
                    result = 1;
                    if(num1 < 0 || num1 % 1 != 0){
                        textField.setText("ERROR");
                        return;
                    }
                    if(num1 == 0 || num1 == 1){
                        textField.setText("1");
                        return;
                    }
                    if(num1 > 1 && num1 <= 10) {
                        for (double i = 1; i <= num1; i++) {
                            result *= i;
                        }
                            textField.setText(String.valueOf((int) result));
                            return;
                    } else {
                        textField.setText("ERROR");
                    }
                }
            }
        });
        /**
         * Decimal actionListener used to place decimal place in textField
         */
        digitBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(!textField.getText().contains(".")) {
                    textField.setText(textField.getText() + digitBtn.getText());
                }
            }
        });
        /**
         * Memory subtract actionListener used to subtract the value of memory from the value in textField
         */
        mSubBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(!textField.getText().isEmpty()){
                    memory -= Double.parseDouble(textField.getText());
                }
            }
        });
        /**
         * Square root actionListener used to find the squareroot of any positive value
         * Will return error if value is negative
         * Utilizes math library to find the squareroot
         */
        sqrBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                num1 = Double.parseDouble(textField.getText());
                operator = "√";
                if(num1 >= 0){
                    result = Math.sqrt(num1);
                    //checks if result as an integer is equal to result as a double, if it is, output as a integer
                    if (result == (int) result) {
                        textField.setText(String.valueOf((int) result));
                    } else {
                        textField.setText(String.valueOf(result));  // display double result if not int
                    }
                } else {
                    textField.setText("ERROR");
                }
            }
        });
        /**
         * Divide actionListener used to trigger division case in equal method's switch case
         * Sets the textField to empty when triggered
         */
        divideBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(!textField.getText().isEmpty()) {
                    num1 = Double.parseDouble(textField.getText());
                    operator = "/";
                    textField.setText("");
                }
            }
        });
        /**
         * Multiply actionListener used to trigger multiply case in equal method
         * Sets textField to empty after pressed
         */
        mulBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(!textField.getText().isEmpty()) {
                    num1 = Double.parseDouble(textField.getText());
                    operator = "*";
                    textField.setText("");
                }
            }
        });
        /**
         * Minus actionListener used to trigger minus case in equals method
         * Sets textFIeld to empty when clicked
         */
        minusBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(!textField.getText().isEmpty()) {
                    num1 = Double.parseDouble(textField.getText());
                    operator = "-";
                    textField.setText("");
                }
            }
        });
        /**
         * Add actionListener used to trigger add case in equal method
         * Sets fieldText to empty when triggered
         */
        addBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(!textField.getText().isEmpty()) {
                    num1 = Double.parseDouble(textField.getText());
                    operator = "+";
                    textField.setText("");
                }
            }
        });
        /**
         * Equal actionListener used to perform all operations
         * Handles error cases when dividing by zero and
         * putting a negative base to a fraction power
         * Converts all results to integers if they meet requirements
         * Utilizes boolean temporary variable to determine if ERROR should be outputted after breaking from switch case
         */
        equalBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                boolean error = false;
                if (!textField.getText().isEmpty()) {  // Ensure there's a second number to operate on
                    num2 = Double.parseDouble(textField.getText());
                    switch (operator) {
                        case "+":
                            result = num1 + num2;
                            break;
                        case "-":
                            result = num1 - num2;
                            break;
                        case "*":
                            result = num1 * num2;
                            break;
                        case "/":
                            // checks division by zero
                            if(num2 == 0){
                                error = true;
                            } else {
                                result = num1 / num2;
                            }
                            break;
                        case "^":       //powerBtn case
                            if(num1 < 0 && num2 % 1 != 0) {
                                error = true;
                            } else {
                                result = Math.pow(num1, num2);                            }
                            break;
                        default:
                            break;
                    }
                    //checks if result as an integer is equal to result as a double, if it is, output as a integer
                    if(error) {
                        textField.setText("ERROR");
                    } else if (result == (int) result) {
                        textField.setText(String.valueOf((int) result));
                    } else {
                        textField.setText(String.valueOf(result));  // Display the result
                    }
                }
            }
        });
    }

    /**
     * Test method to simulate clicks
     * @param button Label to know which button to simulate for
     */
    public void test( String button){
        switch (button){
            case "0": zeroBtn.doClick();break;
            case "1": oneBtn.doClick();break;
            case "2": twoBtn.doClick();break;
            case "3": threeBtn.doClick();break;
            case "4": fourBtn.doClick();break;
            case "5": fiveBtn.doClick();break;
            case "6": sixBtn.doClick();break;
            case "7": sevenBtn.doClick();break;
            case "8": eightBtn.doClick();break;
            case "9": nineBtn.doClick();break;
            case "x!": factorialBtn.doClick();break;
            case "-/+": signBtn.doClick();break;
            case "AC": clearBtn.doClick();break;
            case "1/x": reciprocalBtn.doClick();break;
            case "sqr": sqrBtn.doClick();break;
            case "log": logBtn.doClick();break;
            case ".": digitBtn.doClick();break;
            case "+": addBtn.doClick();break;
            case "-": minusBtn.doClick();break;
            case "*": mulBtn.doClick();break;
            case "/": divideBtn.doClick();break;
            case "**": powerBtn.doClick();break;
            case "=": equalBtn.doClick();break;
            case "MR": mRecallBtn.doClick();break;
            case "MC": mClearBtn.doClick();break;
            case "M-": mSubBtn.doClick();break;
            case "M+": mAddBtn.doClick();break;
            case "txt": System.out.println("The result is: " + textField.getText());break;
            default:System.out.println("invalid input");break;
        }
    }

    /**
     * Main function generated to connect Calculator.java with Swing Gui
     * @param args
     */
    public static void main(String[] args) {
        JFrame frame = new JFrame("Calculator");
        frame.setContentPane(new Calculator().calcPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);

    }

}
