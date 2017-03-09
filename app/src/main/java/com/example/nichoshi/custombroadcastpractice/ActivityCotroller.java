package com.example.nichoshi.custombroadcastpractice;

import android.app.Activity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by NichoShi on 2017/3/9.
 */

public class ActivityCotroller {
    public static List<Activity> ActivityList = new ArrayList<>();

    public static void addActivity(Activity activity){
        ActivityList.add(activity);
    }

    public static void removeActivity(Activity activity){
        ActivityList.remove(activity);
    }

    public static void finishAll(){
        for(Activity activity : ActivityList){
            if(!activity.isFinishing()){
                activity.finish();
            }
        }
    }
}
