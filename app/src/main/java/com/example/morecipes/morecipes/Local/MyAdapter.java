package com.example.morecipes.morecipes.Local;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.morecipes.R;

import java.util.List;

public class MyAdapter  extends RecyclerView.Adapter<MyAdapter.ViewHolder> {
    List<MyDatalist>myDataLists;

    public MyAdapter(List<MyDatalist> myDataLists) {
        this.myDataLists = myDataLists;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view= LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_data,viewGroup,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        MyDatalist md = myDataLists.get(i);
        //  viewHolder.txtid.setText(md.getId());
        viewHolder.txtname.setText(md.getName());
        viewHolder.txtemail.setText(md.getEmail());
        viewHolder.txtcity.setText(md.getCity());
    }

    @Override
    public int getItemCount() {
        return myDataLists.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        private TextView txtid,txtname,txtemail,txtcity;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            //txtid=(TextView)itemView.findViewById(R.id.txt_id);
            txtname=(TextView)itemView.findViewById(R.id.txt_name);
            txtemail=(TextView)itemView.findViewById(R.id.txt_email);
            txtcity=(TextView)itemView.findViewById(R.id.txt_city);
        }
    }
}
