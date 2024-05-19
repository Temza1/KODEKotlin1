package presentation.ui


import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import domain.model.WorkerState





@Composable
fun card(workerState : WorkerState) {

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(12.dp)
    ) {
        val departament = workerState.department
        val firstName = workerState.firstName
        val lastName = workerState.lastName
        val userTag = workerState.userTag
        val avatarUrl = workerState.avatarUrl

        


        Row(
            modifier = Modifier.fillMaxWidth()
        ) {

            Box(
                modifier = Modifier.fillMaxHeight(),
                contentAlignment = Alignment.CenterStart
            ) {
                image(avatarUrl = avatarUrl)
        }
            Box {
                Column {
                    Row {
                        Text(
                            text = firstName,
                            modifier = Modifier.size(12.dp)
                        )
                        Text(text = lastName)
                        Text(text = userTag)
                    }
                    Box(modifier = Modifier.fillMaxWidth())
                }
            }


        }
        Text(text = departament)
    }

}