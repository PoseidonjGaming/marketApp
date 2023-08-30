package fr.poseidonj.marketapp.utils;

import android.content.Context;
import android.content.Intent;

public class Utils {
    public static Intent startIntent(Context context, Class<?> activityTarget){
        return new Intent(context, activityTarget);
    }
}
