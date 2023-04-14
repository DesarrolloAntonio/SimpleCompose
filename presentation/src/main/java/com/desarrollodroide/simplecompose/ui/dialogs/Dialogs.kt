package com.desarrollodroide.simplecompose.ui.dialogs

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties

@Composable
fun InfiniteProgressDialog(
    properties: DialogProperties = DialogProperties(),
    onDismissRequest: () -> Unit
) {
    Dialog(
        onDismissRequest = onDismissRequest,
        properties = properties
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Surface(
                modifier = Modifier.clip(CircleShape),
                color = Color.White
            ) {
                Column(
                    modifier = Modifier
                        .padding(20.dp)
                ) {
                    CircularProgressIndicator(
                        color = Color.Black,
                        strokeWidth = 6.dp,
                        modifier = Modifier
                            .height(70.dp)
                            .width(70.dp)
                    )
                }
            }
        }
    }
}