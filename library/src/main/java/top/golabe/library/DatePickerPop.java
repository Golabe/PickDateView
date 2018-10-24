package top.golabe.library;

import android.content.Context;
import android.graphics.Color;
import android.support.annotation.ColorInt;
import android.support.design.widget.BottomSheetDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.Calendar;

import top.golabe.library.callback.OnCancelListener;
import top.golabe.library.callback.OnConfirmListener;

public class DatePickerPop {
    private BottomSheetDialog mBottomSheetDialog;
    private String cancel;
    private String confirm;
    private int cancelColor;
    private int confirmColor;

    private int maxYear;
    private int minYear;
    private int btnTextSize;
    private int textSize;
    private int bgColor;

    private int textSelectedColor;
    private int textUnselectedColor;
    private String defaultDate;
    private Context context;
    private OnCancelListener onCancelListener;
    private OnConfirmListener onConfirmListener;

    public DatePickerPop(Builder builder) {
        this.context = builder.context;
        this.bgColor = builder.bgColor;
        this.cancel = builder.cancel;
        this.confirm = builder.confirm;
        this.cancelColor = builder.cancelColor;
        this.confirmColor = builder.confirmColor;
        this.maxYear = builder.maxYear;
        this.minYear = builder.minYear;
        this.btnTextSize = builder.btnTextSize;
        this.textSize = builder.textSize;
        this.textSelectedColor = builder.textSelectedColor;
        this.textUnselectedColor = builder.textUnselectedColor;
        this.defaultDate = builder.defaultDate;
        this.onCancelListener = builder.onCancelListener;
        this.onConfirmListener = builder.onConfirmListener;
        initDialogView();
    }

    private void initDialogView() {
        mBottomSheetDialog = new BottomSheetDialog(context);
        View view = LayoutInflater.from(context).inflate(R.layout.dialog_bottom_sheet, null);
        RelativeLayout container = view.findViewById(R.id.dialog_container);
        TextView tvCancel = view.findViewById(R.id.dialog_tv_cancel);
        TextView tvConfirm = view.findViewById(R.id.dialog_tv_confirm);

        container.setBackgroundColor(bgColor);
        tvCancel.setTextColor(cancelColor);
        tvConfirm.setTextColor(confirmColor);
        tvCancel.setText(cancel);
        tvConfirm.setText(confirm);
        tvCancel.setTextSize(btnTextSize);
        tvConfirm.setTextSize(btnTextSize);
        mBottomSheetDialog.setContentView(view);
        if (mBottomSheetDialog.isShowing()) {
            mBottomSheetDialog.dismiss();
        } else {
            mBottomSheetDialog.show();
        }
        tvCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (onCancelListener != null) {
                    onCancelListener.onCancel();
                }
                if (mBottomSheetDialog != null && mBottomSheetDialog.isShowing()) {
                    mBottomSheetDialog.dismiss();
                }
            }
        });
        tvConfirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (onConfirmListener != null) {
                    onConfirmListener.onConfirm(v);
                }

            }
        });

    }

    public static class Builder {
        private String cancel = "CANCEL";
        private String confirm = "CONFIRM";
        private int cancelColor = Color.parseColor("#D81B60");
        private int confirmColor = Color.parseColor("#008577");
        private int maxYear = Calendar.getInstance().get(Calendar.YEAR) + 1;
        private int minYear = 1900;
        private int btnTextSize = 16;
        private int textSize = 24;
        private int bgColor = Color.parseColor("#ffffff");
        private int textSelectedColor = Color.parseColor("#000000");
        private int textUnselectedColor = Color.parseColor("#CCCCCC");
        private String defaultDate = "1900-1-1";
        private Context context;
        private OnConfirmListener onConfirmListener;
        private OnCancelListener onCancelListener;

        public Builder(Context context) {
            this.context = context;
        }

        public Builder cancelListener(OnCancelListener listener) {
            this.onCancelListener = listener;
            return this;
        }

        public Builder confirmListener(OnConfirmListener listener) {
            this.onConfirmListener = listener;
            return this;
        }

        public Builder cancel(String cancel) {
            this.cancel = cancel;
            return this;
        }

        public Builder confirm(String confirm) {
            this.confirm = confirm;
            return this;
        }

        public Builder cancelColor(@ColorInt int color) {
            this.cancelColor = color;
            return this;
        }

        public Builder confirmColor(@ColorInt int color) {
            this.confirmColor = color;
            return this;
        }

        public Builder minYear(int year) {
            this.minYear = year;
            return this;
        }

        public Builder maxYear(int year) {
            this.maxYear = year;
            return this;
        }

        public Builder btnTextSize(int textSize) {
            this.btnTextSize = textSize;
            return this;
        }

        public Builder textSize(int textSize) {
            this.textSize = textSize;
            return this;
        }

        public Builder textSelectedColor(@ColorInt int color) {
            this.textSelectedColor = color;
            return this;
        }

        public Builder textUnselectedColor(@ColorInt int color) {
            this.textUnselectedColor = color;
            return this;
        }

        public Builder defaultData(String defaultDate) {
            this.defaultDate = defaultDate;
            return this;
        }

        public Builder bgColor(@ColorInt int bgColor) {
            this.bgColor = bgColor;
            return this;
        }

        public DatePickerPop build() {
            if (minYear > maxYear) {
                throw new IllegalArgumentException();
            }
            return new DatePickerPop(this);
        }

    }
}
