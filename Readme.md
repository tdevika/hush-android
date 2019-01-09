Roadmap
 - Add homescreen which record expense and store it in firebase/google sheet
 - Add google plus login
 - Create Account specific Record (Switch sheet based on account)
 - Sync data https://dmytrodanylyk.com/articles/data-sync-part1/
 - Add Screen to list the xpns
 - Prepare app launch
 - Create widget to  record xpns

08/01/2019
 - Implement App Color Theming as per Material guideline https://material.io/develop/android/theming/color/
 - Update Submit button UI
 - Referred TiVi,Pelvelea apps
 
 09/01/2019
  - Implement Typography Theming (Adding downloadable font feature)
  - Implement native fonts
  - Implement Day Night mode
  - Show Progress and handle error and complete state of the app
  - Look into chip inflation issue
  
  10/01/2019
  
 - Add new navigation implementation 
 - Immersive mode
 - ThemeOverlay
 
 
 
 
 Theming
 
 ## Color Theming : https://material.io/develop/android/theming/color/
 Concept is to use themes to control app styling instead if putting parameters to each view. Following procedure is used to achieve this
 
 - App uses baseline Material color theme format mentioned here : https://material.io/design/color/the-color-system.html#color-theme-creation 
 - Use the diagram mentioned in above link and generate baseline Material color from here : https://material.io/tools/color/#!/?view.left=0&view.right=1&primary.color=009688&secondary.color=fcfc13
 
 ## Shape Theming : https://material.io/develop/android/theming/shape/
 
 ## Typography Theming : https://material.io/develop/android/theming/typography/
 
 - If you want to use a Downloadable Font before Android O, make sure you are using AppCompatTextView or that you are loading the font yourself with ResourcesCompat.getFont().
 - Sample app to implement downloadable fonts : https://github.com/googlesamples/android-DownloadableFonts
 - https://developer.android.com/guide/topics/ui/look-and-feel/downloadable-fonts
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
                                                                                                                           
                
                
 
 ###Resource
 - https://material.io/
 
