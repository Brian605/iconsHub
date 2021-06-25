package org.icons.iconshub;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ViewFlipper;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {
    @BindView(R2.id.flipper)
    ViewFlipper viewFlipper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        Animation animationIn= AnimationUtils.loadAnimation(MainActivity.this,R.anim.animin);
        Animation animationOut=AnimationUtils.loadAnimation(MainActivity.this,R.anim.animout);

        viewFlipper.setInAnimation(animationIn);
        viewFlipper.setOutAnimation(animationOut);

        viewFlipper.setFlipInterval(5000);
        viewFlipper.setAutoStart(true);
        viewFlipper.startFlipping();
    }
}