# Roadmap
 - [ ] Add google plus login
 - [ ]Create Account specific Record (Switch sheet based on account)
 - [ ] Sync data https://dmytrodanylyk.com/articles/data-sync-part1/
 - [ ]Add Screen to list the xpns
 - [ ]Publish to playstore
 - [ ]Create widget to record xpns
 - [ ]Implement Day Night(Dark) mode
 - [ ]Implement dynamic selection feature
 - [ ]Show Progress and handle error and complete state of the app
 - [ ]Look into chip inflation issue
 - [ ]Add new navigation implementation
 - [ ]Immersive mode
 - [ ]ThemeOverlay
 - [ ]Replace Dagger2 with Koin : https://proandroiddev.com/migrating-from-dagger2-to-koin-3b2b3f5285e9


08/01/2019
 - [Feature]
     - Implement App Color Theming as per Material guideline https://material.io/develop/android/theming/color/
 - [Learning]
    - Color Theming : https://material.io/develop/android/theming/color/
        - Concept is to use themes to control app styling instead if putting parameters to each view. Following procedure is used to achieve this
        - App uses baseline Material color theme format mentioned here : https://material.io/design/color/the-color-system.html#color-theme-creation
        - Use the diagram mentioned in above link and generate baseline Material color from here: https://material.io/tools/color/#!/?view.left=0&view.right=1&primary.color=009688&secondary.color=fcfc13
 - [Referred] : https://material.io/, https://github.com/chrisbanes/tivi , https://github.com/seanghay/pelvelea
 
09/01/2019
 - [Feature]
    - Implement Typography Theming (Adding downloadable font feature) (Extension : Dynamic font selection from app)
 - [Learning]
    - Typography Theming : https://material.io/develop/android/theming/typography/
      - If you want to use a Downloadable Font before Android O, make sure you are using AppCompatTextView or that you are loading the font yourself with ResourcesCompat.getFont().
      - Sample app to implement downloadable fonts : https://github.com/googlesamples/android-DownloadableFonts, https://developer.android.com/guide/topics/ui/look-and-feel/downloadable-fonts
      - LL: Theme Attribute Mapping (Including Downloadable Fonts ) is applied to only below items, for TextView and EditTexts wee need to set attr explicitly as shown below
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

      - Understand which textAppearance will suit best from this guide : https://material.io/design/typography/the-type-system.html#applying-the-type-scale
      - Added bottom bar and learned that need to set vectorDrawables.useSupportLibrary true inside app build.gradle under defaultConfig to use vector drawable in that app
 - [Referred] : https://github.com/material-components , https://github.com/chrisbanes/tivi , https://github.com/googlesamples/android-DownloadableFonts

10/01/2019
 - [Feature]
     - Implement Theme switcher and Font switcher functionality
 - [Learning]
     - **Tried setting custom fonts from manifest and gradle properties but failed (Need to find solution for this)**
     - Implemented color palette , source : https://github.com/material-components

11/01/2019
- [Feature]
     - Add Theme switcher and Font switcher icon to bottom bar
14/01/2019
 - [Feature]
      - Show Progress and handle error and complete state of the app
15/01/2019
 - [Feature]
      - Added release/debug unique server endpoints
      - Day Night mode implementation
      - Navigation
      - Xpns List
 - [Learning]
      - Changing statusbar color <item name="android:statusBarColor">@android:color/transparent</item>
      - Changing status bar icon color   <item name="android:windowLightStatusBar" tools:targetApi="m">true</item>
      - Added release/debug unique server endpoints

 - [Referred] : https://medium.com/androiddevelopers/appcompat-v23-2-daynight-d10f90c83e94, https://github.com/chrisbanes/tivi

 22/01/2019
  - [Feature]
       - Dagger2
  - [Learning]
       - https://medium.com/@iammert/new-android-injector-with-dagger-2-part-1-8baa60152abe
       - https://medium.com/google-cloud/playing-with-kotlin-you-know-everything-john-doe-8275a6e98a96

  - [Referred] : https://medium.com/androiddevelopers/appcompat-v23-2-daynight-d10f90c83e94, https://github.com/chrisbanes/tivi




Release checklist
  - https://www.raywenderlich.com/9043-android-app-bundles-getting-started

 

