package com.asia.delmaratallah;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.Toast;

public class OrderInfo extends AppCompatActivity {

   private ImageView orderInfo_img_more;
   private EditText orderInfo_edtx_address;

    private Context mContext;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_info);
        mContext=OrderInfo.this;

        orderInfo_img_more=findViewById(R.id.orderInfo_img_more);
        orderInfo_edtx_address=findViewById(R.id.orderInfo_edtx_address);
        orderInfo_img_more.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                PopupMenu popupMenu=new PopupMenu(mContext,orderInfo_img_more);
                popupMenu.getMenu().add( "وراق الحضر، وراق العرب، الوراق، الجيزة");
                popupMenu.getMenu().add("وراق الحضر، وراق العرب، الوراق، الجيزة");
                popupMenu.getMenu().add("وراق الحضر، وراق العرب، الوراق، الجيزة");
                popupMenu.getMenu().add("وراق الحضر، وراق العرب، الوراق، الجيزة");

//                popupMenu.getMenu().add(Menu.NONE, 2, 2, "Comment");

                popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {
                        orderInfo_edtx_address.setText(item.getTitle());

                        return true;
                    }
                });
                popupMenu.show();

            }
        });

    }
}
