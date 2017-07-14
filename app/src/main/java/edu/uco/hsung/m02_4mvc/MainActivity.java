package edu.uco.hsung.m02_4mvc;

import android.app.Activity;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {

    private Person[] contacts = new Person[] {
            new Person("John", 23),
            new Person("Mary", 19),
            new Person("Sue", 21),
            new Person("Kelly", 25),
            new Person("Mark", 29)
    };

    private int currentIndex = 0;
    private TextView display;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        display = (TextView) findViewById(R.id.display);
        showPersonInfo();

        Button prev = (Button) findViewById(R.id.prevButton);
        Button next = (Button) findViewById(R.id.nextButton);

        prev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (currentIndex == 0) {
                    Toast.makeText(MainActivity.this,
                            "No previous record",
                            Toast.LENGTH_SHORT
                    ).show();
                } else {
                    --currentIndex;
                    showPersonInfo();
                }
            }
        });

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (currentIndex == contacts.length - 1) {
                    Toast.makeText(MainActivity.this,
                            "No next record",
                            Toast.LENGTH_SHORT
                    ).show();
                } else {
                    ++currentIndex;
                    showPersonInfo();
                }
            }
        });
    }

    private void showPersonInfo() {
        String name = contacts[currentIndex].getName();
        int age = contacts[currentIndex].getAge();
        Resources res = getResources();
        String text = String.format(res.getString(R.string.person_info),
                name, age);
        display.setText(text);
    }
}
