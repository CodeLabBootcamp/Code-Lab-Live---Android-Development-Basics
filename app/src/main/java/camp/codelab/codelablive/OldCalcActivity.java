package camp.codelab.codelablive;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import camp.codelab.codelablive.databinding.ActivityOldCalcBinding;

public class OldCalcActivity extends AppCompatActivity {

    ActivityOldCalcBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_old_calc);
        binding.setVm(new OldCalcViewModel());


    }

}
