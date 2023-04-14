package com.desarrollodroide.simplecompose.ui.list

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.MutableState
import com.desarrollodroide.domain.model.DummyObject
import com.desarrollodroide.simplecompose.MainViewModel
import com.desarrollodroide.simplecompose.ui.dialogs.InfiniteProgressDialog

@Composable
fun HomeScreen(
    viewModel: MainViewModel
) {
    HomeContent(list = viewModel.list?: emptyList())
    ProgressDialog(
        showDialog = viewModel.isLoading
    )
}

@Composable
private fun HomeContent(
    list: List<DummyObject>
){
    LazyColumn {
        items(list) { item ->
            Item(title = item.title, subtitle = item.body)
        }
    }
}

@Composable
private fun Item(
    title: String,
    subtitle: String
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp)
            .clickable { },
        elevation = 10.dp
    ) {
        Column(
            modifier = Modifier.padding(15.dp)
        ) {
            Text(title)
            Text(subtitle)
        }
    }
}

@Composable
fun ProgressDialog(
    showDialog: MutableState<Boolean>
) {
    if (showDialog.value) {
        InfiniteProgressDialog(
            onDismissRequest = {})
    }
}

@Preview
@Composable
private fun PreviewItem() {
    Item(
        title = "Title",
        subtitle = "Subtitle"
    )
}

@Preview
@Composable
private fun PreviewHomeContent() {
    val items = listOf(
        DummyObject(1, 1, "Title1", "Subtitle1"),
        DummyObject(2, 2, "Title2", "Subtitle2")
    )
    HomeContent(
        list = items
    )
}