package com.example.morecipes.morecipes.Online;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.morecipes.R;
import com.example.morecipes.morecipes.Local.ReadDataActivity;
import com.example.morecipes.morecipes.ShoppingList;
import com.firebase.ui.firestore.FirestoreRecyclerOptions;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.Query;

public class MostrarDatosActivity extends AppCompatActivity {
    RecyclerView recyclerViewArticulos;
    ArticulosAdapter mAdapter;
    FirebaseFirestore mFirestore;

    private EditText mSearchField;
    private Button mSearchBtn;
    private DatabaseReference mUserDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mostrar_datos);

        mSearchField = findViewById(R.id.mSearchField);
        mSearchBtn = findViewById(R.id.mSearchBtn);
        recyclerViewArticulos = findViewById(R.id.recyclerViewArticulos);
        recyclerViewArticulos.setLayoutManager(new LinearLayoutManager(this));
        mFirestore = FirebaseFirestore.getInstance();

        Query query = mFirestore.collection("Articulos");
        FirestoreRecyclerOptions<Articulo> firestoreRecyclerOptions = new FirestoreRecyclerOptions.Builder<Articulo>().setQuery(query, Articulo.class).build();

        mAdapter = new ArticulosAdapter(firestoreRecyclerOptions);
        mAdapter.notifyDataSetChanged();
        recyclerViewArticulos.setAdapter(mAdapter);
        mSearchBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Query q = mFirestore.collection("Articulos")
                                    .whereEqualTo("dishname", mSearchField.getText().toString());
                // search case insensitive
                FirestoreRecyclerOptions<Articulo> firestoreRecyclerOptions = new FirestoreRecyclerOptions.Builder<Articulo>().setQuery(q, Articulo.class).build();
                mAdapter.updateOptions(firestoreRecyclerOptions);
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        mAdapter.startListening();
    }

    @Override
    protected void onStop() {
        super.onStop();
        mAdapter.stopListening();
    }

    public void btn_add(View view) {
        Intent intent = new Intent (MostrarDatosActivity.this, MainActivity.class );
        startActivity(intent);
        overridePendingTransition(R.anim.fast_animation, R.anim.fast_animation);
    }

    public void btn_go2local(View view) {
        Intent intent = new Intent (MostrarDatosActivity.this, ReadDataActivity.class );
        startActivity(intent);
        overridePendingTransition(R.anim.fast_animation, R.anim.fast_animation);
    }

    public void btn_go2Online(View view) {
        Intent intent = new Intent (MostrarDatosActivity.this, MostrarDatosActivity.class );
        startActivity(intent);
        overridePendingTransition(R.anim.fast_animation, R.anim.fast_animation);
    }

    public void btn_go2list(View view) {
        Intent intent = new Intent (MostrarDatosActivity.this, ShoppingList.class );
        startActivity(intent);
        overridePendingTransition(R.anim.fast_animation, R.anim.fast_animation);
    }
}
