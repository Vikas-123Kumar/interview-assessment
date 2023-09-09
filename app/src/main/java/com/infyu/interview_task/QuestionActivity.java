package com.infyu.interview_task;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


// all question are showing with their 4 option and checking the condition of all the question.
public class QuestionActivity extends AppCompatActivity {
    String JSONString = "{\n" + "  \"practiceTests\": [\n" + "    {\n" + "      \"ncert_eng_sci_10_01_01_001\": {\n" + "        \"A\": {\n" + "          \"type\": \"text\",\n" + "          \"value\": \"L.P.G. combustion\"\n" + "        },\n" + "        \"B\": {\n" + "          \"type\": \"text\",\n" + "          \"value\": \"Vapourization of boiling water\"\n" + "        },\n" + "        \"C\": {\n" + "          \"type\": \"text\",\n" + "          \"value\": \"Melting of ice\"\n" + "        },\n" + "        \"D\": {\n" + "          \"type\": \"text\",\n" + "          \"value\": \"Dissolving salt in water\"\n" + "        },\n" + "        \"correct_feedback\": \"L.P.G. Combustion is a chemical process.\",\n" + "        \"feedbackImage\": \"\",\n" + "        \"incorrect_feedback\": \"L.P.G. Combustion is a chemical process.\",\n" + "        \"offlineLink\": \"3_Chemical_Reactions_C10_English_Video_Science.mp4\",\n" + "        \"q\": \"Which of the following is not a physical change?\",\n" + "        \"questionImage\": \"\",\n" + "        \"videoLink\": \"https://vimeo.com/444869578\",\n" + "        \"videoLink_diksha\": \"https://ntpproductionall.blob.core.windows.net/ntp-content-production/content/assets/do_313090047192817664193/class-x-science-chapter-1-part-1.mp4\",\n" + "        \"videoName\": \"Chemical Reactions \"\n" + "      }\n" + "    },\n" + "    {\n" + "      \"ncert_eng_sci_10_01_01_002\": {\n" + "        \"A\": {\n" + "          \"type\": \"text\",\n" + "          \"value\": \"Lime water turns milky\"\n" + "        },\n" + "        \"B\": {\n" + "          \"type\": \"text\",\n" + "          \"value\": \"Becomes water vapor\"\n" + "        },\n" + "        \"C\": {\n" + "          \"type\": \"text\",\n" + "          \"value\": \"Sodium carbonate is formed\"\n" + "        },\n" + "        \"D\": {\n" + "          \"type\": \"text\",\n" + "          \"value\": \"None of these\"\n" + "        },\n" + "        \"correct_feedback\": \"When CO₂ gas is passed through lime water, the lime water turns milky due to the formation of insoluble calcium carbonate.\",\n" + "        \"feedbackImage\": \"\",\n" + "        \"incorrect_feedback\": \"When CO₂ gas is passed through lime water, the lime water turns milky due to the formation of insoluble calcium carbonate.\",\n" + "        \"offlineLink\": \"3_Chemical_Reactions_C10_English_Video_Science.mp4\",\n" + "        \"q\": \"When CO₂ gas is passed through lime water, which of the following happens due to the formation of insoluble calcium carbonate?\",\n" + "        \"questionImage\": \"\",\n" + "        \"videoLink\": \"https://vimeo.com/444869578\",\n" + "        \"videoLink_diksha\": \"https://ntpproductionall.blob.core.windows.net/ntp-content-production/content/assets/do_313090047192817664193/class-x-science-chapter-1-part-1.mp4\",\n" + "        \"videoName\": \"Chemical Reactions \"\n" + "      }\n" + "    },\n" + "    {\n" + "      \"ncert_eng_sci_10_01_01_003\": {\n" + "        \"A\": {\n" + "          \"type\": \"text\",\n" + "          \"value\": \"Oxygen helps in burning\"\n" + "        },\n" + "        \"B\": {\n" + "          \"type\": \"text\",\n" + "          \"value\": \"Oxygen burns with the sound of whispers\"\n" + "        },\n" + "        \"C\": {\n" + "          \"type\": \"text\",\n" + "          \"value\": \"Due to the precipitation reaction.\"\n" + "        },\n" + "        \"D\": {\n" + "          \"type\": \"text\",\n" + "          \"value\": \"All of these\"\n" + "        },\n" + "        \"correct_feedback\": \"When we bring a burning matchstick or candle near the jar of oxygen, it starts burning faster because oxygen helps in burning.\",\n" + "        \"feedbackImage\": \"\",\n" + "        \"incorrect_feedback\": \"When we bring a burning matchstick or candle near the jar of oxygen, it starts burning faster because oxygen helps in burning.\",\n" + "        \"offlineLink\": \"3_Chemical_Reactions_C10_English_Video_Science.mp4\",\n" + "        \"q\": \"When we bring a burning matchstick or candle near a jar of oxygen, it starts burning faster why?\",\n" + "        \"questionImage\": \"\",\n" + "        \"videoLink\": \"https://vimeo.com/444869578\",\n" + "        \"videoLink_diksha\": \"https://ntpproductionall.blob.core.windows.net/ntp-content-production/content/assets/do_313090047192817664193/class-x-science-chapter-1-part-1.mp4\",\n" + "        \"videoName\": \"Chemical Reactions \"\n" + "      }\n" + "    },\n" + "    {\n" + "      \"ncert_eng_sci_10_01_01_004\": {\n" + "        \"A\": {\n" + "          \"type\": \"text\",\n" + "          \"value\": \"Chemical reaction\"\n" + "        },\n" + "        \"B\": {\n" + "          \"type\": \"text\",\n" + "          \"value\": \"Physical reaction\"\n" + "        },\n" + "        \"C\": {\n" + "          \"type\": \"text\",\n" + "          \"value\": \"Metabolism\"\n" + "        },\n" + "        \"D\": {\n" + "          \"type\": \"text\",\n" + "          \"value\": \"Precipitation\"\n" + "        },\n" + "        \"correct_feedback\": \"Rusting of iron is a chemical reaction.\",\n" + "        \"feedbackImage\": \"\",\n" + "        \"incorrect_feedback\": \"Rusting of iron is a chemical reaction.\",\n" + "        \"offlineLink\": \"3_Chemical_Reactions_C10_English_Video_Science.mp4\",\n" + "        \"q\": \"What type of reaction is rusting of iron?\",\n" + "        \"questionImage\": \"\",\n" + "        \"videoLink\": \"https://vimeo.com/444869578\",\n" + "        \"videoLink_diksha\": \"https://ntpproductionall.blob.core.windows.net/ntp-content-production/content/assets/do_313090047192817664193/class-x-science-chapter-1-part-1.mp4\",\n" + "        \"videoName\": \"Chemical Reactions \"\n" + "      }\n" + "    },\n" + "    {\n" + "      \"ncert_eng_sci_10_01_01_005\": {\n" + "        \"A\": {\n" + "          \"type\": \"text\",\n" + "          \"value\": \"2:1\"\n" + "        },\n" + "        \"B\": {\n" + "          \"type\": \"text\",\n" + "          \"value\": \"1:1\"\n" + "        },\n" + "        \"C\": {\n" + "          \"type\": \"text\",\n" + "          \"value\": \"4:1\"\n" + "        },\n" + "        \"D\": {\n" + "          \"type\": \"text\",\n" + "          \"value\": \"1:2\"\n" + "        },\n" + "        \"correct_feedback\": \"The electrolysis of water is a decomposition reaction. The mole ratio for the release of hydrogen and oxygen will be 2:1.\",\n" + "        \"feedbackImage\": \"\",\n" + "        \"incorrect_feedback\": \"The electrolysis of water is a decomposition reaction. The mole ratio for the release of hydrogen and oxygen will be 2:1.\",\n" + "        \"offlineLink\": \"3_Chemical_Reactions_C10_English_Video_Science.mp4\",\n" + "        \"q\": \"The electrolysis of water is a decomposition reaction. What will be the mole ratio in the release of hydrogen and oxygen?\",\n" + "        \"questionImage\": \"\",\n" + "        \"videoLink\": \"https://vimeo.com/444869578\",\n" + "        \"videoLink_diksha\": \"https://ntpproductionall.blob.core.windows.net/ntp-content-production/content/assets/do_313090047192817664193/class-x-science-chapter-1-part-1.mp4\",\n" + "        \"videoName\": \"Chemical Reactions \"\n" + "      }\n" + "    },\n" + "    {\n" + "      \"ncert_eng_sci_10_01_01_006\": {\n" + "        \"A\": {\n" + "          \"type\": \"text\",\n" + "          \"value\": \"Helium or nitrogen\"\n" + "        },\n" + "        \"B\": {\n" + "          \"type\": \"text\",\n" + "          \"value\": \"Carbon dioxide or helium\"\n" + "        },\n" + "        \"C\": {\n" + "          \"type\": \"text\",\n" + "          \"value\": \"Nitrogen or oxygen\"\n" + "        },\n" + "        \"D\": {\n" + "          \"type\": \"text\",\n" + "          \"value\": \"Carbon dioxide or oxygen\"\n" + "        },\n" + "        \"correct_feedback\": \"Helium or nitrogen gas can be used to preserve fresh samples of oil for a longer period of time.\",\n" + "        \"feedbackImage\": \"\",\n" + "        \"incorrect_feedback\": \"Helium or nitrogen gas can be used to preserve fresh samples of oil for a longer period of time.\",\n" + "        \"offlineLink\": \"3_Chemical_Reactions_C10_English_Video_Science.mp4\",\n" + "        \"q\": \"Which of the following gas can be used to preserve fresh oil samples for a long time?\",\n" + "        \"questionImage\": \"\",\n" + "        \"videoLink\": \"https://vimeo.com/444869578\",\n" + "        \"videoLink_diksha\": \"https://ntpproductionall.blob.core.windows.net/ntp-content-production/content/assets/do_313090047192817664193/class-x-science-chapter-1-part-1.mp4\",\n" + "        \"videoName\": \"Chemical Reactions \"\n" + "      }\n" + "    },\n" + "    {\n" + "      \"ncert_eng_sci_10_01_01_007\": {\n" + "        \"A\": {\n" + "          \"type\": \"text\",\n" + "          \"value\": \"Heating a copper wire to a high temperature in the presence of air\"\n" + "        },\n" + "        \"B\": {\n" + "          \"type\": \"text\",\n" + "          \"value\": \"Putting petrol in the china dish in the open\"\n" + "        },\n" + "        \"C\": {\n" + "          \"type\": \"text\",\n" + "          \"value\": \"Liquefaction of air\"\n" + "        },\n" + "        \"D\": {\n" + "          \"type\": \"text\",\n" + "          \"value\": \"Storing oxygen gas under high pressure in a gas cylinder\"\n" + "        },\n" + "        \"correct_feedback\": \"A chemical reaction is the heating of a copper wire to a high temperature in the presence of air.\",\n" + "        \"feedbackImage\": \"\",\n" + "        \"incorrect_feedback\": \"A chemical reaction is the heating of a copper wire to a high temperature in the presence of air.\",\n" + "        \"offlineLink\": \"3_Chemical_Reactions_C10_English_Video_Science.mp4\",\n" + "        \"q\": \"Which of the following process is a chemical reaction?\",\n" + "        \"questionImage\": \"\",\n" + "        \"videoLink\": \"https://vimeo.com/444869578\",\n" + "        \"videoLink_diksha\": \"https://ntpproductionall.blob.core.windows.net/ntp-content-production/content/assets/do_313090047192817664193/class-x-science-chapter-1-part-1.mp4\",\n" + "        \"videoName\": \"Chemical Reactions \"\n" + "      }\n" + "    },\n" + "    {\n" + "      \"ncert_eng_sci_10_01_01_008\": {\n" + "        \"A\": {\n" + "          \"type\": \"text\",\n" + "          \"value\": \"Chemical change\"\n" + "        },\n" + "        \"B\": {\n" + "          \"type\": \"text\",\n" + "          \"value\": \"Physical change\"\n" + "        },\n" + "        \"C\": {\n" + "          \"type\": \"text\",\n" + "          \"value\": \"Both physical and chemical change\"\n" + "        },\n" + "        \"D\": {\n" + "          \"type\": \"text\",\n" + "          \"value\": \"None of these\"\n" + "        },\n" + "        \"correct_feedback\": \"The formation of curd from milk is a chemical change.\",\n" + "        \"feedbackImage\": \"\",\n" + "        \"incorrect_feedback\": \"The formation of curd from milk is a chemical change.\",\n" + "        \"offlineLink\": \"3_Chemical_Reactions_C10_English_Video_Science.mp4\",\n" + "        \"q\": \"What type of change occurs from milk to curd production?\",\n" + "        \"questionImage\": \"\",\n" + "        \"videoLink\": \"https://vimeo.com/444869578\",\n" + "        \"videoLink_diksha\": \"https://ntpproductionall.blob.core.windows.net/ntp-content-production/content/assets/do_313090047192817664193/class-x-science-chapter-1-part-1.mp4\",\n" + "        \"videoName\": \"Chemical Reactions \"\n" + "      }\n" + "    }\n" + "  ],\n" + "  \"subjects\": {\n" + "    \"cbse\": {\n" + "      \"english\": [\n" + "        [\n" + "          {\n" + "            \"color\": \"#E67736\",\n" + "            \"icon\": \"https://firebasestorage.googleapis.com/v0/b/iprep-7f10a.appspot.com/o/subject_icon%2FEnglish%20Grammar.png?alt=media&token=f75d03d6-0a80-41e0-93dd-1e33d503cea3\",\n" + "            \"id\": \"english_grammar\",\n" + "            \"name\": \"English Grammar\",\n" + "            \"short_name\": \"Grammar\"\n" + "          },\n" + "          {\n" + "            \"color\": \"#2E6AB2\",\n" + "            \"icon\": \"https://firebasestorage.googleapis.com/v0/b/iprep-7f10a.appspot.com/o/subject_icon%2Ficon_id%2Fevs.png?alt=media&token=3fad2ad0-4d8d-4bb9-adff-b2f99a97bd7c\",\n" + "            \"id\": \"evs\",\n" + "            \"name\": \"EVS\",\n" + "            \"short_name\": \"EVS\"\n" + "          },\n" + "          {\n" + "            \"color\": \"#166B3F\",\n" + "            \"icon\": \"https://firebasestorage.googleapis.com/v0/b/iprep-7f10a.appspot.com/o/subject_icon%2F%E0%A4%97%E0%A4%A3%E0%A4%BF%E0%A4%A4.png?alt=media&token=3eedd4f8-751c-4ed0-8940-5f2b210f09ed\",\n" + "            \"id\": \"math\",\n" + "            \"name\": \"Math\",\n" + "            \"short_name\": \"Math\"\n" + "          }\n" + "        ]\n" + "      ]\n" + "    }\n" + "  }\n" + "}";
    LinearLayout optionLayout1, optionLayout2, optionlayout3, optionLayout4, feedbackLayout;
    TextView questionText, optionTextA, optionTextB, optionTextC, optionTextD, feedbackMessage;
    int question_number = 0;
    TextView submitButton;
    String feedback, optA, optB, optC, optD, question;
    String selectAnswer = "";
    Context context;
    JSONArray jsonArrayCorrectAnswer = new JSONArray();
    JSONArray lastRecordCorrectAnswer, lastRecordWrongAnswer;
    JSONArray jsonArrayWrongAnswer = new JSONArray();

