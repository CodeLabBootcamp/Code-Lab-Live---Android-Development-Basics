package camp.codelab.codelablive;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import camp.codelab.codelablive.databinding.ActivityRealTimeCalculatorBinding;

public class RealTimeCalculatorActivity extends AppCompatActivity {


    ActivityRealTimeCalculatorBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_real_time_calculator);

        binding.setVm(new CalcViewModel());

    }

}
