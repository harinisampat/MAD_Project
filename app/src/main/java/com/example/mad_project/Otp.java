package com.example.mad_project;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.*;
import android.text.InputType;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.EditText;

import com.bumptech.glide.Glide;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseException;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.PhoneAuthOptions;
import com.google.firebase.auth.PhoneAuthProvider;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.TimeUnit;


public class Otp extends AppCompatActivity {

    ImageView otpgif;
    EditText txt_otp;
    Button btn_verify;
    TextView tv_resend;
    String phonenumber;
    Long timeoutSeconds = 60L;
    String verificationCode;// for verifying the otp
    PhoneAuthProvider.ForceResendingToken resendingToken;// for resending the otp
    FirebaseAuth mAuth = FirebaseAuth.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.otp);

        btn_verify = findViewById(R.id.btn_verify);
        txt_otp = findViewById(R.id.txt_otp);
        tv_resend = findViewById(R.id.tv_resend);
        otpgif = findViewById(R.id.otpgif);

        Glide.with(this).load(R.drawable.otpgif).into(otpgif);

        phonenumber = getIntent().getExtras().getString("Phone");
        sendOtp(phonenumber, false);

        btn_verify.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                String enteredOtp = txt_otp.getText().toString();
                PhoneAuthCredential credential = PhoneAuthProvider.getCredential(verificationCode, enteredOtp);
                signIn(credential);
                setInProgress(true);
            }
        });

        tv_resend.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                sendOtp(phonenumber,true);
            }
        });
    }

    void sendOtp(String phoneNumber, boolean isResend)
    {
        startResendTimer();
        setInProgress(true);
        PhoneAuthOptions.Builder builder =
                PhoneAuthOptions.newBuilder(mAuth)
                        .setPhoneNumber(phoneNumber)
                        .setTimeout(timeoutSeconds, TimeUnit.SECONDS)
                        .setActivity(this)
                        .setCallbacks(new PhoneAuthProvider.OnVerificationStateChangedCallbacks() {
                            @Override
                            public void onVerificationCompleted(@NonNull PhoneAuthCredential phoneAuthCredential) {
                                signIn(phoneAuthCredential);
                                setInProgress(false);
                            }

                            @Override
                            public void onVerificationFailed(@NonNull FirebaseException e) {
                                Toast.makeText(getApplicationContext(),"OTP Verification Failed",Toast.LENGTH_LONG).show();
                                setInProgress(false);
                            }

                            @Override
                            public void onCodeSent(@NonNull String s, @NonNull PhoneAuthProvider.ForceResendingToken forceResendingToken) {
                                super.onCodeSent(s, forceResendingToken);
                                verificationCode = s;
                                resendingToken = forceResendingToken;
                                Toast.makeText(getApplicationContext(),"OTP sent successfully",Toast.LENGTH_LONG).show();
                                setInProgress(false);
                            }
                        });

        if(isResend)
        {
            PhoneAuthProvider.verifyPhoneNumber(builder.setForceResendingToken(resendingToken).build());
        }
        else
        {
            PhoneAuthProvider.verifyPhoneNumber(builder.build());
        }
    }

    void setInProgress(boolean inProgress)
    {
        if(inProgress)
        {
            btn_verify.setVisibility(View.GONE);
        }
        else
        {
            btn_verify.setVisibility(View.VISIBLE);
        }
    }

    void signIn(PhoneAuthCredential phoneAuthCredential)
    {
        setInProgress(true);
        mAuth.signInWithCredential(phoneAuthCredential).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                setInProgress(false);
                if(task.isSuccessful())
                {
                    Intent intent = new Intent(Otp.this, CompleteProfile.class);
                    intent.putExtra("phone",phonenumber);
                    startActivity(intent);
                }
                else
                {
                    Toast.makeText(Otp.this, "OTP verification failed", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    void startResendTimer(){
        tv_resend.setEnabled(false);
        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        timeoutSeconds--;
                        if (timeoutSeconds <= 0) {
                            timeoutSeconds=60L;
                            timer.cancel();
                            tv_resend.setText("Resend OTP");
                            tv_resend.setEnabled(true);
                        } else {
                            tv_resend.setText("Resend OTP in " + timeoutSeconds + " seconds");
                        }
                    }
                });
            }
        }, 0, 1000);
    }
}