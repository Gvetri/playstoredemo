package giuseppevetri.grabilityapp;

import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.transition.Fade;
import android.transition.TransitionInflater;

import giuseppevetri.grabilityapp.adapters.ViewPagerAdapter;

public class MainActivity extends AppCompatActivity implements setPager {

    private TabLayout tabLayout;
    private ViewPager viewPager;
    private int[] tabIcons = {
            R.mipmap.ic_favorite_white_24dp,
            R.mipmap.ic_list_white_24dp,
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setupWindowAnimations();
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        viewPager = (ViewPager) findViewById(R.id.viewpager);
        setupViewPager(viewPager);

        tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(viewPager);
        setupTabIcons(tabLayout);
    }

    private void setupWindowAnimations() {
        Fade fade = null;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            fade = (Fade) TransitionInflater.from(this).inflateTransition(R.transition.activity_fade);
        }
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            getWindow().setEnterTransition(fade);
        }
    }

    @Override
    public void setupViewPager(ViewPager viewPager) {
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        adapter.addFragment(new AppFragment(), "Top 10 Apps");
        adapter.addFragment(new CategoryFragment(), "Categorias");
        viewPager.setAdapter(adapter);
    }

    @Override
    public void setupTabIcons(TabLayout tablayout) {
        tabLayout.getTabAt(0).setIcon(tabIcons[0]);
        tabLayout.getTabAt(1).setIcon(tabIcons[1]);
    }

}
