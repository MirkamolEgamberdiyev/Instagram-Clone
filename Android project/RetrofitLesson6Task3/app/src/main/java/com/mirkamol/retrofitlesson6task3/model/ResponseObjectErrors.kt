package com.mirkamol.retrofitlesson6task3.model
data class ResponseObjectErrors<T>(
    var status:String,
    var data:T,
    var message:String,
)
