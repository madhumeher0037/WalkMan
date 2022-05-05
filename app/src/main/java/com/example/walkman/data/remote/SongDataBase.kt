package com.example.walkman.data.remote

import com.example.walkman.data.entities.Song
import com.example.walkman.data.others.Constants.SONG_COLLECTION
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.coroutines.tasks.await
import java.lang.Exception

class SongDataBase {
    private val firestore = FirebaseFirestore.getInstance();
    private val songCollections = firestore.collection(SONG_COLLECTION)
//    we are getting the song data from the firebase asynchronously using suspend function
//    suspend function are co-routines
    suspend fun getAllSongs():List<Song>{
        return try{
//            explicity mentioning which type of object is return by the songCollections
            songCollections.get().await().toObjects(Song::class.java)
        }
        catch (e:Exception){
            emptyList()
        }
    }
}