package com.example.assignement3;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText nameField, departmentField, batchField, sectionField, emailField, idField, passwordField;
    private Button validateButton;
    private TextView resultText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Bind the UI elements
        nameField = findViewById(R.id.nameField);
        departmentField = findViewById(R.id.departmentField);
        batchField = findViewById(R.id.batchField);
        sectionField = findViewById(R.id.sectionField);
        emailField = findViewById(R.id.emailField);
        idField = findViewById(R.id.idField);
        passwordField = findViewById(R.id.passwordField);
        validateButton = findViewById(R.id.validateButton);
        resultText = findViewById(R.id.resultText);

        // Set up validation on button click
        validateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (validateForm()) {
                    resultText.setText("All inputs are valid!");
                    resultText.setTextColor(getResources().getColor(android.R.color.holo_green_dark));
                } else {
                    resultText.setText("Some inputs are invalid.");
                    resultText.setTextColor(getResources().getColor(android.R.color.holo_red_dark));
                }
            }
        });
    }

    // Method to validate the form inputs
    private boolean validateForm() {
        boolean valid = true;

        // Validate name (only letters, 2-30 characters)
        String namePattern = "^[a-zA-Z\\s]{2,30}$";
        if (!nameField.getText().toString().matches(namePattern)) {
            nameField.setError("Invalid Name");
            valid = false;
        }

        // Validate department (only letters, 2-30 characters)
        String deptPattern = "^[a-zA-Z\\s]{2,30}$";
        if (!departmentField.getText().toString().matches(deptPattern)) {
            departmentField.setError("Invalid Department");
            valid = false;
        }

        // Validate batch (e.g., 2021)
        String batchPattern = "^[0-60]{4}$";
        if (!batchField.getText().toString().matches(batchPattern)) {
            batchField.setError("Invalid Batch");
            valid = false;
        }

        // Validate section (single character, A-Z)
        String sectionPattern = "^[A-Z]{1}$";
        if (!sectionField.getText().toString().matches(sectionPattern)) {
            sectionField.setError("Invalid Section");
            valid = false;
        }

        // Validate email
        String emailPattern = "^[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+$";
        if (!emailField.getText().toString().matches(emailPattern)) {
            emailField.setError("Invalid Email");
            valid = false;
        }

        // Validate student ID (e.g., 16-digit number)
        String idPattern = "^[0-16]{6}$";
        if (!idField.getText().toString().matches(idPattern)) {
            idField.setError("Invalid Student ID");
            valid = false;
        }

        // Validate password (at least one uppercase letter, one digit, 6-20 characters)
        String passwordPattern = "^(?=.*[A-Z])(?=.*\\d).{6,20}$";
        if (!passwordField.getText().toString().matches(passwordPattern)) {
            passwordField.setError("Invalid Password");
            valid = false;
        }

        return valid;
    }
}
