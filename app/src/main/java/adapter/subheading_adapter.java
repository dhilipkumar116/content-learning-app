package adapter;

import android.content.Context;
import android.content.Intent;
import android.net.IpSecManager;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.cprogram.LoadHtmlActivity;
import com.example.cprogram.R;

import java.util.ArrayList;
import java.util.logging.LogRecord;

public class subheading_adapter extends RecyclerView.Adapter<subheading_adapter.ViewHolder> {


    ArrayList<String> subheading_list ;
    Context context;



    private static final  ArrayList<String> refheading_list = new ArrayList<>();


    public subheading_adapter(ArrayList<String> sublist , Context context )
    {
        this.subheading_list = sublist;
        this.context = context;


    }



    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.subheading_layout,parent,false);
        ViewHolder viewHolder = new ViewHolder(view );
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, final int position) {

        if(refheading_list.contains(subheading_list.get(position)))
        {
            holder.read_or_not.setVisibility(View.VISIBLE);
        }

        holder.subheading_txt.setText(subheading_list.get(position).toString());

        holder.subheading_txt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                 refheading_list.add(subheading_list.get(position));

                Intent intent  = new Intent(context , LoadHtmlActivity.class);
                intent.putExtra("filename" , subheading_list.get(position));
                context.startActivity(intent);

                android.os.Handler handler = new Handler();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        holder.read_or_not.setVisibility(View.VISIBLE);
                    }
                },1000);



            }
        });


    }

    @Override
    public int getItemCount() {
        return subheading_list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        public TextView subheading_txt;
        public ImageView read_or_not;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            subheading_txt = (TextView)itemView.findViewById(R.id.sub_heading_text);
            read_or_not = (ImageView)itemView.findViewById(R.id.read_checked);

        }
    }
}
