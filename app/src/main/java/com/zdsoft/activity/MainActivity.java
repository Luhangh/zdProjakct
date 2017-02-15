package com.zdsoft.activity;
import java.util.ArrayList;
import java.util.List;
import com.zdsoft.adapter.MainAdapter;
import com.zdsoft.fragment.OneFragment;
import com.zdsoft.fragment.ThreeFragment;
import com.zdsoft.fragment.TwoFragment;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

public class MainActivity extends FragmentActivity  implements  OnClickListener{

	private ViewPager mPageVp;
	private List<Fragment> mFragmentList = new ArrayList<Fragment>();
	private MainAdapter mFragmentAdapter;
	private LinearLayout id_tab_chat_ll,id_tab_friend_ll,id_tab_contacts_ll,linearLayout_LinkMains;
	/**FragmentAdapter
	 * 设置滚动长度
	 */
	//private float mCurrentCheckedRadioLeft;

	/**
	 * Tab显示内容TextView
	 */
	private TextView mTabChatTv, mTabContactsTv, mTabFriendTv;
	/**
	 * Tab的引导线
	 */
	private ImageView mTabLineIv;
	/**
	 * Fragment
	 */
	private OneFragment mChatFg;
	private TwoFragment mFriendFg;
	private ThreeFragment mContactsFg;
	/**
	 * ViewPager的当前选中页
	 */
	private int currentIndex;
	/**
	 * 屏幕的宽度
	 */
	private int screenWidth;
	public TextView result;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		//XGTSActivity.getInstance().getTuiSong();
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		//SDKInitializer.initialize(getApplicationContext());// 满足百度地图使用条件
	
