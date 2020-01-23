package com.example.morecipes.morecipes.Local;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Room;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.morecipes.R;
import com.example.morecipes.morecipes.Online.MostrarDatosActivity;
import com.example.morecipes.morecipes.ShoppingList;

import java.util.List;


public class ReadDataActivity extends AppCompatActivity {
    public static MyDatabase myDatabase;

    private EditText mSearchField3;
    private Button mSearchBtn;
    private RecyclerView rv;
    public String word= "";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_read_data);
        myDatabase = Room.databaseBuilder(getApplicationContext(), MyDatabase.class,"infodb").allowMainThreadQueries().build();

        rv=(RecyclerView)findViewById(R.id.rec);
        mSearchField3 = (EditText)findViewById(R.id.mSearchField3);
        mSearchBtn = (Button)findViewById(R.id.mSearchBtn);

        rv.setHasFixedSize(true);
        rv.setLayoutManager(new LinearLayoutManager(this));

        getData();

    }

    private void getData() {
        class GetData extends AsyncTask<Void,Void,List<MyDatalist>>{


            @Override
            protected List<MyDatalist> doInBackground(Void... voids) {
                List<MyDatalist>myDataLists= ReadDataActivity.myDatabase.myDao().getMyData(word+"%%");
                return myDataLists;

            }

            @Override
            protected void onPostExecute(List<MyDatalist> myDataList) {
                MyAdapter adapter=new MyAdapter(myDataList);
                rv.setAdapter(adapter);
                super.onPostExecute(myDataList);
            }
        }
        GetData gd=new GetData();
        gd.execute();
    }

    public void btn_search(View view) {
        word = mSearchField3.getText().toString();
        getData();
    }

    public void btn_add(View view) {
        Intent intent = new Intent( ReadDataActivity.this, AddDataActivity.class);
        startActivity(intent);
        overridePendingTransition(R.anim.fast_animation, R.anim.fast_animation);
    }

    public void btn_go2Online(View view) {
        Intent intent = new Intent( ReadDataActivity.this, MostrarDatosActivity.class);
        startActivity(intent);
        overridePendingTransition(R.anim.fast_animation, R.anim.fast_animation);
    }

    public void btn_go2Local(View view) {
        Intent intent = new Intent( ReadDataActivity.this, ReadDataActivity.class);
        startActivity(intent);
        overridePendingTransition(R.anim.fast_animation, R.anim.fast_animation);
    }

    public void btn_go2list(View view) {
        Intent intent = new Intent (ReadDataActivity.this, ShoppingList.class );
        startActivity(intent);
        overridePendingTransition(R.anim.fast_animation, R.anim.fast_animation);
    }
}
