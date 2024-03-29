package lib.initope.gradientUI;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.widget.LinearLayout;

public class UIMake implements InitUI {
    private final GradientDrawable shape;
    private final Context ctx;

    public UIMake(Context ctx) {
        this.ctx = ctx;
        shape = new GradientDrawable();
        shape.setShape(SHAPE_RECTANGLE);
    }

    public LinearLayout setLinear(LinearLayout linear, int color, int size) {
        LinearLayout ll = new LinearLayout(ctx);
        ll.setBackgroundColor(color);
        ll.setLayoutParams(new LinearLayout.LayoutParams(-1, 1));
        linear.addView(ll, size);
        return linear;
    }

    public UIMake setShape(int gShape) {
        shape.setShape(gShape);
        return this;
    }

    public UIMake setRadius(float l, float r, float rb, float lb) {
        shape.setCornerRadii(new float[]{l, l, r, r, rb, rb, lb, lb});
        return this;
    }

    public UIMake setRadius(float radius) {
        shape.setCornerRadius(radius);
        return this;
    }

    public UIMake setStroke(int size, int color) {
        shape.setStroke(size, color);
        return this;
    }

    public UIMake setColorBG(int colorBG) {
        shape.setColor(colorBG);
        return this;
    }

    public GradientDrawable show() {
        return shape;
    }
}
