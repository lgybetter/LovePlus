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
    /**
     * 屏幕的宽度
     */
    private int screenWidth;
    //private FloatingActionButton fab;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        initView();
        initFragment();
        //initTabLineWidth();
        //fab.setOnClickListener(this);
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
        //fab = (FloatingActionButton) findViewById(R.id.fab);
        contactsTV = (TextView) findViewById(R.id.tv_contacts);
        messageTV = (TextView) findViewById(R.id.tv_message);
        homeTV = (TextView) findViewById(R.id.tv_home);
        agreementTV = (TextView) findViewById(R.id.tv_agreement);
        settingTV = (TextView) findViewById(R.id.tv_setting);
        //mTabLineIv = (ImageView) this.findViewById(R.id.id_tab_line_iv);
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
//            case R.id.fab:
//                Intent intent = new Intent();
//                intent.setClass(getApplicationContext(), RegiestLoginActivity.class);
//                startActivity(intent);
//                break;
            default:
                break;
        }
    }

    /**
     * 创建菜单栏
     * @param menu
     * @return
     */
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    /**
     * 菜单栏点击事件
     * @param item
     * @return
     */
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        //noinspection SimplifiableIfStatement
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
//        LinearLayout.LayoutParams lp = (LinearLayout.LayoutParams) mTabLineIv
//                .getLayoutParams();
//
//        Log.e("offset:", positionOffset + "");
//        /**
//         * 利用currentIndex(当前所在页面)和position(下一个页面)以及offset来
//         * 设置mTabLineIv的左边距 滑动场景：
//         * 记3个页面,
//         * 从左到右分别为0,1,2
//         * 0->1; 1->2; 2->1; 1->0
//         */
//        if (currentIndex == 0 && position == 0)// 0->1
//        {
//            lp.leftMargin = (int) (positionOffset * (screenWidth * 1.0 / 3) + currentIndex
//                    * (screenWidth / 3));
//
//        } else if (currentIndex == 1 && position == 0) // 1->0
//        {
//            lp.leftMargin = (int) (-(1 - positionOffset)
//                    * (screenWidth * 1.0 / 3) + currentIndex
//                    * (screenWidth / 3));
//
//        } else if (currentIndex == 1 && position == 1) // 1->2
//        {
//            lp.leftMargin = (int) (positionOffset * (screenWidth * 1.0 / 3) + currentIndex
//                    * (screenWidth / 3));
//        } else if (currentIndex == 2 && position == 1) // 2->1
//        {
//            lp.leftMargin = (int) (-(1 - positionOffset)
//                    * (screenWidth * 1.0 / 3) + currentIndex
//                    * (screenWidth / 3));
//        }
//        mTabLineIv.setLayoutParams(lp);
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
     * 设置滑动条的宽度为屏幕的1/3(根据Tab的个数而定)
     */
//    private void initTabLineWidth() {
//        DisplayMetrics dpMetrics = new DisplayMetrics();
//        getWindow().getWindowManager().getDefaultDisplay()
//                .getMetrics(dpMetrics);
//        screenWidth = dpMetrics.widthPixels;
//        LinearLayout.LayoutParams lp = (LinearLayout.LayoutParams) mTabLineIv
//                .getLayoutParams();
//        lp.width = screenWidth / 3;
//        mTabLineIv.setLayoutParams(lp);
//    }

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
