package com.android.launcher3.util;

import android.content.Context;
import android.content.res.Configuration;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class ThemeUtils {

    public static String getCurrentIconPack(Context context) {

        try {
            Configuration currentConfiguration = context.getResources().getConfiguration();
            Field themeConfigField = Configuration.class.getDeclaredField("themeConfig");
            Object themeConfig = themeConfigField.get(currentConfiguration);
            Method getIconPackPkgNameMethod = themeConfig.getClass().getMethod("getIconPackPkgName");
            String iconPackName = (String) getIconPackPkgNameMethod.invoke(themeConfig);
            return iconPackName;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }

}
