package camp.codelab.codelablive;

import android.databinding.BaseObservable;
import android.databinding.Bindable;

/**
 * Created by Sabri on 4/13/17.
 */

public class OldCalcViewModel extends BaseObservable {

    private final int ADD = 1;
    private final int SUB = 2;
    private final int MUL = 3;
    private final int DIV = 4;

    private String number1, number2;
    private String result;

    public OldCalcViewModel() {
        number1 = "";
        number2 = "";
        result = "";
    }


    public String getNumber1() {
        return number1;
    }

    public void setNumber1(String number1) {
        this.number1 = number1;
    }

    public String getNumber2() {
        return number2;
    }

    public void setNumber2(String number2) {
        this.number2 = number2;
    }

    public void add() {
        doCalculations(ADD);
    }

    public void sub() {
        doCalculations(SUB);
    }

    public void mul() {
        doCalculations(MUL);
    }

    public void div() {
        doCalculations(DIV);
    }

    private void doCalculations(int op) {
        String number1String = number1;
        String number2String = number2;

        float result = 0;

        if (!number1String.isEmpty() && !number2String.isEmpty()) {

            int number1 = Integer.parseInt(number1String);
            int number2 = Integer.parseInt(number2String);


            switch (op) {
                case ADD:
                    result = number1 + number2;
                    break;
                case SUB:
                    result = number1 - number2;
                    break;
                case MUL:
                    result = number1 * number2;
                    break;
                case DIV:
                    if (number2 != 0) {
                        result = (float) number1 / number2;
                    } else {
                        result = 0;
                    }
                    break;
            }
        }

        this.result = String.valueOf(result);
        notifyPropertyChanged(BR.result);
    }

    @Bindable
    public String getResult() {
        return result;
    }

}
