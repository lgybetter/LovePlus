package holder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.example.administrator.loveplus.R;

import eventInterface.MyItemClickListener;
import eventInterface.MyItemLongClickListener;

/**
 * Created by Administrator on 2016/7/28.
 */
public class MessageViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener,View.OnLongClickListener
{
    private MyItemClickListener mListener;
    private MyItemLongClickListener mLongListener;
    public TextView name, message,time;
    public MessageViewHolder(View itemView,MyItemClickListener listener,MyItemLongClickListener longListener) {
        super(itemView);
        this.mListener = listener;
        this.mLongListener = longListener;
        initView();
    }

    private void initView() {
        time = (TextView) itemView.findViewById(R.id.tv_time);
        name = (TextView) itemView.findViewById(R.id.tv_user_name);
        message = (TextView) itemView.findViewById(R.id.tv_user_message);
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
