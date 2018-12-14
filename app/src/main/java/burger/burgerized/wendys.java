package burger.burgerized;
import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.TabLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.util.Log;
import android.view.View;


public class wendys extends AppCompatActivity {


    private SharedPreferences mPreferences;
    private SharedPreferences.Editor mEditor;

    private static final String TAG = "MainActivity";

    private SectionPageAdapter mSectionsPageAdapter;

    private ViewPager mViewPager;
    static String chosen;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.wendys);
        Log.d(TAG, "onCreate: Starting.");

        mSectionsPageAdapter = new SectionPageAdapter(getSupportFragmentManager());

        // Set up the ViewPager with the sections adapter.
        mViewPager = (ViewPager) findViewById(R.id.container);
        setupViewPager(mViewPager);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(mViewPager);


    }

    private void setupViewPager(ViewPager viewPager) {

        mPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        mEditor = mPreferences.edit();

        chosen = mPreferences.getString("chosen", "wendys");

        if (chosen == "wendys") {
            SectionPageAdapter adapter = new SectionPageAdapter(getSupportFragmentManager());
            adapter.addFragment(new wendys_combos(), "Combos");
            adapter.addFragment(new wendys_sides(), "Sides");
            viewPager.setAdapter(adapter);
        }
        else if (chosen == "bk") {
            SectionPageAdapter adapter = new SectionPageAdapter(getSupportFragmentManager());
            adapter.addFragment(new bk_combos(), "Combos");
            adapter.addFragment(new bk_sides(), "Sides");
            viewPager.setAdapter(adapter);
        }
        FloatingActionButton bag = findViewById(R.id.bag);
        bag.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent openApp = new Intent(getApplicationContext(), your_bag.class);
                startActivity(openApp);
                finish();
            }
        });
    }
}