package com.eigendaksh.simpledagger.home;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.eigendaksh.simpledagger.base.MyApplication;
import com.eigendaksh.simpledagger.data.MemberDataManager;
import com.eigendaksh.simpledagger.R;
import com.eigendaksh.simpledagger.welcome.WelcomeActivity;

import javax.inject.Inject;
import javax.inject.Named;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @Inject @Named("local") MemberDataManager memberDataManager;
    @Inject @Named("dd-MMM-yy") String currentDate;

    @BindView(R.id.etMemberId) EditText memberId;
    @BindView(R.id.tvCount) TextView tvResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // Inject Dependency
        MyApplication.getApp().getMemberAppComponent().inject(this);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);

        ActionBar supportActionBar = getSupportActionBar();
        if(supportActionBar != null) {
            supportActionBar.setDisplayHomeAsUpEnabled(true);
        }

        tvResult.setText(currentDate);
    }

    @OnClick(R.id.btnSubmit)
    public void onClick() {
        if ((memberId.getText().toString().equals(""))) {
            showToast("Member Id is empty");
        } else {
            String input = memberId.getText().toString();
            String result = memberDataManager.checkMemberStatus(input);
            Intent intent = new Intent(this, WelcomeActivity.class);
            intent.putExtra("result", result);
            startActivity(intent);
        }
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }

    private void showToast(String message) {
        Toast toast = Toast.makeText(this, message, Toast.LENGTH_SHORT);
        toast.setGravity(Gravity.CENTER, 0, 0);
        toast.show();
    }
}
