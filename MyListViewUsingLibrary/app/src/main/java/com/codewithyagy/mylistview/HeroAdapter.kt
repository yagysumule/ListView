package com.codewithyagy.mylistview

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import de.hdodenhof.circleimageview.CircleImageView

/*
Constructor digunakan untuk mengirimkan data atau melakukan suatu proses ketika suatu objek diinisialiasi.
Dalam kasus ini constructor digunakan untuk mengirim context ke dalam adapter
 */
class HeroAdapter internal constructor(private val context: Context) : BaseAdapter() {

    /*
     Varibel heroes berfungsi untuk menampung data yang dikirim dari activity dan
     digunakan sebagai sumber data untuk dimasukkan ke dalam ViewHolder
     */
    internal var heroes = arrayListOf<Hero>()


    /*
    Proses pemanggilan textview dan settext.
    Metode getView() digunakan untuk memanggil layout item xml yang sudah dibuat
    dan melakukan proses manipulasi setiap komponennya seperti textview dan imageview melalui kelas ViewHolder
    */
    override fun getView(position: Int, view: View?, viewGroup: ViewGroup): View {
        var itemView = view
        if (itemView == null) {
            itemView = LayoutInflater.from(context).inflate(R.layout.item_hero, viewGroup, false)
        }

        val viewHolder = ViewHolder(itemView as View)

        val hero = getItem(position) as Hero
        viewHolder.bind(hero)
        return itemView
    }

    // override fun getItem(i: Int): Any = heroes[i] .bisa disingkat seperti ini
    override fun getItem(i: Int): Any {
        return heroes[i]
    }

    // override fun getItemId(i: Int): Long = i.toLong() .bisa disingkat seperti ini
    override fun getItemId(i: Int): Long {
        return i.toLong()
    }

    /*
    override fun getCount(): Int = heroes.size .bisa disingkat seperti ini
    Metode getCount() digunakan untuk mengetahui berapa banyak item yang akan ditampilkan
     */
    override fun getCount(): Int {
        return heroes.size
    }

    private inner class ViewHolder constructor(private val view: View) {
        private val txtName: TextView = view.findViewById(R.id.txt_name)
        private val txtDescription: TextView = view.findViewById(R.id.txt_description)
        private val imgPhoto: CircleImageView = view.findViewById(R.id.img_photo)

        internal fun bind(hero: Hero) {
            txtName.text = hero.name
            txtDescription.text = hero.description
            imgPhoto.setImageResource(hero.photo)
        }
    }

}