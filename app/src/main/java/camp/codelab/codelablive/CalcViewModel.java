package camp.codelab.codelablive;

import android.databinding.BaseObservable;
import android.databinding.Bindable;

/**
 * Created by Sabri on 4/13/17.
 */

public class CalcViewModel extends BaseObservable {

    private String number1, number2;
    private boolean addB, subB, mulB, divB;

    public CalcViewModel() {
        number1 = "";
        number2 = "";
        addB = true;
    }


    public String getNumber1() {
        return number1;
    }

    public void setNumber1(String number1) {
        this.number1 = number1;
        notifyPropertyChanged(BR.result);
    }

    public String getNumber2() {
        return number2;
    }

    public void setNumber2(String number2) {
        this.number2 = number2;
        notifyPropertyChanged(BR.result);
    }

    public boolean isAddB() {
        return addB;
    }

    public void setAddB(boolean addB) {
        this.addB = addB;
        notifyPropertyChanged(BR.result);
    }

    public boolean isSubB() {
        return subB;
    }

    public void setSubB(boolean subB) {
        this.subB = subB;
        notifyPropertyChanged(BR.result);
    }

    public boolean isMulB() {
        return mulB;
    }

    public void setMulB(boolean mulB) {
        this.mulB = mulB;
        notifyPropertyChanged(BR.result);
    }

    public boolean isDivB() {
        return divB;
    }

    public void setDivB(boolean divB) {
        this.divB = divB;
        notifyPropertyChanged(BR.result);
    }

    @Bindable
    public String getResult() {
        String number1String = number1;
        String number2String = number2;

        if (!number1String.isEmpty() && !number2String.isEmpty()) {

            int number1 = Integer.parseInt(number1String);
            int number2 = Integer.parseInt(number2String);


            int result;

            if (addB) {
                result = number1 + number2;
            } else if (subB) {
                result = number1 - number2;
            } else if (mulB) {
                result = number1 * number2;
            } else if (divB) {
                if (number2 != 0) {
                    result = number1 / number2;
                } else {
                    result = 0;
//                    Toast.makeText(context, R.string.cannot_divide_by_zero, Toast.LENGTH_SHORT).show();
                }
            } else {
                result = 0;
            }

            return String.valueOf(result);

        } else {
//            Toast.makeText(context, R.string.please_fill_all_fields, Toast.LENGTH_SHORT).show();
            return "0";
        }
    }
}
