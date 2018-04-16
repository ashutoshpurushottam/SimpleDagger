package com.eigendaksh.simpledagger.welcome;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.eigendaksh.simpledagger.R;
import com.eigendaksh.simpledagger.base.MyApplication;
import com.eigendaksh.simpledagger.data.MessageGenerator;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

public class WelcomeActivity extends AppCompatActivity {

    @Inject
    MessageGenerator messageGenerator;

    @BindView(R.id.tvWelcome)
    TextView tvWelcome;
    @BindView(R.id.tvResult)
    TextView tvResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        MyApplication
                .getApp()
                .getMemberAppComponent()
                .newWelcomeActivityComponent(new MessageModule())
                .inject(this);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        ButterKnife.bind(this);

        ActionBar supportActionBar = getSupportActionBar();
        if(supportActionBar != null) {
            supportActionBar.setDisplayHomeAsUpEnabled(true);
            supportActionBar.setTitle(R.string.welcome);
        }

        tvResult.setText(getIntent().getStringExtra("result"));
        tvWelcome.setText(messageGenerator.getWelcomeMessage());
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }
}
