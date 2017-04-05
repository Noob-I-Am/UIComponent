package com.example.max.uicomponent;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.ActionMode;
import android.widget.AbsListView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class TestActionmode extends AppCompatActivity {
    private String[] seq=new String[]{"One","Two","Three","Four","Five"};
    private int[] images=new int[]{R.drawable.android,R.drawable.android,R.drawable.android,R.drawable.android,R.drawable.android};
    public ActionMode actionMode=null;;


    ListView list;
    private TextView mSelectedItemCount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.listview);
        List<Map<String,Object>> listItems=new ArrayList<>();
        for(int i=0;i<seq.length;i++)
        {
            Map<String,Object>listItem=new HashMap<String,Object>();
            listItem.put("pic",images[i]);
            listItem.put("num",seq[i]);
            listItems.add(listItem);
        }
        MyAdapter mAdapter=new MyAdapter(this,listItems,R.layout.simple_item2,
                new String[]{"pic","num"},
                new int[]{R.id.pic,R.id.num});
        list=(ListView)findViewById(R.id.lv);
        list.setAdapter(mAdapter);
        //*<1>/
        list.setChoiceMode(AbsListView.CHOICE_MODE_MULTIPLE_MODAL);
        AbsListView.MultiChoiceModeListener mMultiChoiceListener =new MultiChoiceListener(this,mAdapter);

        list.setMultiChoiceModeListener(mMultiChoiceListener);
        //*/

    }
}

