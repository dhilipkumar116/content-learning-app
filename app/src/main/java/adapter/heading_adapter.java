package adapter;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.cprogram.R;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class heading_adapter extends RecyclerView.Adapter<heading_adapter.MyViewHolder> {


    ArrayList heading = new ArrayList(Arrays.asList(
            "1.basics",
            "2.data types",
            "3.operators",
            "4.inputs and output"
    ));




  String[][] sub_heading ={ { "C1", "C2", "C3", "C4", "C5", "C6"},
          { "C14", "C15", "C16", "C17", "C18"},
          { "C19", "C20", "C21", "C22", "C23","C24"},
          { "C7", "C8", "C9", "C10", "C11","C12","C13"}};


    Context  context;

    public heading_adapter(Context context){
        this.context  = context;

    }

    public class MyViewHolder extends RecyclerView.ViewHolder{

        public TextView heading_txt;
        public RecyclerView subhead_rec;
        public ImageView arrow;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            heading_txt= (TextView)itemView.findViewById(R.id.heading_text);
            subhead_rec = (RecyclerView)itemView.findViewById(R.id.subheading_recyclerView);
            arrow = (ImageView)itemView.findViewById(R.id.arrow_heading);

        }
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.heading_layout,parent,false);
        MyViewHolder viewHolder = new MyViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull final MyViewHolder holder, final int position) {
        holder.heading_txt.setText(heading.get(position).toString());

        holder.heading_txt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (holder.subhead_rec.getVisibility() == View.VISIBLE)
                {
                    holder.subhead_rec.setVisibility(View.GONE);
                    holder.arrow.setRotation(0);
                }
                else
                {
                    holder.subhead_rec.setVisibility(View.VISIBLE);
                    holder.arrow.setRotation(90);
                }
                //Integer.parseInt(Integer.toString(position))
                int adap_pos = position ;
                //initalising sub heading list
                ArrayList<String> subheading_array = new ArrayList<>();
                for(int i=0; i<sub_heading[adap_pos].length;i++){
                    subheading_array.add(sub_heading[adap_pos][i]);
                }

                //initialising sub heading adapter
                subheading_adapter subheading_adapter = new subheading_adapter(subheading_array, context );

                LinearLayoutManager layoutManager = new LinearLayoutManager(context);
                holder.subhead_rec.addItemDecoration(new DividerItemDecoration(holder.subhead_rec.getContext(), DividerItemDecoration.VERTICAL));
                holder.subhead_rec.setLayoutManager(layoutManager);
                holder.subhead_rec.setAdapter(subheading_adapter);

            }
        });



    }


    @Override
    public int getItemCount() {
        return heading.size();
    }


}
