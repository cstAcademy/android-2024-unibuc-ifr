package com.cst.academy2024unibucfmi.data

import androidx.room.Database
import androidx.room.RoomDatabase
import com.cst.academy2024unibucfmi.data.dao.ProductCategoryDao
import com.cst.academy2024unibucfmi.data.dao.ProductDao
import com.cst.academy2024unibucfmi.models.db.ProductCategoryDBModel
import com.cst.academy2024unibucfmi.models.db.ProductDBModel

@Database(
    entities = [
        ProductDBModel::class,
        ProductCategoryDBModel::class
    ], version = 2
)
abstract class AppDatabase : RoomDatabase() {
    abstract val productDao: ProductDao
    abstract val productCategoryDao: ProductCategoryDao
}