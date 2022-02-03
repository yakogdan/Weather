package com.yakogdan.weather.decoration

import android.graphics.Rect
import android.view.View
import androidx.recyclerview.widget.RecyclerView

class DividerDecoration(
    private val start: Int,
    private val end: Int,
    private var top: Int,
    private var bottom: Int
) : RecyclerView.ItemDecoration() {

    override fun getItemOffsets(
        outRect: Rect,
        view: View,
        parent: RecyclerView,
        state: RecyclerView.State
    ) {
        super.getItemOffsets(outRect, view, parent, state)

        with(outRect) {
            left = this@DividerDecoration.start
            right = this@DividerDecoration.end
            top = this@DividerDecoration.top
            bottom = this@DividerDecoration.bottom
        }
    }

}