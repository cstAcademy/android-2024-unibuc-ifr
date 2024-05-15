package com.cst.academy2024unibucfmi.data.tasks.product

import android.os.AsyncTask
import com.cst.academy2024unibucfmi.ApplicationController
import com.cst.academy2024unibucfmi.models.db.ProductCategoryDBModel
import com.cst.academy2024unibucfmi.models.db.ProductDBModel

class InsertProductCategoryTask(
    val onFinish: () -> Unit
): AsyncTask<ProductCategoryDBModel, Unit, Unit>() {
    @Deprecated("Deprecated in Java")
    override fun doInBackground(vararg params: ProductCategoryDBModel?) {
        params.getOrNull(0)?.let { productCategory ->
            ApplicationController.instance.appDatabase.productCategoryDao.insert(productCategory)
        }
    }

    @Deprecated("Deprecated in Java")
    override fun onPostExecute(result: Unit?) {
        super.onPostExecute(result)

        onFinish.invoke()
    }
}