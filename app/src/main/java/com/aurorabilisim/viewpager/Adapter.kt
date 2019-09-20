package com.aurorabilisim.viewpager

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.viewpager.widget.PagerAdapter

class Adapter : PagerAdapter {

    var models: List<Model>? = null
    var layoutInflater: LayoutInflater? = null
    var context: Context? = null

    constructor(models: List<Model>?, context: Context?) {
        this.models = models
        this.context = context
    }


    override fun isViewFromObject(view: View, `object`: Any): Boolean {
        return view.equals(`object`)
    }

    override fun getCount(): Int {
        return models!!.size
    }

    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        layoutInflater = LayoutInflater.from(context)
        val view = layoutInflater!!.inflate(R.layout.item_pager, container, false)

        val img = view.findViewById<ImageView>(R.id.img)
        val title = view.findViewById<TextView>(R.id.title)
        val desc = view.findViewById<TextView>(R.id.desc)

        img.setImageResource(models?.get(position)?.img!!)
        title.setText(models?.get(position)?.title!!)
        desc.setText(models?.get(position)?.desc!!)

        container.addView(view, 0)

        return view
    }

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        container.removeView(`object` as View?)
    }
}