package top.golabe.library;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;

public class PickDateView extends View {
    public PickDateView(Context context) {
        this(context,null);
    }

    public PickDateView(Context context,AttributeSet attrs) {
        this(context, attrs,0);
    }

    public PickDateView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }
}
