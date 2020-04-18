# Hush

### TODO
- Loading/Error/Data state
- watch list feature
- sorting
- code formatting



----------------------------------------------
- Dagger android usage 
- Lint
- Remove SerializedName
- Usecases
- Viewpager pager 2
- Analytics
- Light / Dark / System theme 
- Follow io19 app and update the app architecture 
- Update search



-------------------------------------
Explain 
    - FragmentModule : IntoMap

Questions
    - How to merge watchlist/portfolio/bhav api call
    - How to update update db
    - How to populate list 
    - How to make 
    
Learning 
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
    
