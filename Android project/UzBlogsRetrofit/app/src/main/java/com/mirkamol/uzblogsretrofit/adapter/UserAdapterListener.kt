package com.mirkamol.uzblogsretrofit.adapter

import com.mirkamol.uzblogsretrofit.model.UserModel

interface UserAdapterListener {
    fun onClick(item:UserModel)
}