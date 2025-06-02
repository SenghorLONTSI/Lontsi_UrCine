package com.eseo.lontsi_urcine.view

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.eseo.lontsi_urcine.model.data.UrCine
import com.eseo.lontsi_urcine.ui.theme.Pink40

@Composable
fun UrCineCard(urCine: UrCine) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(200.dp),
        colors = CardDefaults.cardColors(containerColor = Pink40)
    ) {
        Column(modifier = Modifier.fillMaxSize()) {
            AsyncImage(
                model = urCine.imageThumbnailPath,
                contentDescription = null,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(150.dp)
                    .background(Color.Black)
            )

            urCine.country?.let {
                Text(
                    text = it,
                    color = Color.Black,
                    modifier = Modifier.padding(
                        vertical = 10.dp,
                        horizontal = 10.dp
                    )
                )
            }
        }
    }
}