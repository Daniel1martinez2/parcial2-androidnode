package com.example.parcial2_androidnode;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class MainActivity extends AppCompatActivity {
    private FirebaseDatabase db;
    private Button sendAnswer;
    private TextView question;
    private EditText inputAnswer;
    Question questionRaw;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        db = FirebaseDatabase.getInstance();
        sendAnswer = findViewById(R.id.sendAnswer);
        question = findViewById(R.id.question);
        inputAnswer = findViewById(R.id.inputAnswer);
        sendAnswer.setOnClickListener(
                (e)->{

                    if(questionRaw == null || inputAnswer.getText().toString().matches("")){

                    }else {
                        String id = db.getReference().child("answers").push().getKey();
                        DatabaseReference reference = db.getReference().child("answers").child(id);
                        Answer answer = new Answer(id, questionRaw.getId(), Integer.parseInt( inputAnswer.getText().toString()));
                        reference.setValue(answer);
                    }

                }
        );
        db.getReference().child("questions").orderByChild("state").equalTo(true).addValueEventListener(
                new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        if(snapshot.getValue()== null){
                            question.setText("¿?");
                        }else{
                            for(DataSnapshot child: snapshot.getChildren()){
                                questionRaw = child.getValue(Question.class);

                                question.setText(questionRaw.getText());
                            }
                        }
                    }
                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {
                    }
                }
        );
    }
}