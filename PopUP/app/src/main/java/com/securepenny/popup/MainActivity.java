package com.securepenny.popup;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.widget.PopupWindow;

public class MainActivity extends AppCompatActivity {
    private PopupWindow popup;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        View popupContent = getLayoutInflater().inflate(R.layout.popup, null);
        popup = new PopupWindow();

        //popup should wrap content view
        popup.setWindowLayoutMode(WindowManager.LayoutParams.WRAP_CONTENT, WindowManager.LayoutParams.WRAP_CONTENT);
        popup.setHeight(250);
        popup.setWidth(350);

        //set content and background
        popup.setContentView(popupContent);
        popup.setBackgroundDrawable(getResources().getDrawable(R.drawable.popup_background));

        popupContent.findViewById(R.id.btnClose).setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                popup.dismiss();
            }
        });

        popup.setTouchInterceptor(new View.OnTouchListener(){

            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                return false;
            }
        });
        popup.setFocusable(true);
        popup.setOutsideTouchable(true);
        popup.setAnimationStyle(R.style.PopupAnimation);
    }

    @Override
    protected void onPause() {
        super.onPause();
        popup.dismiss();
    }

    public void onShowWindowClick(View v) {
        if (popup.isShowing()) {
            popup.dismiss();
        } else {
            //Show the PopupWindow anchored to the button we
            //pressed. It will be displayed below the button
            //if there's room, otherwise above.
            popup.showAsDropDown(v);
        }
    }
}
