package kukila.backindapps.Layout;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.widget.EditText;

/**
 * Created by Mindha on 18/10/2017.
 */

public class EditTexteBackindRegular extends EditText {
    public EditTexteBackindRegular(Context context) {
        super(context);
        applyCustomFont(context);
    }

    public EditTexteBackindRegular(Context context, AttributeSet attrs) {
        super(context, attrs);
        applyCustomFont(context);
    }

    public EditTexteBackindRegular(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        applyCustomFont(context);
    }

    private void applyCustomFont(Context context){
        setTypeface(Typeface.createFromAsset(context.getAssets(), "fonts/Montserrat-Regular.ttf"));
    }
}
