package fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;
import com.example.administrator.loveplus.R;
import java.util.ArrayList;
import java.util.List;
import adapter.ContactAdapter;
import beanclass.ContactBeanClass;
import eventInterface.MyItemClickListener;
import eventInterface.MyItemLongClickListener;

/**
 * Created by Administrator on 2016/7/21.
 */
public class ContactFragment extends Fragment implements MyItemClickListener, MyItemLongClickListener{
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
        adapter = new ContactAdapter(getContext(),contactsList);
        adapter.setOnItemClickListener(this);
        adapter.setOnItemLongClickListener(this);
        recyclerView.setAdapter(adapter);
    }

    private void initView() {
        recyclerView = (RecyclerView) contactsView.findViewById(R.id.rv_contacts_list);
        recyclerView.setLayoutManager(new GridLayoutManager(getContext(),3));
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState){
        super.onActivityCreated(savedInstanceState);
    }

    @Override
    public void onItemClick(View view, int postion) {
        ContactBeanClass contactBeanClass = contactsList.get(postion);
        if(contactBeanClass != null) {
            Toast.makeText(getContext(),"onItemClick" + postion,Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onItemLongClick(View view, int postion) {
        ContactBeanClass contactBeanClass = contactsList.get(postion);
        if(contactBeanClass != null) {
            Toast.makeText(getContext(),"onItemLongClick" + postion,Toast.LENGTH_SHORT).show();
        }
    }
}
