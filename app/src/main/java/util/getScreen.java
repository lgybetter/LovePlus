package util;

import android.content.Context;
import android.util.DisplayMetrics;

/**
 * Created by Administrator on 2016/7/22.
 */
public class GetScreen {
    private Context context;
    private DisplayMetrics dm = new DisplayMetrics();
    public GetScreen(Context c)
    {
        context = c;
    }
    public double getDensityDPI() {
        dm = context.getResources().getDisplayMetrics();
        // 屏幕密度（每寸像素：120/160/240/320）
        double densityDPI = dm.densityDpi;
        return densityDPI;
    }
    public double getDensity() {
        dm = context.getResources().getDisplayMetrics();
        // 屏幕密度（像素比例：0.75/1.0/1.5/2.0）
        double density  = dm.density;
        return density;
    }
    public double getScreenWidth() {
        // 屏幕宽（像素，如：480px）
        double screenWidth  = dm.widthPixels;
        return screenWidth;
    }
    public double getScreenHeight() {
        // 屏幕高（像素，如：800px）
        double screenHeight = dm.heightPixels;
        return screenHeight;
    }
}
