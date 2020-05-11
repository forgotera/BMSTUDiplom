package ru.skillbranch.places.drawable

import android.content.Context
import android.graphics.Color
import android.graphics.drawable.Drawable
import android.graphics.drawable.GradientDrawable
import android.graphics.drawable.LayerDrawable
import androidx.annotation.ColorInt
import androidx.annotation.IntRange
import androidx.annotation.Px
import androidx.core.graphics.ColorUtils
import ru.skillbranch.places.utils.dip

var GradientDrawable.solidColor: Int
    set(value) = setColor(value)
    get() = error("sorry")

var GradientDrawable.size: Int
    set(value) = setSize(value, value)
    get() = intrinsicWidth

fun shapeDrawable(colors: IntArray) =
    GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, colors).apply {
        shape = GradientDrawable.RECTANGLE
    }

fun shapeDrawable(colors: IntArray, init: GradientDrawable.() -> Unit) =
    GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, colors).apply {
        shape = GradientDrawable.RECTANGLE
        init()
    }

fun shapeDrawable(shape: Int, init: GradientDrawable.() -> Unit) =
    GradientDrawable().apply {
        this.shape = shape
        init()
    }

fun ovalDrawable(init: GradientDrawable.() -> Unit) = shapeDrawable(GradientDrawable.OVAL, init)
fun lineDrawable(init: GradientDrawable.() -> Unit) = shapeDrawable(GradientDrawable.LINE, init)
fun ringDrawable(init: GradientDrawable.() -> Unit) = shapeDrawable(GradientDrawable.RING, init)
fun rectangleDrawable(init: GradientDrawable.() -> Unit) = shapeDrawable(GradientDrawable.RECTANGLE, init)

fun circleDrawable(@ColorInt color: Int) =
    ovalDrawable { solidColor = color }

fun squareDrawable(@ColorInt color: Int) =
    rectangleDrawable { solidColor = color }

fun squareDrawable(@Px corner: Int, @ColorInt color: Int) =
    rectangleDrawable {
        cornerRadius = corner.toFloat()
        solidColor = color
    }

fun Context.gapDrawable(@Px corner: Int, @ColorInt color: Int) =
    rectangleDrawable {
        solidColor = Color.TRANSPARENT
        cornerRadius = corner.toFloat()
        setStroke(dip(2), color, dip(8).toFloat(), dip(8).toFloat())

    }

fun leftCorners(
    radius: Float,
    @ColorInt solidColor: Int? = null,
    stroke: Int? = null,
    @ColorInt strokeColor: Int? = null
): Drawable =
    corners(
        leftTop = radius,
        leftBottom = radius,
        solidColor = solidColor,
        stroke = stroke,
        strokeColor = strokeColor
    )

fun topCorners(
    radius: Float,
    @ColorInt solidColor: Int? = null,
    stroke: Int? = null,
    @ColorInt strokeColor: Int? = null
): Drawable =
    corners(
        leftTop = radius,
        rightTop = radius,
        solidColor = solidColor,
        stroke = stroke,
        strokeColor = strokeColor
    )

fun rightCorners(
    radius: Float,
    @ColorInt solidColor: Int? = null,
    stroke: Int? = null,
    @ColorInt strokeColor: Int? = null
): Drawable =
    corners(
        rightTop = radius,
        rightBottom = radius,
        solidColor = solidColor,
        stroke = stroke,
        strokeColor = strokeColor
    )

fun bottomCorners(
    radius: Float,
    @ColorInt solidColor: Int? = null,
    stroke: Int? = null,
    @ColorInt strokeColor: Int? = null
): Drawable =
    corners(
        leftBottom = radius,
        rightBottom = radius,
        solidColor = solidColor,
        stroke = stroke,
        strokeColor = strokeColor
    )

fun corners(
    leftTop: Float = 0F,
    rightTop: Float = 0F,
    leftBottom: Float = 0F,
    rightBottom: Float = 0F,
    @ColorInt solidColor: Int? = null,
    stroke: Int? = null,
    @ColorInt strokeColor: Int? = null
): Drawable =
    rectangleDrawable {
        solidColor?.let {
            this.solidColor = it
        }

        if (stroke != null && strokeColor != null) {
            setStroke(stroke, strokeColor)
        }

        cornerRadii = floatArrayOf(
            leftTop, leftTop,
            rightTop, rightTop,
            rightBottom, rightBottom,
            leftBottom, leftBottom
        )
    }


fun gradientDrawable(colors: IntArray) =
    shapeDrawable(colors)

fun gradientDrawable(@Px corner: Int, colors: IntArray) =
    shapeDrawable(colors) {
        cornerRadius = corner.toFloat()
    }

fun Context.borderDrawable(@ColorInt color: Int) =
    rectangleDrawable { setStroke(dip(1), color) }

fun Context.borderDrawable(@Px corner: Int, @ColorInt color: Int) =
    borderDrawable(corner, color, Color.WHITE)

fun Context.borderDrawable(@Px corner: Int, @ColorInt color: Int, @ColorInt solid: Int) =
    rectangleDrawable {
        cornerRadius = corner.toFloat()
        setStroke(dip(1), color)
        solidColor = solid
    }

fun roundDrawable(@Px corner: Int, @ColorInt color: Int) =
    rectangleDrawable {
        cornerRadius = corner.toFloat()
        solidColor = color
    }

fun gradientRange(
    @ColorInt color: Int,
    @IntRange(from = 0x0, to = 0xFF) from: Int,
    @IntRange(from = 0x0, to = 0xFF) to: Int
) = intArrayOf(
    ColorUtils.setAlphaComponent(color, from),
    ColorUtils.setAlphaComponent(color, to)
)

fun gradientRange(
    @ColorInt fromColor: Int,
    @IntRange(from = 0x0, to = 0xFF) from: Int,
    @ColorInt toColor: Int,
    @IntRange(from = 0x0, to = 0xFF) to: Int
) = intArrayOf(
    ColorUtils.setAlphaComponent(fromColor, from),
    ColorUtils.setAlphaComponent(toColor, to)
)

fun layerDrawable(vararg ds: Drawable): LayerDrawable =
    LayerDrawable(ds)