    String subjectName;
    SharedPreferences sharedPreferences;
    TextView back;
    String correctAnswer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question);
        context = this;
        subjectName = getIntent().getStringExtra("subjectName");
        init();
        getQuestion(question_number);
        question_number++;
    }

    public void getQuestion(int question_number) {
        try {
            JSONObject obj = new JSONObject(JSONString);
            JSONArray jsonArray = obj.optJSONArray("practiceTests");
            Log.e("json array", jsonArray.length() + "");
            JSONObject jsonObject = (JSONObject) jsonArray.get(question_number);
            question_number++;
            JSONObject main = jsonObject.optJSONObject("ncert_eng_sci_10_01_01_00" + question_number);
            correctAnswer = main.optJSONObject("A").optString("value");
            optA = main.optJSONObject("A").optString("value");
            optB = main.optJSONObject("B").optString("value");
            optC = main.optJSONObject("C").optString("value");
            optD = main.optJSONObject("D").optString("value");
            question = main.optString("q");
            feedback = main.optString("correct_feedback");
            optionTextA.setText(optA);
            optionTextB.setText(optB);
            optionTextC.setText(optC);
            optionTextD.setText(optD);
            placeOptionInRandomOrder(optA, optB, optC, optD, question_number);
            questionText.setText(question_number + ". " + question);
            feedbackMessage.setText(feedback);
        } catch (JSONException e) {
            throw new RuntimeException(e);
        }
    }

    public void placeOptionInRandomOrder(String optA, String optB, String optC, String optD, int question) {
        List<String> optionsList = new ArrayList<>();
        optionsList.add(optA);
        optionsList.add(optB);
        optionsList.add(optC);
        optionsList.add(optD);
        Collections.shuffle(optionsList);
        optionTextA.setText(optionsList.get(0));
        optionTextB.setText(optionsList.get(1));
        optionTextC.setText(optionsList.get(2));
        optionTextD.setText(optionsList.get(3));

    }

    // initialize all view and handling the click listener
    public void init() {
        optionLayout1 = findViewById(R.id.option1);
        optionLayout2 = findViewById(R.id.option2);
        optionlayout3 = findViewById(R.id.option3);
        optionLayout4 = findViewById(R.id.option4);
        optionLayout1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                optionLayout1.setBackground(getResources().getDrawable(R.drawable.blue_background));
                optionLayout2.setBackground(getResources().getDrawable(R.drawable.rectangular_edit));
                optionlayout3.setBackground(getResources().getDrawable(R.drawable.rectangular_edit));
                optionLayout4.setBackground(getResources().getDrawable(R.drawable.rectangular_edit));
                selectAnswer = "A";
                submitButton.setBackgroundColor(getResources().getColor(R.color.blue1));
                submitButton.setTextColor(getResources().getColor(R.color.white));

            }
        });
        optionLayout2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                optionLayout2.setBackground(getResources().getDrawable(R.drawable.blue_background));
                optionlayout3.setBackground(getResources().getDrawable(R.drawable.rectangular_edit));
                optionLayout4.setBackground(getResources().getDrawable(R.drawable.rectangular_edit));
                optionLayout1.setBackground(getResources().getDrawable(R.drawable.rectangular_edit));
                selectAnswer = "B";
                submitButton.setBackgroundColor(getResources().getColor(R.color.blue1));
                submitButton.setTextColor(getResources().getColor(R.color.white));

            }
        });
        optionlayout3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                optionlayout3.setBackground(getResources().getDrawable(R.drawable.blue_background));
                optionLayout2.setBackground(getResources().getDrawable(R.drawable.rectangular_edit));
                optionLayout4.setBackground(getResources().getDrawable(R.drawable.rectangular_edit));
                optionLayout1.setBackground(getResources().getDrawable(R.drawable.rectangular_edit));
                selectAnswer = "C";
                submitButton.setBackgroundColor(getResources().getColor(R.color.blue1));
                submitButton.setTextColor(getResources().getColor(R.color.white));

            }
        });
        optionLayout4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                optionLayout4.setBackground(getResources().getDrawable(R.drawable.blue_background));
                optionLayout2.setBackground(getResources().getDrawable(R.drawable.rectangular_edit));
                optionlayout3.setBackground(getResources().getDrawable(R.drawable.rectangular_edit));
                optionLayout1.setBackground(getResources().getDrawable(R.drawable.rectangular_edit));
                selectAnswer = "D";
                submitButton.setBackgroundColor(getResources().getColor(R.color.blue1));
                submitButton.setTextColor(getResources().getColor(R.color.white));

            }
        });
        feedbackMessage = findViewById(R.id.feedback_message);
        feedbackLayout = findViewById(R.id.feedbackLayout);
        questionText = findViewById(R.id.question);
        optionTextA = findViewById(R.id.optionA);
        optionTextB = findViewById(R.id.optionB);
        optionTextC = findViewById(R.id.optionC);
        optionTextD = findViewById(R.id.optionD);
        submitButton = findViewById(R.id.submit_button);
        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (submitButton.getText().toString().equals("Next Question")) {
                    getQuestion(question_number);
                    question_number++;
                    submitButton.setText("Submit Answer");
                    selectAnswer = "";
                    optionLayout4.setBackground(getResources().getDrawable(R.drawable.rectangular_edit));
                    optionLayout2.setBackground(getResources().getDrawable(R.drawable.rectangular_edit));
                    optionlayout3.setBackground(getResources().getDrawable(R.drawable.rectangular_edit));
                    optionLayout1.setBackground(getResources().getDrawable(R.drawable.rectangular_edit));
                    feedbackLayout.setVisibility(View.INVISIBLE);
                    submitButton.setBackground(getResources().getDrawable(R.drawable.rectangular_edit));
                    submitButton.setTextColor(getResources().getColor(R.color.black));
                } else if (!selectAnswer.equals("")) {
                    if (selectAnswer.equals("A")) {
                        if (optionTextA.getText().toString().equals(correctAnswer)) {
                            jsonArrayCorrectAnswer.put(selectAnswer);
                            optionLayout1.setBackground(getResources().getDrawable(R.drawable.blue_background));
                        } else {
                            jsonArrayWrongAnswer.put(selectAnswer);
                            optionLayout1.setBackground(getResources().getDrawable(R.drawable.wrong_answer));
                        }
                    } else if (selectAnswer.equals("B")) {

                        if (optionTextB.getText().toString().equals(correctAnswer)) {
                            jsonArrayCorrectAnswer.put(selectAnswer);
                            optionLayout2.setBackground(getResources().getDrawable(R.drawable.blue_background));
                        } else {
                            jsonArrayWrongAnswer.put(selectAnswer);
                            optionLayout2.setBackground(getResources().getDrawable(R.drawable.wrong_answer));
                        }
                    } else if (selectAnswer.equals("C")) {
                        if (optionTextC.getText().toString().equals(correctAnswer)) {
                            jsonArrayCorrectAnswer.put(selectAnswer);
                            optionlayout3.setBackground(getResources().getDrawable(R.drawable.blue_background));
                        } else {
                            jsonArrayWrongAnswer.put(selectAnswer);
                            optionlayout3.setBackground(getResources().getDrawable(R.drawable.wrong_answer));
                        }
                    } else if (selectAnswer.equals("D")) {
                        if (optionTextD.getText().toString().equals(correctAnswer)) {
                            jsonArrayCorrectAnswer.put(selectAnswer);
                            optionLayout4.setBackground(getResources().getDrawable(R.drawable.blue_background));
                        } else {
                            jsonArrayWrongAnswer.put(selectAnswer);
                            optionLayout4.setBackground(getResources().getDrawable(R.drawable.wrong_answer));
                        }
                    }
                    Log.e("question number", question_number + "");
                    feedbackLayout.setVisibility(View.VISIBLE);
                    if (question_number == 8) {
                        if (subjectName.equals("English Grammar")) {
                            sharedPreferences = getSharedPreferences("EnglishResult", 0);
                            getLast();
                            SharedPreferences.Editor editor = sharedPreferences.edit();  // saving the report in shared preference after complete the assessment
                            editor.putInt("correct", jsonArrayCorrectAnswer.length());
                            editor.putInt("wrong", jsonArrayWrongAnswer.length());
                            lastRecordCorrectAnswer.put(jsonArrayCorrectAnswer.length());
                            lastRecordWrongAnswer.put(jsonArrayWrongAnswer.length());
                            editor.putString("lastCorrectAnswer", lastRecordCorrectAnswer.toString());
                            editor.putString("lastWrongAnswer", lastRecordWrongAnswer.toString());
                            editor.commit();
                        } else if (subjectName.equals("Math")) {
                            sharedPreferences = getSharedPreferences("mathResult", 0);
                            getLast();
                            SharedPreferences.Editor editor = sharedPreferences.edit();  // saving the report in shared preference after complete the assessment
                            editor.putInt("correct", jsonArrayCorrectAnswer.length());
                            editor.putInt("wrong", jsonArrayWrongAnswer.length());
                            lastRecordCorrectAnswer.put(jsonArrayCorrectAnswer.length());
                            lastRecordWrongAnswer.put(jsonArrayWrongAnswer.length());
                            editor.putString("lastCorrectAnswer", lastRecordCorrectAnswer.toString());
                            editor.putString("lastWrongAnswer", lastRecordWrongAnswer.toString());
                            editor.commit();
                        } else if (subjectName.equals("EVS")) {
                            sharedPreferences = getSharedPreferences("evsResult", 0);
                            getLast();
                            SharedPreferences.Editor editor = sharedPreferences.edit();  // saving the report in shared preference after complete the assessment
                            editor.putInt("correct", jsonArrayCorrectAnswer.length());
                            editor.putInt("wrong", jsonArrayWrongAnswer.length());
                            lastRecordCorrectAnswer.put(jsonArrayCorrectAnswer.length());
                            lastRecordWrongAnswer.put(jsonArrayWrongAnswer.length());
                            editor.putString("lastCorrectAnswer", lastRecordCorrectAnswer.toString());
                            editor.putString("lastWrongAnswer", lastRecordWrongAnswer.toString());
                            editor.commit();
                        }
                        Toast.makeText(context, "Task completed, report has been submitted.", Toast.LENGTH_SHORT).show();
                        finish();

                    }
                    submitButton.setText("Next Question");
                } else {
                    Toast.makeText(context, "Please select one option!", Toast.LENGTH_SHORT).show();

                }

            }
        });
        back = findViewById(R.id.Question_paper);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    public void getLast() {
        if (subjectName.equals("English Grammar")) {
            SharedPreferences sharedPreferences = getSharedPreferences("EnglishResult", 0);
            lastRecordCorrectAnswer = new JSONArray();
            lastRecordWrongAnswer = new JSONArray();
            if (sharedPreferences != null) {
                try {
                    JSONArray jsonArray = new JSONArray(sharedPreferences.getString("lastCorrectAnswer", ""));
                    JSONArray jsonArray1 = new JSONArray(sharedPreferences.getString("lastWrongAnswer", ""));
                    for (int i = 0; i < jsonArray.length(); i++) {
                        lastRecordCorrectAnswer.put(jsonArray.get(i));
                    }
                    for (int i = 0; i < jsonArray1.length(); i++) {
                        lastRecordWrongAnswer.put(jsonArray.get(i));
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

        } else if (subjectName.equals("Math")) {
            SharedPreferences sharedPreferences = getSharedPreferences("mathResult", 0);
            lastRecordCorrectAnswer = new JSONArray();
            lastRecordWrongAnswer = new JSONArray();
            if (sharedPreferences != null) {
                try {
                    JSONArray jsonArray = new JSONArray(sharedPreferences.getString("lastCorrectAnswer", ""));
                    JSONArray jsonArray1 = new JSONArray(sharedPreferences.getString("lastWrongAnswer", ""));
                    for (int i = 0; i < jsonArray.length(); i++) {
                        lastRecordCorrectAnswer.put(jsonArray.get(i));
                    }
                    for (int i = 0; i < jsonArray1.length(); i++) {
                        lastRecordWrongAnswer.put(jsonArray.get(i));
                    }
                } catch (Exception e) {
                    e.printStackTrace();
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
                        lastRecordCorrectAnswer.put(jsonArray.get(i));
                    }
                    for (int i = 0; i < jsonArray1.length(); i++) {
                        lastRecordWrongAnswer.put(jsonArray.get(i));
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

        }

    }
}