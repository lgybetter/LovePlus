package fragment;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.example.administrator.loveplus.R;

import java.util.ArrayList;
import java.util.List;

import adapter.ShareContentAdapter;
import beanclass.ShareContentBeanClass;
import customview.DividerItemDecoration;

/**
 * Created by Administrator on 2016/7/21.
 */
public class HomeFragment extends Fragment{
    /**
     *测试数据
     */
    private String[] fromNameArr = {"TOM","BOB","KATE"};
    private String[] textArr = {"It is a nice man!","So funny it is","Come to here"};
    private int[] imageSource = {
        R.drawable.vp_1,
        R.drawable.vp_2,
        R.drawable.vp_3,
        R.drawable.vp_4,
        R.drawable.vp_5
    };
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
        adapter = new ShareContentAdapter(getContext(),shareContentList);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.addItemDecoration(new DividerItemDecoration(getContext(),DividerItemDecoration.VERTICAL_LIST));
        recyclerView.setAdapter(adapter);
        return homeView;
    }

    private void initData() {
        shareContentList.clear();
        for(int i = 0; i < fromNameArr.length; i ++) {
            shareContentBeanClass = new ShareContentBeanClass(fromNameArr[i],textArr[i]);
            shareContentList.add(shareContentBeanClass);
        }
    }

    private void initView() {
        recyclerView = (RecyclerView) homeView.findViewById(R.id.rv_share_content);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState){
        super.onActivityCreated(savedInstanceState);
    }
}
