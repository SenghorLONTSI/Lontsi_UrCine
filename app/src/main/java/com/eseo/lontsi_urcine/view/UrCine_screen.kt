package com.eseo.lontsi_urcine.view

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.eseo.lontsi_urcine.viewmodel.UrCineViewModel
import com.eseo.lontsi_urcine.ui.theme.PurpleGrey80

@Preview
@Composable
fun UrCineScreen(
    modifier: Modifier = Modifier,
    urCineViewModel: UrCineViewModel = hiltViewModel()
) {

    val urcines = urCineViewModel.urcines.collectAsState()

    Scaffold(
        modifier = modifier.fillMaxSize(),
        containerColor = PurpleGrey80,
        topBar = {
            MyTopAppBar()
        }
    ) { innerPadding ->
        if (urcines.value.isEmpty()){
            UrCineRow()
        }else{
            LazyVerticalGrid(
                modifier = Modifier.fillMaxSize().padding(innerPadding),
                columns = GridCells.Fixed(2),
                contentPadding = PaddingValues(10.dp),
                verticalArrangement = Arrangement.spacedBy(10.dp),
                horizontalArrangement = Arrangement.spacedBy(10.dp)
            ) {
                items(urcines.value){ urcine ->
                    UrCineCard(urcine)
                }
            }
        }
    }
}