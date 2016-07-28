package activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import com.example.administrator.loveplus.R;

import java.util.ArrayList;
import java.util.List;

import adapter.ChattingMessageAdapter;
import beanclass.MessageBeanClass;

/**
 * Created by Administrator on 2016/7/29.
 */
public class ChattingActivity extends AppCompatActivity {
    /***
     * 测试数据
     */
    String[] messageText = {"你最近好吗？","还行吧！","今晚有空吗？","有空啊"};
    int[] messageType = {0,1,0,1};

    private RecyclerView recyclerView;
    private ChattingMessageAdapter adapter;
    private MessageBeanClass messageBeanClass;
    private List<MessageBeanClass> messageList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chatting_layout);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        initView();
        initData();
    }

    private void initData() {
        for(int i = 0; i < messageText.length; i ++) {
            messageBeanClass = new MessageBeanClass("Bob",messageText[i],"昨天", messageType[i]);
            messageList.add(messageBeanClass);
        }
        adapter = new ChattingMessageAdapter(getApplicationContext(),messageList);
        recyclerView.setAdapter(adapter);
    }

    private void initView() {
        recyclerView = (RecyclerView) findViewById(R.id.rv_chatting_message_list);
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
    }
}
