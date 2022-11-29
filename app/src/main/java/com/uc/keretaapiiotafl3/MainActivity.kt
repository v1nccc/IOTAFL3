package com.uc.keretaapiiotafl3

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.annotation.RequiresApi
import com.google.firebase.database.*
import com.uc.keretaapiiotafl3.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private var firebasedatabase: FirebaseDatabase? =  null
    private var databasereference: DatabaseReference? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.hide()

        firebasedatabase = FirebaseDatabase.getInstance()
        databasereference = firebasedatabase?.getReference("sensor")
        getData2()

    }


    private fun getData2(){
        databasereference?.addValueEventListener(object : ValueEventListener{
            override fun onDataChange(snapshot: DataSnapshot) {
              var  sens1 = snapshot.child("satu").value
                if (sens1 == true)
                {
                    binding.sensor1tv.text = "ada"
                    binding.cvSensro1.setCardBackgroundColor(getColor(R.color.teal_200))
                }else{
                    binding.sensor1tv.text = "No"
                    binding.cvSensro1.setCardBackgroundColor(getColor(R.color.white))
                }


                var  sens2 = snapshot.child("dua").value
                if (sens2 == true)
                {
                    binding.sensor2tv.text = "Ada"
                    binding.cvSensro2.setCardBackgroundColor(getColor(R.color.teal_200))
                }else{
                    binding.sensor2tv.text = "No"
                    binding.cvSensro2.setCardBackgroundColor(getColor(R.color.white))
                }

                var  sens3 = snapshot.child("tiga").value
                if (sens3 == true)
                {
                    binding.sensor3tv.text = "Ada"
                    binding.cvSensro3.setCardBackgroundColor(getColor(R.color.teal_200))
                }else{
                    binding.sensor3tv.text = "No"
                    binding.cvSensro3.setCardBackgroundColor(getColor(R.color.white))
                }

                var  sens4 = snapshot.child("empat").value
                if (sens4 == true)
                {
                    binding.sensor4tv.text = "Ada"
                    binding.cvSensro4.setCardBackgroundColor(getColor(R.color.teal_200))
                }else{
                    binding.sensor4tv.text = "No"
                    binding.cvSensro4.setCardBackgroundColor(getColor(R.color.white))
                }

                if ((sens1 == true && sens2 == true) || (sens2 == true && sens3 == true) || (sens3 == true && sens4 == true)){
                    binding.statuspalangtv.text ="Tertutup"
                }
                else   {
                    binding.statuspalangtv.text ="Terbuka"
                }


            }

            override fun onCancelled(error: DatabaseError) {
                TODO("Not yet implemented")
            }

        })
}}