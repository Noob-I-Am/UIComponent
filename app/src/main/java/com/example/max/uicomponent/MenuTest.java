package com.example.max.uicomponent;


import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;

public class MenuTest extends AppCompatActivity{

    PopupMenu popup = null;
    TextView mText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menuactivity);
        mText=(TextView)findViewById(R.id.textView2);

    }

    public void onPopupButtonClick(View button)
    {
        popup = new PopupMenu(this,button);
        getMenuInflater().inflate(R.menu.menu, popup.getMenu());
        popup.setOnMenuItemClickListener(
                new PopupMenu.OnMenuItemClickListener()
                {
                    @Override
                    public boolean onMenuItemClick(MenuItem item)
                    {
                        switch (item.getItemId())
                        {
                            case R.id.size10:
                                mText.setTextSize(10);
                                break;
                            case R.id.size16:
                                mText.setTextSize(16);
                                break;
                            case R.id.size20:
                                mText.setTextSize(20);
                                break;
                            case R.id.normalitem:
                                Toast.makeText(MenuTest.this,
                                        "您单击了普通菜单项"
                                        , Toast.LENGTH_SHORT).show();
                                break;
                            case R.id.black:
                                mText.setTextColor(Color.BLACK);
                                break;
                            case R.id.red:
                                mText.setTextColor(Color.RED);
                                break;
                            default:
                                // 使用Toast显示用户单击的菜单项
                                Toast.makeText(MenuTest.this,
                                        "您单击了【" + item.getTitle() + "】菜单项"
                                        , Toast.LENGTH_SHORT).show();
                        }
                        return true;
                    }
                });
        popup.show();
    }

}
