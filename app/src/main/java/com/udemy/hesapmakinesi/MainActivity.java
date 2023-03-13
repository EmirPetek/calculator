package com.udemy.hesapmakinesi;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private Button button_0, button_1, button_2, button_3, button_4, button_5, button_6, button_7,button_8,button_9;
    private Button button_equal, button_plus, button_minus, button_divide, button_multiplication, button_square, button_sqrt, button_C, button_point;
    private EditText editTextField, editTextFieldResult;
    public double answer = 0;
    public int minusCheck = 0, operationCheck = 0;
    List<String> numberList = new LinkedList<>();
    List<String> operatorList = new LinkedList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button_0 = findViewById(R.id.button_0);
        button_1 = findViewById(R.id.button_1);
        button_2 = findViewById(R.id.button_2);
        button_3 = findViewById(R.id.button_3);
        button_4 = findViewById(R.id.button_4);
        button_5 = findViewById(R.id.button_5);
        button_6 = findViewById(R.id.button_6);
        button_7 = findViewById(R.id.button_7);
        button_8 = findViewById(R.id.button_8);
        button_9 = findViewById(R.id.button_9);

        button_equal = findViewById(R.id.button_equal);
        button_plus = findViewById(R.id.button_plus);
        button_minus = findViewById(R.id.button_minus);
        button_divide = findViewById(R.id.button_divide);
        button_multiplication = findViewById(R.id.button_multiplication);
        button_square = findViewById(R.id.button_square);
        button_sqrt = findViewById(R.id.button_sqrt);
        button_C = findViewById(R.id.button_C);
        button_point = findViewById(R.id.button_point);
        editTextField = findViewById(R.id.editTextField);
        editTextFieldResult = findViewById(R.id.editTextFieldResult);
        editTextField.setInputType(InputType.TYPE_NULL);
        editTextFieldResult.setInputType(InputType.TYPE_NULL);


        button_0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editTextField.append("0");operationCheck++;minusCheck++;
            }
        });
        button_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editTextField.append("1");operationCheck++;minusCheck++;
            }
        });
        button_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editTextField.append("2");operationCheck++;minusCheck++;
            }
        });
        button_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editTextField.append("3");operationCheck++;minusCheck++;
            }
        });
        button_4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editTextField.append("4");operationCheck++;minusCheck++;
            }
        });
        button_5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editTextField.append("5");operationCheck++;minusCheck++;
            }
        });
        button_6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editTextField.append("6");operationCheck++;minusCheck++;
            }
        });
        button_7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editTextField.append("7");operationCheck++;minusCheck++;
            }
        });
        button_8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editTextField.append("8");operationCheck++;minusCheck++;
            }
        });
        button_9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editTextField.append("9");operationCheck++;minusCheck++;
            }
        });
        button_C.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editTextField.setText("");
                editTextFieldResult.setText("");
                numberList.clear();
                operatorList.clear();
                minusCheck = 0;
                operationCheck = 0;
            }
        });
        button_point.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editTextField.append(".");}
        });


        button_plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numberList.add(editTextField.getText().toString());
                operatorList.add("+");
             editTextField.setText("");
            }
        });
        button_minus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    if (minusCheck == 0) {
                        editTextField.append("-");
                        minusCheck++;
                    }
                    if (operationCheck != 0)
                    {
                        numberList.add(editTextField.getText().toString());
                        operatorList.add("-");
                        editTextField.setText("");
                        minusCheck++;
                    }
            }
        });


        button_multiplication.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numberList.add(editTextField.getText().toString());
                operatorList.add("*");
                editTextField.setText("");
            }
        });
        button_divide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numberList.add(editTextField.getText().toString());
                operatorList.add("/");
                editTextField.setText("");
            }
        });
        button_square.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String currentNumber = editTextField.getText().toString();
                double squareNumber = Double.parseDouble(currentNumber) * Double.parseDouble(currentNumber);
                numberList.add(String.valueOf(squareNumber));
                operatorList.add("");
                editTextField.setText("");
            }
        });
        button_sqrt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String currentNumber = editTextField.getText().toString();
                double squareRootNumber = Math.sqrt(Double.parseDouble(currentNumber));
                numberList.add(String.valueOf(squareRootNumber));
                operatorList.add("");
                editTextField.setText("");
            }
        });

        button_equal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numberList.add(editTextField.getText().toString());
                editTextField.setText("");
                int index = 0;
                double answer = Double.parseDouble(numberList.get(0));
                for (int i = 1; i< numberList.size(); i++){
                    String operator = operatorList.get(index);

                    switch (operator) {
                        case "+":
                            answer = answer + Double.parseDouble(numberList.get(i));
                            break;
                        case "-":
                                answer = answer - Double.parseDouble(numberList.get(i));
                            break;
                        case "*":
                            answer = answer * Double.parseDouble(numberList.get(i));
                            break;
                        case "/":
                            if (Double.parseDouble(numberList.get(i)) == 0){
                                Toast.makeText(getApplicationContext(),"Can not be divided by 0",Toast.LENGTH_SHORT).show();
                            }
                            else{
                                answer = answer / Double.parseDouble(numberList.get(i));
                            }
                            break;
                    }
                    index++;
                }
                if(answer - (int)answer == 0){
                    editTextFieldResult.setText(String.valueOf((int)answer));

                }else{
                    editTextFieldResult.setText(String.valueOf(answer));
                }

            }
        });
    }
}

