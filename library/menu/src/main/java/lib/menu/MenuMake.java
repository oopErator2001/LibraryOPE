package lib.menu;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.provider.Settings;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.widget.Toast;

/**
 * @author oopErator
 * @date: 28/03/2024
 * @note: MenuMake
 */
public abstract class MenuMake implements InitMenu {
    private final Context ctx;
    private View mView;
    private WindowManager mWindowManager;
    private WindowManager.LayoutParams mParams;

    /**
     * Menu library by oopErator
     *
     * @param ctx this của class
     */
    public MenuMake(Context ctx) {
        this.ctx = ctx;
        menuStart();
    }

    /**
     * @param ctx          this của class
     * @param serviceClass service.class của class
     */
    public static void Start(Context ctx, Class<?> serviceClass) {
        if (!Settings.canDrawOverlays(ctx)) {
            ctx.startActivity(new Intent(Settings.ACTION_MANAGE_OVERLAY_PERMISSION, Uri.parse(GET_PACKAGE + ctx.getPackageName())));
            ((Activity) ctx).finish();
        } else {
            ctx.startService(new Intent(ctx, serviceClass));
            ((Activity) ctx).finish();
        }
    }

    /**
     * hàm khởi tạo mặc định
     */
    @SuppressLint("WrongConstant")
    private void menuStart() {
        try {
            mParams = new WindowManager.LayoutParams(PARAMS_W, PARAMS_H, getPosX(), getPosY(), GET_SDK_DEFAULT, PARAMS_FLAGS, PARAMS_FORMAT);
            mParams.gravity = getGravity();
            mView = LayoutInflater.from(ctx).inflate(setLayout(R.layout.default_layout), null);
            getMenu();
            mWindowManager.addView(mView, mParams);
        } catch (Exception e) {
            Toast.makeText(ctx, e.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }

    /**
     * tạo activity Class
     *
     * @return activity.class
     */
    protected MenuMake getActivity() {
        mWindowManager = ((Activity) ctx).getWindowManager();
        mParams.type = WindowManager.LayoutParams.TYPE_APPLICATION;
        return this;
    }

    /**
     * tạo service Class
     *
     * @return service.class
     */
    protected MenuMake getService() {
        mWindowManager = (WindowManager) ctx.getSystemService(Context.WINDOW_SERVICE);
        return this;
    }

    /**
     * @return activity.class[ getActivity() ] hoặc service.class[ getService() ]
     */
    protected abstract MenuMake getMenu();

    /**
     * @param default_Layout_XML layout mặc định
     * @return layout do bạn tạo
     */
    protected abstract int setLayout(int default_Layout_XML);

    /**
     * @return InitMenu.GRAVITY_
     */
    protected int getGravity() {
        return InitMenu.GRAVITY_LT;
    }

    /**
     * @return vị trí X
     */
    protected int getPosX() {
        return 0;
    }

    /**
     * @return vị trí Y
     */
    protected int getPosY() {
        return 0;
    }

    /**
     * thực hiện tạo menu của bạn
     *
     * @param menu menu.setBuild( getView() );
     */
    protected abstract void setCreate(InitMenu menu);

    /**
     * @param linearCheck linear khi click sẽ bật tắt giao diện menu / nếu muốn kéo mà không click thì để null
     * @return kéo menu
     */
    protected View.OnTouchListener setOnTouch(View linearCheck) {
        return new View.OnTouchListener() {
            float initialTouchX, initialTouchY;
            int initialX, initialY;

            @SuppressLint("ClickableViewAccessibility")
            @Override
            public boolean onTouch(View v, MotionEvent motionEvent) {
                switch (motionEvent.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        initialX = mParams.x;
                        initialY = mParams.y;
                        initialTouchX = motionEvent.getRawX();
                        initialTouchY = motionEvent.getRawY();
                        return true;
                    case MotionEvent.ACTION_UP:
                        int rawX = (int) (motionEvent.getRawX() - initialTouchX);
                        int rawY = (int) (motionEvent.getRawY() - initialTouchY);
                        if (linearCheck != null) {
                            if (rawX < 10 && rawY < 10 && linearCheck.getVisibility() == View.GONE) {
                                linearCheck.setVisibility(View.VISIBLE);
                            } else {
                                linearCheck.setVisibility(View.GONE);
                            }
                        }
                        return true;
                    case MotionEvent.ACTION_MOVE:
                        mParams.x = initialX + ((int) (motionEvent.getRawX() - initialTouchX));
                        mParams.y = initialY + ((int) (motionEvent.getRawY() - initialTouchY));
                        mWindowManager.updateViewLayout(mView, mParams);
                        return true;
                    default:
                        return false;
                }
            }
        };
    }

    /**
     * @return Tất cả view của menu đó
     */
    public View getView() {
        return mView;
    }
}
