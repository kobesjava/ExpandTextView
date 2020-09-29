package com.jaki.expand.span;

import android.content.Context;

import androidx.annotation.NonNull;

import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;
import android.widget.Toast;

import com.jaki.expand.R;

public class JAtSpan extends ClickableSpan {

    private Context context;
    private int color = R.color.color_5187ff;
    private String userName;

    public JAtSpan(Context context, String userName) {
        this.context = context;
        this.userName = userName;
    }

    @Override
    public void updateDrawState(@NonNull TextPaint ds) {
        super.updateDrawState(ds);
        ds.setUnderlineText(false);
        ds.setColor(context.getColor(color));
    }

    @Override
    public void onClick(@NonNull View widget) {
        Toast.makeText(context, "CLick AtSpan " + userName, Toast.LENGTH_LONG).show();
    }
}
