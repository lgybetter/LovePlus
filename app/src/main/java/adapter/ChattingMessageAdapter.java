package adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.example.administrator.loveplus.R;

import java.util.List;

import beanclass.MessageBeanClass;
import holder.ChattingMessageHolder;

/**
 * Created by Administrator on 2016/7/29.
 */
public class ChattingMessageAdapter extends RecyclerView.Adapter<ChattingMessageHolder> {
    private static int MESSAGE_SEND = 0;
    private static int MESSAGE_RECIVE = 1;
    private Context context;
    private List<MessageBeanClass> dataList;
    public ChattingMessageAdapter(Context context,List<MessageBeanClass> dataList) {
        this.context = context;
        this.dataList = dataList;
    }
    @Override
    public ChattingMessageHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        ChattingMessageHolder chattingMessageHolder = (ChattingMessageHolder) parent.getTag();
        if(chattingMessageHolder == null) {
            if(viewType == MESSAGE_SEND) {
                chattingMessageHolder = new ChattingMessageHolder(LayoutInflater.from(context).
                        inflate(R.layout.activity_chatting_send_message_item,parent,false));
            } else if(viewType == MESSAGE_RECIVE) {
                chattingMessageHolder = new ChattingMessageHolder(LayoutInflater.from(context).
                        inflate(R.layout.activity_chatting_recive_message_item,parent,false));
            }
        }
        return chattingMessageHolder;
    }

    @Override
    public void onBindViewHolder(ChattingMessageHolder holder, int position) {
        holder.chattingText.setText(dataList.get(position).getMessageText());
    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }

    @Override
    public int getItemViewType(int position) {
        return dataList.get(position).getType();
    }
}
