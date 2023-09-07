package com.infyu.interview_task;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.lang.reflect.Array;
import java.util.ArrayList;

// getting the subject list from the json and showing the list of subject in the recyclerview.
public class SubjectListing extends AppCompatActivity {
    RecyclerView recyclerView;
    String JSONString = "{\n" +
            "  \"practiceTests\": [\n" +
            "    {\n" +
            "      \"ncert_eng_sci_10_01_01_001\": {\n" +
            "        \"A\": {\n" +
            "          \"type\": \"text\",\n" +
            "          \"value\": \"L.P.G. combustion\"\n" +
            "        },\n" +
            "        \"B\": {\n" +
            "          \"type\": \"text\",\n" +
            "          \"value\": \"Vapourization of boiling water\"\n" +
            "        },\n" +
            "        \"C\": {\n" +
            "          \"type\": \"text\",\n" +
            "          \"value\": \"Melting of ice\"\n" +
            "        },\n" +
            "        \"D\": {\n" +
            "          \"type\": \"text\",\n" +
            "          \"value\": \"Dissolving salt in water\"\n" +
            "        },\n" +
            "        \"correct_feedback\": \"L.P.G. Combustion is a chemical process.\",\n" +
            "        \"feedbackImage\": \"\",\n" +
            "        \"incorrect_feedback\": \"L.P.G. Combustion is a chemical process.\",\n" +
            "        \"offlineLink\": \"3_Chemical_Reactions_C10_English_Video_Science.mp4\",\n" +
            "        \"q\": \"Which of the following is not a physical change?\",\n" +
            "        \"questionImage\": \"\",\n" +
            "        \"videoLink\": \"https://vimeo.com/444869578\",\n" +
            "        \"videoLink_diksha\": \"https://ntpproductionall.blob.core.windows.net/ntp-content-production/content/assets/do_313090047192817664193/class-x-science-chapter-1-part-1.mp4\",\n" +
            "        \"videoName\": \"Chemical Reactions \"\n" +
            "      }\n" +
            "    },\n" +
            "    {\n" +
            "      \"ncert_eng_sci_10_01_01_002\": {\n" +
            "        \"A\": {\n" +
            "          \"type\": \"text\",\n" +
            "          \"value\": \"Lime water turns milky\"\n" +
            "        },\n" +
            "        \"B\": {\n" +
            "          \"type\": \"text\",\n" +
            "          \"value\": \"Becomes water vapor\"\n" +
            "        },\n" +
            "        \"C\": {\n" +
            "          \"type\": \"text\",\n" +
            "          \"value\": \"Sodium carbonate is formed\"\n" +
            "        },\n" +
            "        \"D\": {\n" +
            "          \"type\": \"text\",\n" +
            "          \"value\": \"None of these\"\n" +
            "        },\n" +
            "        \"correct_feedback\": \"When CO₂ gas is passed through lime water, the lime water turns milky due to the formation of insoluble calcium carbonate.\",\n" +
            "        \"feedbackImage\": \"\",\n" +
            "        \"incorrect_feedback\": \"When CO₂ gas is passed through lime water, the lime water turns milky due to the formation of insoluble calcium carbonate.\",\n" +
            "        \"offlineLink\": \"3_Chemical_Reactions_C10_English_Video_Science.mp4\",\n" +
            "        \"q\": \"When CO₂ gas is passed through lime water, which of the following happens due to the formation of insoluble calcium carbonate?\",\n" +
            "        \"questionImage\": \"\",\n" +
            "        \"videoLink\": \"https://vimeo.com/444869578\",\n" +
            "        \"videoLink_diksha\": \"https://ntpproductionall.blob.core.windows.net/ntp-content-production/content/assets/do_313090047192817664193/class-x-science-chapter-1-part-1.mp4\",\n" +
            "        \"videoName\": \"Chemical Reactions \"\n" +
            "      }\n" +
            "    },\n" +
            "    {\n" +
            "      \"ncert_eng_sci_10_01_01_003\": {\n" +
            "        \"A\": {\n" +
            "          \"type\": \"text\",\n" +
            "          \"value\": \"Oxygen helps in burning\"\n" +
            "        },\n" +
            "        \"B\": {\n" +
            "          \"type\": \"text\",\n" +
            "          \"value\": \"Oxygen burns with the sound of whispers\"\n" +
            "        },\n" +
            "        \"C\": {\n" +
            "          \"type\": \"text\",\n" +
            "          \"value\": \"Due to the precipitation reaction.\"\n" +
            "        },\n" +
            "        \"D\": {\n" +
            "          \"type\": \"text\",\n" +
            "          \"value\": \"All of these\"\n" +
            "        },\n" +
            "        \"correct_feedback\": \"When we bring a burning matchstick or candle near the jar of oxygen, it starts burning faster because oxygen helps in burning.\",\n" +
            "        \"feedbackImage\": \"\",\n" +
            "        \"incorrect_feedback\": \"When we bring a burning matchstick or candle near the jar of oxygen, it starts burning faster because oxygen helps in burning.\",\n" +
            "        \"offlineLink\": \"3_Chemical_Reactions_C10_English_Video_Science.mp4\",\n" +
            "        \"q\": \"When we bring a burning matchstick or candle near a jar of oxygen, it starts burning faster why?\",\n" +
            "        \"questionImage\": \"\",\n" +
            "        \"videoLink\": \"https://vimeo.com/444869578\",\n" +
            "        \"videoLink_diksha\": \"https://ntpproductionall.blob.core.windows.net/ntp-content-production/content/assets/do_313090047192817664193/class-x-science-chapter-1-part-1.mp4\",\n" +
            "        \"videoName\": \"Chemical Reactions \"\n" +
            "      }\n" +
            "    },\n" +
            "    {\n" +
            "      \"ncert_eng_sci_10_01_01_004\": {\n" +
            "        \"A\": {\n" +
            "          \"type\": \"text\",\n" +
            "          \"value\": \"Chemical reaction\"\n" +
            "        },\n" +
            "        \"B\": {\n" +
            "          \"type\": \"text\",\n" +
            "          \"value\": \"Physical reaction\"\n" +
            "        },\n" +
            "        \"C\": {\n" +
            "          \"type\": \"text\",\n" +
            "          \"value\": \"Metabolism\"\n" +
            "        },\n" +
            "        \"D\": {\n" +
            "          \"type\": \"text\",\n" +
            "          \"value\": \"Precipitation\"\n" +
            "        },\n" +
            "        \"correct_feedback\": \"Rusting of iron is a chemical reaction.\",\n" +
            "        \"feedbackImage\": \"\",\n" +
            "        \"incorrect_feedback\": \"Rusting of iron is a chemical reaction.\",\n" +
            "        \"offlineLink\": \"3_Chemical_Reactions_C10_English_Video_Science.mp4\",\n" +
            "        \"q\": \"What type of reaction is rusting of iron?\",\n" +
            "        \"questionImage\": \"\",\n" +
            "        \"videoLink\": \"https://vimeo.com/444869578\",\n" +
            "        \"videoLink_diksha\": \"https://ntpproductionall.blob.core.windows.net/ntp-content-production/content/assets/do_313090047192817664193/class-x-science-chapter-1-part-1.mp4\",\n" +
            "        \"videoName\": \"Chemical Reactions \"\n" +
            "      }\n" +
            "    },\n" +
            "    {\n" +
            "      \"ncert_eng_sci_10_01_01_005\": {\n" +
            "        \"A\": {\n" +
            "          \"type\": \"text\",\n" +
            "          \"value\": \"2:1\"\n" +
            "        },\n" +
            "        \"B\": {\n" +
            "          \"type\": \"text\",\n" +
            "          \"value\": \"1:1\"\n" +
            "        },\n" +
            "        \"C\": {\n" +
            "          \"type\": \"text\",\n" +
            "          \"value\": \"4:1\"\n" +
            "        },\n" +
            "        \"D\": {\n" +
            "          \"type\": \"text\",\n" +
            "          \"value\": \"1:2\"\n" +
            "        },\n" +
            "        \"correct_feedback\": \"The electrolysis of water is a decomposition reaction. The mole ratio for the release of hydrogen and oxygen will be 2:1.\",\n" +
            "        \"feedbackImage\": \"\",\n" +
            "        \"incorrect_feedback\": \"The electrolysis of water is a decomposition reaction. The mole ratio for the release of hydrogen and oxygen will be 2:1.\",\n" +
            "        \"offlineLink\": \"3_Chemical_Reactions_C10_English_Video_Science.mp4\",\n" +
            "        \"q\": \"The electrolysis of water is a decomposition reaction. What will be the mole ratio in the release of hydrogen and oxygen?\",\n" +
            "        \"questionImage\": \"\",\n" +
            "        \"videoLink\": \"https://vimeo.com/444869578\",\n" +
            "        \"videoLink_diksha\": \"https://ntpproductionall.blob.core.windows.net/ntp-content-production/content/assets/do_313090047192817664193/class-x-science-chapter-1-part-1.mp4\",\n" +
            "        \"videoName\": \"Chemical Reactions \"\n" +
            "      }\n" +
            "    },\n" +
            "    {\n" +
            "      \"ncert_eng_sci_10_01_01_006\": {\n" +
            "        \"A\": {\n" +
            "          \"type\": \"text\",\n" +
            "          \"value\": \"Helium or nitrogen\"\n" +
            "        },\n" +
            "        \"B\": {\n" +
            "          \"type\": \"text\",\n" +
            "          \"value\": \"Carbon dioxide or helium\"\n" +
            "        },\n" +
            "        \"C\": {\n" +
            "          \"type\": \"text\",\n" +
            "          \"value\": \"Nitrogen or oxygen\"\n" +
            "        },\n" +
            "        \"D\": {\n" +
            "          \"type\": \"text\",\n" +
            "          \"value\": \"Carbon dioxide or oxygen\"\n" +
            "        },\n" +
            "        \"correct_feedback\": \"Helium or nitrogen gas can be used to preserve fresh samples of oil for a longer period of time.\",\n" +
            "        \"feedbackImage\": \"\",\n" +
            "        \"incorrect_feedback\": \"Helium or nitrogen gas can be used to preserve fresh samples of oil for a longer period of time.\",\n" +
            "        \"offlineLink\": \"3_Chemical_Reactions_C10_English_Video_Science.mp4\",\n" +
            "        \"q\": \"Which of the following gas can be used to preserve fresh oil samples for a long time?\",\n" +
            "        \"questionImage\": \"\",\n" +
            "        \"videoLink\": \"https://vimeo.com/444869578\",\n" +
            "        \"videoLink_diksha\": \"https://ntpproductionall.blob.core.windows.net/ntp-content-production/content/assets/do_313090047192817664193/class-x-science-chapter-1-part-1.mp4\",\n" +
            "        \"videoName\": \"Chemical Reactions \"\n" +
            "      }\n" +
            "    },\n" +
            "    {\n" +
            "      \"ncert_eng_sci_10_01_01_007\": {\n" +
            "        \"A\": {\n" +
            "          \"type\": \"text\",\n" +
            "          \"value\": \"Heating a copper wire to a high temperature in the presence of air\"\n" +
            "        },\n" +
            "        \"B\": {\n" +
            "          \"type\": \"text\",\n" +
            "          \"value\": \"Putting petrol in the china dish in the open\"\n" +
            "        },\n" +
            "        \"C\": {\n" +
            "          \"type\": \"text\",\n" +
            "          \"value\": \"Liquefaction of air\"\n" +
            "        },\n" +
            "        \"D\": {\n" +
            "          \"type\": \"text\",\n" +
            "          \"value\": \"Storing oxygen gas under high pressure in a gas cylinder\"\n" +
            "        },\n" +
            "        \"correct_feedback\": \"A chemical reaction is the heating of a copper wire to a high temperature in the presence of air.\",\n" +
            "        \"feedbackImage\": \"\",\n" +
            "        \"incorrect_feedback\": \"A chemical reaction is the heating of a copper wire to a high temperature in the presence of air.\",\n" +
            "        \"offlineLink\": \"3_Chemical_Reactions_C10_English_Video_Science.mp4\",\n" +
            "        \"q\": \"Which of the following process is a chemical reaction?\",\n" +
            "        \"questionImage\": \"\",\n" +
            "        \"videoLink\": \"https://vimeo.com/444869578\",\n" +
            "        \"videoLink_diksha\": \"https://ntpproductionall.blob.core.windows.net/ntp-content-production/content/assets/do_313090047192817664193/class-x-science-chapter-1-part-1.mp4\",\n" +
            "        \"videoName\": \"Chemical Reactions \"\n" +
            "      }\n" +
            "    },\n" +
            "    {\n" +
            "      \"ncert_eng_sci_10_01_01_008\": {\n" +
            "        \"A\": {\n" +
            "          \"type\": \"text\",\n" +
            "          \"value\": \"Chemical change\"\n" +
            "        },\n" +
            "        \"B\": {\n" +
            "          \"type\": \"text\",\n" +
            "          \"value\": \"Physical change\"\n" +
            "        },\n" +
            "        \"C\": {\n" +
            "          \"type\": \"text\",\n" +
            "          \"value\": \"Both physical and chemical change\"\n" +
            "        },\n" +
            "        \"D\": {\n" +
            "          \"type\": \"text\",\n" +
            "          \"value\": \"None of these\"\n" +
            "        },\n" +
            "        \"correct_feedback\": \"The formation of curd from milk is a chemical change.\",\n" +
            "        \"feedbackImage\": \"\",\n" +
            "        \"incorrect_feedback\": \"The formation of curd from milk is a chemical change.\",\n" +
            "        \"offlineLink\": \"3_Chemical_Reactions_C10_English_Video_Science.mp4\",\n" +
            "        \"q\": \"What type of change occurs from milk to curd production?\",\n" +
            "        \"questionImage\": \"\",\n" +
            "        \"videoLink\": \"https://vimeo.com/444869578\",\n" +
            "        \"videoLink_diksha\": \"https://ntpproductionall.blob.core.windows.net/ntp-content-production/content/assets/do_313090047192817664193/class-x-science-chapter-1-part-1.mp4\",\n" +
            "        \"videoName\": \"Chemical Reactions \"\n" +
            "      }\n" +
            "    }\n" +
            "  ],\n" +
            "  \"subjects\": {\n" +
            "    \"cbse\": {\n" +
            "      \"english\": [\n" +
            "          {\n" +
            "            \"color\": \"#E67736\",\n" +
            "            \"icon\": \"https://firebasestorage.googleapis.com/v0/b/iprep-7f10a.appspot.com/o/subject_icon%2FEnglish%20Grammar.png?alt=media&token=f75d03d6-0a80-41e0-93dd-1e33d503cea3\",\n" +
            "            \"id\": \"english_grammar\",\n" +
            "            \"name\": \"English Grammar\",\n" +
            "            \"short_name\": \"Grammar\"\n" +
            "          },\n" +
            "          {\n" +
            "            \"color\": \"#2E6AB2\",\n" +
            "            \"icon\": \"https://firebasestorage.googleapis.com/v0/b/iprep-7f10a.appspot.com/o/subject_icon%2Ficon_id%2Fevs.png?alt=media&token=3fad2ad0-4d8d-4bb9-adff-b2f99a97bd7c\",\n" +
            "            \"id\": \"evs\",\n" +
            "            \"name\": \"EVS\",\n" +
            "            \"short_name\": \"EVS\"\n" +
            "          },\n" +
            "          {\n" +
            "            \"color\": \"#166B3F\",\n" +
            "            \"icon\": \"https://firebasestorage.googleapis.com/v0/b/iprep-7f10a.appspot.com/o/subject_icon%2F%E0%A4%97%E0%A4%A3%E0%A4%BF%E0%A4%A4.png?alt=media&token=3eedd4f8-751c-4ed0-8940-5f2b210f09ed\",\n" +
            "            \"id\": \"math\",\n" +
            "            \"name\": \"Math\",\n" +
            "            \"short_name\": \"Math\"\n" +
            "          }\n" +
            "        ]\n" +
            "    }\n" +
            "  }\n" +
            "}";

