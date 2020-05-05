# Tracket

### Daily Update

- 29/04/2020 - 05/05/2020

    - **Implement Typography Theming (Adding downloadable font feature) (Extension : Dynamic font selection from app)**
      - If you want to use a Downloadable Font before Android O, make sure you are using AppCompatTextView or that you are loading the font yourself with ResourcesCompat.getFont().
      - Theme Attribute Mapping (Including Downloadable Fonts ) is applied to only below items, for TextView and EditTexts wee need to set attr explicitly as shown below
           BottomNavigationView
           Chip
           FloatingActionButton
           MaterialButton
           MaterialCardView
           TabLayout

                <androidx.appcompat.widget.AppCompatTextView
                         android:layout_width="wrap_content"
                         android:layout_height="wrap_content"
                         android:textAppearance="?attr/textAppearanceSubtitle1" />

                <com.google.android.material.textfield.TextInputEditText
                          android:layout_width="match_parent"
                          android:layout_height="wrap_content"
                          android:textAppearance="?attr/textAppearanceBody1" />                  

       - Referred
         - [Typography Theming](https://material.io/develop/android/theming/typography/)
         - [Understand which textAppearance will suit best from this guide](https://material.io/design/typography/the-type-system.html#applying-the-type-scale)
         - [Downloadable Fonts](https://developer.android.com/guide/topics/ui/look-and-feel/downloadable-fonts)
         - [Developing Themes with Style (Android Dev Summit '19](https://www.youtube.com/watch?v=Owkf8DhAOSo)
         - [Sample](https://github.com/googlesamples/android-DownloadableFonts)



 
 - [Feature]
    - App Color pallet 
 - [Learning]
 - [Referred]
 
  - [Feature]
     - Adaptive icons
  - [Learning]
  - [Referred]
  
 - [Feature]
    - Adaptive icons
 - [Learning]
 - [Referred]

 - [Feature]
     - Implement Theme switcher functionality
 - [Learning]
     - **Tried setting custom fonts from manifest and gradle properties but failed (Need to find solution for this)**
     - Implemented color palette , source : https://github.com/material-components
     
28/04/2020
 - [Feature]
     - Integrate CI Bitrise : https://www.youtube.com/watch?v=jVMubvLDyHU
     
26/04/2020
 - [Code cleanup]
    - Integrate ktlint : https://www.youtube.com/watch?v=YmZIkUGnCco
    - Refactor > Remove unused resource 
    - Analyze -> Run inspection by name > Kotlin | Redundant constructs | Unused symbol
    - Add pre-commit hook for ktlint : https://www.youtube.com/watch?v=eysVDO2_X0s
    
22/01/2019
  - [Feature]
       - Dagger2
  - [Learning]
       - https://medium.com/@iammert/new-android-injector-with-dagger-2-part-1-8baa60152abe
       - https://medium.com/google-cloud/playing-with-kotlin-you-know-everything-john-doe-8275a6e98a96

  - [Referred] : https://medium.com/androiddevelopers/appcompat-v23-2-daynight-d10f90c83e94, https://github.com/chrisbanes/tivi

15/01/2019
 - [Feature]
      - Added release/debug unique server endpoints
      - Day Night mode implementation
      - Navigation
 - [Learning]
      - Changing statusbar color <item name="android:statusBarColor">@android:color/transparent</item>
      - Changing status bar icon color   <item name="android:windowLightStatusBar" tools:targetApi="m">true</item>
      - Added release/debug unique server endpoints
 - [Referred] : https://medium.com/androiddevelopers/appcompat-v23-2-daynight-d10f90c83e94, https://github.com/chrisbanes/tivi

14/01/2019
 - [Feature]
      - Show Progress and handle error and complete state of the app


08/01/2019
 - [Feature]
    - Implement App Color Theming as per Material guideline https://material.io/develop/android/theming/color/
 - [Learning]
    - Color Theming : https://material.io/develop/android/theming/color/
        - Concept is to use themes to control app styling instead if putting parameters to each view. Following procedure is used to achieve this
        - App uses baseline Material color theme format mentioned here : https://material.io/design/color/the-color-system.html#color-theme-creation
        - Use the diagram mentioned in above link and generate baseline Material color from here: https://material.io/tools/color/#!/?view.left=0&view.right=1&primary.color=009688&secondary.color=fcfc13
 - [Referred] : https://material.io/, https://github.com/chrisbanes/tivi , https://github.com/seanghay/pelvelea
 
 -----------------------------------------------------------------------------------------------------------
 ### Product Backlog
  - [ ]Core
     - [ ]Portfolio
     - [ ]Watchlist
     - [ ]All Stocks
     - [ ]Stock Details
     - [ ]Filter Stocks (iosched filter bottom sheet)
     - [ ]Stock search (iosched search)
  - [ ]Add google plus login
  - [ ]Show Progress and handle error and complete state for the app
 
 ### Tech Backlog
  - Architecture 
     - Usecases
  - Style
      - [ ]Add new navigation implementation
      - [ ]Implement Day Night(Dark) mode
      - [ ]Immersive mode
      - [ ]ThemeOverlay
      - [ ]Adaptive app icon
      - [ ]App font
      - [ ]App color pallet 
      - [ ]Add animated vector drawable for tab icons
  - [ ]Integrate ktlint
  - [ ]Explore Android Studio lint
  - [ ]Release : https://www.raywenderlich.com/9043-android-app-bundles-getting-started
  - [ ]Integrate CI Bitrise
  - [ ]Analytics
  - [ ]Viewpager pager 2
 
### Tech TODO
 - Fix ./gradlew build issue 

### Explain 
 - FragmentModule : IntoMap

### Questions
 - How to merge watchlist/portfolio/bhav api call
 - How to update db
    
### Learning 
- Style 
    - Typography
    - Theme
    - Material Components for Android [https://medium.com/androiddevelopers/migrating-to-material-components-for-android-ec6757795351]
- Create parallel network requests
        launch {
            try {
                val getObject1Task = apiService.getObject1()
                val getObject2Task = apiService.getObject2()

                successHandler(getObject1Task.await().body(), getObject2Task.await().body())
            } catch (exception: Exception) {
                Log.e("TAG", exception.message)
            }
        }
- https://www.rockandnull.com/jetpack-viewmodel-initialization/
    val user: LiveData<Result> = liveData {
      emit(Result.loading())
      try {
          emit(Result.success(SomeDataRepository.fetchData()))
      } catch(ioException: Exception) {
          emit(Result.error(ioException))
      }
  }
  
- https://www.youtube.com/watch?v=Qxj2eBmXLHg
    - Databinding vs ViewBinding vs Kotlin synthetic
    - View model vs saved state 
    
    //How to do this with coroutine 
     AsyncDifferConfig.Builder<Portfolio>(PortfolioDiff)
            .setBackgroundThreadExecutor(Executors.newSingleThreadExecutor())
            .build()
    
