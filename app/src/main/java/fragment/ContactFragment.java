package fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.example.administrator.loveplus.R;

import java.util.ArrayList;
import java.util.List;
import adapter.ContactAdapter;
import beanclass.ContactBeanClass;
import customview.DividerGridItemDecoration;

/**
 * Created by Administrator on 2016/7/21.
 */
public class ContactFragment extends Fragment {
    /**
     * 测试数据
    * */
    private String [] name = {"TOM","BOB","JAME","LGY","KAE","JAKE"};

    private RecyclerView recyclerView;
    private View contactsView;
    private ContactAdapter adapter;
    private ContactBeanClass contactBeanClass;
    private List<ContactBeanClass> contactsList = new ArrayList<>();
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        super.onCreateView(inflater, container, savedInstanceState);
        contactsView = inflater.inflate(R.layout.activity_tab_contacts, container,false);
        initView();
        initData();
        adapter = new ContactAdapter(getContext(),contactsList);
        recyclerView.setLayoutManager(new GridLayoutManager(getContext(),3));
        recyclerView.setAdapter(adapter);
        //recyclerView.addItemDecoration(new DividerGridItemDecoration(getContext()));
        return contactsView;
    }

    private void initData() {
        contactsList.clear();
        for(int i = 0;i < name.length; i ++) {
            String nameStr = name[i];
            contactBeanClass = new ContactBeanClass(nameStr,null,null,null,null);
            contactsList.add(contactBeanClass);
        }
    }

    private void initView() {
        recyclerView = (RecyclerView) contactsView.findViewById(R.id.rv_contacts_list);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState){
        super.onActivityCreated(savedInstanceState);
    }
}
