package ru.skillbranch.places.utils

import android.app.Activity
import android.content.Context
import android.content.ContextWrapper
import android.content.res.ColorStateList
import android.graphics.Point
import android.graphics.drawable.BitmapDrawable
import android.graphics.drawable.Drawable
import android.graphics.drawable.LayerDrawable
import android.graphics.drawable.ScaleDrawable
import android.view.Gravity
import android.view.View
import androidx.annotation.ColorInt
import androidx.annotation.ColorRes
import androidx.annotation.DrawableRes
import androidx.core.content.ContextCompat
import androidx.core.graphics.drawable.DrawableCompat
import androidx.vectordrawable.graphics.drawable.VectorDrawableCompat

private val MAIN_THREAD_POINT = Point()


@ColorInt
fun Context.color(@ColorRes res: Int): Int =
    ContextCompat.getColor(this, res)

fun Context.drawable(@DrawableRes res: Int): Drawable =
    ContextCompat.getDrawable(this, res) ?: error("Not found drawable!")

fun Drawable.tint(@ColorInt color: Int): Drawable =
    DrawableCompat.wrap(this).apply { DrawableCompat.setTint(this, color) }

fun Drawable.tint(tint: ColorStateList?): Drawable =
    DrawableCompat.wrap(this).apply { DrawableCompat.setTintList(this, tint) }

fun Context.bitmapDrawable(@DrawableRes res: Int): BitmapDrawable =
    drawable(res) as BitmapDrawable

inline fun scaleDrawable(scale: Float, gravity: Int = Gravity.CENTER, block: () -> Drawable): ScaleDrawable =
    ScaleDrawable(block(), gravity, scale, scale).apply {
        // hacking dem android drawables
        level = 1
    }

fun Context.vectorDrawable(@DrawableRes resource: Int): VectorDrawableCompat =
    nullableVectorDrawable(resource) ?: error("Not found vector drawable")

fun View.vectorDrawable(@DrawableRes resource: Int): VectorDrawableCompat =
    nullableVectorDrawable(resource) ?: error("Not found vector drawable")

fun Context.nullableVectorDrawable(@DrawableRes resource: Int?): VectorDrawableCompat? =
    resource?.let { VectorDrawableCompat.create(resources, resource, null) }

fun View.nullableVectorDrawable(@DrawableRes resource: Int?): VectorDrawableCompat? =
    resource?.let { VectorDrawableCompat.create(resources, resource, null) }

fun VectorDrawableCompat.vectorTint(@ColorInt color: Int): Drawable =
    mutate().also { setTint(color) }

fun VectorDrawableCompat.vectorTint(tint: ColorStateList?): Drawable =
    mutate().also { setTintList(tint) }

fun layerDrawable(vararg ds: Drawable): LayerDrawable =
    LayerDrawable(ds)

tailrec fun Context.activity(): Activity? = when (this) {
    is Activity     -> this
    else            -> (this as? ContextWrapper)?.baseContext?.activity()
}