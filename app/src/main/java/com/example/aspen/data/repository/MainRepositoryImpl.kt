package com.example.aspen.data.repository

import com.example.aspen.data.source.local.MainRoomDB
import com.example.aspen.data.source.remote.MainService
import com.example.aspen.domain.repository.MainRepository
import javax.inject.Inject

class MainRepositoryImpl @Inject constructor(
    private val mainService: MainService,
    private val mainRoomDB: MainRoomDB,
) : MainRepository