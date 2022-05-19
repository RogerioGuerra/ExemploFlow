package com.rgprogrammer.exemploflow


import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow


class MViewModel : ViewModel() {
    private val musicStyles = arrayListOf(
        "Led Zeppelin", "Pink Floyd", "The Beatles", "Jimmy Hendrix", "The Rolling Stones", "Joe Satriani",
        "Chuck Berry", "Queen", "Black Sabbath", "AC/DC", "Eric Clapton", "Metalica", "Rush", "Creedence",
        "Nirvana", "Deep Purple", "Dire Straits", "The Doors", "Alice in Chains"
    )

   val musicstyls: LiveData<String> = getMusicStyles().asLiveData()

    fun getMusicStyles(): Flow<String> {

        return flow {
            /*   for (estilo in musicStyles){
              emit(estilo)
              delay(1000L)
          }*/

            musicStyles.forEachIndexed { index, s ->
                emit("${index + 1}. $s")
                delay(500L)

            }

        }

    }
}