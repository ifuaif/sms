package com.example.ifuaif.zavdannya_1;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements OnClickListener {

    private static final String LIST_INSTANCE_STATE = "1";
    private Toolbar toolbar;

    String tasks = "";
    String comments = "";
    Button addButton;
    ListView lViewMain;
    public ArrayList<Item> array;
    public MyAdapter adapter;
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);


       toolbar = (Toolbar)findViewById(R.id.my_toolbar);

        lViewMain = (ListView) findViewById(R.id.list_view_main);
        addButton = (Button) findViewById(R.id.add_button);
        addButton.setOnClickListener(this);

        array = new ArrayList<Item>();
        Intent intent = getIntent();
        adapter = new MyAdapter(this, array);
       // adapter = (MyAdapter) intent.getSerializableExtra("1");
        lViewMain.setAdapter(adapter);
        adapter.notifyDataSetChanged();
       // lViewMain.onRestoreInstanceState(mListInstanceState);
    }
    private  void deleteListDate(){

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.add_button:
                Intent intent = new Intent(this,CreateTask.class); //Вказую між якими Аctiviti відбуватиметься зв*язок
                startActivityForResult(intent, 6 );
                break;
            default:
                break;
        }
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        // Проверяем ориентацию экрана
        if (newConfig.orientation == Configuration.ORIENTATION_LANDSCAPE) {
        } else if (newConfig.orientation == Configuration.ORIENTATION_PORTRAIT) {
        }
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode == RESULT_OK) {
            final String task = data.getStringExtra("task");
            final String comment = data.getStringExtra("comment");
            array.add(new Item(task,comment));
            adapter.notifyDataSetChanged();
        }
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString("task", tasks);
        outState.putString("comments", comments);

       // outState.putParcelable(LIST_INSTANCE_STATE, lViewMain.onSaveInstanceState());
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        //  lViewMain.setAdapter((ListAdapter) new Item(tasks,comments));
        tasks = savedInstanceState.getString("task");
        comments = savedInstanceState.getString("comments");
    }

}