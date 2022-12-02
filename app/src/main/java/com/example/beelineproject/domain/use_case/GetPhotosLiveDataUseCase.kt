package com.example.beelineproject.domain.use_case

import androidx.lifecycle.LiveData
import com.example.beelineproject.data.models.Photos
import com.example.beelineproject.data.repo.PhotosRepo
import javax.inject.Inject


class GetPhotosLiveDataUseCase @Inject constructor(
    private val photosRepo: PhotosRepo
) {
    operator  fun invoke(): LiveData<List<Photos>> {
        return photosRepo.getPhotoFRomDB()
    }
}