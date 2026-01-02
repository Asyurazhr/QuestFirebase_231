package com.example.firebase.repositori

import com.example.firebase.modeldata.Siswa
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.coroutines.tasks.await

interface RepositorySiswa {
    suspend fun getDataSiswa(): List<Siswa>
    suspend fun postDataSiswa(siswa: Siswa)
}
class FirebaseRepositorySiswa: RepositorySiswa{
    private val db = FirebaseFirestore.getInstance()
    private val collection = db.collection("siswa")
