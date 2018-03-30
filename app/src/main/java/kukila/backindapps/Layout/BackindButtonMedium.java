package kukila.backindapps.Layout;

import android.content.Context;
import android.graphics.Typeface;
import android.support.v7.widget.AppCompatButton;
import android.util.AttributeSet;

/**
 * Created by Mindha on 18/10/2017.
 */

public class BackindButtonMedium extends AppCompatButton {
    public BackindButtonMedium(Context context) {
        super(context);
        applyCustomFont(context);
    }

    public BackindButtonMedium(Context context, AttributeSet attrs) {
        super(context, attrs);
        applyCustomFont(context);
    }

    public BackindButtonMedium(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        applyCustomFont(context);
    }

    private void applyCustomFont(Context context){
        setTypeface(Typeface.createFromAsset(context.getAssets(), "fonts/Montserrat-Regular.ttf"));
    }
}
