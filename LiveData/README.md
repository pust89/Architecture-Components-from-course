setValue() or postValue()

There are two methods to update the value of a MutableLiveData instance.

setValue() and the postValue().

This setvalue() method must be called from the main thread.

If you need to set a value form a background thread you should use the postValue() method.

<code>
  
dependencies {



    def lifecycle_version = "2.1.0"

    // ViewModel and LiveData
    implementation "androidx.lifecycle:lifecycle-extensions:$lifecycle_version"
	


    annotationProcessor "androidx.lifecycle:lifecycle-compiler:$lifecycle_version" // For Kotlin use kapt instead of annotationProcessor
	
	
   
}

</code>




