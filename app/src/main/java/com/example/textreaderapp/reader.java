package com.example.textreaderapp;

import android.accessibilityservice.AccessibilityService;
import android.accessibilityservice.AccessibilityServiceInfo;
import android.view.accessibility.AccessibilityEvent;
import android.widget.Toast;

public class reader extends AccessibilityService {



    @Override
    public void onServiceConnected(){

        AccessibilityServiceInfo info = new AccessibilityServiceInfo();
        info.eventTypes = AccessibilityEvent.TYPE_VIEW_TEXT_SELECTION_CHANGED;
        info.feedbackType = AccessibilityServiceInfo.FEEDBACK_SPOKEN;
        info.notificationTimeout = 100;
        this.setServiceInfo(info);
        Toast.makeText(this,"Connected",Toast.LENGTH_LONG).show();
    }

    @Override
    public void onAccessibilityEvent(AccessibilityEvent event)
    {
        Toast.makeText(this,"Got event",Toast.LENGTH_LONG).show();

        final int selectBegin = event.getSource().getTextSelectionStart();
        final int selectEnd = event.getSource().getTextSelectionEnd();
        if (selectBegin == selectEnd)
        {
            return;
        }
         String text = event.getText().toString().substring(selectBegin,selectEnd + 1);




    }

    @Override
    public void onInterrupt()
    {
        return;
    }

    @Override
    public void onDestroy()
    {
        super.onDestroy();
        Toast.makeText(this,"Stopped",Toast.LENGTH_LONG).show();
    }




}
