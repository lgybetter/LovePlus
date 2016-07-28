package holder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.administrator.loveplus.R;

import eventInterface.MyItemClickListener;
import eventInterface.MyItemLongClickListener;

/**
 * Created by Administrator on 2016/7/28.
 */
public class ContactHolder extends RecyclerView.ViewHolder implements View.OnClickListener,View.OnLongClickListener{
    private MyItemClickListener mListener;
    private MyItemLongClickListener mLongListener;
    public TextView contactName;
    public ImageView contactImage;
    //        private Button sendSms,startPhone,startVideo;
    public ContactHolder(View itemView,MyItemClickListener mListener,MyItemLongClickListener mLongListener) {
        super(itemView);
        this.mListener = mListener;
        this.mLongListener = mLongListener;
        initView();
    }

    private void initView() {
//            sendSms = (Button) itemView.findViewById(R.id.bn_send_message);
//            startPhone = (Button) itemView.findViewById(R.id.bn_start_phone);
//            startVideo = (Button) itemView.findViewById(R.id.bn_start_video);
        contactName = (TextView) itemView.findViewById(R.id.tv_contacts_name);
        itemView.setBackgroundResource(R.drawable.recycle_view_card_background);
        itemView.setOnClickListener(this);
        itemView.setOnLongClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if(mListener != null) {
            mListener.onItemClick(view,getAdapterPosition());
        }
    }

    @Override
    public boolean onLongClick(View view) {
        if(mLongListener != null) {
            mLongListener.onItemLongClick(view,getAdapterPosition());
        }
        return true;
    }
}