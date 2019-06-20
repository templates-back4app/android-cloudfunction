package com.back4app.androidcloudcodefunction;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.parse.FunctionCallback;
import com.parse.ParseCloud;
import com.parse.ParseException;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Map<String, String> parameters = new HashMap<>();

        final Button callFunction = findViewById(R.id.btnCloudCodeFunction);
        callFunction.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                parameters.put("name", "Natália");
                ParseCloud.callFunctionInBackground("welcomeToBack4App", parameters
                        , new FunctionCallback<String>() {
                        @Override
                        public void done(String object, ParseException e) {
                            if (e == null) {
                                // Everything is alright
                                Log.d("Debug",object);
                                Toast.makeText(MainActivity.this, object, Toast.LENGTH_SHORT).show();
                            }
                            else {
                                // Something went wrong
                                Log.d("Debug",e.getMessage());
                                Toast.makeText(MainActivity.this, e.getMessage(), Toast.LENGTH_SHORT).show();
                            }
                        }
                });
            }
        });

    }
}
