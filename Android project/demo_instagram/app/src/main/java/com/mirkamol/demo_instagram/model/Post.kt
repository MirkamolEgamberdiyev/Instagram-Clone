package com.mirkamol.demo_instagram.model

class Post {
    val profile:Int
    val fullName:String
    var photo:Int = 0
    var photos: List<Photos> = ArrayList()

    constructor(profile: Int, photo: Int, fullName: String){
        this.profile = profile
        this.photo = photo
        this.fullName = fullName
    }

    constructor(profile: Int, photos: List<Photos>, fullName: String){
        this.profile = profile
        this.photos = photos
        this.fullName = fullName
    }
}