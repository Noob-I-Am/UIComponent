package com.example.max.uicomponent;

import android.content.Context;
import android.view.ActionMode;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AbsListView.MultiChoiceModeListener;
import android.widget.TextView;

public class MultiChoiceListener implements MultiChoiceModeListener {
    private View mMultiSelectionbarView;

    private TextView mSelectedItemCount;
    private boolean allCheckedMode;
    private Context con;
    private MyAdapter mAdapter;
    public MultiChoiceListener(TestActionmode con,MyAdapter mAdapter)
    {
        this.con=con;
        this.mAdapter=mAdapter;
    }
    @Override
    public void onItemCheckedStateChanged(ActionMode mode, int position, long id, boolean checked) {
        int checkedCount = 0;
        if (allCheckedMode) {
            if (checked) {
                mAdapter.getItemState()[position] = 0;
            } else {
                mAdapter.getItemState()[position] = 1;

            }
            checkedCount = mAdapter.getCheckedItemCount();
        } else {
            if (checked) {
                mAdapter.getItemState()[position] = 1;
            } else {
                mAdapter.getItemState()[position] = 0;
            }
            checkedCount = mAdapter.getCheckedItemCount();
        }
        mSelectedItemCount.setText(checkedCount+"");
        mAdapter.notifyDataSetChanged();

    }

    @Override
    public boolean onCreateActionMode(ActionMode mode, Menu menu) {
        allCheckedMode = false;
        mode.getMenuInflater().inflate(R.menu.choise_menu, menu);
        if (mMultiSelectionbarView == null) {
            mMultiSelectionbarView = LayoutInflater.from(this.con).inflate(R.layout.custom_view, null, false);
            mSelectedItemCount = (TextView) mMultiSelectionbarView.findViewById(R.id.selected_conv_count);
        }
        mode.setCustomView(mMultiSelectionbarView);
        ((TextView) mMultiSelectionbarView.findViewById(R.id.title)).setText("选择项目");
        mSelectedItemCount.setText(mAdapter.getCheckedItemCount() + "");
        return true;
    }

    @Override
    public boolean onPrepareActionMode(ActionMode mode, Menu menu) {
        return true;
    }

    @Override
    public boolean onActionItemClicked(ActionMode mode, MenuItem item) {
        return false;
    }

    @Override
    public void onDestroyActionMode(ActionMode mode) {
        allCheckedMode = false;
        mAdapter.unCheckAll();
    }
}