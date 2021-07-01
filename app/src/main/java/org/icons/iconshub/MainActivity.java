package org.icons.iconshub;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ViewFlipper;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.appbar.MaterialToolbar;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import org.icons.iconshub.fragments.AboutDialog;
import org.icons.iconshub.fragments.CoWorkingDialog;
import org.icons.iconshub.fragments.HelpsDialog;
import org.icons.iconshub.fragments.InnovationDialog;
import org.icons.iconshub.fragments.PlansDialog;
import org.icons.iconshub.fragments.SocialDialog;
import org.jetbrains.annotations.NotNull;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {
    @BindView(R2.id.flipper)
    ViewFlipper viewFlipper;

    @BindView(R2.id.toolBar)
    MaterialToolbar toolBar;

    @BindView(R2.id.bottomNav)
    BottomNavigationView bottomNav;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        setSupportActionBar(toolBar);

        Animation animationIn = AnimationUtils.loadAnimation(MainActivity.this, R.anim.animin);
        Animation animationOut = AnimationUtils.loadAnimation(MainActivity.this, R.anim.animout);

        viewFlipper.setInAnimation(animationIn);
        viewFlipper.setOutAnimation(animationOut);

        viewFlipper.setFlipInterval(5000);
        viewFlipper.setAutoStart(true);
        viewFlipper.startFlipping();

        setUpBottomNav();
    }

    private void setUpBottomNav() {
        bottomNav.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NotNull MenuItem item) {
                if (item.getItemId() == R.id.menu_social) {
                    SocialDialog.showDialog(getSupportFragmentManager());
                }
                if ((item.getItemId()==R.id.menu_help)){
                    HelpsDialog.showDialog(getSupportFragmentManager());
                }
                return false;
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.menu_co_working) {
            CoWorkingDialog.showDialog(getSupportFragmentManager());
        } else if (item.getItemId() == R.id.menu_innovation) {
            InnovationDialog.showDialog(getSupportFragmentManager());
        } else if (item.getItemId() == R.id.menu_plans) {
            PlansDialog.showDialog(getSupportFragmentManager());
        } else if (item.getItemId() == R.id.menu_about) {
            AboutDialog.showDialog(getSupportFragmentManager());
        }
        return super.onOptionsItemSelected(item);
    }
}