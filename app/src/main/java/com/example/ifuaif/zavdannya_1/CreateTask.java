package com.example.ifuaif.zavdannya_1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

/**
 * Created by IFuaIF on 26.05.2016.
 */
public class CreateTask extends MainActivity implements OnClickListener {
    private static final int CM_DELETE_ID = 1;
    private Button saveBt;
    private Button exitBt;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.create_task_activity);
        exitBt = (Button) findViewById(R.id.exit_button);
        exitBt.setOnClickListener(this);

        saveBt = (Button) findViewById(R.id.save_button);
        saveBt.setOnClickListener(this);

        lViewMain.setAdapter(adapter);


        saveBt.setOnClickListener(new OnClickListener() {
            private EditText eTextTasks, eTextComments;

            @Override
            public void onClick(View v) {

                eTextTasks = (EditText) findViewById(R.id.eText_task);
                eTextComments = (EditText) findViewById(R.id.eText_comment);


                if (!(eTextTasks.getText().toString().equals("") || eTextComments.getText().toString().equals(""))) {
                    final String task = eTextTasks.getText().toString();
                    final String comment = eTextComments.getText().toString();
                    Intent intent1 = new Intent();
                    intent1.putExtra("task", task);
                    intent1.putExtra("comment", comment);
                    setResult(RESULT_OK, intent1);
                    finish();
                }

            }
        });
        exitBt.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();


            }
        });
    }

    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState);
        savedInstanceState.putString(tasks, comments);
    }

}

