package com.github.amlcurran.showcaseview.targets;

import android.app.Activity;
import android.graphics.Point;
import android.view.ViewParent;

import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import com.github.amlcurran.showcaseview.targets.ActionBarViewWrapper;
import com.github.amlcurran.showcaseview.targets.ActionBarReflector;

public class ActionTabTarget implements Target {

    private final Activity mActivity;
    private final int tabId;

    ActionBarViewWrapper mActionBarWrapper;

    public ActionTabTarget(Activity activity, int tabId) {
        mActivity = activity;
		this.tabId = tabId;
    }

    @Override
    public Point getPoint() {
        setUp();
        return new ViewTarget(mActionBarWrapper.getTabItem(tabId)).getPoint();
    }

    protected void setUp() {
    	
    	ActionBarReflector reflector = new ActionBarReflector(mActivity);
        ViewParent p = reflector.getActionBarView(); //ActionBarView
        mActionBarWrapper = new ActionBarViewWrapper(p);
    }

}