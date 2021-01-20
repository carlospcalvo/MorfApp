package com.krlo.morfapp

import android.graphics.drawable.Drawable
import android.os.Build
import android.os.Bundle
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import com.krlo.morfapp.R.drawable
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : AppCompatActivity() {

    class Food(var name: String, var icon: Int)

    val foodList = arrayListOf(
        Food("McDonald's", drawable.burger),
        Food("Burger King", drawable.burger),
        Food("Shawarma", drawable.tacos),
        Food("Pollo", drawable.pollo),
        Food("Pizza", drawable.pizza),
        Food("Panchos", drawable.pancho),
        Food("Ensalada", drawable.ensalada),
        Food("Empanadas", drawable.empanadas),
        Food("Churrascos", drawable.carne)

        )

    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        lucky_button.setOnClickListener {
            val random = Random()
            val randomFood = random.nextInt(foodList.count())
            val image = this.getDrawable(foodList[randomFood].icon)
            selected_food.text = foodList[randomFood].name
            imageView2.setImageDrawable(image)
        }

        btnAgregar.setOnClickListener{
            val food = Food(textFieldAgregar.text.toString(), R.drawable.cubiertos)
            if(!food.name.isBlank()){
                this.foodList.add(food)
                Toast.makeText(this, "Comida agregada!", Toast.LENGTH_SHORT).show()
            }

            textFieldAgregar.text.clear()
        }
    }
}