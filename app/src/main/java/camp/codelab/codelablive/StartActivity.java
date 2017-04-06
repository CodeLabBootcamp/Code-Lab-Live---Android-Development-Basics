package camp.codelab.codelablive;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class StartActivity extends AppCompatActivity {

    Button openCalculatorButton;
    Button openRealTimeCalculatorButton;
    Button openImage;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);
        openCalculatorButton = (Button) findViewById(R.id.open_calculator_button);
        openRealTimeCalculatorButton = (Button) findViewById(R.id.open_real_time_calc);
        openImage = (Button) findViewById(R.id.open_image);

        openCalculatorButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(StartActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });


        openRealTimeCalculatorButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(StartActivity.this, RealTimeCalculatorActivity.class);
                startActivity(intent);
            }
        });

        openImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(StartActivity.this, ImageActivity.class);
                startActivity(intent);
            }
        });

    }
}
