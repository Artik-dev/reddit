package com.artik.reddit.main.ui

import android.content.ContentResolver
import android.graphics.Bitmap
import android.provider.MediaStore
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList
import com.artik.core.Constants
import com.artik.core.PermissionManager
import com.artik.core.base.BaseViewModel
import com.artik.domain.useCase.top.TopUseCase
import com.artik.reddit.R
import com.artik.reddit.main.adapter.ImageClickHandler
import com.artik.reddit.main.dataSource.MainDataSource
import java.util.concurrent.Executors

class MainViewModel(
    private val useCase: TopUseCase,
    private val router: IMainRouter,
    private val permissionManager: PermissionManager,
    private val contentResolver: ContentResolver
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
        router.showLargeImageDialog(largeImageUrl) {
            onSaveImageClickAction(it)
        }
    }

    private fun onSaveImageClickAction(image: Bitmap) {
        permissionManager.askStoragePermissionIfNeed(
            { saveImageToGallery(image) },
            { onSaveImageErrorAction() },
            { onSaveImageErrorAction() })
    }

    private fun saveImageToGallery(image: Bitmap) {
        MediaStore.Images.Media.insertImage(contentResolver, image, getFormattedImageName(), "")
        router.showToast(R.string.image_saved)
    }

    private fun onSaveImageErrorAction() {
        router.showToast(R.string.image_not_saved)
        router.showToast(R.string.permission_error_massage_store)
    }

    private fun getFormattedImageName(): String {
        return Constants.SIMPLE_DATA_FORMAT_YYYY_MM_DD_HH_MM_SS.format(System.currentTimeMillis())
    }
}