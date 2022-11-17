package org.tensorflow.lite.examples.detection.recruit;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import org.tensorflow.lite.examples.detection.R;
import org.tensorflow.lite.examples.detection.data.RecruitInfo;

import java.util.ArrayList;

public class InfoActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutManager;
    private ArrayList<RecruitInfo> arrayList;
    private FirebaseDatabase database;
    private DatabaseReference databaseReference;

    private CustomAdapter customAdapter;
    //private FirebaseStorge storge;
    //private StorageReference storageReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);

        recyclerView = findViewById(R.id.recyclerView);     //리사이클러 뷰 연결
        recyclerView.setHasFixedSize(true);     //리사이클러 뷰 성능 강화
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        arrayList = new ArrayList<>();      //객체를 담을 arraylist

        database = FirebaseDatabase.getInstance();  //파이어베이스 데이터베이스 연동
        databaseReference = database.getReference("FVA/RecruitInfo/items"); //DB 테이블 연동

        databaseReference.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                //데이터베이스 데이터 가져오기
                arrayList.clear(); //배열 초기화
                for(DataSnapshot snapshot : dataSnapshot.getChildren()){
                    //반복문으로 데이터 리스트 추출
                    RecruitInfo recruitInfo = snapshot.getValue(RecruitInfo.class); //RecruitInfo에 객체 담기
                    Log.d("dd",recruitInfo.toString());
                    arrayList.add(recruitInfo); //담은 데이터를 배열리스트에 넣고 리사이클러뷰로 보낼 준비
                }
                adapter.notifyDataSetChanged(); // 리스트 저장 및 새로고침
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                //에러 처리
                Log.e("InfoActivity", String.valueOf(databaseError.toException()));
            }
        });
        
        adapter = new CustomAdapter(arrayList, this);
        recyclerView.setAdapter(adapter);  //리사이클러뷰 adapter 연결
        
    }
}