package adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.administrator.loveplus.R;

import java.util.List;

import beanclass.ContactBeanClass;
import eventInterface.MyItemClickListener;
import eventInterface.MyItemLongClickListener;
import holder.ContactHolder;

/**
 * Created by Administrator on 2016/7/23.
 */
public class ContactAdapter extends RecyclerView.Adapter<ContactHolder> {
    //保存对象的信息列表
    private List<ContactBeanClass> dataList;
    //上下文引入
    Context context;
    private MyItemClickListener mItemClickListener;
    private MyItemLongClickListener mItemLongClickListener;

    public ContactAdapter(Context context,List<ContactBeanClass> dataList) {
        this.context = context;
        this.dataList = dataList;
    }
    @Override
    public ContactHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        ContactHolder contactHolder = (ContactHolder) parent.getTag();
        if(contactHolder == null) {
            contactHolder = new ContactHolder(LayoutInflater.from(context).
                    inflate(R.layout.activity_tab_contacts_item,parent,false),
                    mItemClickListener,mItemLongClickListener);
        }
        return contactHolder;
    }

    @Override
    public void onBindViewHolder(ContactHolder holder, int position) {
        holder.contactName.setText(dataList.get(position).getUserName());
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
