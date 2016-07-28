package adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.example.administrator.loveplus.R;
import java.util.List;
import beanclass.ShareContentBeanClass;
import eventInterface.MyItemClickListener;
import eventInterface.MyItemLongClickListener;
import holder.ShareContentHolder;

/**
 * Created by Administrator on 2016/7/25.
 */
public class ShareContentAdapter extends RecyclerView.Adapter<ShareContentHolder> {
    //上下文引入
    private Context context;
    //保存对象的信息列表
    private List<ShareContentBeanClass> dataList;
    private MyItemClickListener mItemClickListener;
    private MyItemLongClickListener mItemLongClickListener;
    public ShareContentAdapter(Context context,List<ShareContentBeanClass> dataList) {
        this.context = context;
        this.dataList = dataList;
    }
    @Override
    public ShareContentHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        ShareContentHolder shareContentHolder = (ShareContentHolder) parent.getTag();
        if(shareContentHolder == null) {
            shareContentHolder = new ShareContentHolder(LayoutInflater.from(context).
                    inflate(R.layout.activity_tab_home_share_item,parent,false),
                    mItemClickListener,mItemLongClickListener);
        }
        return shareContentHolder;
    }

    @Override
    public void onBindViewHolder(ShareContentHolder holder, int position) {
        holder.fromName.setText(dataList.get(position).getFromPerson());
        holder.shareText.setText(dataList.get(position).getMessageText());
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
