package com.example.bbovino;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import databaseFire.Register;

public class RegisterActivity extends AppCompatActivity {

    // creating variables for our edit text
    private EditText userRegister, emailRegister, passwordRegister, confirmPasswordRegister;

    // creating variable for button
    private Button registerNew;

    // creating a strings for storing
    // our values from edittext fields.
    private String userReg, emailReg, passwordReg, confirmPasswordReg;

    // creating a variable
    // for firebasefirestore.
    private FirebaseFirestore db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {



        super.onCreate(savedInstanceState);
        setContentView(R.layout.register);

        // getting our instance
        // from Firebase Firestore.
        db = FirebaseFirestore.getInstance();

        // initializing our edittext and buttons
        //courseNameEdt = findViewById(R.id.idEdtCourseName);
        //courseDescriptionEdt = findViewById(R.id.idEdtCourseDescription);
        //courseDurationEdt = findViewById(R.id.idEdtCourseDuration);
        //submitCourseBtn = findViewById(R.id.idBtnSubmitCourse);
        userRegister = findViewById(R.id.editTextUserRegister);
        emailRegister = findViewById(R.id.editTextEmailRegister);
        passwordRegister = findViewById(R.id.editTextTextPasswordRegister);
        confirmPasswordRegister = findViewById(R.id.editTextTextConfirmPasswordRegister);
        registerNew = findViewById(R.id.buttonRegisterNew);

        // adding on click listener for button
        registerNew.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // getting data from edittext fields.
                //courseName = courseNameEdt.getText().toString();
                //courseDescription = courseDescriptionEdt.getText().toString();
                //courseDuration = courseDurationEdt.getText().toString();

                userReg = userRegister.getText().toString();
                emailReg = emailRegister.getText().toString();
                passwordReg = passwordRegister.getText().toString();
                confirmPasswordReg = confirmPasswordRegister.getText().toString();

                // validating the text fields if empty or not.
                if (TextUtils.isEmpty(userReg)) {
                    userRegister.setError("Ingrese un usuario valido");
                    Toast.makeText(RegisterActivity.this, "ERROR \n" , Toast.LENGTH_SHORT).show();
                } else if (TextUtils.isEmpty(emailReg)) {
                    emailRegister.setError("Ingrese un correo valido");
                    Toast.makeText(RegisterActivity.this, "ERROR \n", Toast.LENGTH_SHORT).show();
                } else if (TextUtils.isEmpty(passwordReg)) {
                    passwordRegister.setError("Ingrese un contraseña valida");
                    Toast.makeText(RegisterActivity.this, "ERROR \n", Toast.LENGTH_SHORT).show();
                }else if (TextUtils.isEmpty(confirmPasswordReg)) {
                    confirmPasswordRegister.setError("Ingrese un contraseña valida");
                    Toast.makeText(RegisterActivity.this, "ERROR \n", Toast.LENGTH_SHORT).show();
                } else {
                    // calling method to add data to Firebase Firestore.
                    addDataToFirestore(userReg, emailReg, passwordReg);
                }
            }
        });
    }

    private void addDataToFirestore(String userReg, String emailReg, String passwordReg) {

        // creating a collection reference
        // for our Firebase Firetore database.
        CollectionReference dbCourses = db.collection("usuario");

        // adding our data to our courses object class.
        Register nuevoUsuario = new Register(userReg, emailReg, passwordReg);

        // below method is use to add data to Firebase Firestore.
        dbCourses.add(nuevoUsuario).addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
            @Override
            public void onSuccess(DocumentReference documentReference) {
                // after the data addition is successful
                // we are displaying a success toast message.
                Toast.makeText(RegisterActivity.this, "Your Course has been added to Firebase Firestore", Toast.LENGTH_SHORT).show();
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                // this method is called when the data addition process is failed.
                // displaying a toast message when data addition is failed.
                Toast.makeText(RegisterActivity.this, "Fail to add course \n" + e, Toast.LENGTH_SHORT).show();
            }
        });
    }
}
