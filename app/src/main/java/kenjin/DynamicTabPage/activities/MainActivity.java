package kenjin.DynamicTabPage.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import kenjin.DynamicTabPage.R;

/**
 * Created by kenjinsan on 5/22/17.
 */

public class MainActivity extends AppCompatActivity {



    Button dynamictab,statictab;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        statictab=(Button) findViewById(R.id.statictab);
        dynamictab=(Button) findViewById(R.id.dynamictab);

        statictab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent inten = new Intent(v.getContext(), StaticActivity.class);//berpindah ke activity yang lain dgn data
                startActivity(inten);
            }
        });
        dynamictab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent inten = new Intent(v.getContext(), DynamicActivity.class);//berpindah ke activity yang lain dgn data
                startActivity(inten);
            }
        });


       // getSupportActionBar().hide();

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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
