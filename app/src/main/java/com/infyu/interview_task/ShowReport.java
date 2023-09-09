package com.infyu.interview_task;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONArray;

import java.util.ArrayList;

// showing the assessment report after complete the assessment
public class ShowReport extends AppCompatActivity {
    RecyclerView recyclerView;
    SharedPreferences englishSharedPreferences, mathSharedPreference, evsPreference;
    ArrayList<ReportBean> arrayList;
    Context context;
    TextView reportBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_report);
        context = this;
        init();
        try {
            englishSharedPreferences = getSharedPreferences("EnglishResult", 0);
            mathSharedPreference = getSharedPreferences("mathResult", 0);
            evsPreference = getSharedPreferences("evsResult", 0);
            arrayList = new ArrayList<>();
            if (englishSharedPreferences != null) {
                ReportBean reportBean = new ReportBean();
                reportBean.setSubjectname("English Grammar");
                int correct = englishSharedPreferences.getInt("correct", 0);
                int wrong = englishSharedPreferences.getInt("wrong", 0);
                reportBean.setCorrectAnswer(correct);
                reportBean.setWrongAnswer(wrong);
                double percentage = ((double) correct / (correct + wrong)) * 100;
                reportBean.setPercentage(percentage);
                if (correct + wrong != 0) {
                    arrayList.add(reportBean);
                }
            }
            if (mathSharedPreference != null) {
                ReportBean reportBean = new ReportBean();
                reportBean.setSubjectname("Math");
                int correct = mathSharedPreference.getInt("correct", 0);
                int wrong = mathSharedPreference.getInt("wrong", 0);
                reportBean.setCorrectAnswer(correct);
                reportBean.setWrongAnswer(wrong);
                double percentage = ((double) correct / (correct + wrong)) * 100;
                Log.e("percentage", percentage + "");
                reportBean.setPercentage(percentage);
                reportBean.setPercentage(percentage);
                if (correct + wrong != 0) {
                    arrayList.add(reportBean);
                }
            }
            if (evsPreference != null) {
                ReportBean reportBean = new ReportBean();
                reportBean.setSubjectname("EVS");
                int correct = evsPreference.getInt("correct", 0);
                int wrong = evsPreference.getInt("wrong", 0);
                reportBean.setCorrectAnswer(correct);
                reportBean.setWrongAnswer(wrong);
                double percentage = ((double) correct / (correct + wrong)) * 100;
                reportBean.setPercentage(percentage);
                if (correct + wrong != 0) {
                    arrayList.add(reportBean);
                }
            }
            ReportAdapter reportAdapter = new ReportAdapter(context, arrayList);
            recyclerView.setLayoutManager(new LinearLayoutManager(context));
            recyclerView.setAdapter(reportAdapter);
        } catch (Exception e) {
            Toast.makeText(getApplicationContext(), "No report found", Toast.LENGTH_SHORT).show();
            e.printStackTrace();
        }
    }

    public void init() {
        recyclerView = findViewById(R.id.report_recycler);
        reportBack = findViewById(R.id.report);
        reportBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

}