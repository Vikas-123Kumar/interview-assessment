package com.infyu.interview_task;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class SubjectAdapter extends RecyclerView.Adapter<SubjectAdapter.MyViewholder> {
    ArrayList<SubjectBean> arrayList;
    Context context;

    public SubjectAdapter(Context context, ArrayList<SubjectBean> arrayList) {
        this.context = context;
        this.arrayList = arrayList;
    }

    @NonNull
    @Override
    public MyViewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.subject_view, parent, false);
        return new MyViewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewholder holder, int position) {
        holder.name.setText(arrayList.get(position).getName());
        holder.name.setTextColor(Color.parseColor(arrayList.get(position).getColor()));
        Picasso.with(context).load(arrayList.get(position).getIconUrl()).into(holder.icon);
        holder.linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                context.startActivity(new Intent(context, QuestionActivity.class));
            }
        });
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public class MyViewholder extends RecyclerView.ViewHolder {
        TextView name;
        ImageView icon;
        LinearLayout linearLayout;

        public MyViewholder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.subject_name);
            icon = itemView.findViewById(R.id.subject_icon);
            linearLayout = itemView.findViewById(R.id.subject_layout);
        }
    }
}
