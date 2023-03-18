package com.example.bellmannford;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class SetUp extends AppCompatActivity {
    EditText to01,to02,to12,to13,to23,to24,to34;
    Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_set_up);
        button=findViewById(R.id.button);
        to01=findViewById(R.id.to01);
        to02=findViewById(R.id.to02);
        to12=findViewById(R.id.to12);
        to13=findViewById(R.id.to13);
        to23=findViewById(R.id.to23);
        to24=findViewById(R.id.to24);
        to34=findViewById(R.id.to34);

        button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                int array[]={Integer.parseInt(to01.getText().toString()),Integer.parseInt(to02.getText().toString()),Integer.parseInt(to12.getText().toString()),Integer.parseInt(to13.getText().toString()),Integer.parseInt(to23.getText().toString()),Integer.parseInt(to24.getText().toString()),Integer.parseInt(to34.getText().toString())};
                Intent i= new Intent(SetUp.this,MainActivity.class);
                i.putExtra("number",array);
                startActivity(i);
            }
        });

    }
}