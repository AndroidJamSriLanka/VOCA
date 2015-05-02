package com.nextgen.kasun.uidesign3;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.parse.FindCallback;
import com.parse.ParseObject;
import com.parse.ParseQuery;

import java.util.ArrayList;
import java.util.List;


public class QuizActivity extends ActionBarActivity {
    ArrayList<String> asd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        ParseQuery<ParseObject> query = ParseQuery.getQuery("vocabulary");
        query.findInBackground(new FindCallback<ParseObject>() {

            public void done(List<ParseObject> scoreList, com.parse.ParseException e) {
                if (e == null) {
                    Log.d("score", "Retrieved " + scoreList.size() + " scores");
                     asd=new ArrayList<String>();


                    for (int i = 0; i < scoreList.size(); i++) {

                        ParseObject object = scoreList.get(i);
                        String name = ((ParseObject) object).get("word").toString();
                        asd.add(i,name);
//
                    }

                    ;

                } else {
                    Log.d("score", "Error: " + e.getMessage());
                }
            }


        });



    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_quiz, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
