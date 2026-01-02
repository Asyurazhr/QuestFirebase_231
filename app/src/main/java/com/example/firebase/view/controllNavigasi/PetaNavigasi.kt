package com.example.firebase.view.controllNavigasi

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.firebase.view.EntrySiswaScreen
import com.example.firebase.view.HomeScreen
import com.example.firebase.view.route.DestinasiDetail
import com.example.firebase.view.route.DestinasiEntry
import com.example.firebase.view.route.DestinasiHome

@Composable
fun DataSiswaApp(navController: NavHostController = rememberNavController(), modifier:
Modifier = Modifier){
    HostNavigasi(navController = navController)
}
@Composable
fun HostNavigasi(
    navController: NavHostController,
    modifier: Modifier = Modifier
){
