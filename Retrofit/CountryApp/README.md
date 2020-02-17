
<code>



dataBinding{
enabled = true
}


    compileOptions {
        sourceCompatibility = 1.8
        targetCompatibility = 1.8
    }




      //Retrofit
    implementation 'com.squareup.retrofit2:retrofit:2.7.1'
    //for import retrofit2.converter.gson.GsonConverterFactory;
    implementation 'com.squareup.retrofit2:converter-gson:2.7.1'


    //@SerializedName and @Expose
    implementation 'com.google.code.gson:gson:2.8.6'


    // ViewModel and LiveData
    def lifecycle_version = "2.1.0"
    implementation "androidx.lifecycle:lifecycle-extensions:$lifecycle_version"
    implementation "androidx.lifecycle:lifecycle-common-java8:$lifecycle_version"
}

</code>