		findById();
		init();
		initTabLineWidth();
		WindowManager windowManager =this.getWindowManager();    
        Display display = windowManager.getDefaultDisplay();    
        int screenWidth = screenWidth = display.getWidth();    
        int screenHeight = screenHeight = display.getHeight();
	
	}


	@Override
	protected void onStart() {
		// TODO Auto-generated method stub
		super.onStart();
	
	}
	private void findById() {
		mTabContactsTv = (TextView) this.findViewById(R.id.id_contacts_tv);
		mTabChatTv = (TextView) this.findViewById(R.id.id_chat_tv);
		mTabFriendTv = (TextView) this.findViewById(R.id.id_friend_tv);
		mTabLineIv = (ImageView) this.findViewById(R.id.id_tab_line_iv);

		mPageVp = (ViewPager) this.findViewById(R.id.id_page_vp);
		linearLayout_LinkMains=(LinearLayout)findViewById(R.id.linearLayout_LinkMains);
		id_tab_chat_ll=(LinearLayout)findViewById(R.id.id_tab_chat_ll);
		
		id_tab_friend_ll=(LinearLayout)findViewById(R.id.id_tab_friend_ll);
		
		id_tab_contacts_ll=(LinearLayout)findViewById(R.id.id_tab_contacts_ll);
		
		id_tab_chat_ll.setOnClickListener(this);
		
		id_tab_friend_ll.setOnClickListener(this);
		
		id_tab_contacts_ll.setOnClickListener(this);
		
		//text_friend=(TextView)this.findViewById(R.id.text_friend);
	}



	private void init() {
		
		mFriendFg = new TwoFragment();
		mContactsFg = new ThreeFragment();
		mChatFg = new OneFragment();
		mFragmentList.add(mChatFg);
		mFragmentList.add(mFriendFg);
		mFragmentList.add(mContactsFg);

		mFragmentAdapter = new MainAdapter(
				this.getSupportFragmentManager(), mFragmentList);
		mPageVp.setAdapter(mFragmentAdapter);
		mPageVp.setCurrentItem(0);

		mPageVp.setOnPageChangeListener(new OnPageChangeListener() {

			/**
			 * state滑动中的状态 有三种状态（0，1，2） 1：正在滑动 2：滑动完毕 0：什么都没做。
			 */
			@Override
			public void onPageScrollStateChanged(int state) {

			}

			/**
			 * position :当前页面，及你点击滑动的页面 offset:当前页面偏移的百分比
			 * offsetPixels:当前页面偏移的像素位置
			 */
			@Override
			public void onPageScrolled(int position, float offset,
					int offsetPixels) {
				LinearLayout.LayoutParams lp = (LinearLayout.LayoutParams) mTabLineIv.getLayoutParams();

				Log.e("offset:", offset + "");
				/**
				 * 利用currentIndex(当前所在页面)和position(下一个页面)以及offset来
				 * 设置mTabLineIv的左边距 滑动场景：
				 * 记3个页面,
				 * 从左到右分别为0,1,2 
				 * 0->1; 1->2; 2->1; 1->0
				 */

				if (currentIndex == 0 && position == 0)// 0->1
				{
					lp.leftMargin = (int) (offset * (screenWidth * 1.0 / 3) + currentIndex
							* (screenWidth / 3));

				} else if (currentIndex == 1 && position == 0) // 1->0
				{
					lp.leftMargin = (int) (-(1 - offset)
							* (screenWidth * 1.0 / 3) + currentIndex
							* (screenWidth / 3));
				} else if (currentIndex == 1 && position == 1) // 1->2
				{
					lp.leftMargin = (int) (offset * (screenWidth * 1.0 / 3) + currentIndex
							* (screenWidth / 3));
				} else if (currentIndex == 2 && position == 1) // 2->1
				{
					lp.leftMargin = (int) (-(1 - offset)
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
					mTabChatTv.setTextColor(MainActivity.this.getResources().getColor(R.color.blue));
					break;
				case 1:
					mTabFriendTv.setTextColor(MainActivity.this.getResources().getColor(R.color.blue));
					
					break;
				case 2:
					mTabContactsTv.setTextColor(MainActivity.this.getResources().getColor(R.color.blue));
					break;
				}
				currentIndex = position;
			}
		});

	}

	/**
	 * 设置滑动条的宽度为屏幕的1/3(根据Tab的个数而定)
	 */
	private void initTabLineWidth() {
		DisplayMetrics dpMetrics = new DisplayMetrics();
		getWindow().getWindowManager().getDefaultDisplay().getMetrics(dpMetrics);
		screenWidth = dpMetrics.widthPixels;
		LinearLayout.LayoutParams lp = (LinearLayout.LayoutParams) mTabLineIv.getLayoutParams();
		lp.width = screenWidth / 3;
		mTabLineIv.setLayoutParams(lp);
	}

	/**
	 * 重置颜色
	 */
	private void resetTextView() {
		mTabChatTv.setTextColor(MainActivity.this.getResources().getColor(R.color.grey));
		mTabFriendTv.setTextColor(MainActivity.this.getResources().getColor(R.color.grey));
		mTabContactsTv.setTextColor(MainActivity.this.getResources().getColor(R.color.grey));
	}

	@Override
	public void onClick(View arg0) {
		/*AnimationSet _AnimationSet = new AnimationSet(true);
		TranslateAnimation _TranslateAnimation;*/
		switch (arg0.getId()) {
		case R.id.id_tab_chat_ll: 
		
			mPageVp.setCurrentItem(0);
			break;
        case R.id.id_tab_friend_ll:
		
			mPageVp.setCurrentItem(1);
			break;
        case R.id.id_tab_contacts_ll:
	
			mPageVp.setCurrentItem(2);
	        break;
		default:
			break;
		}
		
	}

	@Override
	public void onActivityResult(int arg0, int arg1, Intent arg2) {
		// TODO Auto-generated method stub
		if(arg2==null){
			
			return;
		}
		super.onActivityResult(arg0, arg1, arg2);
	}
	@Override
	protected void onStop() {
	
		super.onStop();
	}
  @Override
	public void onDestroy() {
    
		super.onDestroy();
	}
}
