package com.mirkamol.roomdatabaseexample.database.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.mirkamol.roomdatabaseexample.database.entity.Product

@Dao
interface ProductDao {
    @Insert()
    fun insertProduct(product: Product)
    @Query("SELECT * FROM table_name")
    fun getAllProduct():List<Product>

    @Query("SELECT * FROM table_name WHERE productId=:product")
    fun getItEM(product: Int):Product

  @Query("DELETE FROM table_name")
  fun clearProduct()

  @Query("DELETE FROM table_name WHERE productId =:productId")
  fun removeProduct(productId:Int)

}