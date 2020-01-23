package com.example.morecipes.morecipes.Online;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.morecipes.R;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    EditText mEditTextDishname;
    EditText mEditTextIngredients;
    EditText mEditTextSteps;

    Button mButtonCrearDatos;
    Button mButtonMostrarDatos;

    FirebaseFirestore mFirestore;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mFirestore = FirebaseFirestore.getInstance();

        mEditTextDishname = findViewById(R.id.editTextDishname);
        mEditTextIngredients = findViewById(R.id.editTextIngredients);
        mEditTextSteps = findViewById(R.id.editTextSteps);

        mButtonCrearDatos = findViewById(R.id.btnCrerDatos);
        mButtonMostrarDatos = findViewById(R.id.btnMostrarDatos);

        mButtonMostrarDatos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, MostrarDatosActivity.class));
                overridePendingTransition(R.anim.fast_animation, R.anim.fast_animation);
            }
        });

        mButtonCrearDatos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                crearDatos();
            }
        });
    }

    private void crearDatos(){
        String dishname = mEditTextDishname.getText().toString();
        String ingredients = mEditTextIngredients.getText().toString();
        String steps = mEditTextSteps.getText().toString();

        Map<String, Object> map = new HashMap<>();
        map.put("dishname",dishname);
        map.put("ingredients",ingredients);
        map.put("steps",steps);


        mFirestore.collection("Articulos").add(map).addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
            @Override
            public void onSuccess(DocumentReference documentReference) {
                Toast.makeText(MainActivity.this, "Correct!!", Toast.LENGTH_SHORT).show();
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(MainActivity.this, "Something Wrong!!", Toast.LENGTH_SHORT).show();

            }
        });

        Intent intent = new Intent(MainActivity.this,MostrarDatosActivity.class);
        startActivity(intent);
        overridePendingTransition(R.anim.fast_animation, R.anim.fast_animation);
    }


}
