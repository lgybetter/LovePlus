package adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.example.administrator.loveplus.R;
import java.util.List;
import beanclass.MessageBeanClass;

/**
 * Created by Administrator on 2016/7/22.
 */
public class MessageAdapter extends RecyclerView.Adapter<MessageAdapter.MessageViewHolder> {
    //上下文引入
    private Context context;
    //保存对象的信息列表
    private List<MessageBeanClass> dataList;
    public MessageAdapter(Context c, List<MessageBeanClass> d) {
        context = c;
        dataList = d;
    }
    @Override
    public MessageViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        MessageViewHolder messageViewHolder = (MessageViewHolder) parent.getTag();
        if(messageViewHolder == null)
        {
            messageViewHolder = new MessageViewHolder(LayoutInflater.
                    from(context).inflate(R.layout.activity_tab_message_item,parent,false));
        }
        return messageViewHolder;
    }

    @Override
    public void onBindViewHolder(MessageViewHolder holder, int position) {
        holder.name.setText(dataList.get(position).getName());
        holder.message.setText(dataList.get(position).getMessageText());
    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }

    class MessageViewHolder extends RecyclerView.ViewHolder
    {
        TextView name, message;
        public MessageViewHolder(View itemView) {
            super(itemView);
            name = (TextView) itemView.findViewById(R.id.tv_user_name);
            message = (TextView) itemView.findViewById(R.id.tv_user_message);
        }
    }
}
