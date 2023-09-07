package com.infyu.interview_task;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;


// assessment report result adapter class to show the data on recycler
public class ReportAdapter extends RecyclerView.Adapter<ReportAdapter.MyViewholder> {
    ArrayList<ReportBean> arrayList;
    Context context;

    public ReportAdapter(Context context, ArrayList<ReportBean> arrayList) {
        this.context = context;
        this.arrayList = arrayList;
    }

    @NonNull
    @Override
    public MyViewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.report_view, parent, false);
        return new MyViewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewholder holder, int position) {
        holder.option.setText(arrayList.get(position).getOption());
        holder.questionNumber.setText(arrayList.get(position).getQuestion() + ". ");
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public class MyViewholder extends RecyclerView.ViewHolder {
        TextView questionNumber, option;

        public MyViewholder(@NonNull View itemView) {
            super(itemView);
            questionNumber = itemView.findViewById(R.id.question_number);
            option = itemView.findViewById(R.id.option);
        }
    }
}
