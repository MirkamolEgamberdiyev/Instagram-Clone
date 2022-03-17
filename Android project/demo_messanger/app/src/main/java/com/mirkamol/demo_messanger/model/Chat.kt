package com.mirkamol.demo_messanger.model

class Chat {
    var message: Message? = null
    var rooms: ArrayList<Room> = ArrayList()

    constructor(message: Message) {
        this.message = message
    }
    constructor(rooms: ArrayList<Room>) {
        this.rooms = rooms
    }
}
