package com.aurorabilisim.viewpager

import android.animation.ArgbEvaluator
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.viewpager.widget.ViewPager



class MainActivity : AppCompatActivity() {

    var viewPager: ViewPager? = null
    var adapter: Adapter? = null
    var models: ArrayList<Model>? = null

    var colors: Array<Int>? = null

    var argbEvaluator = ArgbEvaluator()

    var colors_temp: Array<Int>? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        models = ArrayList()
        models!!.add(Model(R.drawable.brochure, "Brochure", "Lorem Ipsum, adı bilinmeyen bir matbaacının bir hurufat numune kitabı oluşturmak üzere bir yazı galerisini alarak karıştırdığı 1500'lerden beri endüstri standardı sahte metinler olarak kullanılmıştır."))
        models!!.add(Model(R.drawable.sticker, "Sticker", "Beşyüz yıl boyunca varlığını sürdürmekle kalmamış, aynı zamanda pek değişmeden elektronik dizgiye de sıçramıştır."))
        models!!.add(Model(R.drawable.poster, "Poster", "Lorem Ipsum kullanmanın amacı, sürekli 'buraya metin gelecek, buraya metin gelecek' yazmaya kıyasla daha dengeli bir harf dağılımı sağlayarak okunurluğu artırmasıdır."))
        models!!.add(Model(R.drawable.namecard, "NameCard", "Şu anda birçok masaüstü yayıncılık paketi ve web sayfa düzenleyicisi, varsayılan mıgır metinler olarak Lorem Ipsum kullanmaktadır."))

        adapter = Adapter(models,this)
        viewPager = findViewById(R.id.viewPager)
        viewPager?.adapter = adapter
        viewPager!!.setPadding(130,0,130,0)

        colors_temp = arrayOf(
            resources.getColor(R.color.color1),
            resources.getColor(R.color.color2),
            resources.getColor(R.color.color3),
            resources.getColor(R.color.color4)
        )

        colors = colors_temp

        viewPager!!.setOnPageChangeListener(object : ViewPager.OnPageChangeListener{
            override fun onPageScrollStateChanged(state: Int) {

            }

            override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {
                if (position<(adapter!!.count - 1) && position<(colors!!.size-1)){

                    viewPager!!.setBackgroundColor(argbEvaluator.evaluate(positionOffset,colors!![position],colors!![position+1]) as Int)

                }else {
                    viewPager?.setBackgroundColor(colors!![colors!!.size-1])
                }

            }

            override fun onPageSelected(position: Int) {

            }

        })

    }
}
