package com.example.myapplicationlab2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        //Mensajes para darle indicaciones al usuario
        Toast.makeText(this, "Desliza hacia la derecha para mas informacion", Toast.LENGTH_SHORT).show()
        Toast.makeText(this, "→", Toast.LENGTH_SHORT).show()

        //Aqui tendriamos el llamado a la actividad mapa gracias al boton mapa
        mapa.setOnClickListener {

            val intento1 = Intent(this, MapsActivity::class.java)
            startActivity(intento1)
        }

        //Aqui tendriamos el usu de Viewpager2
        setupViewPager2()


    }

    //Aqui estan los datos que apareceran en cada vista de la ViewPager2
    private fun setupViewPager2() {
        val list: MutableList<String> = ArrayList()
        list.add("Desarrollador: ")
        list.add("Mapa de El Salvador: ")


        val list2: MutableList<String> = ArrayList()
        list2.add("Edwin Adony Ulloa Diaz")
        list2.add("Se muestra la ubicación exacta de la Universidad Gerardo Barrios")

        val colorList: MutableList<String> = ArrayList()
        colorList.add("#84b6f4")
        colorList.add("#fdfd96")

        // Set adapter to viewPager.
        viewPager.adapter = ViewPagerAdapter(this, list, list2, colorList)
    }

    //Donde creamos el menu de opciones que los dara la opcion de ver mas informacion del desarrollador
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    //Aqui los canbiamos a la actividy Informacion
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.info-> {
                val intent = Intent(this, Information::class.java)
                startActivity(intent)
                // using finish() to end the activity
                finish()
            }
        }
        return super.onOptionsItemSelected(item)
    }

}