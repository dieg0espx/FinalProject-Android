package com.example.morecipes;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SearchView;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.firestore.FirestoreRecyclerAdapter;
import com.firebase.ui.firestore.FirestoreRecyclerOptions;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.Query;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

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
    }

    public void btn_go2local(View view) {
        Intent intent = new Intent (MostrarDatosActivity.this, MainActivity.class );
        startActivity(intent);
    }
}
