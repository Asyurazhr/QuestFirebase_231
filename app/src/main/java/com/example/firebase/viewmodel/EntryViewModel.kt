package com.example.firebase.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.firebase.modeldata.DetailSiswa
import com.example.firebase.modeldata.UIStateSiswa
import com.example.firebase.modeldata.toDataSiswa
import com.example.firebase.repositori.RepositorySiswa
import java.io.IOException

class EntryViewModel (private val repositorySiswa: RepositorySiswa): ViewModel(){
    var uiStateSiswa by mutableStateOf(UIStateSiswa())
        private set
    
    var errorMessage by mutableStateOf<String?>(null)
        private set
    
    private fun validasiInput(uiState: DetailSiswa = uiStateSiswa.detailSiswa): Boolean{
        return with(uiState){
            nama.isNotBlank() && alamat.isNotBlank() && telpon.isNotBlank()

        }
    }
    fun updateUiState(detailSiswa: DetailSiswa){
        uiStateSiswa = UIStateSiswa(detailSiswa = detailSiswa, isEntryValid = validasiInput(detailSiswa))
        errorMessage = null // Clear error when user types
    }

    suspend fun addSiswa(): Boolean {
        return if (validasiInput()) {
            try {
                repositorySiswa.postDataSiswa(uiStateSiswa.detailSiswa.toDataSiswa())
                errorMessage = null
                true // Success
            } catch (e: IOException) {
                errorMessage = "Gagal menyimpan data: Tidak ada koneksi internet"
                false // Failed
            } catch (e: Exception) {
                errorMessage = "Gagal menyimpan data: ${e.message ?: "Terjadi kesalahan"}"
                false // Failed
            }
        } else {
            errorMessage = "Mohon lengkapi semua field"
            false
        }
    }
}