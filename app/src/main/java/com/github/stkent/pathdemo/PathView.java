package com.github.stkent.pathdemo;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.support.annotation.NonNull;
import android.util.AttributeSet;
import android.view.View;

import static android.graphics.Color.BLACK;
import static android.graphics.Color.CYAN;
import static android.graphics.Paint.ANTI_ALIAS_FLAG;
import static android.graphics.Paint.Style.STROKE;

public class PathView extends View {

    private static final float ASPECT_RATIO = 1f;

    private Path path;

    @NonNull
    private final Paint pathPaint = new Paint(ANTI_ALIAS_FLAG);

    public PathView(final Context context, final AttributeSet attrs) {
        super(context, attrs);

        pathPaint.setColor(BLACK);
        pathPaint.setStyle(STROKE);
        pathPaint.setStrokeWidth(10);
    }

    @Override
    protected void onMeasure(final int widthSpec, final int heightSpec) {
        super.onMeasure(widthSpec, heightSpec);
        setMeasuredDimension(
                getMeasuredWidth(),
                (int) (ASPECT_RATIO * getMeasuredWidth())
        );
    }

    @Override
    protected void onSizeChanged(final int w, final int h, final int oldw, final int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);

        path = new Path();
        path.moveTo(0, getHeight());
        path.lineTo(getWidth(), 0);
    }

    @Override
    protected void onDraw(@NonNull final Canvas canvas) {
        canvas.drawColor(CYAN);
        canvas.drawPath(path, pathPaint);
    }

}
