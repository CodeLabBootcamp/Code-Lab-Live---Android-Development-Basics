package camp.codelab.codelablive;

import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class RealTimeCalculatorActivity extends AppCompatActivity {

    EditText number1Java;
    EditText number2Java;
    TextView resultJava;
    RadioGroup radioGroupJava;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_real_time_calculator);

        number1Java = (EditText) findViewById(R.id.number1XML);
        number2Java = (EditText) findViewById(R.id.number2XML);
        resultJava = (TextView) findViewById(R.id.resultXML);
        radioGroupJava = (RadioGroup) findViewById(R.id.radio_group);


        number1Java.addTextChangedListener(textWatcher);
        number2Java.addTextChangedListener(textWatcher);

        radioGroupJava.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, @IdRes int checkedId) {
                doCalculations();
            }
        });
    }


    TextWatcher textWatcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
            doCalculations();
        }

        @Override
        public void afterTextChanged(Editable s) {

        }
    };



    public void doCalculations(){
        String number1String = number1Java.getText().toString();
        String number2String = number2Java.getText().toString();

        if (!number1String.isEmpty() && !number2String.isEmpty()) {

            int number1 = Integer.parseInt(number1String);
            int number2 = Integer.parseInt(number2String);


            int result;

            switch (radioGroupJava.getCheckedRadioButtonId()) {
                case R.id.add_radio:
                    result = number1 + number2;
                    break;
                case R.id.sub_radio:
                    result = number1 - number2;
                    break;
                case R.id.mul_radio:
                    result = number1 * number2;
                    break;
                case R.id.div_radio:
                    if (number2 != 0) {
                        result = number1 / number2;
                    } else {
                        result = 0;
                        Toast.makeText(RealTimeCalculatorActivity.this, R.string.cannot_divide_by_zero, Toast.LENGTH_SHORT).show();
                    }
                    break;
                default:
                    result = 0;
                    break;

            }

            resultJava.setText(String.valueOf(result));

        } else {
            Toast.makeText(RealTimeCalculatorActivity.this, R.string.please_fill_all_fields, Toast.LENGTH_SHORT).show();
        }

    }
}
