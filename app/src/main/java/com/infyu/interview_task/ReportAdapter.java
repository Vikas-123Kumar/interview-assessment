package com.infyu.interview_task;

import android.content.Context;
import android.content.Intent;
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
        holder.subjectName.setText("Subject: " + arrayList.get(position).getSubjectname());
        holder.correctAnswer.setText("Correct Answer: " + arrayList.get(position).getCorrectAnswer());
        holder.wrongAnswer.setText("Wrong Answer: " + arrayList.get(position).getWrongAnswer());
        holder.percentage.setText("Percentage: " + arrayList.get(position).getPercentage() + "%");
        holder.subjectName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                context.startActivity(new Intent(context, LastAttamptRecord.class).putExtra("subjectName", arrayList.get(position).getSubjectname()));
            }
        });
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public class MyViewholder extends RecyclerView.ViewHolder {
        TextView subjectName, correctAnswer, wrongAnswer, percentage;

        public MyViewholder(@NonNull View itemView) {
            super(itemView);
            subjectName = itemView.findViewById(R.id.subject_name);
            correctAnswer = itemView.findViewById(R.id.correct_answer);
            wrongAnswer = itemView.findViewById(R.id.wrong_answer);
            percentage = itemView.findViewById(R.id.percentage);
        }
    }
}
