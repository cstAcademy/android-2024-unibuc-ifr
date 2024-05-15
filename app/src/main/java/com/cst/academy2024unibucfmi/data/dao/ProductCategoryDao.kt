package com.cst.academy2024unibucfmi.data.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Transaction
import com.cst.academy2024unibucfmi.models.db.CategoryWithProductsDBModel
import com.cst.academy2024unibucfmi.models.db.ProductCategoryDBModel

@Dao
interface ProductCategoryDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insert(model: ProductCategoryDBModel)

    @Query("SELECT * From product_category")
    fun getAllWithProducts(): List<CategoryWithProductsDBModel>
}