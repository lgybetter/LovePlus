package fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.administrator.loveplus.R;

import java.util.ArrayList;
import java.util.List;

import adapter.MessageAdapter;
import beanclass.MessageBeanClass;
import customview.DividerItemDecoration;
import eventInterface.MyItemClickListener;
import eventInterface.MyItemLongClickListener;

/**
 * Created by Administrator on 2016/7/21.
 */
public class MessageFragment extends Fragment implements MyItemClickListener, MyItemLongClickListener{
    /**
     * 测试数据
     */
    private String[] nameTest = {"TOM","BOB","JAME"};
    private String[] messageTest = {"FUCK YOU","YOU GET OUT","ONE NIGHT"};
    private String[] timeTest = {"2小时前","昨天","2016-12-31"};
    private RecyclerView recyclerView;
    private View messageView;
    private MessageAdapter adapter;
    private MessageBeanClass messageBean;
    private List<MessageBeanClass> messageList = new ArrayList<>();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        super.onCreateView(inflater, container, savedInstanceState);
        messageView = inflater.inflate(R.layout.activity_tab_message, container,false);
        initView();
        initData();
        return messageView;
    }

    private void initData() {
        messageList.clear();
        for(int i = 0; i < 3 ; i++) {
            //Bitmap bitmap = BitmapFactory.decodeResource(getResources(),imageTest[i]);
            String name = nameTest[i];
            String message = messageTest[i];
            String time = timeTest[i];
            messageBean = new MessageBeanClass(name,message,time);
            messageList.add(messageBean);
        }
        adapter = new MessageAdapter(getContext(),messageList);
        recyclerView.setAdapter(adapter);
        adapter.setOnItemClickListener(this);
        adapter.setOnItemLongClickListener(this);
    }

    private void initView() {
        recyclerView = (RecyclerView) messageView.findViewById(R.id.rv_message_list);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.addItemDecoration(new DividerItemDecoration(getContext(),DividerItemDecoration.VERTICAL_LIST));
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState){
        super.onActivityCreated(savedInstanceState);
    }

    @Override
    public void onItemClick(View view, int postion) {
        MessageBeanClass messageBeanClass = messageList.get(postion);
        if(messageBeanClass != null) {
            Toast.makeText(getContext(),"onItemClick" + postion,Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onItemLongClick(View view, int postion) {
        MessageBeanClass messageBeanClass = messageList.get(postion);
        if(messageBeanClass != null) {
            Toast.makeText(getContext(),"onItemLongClick" + postion,Toast.LENGTH_SHORT).show();
        }
    }
}