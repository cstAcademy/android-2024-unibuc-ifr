package com.cst.academy2024unibucfmi.data.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.cst.academy2024unibucfmi.models.db.ProductDBModel

@Dao
interface ProductDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insert(product: ProductDBModel)

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insertAll(products: List<ProductDBModel>)

    @Query("SELECT * FROM products")
    fun getAll(): List<ProductDBModel>

}