package com.mirkamol.firebaseexamplesanjarsuvonov.model

 class User{
     var name:String? =null
     var email:String? = null
     var password:String? = null

     constructor(name: String?, email: String?, password: String?) {
         this.name = name
         this.email = email
         this.password = password
     }

     constructor()

     override fun toString(): String {
         return "User(name=$name, email=$email, password=$password)"
     }

     override fun equals(other: Any?): Boolean {
         if (this === other) return true
         if (javaClass != other?.javaClass) return false

         other as User

         if (name != other.name) return false
         if (email != other.email) return false
         if (password != other.password) return false

         return true
     }

     override fun hashCode(): Int {
         var result = name?.hashCode() ?: 0
         result = 31 * result + (email?.hashCode() ?: 0)
         result = 31 * result + (password?.hashCode() ?: 0)
         return result
     }
 }