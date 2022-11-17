package org.tensorflow.lite.examples.detection.recruit;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.tensorflow.lite.examples.detection.R;
import org.tensorflow.lite.examples.detection.data.RecruitInfo;

import java.util.ArrayList;

//import com.google.android.gms.tasks.OnSuccessListener;
//import com.google.firebase.storage.FirebaseStorage;
//import com.google.firebase.storage.StorageReference;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.CustomViewHolder> {

    private ArrayList<RecruitInfo> arrayList;
    private Context mContext;
    private Context context;

    //Click 이벤트 구현
    /*private OnItemClickListener itemClickListener;

    public interface OnItemClickListener{
        void onItemClicked(View view, int position);
    }

    private void setOnItemClickListener(OnItemClickListener listener){
        this.itemClickListener = listener;
    }*/


    public CustomAdapter(ArrayList<RecruitInfo> arrayList, Context context) {
        this.arrayList = arrayList;

        this.mContext = context;
    }

    @NonNull
    @Override
    public CustomViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //listview가 담겨지면 view 생성
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.listview_recruit, parent, false);
        CustomViewHolder holder = new CustomViewHolder(view);
        context = parent.getContext();

        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull CustomViewHolder holder, int position) {
        //storage = FirebaseStorage.getInstance("gs://direct-plateau-367114.appspot.com"); //파이어베이스 스토리지 연동
        //storageReference = storage.getReference();


        //glide를 이용해 서버에서 이미지를 받는다
        /*Glide.with(holder.itemView)
                .load(arrayList.get(position).getImage())
                .into(holder.image_profile);*/

        //서버에서 text를 받는다
        holder.text_nm.setText(arrayList.get(position).getCon_nm());
        holder.text_sj.setText(arrayList.get(position).getSj());
        holder.text_qlfc.setText(arrayList.get(position).getQlfc_rqrmnt());
    }

    @Override
    public int getItemCount() {
        //arraylist가 null이 아니면 사이즈 반환
        return (arrayList != null ? arrayList.size() : 0);
    }

    public class CustomViewHolder extends RecyclerView.ViewHolder {
        //ImageView image_profile;
        //LinearLayout layout_panel;
        TextView text_nm;
        TextView text_sj;
        TextView text_qlfc;

        public CustomViewHolder(@NonNull View itemView) {
            super(itemView);
            //this.image_profile = itemView.findViewById(R.id.image_profile);
            //layout_panel = (LinearLayout)itemView.findViewById(R.id.layout_panel);
            this.text_nm = itemView.findViewById(R.id.text_nm);
            this.text_sj = itemView.findViewById(R.id.text_sj);
            this.text_qlfc = itemView.findViewById(R.id.text_qlfc);

            //아이템 클릭 시 (전체)
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    //클릭된 포지션 반환
                    int currposition = getAdapterPosition();
                    RecruitInfo recruitInfo = arrayList.get(currposition);
                    Toast.makeText(context, recruitInfo.getSj() + "\n", Toast.LENGTH_SHORT).show();
                    if (currposition != RecyclerView.NO_POSITION) {
                        Intent intent = new Intent(mContext, DetailActivity.class).addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                        intent.putExtra("no", recruitInfo.getNo()); // intent에 회사명 전달.
                        intent.putExtra("sj", recruitInfo.getSj().toString());
                        intent.putExtra("pos", currposition);
                        mContext.startActivity(intent);
                    }
                }
            });
        }
    }
}
