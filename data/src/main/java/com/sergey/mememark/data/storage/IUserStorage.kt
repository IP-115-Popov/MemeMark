package com.sergey.mememark.data.storage

import com.sergey.mememark.data.storage.models.UserForStorage

interface IUserStorage {
    fun save(saveparam: UserForStorage):Boolean
    fun get():UserForStorage
}