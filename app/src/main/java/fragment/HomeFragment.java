package fragment;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.administrator.loveplus.R;
import java.util.ArrayList;
import java.util.List;
import adapter.ShareContentAdapter;
import beanclass.ShareContentBeanClass;
import customview.DividerItemDecoration;
import eventInterface.MyItemClickListener;
import eventInterface.MyItemLongClickListener;


/**
 * Created by Administrator on 2016/7/21.
 */
public class HomeFragment extends Fragment implements MyItemLongClickListener, MyItemClickListener{
    /**
     *测试数据
     */

    private String[] fromNameArr = {"TOM","BOB","KATE"};
    private String[] textArr = {"It is a nice man!","So funny it is","Come to here"};

    private View homeView;
    private RecyclerView recyclerView;
    private ShareContentAdapter adapter;
    private ShareContentBeanClass shareContentBeanClass;
    private List<ShareContentBeanClass> shareContentList = new ArrayList<>();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        super.onCreateView(inflater, container, savedInstanceState);
        homeView = inflater.inflate(R.layout.activity_tab_home, container,false);
        initView();
        initData();
        return homeView;
    }

    private void initData() {
        shareContentList.clear();
        for(int i = 0; i < fromNameArr.length; i ++) {
            shareContentBeanClass = new ShareContentBeanClass(fromNameArr[i],textArr[i]);
            shareContentList.add(shareContentBeanClass);
        }
        adapter = new ShareContentAdapter(getContext(),shareContentList);
        recyclerView.setAdapter(adapter);
        adapter.setOnItemClickListener(this);
        adapter.setOnItemLongClickListener(this);
    }

    private void initView() {
        recyclerView = (RecyclerView) homeView.findViewById(R.id.rv_share_content);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.addItemDecoration(new DividerItemDecoration(getContext(),DividerItemDecoration.VERTICAL_LIST));
    }


    @Override
    public void onActivityCreated(Bundle savedInstanceState){
        super.onActivityCreated(savedInstanceState);
    }

    @Override
    public void onItemClick(View view, int postion) {
        ShareContentBeanClass shareContentBeanClass = shareContentList.get(postion);
        if(shareContentBeanClass != null) {
            switch (view.getId()) {
                case R.id.bn_share_enter:
                    Toast.makeText(getContext(),"onItemClick " + postion +" " + view.getId(),Toast.LENGTH_SHORT).show();
                    break;
                case R.id.bn_share_show_video:
                    Toast.makeText(getContext(),"onItemClick " + postion +" " + view.getId(),Toast.LENGTH_SHORT).show();
                    break;
                default:
                    break;
            }
            //Toast.makeText(getContext(),"onItemClick " ,Toast.LENGTH_SHORT).show();
        }

    }

    @Override
    public void onItemLongClick(View view, int postion) {
        ShareContentBeanClass shareContentBeanClass = shareContentList.get(postion);
        if(shareContentBeanClass != null) {
            switch (view.getId()) {
                case R.id.bn_share_enter:
                    Toast.makeText(getContext(),"onItemLongClick " + postion +" " + view.getId(),Toast.LENGTH_SHORT).show();
                    break;
                case R.id.bn_share_show_video:
                    Toast.makeText(getContext(),"onItemLongClick " + postion +" " + view.getId(),Toast.LENGTH_SHORT).show();
                    break;
                default:
                    break;
            }
            //Toast.makeText(getContext(),"onItemLongClick ",Toast.LENGTH_SHORT).show();
        }

    }
}
