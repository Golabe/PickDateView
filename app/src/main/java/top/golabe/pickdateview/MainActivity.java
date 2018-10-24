package top.golabe.pickdateview;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import top.golabe.library.DatePickerPop;
import top.golabe.library.callback.OnCancelListener;
import top.golabe.library.callback.OnConfirmListener;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }

    public void showDialog(View view) {
        DatePickerPop datePickerPop = new DatePickerPop.Builder(this)
                .maxYear(2050)
                .minYear(1900)
                .defaultData("2012-02-20")
                .textSize(16)
                .textUnselectedColor(Color.parseColor("#CCCCCC"))
                .textSelectedColor(Color.parseColor("#000000"))
                .cancelColor(Color.parseColor("#f45151"))
                .confirmColor(Color.parseColor("#000000"))
                .btnTextSize(12)
                .cancel("取消")
                .confirm("确定")
                .bgColor(Color.parseColor("#FFFFFF"))
                .confirmListener(new OnConfirmListener() {
                    @Override
                    public void onConfirm(View v) {
                        Toast.makeText(MainActivity.this, "confirm", Toast.LENGTH_LONG).show();
                    }
                })
                .cancelListener(new OnCancelListener() {
                    @Override
                    public void onCancel() {
                        Toast.makeText(MainActivity.this, "cancel", Toast.LENGTH_LONG).show();
                    }
                })
                .build();
    }
}
