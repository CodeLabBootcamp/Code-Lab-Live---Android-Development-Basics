package camp.codelab.codelablive;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText number1Java;
    EditText number2Java;
    Button addJava;
    Button subJava;
    Button mulJava;
    Button divJava;
    TextView resultJava;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        number1Java = (EditText) findViewById(R.id.number1XML);
        number2Java = (EditText) findViewById(R.id.number2XML);
        addJava = (Button) findViewById(R.id.addXML);
        subJava = (Button) findViewById(R.id.subXML);
        mulJava = (Button) findViewById(R.id.mulXML);
        divJava = (Button) findViewById(R.id.divXML);
        resultJava = (TextView) findViewById(R.id.resultXML);

        addJava.setOnClickListener(listener);
        subJava.setOnClickListener(listener);
        mulJava.setOnClickListener(listener);
        divJava.setOnClickListener(listener);

    }

    View.OnClickListener listener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {

            String number1String = number1Java.getText().toString();
            String number2String = number2Java.getText().toString();

            if (!number1String.isEmpty() && !number2String.isEmpty()) {

                int number1 = Integer.parseInt(number1String);
                int number2 = Integer.parseInt(number2String);


                int result;

                switch (v.getId()) {
                    case R.id.addXML:
                        result = number1 + number2;
                        break;
                    case R.id.subXML:
                        result = number1 - number2;
                        break;
                    case R.id.mulXML:
                        result = number1 * number2;
                        break;
                    case R.id.divXML:
                        if (number2 != 0) {
                            result = number1 / number2;
                        } else {
                            result = 0;
                            Toast.makeText(MainActivity.this, R.string.cannot_divide_by_zero, Toast.LENGTH_SHORT).show();
                        }
                        break;
                    default:
                        result = 0;
                        break;

                }

                resultJava.setText(String.valueOf(result));

            } else {
                Toast.makeText(MainActivity.this, R.string.please_fill_all_fields, Toast.LENGTH_SHORT).show();
            }

        }
    };
}
