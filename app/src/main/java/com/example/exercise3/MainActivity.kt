package com.example.exercise3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
lateinit var myData:PremiumModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)
        fun display(){
            if(myData.premiumAmount!=0.0)
                data.text=myData.premiumAmount.toString()
        }

        fun getPremium():Double{
            return when(spinnerAge.selectedItemPosition){
                0->60.00
                1->70.00+
                        (if(radMale.isChecked)50.00 else 0.0)+
                        (if(chkSmoker.isChecked)100.00 else 0.0)
                2->90.00+
                        (if(radMale.isChecked)100.00 else 0.0)+
                        (if(chkSmoker.isChecked)150.00 else 0.0)
                3->120.00+
                        (if(radMale.isChecked)150.00 else 0.0)+
                        (if(chkSmoker.isChecked)200.00 else 0.0)
                4->150.00+
                        (if(radMale.isChecked)200.00 else 0.0)+
                        (if(chkSmoker.isChecked)250.00 else 0.0)
                else->150.00+
                        (if(radMale.isChecked)200.00 else 0.0)+
                        (if(chkSmoker.isChecked)300.00 else 0.0)

            }
        }
        myData= ViewModelProviders.of(this).get(PremiumModel::class.java)
        display()
        btnCal.setOnClickListener() {


            try {
                myData.premiumAmount= getPremium()

                display()
            } catch (ex: Exception) {
                val toast: Toast =
                    Toast.makeText(applicationContext, "Invalid Input", Toast.LENGTH_LONG)
                toast.setGravity(Gravity.CENTER, 0, 0)
                toast.show()

            }



        }
            btnReset.setOnClickListener() {
                spinnerAge.setSelection(0)
                radGroup.clearCheck()
                chkSmoker.setChecked(false)
                data.setText("")
            }
        }

    }

