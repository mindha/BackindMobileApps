package kukila.backindapps;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.TextView;

public class BottomMenu extends AppCompatActivity {

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    setTitle("Home");
                    Home fragment1 = new Home();
                    FragmentTransaction fT1 = getSupportFragmentManager().beginTransaction();
                    fT1.replace(R.id.content, fragment1,"FragmentName");
                    fT1.commit();
                    return true;
                case R.id.navigation_booking:
                    setTitle("My Booking");
                    Booking fragment2 = new Booking();
                    FragmentTransaction fT2 = getSupportFragmentManager().beginTransaction();
                    fT2.replace(R.id.content, fragment2,"FragmentName");
                    fT2.commit();
                    return true;
                case R.id.navigation_profile:
                    setTitle("My Profile");
                    Profile fragment3 = new Profile();
                    FragmentTransaction fT3 = getSupportFragmentManager().beginTransaction();
                    fT3.replace(R.id.content, fragment3,"FragmentName");
                    fT3.commit();
                    return true;
            }
            return false;
        }

    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bottom_menu);

        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        setTitle("Home");
        Home fragment1 = new Home();
        FragmentTransaction fT1 = getSupportFragmentManager().beginTransaction();
        fT1.replace(R.id.content, fragment1,"FragmentName");
        fT1.commit();
    }

}
