package kukila.backindapps.Layout;

import android.content.Context;
import android.graphics.Typeface;
import android.support.v7.widget.AppCompatAutoCompleteTextView;
import android.util.AttributeSet;
import android.widget.AutoCompleteTextView;

/**
 * Created by Mindha on 18/10/2017.
 */

public class AutoCompleteBackindLight extends AppCompatAutoCompleteTextView {
    public AutoCompleteBackindLight(Context context) {
        super(context);
        applyCustomFont(context);
    }

    public AutoCompleteBackindLight(Context context, AttributeSet attrs) {
        super(context, attrs);
        applyCustomFont(context);
    }

    public AutoCompleteBackindLight(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        applyCustomFont(context);
    }

    private void applyCustomFont(Context context){
        setTypeface(Typeface.createFromAsset(context.getAssets(), "fonts/Montserrat-Light.ttf"));
    }
}
