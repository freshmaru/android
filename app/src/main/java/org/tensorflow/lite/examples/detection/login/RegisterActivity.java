package org.tensorflow.lite.examples.detection.login;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import org.tensorflow.lite.examples.detection.R;
import org.tensorflow.lite.examples.detection.data.UserAccount;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class RegisterActivity extends AppCompatActivity {

    private FirebaseAuth mFirebaseAuth;                 // 파이어베이스 인증 처리
    private DatabaseReference mDatabaseRef;             // 실시간 데이터베이스 연동
    private EditText mEtEmail, mEtPwd, mEtName, mEtAge;  //회원가입 입력필드
    private Button mBtnRegister;                         //회원가입 버튼

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        mFirebaseAuth = FirebaseAuth.getInstance();
        mDatabaseRef = FirebaseDatabase.getInstance().getReference("FVA");

        mEtEmail = findViewById(R.id.et_email);
        mEtPwd = findViewById(R.id.et_pw);
        mEtName = findViewById(R.id.et_name);
        mEtAge = findViewById(R.id.et_age);

        mBtnRegister = findViewById(R.id.bt_register2);
        mBtnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //회원가입 처리 시작
                String strEmail = mEtEmail.getText().toString(); //문자열로 변환된 입력값 저장
                String strPwd = mEtPwd.getText().toString();
                String strName = mEtName.getText().toString();
                String strAge = mEtAge.getText().toString();

                //Firebase Auth 진행
                mFirebaseAuth.createUserWithEmailAndPassword(strEmail, strPwd).addOnCompleteListener(RegisterActivity.this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()){
                            FirebaseUser firebaseuser = mFirebaseAuth.getCurrentUser();
                            UserAccount account = new UserAccount();
                            account.setIdToken(firebaseuser.getUid());
                            account.setEmailId(firebaseuser.getEmail());
                            account.setPassword(strPwd);
                            account.setUserName(strName);
                            account.setAge(strAge);

                            // setValue : database에 insert
                            mDatabaseRef.child("UserAccount").child(firebaseuser.getUid()).setValue(account);

                            Toast.makeText(RegisterActivity.this, "회원가입에 성공하였습니다", Toast.LENGTH_SHORT).show();
                        }
                        else{
                            Toast.makeText(RegisterActivity.this, "회원가입에 실패하였습니다", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
            }
        });
    }
}