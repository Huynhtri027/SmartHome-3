package com.gdgl.widgets;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.MotionEvent;

/**
 * Found at http://stackoverflow.com/questions/7814017/is-it-possible-to-disable-scrolling-on-a-viewpager.
 * Convenient way to temporarily disable ViewPager navigation while interacting with ImageView.
 * 
 * Julia Zudikova
 */

/**
 * Hacky fix for Issue #4 and
 * http://code.google.com/p/android/issues/detail?id=18990
 * <p/>
 * ScaleGestureDetector seems to mess up the touch events, which means that
 * ViewGroups which make use of onInterceptTouchEvent throw a lot of
 * IllegalArgumentException: pointerIndex out of range.
 * <p/>
 * There's not much I can do in my code for now, but we can mask the result by
 * just catching the problem and ignoring it.
 *
 * @author Chris Banes
 */
public class HackyViewPager extends ViewPager {

	
	public HackyViewPager(Context context) {
        super(context);
    }
	public HackyViewPager(Context context, AttributeSet attrs) {
        super(context, attrs);
    }
	@Override  
    public boolean onInterceptTouchEvent(MotionEvent ev) {  
        try {  
            return super.onInterceptTouchEvent(ev);  
        } catch (Exception e) {  
            // ignore it  
        	e.printStackTrace();
        }  
        return false;  
    }  
  
  
    @Override  
    public boolean onTouchEvent(MotionEvent ev) {  
        try {  
            return super.onTouchEvent(ev);  
        } catch (IllegalArgumentException e) {  
            // ignore it 
        	e.printStackTrace();
        }  
        return false;  
    }  

   
	
}
