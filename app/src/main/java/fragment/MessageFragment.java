package fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.administrator.loveplus.R;

import java.util.ArrayList;
import java.util.List;

import adapter.MessageAdapter;
import beanclass.MessageBeanClass;
import customview.DividerItemDecoration;

/**
 * Created by Administrator on 2016/7/21.
 */
public class MessageFragment extends Fragment {
    /**
     * 测试数据
     */
    private String[] nameTest = {"TOM","BOB","JAME"};
    private String[] messageTest = {"FUCK YOU","YOU GET OUT","ONE NIGHT"};

    private RecyclerView recyclerView;
    private View messageView;
    private MessageAdapter adapter;
    private MessageBeanClass messageBean;
    private List<MessageBeanClass> messageList = new ArrayList<>();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        super.onCreateView(inflater, container, savedInstanceState);
        messageView = inflater.inflate(R.layout.activity_tab_message, container,false);
        initData();
        initView();
        adapter = new MessageAdapter(getContext(),messageList);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(adapter);
        recyclerView.addItemDecoration(new DividerItemDecoration(getContext(),DividerItemDecoration.VERTICAL_LIST));
        return messageView;
    }

    private void initData() {
        messageList.clear();
        for(int i = 0; i < 3 ; i++) {
            //Bitmap bitmap = BitmapFactory.decodeResource(getResources(),imageTest[i]);
            String name = nameTest[i];
            String message = messageTest[i];
            messageBean = new MessageBeanClass(name,message);
            messageList.add(messageBean);
        }
    }

    private void initView() {
        recyclerView = (RecyclerView) messageView.findViewById(R.id.rv_message_list);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState){
        super.onActivityCreated(savedInstanceState);
    }
}