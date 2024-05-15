package com.cst.academy2024unibucfmi.data.tasks.product

import android.os.AsyncTask
import com.cst.academy2024unibucfmi.ApplicationController
import com.cst.academy2024unibucfmi.models.db.ProductCategoryDBModel
import com.cst.academy2024unibucfmi.models.db.ProductDBModel

class InsertProductTask(
    val product: ProductDBModel,
    val category: ProductCategoryDBModel,
    val onFinish: () -> Unit
): AsyncTask<Unit, Unit, Unit>() {
    @Deprecated("Deprecated in Java")
    override fun doInBackground(vararg params: Unit) {
        ApplicationController.instance.appDatabase.productDao.insert(product)
        ApplicationController.instance.appDatabase.productCategoryDao.insert(category)
    }

    @Deprecated("Deprecated in Java")
    override fun onPostExecute(result: Unit?) {
        super.onPostExecute(result)

        onFinish.invoke()
    }
}