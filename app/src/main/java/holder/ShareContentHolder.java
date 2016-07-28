package holder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.administrator.loveplus.R;

import eventInterface.MyItemClickListener;
import eventInterface.MyItemLongClickListener;

/**
 * Created by Administrator on 2016/7/28.
 */
public class ShareContentHolder extends RecyclerView.ViewHolder implements View.OnClickListener,View.OnLongClickListener{
    private MyItemLongClickListener mLongListener;
    private MyItemClickListener mListener;
    public TextView fromName , shareText;
    public Button showVideo,shareEnter;
    public ShareContentHolder(View itemView,MyItemClickListener mListener,MyItemLongClickListener mLongListener) {
        super(itemView);
        this.mListener = mListener;
        this.mLongListener = mLongListener;
        initView();
    }

    private void initView() {
        shareEnter = (Button) itemView.findViewById(R.id.bn_share_enter);
        showVideo = (Button) itemView.findViewById(R.id.bn_share_show_video);
        fromName = (TextView) itemView.findViewById(R.id.tv_share_from_name);
        shareText = (TextView) itemView.findViewById(R.id.tv_share_text);
//        itemView.setOnClickListener(this);
//        itemView.setOnLongClickListener(this);
        shareEnter.setOnClickListener(this);
        showVideo.setOnClickListener(this);
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
