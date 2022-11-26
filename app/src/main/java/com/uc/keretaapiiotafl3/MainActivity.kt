package com.uc.keretaapiiotafl3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
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

        firebasedatabase = FirebaseDatabase.getInstance()
        databasereference = firebasedatabase?.getReference("sensor")
//        getData1()
        getData2()

    }

    private fun getData1(){
        databasereference?.get()?.addOnSuccessListener {
            var sens1= it.child("satu").value
            if (sens1 == true)
            {
                binding.sensor1tv.text = "Ada"

            }
           else if (sens1 == false)
            {
                binding.sensor1tv.text = "No"

            }
            var sens2= it.child("dua").value
            if (sens2 == true)
            {
                binding.sensor2tv.text = "Ada"

            }
            else if (sens2 == false)
            {
                binding.sensor2tv.text = "No"

            }

            var sens3= it.child("tiga").value
            if (sens3 == true)
            {
                binding.sensor3tv.text = "Ada"

            }
            else if (sens3 == false)
            {
                binding.sensor3tv.text = "No"

            }

            var sens4= it.child("empat").value
            if (sens4 == true)
            {
                binding.sensor4tv.text = "Ada"

            }
            else if (sens4 == false)
            {
                binding.sensor4tv.text = "No"

            }
           if ((sens1 == true && sens2 == true) || (sens2 == true && sens3 == true) || (sens3 == true && sens4 == true)){
               binding.statuspalangtv.text ="Terbuka"
           }
            else   {
               binding.statuspalangtv.text ="Tertutup"
            }

        }





    }   private fun getData2(){
        databasereference?.addValueEventListener(object : ValueEventListener{
            override fun onDataChange(snapshot: DataSnapshot) {
              var  sens1 = snapshot.child("satu").value
                if (sens1 == true)
                {
                    binding.sensor1tv.text = "Ada"

                }
                else if (sens1 == false)
                {
                    binding.sensor1tv.text = "No"

                }

                var  sens2 = snapshot.child("dua").value
                if (sens2 == true)
                {
                    binding.sensor2tv.text = "Ada"

                }
                else if (sens2 == false)
                {
                    binding.sensor2tv.text = "No"

                }

                var  sens3 = snapshot.child("tiga").value
                if (sens3 == true)
                {
                    binding.sensor3tv.text = "Ada"

                }
                else if (sens3 == false)
                {
                    binding.sensor3tv.text = "No"

                }
                var  sens4 = snapshot.child("empat").value
                if (sens4 == true)
                {
                    binding.sensor4tv.text = "Ada"

                }
                else if (sens4 == false)
                {
                    binding.sensor4tv.text = "No"

                }
                if ((sens1 == true && sens2 == true) || (sens2 == true && sens3 == true) || (sens3 == true && sens4 == true)){
                    binding.statuspalangtv.text ="Terbuka"
                }
                else   {
                    binding.statuspalangtv.text ="Tertutup"
                }


            }

            override fun onCancelled(error: DatabaseError) {
                TODO("Not yet implemented")
            }


        })
}}