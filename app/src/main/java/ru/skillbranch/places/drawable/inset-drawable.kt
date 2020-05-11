package ru.skillbranch.places.drawable

import android.graphics.drawable.Drawable
import android.graphics.drawable.InsetDrawable

fun insetLeftDrawable(drawable: Drawable, inset: Int) =
    InsetDrawable(drawable, 0, -inset, -inset, -inset)

fun insetTopDrawable(drawable: Drawable, inset: Int) =
    InsetDrawable(drawable, -inset, 0, -inset, -inset)

fun insetRightDrawable(drawable: Drawable, inset: Int) =
    InsetDrawable(drawable, -inset, -inset, 0, -inset)

fun insetBottomDrawable(drawable: Drawable, inset: Int) =
    InsetDrawable(drawable, -inset, -inset, -inset, 0)

fun insetLeftTopDrawable(drawable: Drawable, inset: Int) =
    InsetDrawable(drawable, 0, 0, -inset, -inset)

fun insetInnerLeftDrawable(drawable: Drawable, inset: Int) =
    InsetDrawable(drawable, -inset, 0, 0, 0)

fun insetInnerRightDrawable(drawable: Drawable, inset: Int) =
    InsetDrawable(drawable, 0, 0, -inset, 0)

fun insetDrawable(drawable: Drawable, insetLeft: Int, insetTop: Int, insetRight: Int, insetBottom: Int) =
    InsetDrawable(drawable, insetLeft, insetTop, insetRight, insetBottom)