    ArrayList<SubjectBean> arrayList;
    Context context;
    Button show_report;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_subject_listing);
        arrayList = new ArrayList<>();
        context = this;
        init();
        try {  // subject list with icon and color as well
            JSONObject obj = new JSONObject(JSONString);
            JSONObject subject = obj.optJSONObject("subjects").optJSONObject("cbse");
            JSONArray jsonArray = subject.optJSONArray("english");
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject jsonObject = (JSONObject) jsonArray.get(i);
                SubjectBean subjectBean = new SubjectBean();
                subjectBean.setColor(jsonObject.optString("color"));
                subjectBean.setName(jsonObject.optString("name"));
                subjectBean.setIconUrl(jsonObject.optString("icon"));
                subjectBean.setShortName(jsonObject.optString("short_name"));
                Log.e("icon", jsonObject.optString("icon"));
                arrayList.add(subjectBean);
            }
            SubjectAdapter subjectAdapter = new SubjectAdapter(context, arrayList);
            recyclerView.setLayoutManager(new LinearLayoutManager(context));
            recyclerView.setAdapter(subjectAdapter);
            Log.e("subject", subject + "");
        } catch (JSONException e) {
            e.printStackTrace();
        }

    }

    public void init() {  // initialize the view component
        recyclerView = findViewById(R.id.subject_recyclerview);
        show_report = findViewById(R.id.show_report);
        show_report.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), ShowReport.class));
            }
        });
    }
}