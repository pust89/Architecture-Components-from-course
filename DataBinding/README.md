

<code>
  
  //add dataBinding {enabled = true}
  
  
  android {
    compileSdkVersion 29
    buildToolsVersion "29.0.2"
	...

    dataBinding{
    enabled = true
    }
	...
	
    defaultConfig {
        applicationId "com.pustovit.bindingdemo"
		.
		.
		.
    }
  
  
dependencies {
    def lifecycle_version = "2.1.0"

    // ViewModel and LiveData
    implementation "androidx.lifecycle:lifecycle-extensions:$lifecycle_version"
	
	
    // alternatively - just ViewModel
    implementation "androidx.lifecycle:lifecycle-viewmodel:$lifecycle_version" // For Kotlin use lifecycle-viewmodel-ktx
	
	
    // alternatively - just LiveData
    implementation "androidx.lifecycle:lifecycle-livedata:$lifecycle_version"
	
	
    // alternatively - Lifecycles only (no ViewModel or LiveData). Some UI
    //     AndroidX libraries use this lightweight import for Lifecycle
    implementation "androidx.lifecycle:lifecycle-runtime:$lifecycle_version"

    annotationProcessor "androidx.lifecycle:lifecycle-compiler:$lifecycle_version" // For Kotlin use kapt instead of annotationProcessor
	
	
    // alternately - if using Java8, use the following instead of lifecycle-compiler
    implementation "androidx.lifecycle:lifecycle-common-java8:$lifecycle_version"



    // optional - ReactiveStreams support for LiveData
    implementation "androidx.lifecycle:lifecycle-reactivestreams:$lifecycle_version" // For Kotlin use lifecycle-reactivestreams-ktx



    // optional - Test helpers for LiveData
    testImplementation "androidx.arch.core:core-testing:$lifecycle_version"
}

</code>




