package com.example.altimetrikpoc.viewModel

import android.app.Application
import android.graphics.Movie
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.altimetrikpoc.model.ModelResult
import com.example.altimetrikpoc.repository.RepositoryAPI
import kotlinx.coroutines.async
import java.util.*
import kotlin.collections.ArrayList

class ViewModelAlbumSearch(application: Application) : AndroidViewModel(application) {
    var liveDataModelData = MutableLiveData<ArrayList<ModelResult>>()
    var repositoryAPI = RepositoryAPI()

    init {
        viewModelScope.async {
            var response = repositoryAPI.getAllData()
            if (response?.isSuccessful!!) {
                var results: ArrayList<ModelResult> = ArrayList<ModelResult>(response.body()?.results!!)
                System.out.println("\t\tBefor sort\n\n")
                for (data in results) {
                    System.out.println(data.releaseDate)
                }

                /*Collections.sort(
                    results
                ) { _, _ ->
                    fun compare(m1: ModelResult, m2: ModelResult): Int {
                        return m1.releaseDate.compareTo(m2.releaseDate)
                    }

                    TODO("Not yet implemented")
                }*/

                results.sortedBy { it.releaseDate }
                System.out.println("\t\tAfter sort\n\n")
                for (data in results) {
                    System.out.println(data.releaseDate)
                }

                liveDataModelData.postValue(results)
            }

        }
    }
}