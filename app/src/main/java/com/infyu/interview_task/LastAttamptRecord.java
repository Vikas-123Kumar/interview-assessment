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
import org.json.JSONException;

import java.util.ArrayList;

public class LastAttamptRecord extends AppCompatActivity {
    RecyclerView recyclerView;
    SharedPreferences englishSharedPreferences, mathSharedPreference, evsPreference;
    ArrayList<ReportBean> arrayList, arrayList2;
    Context context;
    TextView reportBack;
    String subjectName;
    JSONArray lastRecordCorrectAnswer, lastRecordWrongAnswer;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_last_attampt_record);
        subjectName = getIntent().getStringExtra("subjectName");
        context = this;
        init();
        try {
            englishSharedPreferences = getSharedPreferences("EnglishResult", 0);
            mathSharedPreference = getSharedPreferences("mathResult", 0);
            evsPreference = getSharedPreferences("evsResult", 0);
            arrayList = new ArrayList<>();
            arrayList2 = new ArrayList<>();
            if (subjectName.equals("Math")) {
                SharedPreferences sharedPreferences = getSharedPreferences("mathResult", 0);
                lastRecordCorrectAnswer = new JSONArray();
                lastRecordWrongAnswer = new JSONArray();
                if (sharedPreferences != null) {
                    try {
                        JSONArray jsonArray = new JSONArray(sharedPreferences.getString("lastCorrectAnswer", ""));
                        JSONArray jsonArray1 = new JSONArray(sharedPreferences.getString("lastWrongAnswer", ""));
                        for (int i = 0; i < jsonArray.length(); i++) {
                            ReportBean bean = new ReportBean();
                            String correct = jsonArray.get(i).toString();
                            bean.setCorrectAnswer(Integer.parseInt(correct));
                            arrayList.add(bean);
                        }
                        for (int i = 0; i < jsonArray1.length(); i++) {
                            ReportBean bean = new ReportBean();
                            String wrong = jsonArray1.get(i).toString();
                            bean.setWrongAnswer(Integer.parseInt(wrong));
                            arrayList2.add(bean);
                        }
                        Log.e("arraylist", arrayList.get(0).getCorrectAnswer() + "");
                    } catch (JSONException e) {
                        throw new RuntimeException(e);
                    }
                }
            } else if (subjectName.equals("English Grammar")) {
                SharedPreferences sharedPreferences = getSharedPreferences("EnglishResult", 0);
                lastRecordCorrectAnswer = new JSONArray();
                lastRecordWrongAnswer = new JSONArray();
                if (sharedPreferences != null) {
                    try {
                        JSONArray jsonArray = new JSONArray(sharedPreferences.getString("lastCorrectAnswer", ""));
                        JSONArray jsonArray1 = new JSONArray(sharedPreferences.getString("lastWrongAnswer", ""));
                        for (int i = 0; i < jsonArray.length(); i++) {
                            ReportBean bean = new ReportBean();
                            String correct = jsonArray.get(i).toString();
                            bean.setCorrectAnswer(Integer.parseInt(correct));
                            arrayList.add(bean);
                        }
                        for (int i = 0; i < jsonArray1.length(); i++) {
                            ReportBean bean = new ReportBean();
                            String wrong = jsonArray1.get(i).toString();
                            bean.setWrongAnswer(Integer.parseInt(wrong));
                            arrayList2.add(bean);
                        }
                        Log.e("arraylist", arrayList.get(0).getCorrectAnswer() + "");
                    } catch (JSONException e) {
                        throw new RuntimeException(e);
                    }
                }
            } else if (subjectName.equals("EVS")) {
                SharedPreferences sharedPreferences = getSharedPreferences("evsResult", 0);
                lastRecordCorrectAnswer = new JSONArray();
                lastRecordWrongAnswer = new JSONArray();
                if (sharedPreferences != null) {
                    try {
                        JSONArray jsonArray = new JSONArray(sharedPreferences.getString("lastCorrectAnswer", ""));
                        JSONArray jsonArray1 = new JSONArray(sharedPreferences.getString("lastWrongAnswer", ""));
                        for (int i = 0; i < jsonArray.length(); i++) {
                            ReportBean bean = new ReportBean();
                            String correct = jsonArray.get(i).toString();
                            bean.setCorrectAnswer(Integer.parseInt(correct));
                            arrayList.add(bean);
                        }
                        for (int i = 0; i < jsonArray1.length(); i++) {
                            ReportBean bean = new ReportBean();
                            String wrong = jsonArray1.get(i).toString();
                            bean.setWrongAnswer(Integer.parseInt(wrong));
                            arrayList2.add(bean);
                        }
                        Log.e("arraylist", arrayList.get(0).getCorrectAnswer() + "");
                    } catch (JSONException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
            LastAttampAdapter reportAdapter = new LastAttampAdapter(context, arrayList, arrayList2);
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
        reportBack.setText(subjectName+" Assessment Report");
        reportBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
