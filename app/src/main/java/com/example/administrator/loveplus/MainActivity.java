package com.example.administrator.loveplus;
import android.graphics.Color;
import android.support.v4.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.List;
import adapter.FragmentAdapter;
import fragment.ChatFragment;
import fragment.ContactsFragment;
import fragment.FriendFragment;
import regiest_login.RegiestLoginActivity;


public class MainActivity extends AppCompatActivity implements ViewPager.OnPageChangeListener,View.OnClickListener{
    private ViewPager mPageVp;

    private List<Fragment> mFragmentList = new ArrayList<>();
    private FragmentAdapter mFragmentAdapter;

    /**
     * Tab显示内容TextView
     */
    private TextView mTabChatTv, mTabContactsTv, mTabFriendTv;
    /**
     * Tab的那个引导线
     */
    private ImageView mTabLineIv;
    /**
     * Fragment
     */
    private ChatFragment mChatFg;
    private FriendFragment mFriendFg;
    private ContactsFragment mContactsFg;
    /**
     * ViewPager的当前选中页
     */
    private int currentIndex = 0;
    /**
     * 屏幕的宽度
     */
    private int screenWidth;
    private FloatingActionButton fab;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        initView();
        initFragment();
        initTabLineWidth();
        fab.setOnClickListener(this);
        mPageVp.addOnPageChangeListener(this);
    }

    private void initFragment() {
        mFriendFg = new FriendFragment();
        mContactsFg = new ContactsFragment();
        mChatFg = new ChatFragment();
        mFragmentList.add(mChatFg);
        mFragmentList.add(mFriendFg);
        mFragmentList.add(mContactsFg);

        mFragmentAdapter = new FragmentAdapter(
                this.getSupportFragmentManager(), mFragmentList);
        mPageVp.setAdapter(mFragmentAdapter);
        mPageVp.setCurrentItem(0);

    }

    private void initView() {
        fab = (FloatingActionButton) findViewById(R.id.fab);
        mTabContactsTv = (TextView) this.findViewById(R.id.id_contacts_tv);
        mTabChatTv = (TextView) this.findViewById(R.id.id_chat_tv);
        mTabFriendTv = (TextView) this.findViewById(R.id.id_friend_tv);
        mTabLineIv = (ImageView) this.findViewById(R.id.id_tab_line_iv);
        mPageVp = (ViewPager) this.findViewById(R.id.id_page_vp);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.fab:
                Intent intent = new Intent();
                intent.setClass(getApplicationContext(), RegiestLoginActivity.class);
                startActivity(intent);
                break;
            default:
                break;
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    /**
     * position :当前页面，及你点击滑动的页面 offset:当前页面偏移的百分比
     * offsetPixels:当前页面偏移的像素位置
     */
    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
        LinearLayout.LayoutParams lp = (LinearLayout.LayoutParams) mTabLineIv
                .getLayoutParams();

        Log.e("offset:", positionOffset + "");
        /**
         * 利用currentIndex(当前所在页面)和position(下一个页面)以及offset来
         * 设置mTabLineIv的左边距 滑动场景：
         * 记3个页面,
         * 从左到右分别为0,1,2
         * 0->1; 1->2; 2->1; 1->0
         */
        if (currentIndex == 0 && position == 0)// 0->1
        {
            lp.leftMargin = (int) (positionOffset * (screenWidth * 1.0 / 3) + currentIndex
                    * (screenWidth / 3));

        } else if (currentIndex == 1 && position == 0) // 1->0
        {
            lp.leftMargin = (int) (-(1 - positionOffset)
                    * (screenWidth * 1.0 / 3) + currentIndex
                    * (screenWidth / 3));

        } else if (currentIndex == 1 && position == 1) // 1->2
        {
            lp.leftMargin = (int) (positionOffset * (screenWidth * 1.0 / 3) + currentIndex
                    * (screenWidth / 3));
        } else if (currentIndex == 2 && position == 1) // 2->1
        {
            lp.leftMargin = (int) (-(1 - positionOffset)
                    * (screenWidth * 1.0 / 3) + currentIndex
                    * (screenWidth / 3));
        }
        mTabLineIv.setLayoutParams(lp);
    }

    @Override
    public void onPageSelected(int position) {
        resetTextView();
        switch (position) {
            case 0:
                mTabChatTv.setTextColor(Color.BLUE);
                break;
            case 1:
                mTabFriendTv.setTextColor(Color.BLUE);
                break;
            case 2:
                mTabContactsTv.setTextColor(Color.BLUE);
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

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    /**
     * 设置滑动条的宽度为屏幕的1/3(根据Tab的个数而定)
     */
    private void initTabLineWidth() {
        DisplayMetrics dpMetrics = new DisplayMetrics();
        getWindow().getWindowManager().getDefaultDisplay()
                .getMetrics(dpMetrics);
        screenWidth = dpMetrics.widthPixels;
        LinearLayout.LayoutParams lp = (LinearLayout.LayoutParams) mTabLineIv
                .getLayoutParams();
        lp.width = screenWidth / 3;
        mTabLineIv.setLayoutParams(lp);
    }

    /**
     * 重置颜色
     */
    private void resetTextView() {
        mTabChatTv.setTextColor(Color.BLACK);
        mTabFriendTv.setTextColor(Color.BLACK);
        mTabContactsTv.setTextColor(Color.BLACK);
    }
}
