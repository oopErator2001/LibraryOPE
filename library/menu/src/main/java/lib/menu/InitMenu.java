package lib.menu;

import android.os.Build;
import android.view.Gravity;
import android.view.View;


/**
 * @author oopErator
 * @date: 28/03/2024
 * @note: Init
 */
public interface InitMenu {
    //--Gravity menu setting--//
    /**
     * Căn giữa
     */
    int GRAVITY_CENTER = Gravity.CENTER;
    /**
     * Căn bên trái
     */
    int GRAVITY_LEFT = Gravity.LEFT;
    /**
     * Căn bên trên
     */
    int GRAVITY_TOP = Gravity.TOP;
    /**
     * Căn bên trái và trên
     */
    int GRAVITY_LT = 51;
    //------------------------//


    //--Params menu setting--//
    int PARAMS_W = -2;
    int PARAMS_H = -2;
    int PARAMS_FLAGS = 512 | 8;
    int PARAMS_FORMAT = -2;
    //------------------------//


    //--SDK menu setting--//
    int GET_SDK = (Build.VERSION.RELEASE.length() == 2) ? Integer.parseInt(Build.VERSION.RELEASE) : Integer.parseInt(String.valueOf(Build.VERSION.RELEASE.charAt(0)));
    int GET_SDK_DEFAULT = (GET_SDK > 7) ? 2038 : 2002;
    //------------------------//


    //--Init menu setting--//
    /**
     * lấy thông tin của máy điện thoại
     */
    String GET_SYSTEM_DETAIL = "DeviceID: " + Build.DEVICE + "\n" + "Model: " + Build.MODEL + "\n" + "ID: " + Build.ID + "\n" + "SDK: " + Build.VERSION.SDK_INT + "\n" + "Manufacture: " + Build.MANUFACTURER + "\n" + "Brand: " + Build.BRAND + "\n" + "User: " + Build.USER + "\n" + "Type: " + Build.TYPE + "\n" + "Base: " + Build.VERSION_CODES.BASE + "\n" + "Incremental: " + Build.VERSION.INCREMENTAL + "\n" + "Board: " + Build.BOARD + "\n" + "Host: " + Build.HOST + "\n" + "FingerPrint: " + Build.FINGERPRINT + "\n" + "Version Code: " + Build.VERSION.RELEASE;
    String GET_PACKAGE = "package:";
    //------------------------//


    //--Build menu setting--//

    /**
     * @param view getView() menu
     */
    void setBuild(View view);
}
