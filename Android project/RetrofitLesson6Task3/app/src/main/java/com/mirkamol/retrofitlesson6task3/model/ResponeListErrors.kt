package com.mirkamol.retrofitlesson6task3.model

data class ResponeListErrors<T>(
    var status:String,
    var data:List<T>,
    var message:String
)