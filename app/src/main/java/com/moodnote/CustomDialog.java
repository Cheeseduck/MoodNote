package com.moodnote;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;


public class CustomDialog extends Dialog
{
    private MoodInfoDao moodInfoDao;
    private MoodInfo mood;
    private PostitDao postitDao;
    private Postit postit;
    private Context context;
    private long postId;

    CustomDialog m_oDialog;
    public CustomDialog(Context context, MoodInfoDao moodInfoDao, PostitDao postitDao, long postId)
    {
        super(context, android.R.style.Theme_Translucent_NoTitleBar);

        this.context = context;
        this.moodInfoDao = moodInfoDao;
        this.postitDao = postitDao;
        this.postId = postId;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        postit = postitDao.selectById(postId);
        mood = moodInfoDao.selectById(postit.getMoodId());

        super.onCreate(savedInstanceState);

        WindowManager.LayoutParams lpWindow = new WindowManager.LayoutParams();
        lpWindow.flags = WindowManager.LayoutParams.FLAG_DIM_BEHIND;
        lpWindow.dimAmount = 0.5f;
        getWindow().setAttributes(lpWindow);

        setContentView(R.layout.fragment_4_zoom);

        m_oDialog = this;
        String iconStr = mood.getIcon() + "_39";
        int icon = context.getResources().getIdentifier(iconStr, "drawable", context.getPackageName());

        TextView oView = (TextView) this.findViewById(R.id.maincon);
        TextView oView2 = (TextView) this.findViewById(R.id.mood);
        ImageView iView = (ImageView) this.findViewById(R.id.moodIcon);

        oView.setText(postit.getContents());
        oView2.setText(mood.getName());
        oView.setBackground(new ColorDrawable(Color.parseColor(mood.getColor())));
        iView.setImageResource(icon);

        ImageButton cBtn = (ImageButton)this.findViewById(R.id.close_btn);
        cBtn.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                onClickBtn(v);
            }
        });
    }

    public void onClickBtn(View _oView)
    {
        this.dismiss();
    }
}
