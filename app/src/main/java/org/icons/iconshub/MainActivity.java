package org.icons.iconshub;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ViewFlipper;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.appbar.MaterialToolbar;

import org.icons.iconshub.fragments.CoWorkingDialog;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {
    @BindView(R2.id.flipper)
    ViewFlipper viewFlipper;

    @BindView(R2.id.toolBar)
    MaterialToolbar toolBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        setSupportActionBar(toolBar);

        Animation animationIn= AnimationUtils.loadAnimation(MainActivity.this,R.anim.animin);
        Animation animationOut=AnimationUtils.loadAnimation(MainActivity.this,R.anim.animout);

        viewFlipper.setInAnimation(animationIn);
        viewFlipper.setOutAnimation(animationOut);

        viewFlipper.setFlipInterval(5000);
        viewFlipper.setAutoStart(true);
        viewFlipper.startFlipping();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId()==R.id.menu_co_working){
            CoWorkingDialog.showDialog(getSupportFragmentManager());
        }
        return super.onOptionsItemSelected(item);
    }
}