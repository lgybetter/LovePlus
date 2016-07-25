package com.example.administrator.loveplus;
import android.content.Intent;
import android.graphics.Color;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.LinearLayout;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.List;
import adapter.FragmentAdapter;
import fragment.AgreementFragment;
import fragment.MessageFragment;
import fragment.ContactFragment;
import fragment.HomeFragment;
import fragment.SettingFragment;
import regiest_login.RegiestLoginActivity;


public class MainActivity extends AppCompatActivity implements ViewPager.OnPageChangeListener,View.OnClickListener{
    private ViewPager viewPager;
    private LinearLayout messageLayout,contactsLayout,homeLayout,agreementLayout,settingLayout;
    private List<Fragment> mFragmentList = new ArrayList<>();
    private FragmentAdapter mFragmentAdapter;

    /**
     * Tab显示内容TextView
     */
    private TextView messageTV, contactsTV, homeTV, agreementTV, settingTV;

    /**
     * Fragment
     */
    private MessageFragment messageFragment;
    private HomeFragment homeFragment;
    private ContactFragment contactsFragment;
    private AgreementFragment agreementFragment;
    private SettingFragment settingFragment;

    /**
     * ViewPager的当前选中页
     */
    private int currentIndex = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        initView();
        initFragment();
        viewPager.addOnPageChangeListener(this);
        messageLayout.setOnClickListener(this);
        contactsLayout.setOnClickListener(this);
        homeLayout.setOnClickListener(this);
        agreementLayout.setOnClickListener(this);
        settingLayout.setOnClickListener(this);
    }

    private void initFragment() {
        homeFragment = new HomeFragment();
        contactsFragment = new ContactFragment();
        messageFragment = new MessageFragment();
        agreementFragment = new AgreementFragment();
        settingFragment = new SettingFragment();
        mFragmentList.add(messageFragment);
        mFragmentList.add(contactsFragment);
        mFragmentList.add(homeFragment);
        mFragmentList.add(agreementFragment);
        mFragmentList.add(settingFragment);
        mFragmentAdapter = new FragmentAdapter(this.getSupportFragmentManager(), mFragmentList);
        viewPager.setAdapter(mFragmentAdapter);
        viewPager.setCurrentItem(0);
        messageTV.setTextColor(Color.BLUE);
    }

    private void initView() {
        contactsTV = (TextView) findViewById(R.id.tv_contacts);
        messageTV = (TextView) findViewById(R.id.tv_message);
        homeTV = (TextView) findViewById(R.id.tv_home);
        agreementTV = (TextView) findViewById(R.id.tv_agreement);
        settingTV = (TextView) findViewById(R.id.tv_setting);
        viewPager = (ViewPager) findViewById(R.id.id_page_vp);
        messageLayout = (LinearLayout) findViewById(R.id.ll_message);
        contactsLayout = (LinearLayout) findViewById(R.id.ll_contacts);
        homeLayout = (LinearLayout) findViewById(R.id.ll_home);
        agreementLayout = (LinearLayout) findViewById(R.id.ll_agreement);
        settingLayout = (LinearLayout) findViewById(R.id.ll_setting);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.ll_message:
                viewPager.setCurrentItem(0);
                break;
            case R.id.ll_contacts:
                viewPager.setCurrentItem(1);
                break;
            case R.id.ll_home:
                viewPager.setCurrentItem(2);
                break;
            case R.id.ll_agreement:
                viewPager.setCurrentItem(3);
                break;
            case R.id.ll_setting:
                viewPager.setCurrentItem(4);
                break;
            default:
                break;
        }
    }

    /**
     * 创建菜单栏
     */
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    /**
     * 菜单栏点击事件
     */
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        switch (id) {
            case R.id.action_add:
                return true;
            case R.id.action_search:
                Intent intent = new Intent();
                intent.setClass(getApplicationContext(),RegiestLoginActivity.class);
                startActivity(intent);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    /**
     * position :当前页面，及你点击滑动的页面 offset:当前页面偏移的百分比
     * offsetPixels:当前页面偏移的像素位置
     */
    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {
        resetTextView();
        switch (position) {
            case 0:
                messageTV.setTextColor(Color.BLUE);
                break;
            case 1:
                contactsTV.setTextColor(Color.BLUE);
                break;
            case 2:
                homeTV.setTextColor(Color.BLUE);
                break;
            case 3:
                agreementTV.setTextColor(Color.BLUE);
                break;
            case 4:
                settingTV.setTextColor(Color.BLUE);
                break;
            default:
                break;
        }
        currentIndex = position;
    }

    /**
     * state滑动中的状态 有三种状态（0，1，2） 1：正在滑动 2：滑动完毕 0：什么都没做。
     */
    @Override
    public void onPageScrollStateChanged(int state) {

    }

    /**
     * 重置颜色
     */
    private void resetTextView() {
        messageTV.setTextColor(Color.BLACK);
        homeTV.setTextColor(Color.BLACK);
        contactsTV.setTextColor(Color.BLACK);
        agreementTV.setTextColor(Color.BLACK);
        settingTV.setTextColor(Color.BLACK);
    }
}
