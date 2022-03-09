import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class Controller {
    //use to figuring out what operator the user want
    enum whatOperator {
        ADDITION, SUBSTRACTION, MULTIPLY, DIVISION, MODULO
    }
    private whatOperator inputOperator = null;

    //use to figuring out whether using want decimal number
    private int fractionCounter = 0;

    //use Double wrapper class and set to null
    // (operant1) operator (operant2) = result
    private Double operant1 = null;
    private Double operant2 = null;
    private Double result = null;
    
    @FXML
    private Label resultText;

    @FXML
    void multiplyWithMinusOne(ActionEvent event) {
        if(inputOperator == null) {
            operant1 *= -1;
            resultText.setText(operant1.toString());
        }
        if(inputOperator != null) {
            operant2 *= -1;
            resultText.setText(operant2.toString());
        }
    }

    @FXML
    void AC(ActionEvent event) {
        //reset everything to null/false
        operant1 = null;
        operant2 = null;
        result = null;
        inputOperator = null;
        fractionCounter = 0;
        resultText.setText("0");
    }
    @FXML
    void plus(ActionEvent event) {
        //set addtion operator, if the user have already inputted the first operant 
        if(operant1 != null) {
            inputOperator = whatOperator.ADDITION;
            fractionCounter = 0;
        }
    }
    @FXML
    void minus(ActionEvent event) {
        //set minus operator, if the user have already inputted the first operant 
        if(operant1 != null) {
            inputOperator = whatOperator.SUBSTRACTION;
            fractionCounter = 0;
        }
    }

    @FXML
    void modulo(ActionEvent event) {
        //set modulo operator, if the user have already inputted the first operant 
        if(operant1 != null) {
            inputOperator = whatOperator.MODULO;
            fractionCounter = 0;
        }
    }

    @FXML
    void multiply(ActionEvent event) {
        //set multiply operator, if the user have already inputted the first operant 
        if(operant1 != null) {
            inputOperator = whatOperator.MULTIPLY;
            fractionCounter = 0;
        }
    }
    @FXML
    void divide(ActionEvent event) {
        //set divide operator, if the user have already inputted the first operant 
        if(operant1 != null) {
            inputOperator = whatOperator.DIVISION;
            fractionCounter = 0;
        }
    }

    @FXML
    void dot(ActionEvent event) {
        //when user clicked dot, set to 1
        if (fractionCounter == 0) {
            fractionCounter = 1;
        }
    }

    @FXML
    void equal(ActionEvent event) {
        //Double TempResult = Double.parseDouble(TempText);
        if(operant1 != null && operant2 != null && inputOperator != null) {
            switch(inputOperator) {
                case SUBSTRACTION:
                    result = operant1 - operant2;
                    break;
                case ADDITION:
                    result = operant1 + operant2;
                    break;      
                case MULTIPLY:
                    result = operant1 * operant2;
                    break;
                case DIVISION:
                    result = operant1 / operant2;
                    break;
                case MODULO:
                    result = operant1 % operant2;
                    break;
            }
        }
        resultText.setText(result.toString());

        fractionCounter = 0;
        operant1 = result;
        operant2 = null;
        inputOperator = null;
        result = null;
    }

    @FXML
    //For zero, we only multiply with 10 when user click
    //Ex: 1 ===> 10
    //    10===> 100
    void zero(ActionEvent event) {
        //when user is on the first operant
        if(inputOperator == null && operant1 != null && fractionCounter == 0) {
            operant1 *= 10;
            resultText.setText(operant1.toString());
        }
        //when user is on the second operant
        else if(inputOperator != null && operant2 != null && fractionCounter == 0) {
            operant2 *= 10; 
            resultText.setText(operant2.toString());
        }

        
    }
    /************Logic for inputting number:
    **  if inputOperator==null, user is working with operant1, otherwise user is working with operant2
    **  then we check if the operant is have number or not. If it does not have number yet, just add(Ex: null --> 1). Else, add the number at the end.(Ex: 1 --> 11)
    **  at the same, check if user have click dot (.), then we add decimal.(ex: 1 ---> 1.3 / 1.3 ---> 1.33)
     */
    @FXML
    void one(ActionEvent event) { 
        if(inputOperator == null) {
            if(operant1 == null) {
                if(fractionCounter == 1) {
                    operant1 = 0.1;
        
                    fractionCounter +=1;
                }
                else {
                    operant1 = (double)1;
                }
            }
            else {
                if(fractionCounter >=1) {
                    operant1 = operant1 + (Math.pow(0.1, fractionCounter) * 1);

                    fractionCounter++;
                }
                else {
                    operant1 = (operant1*10) +1;
                }

            }
            resultText.setText(operant1.toString());
        }
        else {
            if(operant2 == null) {
                if(fractionCounter == 1) {
                    operant2 = 0.1;
                    fractionCounter++;
                }
                else {
                    operant2 = (double)1;
                }
            }
            else {
                if(fractionCounter>=1) {
                    operant2 = operant2 + (Math.pow(0.1, fractionCounter) * 1);

                    fractionCounter++;
                }
                else {
                    operant2 = (operant2*10) +1;
                }

            }
            resultText.setText(operant2.toString());
        }
    }   
    
    @FXML
    void two(ActionEvent event) {
        if(inputOperator == null) {
            if(operant1 == null) {
                if(fractionCounter == 1) {
                    operant1 = 0.2;

                    fractionCounter +=1;
                }
                else {
                    operant1 = (double)2;
                }
            }
            else {
                if(fractionCounter >=1) {
                    operant1 = operant1 + (Math.pow(0.1, fractionCounter) * 2);

                    fractionCounter++;
                }
                else {
                    operant1 = (operant1*10) +2;
                }
            }
            resultText.setText(operant1.toString());
        }
        else {
            if(operant2 == null) {
                if(fractionCounter == 1) {
                    operant2 = 0.2;
                    fractionCounter++;
                }
                else {
                    operant2 = (double)2;
                }
            }
            else {
                if(fractionCounter>=1) {
                    operant2 = operant2 + (Math.pow(0.1, fractionCounter) * 2);

                    fractionCounter++;
                }
                else {
                    operant2 = (operant2*10) +2;
                }

            }
            resultText.setText(operant2.toString());
        }
    }
    @FXML
    void three(ActionEvent event) {
        if(inputOperator == null) {
            if(operant1 == null) {
                if(fractionCounter == 1) {
                    operant1 = 0.3;

                    fractionCounter +=1;
                }
                else {
                    operant1 = (double)3;
                }
            }
            else {
                if(fractionCounter >=1) {
                    operant1 = operant1 + (Math.pow(0.1, fractionCounter) * 3);
                    
                    fractionCounter++;
                }
                else {
                    operant1 = (operant1*10) +3;
                }

            }
            resultText.setText(operant1.toString());
        }
        else {
            if(operant2 == null) {
                if(fractionCounter == 1) {
                    operant2 = 0.3;
                    fractionCounter++;
                }
                else {
                    operant2 = (double)3;
                }
            }
            else {
                if(fractionCounter>=1) {
                    operant2 = operant2 + (Math.pow(0.1, fractionCounter) * 3);

                    fractionCounter++;
                }
                else {
                    operant2 = (operant2*10) +3;
                }

            }
            resultText.setText(operant2.toString());
        }
    }
    @FXML
    void four(ActionEvent event) {
        if(inputOperator == null) {
            if(operant1 == null) {
                if(fractionCounter == 1) {
                    operant1 = 0.4;

                    fractionCounter +=1;
                }
                else {
                    operant1 = (double)4;
                }
            }
            else {
                if(fractionCounter >=1) {
                    operant1 = operant1 + (Math.pow(0.1, fractionCounter) * 4);

                    fractionCounter++;
                }
                else {
                    operant1 = (operant1*10) +4;
                }

            }
            resultText.setText(operant1.toString());
        }
        else {
            if(operant2 == null) {
                if(fractionCounter == 1) {
                    operant2 = 0.4;
                    fractionCounter++;
                }
                else {
                    operant2 = (double)4;
                }
            }
            else {
                if(fractionCounter>=1) {
                    operant2 = operant2 + (Math.pow(0.1, fractionCounter) * 4);

                    fractionCounter++;
                }
                else {
                    operant2 = (operant2*10) +4;
                }

            }
            resultText.setText(operant2.toString());
        }
    }
    @FXML
    void five(ActionEvent event) {
        if(inputOperator == null) {
            if(operant1 == null) {
                if(fractionCounter == 1) {
                    operant1 = 0.5;

                    fractionCounter +=1;
                }
                else {
                    operant1 = (double)5;
                }
            }
            else {
                if(fractionCounter >=1) {
                    operant1 = operant1 + (Math.pow(0.1, fractionCounter) * 5);

                    fractionCounter++;
                }
                else {
                    operant1 = (operant1*10) +5;
                }

            }
            resultText.setText(operant1.toString());
        }
        else {
            if(operant2 == null) {
                if(fractionCounter == 1) {
                    operant2 = 0.5;
                    fractionCounter++;
                }
                else {
                    operant2 = (double)5;
                }
            }
            else {
                if(fractionCounter>=1) {
                    operant2 = operant2 + (Math.pow(0.1, fractionCounter) * 5);

                    fractionCounter++;
                }
                else {
                    operant2 = (operant2*10) +5;
                }
            }
            resultText.setText(operant2.toString());
        }
    }
    @FXML
    void six(ActionEvent event) {
        if(inputOperator == null) {
            if(operant1 == null) {
                if(fractionCounter == 1) {
                    operant1 = 0.6;

                    fractionCounter +=1;
                }
                else {
                    operant1 = (double)6;
                }
            }
            else {
                if(fractionCounter >=1) {
                    operant1 = operant1 + (Math.pow(0.1, fractionCounter) * 6);

                    fractionCounter++;
                }
                else {
                    operant1 = (operant1*10) +6;
                }

            }
            resultText.setText(operant1.toString());
        }
        else {
            if(operant2 == null) {
                if(fractionCounter == 1) {
                    operant2 = 0.6;
                    fractionCounter++;
                }
                else {
                    operant2 = (double)6;
                }
            }
            else {
                if(fractionCounter>=1) {
                    operant2 = operant2 + (Math.pow(0.1, fractionCounter) * 6);

                    fractionCounter++;
                }
                else {
                    operant2 = (operant2*10) +6;
                }
            }
            resultText.setText(operant2.toString());
        }
    }
    @FXML
    void seven(ActionEvent event) {
        if(inputOperator == null) {
            if(operant1 == null) {
                if(fractionCounter == 1) {
                    operant1 = 0.7;

                    fractionCounter +=1;
                }
                else {
                    operant1 = (double)7;
                }
            }
            else {
                if(fractionCounter >=1) {
                    operant1 = operant1 + (Math.pow(0.1, fractionCounter) * 7);

                    fractionCounter++;
                }
                else {
                    operant1 = (operant1*10) +7;
                }

            }
            resultText.setText(operant1.toString());
        }
        else {
            if(operant2 == null) {
                if(fractionCounter == 1) {
                    operant2 = 0.7;
                    fractionCounter++;
                }
                else {
                    operant2 = (double)7;
                }
            }
            else {
                if(fractionCounter>=1) {
                    operant2 = operant2 + (Math.pow(0.1, fractionCounter) * 7);
                    
                    fractionCounter++;
                }
                else {
                    operant2 = (operant2*10) +7;
                }

            }
            resultText.setText(operant2.toString());
        }
    }
    @FXML
    void eight(ActionEvent event) {
        if(inputOperator == null) {
            if(operant1 == null) {
                if(fractionCounter == 1) {
                    operant1 = 0.8;

                    fractionCounter +=1;
                }
                else {
                    operant1 = (double)8;
                }
            }
            else {
                if(fractionCounter >=1) {
                    operant1 = operant1 + (Math.pow(0.1, fractionCounter) * 8);

                    fractionCounter++;
                }
                else {
                    operant1 = (operant1*10) +8;
                }

            }
            resultText.setText(operant1.toString());
        }
        else {
            if(operant2 == null) {
                if(fractionCounter == 1) {
                    operant2 = 0.8;
                    fractionCounter++;
                }
                else {
                    operant2 = (double)8;
                }
            }
            else {
                if(fractionCounter>=1) {
                    operant2 = operant2 + (Math.pow(0.1, fractionCounter) * 8);

                    fractionCounter++;
                }
                else {
                    operant2 = (operant2*10) +8;
                }

            }
            resultText.setText(operant2.toString());
        }
    }
    @FXML
    void nine(ActionEvent event) {
        if(inputOperator == null) {
            if(operant1 == null) {
                if(fractionCounter == 1) {
                    operant1 = 0.9;

                    fractionCounter +=1;
                }
                else {
                    operant1 = (double)9;
                }
            }
            else {
                if(fractionCounter >=1) {
                    operant1 = operant1 + (Math.pow(0.1, fractionCounter) * 9);

                    fractionCounter++;
                }
                else {
                    operant1 = (operant1*10) +9;
                }

            }
            resultText.setText(operant1.toString());
        }
        else {
            if(operant2 == null) {
                if(fractionCounter == 1) {
                    operant2 = 0.9;
                    fractionCounter++;
                }
                else {
                    operant2 = (double)9;
                }
            }
            else {
                if(fractionCounter>=1) {
                    operant2 = operant2 + (Math.pow(0.1, fractionCounter) * 9);

                    fractionCounter++;
                }
                else {
                    operant2 = (operant2*10) +9;
                }

            }
            resultText.setText(operant2.toString());
        }
    }
}
