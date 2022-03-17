package com.mirkamol.roomdatabaseexample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.mirkamol.roomdatabaseexample.database.AppDatabase
import com.mirkamol.roomdatabaseexample.database.dao.ProductDao
import com.mirkamol.roomdatabaseexample.database.entity.Product
import com.mirkamol.roomdatabaseexample.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding:ActivityMainBinding
    lateinit var appDatabase: AppDatabase
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding  = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        appDatabase = AppDatabase.getInstance(this)
        binding.apply {
            saveBtn.setOnClickListener{
                var product = Product(name = productName.text.toString(),
                    price = productPrice.text.toString().toInt())
                appDatabase.productDao().insertProduct(product)

            }


            getAllProductBtn.setOnClickListener {
                Log.d("products", appDatabase.productDao().getAllProduct().toString())
            }

            deleteAllBtn.setOnClickListener {
                appDatabase.productDao().clearProduct()
            }

        }

    }
}