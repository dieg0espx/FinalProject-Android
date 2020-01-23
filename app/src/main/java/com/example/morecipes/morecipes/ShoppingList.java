package com.example.morecipes.morecipes;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import com.example.morecipes.R;
import com.example.morecipes.morecipes.Local.ReadDataActivity;
import com.example.morecipes.morecipes.Online.MainActivity;
import com.example.morecipes.morecipes.Online.MostrarDatosActivity;

public class ShoppingList extends AppCompatActivity {

    EditText etDato;
    Button btnGuardar;
    ImageButton btn_delete;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shopping_list);


        final Context context = this;
        SharedPreferences sharprefs = getSharedPreferences("ArchivoSP", context.MODE_PRIVATE);
        final SharedPreferences sharpref = getPreferences(context.MODE_PRIVATE);

        etDato = (EditText)findViewById(R.id.etDato);
        btnGuardar = (Button)findViewById(R.id.btnGuardar);
        btn_delete = (ImageButton)findViewById(R.id.btn_delete);

        String valor = sharpref.getString("MiDato", "");
        etDato.setText(valor);

        btnGuardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences.Editor editor = sharpref.edit();
                editor.putString("MiDato", etDato.getText().toString());
                editor.commit();
                Toast.makeText(ShoppingList.this, "List Saved", Toast.LENGTH_SHORT).show();


            }
        });

        btn_delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                etDato.setText("");
                SharedPreferences.Editor editor = sharpref.edit();
                editor.putString("MiDato", etDato.getText().toString());
                editor.commit();
                Toast.makeText(ShoppingList.this, "List Deleted", Toast.LENGTH_SHORT).show();

            }
        });
    }

    public void btn_go2list(View view) {
        Intent intent = new Intent (ShoppingList.this, ShoppingList.class );
        startActivity(intent);
        overridePendingTransition(R.anim.fast_animation, R.anim.fast_animation);
    }

    public void btn_go2Local(View view) {
        Intent intent = new Intent (ShoppingList.this, ReadDataActivity.class );
        startActivity(intent);
        overridePendingTransition(R.anim.fast_animation, R.anim.fast_animation);
    }

    public void btn_go2Online(View view) {
        Intent intent = new Intent (ShoppingList.this, MostrarDatosActivity.class );
        startActivity(intent);
        overridePendingTransition(R.anim.fast_animation, R.anim.fast_animation);
    }
}
