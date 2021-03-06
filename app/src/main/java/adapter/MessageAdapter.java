package adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.example.administrator.loveplus.R;
import java.util.List;
import beanclass.MessageBeanClass;
import eventInterface.MyItemClickListener;
import eventInterface.MyItemLongClickListener;
import holder.MessageViewHolder;

/**
 * Created by Administrator on 2016/7/22.
 */
public class MessageAdapter extends RecyclerView.Adapter<MessageViewHolder> {
    //上下文引入
    private Context context;
    //保存对象的信息列表
    private List<MessageBeanClass> dataList;
    private MyItemClickListener mItemClickListener;
    private MyItemLongClickListener mItemLongClickListener;

    public MessageAdapter(Context c, List<MessageBeanClass> d) {
        context = c;
        dataList = d;
    }
    @Override
    public MessageViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        MessageViewHolder messageViewHolder = (MessageViewHolder) parent.getTag();
        if(messageViewHolder == null) {
            messageViewHolder = new MessageViewHolder(LayoutInflater.
                    from(context).inflate(R.layout.activity_tab_message_item,parent,false),
                    mItemClickListener,mItemLongClickListener);
        }
        return messageViewHolder;
    }

    @Override
    public void onBindViewHolder(MessageViewHolder holder, int position) {
        holder.name.setText(dataList.get(position).getName());
        holder.message.setText(dataList.get(position).getMessageText());
        holder.time.setText(dataList.get(position).getTime());
    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }

    public void setOnItemClickListener(MyItemClickListener listener){
        this.mItemClickListener = listener;
    }

    public void setOnItemLongClickListener(MyItemLongClickListener listener){
        this.mItemLongClickListener = listener;
    }

}
