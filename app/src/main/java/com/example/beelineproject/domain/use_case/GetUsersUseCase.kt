package com.example.beelineproject.domain.use_case

import com.example.beelineproject.data.models.Users
import com.example.beelineproject.data.repo.UserRepo
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import javax.inject.Inject

class GetUsersUseCase @Inject constructor(
    private val userRepo : UserRepo) {

//    operator fun invoke(): Observable<Unit>{
//        return userRepo.getAll()
//            .map{
//                val list = mutableListOf<Users>()
//            }
//            .observeOn(AndroidSchedulers.mainThread())
//    }
}