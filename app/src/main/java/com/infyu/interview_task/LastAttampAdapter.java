package com.infyu.interview_task;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class LastAttampAdapter extends RecyclerView.Adapter<LastAttampAdapter.MyViewholder> {
    ArrayList<ReportBean> arrayList;
    ArrayList<ReportBean> arrayList2;

    Context context;

    public LastAttampAdapter(Context context, ArrayList<ReportBean> arrayList, ArrayList<ReportBean> arrayList2) {
        this.context = context;
        this.arrayList = arrayList;
        this.arrayList2 = arrayList2;

    }

    @NonNull
    @Override
    public MyViewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.last_aatampt_view, parent, false);
        return new MyViewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewholder holder, int position) {
        holder.subjectName.setText("Attempt: " + (position+1));
        holder.correctAnswer.setText("Correct Answer: " + arrayList.get(position).getCorrectAnswer());
        holder.wrongAnswer.setText("Wrong Answer: " + arrayList2.get(position).getWrongAnswer());
        int correct = arrayList.get(position).getCorrectAnswer();
        int wrong = arrayList2.get(position).getWrongAnswer();
        double percentage = ((double) correct / (correct + wrong)) * 100;
        holder.percentage.setText("Percentage: " + percentage + "%");
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
