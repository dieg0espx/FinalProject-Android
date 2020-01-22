package com.example.morecipes.morecipes.Local;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.morecipes.R;

public class AddDataActivity extends AppCompatActivity {

    EditText etid,etname,etemail,etcity;
    private Button btn_save;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_data);


        //etid=(EditText)findViewById(R.id.editid);
        etname=(EditText)findViewById(R.id.editname);
        etemail=(EditText)findViewById(R.id.editemail);
        etcity=(EditText)findViewById(R.id.editcity);
        btn_save=(Button)findViewById(R.id.btn_add);


        btn_save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name=etname.getText().toString();
                String email=etemail.getText().toString();
                String city=etcity.getText().toString();
                MyDatalist myDataList=new MyDatalist();
                myDataList.setName(name);
                myDataList.setEmail(email);
                myDataList.setCity(city);


                ReadDataActivity.myDatabase.myDao().addData(myDataList);
                Toast.makeText(getApplicationContext(),"Data Save",Toast.LENGTH_LONG).show();
                Intent intent = new Intent(AddDataActivity.this, ReadDataActivity.class);
                startActivity(intent);

            }
        });


    }

    public void go2List(View view) {
        Intent intent = new Intent(AddDataActivity.this, ReadDataActivity.class);
        startActivity(intent);
    }
}

