package com.artik.reddit.main.ui

import android.graphics.Bitmap
import android.os.Environment
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList
import com.artik.core.base.BaseViewModel
import com.artik.domain.useCase.top.TopUseCase
import com.artik.reddit.main.adapter.ImageClickHandler
import com.artik.reddit.main.dataSource.MainDataSource
import java.io.File
import java.io.FileNotFoundException
import java.io.FileOutputStream
import java.io.IOException
import java.util.concurrent.Executors

class MainViewModel(
    private val useCase: TopUseCase,
    private val router: IMainRouter
) : BaseViewModel(), ImageClickHandler {

    private val factory = MainDataSource.Factory(
        useCase,
        ioScope
    )

    private val pagedListConfig = PagedList.Config.Builder()
        .setEnablePlaceholders(true)
        .setPageSize(MainDataSource.PAGE_SIZE)
        .build()

    val mainRecyclerDataSource = LivePagedListBuilder(
        factory,
        pagedListConfig
    ).setFetchExecutor(Executors.newSingleThreadExecutor()).build()

   override fun onImageClickAction(largeImageUrl: String) {
     router.showLargeImageDialog(largeImageUrl){fileName, bitmap ->
         onSaveImageClickAction(fileName, bitmap)
     }
    }

   private fun onSaveImageClickAction(fileName:String, image: Bitmap) {
        val storageLoc =
            Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES)

        val file = File(storageLoc, "$fileName.jpg");

        try {
            val fos = FileOutputStream(file)
            image.compress(Bitmap.CompressFormat.JPEG, 100, fos);
            fos.close();

        } catch (e: FileNotFoundException) {
            e.printStackTrace();
        } catch (e: IOException) {
            e.printStackTrace();
        }
    }
}