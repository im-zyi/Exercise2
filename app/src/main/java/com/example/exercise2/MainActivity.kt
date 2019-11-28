package com.example.exercise2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.telephony.SmsMessage
import android.view.Gravity
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import java.io.IOException
import java.security.AccessController.getContext

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        textViewBMI.text=""

            button_Calculate.setOnClickListener() {
                try {
                    val height: Double = editHeight.text.toString().toDouble() / 100
                    val weight: Double = editWeight.text.toString().toDouble()
                    val BMI: Double = calculateBMI(height, weight)
                    var status: String = ""
                    if (BMI < 18.5) {
                        status = "Underweight"
                        imageResult.setImageResource(R.drawable.under)

                    } else if (BMI >= 18.5 && BMI <= 24.9) {
                        status = "Normal"
                        imageResult.setImageResource(R.drawable.normal)
                    } else {
                        status = "Overweight"
                        imageResult.setImageResource(R.drawable.over)
                    }
                    textViewBMI.text =
                        "BMI: " + String.format("%.2f", BMI) + "(" + status + ")" + "%.2f".format(
                            BMI
                        )
                }   catch (ex:  Exception){
                    val toast:Toast= Toast.makeText(applicationContext,"Please enter height and weight",Toast.LENGTH_SHORT)
                    toast.setGravity(Gravity.CENTER,0,0)
                    toast.show()

                }
            }



        button_Reset.setOnClickListener(){
            editHeight.text.clear()
            editWeight.text.clear() //editWeight.setText("")
            imageResult.setImageResource(R.drawable.empty)

            textViewBMI.setText("")
            editHeight.requestFocus()
        }
    }
    private fun calculateBMI(height:Double,weight:Double):Double{
            return weight/(height*height)
    }
}
