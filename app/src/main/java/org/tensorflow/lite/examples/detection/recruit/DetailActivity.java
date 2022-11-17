package org.tensorflow.lite.examples.detection.recruit;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import org.tensorflow.lite.examples.detection.R;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import org.tensorflow.lite.examples.detection.data.RecruitInfo;
import org.w3c.dom.Text;

import java.util.ArrayList;

public class DetailActivity extends AppCompatActivity {

    private int pos;
    private int code;
    private String  str;

    private RecruitInfo recruitInfo;

    private FirebaseDatabase database;
    private DatabaseReference databaseReference;

    private TextView tv_title;
    private TextView tv_company;
    private TextView tv_address;
    private TextView tv_info;
    private TextView tv_wadge;
    private TextView tv_hr_form;
    private TextView tv_duty;
    private TextView tv_prfml;
    private TextView tv_mthd;
    private TextView tv_dday;
    private TextView tv_tel;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        Intent intent = getIntent();

        database = FirebaseDatabase.getInstance();
        databaseReference = database.getReference("FVA/RecruitInfo/items");

        tv_title = findViewById(R.id.tv_title);
        tv_company = findViewById(R.id.tv_company);
        tv_address = findViewById(R.id.tv_address);
        tv_info = findViewById(R.id.tv_info);
        tv_wadge = findViewById(R.id.tv_wadge);
        tv_hr_form = findViewById(R.id.tv_hr_form);
        tv_duty = findViewById(R.id.tv_duty);
        tv_prfml = findViewById(R.id.tv_prfml);
        tv_mthd = findViewById(R.id.tv_mthd);
        tv_dday = findViewById(R.id.tv_dday);
        tv_tel = findViewById(R.id.tv_tel);

        code = intent.getIntExtra("no", -1);
        pos = intent.getIntExtra("pos", -1);

        //Toast.makeText(this, str + "\n", Toast.LENGTH_SHORT).show();
        //tv_company.setText(str);

        databaseReference.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for(DataSnapshot temp : snapshot.getChildren()){
                    if(temp.getValue(RecruitInfo.class).getNo()==code){
                        recruitInfo=temp.getValue(RecruitInfo.class);
                        tv_title.setText(recruitInfo.getSj());
                        tv_company.setText(recruitInfo.getCon_nm());
                        tv_address.setText(recruitInfo.getAddr());
                        tv_info.setText(recruitInfo.getEmplymt_form());
                        tv_wadge.setText(recruitInfo.getWadge_cdn());
                        tv_hr_form.setText(recruitInfo.getWork_hr_form());
                        tv_duty.setText(recruitInfo.getDuty_cn());
                        tv_prfml.setText(recruitInfo.getQlfc_rqrmnt());
                        tv_mthd.setText(recruitInfo.getRcpt_mthd());
                        tv_dday.setText(recruitInfo.getRcpt_ddln_day());
                        tv_tel.setText(recruitInfo.getTelno());
                    }
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

    }
}