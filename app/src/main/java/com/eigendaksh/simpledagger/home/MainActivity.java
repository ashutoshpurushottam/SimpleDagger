package com.eigendaksh.simpledagger.home;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.eigendaksh.simpledagger.base.MyApplication;
import com.eigendaksh.simpledagger.data.MemberDataManager;
import com.eigendaksh.simpledagger.R;
import com.eigendaksh.simpledagger.di.MemberAppComponent;

import javax.inject.Inject;

public class MainActivity extends AppCompatActivity {

    @Inject MemberDataManager memberDataManager;

    private EditText memberId;
    private Button submitButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        MyApplication.getApp().getMemberAppComponent().inject(this);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ActionBar supportActionBar = getSupportActionBar();
        if(supportActionBar != null) {
            supportActionBar.setDisplayHomeAsUpEnabled(true);
        }

        memberId = findViewById(R.id.etMemberId);
        submitButton = findViewById(R.id.btnSubmit);


        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if ((memberId.getText().toString().equals(""))) {
                    showToast("Member Id is empty");
                } else {
                    String input = memberId.getText().toString();
                    String result = memberDataManager.checkMemberStatus(input);
                    showToast(result);
                }
            }
        });
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
