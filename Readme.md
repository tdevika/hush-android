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

          ```xml
                <androidx.appcompat.widget.AppCompatTextView
                        android:layout_width="wrap_content"
                        android:layout_height="wrap_content"
                        android:textAppearance="?attr/textAppearanceSubtitle1" />          
          ```
          ```xml
            <com.google.android.material.textfield.TextInputEditText
                    android:layout_width="match_parent"
                    android:layout_height="wrap_content"
                    android:textAppearance="?attr/textAppearanceBody1" />     
          ```
     - Referred
       - [Typography Theming](https://material.io/develop/android/theming/typography/)
       - [Understand which textAppearance will suit best from this guide](https://material.io/design/typography/the-type-system.html#applying-the-type-scale)
       - [Downloadable Fonts](https://developer.android.com/guide/topics/ui/look-and-feel/downloadable-fonts)
       - [Developing Themes with Style (Android Dev Summit '19](https://www.youtube.com/watch?v=Owkf8DhAOSo)
       - [Sample](https://github.com/googlesamples/android-DownloadableFonts)
   - **Color palettes**
      - [Choosing palettes types](https://color.adobe.com/create)
        - Monochromatic
        - Analogous
        - Complimentary
        - Trirad
      - Use [this](https://material.io/design/color/the-color-system.html#tools-for-picking-colors) tool to generate color palettes
      - Use [this](https://material.io/design/color/dark-theme.html#ui-application) guideline to map android color palettes
      - Output
        ```xml
            <!--    light-->
            <color name="md_dark_grey_50">#F7F7F7</color> <!-- colorBackground -->
            <color name="md_dark_grey_50">#F7F7F7</color> <!-- colorSurface -->
            <color name="md_dark_grey_500">#8A8A8A</color> <!-- colorPrimary (500/700)-->
            <color name="md_dark_grey_700">#505050</color> <!-- colorPrimaryVariant (colorPrimary+100/200)-->
            <color name="md_dark_grey_200">#E2E2E2</color> <!-- colorSecondary (colorPrimary - 200/300)/-->
            <color name="md_dark_grey_200">#E2E2E2</color> <!-- colorSecondaryVariant (colorPrimary - 200/300)/-->
            <color name="md_red_600">#B00020</color> <!-- colorError -->
            <color name="md_dark_grey_50">#121212</color> <!-- colorOnPrimary-->
            <color name="md_dark_grey_900">#121212</color><!-- colorOnSecondary-->
            <color name="md_dark_grey_900">#F7F7F7</color><!-- colorOnBackground-->
            <color name="md_dark_grey_900">#F7F7F7</color><!-- colorOnSurface-->
            <item name="md_dark_grey_50">#121212</item><!-- colorOnError-->
        ```
        ```xml
            <!--    dark-->
            <color name="md_dark_grey_900">#121212</color> <!-- colorBackground -->
            <color name="md_dark_grey_800">#272727</color> <!-- colorSurface | The color #272727 is the result of combining the dark theme surface color #121212 and the 8% Primary color.Use Android studio color alpha to get % -->
            <color name="md_dark_grey_200">#E2E2E2</color> <!-- colorPrimary (200)-->
            <color name="md_dark_grey_700">#505050</color> <!-- colorPrimaryVariant (colorPrimary+100/200/500)-->
            <color name="md_dark_grey_200">#E2E2E2</color> <!-- colorSecondary (colorPrimary + 0/100)-->
            <color name="md_dark_grey_200">#E2E2E2</color> <!--colorSecondaryVariant (colorPrimary + 0/100/200/300)-->
            <color name="md_red_200">#CF6679</color>   <!-- colorError created by taking the light theme error color (#B00020) and lightening it with a 40% white overlay-->
            <color name="md_dark_grey_900">#121212</color> <!-- colorOnPrimary-->
            <color name="md_dark_grey_900">#121212</color><!-- colorOnSecondary-->
            <color name="md_dark_grey_50">#F7F7F7</color><!-- colorOnBackground-->
            <color name="md_dark_grey_50">#F7F7F7</color><!-- colorOnSurface-->
            <item name="md_dark_grey_900">#121212</item><!-- colorOnError-->
        ```
      - Referred
        - [Developing Themes with Style (Android Dev Summit '19](https://www.youtube.com/watch?v=Owkf8DhAOSo)
        - [Building a real Android app with Material Tools - Nick Rout - DevFest South Africa](https://www.youtube.com/watch?v=hjATvyrA0CQ)
        - [UI Design | How to choose colors and color palettes](https://www.youtube.com/watch?v=wuZuvhF4u6U)
        - [Color codes](https://material.io/design/color/dark-theme.html#ui-application)
        - [Dribble](https://dribbble.com/shots/7111349/attachments/113890?mode=media)
        - [Color Tool](https://material.io/resources/color/#!/?view.left=0&view.right=1&secondary.color=4DD0E1&primary.color=6200ee)
        - [Palette Generator](https://material.io/design/color/the-color-system.html#tools-for-picking-colors)
        - [Custom color palette](https://codelabs.developers.google.com/codelabs/mdc-103-flutter/index.html?index=..%2F..index#3)
   - **Dark Theme**
      - Referred
        - [material.io](https://material.io/design/color/dark-theme.html)
        - [Codelab](https://codelabs.developers.google.com/codelabs/design-material-darktheme/index.html?index=..%2F..index#0)
        - [How to Design a Dark Theme Using Material (Google I/O'19)](https://www.youtube.com/watch?v=9NDLR3COU7Y)
   - **Themes with Style**
     - Implement Theme switcher functionality
     - Tried setting custom fonts from manifest and gradle properties but failed (Need to find solution for this)
     - Referred
       - [Refactoring Android Themes with Style](https://medium.com/monzo-bank/refactoring-android-themes-with-style-restructuring-themes-15230569e50)
   - **Adaptive icons**
     - Referred

- 28/04/2020
  - [Integrate CI Bitrise](https://www.youtube.com/watch?v=jVMubvLDyHU)
     
- 26/04/2020
   - Code cleanup
      - [Integrate ktlint](https://www.youtube.com/watch?v=YmZIkUGnCco)
      - Refactor > Remove unused resource
      - Analyze -> Run inspection by name > Kotlin | Redundant constructs | Unused symbol
      - [Add pre-commit hook for ktlint](https://www.youtube.com/watch?v=eysVDO2_X0s)

- - -

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
      - [ ]App color palettes
      - [ ]Add animated vector drawable for tab icons
  - [ ]Integrate ktlint
  - [ ]Explore Android Studio lint
  - [ ]Release : https://www.raywenderlich.com/9043-android-app-bundles-getting-started
  - [ ]Integrate CI Bitrise
  - [ ]Analytics
  - [ ]Viewpager pager 2

- - -

### Tech TODO
 - Fix ./gradlew build issue 

- - -

### Explain 
 - FragmentModule : IntoMap

- - -

### Questions
 - How to merge watchlist/portfolio/bhav api call
 - How to update db

- - -

### Learning 

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
    
