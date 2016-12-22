package me.tyrion.glidedemo.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;

import me.tyrion.glidedemo.R;

/**
 * Created by taomaogan on 16/3/17.
 */
public class CircleLoading extends View {
    private static final int CIRCLE_LEFT = 1;
    private static final int CIRCLE_TOP = 2;
    private static final int CIRCLE_RIGHT = 3;
    private static final int CIRCLE_BOTTOM = 4;

    //外圈圆（空心圆）
    private int outCircleColor;
    private float outCircleStrokeWidth;
    private float outCircleRadius;
    private Paint outCirclePaint;

    //内圈圆（是心圆）
    private int inCircleColor;
    private float startAngle = 0, sweepAngle = 0;
    private float left, top, right, bottom;
    private Paint inCirclePaint;
    private int progress = 0;

    //公共变量
    private float divideWidth; //外圈圆和内圈圆的距离
    private int position;

    public CircleLoading(Context context) {
        super(context);
    }

    public CircleLoading(Context context, AttributeSet attrs) {
        super(context, attrs);

        TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.CircleLoading);

        outCircleColor = a.getColor(R.styleable.CircleLoading_outCircleColor, 0xffffff);
        outCircleRadius = a.getDimension(R.styleable.CircleLoading_outCircleRadius, 15f);
        outCircleStrokeWidth = a.getDimension(R.styleable.CircleLoading_outCircleStrokeWidth, 2.5f);
        inCircleColor = a.getColor(R.styleable.CircleLoading_inCircleColor, 0xffffff);
        divideWidth = a.getDimension(R.styleable.CircleLoading_divideWidth, 5f);
        position = a.getInteger(R.styleable.CircleLoading_position, 2);
        progress = a.getInteger(R.styleable.CircleLoading_cirlceProgress, 0);
        if (outCircleRadius < divideWidth) {
            throw new IllegalStateException("outCircleRadius must bigger than divideWidth.");
        }

        init();
    }

    private void init() {
        outCirclePaint = new Paint();
        outCirclePaint.setColor(outCircleColor);
        outCirclePaint.setAntiAlias(true);
        outCirclePaint.setStyle(Paint.Style.STROKE);
        outCirclePaint.setStrokeWidth(outCircleStrokeWidth);

        inCirclePaint = new Paint();
        inCirclePaint.setColor(inCircleColor);
        inCirclePaint.setAntiAlias(true);
        inCirclePaint.setStyle(Paint.Style.FILL_AND_STROKE);

        float inCircleRadius = outCircleRadius - divideWidth;
        float incremental = outCircleStrokeWidth + divideWidth;
        left = incremental;
        top = incremental;
        right = incremental + inCircleRadius * 2;
        bottom = incremental + inCircleRadius * 2;

        initPosition();
    }

    private void initPosition() {
        switch (position) {
            case CIRCLE_LEFT:
                startAngle = 180;
                break;

            case CIRCLE_TOP:
                startAngle = 270;
                break;

            case CIRCLE_RIGHT:
                startAngle = 0;
                break;

            case CIRCLE_BOTTOM:
                startAngle = 90;
                break;

            default:
                startAngle = 270;
                break;
        }
        setSweepAngle();
    }

    public CircleLoading(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        canvas.drawArc(new RectF(left, top, right, bottom), startAngle, sweepAngle, true, inCirclePaint);
        canvas.drawCircle(outCircleRadius + outCircleStrokeWidth, outCircleRadius + outCircleStrokeWidth, outCircleRadius, outCirclePaint);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        float width, height;
        width = outCircleStrokeWidth * 2 + outCircleRadius * 2;
        height = outCircleStrokeWidth * 2 + outCircleRadius * 2;
        setPadding(0, 0, 0, 0);
        setMeasuredDimension((int)width, (int)height);
    }

    public void setProgress(int progress) {
        this.progress = progress;
        setSweepAngle();
        invalidate();
    }

    private void setSweepAngle() {
        sweepAngle = progress * (360 / 100f);
    }
}
