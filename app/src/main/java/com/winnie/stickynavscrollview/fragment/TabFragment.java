package com.winnie.stickynavscrollview.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.winnie.library.stickynav.base.IStickyTabViewListener;
import com.winnie.stickynavscrollview.R;
import com.winnie.stickynavscrollview.adapter.RecyclerTestAdapter;

import java.util.ArrayList;
import java.util.List;

public class TabFragment extends Fragment implements IStickyTabViewListener
{
    public static final String TITLE = "title";
    private String mTitle = "Defaut Value";
    private RecyclerView mRecyclerView;
    // private TextView mTextView;
    private List<String> mDatas = new ArrayList<String>();

    private TextView mTextView;

    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        if (getArguments() != null)
        {
            mTitle = getArguments().getString(TITLE);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState)
    {
        View view = inflater.inflate(R.layout.fragment_tab, container, false);
        mRecyclerView = (RecyclerView) view
                .findViewById(R.id.id_stickynavlayout_innerscrollview);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
//        mRecyclerView.setPullRefreshEnabled(false);
        // mTextView = (TextView) view.findViewById(R.id.id_info);
        // mTextView.setText(mTitle);
        for (int i = 0; i < 10; i++)
        {
            mDatas.add(mTitle + " -> " + i);
        }
//        mRecyclerView.setAdapter(new CommonAdapter<String>(getActivity(), R.layout.item, mDatas)
//        {
//            @Override
//            public void convert(ViewHolder holder, String o)
//            {
//                holder.setText(R.id.id_info, o);
//            }
//        });

        mRecyclerView.setAdapter(new RecyclerTestAdapter(getContext(), mDatas));

        mTextView = view.findViewById(R.id.sticky_nav_tab_title);
        mTextView.setText(mTitle);
        return view;

    }

    public static TabFragment newInstance(String title)
    {
        TabFragment tabFragment = new TabFragment();
        Bundle bundle = new Bundle();
        bundle.putString(TITLE, title);
        tabFragment.setArguments(bundle);
        return tabFragment;
    }

    public void scrollToTop(){
       if(mRecyclerView != null) {
           mRecyclerView.scrollToPosition(0);
       }
    }

    public boolean isScrollToTop(){
        /** 滑动到顶部 **/
        RecyclerView.LayoutManager manager = mRecyclerView.getLayoutManager();
        int firstVisibleItem = 1;
        if (manager instanceof LinearLayoutManager) {
            firstVisibleItem = ((LinearLayoutManager) manager).findFirstVisibleItemPosition();
        } else if (manager instanceof GridLayoutManager) {
            firstVisibleItem = ((GridLayoutManager) manager).findFirstVisibleItemPosition();
        }

        return (mRecyclerView.getChildAt(0).getTop() == 0 && firstVisibleItem == 1);
    }
}
