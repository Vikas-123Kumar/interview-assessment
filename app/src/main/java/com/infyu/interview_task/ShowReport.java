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

import org.json.JSONArray;
import org.json.JSONException;

import java.util.ArrayList;

// showing the assessment report after complete the assessment
public class ShowReport extends AppCompatActivity {
    RecyclerView recyclerView;
    SharedPreferences sharedPreferences;
    ArrayList<ReportBean> arrayList;
    Context context;
    TextView reportBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_report);
        context = this;
        init();
        sharedPreferences = getSharedPreferences("result", 0);
        arrayList = new ArrayList<>();
        try {
            JSONArray jsonArray = new JSONArray(sharedPreferences.getString("report", ""));
            for (int i = 0; i < jsonArray.length(); i++) {
                ReportBean reportBean = new ReportBean();
                reportBean.setOption(jsonArray.get(i).toString());
                int questionNumber = i;
                questionNumber++;
                reportBean.setQuestion(questionNumber);
                arrayList.add(reportBean);
            }
            ReportAdapter reportAdapter = new ReportAdapter(context, arrayList);
            recyclerView.setLayoutManager(new LinearLayoutManager(context));
            recyclerView.setAdapter(reportAdapter);
        } catch (JSONException e) {
            throw new RuntimeException(e);
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