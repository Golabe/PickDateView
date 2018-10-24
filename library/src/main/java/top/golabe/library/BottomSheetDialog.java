package top.golabe.library;

import android.content.Context;
import android.support.annotation.NonNull;

public class BottomSheetDialog  extends android.support.design.widget.BottomSheetDialog {
    private Context context;
    public BottomSheetDialog(@NonNull Context context) {
        super(context);
        this.context=context;
    }


}
