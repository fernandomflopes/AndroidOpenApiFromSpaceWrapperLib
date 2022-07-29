# AndroidOpenApiFromSpaceWrapperLib

Este projeto facilita o acesso da [Open Space API](http://open-notify.org/). É fornecido informações reais de localização da Estação Espacial Internacional ISS

![image](https://github.com/fernandomflopes/AndroidOpenApiFromSpaceWrapperLib/blob/master/media/ex01.png)

* [link do modulo](https://github.com/fernandomflopes/AndroidOpenApiFromSpaceWrapperLib/tree/master/ISSAPIWrapper)

* Insira sua chave do google maps para poder visualizar o exemplo

# Utilização

* AndroidManifest.xml
```XML
    <uses-permission android:name="android.permission.INTERNET"/>

    <application
        ....
        android:usesCleartextTraffic="true"
        
        ETC ...

```
* build.gradle (Project)

```gradle

allprojects {
	repositories {
		...
		maven { url 'https://jitpack.io' }
	}
}
```
* build.gradle (Module)
```gradle
dependencies {
    implementation 'com.github.fernandomflopes:AndroidOpenApiFromSpaceWrapperLib:1.0.0'
}

```

# Exemplo de utilização


```kotlin

    lifecycleScope.launch {
            ISS().getNow(3000).collect {

                binding.txtLongitude.text = it.position.longitude.toString()
                binding.txtLatitude.text = it.position.latitude.toString()
            
            }
   }

```
